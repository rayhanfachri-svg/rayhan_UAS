import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // ArrayList untuk menyimpan object
    static ArrayList<User> daftarUser = new ArrayList<>(); // Polymorphism
    static ArrayList<MataKuliah> daftarMatkul = new ArrayList<>();
    static ArrayList<Nilai> daftarNilai = new ArrayList<>();
    
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int menu;
        
        do {
            System.out.println("\n=== SIAKAD MINI ===");
            System.out.println("1. Input Data Mahasiswa");
            System.out.println("2. Input Data Dosen");
            System.out.println("3. Input Mata Kuliah");
            System.out.println("4. Input Nilai Mahasiswa");
            System.out.println("5. Tampilkan Data & Nilai");
            System.out.println("6. Info Jumlah Mahasiswa (Static Var)");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            menu = scanner.nextInt();
            scanner.nextLine(); // Consume newline buffer

            switch (menu) {
                case 1:
                    inputMahasiswa();
                    break;
                case 2:
                    inputDosen();
                    break;
                case 3:
                    inputMatkul();
                    break;
                case 4:
                    inputNilai();
                    break;
                case 5:
                    tampilkanData();
                    break;
                case 6:
                    // Mengakses Static Variable langsung dari Class
                    System.out.println("Total Mahasiswa Terdaftar: " + Mahasiswa.totalMahasiswa);
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        } while (menu != 0);
    }

    // Method Input Mahasiswa
    static void inputMahasiswa() {
        System.out.print("Masukkan NIM  : ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Nama : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Prodi: ");
        String prodi = scanner.nextLine();

        // Membuat Object Mahasiswa dan disimpan ke ArrayList User (Upcasting)
        User mhs = new Mahasiswa(nim, nama, prodi);
        daftarUser.add(mhs);
        System.out.println("Data Mahasiswa berhasil disimpan!");
    }

    // Method Input Dosen
    static void inputDosen() {
        System.out.print("Masukkan NIDN : ");
        String nidn = scanner.nextLine();
        System.out.print("Masukkan Nama : ");
        String nama = scanner.nextLine();
        System.out.print("Spesialisasi  : ");
        String spe = scanner.nextLine();

        // Membuat Object Dosen
        User dosen = new Dosen(nidn, nama, spe);
        daftarUser.add(dosen);
        System.out.println("Data Dosen berhasil disimpan!");
    }

    // Method Input Matkul
    static void inputMatkul() {
        System.out.print("Kode MK : ");
        String kode = scanner.nextLine();
        System.out.print("Nama MK : ");
        String nm = scanner.nextLine();
        System.out.print("SKS     : ");
        int sks = scanner.nextInt();
        scanner.nextLine();

        daftarMatkul.add(new MataKuliah(kode, nm, sks));
        System.out.println("Mata Kuliah berhasil disimpan!");
    }

    // Method Input Nilai (Paling Kompleks - Butuh Mhs & Matkul yg sudah ada)
    static void inputNilai() {
        if (daftarUser.isEmpty() || daftarMatkul.isEmpty()) {
            System.out.println("Error: Data Mahasiswa atau Mata Kuliah belum ada.");
            return;
        }

        // Cari Mahasiswa berdasarkan NIM
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nimCari = scanner.nextLine();
        Mahasiswa mhsDipilih = null;

        // Looping mencari object Mahasiswa di dalam ArrayList User
        for (User u : daftarUser) {
            // Cek apakah object u adalah instance dari Mahasiswa (keyword instanceof)
            if (u instanceof Mahasiswa) {
                if (u.getId().equals(nimCari)) {
                    mhsDipilih = (Mahasiswa) u; // Downcasting
                    break;
                }
            }
        }

        if (mhsDipilih == null) {
            System.out.println("Mahasiswa tidak ditemukan.");
            return;
        }

        // Cari Matkul
        System.out.print("Masukkan Kode MK: ");
        String kodeCari = scanner.nextLine();
        MataKuliah mkDipilih = null;

        for (MataKuliah mk : daftarMatkul) {
            if (mk.getKodeMk().equals(kodeCari)) {
                mkDipilih = mk;
                break;
            }
        }

        if (mkDipilih == null) {
            System.out.println("Mata Kuliah tidak ditemukan.");
            return;
        }

        System.out.print("Nilai Tugas : ");
        double tugas = scanner.nextDouble();
        System.out.print("Nilai UTS   : ");
        double uts = scanner.nextDouble();
        System.out.print("Nilai UAS   : ");
        double uas = scanner.nextDouble();
        scanner.nextLine();

        // Membuat Object Nilai
        Nilai nilaiBaru = new Nilai(mhsDipilih, mkDipilih, tugas, uts, uas);
        daftarNilai.add(nilaiBaru);
        System.out.println("Nilai berhasil diinput!");
    }

    // Method Tampilkan Data
    static void tampilkanData() {
        System.out.println("\n--- DATA USER (Dosen & Mahasiswa) ---");
        for (User u : daftarUser) {
            // Polymorphism: Method tampilInfo() akan menyesuaikan apakah dia Dosen atau Mhs
            u.tampilInfo(); 
        }

        System.out.println("\n--- DATA NILAI MAHASISWA ---");
        for (Nilai n : daftarNilai) {
            n.tampilkanDataNilai(); // Menggunakan method dari class Nilai
        }
    }
}
