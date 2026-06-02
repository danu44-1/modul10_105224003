import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SistemGudang {
    Map<String, Barang> database = new HashMap<>();
    Set<String> kategoriUnik = new HashSet<>();
    List<String> riwayat = new ArrayList<>();

    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {
        database.put(id, new Barang(id, nama, kategori, stok));

        kategoriUnik.add(kategori);
    }

    public void tambahStok(String id, int jumlah) {
        Barang barang = database.get(id);

        if (barang.getIdBarang() == id) {
            barang.setStok(barang.getStok() + jumlah);
            riwayat.add("Barang Masuk: " + id + " ditambah " + jumlah + " Unit");
        }
    }

    public void kurangiStok(String id, int jumlah) {
        Barang barang = database.get(id);

        if (barang.getIdBarang() == id) {
            if (barang.getStok() >= jumlah) {
                barang.setStok(barang.getStok() - jumlah);
                riwayat.add("Kurangi Stok: " + id + " dikurangi " + jumlah + ".");
            }
            else {
                System.out.println("Stok " + id + " tidak mencukupi, Sisa: " + barang.getStok() + "\n");
            }
        }
    }

    public void cetakLaporan() {
        for (String daftarKategori : kategoriUnik) {
            System.out.println("-" + daftarKategori);
        }

        System.out.println("\n");

        for (Barang barang : database.values()) {
            System.out.println(barang.getNamaBarang() + " Sisa Stok : " + barang.getStok());
        }

        for (int i = 0; i < riwayat.size(); i++) {
            System.out.println((i + 1) + ". " + riwayat.get(i));
        }

        System.out.println("-----");
    }
}
