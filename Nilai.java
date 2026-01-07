// Class Nilai implements Interface
public class Nilai implements Penilaian {
    private Mahasiswa mahasiswa; 
    private MataKuliah mataKuliah;
    private double nilaiTugas;
    private double nilaiUts;
    private double nilaiUas;

    public Nilai(Mahasiswa mahasiswa, MataKuliah mataKuliah, double nilaiTugas, double nilaiUts, double nilaiUas) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUts = nilaiUts;
        this.nilaiUas = nilaiUas;
    }

    // Method Interface
    @Override
    public double hitungNilaiAkhir() {
        return (0.3 * nilaiTugas) + (0.3 * nilaiUts) + (0.4 * nilaiUas);
    }
    
    public void tampilkanDataNilai() {
        System.out.println("Nama Mhs  : " + mahasiswa.getNama());
        System.out.println("Mata Kuliah: " + mataKuliah.getNamaMk());
        System.out.println("Nilai Akhir: " + hitungNilaiAkhir());
        System.out.println("-------------------------");
    }
}
