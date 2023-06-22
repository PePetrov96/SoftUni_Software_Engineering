package exam.service.impl;

import com.google.gson.Gson;
import exam.model.Customer;
import exam.model.Town;
import exam.model.dtos.CustomerCreateDTO;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static exam.constants.Messages.CUSTOMER_IMPORTED;
import static exam.constants.Messages.INVALID_CUSTOMER;
import static exam.constants.Paths.CUSTOMERS_PATH;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validator;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, TownRepository townRepository,
                               ModelMapper mapper, Gson gson, ValidationUtil validator) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMERS_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        StringBuilder out = new StringBuilder();

        CustomerCreateDTO[] customerDTOs = this.gson.fromJson(readCustomersFileContent(), CustomerCreateDTO[].class);

        for (CustomerCreateDTO customerDTO : customerDTOs) {
            boolean isValid = this.validator.isValid(customerDTO);

            Optional<Town> town = this.townRepository.findTownByName(customerDTO.getTown().getName());

            if (this.customerRepository.existsByEmail(customerDTO.getEmail()) || town.isEmpty()) {
                isValid = false;
            }

            if (isValid) {
                out.append(String.format(CUSTOMER_IMPORTED, customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getEmail()));

                Customer customer = this.mapper.map(customerDTO, Customer.class);
                customer.setTown(town.get());

                this.customerRepository.saveAndFlush(customer);
            } else {
                out.append(String.format(INVALID_CUSTOMER));
            }
        }

        return out.toString().trim();
    }
}
