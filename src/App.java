import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "user";
        String password = "2281337";
        
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL successfully!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}