package com.example.simplemapping.services;

import com.example.simplemapping.entities.Address;
import com.example.simplemapping.entities.dtos.AddressDTO;

public interface AddressService {
    Address create(AddressDTO data);
}
