package java_The_Best_Homeworke;

import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;
public class Mydb 
{
	
	//ע���û�
	public static void Register(String u,String p) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URLָ��Ҫ���ʵ����ݿ���mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL�����û���                           
		String password = "u201712051";		// MySQL����ʱ������  
		String name;
	    try 
	    {         
	    	Class.forName(driver);// ������������   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�      
//	    	System.out.println(u,p);
//	    	if(!conn.isClosed())              
//	    		System.out.println("Succeeded connecting to the Database!");
	    	PreparedStatement statement = conn.prepareStatement("insert into UserTable values(?,?)");
	    	statement.setString(1, u);
	    	statement.setString(2, p);
	    	int i=statement.executeUpdate();
	    	if(i==1)
	    	{
	    		System.out.println("���OK");
	    		JOptionPane.showMessageDialog(null, "ע��ɹ�","�ɹ�",JOptionPane.ERROR_MESSAGE);
	    	}
       
			conn.close();
	    } 
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println("Sorry,can`t find the Driver!");             
	    	e.printStackTrace();
	    } 
	    catch(SQLException e) 
	    {
	    	e.printStackTrace();
	    } 
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    } 
	}
	
	//ע���˻�
	public static void Cancellation() 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URLָ��Ҫ���ʵ����ݿ���mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL�����û���                           
		String password = "u201712051";		// MySQL����ʱ������  
		String name;
		String u = null;
	    try 
	    {         
	    	Class.forName(driver);// ������������   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�      
//	    	System.out.println(u,p);
//	    	if(!conn.isClosed())              
//	    		System.out.println("Succeeded connecting to the Database!");
	    			
	    	PreparedStatement ps = conn.prepareStatement("select * from UserTable");
	    	ResultSet rs = ps.executeQuery();// ����� 
	    	while(rs.next())
	    	{
				u=rs.getString("User_Name");
			}
	    	PreparedStatement statement = conn.prepareStatement("delete from UserTable where User_Name = ?");
	    	statement.setString(1, u);
	    	
	    	

	    	int i=statement.executeUpdate();
	    	if(i==1)
	    	{
	    		System.out.println("ɾ���ɹ�");
	    		JOptionPane.showMessageDialog(null, "ע���ɹ�","�ɹ�",JOptionPane.ERROR_MESSAGE);
	    	}
       
			conn.close();
	    } 
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println("Sorry,can`t find the Driver!");             
	    	e.printStackTrace();
	    } 
	    catch(SQLException e) 
	    {
	    	e.printStackTrace();
	    } 
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    } 
	}
	
	
	//����Ƿ����
	public static boolean cheak(String TN,String N,String PN) //����������������������
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URLָ��Ҫ���ʵ����ݿ���mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL�����û���                           
		String password = "u201712051";		// MySQL����ʱ������  
		boolean flag = true; 
		String sql;
	    try 
	    {         
	    	Class.forName(driver);// ������������   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�      
    			
//	    	PreparedStatement ps = conn.prepareStatement("select ? from ? ");
//	    	ps.setString(1,N);
//	    	ps.setString(2,TN);
	    	PreparedStatement ps = conn.prepareStatement("select "+N+" from "+TN);
	    	ResultSet rs = ps.executeQuery();// ����� 
	    	while(rs.next())
	    	{
	    		if(rs.getString(N).equals(PN)) 
	    		{
	    			flag = false;
	    			break;
	    		}
	    		
	    	}
	    	rs.close();
			conn.close();
	    } 
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println("Sorry,can`t find the Driver!");             
	    	e.printStackTrace();
	    } 
	    catch(SQLException e) 
	    {
	    	e.printStackTrace();
	    } 
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    } 
	    return flag;
	}
	
	
	//���ӵ���
	public static void add_shop(String n,String l,String t,String a) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URLָ��Ҫ���ʵ����ݿ���mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL�����û���                           
		String password = "u201712051";		// MySQL����ʱ������  
		String u = null;
	    try 
	    {         
	    	Class.forName(driver);// ������������   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�      
//	    	System.out.println(u,p);
//	    	if(!conn.isClosed())               
//	    		System.out.println("Succeeded connecting to the Database!");
	    			
//	    	PreparedStatement ps = conn.prepareStatement("");
//	    	ResultSet rs = ps.executeQuery();// ����� 
//	    	while(rs.next())
//	    	{
//				u=rs.getString("User_Name");
//			}

	    	PreparedStatement statement = conn.prepareStatement("insert into Shop values(?,?,?,?)");
	    	statement.setString(1, n);
	    	statement.setString(2, l);
	    	statement.setString(3, t);	
	    	statement.setString(4, a);	

	    	int i=statement.executeUpdate();
	    	if(i==1)
	    	{
	    		JOptionPane.showMessageDialog(null, "��ӳɹ�","�ɹ�",JOptionPane.ERROR_MESSAGE);
	    	}
       
			conn.close();
	    } 
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println("Sorry,can`t find the Driver!");             
	    	e.printStackTrace();
	    } 
	    catch(SQLException e) 
	    {
	    	e.printStackTrace();
	    } 
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    } 
	}
	
	
	
	//ɾ������
	public static void Del_shop(String u) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URLָ��Ҫ���ʵ����ݿ���mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL�����û���                           
		String password = "u201712051";		// MySQL����ʱ������  
		String name;
	    try 
	    {         
	    	Class.forName(driver);// ������������   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�      

	    	PreparedStatement statement = conn.prepareStatement("delete from Shop where Shop_Name = ?");
	    	statement.setString(1, u);
	    	int i=statement.executeUpdate();
	    	if(i==1)
	    	{
	    		System.out.println("ɾ���ɹ�");
	    		JOptionPane.showMessageDialog(null, "ɾ���ɹ�","�ɹ�",JOptionPane.ERROR_MESSAGE);
	    	}
       
			conn.close();
	    } 
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println("Sorry,can`t find the Driver!");             
	    	e.printStackTrace();
	    } 
	    catch(SQLException e) 
	    {
	    	e.printStackTrace();
	    } 
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    } 
	}
	//�޸ĵ���
	public static void Alter(String u,String l,String t) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URLָ��Ҫ���ʵ����ݿ���mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL�����û���                           
		String password = "u201712051";		// MySQL����ʱ������  
	    try 
	    {         
	    	Class.forName(driver);// ������������   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�      
	    	PreparedStatement statement = conn.prepareStatement("UPDATE Shop SET Shop_Local = ?,Shop_Tell = ? WHERE Shop_Name = ?");   	
	    	statement.setString(1, l);
	    	statement.setString(2, t);
	    	statement.setString(3, u);
	    	int i=statement.executeUpdate();
	    	if(i==1)
	    	{
//	    		System.out.println("�޸ĳɹ�");
	    		JOptionPane.showMessageDialog(null, "�޸ĳɹ�","�ɹ�",JOptionPane.ERROR_MESSAGE);
	    	}
       
			conn.close();
	    } 
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println("Sorry,can`t find the Driver!");             
	    	e.printStackTrace();
	    } 
	    catch(SQLException e) 
	    {
	    	e.printStackTrace();
	    } 
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    } 
	}
	
	//�ҵ��ղ�
	public static String My_Shop() 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URLָ��Ҫ���ʵ����ݿ���mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL�����û���                           
		String password = "u201712051";		// MySQL����ʱ������  
		String sum="";
	    try 
	    {         
	    	Class.forName(driver);// ������������   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�         			
	    	PreparedStatement ps = conn.prepareStatement("select * from Shop");
	    	ResultSet rs = ps.executeQuery();// ���
	    	while(rs.next())
	    	{
	    		sum = rs.getString(1) +"\n"+ sum;
	    	}
	    	
	    	rs.close();
			conn.close();
			
	    } 
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println("Sorry,can`t find the Driver!");             
	    	e.printStackTrace();
	    } 
	    catch(SQLException e) 
	    {
	    	e.printStackTrace();
	    } 
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    } 
	    return sum;
	}
	
	//����ɾ�����̱���������ݿ�
	public static Vector shop_table() 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URLָ��Ҫ���ʵ����ݿ���mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL�����û���                           
		String password = "u201712051";		// MySQL����ʱ������  
		Vector sum = new Vector(10,1);
	    try 
	    {         
	    	Class.forName(driver);// ������������   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�         			
	    	PreparedStatement ps = conn.prepareStatement("select * from Shop");
	    	ResultSet rs = ps.executeQuery();// ���
	    	
	    	while(rs.next())
	    	{
	    		sum.add(rs.getString(1));
	    	}
	    	
	    	
	    	rs.close();
			conn.close();
			
	    } 
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println("Sorry,can`t find the Driver!");             
	    	e.printStackTrace();
	    } 
	    catch(SQLException e) 
	    {
	    	e.printStackTrace();
	    } 
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    } 
	    return sum;
	}
	
	
	public static String MyShop(String n) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URLָ��Ҫ���ʵ����ݿ���mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL�����û���                           
		String password = "u201712051";		// MySQL����ʱ������  
		String name,local,tell,sum = null;
	    try 
	    {         
	    	Class.forName(driver);// ������������   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�         			
	    	PreparedStatement ps = conn.prepareStatement("select * from Shop where Shop_Name = ?");
	    	ps.setString(1, n);
	    	ResultSet rs = ps.executeQuery();// ���

	    	
	    	rs.next();
    		name = rs.getString(1) + "\n";
    		local = rs.getString(2) + "\n";
    		tell = rs.getString(3) + "\n";
    		sum = "�������֣�"+name+"    "+"����λ�ã�"+local+"    "+"���̵绰��"+tell; 
    		
	    	
//	    	rs.close();
//	    	r2.close();
//	    	r3.close();
			conn.close();
			
	    } 
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println("Sorry,can`t find the Driver!");             
	    	e.printStackTrace();
	    } 
	    catch(SQLException e) 
	    {
	    	e.printStackTrace();
	    } 
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    } 
	    return sum;
	}
	//���Ӳ�Ʒ
	public static void add_Food(String n,String l,String t) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URLָ��Ҫ���ʵ����ݿ���mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL�����û���                           
		String password = "u201712051";		// MySQL����ʱ������  
		String u = null;
	    try 
	    {         
	    	Class.forName(driver);// ������������   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�      

	    	PreparedStatement statement = conn.prepareStatement("insert into Food values(?,?,?)");
	    	statement.setString(1, n);
	    	statement.setString(2, l);
	    	statement.setString(3, t);	    		 	

	    	int i=statement.executeUpdate();
	    	if(i==1)
	    	{
	    		JOptionPane.showMessageDialog(null, "��ӳɹ�","�ɹ�",JOptionPane.ERROR_MESSAGE);
	    	}
       
			conn.close();
	    } 
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println("Sorry,can`t find the Driver!");             
	    	e.printStackTrace();
	    } 
	    catch(SQLException e) 
	    {
	    	e.printStackTrace();
	    } 
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    } 
	}
	//ɾ����Ʒ
	public static void Del_Food(String u) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URLָ��Ҫ���ʵ����ݿ���mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL�����û���                           
		String password = "u201712051";		// MySQL����ʱ������  
		String name;
	    try 
	    {         
	    	Class.forName(driver);// ������������   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�      

	    	PreparedStatement statement = conn.prepareStatement("delete from Food where Food_Name = ?");
	    	statement.setString(1, u);
	    	int i=statement.executeUpdate();
	    	if(i==1)
	    	{
	    		System.out.println("ɾ���ɹ�");
	    		JOptionPane.showMessageDialog(null, "ɾ���ɹ�","�ɹ�",JOptionPane.ERROR_MESSAGE);
	    	}
       
			conn.close();
	    } 
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println("Sorry,can`t find the Driver!");             
	    	e.printStackTrace();
	    } 
	    catch(SQLException e) 
	    {
	    	e.printStackTrace();
	    } 
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    } 
	}
	//����ɾ����Ʒ����������ݿ�
	public static Vector food_table() 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URLָ��Ҫ���ʵ����ݿ���mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL�����û���                           
		String password = "u201712051";		// MySQL����ʱ������  
		Vector sum = new Vector(10,1);
	    try 
	    {         
	    	Class.forName(driver);// ������������   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�         			
	    	PreparedStatement ps = conn.prepareStatement("select * from Food");
	    	ResultSet rs = ps.executeQuery();// ���
	    	
	    	while(rs.next())
	    	{
	    		sum.add(rs.getString(1));
	    	}
	    	
	    	
	    	rs.close();
			conn.close();
			
	    } 
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println("Sorry,can`t find the Driver!");             
	    	e.printStackTrace();
	    } 
	    catch(SQLException e) 
	    {
	    	e.printStackTrace();
	    } 
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    } 
	    return sum;
	}
	
	//�޸Ĳ�Ʒ
		public static void Alter_Food(String u,String l,String t) 
		{
			String driver = "com.mysql.cj.jdbc.Driver";
		    // URLָ��Ҫ���ʵ����ݿ���mydb    
			String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
			String user = "u201712051";     	// MySQL�����û���                           
			String password = "u201712051";		// MySQL����ʱ������  
		    try 
		    {         
		    	Class.forName(driver);// ������������   	       
		    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�      
		    	PreparedStatement statement = conn.prepareStatement("UPDATE Food SET Food_kind = ?,Food_price = ? WHERE Food_Name = ?");   	
		    	statement.setString(1, l);
		    	statement.setString(2, t);
		    	statement.setString(3, u);
		    	int i=statement.executeUpdate();
		    	if(i==1)
		    	{
//		    		System.out.println("�޸ĳɹ�");
		    		JOptionPane.showMessageDialog(null, "�޸ĳɹ�","�ɹ�",JOptionPane.ERROR_MESSAGE);
		    	}
	       
				conn.close();
		    } 
		    catch(ClassNotFoundException e) 
		    {
		    	System.out.println("Sorry,can`t find the Driver!");             
		    	e.printStackTrace();
		    } 
		    catch(SQLException e) 
		    {
		    	e.printStackTrace();
		    } 
		    catch(Exception e) 
		    {
		    	e.printStackTrace();
		    } 
		}
		
		//�ҵĲ�Ʒ
		public static String My_Food() 
		{
			String driver = "com.mysql.cj.jdbc.Driver";
		    // URLָ��Ҫ���ʵ����ݿ���mydb    
			String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
			String user = "u201712051";     	// MySQL�����û���                           
			String password = "u201712051";		// MySQL����ʱ������  
			String sum="";
			
			
		    try 
		    {         
		    	Class.forName(driver);// ������������   	       
		    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�         			
		    	PreparedStatement ps = conn.prepareStatement("select * from Food");
		    	ResultSet rs = ps.executeQuery();// ���
		    	
		    	while(rs.next())
		    	{
		    		sum = rs.getString(1)+"\n"+ sum ;
		    	}
		    	
		    	rs.close();
				conn.close();
				
		    } 
		    catch(ClassNotFoundException e) 
		    {
		    	System.out.println("Sorry,can`t find the Driver!");             
		    	e.printStackTrace();
		    } 
		    catch(SQLException e) 
		    {
		    	e.printStackTrace();
		    } 
		    catch(Exception e) 
		    {
		    	e.printStackTrace();
		    } 
		    return sum;
		}
		public static String MyFood(String n) 
		{
			String driver = "com.mysql.cj.jdbc.Driver";
		    // URLָ��Ҫ���ʵ����ݿ���mydb    
			String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
			String user = "u201712051";     	// MySQL�����û���                           
			String password = "u201712051";		// MySQL����ʱ������  
			String name,kind,price,sum = null;
		    try 
		    {         
		    	Class.forName(driver);// ������������   	       
		    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�         			
		    	PreparedStatement ps = conn.prepareStatement("select * from Food where Food_Name = ?");
		    	ps.setString(1, n);
		    	ResultSet rs = ps.executeQuery();// ���

		    	
		    	rs.next();
	    		name = rs.getString(1) + "\n";
	    		kind = rs.getString(2) + "\n";
	    		price = rs.getString(3) + "\n";
	    		sum = "��Ʒ���֣�"+name+"    "+"��Ʒ���ࣺ"+kind+"    "+"��Ʒ�۸�"+price; 
	    		
		    	
//		    	rs.close();
//		    	r2.close();
//		    	r3.close();
				conn.close();
				
		    } 
		    catch(ClassNotFoundException e) 
		    {
		    	System.out.println("Sorry,can`t find the Driver!");             
		    	e.printStackTrace();
		    } 
		    catch(SQLException e) 
		    {
		    	e.printStackTrace();
		    } 
		    catch(Exception e) 
		    {
		    	e.printStackTrace();
		    } 
		    return sum;
		}
		
	
	
	//����û��Ƿ����
	public static boolean login(String u,String p)
	{
		 boolean flag=false;
	    // ����������           
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URLָ��Ҫ���ʵ����ݿ���mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL�����û���                           
		String password = "u201712051";		// MySQL����ʱ������  
		String name;
	    try 
	    {         
	    	Class.forName(driver);// ������������   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// �������ݿ�    
//	    	if(!conn.isClosed())              
//	    		System.out.println("Succeeded connecting to the Database!");
	    	// statement����ִ��SQL���           
	    	PreparedStatement statement = conn.prepareStatement("select * from UserTable where User_Name=? and User_Password=?");
	    	statement.setString(1, u);
	    	statement.setString(2, p);
	    	          
	    	ResultSet rs = statement.executeQuery();// ����� 
	
			if(rs.next())
			{
				flag=true;
			}
//			System.out.println(flag);

			rs.close();            
			conn.close();
	    } 
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println("Sorry,can`t find the Driver!");             
	    	e.printStackTrace();
	    } 
	    catch(SQLException e) 
	    {
	    	e.printStackTrace();
	    } 
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    } 
	    return flag;
	    
	} 
}
