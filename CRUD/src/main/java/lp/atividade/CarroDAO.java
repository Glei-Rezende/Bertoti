package lp.atividade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/Crud";
    private static final String USER = "root";  // Altere conforme sua configuração
    private static final String PASSWORD = "Glei140510@";  // Altere conforme sua configuração

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addCarro(Carro carro) throws SQLException {
        String sql = "INSERT INTO carro (fabricante, modelo, cor) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, carro.getFabricante());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getCor());
            stmt.executeUpdate();
        }
    }

    public List<Carro> getAllCarros() throws SQLException {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM carro";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Carro carro = new Carro();
                carro.setId(rs.getInt("id"));
                carro.setFabricante(rs.getString("fabricante"));
                carro.setModelo(rs.getString("modelo"));
                carro.setCor(rs.getString("cor"));
                carros.add(carro);
            }
        }
        return carros;
    }

    public void updateCarro(Carro carro) throws SQLException {
        String sql = "UPDATE carro SET fabricante = ?, modelo = ?, cor = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, carro.getFabricante());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getCor());
            stmt.setInt(4, carro.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteCarro(int id) throws SQLException {
        String sql = "DELETE FROM carro WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

