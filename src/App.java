import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        Path p = Paths.get(System.getProperty("user.home"), ".pgpass");
        String s = null;
        try {
            s = Files.readString(p);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        String[] splitted = s.split(":");
        String user = splitted[3].trim();
        String pass = splitted[4].trim();
        //System.out.println(String.format("%s - %s", user, pass));
        Properties info = new Properties();
        info.setProperty("user",user);
        info.setProperty("password",pass);
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studs", info);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM character");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
}