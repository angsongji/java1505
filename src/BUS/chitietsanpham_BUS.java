package BUS;

import java.util.ArrayList;

import DAO.DAO_chitietsanpham;
import DTO.SanPhamDTO;
import DTO.chitietsanpham_DTO;

import DTO.SanPhamDTO;

public class chitietsanpham_BUS {

    ArrayList<chitietsanpham_DTO> ds;

    public chitietsanpham_BUS() {
        ds = new ArrayList<>();
        init();

    }

    private void init() {
        DAO_chitietsanpham n = new DAO_chitietsanpham();
        ds = n.listCTSP();
    }

    public ArrayList<chitietsanpham_DTO> getList() {
        return ds;
    }

    public chitietsanpham_BUS(SanPhamDTO h) {
        newlist(h);

    }

    public void newlist(SanPhamDTO h) {
        DAO_chitietsanpham c = new DAO_chitietsanpham(h);

        ds = c.select_all(h);
    }

    public ArrayList<String> select_masize(SanPhamDTO sanpham_DTO) {
        ArrayList<String> t = new ArrayList<String>();
        DAO_chitietsanpham c = new DAO_chitietsanpham(sanpham_DTO);

        t = c.select_size(sanpham_DTO);
        return t;
    }

    public static void main(String[] args) {
        SanPhamDTO m = new SanPhamDTO("SP8", null, null, 0, args, 0);
        chitietsanpham_BUS c = new chitietsanpham_BUS(m);
        for (String t : c.select_masize(m)) {
            System.out.println(t);
        }
    }
}
