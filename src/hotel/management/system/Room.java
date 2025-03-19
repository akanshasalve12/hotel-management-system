package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    
    Room() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
      

        JLabel l1=new JLabel("Room numbers");
        l1.setBounds(10,10,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Availability");
        l2.setBounds(120,10,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Status");
        l3.setBounds(230,10,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(330,10,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(420,10,100,20);
        add(l5);
        
        

        table =new JTable();
        table.setBounds(0,40,500,400);
        add(table);
     
        
        try{
            Conn c=new Conn();
            ResultSet rs = c.s.executeQuery("select * from room ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch (Exception e) {
            e.printStackTrace();
        
        }
      
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);
       
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eigth.jpg"));
//        JLabel image = new JLabel(i1);
//        image.setBounds(400, 50,500,300);
//        add(image);
        
        setBounds(300, 200, 1050, 600);
        setVisible(true);
            
         
    }
//    public void actionPerfomed(ActionEvent e){
//        setVisible(false);
//        new Reception();
//    }
        

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
     public static void main (String args[])
    {
        new Room();
    }
}