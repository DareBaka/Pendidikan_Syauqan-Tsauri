/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sekolahan;

/**
 *
 * @author tsugu
 */
import java.sql.SQLException;

public class GuruMapel {
    public static void main(String[] args) {
        GuruDAO guruDAO = new GuruDAO();
        MapelDAO mapelDAO = new MapelDAO();

        // Contoh menambahkan data ke tabel guru dan mapel
        try {
            Guru guru = new Guru("G001", "Ahmad", "Jl. Merdeka No. 10", "08123456789", "S1");
            guruDAO.addGuru(guru);

            Mapel mapel = new Mapel("M001", "Matematika", "75");
            mapelDAO.addMapel(mapel);

            // Contoh mengambil data dari tabel guru dan mapel
            Guru retrievedGuru = guruDAO.getGuru("G001");
            Mapel retrievedMapel = mapelDAO.getMapel("M001");

            // Menampilkan informasi gabungan
            GuruMapel guruMapel = new GuruMapel(
                    retrievedGuru.getKodeGuru(),
                    retrievedGuru.getNamaGuru(),
                    retrievedGuru.getAlamat(),
                    retrievedGuru.getNoTelepon(),
                    retrievedGuru.getPendidikanAkhir(),
                    retrievedMapel.getKodeMapel(),
                    retrievedMapel.getNamaMapel(),
                    retrievedMapel.getNilaiStandarMinimum()
            );

            System.out.println("Kode Guru: " + guruMapel.getKodeGuru());
            System.out.println("Nama Guru: " + guruMapel.getNamaGuru());
            System.out.println("Alamat: " + guruMapel.getAlamat());
            System.out.println("No Telepon: " + guruMapel.getNoTelepon());
            System.out.println("Pendidikan Akhir: " + guruMapel.getPendidikanAkhir());
            System.out.println("Kode Mapel: " + guruMapel.getKodeMapel());
            System.out.println("Nama Mapel: " + guruMapel.getNamaMapel());
            System.out.println("Nilai Standar Minimum: " + guruMapel.getNilaiStandarMinimum());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
