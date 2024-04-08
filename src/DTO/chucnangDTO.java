/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hp
 */
public class chucnangDTO {
    private String MACHUCNANG;
    private String TENCHUCNANG;
    
    public chucnangDTO(String m,String t){
        MACHUCNANG=m;
        TENCHUCNANG=t;
    }
    public String getMACHUCNANG(){
        return MACHUCNANG;
    }
    public void setMACHUCNANG(String s){
        MACHUCNANG=s;
    }
    public String getTENCHUCNANG(){
        return TENCHUCNANG;
    }
    public void setTENCHUCNANG(String s){
        TENCHUCNANG=s;
    }
    
}
