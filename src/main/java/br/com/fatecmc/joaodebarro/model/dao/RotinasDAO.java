package br.com.fatecmc.joaodebarro.model.dao;

import br.com.fatecmc.joaodebarro.util.ConnectionFactory;
import java.sql.*;

public class RotinasDAO {
    private Connection conn;

    public boolean processarPedidos() {
        this.conn = ConnectionFactory.getConnection();
        String sql = "CALL processarPedidos()";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            if(stmt.executeUpdate() == 1) return true;
        } catch (SQLException ex) {
            System.out.println("Não foi possível executar a rotina no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
        return false;
    }
    
}
