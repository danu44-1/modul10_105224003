import java.util.Objects;

public class Anggota {
    protected String idAnggota;
    protected String nama;
    protected String tipe;

    Anggota(String idAnggota, String nama, String tipe) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        if (tipe == "Mahasiswa" || tipe == "Dosen") {
            this.tipe = tipe;
        }
    }

    @Override     
    public boolean equals(Object o) {         
        if (this == o) return true;         
        if (o == null || getClass() != o.getClass()) return false;         
        Anggota anggota = (Anggota) o;         
        return Objects.equals(idAnggota, anggota.idAnggota);     
    } 
    
     @Override     
     public int hashCode() {         
        return Objects.hash(idAnggota);     
    } 
    
}
