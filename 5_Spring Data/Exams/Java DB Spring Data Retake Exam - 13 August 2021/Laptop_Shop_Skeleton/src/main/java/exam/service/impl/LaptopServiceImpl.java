package exam.service.impl;

import com.google.gson.Gson;
import exam.model.Laptop;
import exam.model.Shop;
import exam.model.dtos.LaptopCreateDTO;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.LaptopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static exam.constants.Messages.*;
import static exam.constants.Paths.LAPTOPS_PATH;

@Service
public class LaptopServiceImpl implements LaptopService {
    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validator;

    @Autowired
    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository,
                             ModelMapper mapper, Gson gson, ValidationUtil validator) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder out = new StringBuilder();

        LaptopCreateDTO[] laptopDTOs = this.gson.fromJson(readLaptopsFileContent(), LaptopCreateDTO[].class);

        for (LaptopCreateDTO laptopDTO : laptopDTOs) {
            boolean isValid = this.validator.isValid(laptopDTO);

            Optional<Shop> shop = this.shopRepository.findByName(laptopDTO.getShop().getName());

            if (this.laptopRepository.existsByMacAddress(laptopDTO.getMacAddress()) ||
            shop.isEmpty()) {
                isValid = false;
            }

            if (isValid) {
                out.append(String.format(LAPTOP_IMPORTED, laptopDTO.getMacAddress(), laptopDTO.getCpuSpeed(),
                        laptopDTO.getRam(), laptopDTO.getStorage()));

                Laptop laptop = this.mapper.map(laptopDTO, Laptop.class);
                laptop.setShop(shop.get());

                this.laptopRepository.saveAndFlush(laptop);

            } else {
                out.append(String.format(INVALID_LAPTOP));
            }
        }

        return out.toString().trim();
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder out = new StringBuilder();

        List<Laptop> laptopList = this.laptopRepository
                .findAllByIdGreaterThanOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc((long) 0);

        for (Laptop laptop : laptopList) {
            out.append(String.format(EXPORT_LAPTOP,
                    laptop.getMacAddress(),
                    laptop.getCpuSpeed(),
                    laptop.getRam(),
                    laptop.getStorage(),
                    laptop.getPrice(),
                    laptop.getShop().getName(),
                    laptop.getShop().getTown().getName()));
        }

        return out.toString().trim();
    }
}
