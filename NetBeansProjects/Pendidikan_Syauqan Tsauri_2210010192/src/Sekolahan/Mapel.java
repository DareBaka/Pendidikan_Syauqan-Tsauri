/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sekolahan;

/**
 *
 * @author tsugu
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapel {
    // Create
    public void addMapel(Mapel mapel) throws SQLException {
        String query = "INSERT INTO mapel (kode_mapel, nama_mapel, nilai_standar_minimum) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, mapel.getKodeMapel());
            statement.setString(2, mapel.getNamaMapel());
            statement.setString(3, mapel.getNilaiStandarMinimum());
            statement.executeUpdate();
        }
    }

    // Read
    public Mapel getMapel(String kodeMapel) throws SQLException {
        String query = "SELECT * FROM mapel WHERE kode_mapel = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, kodeMapel);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Mapel(
                        resultSet.getString("kode_mapel"),
                        resultSet.getString("nama_mapel"),
                        resultSet.getString("nilai_standar_minimum")
                );
            }
        }
        return null;
    }

    // Update
    public void updateMapel(Mapel mapel) throws SQLException {
        String query = "UPDATE mapel SET nama_mapel = ?, nilai_standar_minimum = ? WHERE kode_mapel = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, mapel.getNamaMapel());
            statement.setString(2, mapel.getNilaiStandarMinimum());
            statement.setString(3, mapel.getKodeMapel());
            statement.executeUpdate();
        }
    }

    // Delete
    public void deleteMapel(String kodeMapel) throws SQLException {
        String query = "DELETE FROM mapel WHERE kode_mapel = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, kodeMapel);
            statement.executeUpdate();
        }
    }
}
