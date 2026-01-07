// Inheritance
public class Mahasiswa extends User {
    private String prodi;
    
    // Static Variable
    public static int totalMahasiswa = 0;

    // Constructor Overloading
    public Mahasiswa(String id, String nama, String prodi) {
        super(id, nama);
        this.prodi = prodi;
        totalMahasiswa++;
    }

    // Constructor Overloading
    public Mahasiswa(String id, String nama) {
        super(id, nama);
        this.prodi = "Umum";
        totalMahasiswa++;
    }

    public String getProdi() { return prodi; }
    public void setProdi(String prodi) { this.prodi = prodi; }

    // Polymorphism
    @Override
    public void tampilInfo() {
        System.out.println("Status: Mahasiswa");
        System.out.println("NIM   : " + this.id);
        System.out.println("Nama  : " + this.nama);
        System.out.println("Prodi : " + this.prodi);
        System.out.println("-------------------------");
    }
}