package com.example.xmlprocessing.DTOs.CreateDTOs.User;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersCreateDTO implements Serializable {
    @XmlElement(name = "user")
    private List<UserCreateDTO> userCreateDTOs;

    public UsersCreateDTO() {
        this.userCreateDTOs = new ArrayList<>();
    }

    public List<UserCreateDTO> getUserCreateDTOs() {
        return userCreateDTOs;
    }

    public void setUserCreateDTOs(List<UserCreateDTO> userCreateDTOs) {
        this.userCreateDTOs = userCreateDTOs;
    }
}
