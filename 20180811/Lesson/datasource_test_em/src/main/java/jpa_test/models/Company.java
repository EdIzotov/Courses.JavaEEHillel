package jpa_test.models;

import jpa_test.DBColumn;
import jpa_test.DBTable;

@DBTable(name = "company")
public class Company {
    @DBColumn(name = "id")
    private String id;
    @DBColumn(name = "address")
    private String address;

    public Company() {
    }

    public Company(String id, String address) {
        this.id = id;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
