package jpa_hibernate_test.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPANY", schema = "PUBLIC", catalog = "TEST_DB")
public class CompanyEntity {
    private int id;
    private String address;
    private List<UsersEntity> usersEntityList;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "companyEntity")
    public List<UsersEntity> getUsersEntityList() {
        return usersEntityList;
    }

    public void setUsersEntityList(List<UsersEntity> usersEntityList) {
        this.usersEntityList = usersEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyEntity that = (CompanyEntity) o;

        if (id != that.id) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
