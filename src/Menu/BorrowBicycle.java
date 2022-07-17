package Menu;
import Domain.Users.user;
import java.util.ArrayList;
import static DAO.Daousers.readusers;

public class BorrowBicycle {
    private static Registeruser reguser = new Registeruser();
    public static void start(){
        ArrayList<user> Userlist = new ArrayList<user>();
        Userlist = readusers();
    }
}
