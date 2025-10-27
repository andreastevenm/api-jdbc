package andreasjiu.ac.api_jdbc.model;

public class User {

//    di class User ini adalah model untuk menampung is data dari login user
    private String username;
    private String password;

//    saya buat getter dan setter dan constructor untuk menerima JSON dari body Postman nya
//    Constructor adalah method khusus di dalam class yang akan dipanggil otomatis ketika objek dibuat.
    public User() {}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
