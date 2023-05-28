package com.example.simplemapping.services.Impl;

import com.example.simplemapping.entities.Address;
import com.example.simplemapping.entities.dtos.CreateAddressDTO;
import com.example.simplemapping.repositories.AddressRepository;
import com.example.simplemapping.services.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(CreateAddressDTO data) {
        ModelMapper mapper = new ModelMapper();

        Address address = mapper.map(data, Address.class);

        return this.addressRepository.save(address);
    }
}
