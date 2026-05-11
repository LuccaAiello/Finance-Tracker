import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConnection {
    public static Connection getConnection(){
        try{
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("config.properties");
            props.load(fis);

            String url = props.getProperty("db.url");
            String usuario = props.getProperty("db.usuario");
            String senha = props.getProperty("db.senha");

            Connection connection = DriverManager.getConnection(url, usuario, senha);
            return connection;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}