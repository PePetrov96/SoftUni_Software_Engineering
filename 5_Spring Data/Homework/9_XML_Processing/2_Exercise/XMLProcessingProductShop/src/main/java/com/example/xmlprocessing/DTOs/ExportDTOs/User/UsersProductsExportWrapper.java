package com.example.xmlprocessing.DTOs.ExportDTOs.User;

import jakarta.xml.bind.annotation.*;

import java.util.List;
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersProductsExportWrapper {
    @XmlAttribute(name = "count")
    private long count;
    @XmlElement(name = "user")
    private List<UsersProductsExportDTO> users;

    public UsersProductsExportWrapper(List<UsersProductsExportDTO> users) {
        this.count = users.size();
        this.users = users;
    }

    public UsersProductsExportWrapper() {
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<UsersProductsExportDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UsersProductsExportDTO> users) {
        this.users = users;
    }
}
