/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Proccess;

import Database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Me
 */
public class Timsanpham {
  public Connect cn= new Connect();     
    //Truy van tat ca du lieu trong Table LoaiSP 
    public ResultSet ShowSanpham() throws SQLException{    
           cn.connectSQL(); 
           String sql = "SELECT * FROM LoaiSP";         
           return cn.LoadData(sql); 
          
        } 
        //Truy van lieu trong Table Sanpham theo Maloai 
        public ResultSet ShowSPTheoloai(String ml) throws SQLException {            
        String sql = "SELECT MaSP,TenSP,Dongia,Tenloai  FROM Sanpham S, LoaiSP L  where L.Maloai=S.Maloai and L.Maloai='" + ml +"'";         
        return cn.LoadData(sql); 
        }

   
}
