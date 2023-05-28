package com.example.simplemapping.services;

import com.example.simplemapping.entities.Address;
import com.example.simplemapping.entities.dtos.CreateAddressDTO;

public interface AddressService {
    Address create(CreateAddressDTO data);
}
