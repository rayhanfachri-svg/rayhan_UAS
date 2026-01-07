// Abstract Class
public abstract class User {

    protected String id;
    protected String nama;

    public User() {
    }

    public User(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }
    // Encapsulation
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    // Abstract Method
    public abstract void tampilInfo();
}