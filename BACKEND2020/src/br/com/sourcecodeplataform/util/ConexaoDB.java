package br.com.sourcecodeplataform.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    public static boolean isMock = false;
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String realDB = "sourcecodeplataform";
        return getConnectionByDB(isMock? "mock" + realDB: realDB);
    }
    
    // criei para poder adicionar e excluir tudo do banco de dados nos testes
    // sem me preocupar com ordem e afims
    private static Connection getConnectionByDB(String dbname) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/" + dbname;
            String usuario = "root";
            String senha = "admin";
            return DriverManager.getConnection(url,usuario,senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}