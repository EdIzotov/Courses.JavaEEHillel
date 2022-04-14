package tools.mawashi;

import tools.mawashi.model.Account;
import tools.mawashi.model.Role;
import tools.mawashi.model.TariffPlan;
import tools.mawashi.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        List<User> userList = new ArrayList<>();
        Class.forName("org.h2.Driver");
        try (
                Connection connection = DriverManager.getConnection("jdbc:h2:file:.\\src\\main\\database\\test_db", "sa", "sa");
                PreparedStatement preparedStatement = connection.prepareStatement("select USER_ID, USER_NAME, ACCOUNT_NAME, TARIFF_PLAN_NAME, ROLE_NAME, USER_FIRSTNAME, USER_LASTNAME from TOOLS.MT_USERS_VIEW");
                ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                String accountName = resultSet.getString(3);
                String tariffPlanName = resultSet.getString(4);
                String roleName = resultSet.getString(5);
                String userFirstname = resultSet.getString(6);
                String userLastname = resultSet.getString(7);
                String format = String.format("userId=%d, userName=%s, accountName=%s, tariffPlanName=%s, roleName=%s, userFirstname=%s, userLastname=%s",
                        userId, userName, accountName, tariffPlanName, roleName, userFirstname, userLastname);
                try (
                        CallableStatement selectTariffPlan = connection.prepareCall("select tariff_plan_id, tariff_plan_name, tariff_plan_description from TOOLS.MT_TARIFF_PLANS where TARIFF_PLAN_NAME = '" + tariffPlanName + "' limit 1");
                        ) {
                    ResultSet tariffPlanResultSet = selectTariffPlan.executeQuery();
                    if (tariffPlanResultSet.next()) {
                        TariffPlan tariffPlan = new TariffPlan(tariffPlanResultSet.getInt(1), tariffPlanResultSet.getString(2), tariffPlanResultSet.getString(3));
                        try (
                                CallableStatement selectAccount = connection.prepareCall("select account_id, account_name from TOOLS.MT_ACCOUNTS where ACCOUNT_NAME = '" + accountName + "' limit 1");
                                ) {
                            ResultSet accountResultSet = selectAccount.executeQuery();
                            if (accountResultSet.next()) {
                                Account account = new Account(accountResultSet.getInt(1), accountResultSet.getString(2), tariffPlan);
                                try (
                                        CallableStatement selectRole = connection.prepareCall("select role_id, role_name from TOOLS.MT_ROLES where ROLE_NAME = '" + roleName + "' limit 1");
                                        ) {
                                    ResultSet roleResultSet = selectRole.executeQuery();
                                    if (roleResultSet.next()) {
                                        Role role = new Role(roleResultSet.getInt(1), roleResultSet.getString(2));
                                        User user = new User(userId, userName, account, role, userFirstname, userLastname);
                                        userList.add(user);
                                        System.out.println(format);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (User user: userList) {
            System.out.println(user);
        }
    }
}
