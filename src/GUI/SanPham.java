package GUI;

import java.awt.*;
import javax.swing.*;

public class SanPham {
    private String srcAnh,tenSP;
    private float giaSP;

    public SanPham(String srcAnh, String tenSP, float giaSP) {
        this.srcAnh = srcAnh;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
    }

    public SanPham() {
    }

    public String getSrcAnh() {
        return srcAnh;
    }

    public void setSrcAnh(String srcAnh) {
        this.srcAnh = srcAnh;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public float getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(float giaSP) {
        this.giaSP = giaSP;
    }

    @Override
    public String toString() {
        return "SanPham{" + "srcAnh=" + srcAnh + ", tenSP=" + tenSP + ", giaSP=" + giaSP + '}';
    }
    
    
    
}
