package jpa_test.models;

import jpa_test.DBColumn;
import jpa_test.DBTable;

@DBTable(name = "users")
public class User {
    @DBColumn(name = "id")
    private String id;
    @DBColumn(name = "name")
    private String login;

    public User() {}

    public User(String id, String login) {
        this.id = id;
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
