import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(ConnectionUtilities.getUrl(), ConnectionUtilities.getUser(), ConnectionUtilities.getPassword())){

            UserDao userDao = new UserDao();

            User user1 = userDao.getUserData("pasquale");

            System.out.println(user1);

            userDao.fetchActiveUsers();

            System.out.println(userDao.getMapActiveUsers());

            //AcquistoConFatturaDAO acquistoConFatturaDAO = new AcquistoConFatturaDAO();
            //System.out.println(acquistoConFatturaDAO.getAcquistoByFornitore(1));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}