/*
 * frmXemSPTheoLoai.java
 *
 * Created on December 18, 2016, 9:04 AM
 */

package Interface;
import Proccess.Timsanpham; 
import java.sql.*; 
import java.util.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel; 
/**
 *
 * @author  Me
 */
public class frmXemSPTheoLoai extends javax.swing.JFrame {
     Timsanpham sp = new Timsanpham();      
    DefaultTableModel tableModel = new DefaultTableModel();
    
      public final void ShowDataCombo() {         
        ResultSet result=null;           
        try { 
            result = sp.ShowSanpham();            
            while(result.next()){  
               //Them du lieu vao Combobox tìm đến cái có tên là :Maloai:
                cboLoaiSP.addItem(result.getString("Maloai")); 
            } 
        }  
        catch (SQLException e) { 
        }  
    }
      //click vao combobox nao load data do
     public final void ShowData(String ml) throws SQLException {         
        ResultSet result=null;           
        result = sp.ShowSPTheoloai(ml); 
        try {   
            ClearData(); 
            while(result.next()){  
                String rows[] = new String[4];  
                rows[0] = result.getString(1);  
                rows[1] = result.getString(2);  
                rows[2] = result.getString(3);  
                rows[3] = result.getString(4);                 
                tableModel.addRow(rows); 
            } 
        }  
        catch (SQLException e) { 
        }  
    } 
    /** Creates new form frmXemSPTheoLoai */
    public frmXemSPTheoLoai() {
        initComponents();
        ShowDataCombo(); 
       String []colsName = {"Mã SP", "Tên SP", "Giá bán","Loại"}; 
        // đặt tiêu đề cột cho tableModel 
       tableModel.setColumnIdentifiers(colsName);   
        // kết nối jtable với tableModel   
       jTable1.setModel(tableModel);
    }
     public void ClearData() throws SQLException{ 
         //Lay chi so dong cuoi cung 
         int n=tableModel.getRowCount()-1; 
         for(int i=n;i>=0;i--) 
            tableModel.removeRow(i);//Remove tung dong          
    }  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboLoaiSP = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btthoat = new javax.swing.JButton();
        bttrolai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));

        jLabel2.setText("Chọn mã:");

        cboLoaiSP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "chọn mã cần tìm" }));
        cboLoaiSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoaiSPItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Đơn Giá:", "Loại SP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btthoat.setText("Thoát");
        btthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthoatActionPerformed(evt);
            }
        });

        bttrolai.setText("Trở Lại");
        bttrolai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttrolaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(btthoat))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bttrolai, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttrolai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btthoat)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboLoaiSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoaiSPItemStateChanged
        try {
            
            // TODO add your handling code here:
            String ml = cboLoaiSP.getSelectedItem().toString();
            ShowData(ml);//GEN-LAST:event_cboLoaiSPItemStateChanged
        } catch (SQLException ex) {
            Logger.getLogger(frmXemSPTheoLoai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthoatActionPerformed
        // TODO add your handling code here:
       System.exit(0);
    }//GEN-LAST:event_btthoatActionPerformed

    private void bttrolaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttrolaiActionPerformed
        try {
            // TODO add your handling code here:
            frmCapnhatLoaiSP fr = new frmCapnhatLoaiSP();
            fr.setVisible(true);
            this.dispose();//GEN-LAST:event_bttrolaiActionPerformed
        } catch (SQLException ex) {
            Logger.getLogger(frmXemSPTheoLoai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmXemSPTheoLoai().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btthoat;
    private javax.swing.JButton bttrolai;
    private javax.swing.JComboBox cboLoaiSP;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
}
