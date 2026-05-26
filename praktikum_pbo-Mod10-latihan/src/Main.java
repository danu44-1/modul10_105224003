import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;
import java.util.Map;

public class Main {
     public static void main(String[] args) throws Exception {
        Map<String, Buku> daftarBuku = new HashMap<>(); // Soal 1

        daftarBuku.put("1001", new Buku("1001", "10 Dosa Besar Pemimpin"));
        daftarBuku.put("1002", new Buku("1002", "Kisah Raja Pisang"));

        

        // System.out.println("daftar buku" + daftarBuku);

        Set<Anggota> anggotaSet = new HashSet<>();

        anggotaSet.add(new Anggota("105", "Dimas", "Mahasiswa")); // Soal 2
        anggotaSet.add(new Anggota("105", "Putra", "Dosen"));
        anggotaSet.add(new Anggota("106", "Kijang", "Dosen"));

        anggotaSet.add(new Anggota("224", "Andi", "Mahasiswa"));

        LinkedList<String> daftar = new LinkedList<>(); // Soal 3

        for (Anggota daftarAnggota : anggotaSet) {
            if (daftarAnggota.tipe == "Dosen") {
                daftar.addFirst(daftarAnggota.idAnggota + "#" + daftarBuku.get("101").isbn);
            }
            else if (daftarAnggota.tipe == "Mahasiswa") {
                daftar.addLast(daftarAnggota.idAnggota + "#" + daftarBuku.get("101").isbn);
            }
        }

        Set<String> peminjaman = new HashSet<>(); // Soal 4 (Masih Gagal)

        while (!daftar.isEmpty()) {
            String pinjam = daftar.removeFirst(); // Ambil dari urutan paling depan
            String[] split = pinjam.split("#");
            
            String idAnggota = split[0];
            String isbn = split[1];

            boolean terdaftar = false;
            for (Anggota agt : anggotaSet) {
                if (agt.idAnggota.equals(split[0])) {
                    terdaftar = true;
                    break;
                }
            }

            boolean isIsbnValid = daftarBuku.containsKey(isbn);

            boolean isBukuTersedia = !peminjaman.contains(isbn);

            if (!terdaftar) {
                System.out.println("Gagal: Anggota dengan ID " + idAnggota + " tidak terdaftar.");
            } else if (!daftarBuku.containsKey(split[1])) {
                System.out.println("Gagal: Buku dengan ISBN " + isbn + " tidak ditemukan di katalog.");
            } else if (!peminjaman.containsKey(split[1])) {
                System.out.println("Gagal: Buku dengan ISBN " + isbn + " sedang dipinjam oleh orang lain.");
            } else {
                peminjaman.add(split[1]);
                System.out.println("Berhasil: Anggota " + idAnggota + " berhasil meminjam buku " + isbn);
            }
        }
        
        System.out.println("\nDaftar ISBN Buku yang sedang dipinjam saat ini: " + peminjaman);


    }
}
