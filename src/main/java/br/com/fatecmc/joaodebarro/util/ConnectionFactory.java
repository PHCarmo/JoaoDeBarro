package br.com.fatecmc.joaodebarro.util;

import java.sql.*;

public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/DB_JDB";
    private static final String CONFIG = "?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "1234";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL + CONFIG, USER, PASS);
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível acessar a classe de conexão.\nErro: " + ex.getMessage());
            return null;
        } catch (SQLException ex) {
            System.out.println("Não foi possível acessar o banco de dados.\nErro: " + ex.getMessage());
            return null;
        }
    }
    
    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Não foi possível fechar a conexão.\nErro: " + ex.getMessage());
            }
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Não foi possível fechar a statement.\nErro: " + ex.getMessage());
            }
        }
        closeConnection(conn);
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Não foi possível fechar o resultset.\nErro: " + ex.getMessage());
            }
        }
        closeConnection(conn, stmt);
    }
    
}
