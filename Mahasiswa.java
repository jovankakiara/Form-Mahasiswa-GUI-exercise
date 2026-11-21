// Class biasa buat nyimpen data satu mahasiswa
public class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;

    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    // dipakai buat nampilin data di text area
    public String toString() {
        return nama + " | " + nim + " | " + jurusan;
    }
}
