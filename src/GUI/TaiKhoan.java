package GUI;


public class TaiKhoan {
    private String maNV,username, password, ngayTao, maQuyen;
    private String state;

    public TaiKhoan() {
    }

    public TaiKhoan(String maNV, String username, String password, String ngayTao, String maQuyen, String state) {
        this.maNV = maNV;
        this.username = username;
        this.password = password;
        this.ngayTao = ngayTao;
        this.maQuyen = maQuyen;
        this.state = state;
    }

    public TaiKhoan(String state) {
        this.state = state;
    }

    

    
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    
    
    
}
