
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Insets;
import java.awt.event.*;  
import java.sql.*;  
import java.util.regex.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class InterfaceApp{
	JFrame frame;
	private JTable table;
	private JTextField textField;
  public static void main(String[] args){
  	InterfaceApp gui=new InterfaceApp();
  	gui.go();
  }
  public Connection getcon(){// connect to the database
	    Connection conn=null;
	    String url=null;
	    String user=null;
	    String password=null;
	    try{
	      Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch(ClassNotFoundException e){
	      System.out.println(" url error");
	      e.printStackTrace();
	    }
	    try{
	      url="jdbc:mysql://localhost:3306/accomodation?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";//the driver
	      user="root";//the account name
	      password="qwert";//the password
	      conn=(Connection)DriverManager.getConnection(url,user,password);//the connection
	      return conn;
	    } catch(SQLException e){
	      System.out.println(" link error");
	      e.printStackTrace();
	    }
	      return null;    
	    }
  public void go(){
  	frame=new JFrame();//create frame
  	frame.setTitle("Accomodation System");
  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	frame.setSize(934,334);
  	frame.getContentPane().setLayout(null);
  	
  	JLabel lblPleaseChooseThe = new JLabel("Please choose the table");
  	lblPleaseChooseThe.setBounds(27, 10, 173, 23);
  	frame.getContentPane().add(lblPleaseChooseThe);
  	
  	JLabel lblSamples = new JLabel("Samples");
  	lblSamples.setBounds(457, 14, 54, 15);
  	frame.getContentPane().add(lblSamples);
  	table = new JTable();
  	table.setBounds(10, 80, 901, 210);
  	frame.getContentPane().add(table);
  	
  	String tablelabel[]={"student","staff","advisor","manager","room","hall","flat","lease"};
  	JComboBox<?> jComboBox = new JComboBox<Object>(tablelabel);
	JComboBox<?> comboBox = jComboBox;
  	comboBox.setBounds(120, 35, 106, 23);
  	frame.getContentPane().add(comboBox);
  	
  	
  	
  	JButton btnSearch = new JButton("Search");
  	btnSearch.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent arg0) {
  			if(jComboBox.getSelectedItem().toString().equals("student"))
  			{
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();//establish the connection
  	  			String sql="select * from student";//this is the sentence in MySQL
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();//get the number of columns
  	  	  			JTableModel.setColumnCount(col);//set the column
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			while (rs.next()) {
	  				  vcRows=new Vector<String>();
	  				  for (int i = 1; i <= col; i++) {
	  					  vcRows.addElement(rs.getString(i));
	                  }
	  				  JTableModel.addRow(vcRows);
	                }
  	  	  			JTableModel.addRow(new Vector());
	  	  		    table.setModel(JTableModel);	
  	  	  			rs.close();//close
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("staff")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select * from staff";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			while (rs.next()) {
	  				  vcRows=new Vector<String>();
	  				  for (int i = 1; i <= col; i++) {
	  					  vcRows.addElement(rs.getString(i));
	                  }
	  				  JTableModel.addRow(vcRows);
	                }
  	  	  			JTableModel.addRow(new Vector());
  	  	  			table.setModel(JTableModel);	
  	  	  			rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("advisor")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select * from advisor";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			while (rs.next()) {
	  				  vcRows=new Vector<String>();
	  				  for (int i = 1; i <= col; i++) {
	  					  vcRows.addElement(rs.getString(i));
	                  }
	  				  JTableModel.addRow(vcRows);
	                }
  	  	  			JTableModel.addRow(new Vector());
  	  	  			table.setModel(JTableModel);	
  	  	  			rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("manager")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select * from manager";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			while (rs.next()) {
	  				  vcRows=new Vector<String>();
	  				  for (int i = 1; i <= col; i++) {
	  					  vcRows.addElement(rs.getString(i));
	                  }
	  				  JTableModel.addRow(vcRows);
	                }
  	  	  			JTableModel.addRow(new Vector());
  	  	  			table.setModel(JTableModel);	
  	  	  			rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("room")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select * from room";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			while (rs.next()) {
	  				  vcRows=new Vector<String>();
	  				  for (int i = 1; i <= col; i++) {
	  					  vcRows.addElement(rs.getString(i));
	                  }
	  				  JTableModel.addRow(vcRows);
	                }
  	  	  			JTableModel.addRow(new Vector());
  	  	  			table.setModel(JTableModel);	
  	  	  			rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("hall")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select * from hall";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			while (rs.next()) {
	  				  vcRows=new Vector<String>();
	  				  for (int i = 1; i <= col; i++) {
	  					  vcRows.addElement(rs.getString(i));
	                  }
	  				  JTableModel.addRow(vcRows);
	                }
  	  	  			JTableModel.addRow(new Vector());
  	  	  			table.setModel(JTableModel);	
  	  	  			rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("flat")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select * from flat";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			while (rs.next()) {
	  				  vcRows=new Vector<String>();
	  				  for (int i = 1; i <= col; i++) {
	  					  vcRows.addElement(rs.getString(i));
	                  }
	  				  JTableModel.addRow(vcRows);
	                }
  	  	  			JTableModel.addRow(new Vector());
  	  	  			table.setModel(JTableModel);	
  	  	  			rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("lease")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select * from lease";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  		    while (rs.next()) {
  	  				  vcRows=new Vector<String>();
  	  				  for (int i = 1; i <= col; i++) {
  	  					  vcRows.addElement(rs.getString(i));
  	                  }
  	  				  JTableModel.addRow(vcRows);
  	                }
  	  	  		    JTableModel.addRow(new Vector());
  	  	  		    table.setModel(JTableModel);	
  	  	            rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}	
  		}
  	});
  	btnSearch.setBounds(27, 35, 93, 23);
  	frame.getContentPane().add(btnSearch);
  	
  	String combolabel2[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n"};
  	JComboBox<?> comboBox_1 = new JComboBox<Object>(combolabel2);
  	comboBox_1.setBounds(565, 35, 68, 23);
  	frame.getContentPane().add(comboBox_1);
  	
  	JButton btnExecute = new JButton("Execute");
  	btnExecute.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			if(comboBox_1.getSelectedItem().toString().equals("a")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select stu_id, stu_name, place_no\r\n" + 
  	  					"from student\r\n" + 
  	  					"inner join lease on student.stu_id = lease.student\r\n" + 
  	  					"inner join room on lease.place = room.place_no;";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			  while (rs.next()) {
  	  	  				  vcRows=new Vector<String>();
  	  	  				  for (int i = 1; i <= col; i++) {
  	  	  					  vcRows.addElement(rs.getString(i));
  	  	                  }
  	  	  				  JTableModel.addRow(vcRows);
  	  	              }
  	  	  	        table.setModel(JTableModel);
  	  	            rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			
  			else if(comboBox_1.getSelectedItem().toString().equals("b")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select stu_id, stu_name\r\n" + 
  	  					"from lease\r\n" + 
  	  					"left outer join student\r\n" + 
  	  					"on student.stu_id = lease.student\r\n" + 
  	  					"where stu_id is not null;";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			  while (rs.next()) {
  	  	  				  vcRows=new Vector<String>();
  	  	  				  for (int i = 1; i <= col; i++) {
  	  	  					  vcRows.addElement(rs.getString(i));
  	  	                  }
  	  	  				  JTableModel.addRow(vcRows);
  	  	              }
  	  	  	        table.setModel(JTableModel);
  	  	            rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			
  			else if(comboBox_1.getSelectedItem().toString().equals("c")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select *\r\n" + 
  	  					"from room_of_hall\r\n" + 
  	  					"order by hall_name;";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			  while (rs.next()) {
  	  	  				  vcRows=new Vector<String>();
  	  	  				  for (int i = 1; i <= col; i++) {
  	  	  					  vcRows.addElement(rs.getString(i));
  	  	                  }
  	  	  				  JTableModel.addRow(vcRows);
  	  	              }
  	  	  	        table.setModel(JTableModel);
  	  	            rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			
  			else if(comboBox_1.getSelectedItem().toString().equals("d")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select advisor_name, advisor_tel, stu_name\r\n" + 
  	  					"from student left outer join advisor\r\n" + 
  	  					"on student.advisor = advisor_id;";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			  while (rs.next()) {
  	  	  				  vcRows=new Vector<String>();
  	  	  				  for (int i = 1; i <= col; i++) {
  	  	  					  vcRows.addElement(rs.getString(i));
  	  	                  }
  	  	  				  JTableModel.addRow(vcRows);
  	  	              }
  	  	  	        table.setModel(JTableModel);
  	  	            rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			
  			else if(comboBox_1.getSelectedItem().toString().equals("e")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select advisor_name, advisor_tel, stu_name\r\n" + 
  	  					"from student left outer join advisor\r\n" + 
  	  					"on student.advisor = advisor_id\r\n" + 
  	  					"where student.stu_id in (select stu_id\r\n" + 
  	  					"from lease left join student on student.stu_id = lease.student\r\n" + 
  	  					"where stu_id is not null);";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			  while (rs.next()) {
  	  	  				  vcRows=new Vector<String>();
  	  	  				  for (int i = 1; i <= col; i++) {
  	  	  					  vcRows.addElement(rs.getString(i));
  	  	                  }
  	  	  				  JTableModel.addRow(vcRows);
  	  	              }
  	  	  	        table.setModel(JTableModel);
  	  	            rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			
  			else if(comboBox_1.getSelectedItem().toString().equals("f")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select stu_dept, count(stu_id)\r\n" + 
  	  					"from lease right join student on stu_id = student\r\n" + 
  	  					"inner join room on place = place_no\r\n" + 
  	  					"where room_type = 'hall'\r\n" + 
  	  					"group by stu_dept;";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			  while (rs.next()) {
  	  	  				  vcRows=new Vector<String>();
  	  	  				  for (int i = 1; i <= col; i++) {
  	  	  					  vcRows.addElement(rs.getString(i));
  	  	                  }
  	  	  				  JTableModel.addRow(vcRows);
  	  	              }
  	  	  	        table.setModel(JTableModel);
  	  	            rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			
  			else if(comboBox_1.getSelectedItem().toString().equals("g")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select stu_id, addr \r\n" + 
  	  					"from student inner join lease \r\n" + 
  	  					"on lease.student = student.stu_id \r\n" + 
  	  					"and student.stu_id = \"2017549372\";";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			  while (rs.next()) {
  	  	  				  vcRows=new Vector<String>();
  	  	  				  for (int i = 1; i <= col; i++) {
  	  	  					  vcRows.addElement(rs.getString(i));
  	  	                  }
  	  	  				  JTableModel.addRow(vcRows);
  	  	              }
  	  	  	        table.setModel(JTableModel);
  	  	            rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			
  			else if(comboBox_1.getSelectedItem().toString().equals("h")){
  	  		  	DefaultTableModel JTableModel = new DefaultTableModel();   
  	  			Connection conn=getcon();
  	  			String sql="select manager_id, manager_name, hall \r\n" + 
  	  					"from manager left outer join hall \r\n" + 
  	  					"on manager.hall = hall.hall_name\r\n" + 
  	  					"order by manager_id;";
  	  	  		PreparedStatement pstmt;
  	  	  		try{
  	  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  	  			ResultSet rs=pstmt.executeQuery();
  	  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  	  			int col=rsmd.getColumnCount();
  	  	  			JTableModel.setColumnCount(col);
  	  	  			Vector<String> vcRows=new Vector<String>();
  	  	  			rs.next();
  	  	  			for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  	  			}
  	  	  			rs.beforeFirst();
  	  	  			JTableModel.addRow(vcRows);
  	  	  			  while (rs.next()) {
  	  	  				  vcRows=new Vector<String>();
  	  	  				  for (int i = 1; i <= col; i++) {
  	  	  					  vcRows.addElement(rs.getString(i));
  	  	                  }
  	  	  				  JTableModel.addRow(vcRows);
  	  	              }
  	  	  	        table.setModel(JTableModel);
  	  	            rs.close();
  	  	            pstmt.close();
  	  	            conn.close();
  	  	  		} catch (SQLException e1) {
  	  	  		System.out.println("Your command is not available");
  	  	        e1.printStackTrace();
  	  	    }
  			}
  			
  		}
  	});
  	btnExecute.setBounds(460, 35, 93, 23);
  	frame.getContentPane().add(btnExecute);
  	
  	JLabel lblInputQuery = new JLabel("Input Query");
  	lblInputQuery.setBounds(654, 13, 126, 16);
  	frame.getContentPane().add(lblInputQuery);
  	
  	textField = new JTextField();
  	textField.setBounds(659, 32, 147, 26);
  	frame.getContentPane().add(textField);
  	textField.setColumns(10);
  	
  	JButton btnExecute_1 = new JButton("Execute");
  	btnExecute_1.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			String sql =textField.getText();
  			DefaultTableModel JTableModel = new DefaultTableModel();   
	  		Connection conn=getcon();
	  	  	PreparedStatement pstmt;
	  	  	if (sql.startsWith("select")) {
	  	  	try{
  	  			pstmt=(PreparedStatement)conn.prepareStatement(sql);
  	  			ResultSet rs=pstmt.executeQuery();
  	  			ResultSetMetaData rsmd=rs.getMetaData();
  	  			int col=rsmd.getColumnCount();
  	  			JTableModel.setColumnCount(col);
  	  			Vector<String> vcRows=new Vector<String>();
  	  		    rs.next();
  	  		    for (int i = 1; i <= col; i++) {
					  vcRows.addElement(rsmd.getColumnName(i));
  	  		    }
  	  		    rs.beforeFirst();
  	  		    JTableModel.addRow(vcRows);
  	  			  while (rs.next()) {
  	  				  vcRows=new Vector<String>();
  	  				  for (int i = 1; i <= col; i++) {
  	  					  vcRows.addElement(rs.getString(i));
  	                  }
  	  				  JTableModel.addRow(vcRows);
  	              }
  	  	        table.setModel(JTableModel);
  	  	        //JOptionPane.showMessageDialog(null, "Success");
  	            rs.close();
  	            pstmt.close();
  	            conn.close();
  	  		} catch (SQLException e1) {
  	  		System.out.println("Your command is not available");
	  	  	JOptionPane.showMessageDialog(null, "Your command is not available");
  	        e1.printStackTrace();
  	  		}
	  	  	}
	  	  	else {
	  	  		try {
	  	  		pstmt=(PreparedStatement)conn.prepareStatement(sql);
	  			pstmt.executeUpdate();
	  			JOptionPane.showMessageDialog(null, "Success");
	  			pstmt.close();
	  			conn.close();
	  	  		} catch (SQLException e1) {
	  	  	  		System.out.println("Your command is not available");
	  	  	  		JOptionPane.showMessageDialog(null, "Your command is not available");
	  	  	        e1.printStackTrace();
	  	  		}
	  	  	}
  		}
  	});
  	btnExecute_1.setBounds(818, 32, 93, 29);
  	frame.getContentPane().add(btnExecute_1);
  	
  	JButton btnAdd = new JButton("Add");
  	btnAdd.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			if(jComboBox.getSelectedItem().toString().equals("student"))
  			{
  			Connection conn=getcon();
	  	  	PreparedStatement pstmt;
  			int column = table.getColumnCount();
  			int row = table.getRowCount();
  			String[] value = new String[column];
  			try {
  	  			for(int i=0; i<column; i++) {
  	  				value[i] = table.getValueAt(row-1, i).toString();
  	  			}
  	  			String sql = "insert into student values('"+value[0]+"','"+value[1]+"','"+
  	  							value[2]+"','"+value[3]+"','"+value[4]+
  	  							"','"+value[5]+"','"+value[6]+"','"+value[7]+"')";
  	  				pstmt=(PreparedStatement)conn.prepareStatement(sql);
  		  			pstmt.executeUpdate();
  		  			JOptionPane.showMessageDialog(null, "Success");
  		  			pstmt.close();
  		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			
  			else if(jComboBox.getSelectedItem().toString().equals("staff"))
  			{
  			Connection conn=getcon();
	  	  	PreparedStatement pstmt;
  			int column = table.getColumnCount();
  			int row = table.getRowCount();
  			String[] value = new String[column];
  			try {
  	  			for(int i=0; i<column; i++) {
  	  				value[i] = table.getValueAt(row-1, i).toString();
  	  			}
  	  			String sql = "insert into staff values('"+value[0]+"','"+value[1]+"','"+
  	  							value[2]+"','"+value[3]+"','"+value[4]+
  	  							"','"+value[5]+"','"+value[6]+"')";
  	  				pstmt=(PreparedStatement)conn.prepareStatement(sql);
  		  			pstmt.executeUpdate();
  		  			JOptionPane.showMessageDialog(null, "Success");
  		  			pstmt.close();
  		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			
  			else if(jComboBox.getSelectedItem().toString().equals("advisor"))
  			{
  			Connection conn=getcon();
	  	  	PreparedStatement pstmt;
  			int column = table.getColumnCount();
  			int row = table.getRowCount();
  			String[] value = new String[column];
  			try {
  	  			for(int i=0; i<column; i++) {
  	  				value[i] = table.getValueAt(row-1, i).toString();
  	  			}
  	  			String sql = "insert into advisor values('"+value[0]+"','"+value[1]+"','"+
  	  							value[2]+"','"+value[3]+"')";
  	  				pstmt=(PreparedStatement)conn.prepareStatement(sql);
  		  			pstmt.executeUpdate();
  		  			JOptionPane.showMessageDialog(null, "Success");
  		  			pstmt.close();
  		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			
  			else if(jComboBox.getSelectedItem().toString().equals("manager"))
  			{
  			Connection conn=getcon();
	  	  	PreparedStatement pstmt;
  			int column = table.getColumnCount();
  			int row = table.getRowCount();
  			String[] value = new String[column];
  			try {
  	  			for(int i=0; i<column; i++) {
  	  				value[i] = table.getValueAt(row-1, i).toString();
  	  			}
  	  			String sql = "insert into manager values('"+value[0]+"','"+value[1]+"','"+
  	  							value[2]+"')";
  	  				pstmt=(PreparedStatement)conn.prepareStatement(sql);
  		  			pstmt.executeUpdate();
  		  			JOptionPane.showMessageDialog(null, "Success");
  		  			pstmt.close();
  		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			
  			else if(jComboBox.getSelectedItem().toString().equals("room"))
  			{
  			Connection conn=getcon();
	  	  	PreparedStatement pstmt;
  			int column = table.getColumnCount();
  			int row = table.getRowCount();
  			String[] value = new String[column];
  			try {
  	  			for(int i=0; i<column; i++) {
  	  				value[i] = table.getValueAt(row-1, i).toString();
  	  			}
  	  			String sql = "insert into room values('"+value[0]+"','"+value[1]+"','"+
  	  							value[2]+"')";
  	  				pstmt=(PreparedStatement)conn.prepareStatement(sql);
  		  			pstmt.executeUpdate();
  		  			JOptionPane.showMessageDialog(null, "Success");
  		  			pstmt.close();
  		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			
  			else if(jComboBox.getSelectedItem().toString().equals("hall"))
  			{
  			Connection conn=getcon();
	  	  	PreparedStatement pstmt;
  			int column = table.getColumnCount();
  			int row = table.getRowCount();
  			String[] value = new String[column];
  			try {
  	  			for(int i=0; i<column; i++) {
  	  				value[i] = table.getValueAt(row-1, i).toString();
  	  				if(i==2) {
  	  					if(!((Integer)Integer.parseInt(value[i]) instanceof Integer)) {
						value[i] = "0";
  	  					}
  	  				}
  	  			}
  	  			String sql = "insert into hall values('"+value[0]+"','"+value[1]+"',"+
  	  							value[2]+")";
  	  				pstmt=(PreparedStatement)conn.prepareStatement(sql);
  		  			pstmt.executeUpdate();
  		  			JOptionPane.showMessageDialog(null, "Success");
  		  			pstmt.close();
  		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			
  			else if(jComboBox.getSelectedItem().toString().equals("flat"))
  			{
  			Connection conn=getcon();
	  	  	PreparedStatement pstmt;
  			int column = table.getColumnCount();
  			int row = table.getRowCount();
  			String[] value = new String[column];
  			try {
  	  			for(int i=0; i<column; i++) {
  	  				value[i] = table.getValueAt(row-1, i).toString();
  	  				if(i==2) {
  	  					if(!((Integer)Integer.parseInt(value[i]) instanceof Integer)) {
							value[i] = "0";
						}
  	  				}
  	  			}
  	  			String sql = "insert into flat values('"+value[0]+"','"+value[1]+"',"+
  	  							value[2]+")";
  	  				pstmt=(PreparedStatement)conn.prepareStatement(sql);
  		  			pstmt.executeUpdate();
  		  			JOptionPane.showMessageDialog(null, "Success");
  		  			pstmt.close();
  		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			
  			else if(jComboBox.getSelectedItem().toString().equals("lease"))
  			{
  			Connection conn=getcon();
	  	  	PreparedStatement pstmt;
  			int column = table.getColumnCount();
  			int row = table.getRowCount();
  			String[] value = new String[column];
  			try {
  	  			for(int i=0; i<column; i++) {
  	  				value[i] = table.getValueAt(row-1, i).toString();
  	  			}
  	  			String sql = "insert into lease values('"+value[0]+"','"+value[1]+"','"+
  	  							value[2]+"','"+value[3]+"','"+value[4]+
  	  							"','"+value[5]+"')";
  	  				pstmt=(PreparedStatement)conn.prepareStatement(sql);
  		  			pstmt.executeUpdate();
  		  			JOptionPane.showMessageDialog(null, "Success");
  		  			pstmt.close();
  		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  		}
  		});
  	btnAdd.setBounds(227, 35, 75, 23);
  	frame.getContentPane().add(btnAdd);
  	
  	JButton btnDelete = new JButton("Delete");
  	btnDelete.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			if(jComboBox.getSelectedItem().toString().equals("student"))
  			{
  				int rowcount = table.getSelectedRow();
  				if(rowcount >= 0 && rowcount != table.getRowCount()-1 && rowcount != 0) {
  					((DefaultTableModel) table.getModel()).removeRow(rowcount);
  				}
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			System.out.println(row);
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete from student where true");
  	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into student values('"+value[i][0]+
  	  							"','"+value[i][1]+
  	  							"','"+value[i][2]+"','"+value[i][3]+"','"+value[i][4]+
  	  							"','"+value[i][5]+"','"+value[i][6]+"','"+value[i][7]+"')");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("staff"))
  			{
  				int rowcount = table.getSelectedRow();
  				if(rowcount >= 0 && rowcount != table.getRowCount()-1 && rowcount != 0) {
  					((DefaultTableModel) table.getModel()).removeRow(rowcount);
  				}
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  			pstmt = (PreparedStatement)conn.prepareStatement("delete from staff where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into staff values('"+
  	  							value[i][0]+"','"+value[i][1]+"','"+
  	  							value[i][2]+"','"+value[i][3]+"','"+value[i][4]+
  	  							"','"+value[i][5]+"','"+value[i][6]+"')");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("advisor"))
  			{
  				int rowcount = table.getSelectedRow();
  				if(rowcount >= 0 && rowcount != table.getRowCount()-1 && rowcount != 0) {
  					((DefaultTableModel) table.getModel()).removeRow(rowcount);
  				}
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete from advisor where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into advisor values('"+
  	  							value[i][0]+"','"+value[i][1]+"','"+
  	  							value[i][2]+"','"+value[i][3]+"')");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("manager"))
  			{
  				int rowcount = table.getSelectedRow();
  				if(rowcount >= 0 && rowcount != table.getRowCount()-1 && rowcount != 0) {
  					((DefaultTableModel) table.getModel()).removeRow(rowcount);
  				}
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete manager student where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into manager values('"+value[i][0]+
  	  							"','"+value[i][1]+"','"+
  	  							value[i][2]+"')");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("room"))
  			{
  				int rowcount = table.getSelectedRow();
  				if(rowcount >= 0 && rowcount != table.getRowCount()-1 && rowcount != 0) {
  					((DefaultTableModel) table.getModel()).removeRow(rowcount);
  				}
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete from room where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into room values('"+value[i][0]+
  	  							"','"+value[i][1]+"','"+
  	  							value[i][2]+"')");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("hall"))
  			{
  				int rowcount = table.getSelectedRow();
  				System.out.println(rowcount);
  				if(rowcount >= 0 && rowcount != table.getRowCount()-1 && rowcount != 0) {
  					((DefaultTableModel) table.getModel()).removeRow(rowcount);
  				}
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete from hall where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into hall values('"+
  	  							value[i][0]+"','"+value[i][1]+"',"+
  	  							value[i][2]+")");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("flat"))
  			{
  				int rowcount = table.getSelectedRow();
  				if(rowcount >= 0 && rowcount != table.getRowCount()-1 && rowcount != 0) {
  					((DefaultTableModel) table.getModel()).removeRow(rowcount);
  				}
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete from flat where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into flat values('"+value[i][0]+
  	  							"','"+value[i][1]+"',"+
  	  							value[i][2]+")");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("lease"))
  			{
  				int rowcount = table.getSelectedRow();
  				if(rowcount >= 0 && rowcount != table.getRowCount()-1 && rowcount != 0) {
  					((DefaultTableModel) table.getModel()).removeRow(rowcount);
  				}
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete from lease where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into lease values('"+value[i][0]+
  	  							"','"+value[i][1]+"','"+
  	  							value[i][2]+"','"+value[i][3]+"','"+value[i][4]+
  	  							"','"+value[i][5]+"')");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  		}
  	});
  	btnDelete.setBounds(297, 35, 75, 23);
  	frame.getContentPane().add(btnDelete);
  	
  	JButton btnUpdate = new JButton("Update");
  	btnUpdate.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			if(jComboBox.getSelectedItem().toString().equals("student"))
  			{
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			System.out.println(row);
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete from student where true");
  	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into student values('"+value[i][0]+
  	  							"','"+value[i][1]+
  	  							"','"+value[i][2]+"','"+value[i][3]+"','"+value[i][4]+
  	  							"','"+value[i][5]+"','"+value[i][6]+"','"+value[i][7]+"')");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("staff"))
  			{
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  			pstmt = (PreparedStatement)conn.prepareStatement("delete from staff where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into staff values('"+
  	  							value[i][0]+"','"+value[i][1]+"','"+
  	  							value[i][2]+"','"+value[i][3]+"','"+value[i][4]+
  	  							"','"+value[i][5]+"','"+value[i][6]+"')");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("advisor"))
  			{
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete from advisor where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into advisor values('"+
  	  							value[i][0]+"','"+value[i][1]+"','"+
  	  							value[i][2]+"','"+value[i][3]+"')");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("manager"))
  			{
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete manager student where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into manager values('"+value[i][0]+
  	  							"','"+value[i][1]+"','"+
  	  							value[i][2]+"')");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("room"))
  			{
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete from room where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into room values('"+value[i][0]+
  	  							"','"+value[i][1]+"','"+
  	  							value[i][2]+"')");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("hall"))
  			{
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  						if(j==2) {
  	  							if(!((Integer)Integer.parseInt(value[i][j]) instanceof Integer)) {
  	  								value[i][j] = "0";
  	  							}
  	  						}
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete from hall where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into hall values('"+
  	  							value[i][0]+"','"+value[i][1]+"',"+
  	  							value[i][2]+")");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("flat"))
  			{
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  						if(j==2) {
  	  							if(!((Integer)Integer.parseInt(value[i][j]) instanceof Integer)) {
	  								value[i][j] = "0";
	  							}
  	  						}
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete from flat where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into flat values('"+value[i][0]+
  	  							"','"+value[i][1]+"',"+
  	  							value[i][2]+")");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  			else if(jComboBox.getSelectedItem().toString().equals("lease"))
  			{
  				Connection conn=getcon();
  		  	  	PreparedStatement pstmt = null;
  	  			int column = table.getColumnCount();
  	  			int row = table.getRowCount();
  	  			String[][] value = new String[row-1][column];
  	  			try {
  	  				for (int i=1;i<row-1;i++) {
  	  					for (int j=0;j<column;j++) {
  	  						value[i][j] = table.getValueAt(i,j).toString();
  	  					}
  	  				}
  	  				pstmt = (PreparedStatement)conn.prepareStatement("delete from lease where true");
	  				pstmt.executeUpdate();
  	  				for(int i=1;i<row-1;i++) {
  	  					pstmt = (PreparedStatement)conn.prepareStatement("insert into lease values('"+value[i][0]+
  	  							"','"+value[i][1]+"','"+
  	  							value[i][2]+"','"+value[i][3]+"','"+value[i][4]+
  	  							"','"+value[i][5]+"')");
  	  					pstmt.executeUpdate();
  	  				}
  	  				JOptionPane.showMessageDialog(null, "Success");
		  			pstmt.close();
		  			conn.close();
  	  			}catch(SQLException e1) {
  	  				System.out.println("Your command is not available");
  	  	  	        e1.printStackTrace();
  	  			}catch(NullPointerException e2) {
  	  				System.out.println("Invalid Input");
  	  				e2.printStackTrace();
  	  			}
  			}
  		}
  	});
  	btnUpdate.setBounds(366, 35, 75, 23);
  	frame.getContentPane().add(btnUpdate);
  	
  	frame.setVisible(true);	
  }
}



  
    
















