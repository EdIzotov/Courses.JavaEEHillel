package com;

public class Company {
    private long id;
    private String address;

    public Company(long id, String address) {
        this.id = id;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
