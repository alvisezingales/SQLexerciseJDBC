import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class UserDao {

    Map<String, User> mapActiveUsers = new HashMap<>();

    public User getUserData(String username) throws SQLException {

        User userSelected = null;

        try (Connection connection = DriverManager.getConnection(ConnectionUtilities.getUrl(), ConnectionUtilities.getUser(), ConnectionUtilities.getPassword())) {

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE username = '" + username + "'");


            while (resultSet.next()) {
                String usernameVariable = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Date registrationDate = resultSet.getDate("registration_date");
                Short active = resultSet.getShort("active");

                userSelected = new User(usernameVariable, email, password, registrationDate, active);

            }

            return userSelected;

        }
    }

        public void fetchActiveUsers() throws SQLException{
            Connection connection = DriverManager.getConnection(ConnectionUtilities.getUrl(), ConnectionUtilities.getUser(), ConnectionUtilities.getPassword());

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE active != 0");

            while (resultSet.next()) {
                String usernameVariable = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Date registrationDate = resultSet.getDate("registration_date");
                Short active = resultSet.getShort("active");

                User user1Selected = new User(usernameVariable, email, password, registrationDate, active);

                mapActiveUsers.put(resultSet.getString("username"), user1Selected);
            }
        }

    public Map<String, User> getMapActiveUsers() {
        return mapActiveUsers;
    }
}


