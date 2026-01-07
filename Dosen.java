// Inheritance
public class Dosen extends User {
    private String spesialisasi;

    public Dosen(String id, String nama, String spesialisasi) {
        super(id, nama);
        this.spesialisasi = spesialisasi;
    }

    public String getSpesialisasi() { return spesialisasi; }
    public void setSpesialisasi(String spesialisasi) { this.spesialisasi = spesialisasi; }

    @Override
    public void tampilInfo() {
        System.out.println("Status: Dosen");
        System.out.println("NIDN  : " + this.id);
        System.out.println("Nama  : " + this.nama);
        System.out.println("Bidang: " + this.spesialisasi);
        System.out.println("-------------------------");
    }
}