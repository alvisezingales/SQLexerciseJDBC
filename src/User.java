import java.time.LocalDateTime;
import java.util.Date;

public class User {

    private String username;
    private String email;
    private String password;
    private Date registrationDate;
    private short isActive;

    public User(String username, String email, String password, Date registrationDate, short isActive) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.isActive = isActive;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public short isActive() {
        return isActive;
    }

    public void setActive(short active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                ", isActive=" + isActive +
                '}';
    }
}
