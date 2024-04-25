
package DTO;

public class Hoadon_DTO {
    private String maHD,maNV;
    private String ngayHD;
    private int maKH, giamgia, tongTien;

    public Hoadon_DTO(String maHD, String ngayHD, int maKH, String maNV,  int giamgia, int tongTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayHD = ngayHD;
        this.giamgia = giamgia;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }



    public String getMaNV() {
        return maNV;
    }

    public String getNgayHD() {
        return ngayHD;
    }

    public int getGiamgia() {
        return giamgia;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }


    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setNgayHD(String ngayHD) {
        this.ngayHD = ngayHD;
    }

    public void setGiamgia(int giamgia) {
        this.giamgia = giamgia;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    
    
    
}
