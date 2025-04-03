import java.io.Console;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        String user = "username";
        String pass = "pass";
        Properties info = new Properties();
        info.setProperty("user",user);
        info.setProperty("password",pass);
        //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
        //Создаём соединение
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", info);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
}