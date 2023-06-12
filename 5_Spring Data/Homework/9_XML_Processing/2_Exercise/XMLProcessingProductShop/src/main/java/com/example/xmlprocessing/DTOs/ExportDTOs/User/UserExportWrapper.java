package com.example.xmlprocessing.DTOs.ExportDTOs.User;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserExportWrapper {
    @XmlElement(name = "user")
    private List<UserExportDTO> users;

    public UserExportWrapper(List<UserExportDTO> users) {
        this.users = users;
    }

    public UserExportWrapper() {
    }

    public List<UserExportDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserExportDTO> users) {
        this.users = users;
    }
}
