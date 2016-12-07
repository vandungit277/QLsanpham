/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Proccess;
import Database.Connect; 
import java.sql.*; 
/**
 *
 * @author Me
 */
public class Sanpham {
 public Connect cn= new Connect();     
        //Truy van tat ca du lieu trong Table LoaiSP 
  public ResultSet ShowLoaiSP() throws SQLException{    
           cn.connectSQL(); 
           String sql = "SELECT * FROM LoaiSP";         
           return cn.LoadData(sql); 
        } 
        //Truy van cac dong du lieu trong Table LoaiSP theo Maloai 
        public ResultSet ShowLoaiSP(String ml) throws SQLException{    
           String sql = "SELECT * FROM LoaiSP where Maloai='" + ml +"'";         
           return cn.LoadData(sql); 
        }
         //Truy van lieu trong Table Sanpham theo Maloai 
        public ResultSet ShowSPTheoloai(String ml) throws SQLException {            
        String sql = "SELECT MaSP,TenSP,Dongia,L.Maloai, Tenloai  FROM Sanpham S, LoaiSP L where L.Maloai=S.Maloai and L.Maloai='" + ml +"'";         
        return cn.LoadData(sql); 
        } 
        //Truy van tat ca du lieu trong Table Sanpham 
        public ResultSet ShowSanpham() throws SQLException{    
           cn.connectSQL(); 
           String sql = "SELECT MaSP,TenSP,Dongia,L.Maloai, Tenloai  FROM Sanpham S, LoaiSP L where L.Maloai=S.Maloai";         
           return cn.LoadData(sql); 
        } 
        //Truy van du lieu trong Table Sanpham theo MaSP 
        public ResultSet ShowSPTheoma(String ma) throws SQLException{    
           String sql = "SELECT MaSP,TenSP,Dongia,L.Maloai, Tenloai  FROM Sanpham S, LoaiSP L where L.Maloai=S.Maloai and MaSP='" + ma +"'";         
           return cn.LoadData(sql); 
        }  
         //Truy van du lieu trong Table Sanpham theo gia  
        public ResultSet ShowSPTheogia(int giatu, int giaden) throws SQLException{    
           String sql = "SELECT MaSP,TenSP,Dongia,L.Maloai, Tenloai  FROM Sanpham S, LoaiSP L  where L.Maloai=S.Maloai and Dongia between " + giatu +" and " + giaden;         
           return cn.LoadData(sql); 
        } 
        public ResultSet ShowSPTheoten(String ten) throws SQLException{    
           String sql = "SELECT MaSP,TenSP,Dongia,L.Maloai, Tenloai  FROM Sanpham S, LoaiSP L  where L.Maloai=S.Maloai and TenSp like %" + ten + "%";         
           return cn.LoadData(sql); 
        } 
        //Theo moi 1 dong du lieu vao table Sanpham 
        public void InsertSanpham(String ma, String ten, int dg, String ml)  throws SQLException{    
            String sql = "INSERT INTO Sanpham  values('" + ma +"',N'" + ten +"'," + dg + ",'" + ml + "')";  
             cn.UpdateData(sql); 
        }
 //Dieu chinh 1 dong du lieu vao table Sanpham 
        public void EditSanpham(String ma, String ten, int dg, String ml)  throws SQLException{    
           String sql = "Update Sanpham  set TenSP=N'" + ten +"',Dongia=" + dg +",Maloai='" + ml +"'  where MaSP='" + ma +"'";         
           cn.UpdateData(sql); 
        }
 //Xoa 1 dong du lieu vao table Sanpham 
        public void DeleteSanpham(String ma) throws SQLException{    
           String sql = "Delete from Sanpham where MaSP='" + ma +"'";         
           cn.UpdateData(sql); 
        }

}
