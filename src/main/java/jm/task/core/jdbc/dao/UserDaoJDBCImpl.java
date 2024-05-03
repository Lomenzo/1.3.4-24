package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private Util util = new Util();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            Statement statement = util.getConnection().createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS users (Id INT PRIMARY KEY AUTO_INCREMENT, " +
                                                            "Name VARCHAR(20), " +
                                                            "LastName VARCHAR(20), " +
                                                            "Age INT);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try {
            Statement statement = util.getConnection().createStatement();
            statement.execute("DROP TABLE IF EXISTS users;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
            try (PreparedStatement preparedStatement = util.getConnection().prepareStatement("INSERT INTO users (Name, LastName, Age) VALUES (?,?,?)")) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, lastName);
                preparedStatement.setByte(3, age);
                preparedStatement.executeUpdate();
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement("DELETE FROM users WHERE ID=?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {
        try {
            Statement statement = util.getConnection().createStatement();
            statement.execute("TRUNCATE TABLE users;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
