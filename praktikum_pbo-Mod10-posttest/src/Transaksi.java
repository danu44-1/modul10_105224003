public class Transaksi {
    String namaPemesan;
    String noKursi;
    Bioskop film;

    Transaksi(String namaPemesan, String noKursi, Bioskop film) {
        this.namaPemesan = namaPemesan;
        this.noKursi = noKursi;
        this.film = film;
    }

    public void cetak() {
        System.out.println("Nama Pemesan : " + this.namaPemesan);
        System.out.println("Nomor Kursi : " + this.noKursi);
        System.out.println("Judul Film : " + this.film.judul);
        System.out.println("Harga : " + this.film.harga + "\n");
    }
}
