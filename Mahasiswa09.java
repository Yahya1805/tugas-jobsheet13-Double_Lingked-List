public class Mahasiswa09 {
    public String nim;
    public String nama;
    public String kelas;
    public String ipk;

    Mahasiswa09(String nim, String nama, String kelas, String ipk) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    void tampil() {
        System.out.println("NIM: " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("Kelas: " + kelas);
        System.out.println("IPK: " + ipk);
    }
}