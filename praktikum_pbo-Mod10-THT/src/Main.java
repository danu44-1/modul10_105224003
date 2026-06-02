public class Main {
    public static void main(String[] args) throws Exception {
        SistemGudang gudang = new SistemGudang();

        gudang.tambahBarangBaru("B01", "Laptop ACER RedBull Edition", "Elektronik", 10);
        gudang.tambahBarangBaru("B02", "Kursi Gaming Ferrari Pharaoh Edition", "Furnitur", 5);
        gudang.tambahBarangBaru("B03", "Baju RGB Galaxy UltraHD", "T-Shirt", 5);

        gudang.tambahStok("B03", 5);

        gudang.kurangiStok("B01", 5);

        gudang.kurangiStok("B02", 50);

        gudang.cetakLaporan();
    }
}
