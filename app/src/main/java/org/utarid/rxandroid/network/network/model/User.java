package org.utarid.rxandroid.network.network.model;

import com.google.gson.annotations.SerializedName;

//https://jsonplaceholder.typicode.com/users/
public class User {
    @SerializedName("website")
    private String website;
    @SerializedName("address")
    private Address address;
    @SerializedName("phone")
    private String phone;
    @SerializedName("name")
    private String name;
    @SerializedName("company")
    private Company company;
    @SerializedName("id")
    private String id;
    @SerializedName("email")
    private String email;
    @SerializedName("username")
    private String username;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ClassPojo [website = " + website + ", address = " + address + ", phone = " + phone + ", name = " + name + ", company = " + company + ", id = " + id + ", email = " + email + ", username = " + username + "]";
    }
}
