package java_The_Best_Homeworke;

import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;
public class Mydb 
{
	
	//注册用户
	public static void Register(String u,String p) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URL指向要访问的数据库名mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL配置用户名                           
		String password = "u201712051";		// MySQL配置时的密码  
		String name;
	    try 
	    {         
	    	Class.forName(driver);// 加载驱动程序   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库      
//	    	System.out.println(u,p);
//	    	if(!conn.isClosed())              
//	    		System.out.println("Succeeded connecting to the Database!");
	    	PreparedStatement statement = conn.prepareStatement("insert into UserTable values(?,?)");
	    	statement.setString(1, u);
	    	statement.setString(2, p);
	    	int i=statement.executeUpdate();
	    	if(i==1)
	    	{
	    		System.out.println("添加OK");
	    		JOptionPane.showMessageDialog(null, "注册成功","成功",JOptionPane.ERROR_MESSAGE);
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
	
	//注销账户
	public static void Cancellation() 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URL指向要访问的数据库名mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL配置用户名                           
		String password = "u201712051";		// MySQL配置时的密码  
		String name;
		String u = null;
	    try 
	    {         
	    	Class.forName(driver);// 加载驱动程序   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库      
//	    	System.out.println(u,p);
//	    	if(!conn.isClosed())              
//	    		System.out.println("Succeeded connecting to the Database!");
	    			
	    	PreparedStatement ps = conn.prepareStatement("select * from UserTable");
	    	ResultSet rs = ps.executeQuery();// 结果集 
	    	while(rs.next())
	    	{
				u=rs.getString("User_Name");
			}
	    	PreparedStatement statement = conn.prepareStatement("delete from UserTable where User_Name = ?");
	    	statement.setString(1, u);
	    	
	    	

	    	int i=statement.executeUpdate();
	    	if(i==1)
	    	{
	    		System.out.println("删除成功");
	    		JOptionPane.showMessageDialog(null, "注销成功","成功",JOptionPane.ERROR_MESSAGE);
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
	
	
	//检测是否存在
	public static boolean cheak(String TN,String N,String PN) //表名、列名、主键数据名
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URL指向要访问的数据库名mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL配置用户名                           
		String password = "u201712051";		// MySQL配置时的密码  
		boolean flag = true; 
		String sql;
	    try 
	    {         
	    	Class.forName(driver);// 加载驱动程序   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库      
    			
//	    	PreparedStatement ps = conn.prepareStatement("select ? from ? ");
//	    	ps.setString(1,N);
//	    	ps.setString(2,TN);
	    	PreparedStatement ps = conn.prepareStatement("select "+N+" from "+TN);
	    	ResultSet rs = ps.executeQuery();// 结果集 
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
	
	
	//增加店铺
	public static void add_shop(String n,String l,String t,String a) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URL指向要访问的数据库名mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL配置用户名                           
		String password = "u201712051";		// MySQL配置时的密码  
		String u = null;
	    try 
	    {         
	    	Class.forName(driver);// 加载驱动程序   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库      
//	    	System.out.println(u,p);
//	    	if(!conn.isClosed())               
//	    		System.out.println("Succeeded connecting to the Database!");
	    			
//	    	PreparedStatement ps = conn.prepareStatement("");
//	    	ResultSet rs = ps.executeQuery();// 结果集 
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
	    		JOptionPane.showMessageDialog(null, "添加成功","成功",JOptionPane.ERROR_MESSAGE);
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
	
	
	
	//删除店铺
	public static void Del_shop(String u) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URL指向要访问的数据库名mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL配置用户名                           
		String password = "u201712051";		// MySQL配置时的密码  
		String name;
	    try 
	    {         
	    	Class.forName(driver);// 加载驱动程序   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库      

	    	PreparedStatement statement = conn.prepareStatement("delete from Shop where Shop_Name = ?");
	    	statement.setString(1, u);
	    	int i=statement.executeUpdate();
	    	if(i==1)
	    	{
	    		System.out.println("删除成功");
	    		JOptionPane.showMessageDialog(null, "删除成功","成功",JOptionPane.ERROR_MESSAGE);
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
	//修改店铺
	public static void Alter(String u,String l,String t) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URL指向要访问的数据库名mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL配置用户名                           
		String password = "u201712051";		// MySQL配置时的密码  
	    try 
	    {         
	    	Class.forName(driver);// 加载驱动程序   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库      
	    	PreparedStatement statement = conn.prepareStatement("UPDATE Shop SET Shop_Local = ?,Shop_Tell = ? WHERE Shop_Name = ?");   	
	    	statement.setString(1, l);
	    	statement.setString(2, t);
	    	statement.setString(3, u);
	    	int i=statement.executeUpdate();
	    	if(i==1)
	    	{
//	    		System.out.println("修改成功");
	    		JOptionPane.showMessageDialog(null, "修改成功","成功",JOptionPane.ERROR_MESSAGE);
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
	
	//我的收藏
	public static String My_Shop() 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URL指向要访问的数据库名mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL配置用户名                           
		String password = "u201712051";		// MySQL配置时的密码  
		String sum="";
	    try 
	    {         
	    	Class.forName(driver);// 加载驱动程序   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库         			
	    	PreparedStatement ps = conn.prepareStatement("select * from Shop");
	    	ResultSet rs = ps.executeQuery();// 结果
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
	
	//增加删除店铺表格连接数据库
	public static Vector shop_table() 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URL指向要访问的数据库名mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL配置用户名                           
		String password = "u201712051";		// MySQL配置时的密码  
		Vector sum = new Vector(10,1);
	    try 
	    {         
	    	Class.forName(driver);// 加载驱动程序   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库         			
	    	PreparedStatement ps = conn.prepareStatement("select * from Shop");
	    	ResultSet rs = ps.executeQuery();// 结果
	    	
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
	    // URL指向要访问的数据库名mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL配置用户名                           
		String password = "u201712051";		// MySQL配置时的密码  
		String name,local,tell,sum = null;
	    try 
	    {         
	    	Class.forName(driver);// 加载驱动程序   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库         			
	    	PreparedStatement ps = conn.prepareStatement("select * from Shop where Shop_Name = ?");
	    	ps.setString(1, n);
	    	ResultSet rs = ps.executeQuery();// 结果

	    	
	    	rs.next();
    		name = rs.getString(1) + "\n";
    		local = rs.getString(2) + "\n";
    		tell = rs.getString(3) + "\n";
    		sum = "店铺名字："+name+"    "+"店铺位置："+local+"    "+"店铺电话："+tell; 
    		
	    	
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
	//增加菜品
	public static void add_Food(String n,String l,String t) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URL指向要访问的数据库名mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL配置用户名                           
		String password = "u201712051";		// MySQL配置时的密码  
		String u = null;
	    try 
	    {         
	    	Class.forName(driver);// 加载驱动程序   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库      

	    	PreparedStatement statement = conn.prepareStatement("insert into Food values(?,?,?)");
	    	statement.setString(1, n);
	    	statement.setString(2, l);
	    	statement.setString(3, t);	    		 	

	    	int i=statement.executeUpdate();
	    	if(i==1)
	    	{
	    		JOptionPane.showMessageDialog(null, "添加成功","成功",JOptionPane.ERROR_MESSAGE);
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
	//删除菜品
	public static void Del_Food(String u) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URL指向要访问的数据库名mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL配置用户名                           
		String password = "u201712051";		// MySQL配置时的密码  
		String name;
	    try 
	    {         
	    	Class.forName(driver);// 加载驱动程序   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库      

	    	PreparedStatement statement = conn.prepareStatement("delete from Food where Food_Name = ?");
	    	statement.setString(1, u);
	    	int i=statement.executeUpdate();
	    	if(i==1)
	    	{
	    		System.out.println("删除成功");
	    		JOptionPane.showMessageDialog(null, "删除成功","成功",JOptionPane.ERROR_MESSAGE);
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
	//增加删除菜品表格连接数据库
	public static Vector food_table() 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URL指向要访问的数据库名mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL配置用户名                           
		String password = "u201712051";		// MySQL配置时的密码  
		Vector sum = new Vector(10,1);
	    try 
	    {         
	    	Class.forName(driver);// 加载驱动程序   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库         			
	    	PreparedStatement ps = conn.prepareStatement("select * from Food");
	    	ResultSet rs = ps.executeQuery();// 结果
	    	
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
	
	//修改菜品
		public static void Alter_Food(String u,String l,String t) 
		{
			String driver = "com.mysql.cj.jdbc.Driver";
		    // URL指向要访问的数据库名mydb    
			String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
			String user = "u201712051";     	// MySQL配置用户名                           
			String password = "u201712051";		// MySQL配置时的密码  
		    try 
		    {         
		    	Class.forName(driver);// 加载驱动程序   	       
		    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库      
		    	PreparedStatement statement = conn.prepareStatement("UPDATE Food SET Food_kind = ?,Food_price = ? WHERE Food_Name = ?");   	
		    	statement.setString(1, l);
		    	statement.setString(2, t);
		    	statement.setString(3, u);
		    	int i=statement.executeUpdate();
		    	if(i==1)
		    	{
//		    		System.out.println("修改成功");
		    		JOptionPane.showMessageDialog(null, "修改成功","成功",JOptionPane.ERROR_MESSAGE);
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
		
		//我的菜品
		public static String My_Food() 
		{
			String driver = "com.mysql.cj.jdbc.Driver";
		    // URL指向要访问的数据库名mydb    
			String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
			String user = "u201712051";     	// MySQL配置用户名                           
			String password = "u201712051";		// MySQL配置时的密码  
			String sum="";
			
			
		    try 
		    {         
		    	Class.forName(driver);// 加载驱动程序   	       
		    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库         			
		    	PreparedStatement ps = conn.prepareStatement("select * from Food");
		    	ResultSet rs = ps.executeQuery();// 结果
		    	
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
		    // URL指向要访问的数据库名mydb    
			String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
			String user = "u201712051";     	// MySQL配置用户名                           
			String password = "u201712051";		// MySQL配置时的密码  
			String name,kind,price,sum = null;
		    try 
		    {         
		    	Class.forName(driver);// 加载驱动程序   	       
		    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库         			
		    	PreparedStatement ps = conn.prepareStatement("select * from Food where Food_Name = ?");
		    	ps.setString(1, n);
		    	ResultSet rs = ps.executeQuery();// 结果

		    	
		    	rs.next();
	    		name = rs.getString(1) + "\n";
	    		kind = rs.getString(2) + "\n";
	    		price = rs.getString(3) + "\n";
	    		sum = "菜品名字："+name+"    "+"菜品种类："+kind+"    "+"菜品价格："+price; 
	    		
		    	
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
		
	
	
	//监测用户是否存在
	public static boolean login(String u,String p)
	{
		 boolean flag=false;
	    // 驱动程序名           
		String driver = "com.mysql.cj.jdbc.Driver";
	    // URL指向要访问的数据库名mydb    
		String url="jdbc:mysql://210.30.108.222:3306/u201712051?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";	
		String user = "u201712051";     	// MySQL配置用户名                           
		String password = "u201712051";		// MySQL配置时的密码  
		String name;
	    try 
	    {         
	    	Class.forName(driver);// 加载驱动程序   	       
	    	Connection conn = DriverManager.getConnection(url, user, password);// 连接数据库    
//	    	if(!conn.isClosed())              
//	    		System.out.println("Succeeded connecting to the Database!");
	    	// statement用来执行SQL语句           
	    	PreparedStatement statement = conn.prepareStatement("select * from UserTable where User_Name=? and User_Password=?");
	    	statement.setString(1, u);
	    	statement.setString(2, p);
	    	          
	    	ResultSet rs = statement.executeQuery();// 结果集 
	
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
