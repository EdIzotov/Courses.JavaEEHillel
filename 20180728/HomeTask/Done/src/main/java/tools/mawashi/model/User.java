package tools.mawashi.model;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "tools")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "user_name", unique = true, nullable = false, length = 320)
    private String userName;

    @Column(name = "user_account")
    private Account userAccount;

    @Column(name = "user_role")
    private Role userRole;

    @Column(name = "user_firstname")
    private String firstName;

    @Column(name = "user_lastname")
    private String lastName;

    public User(int userId, String userName, Account userAccount, Role userRole, String firstName, String lastName) {
        this.userId = userId;
        this.userName = userName;
        this.userAccount = userAccount;
        this.userRole = userRole;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAccount=" + userAccount +
                ", userRole=" + userRole +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
