import java.util.Scanner;

public class DLLMain09 {
    static void menu() {
        System.out.println("\nMenu Double Linked List Mahasiswa:");
        System.out.println("1. Tambah Data Mahasiswa di Awal");
        System.out.println("2. Tambah Data Mahasiswa di Akhir");
        System.out.println("3. Tambah Data Mahasiswa Setelah NIM Tertentu");
        System.out.println("4. Hapus Data Mahasiswa di Awal");
        System.out.println("5. Hapus Data Mahasiswa di Akhir");
        System.out.println("6. Hapus Data Mahasiswa Setelah NIM Tertentu");
        System.out.println("7. Tampilkan Semua Data Mahasiswa");
        System.out.println("8. Cari Data Mahasiswa");
        System.out.println("0. Keluar");
        System.out.print("Pilihan Menu: ");
    }

    public static void main(String[] args) {
        DoubleLinkedList09 dll = new DoubleLinkedList09();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            menu();
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim1 = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama1 = scanner.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    String kelas1 = scanner.nextLine();
                    System.out.print("Masukkan IPK: ");
                    String ipk1 = scanner.nextLine();
                    dll.addFirst(new Mahasiswa09(nim1, nama1, kelas1, ipk1));
                    System.out.println("Data Mahasiswa berhasil ditambahkan di awal.");
                    break;
                case 2:
                    System.out.print("Masukkan NIM: ");
                    String nim2 = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama2 = scanner.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    String kelas2 = scanner.nextLine();
                    System.out.print("Masukkan IPK: ");
                    String ipk2 = scanner.nextLine();
                    dll.addLast(new Mahasiswa09(nim2, nama2, kelas2, ipk2));
                    System.out.println("Data Mahasiswa berhasil ditambahkan di akhir.");
                    break;
                case 3:
                    System.out.print("Masukkan NIM: ");
                    String nim3 = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama3 = scanner.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    String kelas3 = scanner.nextLine();
                    System.out.print("Masukkan IPK: ");
                    String ipk3 = scanner.nextLine();
                    System.out.print("Masukkan NIM setelah data mana: ");
                    String nimAfter = scanner.nextLine();
                    dll.insertAfter(new Mahasiswa09(nim3, nama3, kelas3, ipk3), nimAfter);
                    break;
                case 4:
                    dll.removeFirst();
                    break;
                case 5:
                    dll.removeLast();
                    break;
                case 6:
                    System.out.print("Masukkan NIM setelah data mana: ");
                    String nimDelete = scanner.nextLine();
                    dll.removeAfter(nimDelete);
                    break;
                case 7:
                    System.out.println("Data Mahasiswa:");
                    dll.print();
                    break;
                case 8:
                    System.out.print("Masukkan NIM yang ingin dicari: ");
                    String nimCari = scanner.nextLine();
                    Node09 found = dll.search(nimCari);
                    if (found != null) {
                        System.out.println("Data Mahasiswa ditemukan:");
                        found.data.tampil();
                    } else {
                        System.out.println("Data Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
                    }
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
