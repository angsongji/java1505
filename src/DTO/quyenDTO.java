/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hp
 */
public class quyenDTO {
    private String MAQUYEN;
    private String TENQUYEN;
    
    public quyenDTO(String m,String t){
        MAQUYEN=m;
        TENQUYEN=t;
    }
    public String getMAQUYEN(){
        return MAQUYEN;
    }
    public void setMAQUYEN(String s){
        MAQUYEN=s;
    }
    public String getTENQUYEN(){
        return TENQUYEN;
    }
    public void setTENQUYEN(String s){
        TENQUYEN=s;
    }
    
}
