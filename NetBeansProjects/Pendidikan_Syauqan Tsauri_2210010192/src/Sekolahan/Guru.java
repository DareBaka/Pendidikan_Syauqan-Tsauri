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

public class Guru {
    // Create
    public void addGuru(Guru guru) throws SQLException {
        String query = "INSERT INTO guru (kode_guru, nama_guru, alamat, no_telepon, pendidikan_akhir) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, guru.getKodeGuru());
            statement.setString(2, guru.getNamaGuru());
            statement.setString(3, guru.getAlamat());
            statement.setString(4, guru.getNoTelepon());
            statement.setString(5, guru.getPendidikanAkhir());
            statement.executeUpdate();
        }
    }

    // Read
    public Guru getGuru(String kodeGuru) throws SQLException {
        String query = "SELECT * FROM guru WHERE kode_guru = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, kodeGuru);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Guru(
                        resultSet.getString("kode_guru"),
                        resultSet.getString("nama_guru"),
                        resultSet.getString("alamat"),
                        resultSet.getString("no_telepon"),
                        resultSet.getString("pendidikan_akhir")
                );
            }
        }
        return null;
    }

    // Update
    public void updateGuru(Guru guru) throws SQLException {
        String query = "UPDATE guru SET nama_guru = ?, alamat = ?, no_telepon = ?, pendidikan_akhir = ? WHERE kode_guru = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, guru.getNamaGuru());
            statement.setString(2, guru.getAlamat());
            statement.setString(3, guru.getNoTelepon());
            statement.setString(4, guru.getPendidikanAkhir());
            statement.setString(5, guru.getKodeGuru());
            statement.executeUpdate();
        }
    }

    // Delete
    public void deleteGuru(String kodeGuru) throws SQLException {
        String query = "DELETE FROM guru WHERE kode_guru = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, kodeGuru);
            statement.executeUpdate();
        }
    }
}
