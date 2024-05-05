/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SizeDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class SizeDAO {

    private ConnectDataBase c;

    public SizeDAO() {
        try {
            c = new ConnectDataBase();
        } catch (SQLException e) {
        }
    }

    public ArrayList<SizeDTO> listSizeRemoveTrangthai0() {
        ArrayList<SizeDTO> list = new ArrayList<>();

        try {
            c.connect();
            String query = "SELECT * FROM size";
            ResultSet result = c.executeQuery(query);
            while (result.next()) {
                if (result.getInt("TRANGTHAI") == 1) {
                    list.add(new SizeDTO(result.getString("MASIZE"), result.getString("TENSIZE")));
                }

            }

            c.disconnect();
        } catch (SQLException e) {
        }

        return list;
    }

    public ArrayList<SizeDTO> listSize() {
        ArrayList<SizeDTO> list = new ArrayList<>();

        try {
            c.connect();
            String query = "SELECT * FROM size";
            ResultSet result = c.executeQuery(query);
            while (result.next()) {

                list.add(new SizeDTO(result.getString("MASIZE"), result.getString("TENSIZE")));

            }

            c.disconnect();
        } catch (SQLException e) {
        }

        return list;
    }

    public void add(SizeDTO item) {
        try {
            c.connect();
            
            String query = "INSERT INTO size(MASIZE,TENSIZE) VALUES ('" + item.getMASIZE() + "','" + item.getTENSIZE() + "');";
            c.executeUpdate(query);
            c.disconnect();
        } catch (SQLException e) {
        }
    }

    public void update(SizeDTO item) {
        try {
            c.connect();

            String query = " UPDATE size SET TENSIZE='" + item.getTENSIZE() + "' WHERE MASIZE='" + item.getMASIZE() + "'";
            c.executeUpdate(query);
            c.disconnect();
        } catch (SQLException e) {
        }
    }

    public void delete(String m) {
        try {
            c.connect();
            String query = "UPDATE size SET TRANGTHAI = 0 WHERE MASIZE = '" + m + "'";
            c.executeUpdate(query);
            c.disconnect();
        } catch (SQLException e) {
        }
    }

}
