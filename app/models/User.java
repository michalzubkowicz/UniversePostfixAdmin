package models;

import org.mindrot.jbcrypt.BCrypt;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends Model {

    public static Finder<String, User> find
            = new Finder<String, User>(String.class, User.class);

    @Id
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;

    public void setPassword(String enteredPassword) {
        this.password=BCrypt.hashpw(enteredPassword, BCrypt.gensalt());
    }

    private Boolean checkPassword(String enteredPassword) {
        return BCrypt.checkpw(enteredPassword, password);
    }

    public static Boolean authenticate(String email, String enteredPassword) {
        try {
            if(email.length()<1 || enteredPassword.length()<0) return false;
            User u = User.find.byId(email);
            return u.checkPassword(enteredPassword);
        } catch(NullPointerException e) {
            return false;
        }
    }

    public static void changeCurrentUserPassword(String pass) {
        //TODO
    }



}
