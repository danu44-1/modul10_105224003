import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
        public static void main(String[] args) throws Exception {
        Map<String, Bioskop> daftarFilm = new HashMap<>(); // map untuk simpan objek film dengan kunci kode film

        Bioskop film1 = new Bioskop("10 Dosa Besar Pemimpin", 50000);
        Bioskop film2 = new Bioskop("Pesta Ayam", 99000);
        Bioskop film3 = new Bioskop("Lonjakan Kurs Rupiah", 19000);

        daftarFilm.put("F01", film1);
        daftarFilm.put("F02", film2);
        daftarFilm.put("F03", film3);

        List<String> pesan = new ArrayList<>(); // list untuk simpan pemesanannya yang terurut
        
        pesan.add("Dimas#A1#F01");
        pesan.add("Putra#B4#F02");
        pesan.add("Igog#B1#F01");
        pesan.add("Dadang#A1#F01");
        
        Set<String> pesanKursi = new HashSet<>(); // set untuk periksa kursinya yang duplikat

        ArrayList<Transaksi> riwayat = new ArrayList<>(); // Arraylist untuk simpan riwayat yang dipesan

        for (String proses : pesan) {
            String[] pemesanan = proses.split("#");
            String namaP = pemesanan[0];
            String noKursi = pemesanan[1];
            String kodeFilm = pemesanan[2];

            if (daftarFilm.containsKey(kodeFilm) && !pesanKursi.add(noKursi)) { // jika kode film ada, namun kursi yang dipesan berdasarkan noKursi sudah ada yang memesan sebelumnya (false). jadi gagal pesan
                System.out.println("Gagal! Kursi sudah dipesan");
            }
            else {
                Transaksi bayar = new Transaksi(namaP, noKursi, daftarFilm.get(kodeFilm));
                riwayat.add(bayar);
                System.out.println("Pesanan Berhasil");
            }


        }

        for (Transaksi tr : riwayat) {
            tr.cetak();
        }
    }
}
