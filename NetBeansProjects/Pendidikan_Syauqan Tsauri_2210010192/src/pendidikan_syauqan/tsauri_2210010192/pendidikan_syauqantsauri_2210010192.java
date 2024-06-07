package pendidikan_syauqan.tsauri_2210010192;

import java.sql.Connection;
import java.sql.SQLException;

public class Pendidikan_Syauqan Tsauri_2210010192{
    public static void main(String[] args) {
        try {
            // Membuat koneksi ke database
            Connection connection = DatabaseConnection.getConnection();
            System.out.println("Koneksi berhasil!");

            // Membuat objek GuruMapel
            GuruMapel guruMapel = new GuruMapel("G001", "Ahmad", "Jl. Merdeka No. 10", "08123456789", "S1",
                                                "M001", "Matematika", "75");

            // Menampilkan informasi
            System.out.println("Kode Guru: " + guruMapel.getKodeGuru());
            System.out.println("Nama Guru: " + guruMapel.getNamaGuru());
            System.out.println("Alamat: " + guruMapel.getAlamat());
            System.out.println("No Telepon: " + guruMapel.getNoTelepon());
            System.out.println("Pendidikan Akhir: " + guruMapel.getPendidikanAkhir());
            System.out.println("Kode Mapel: " + guruMapel.getKodeMapel());
            System.out.println("Nama Mapel: " + guruMapel.getNamaMapel());
            System.out.println("Nilai Standar Minimum: " + guruMapel.getNilaiStandarMinimum());

            // Tutup koneksi
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
    }
}
