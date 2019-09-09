package java_The_Best_Homeworke;
/*
 * Project:校园订餐系统
 * Worker:王继鹏
 * Time:2019/3/6
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Home extends JFrame
{
	JLabel User = new JLabel("请输入用户名："); //标签
	JLabel Password = new JLabel("请输入密码："); 
	JLabel J1 = new JLabel("欢迎使用酒店点菜系统"); 
	JButton Log_in = new JButton("登录");//登录按钮
	JButton Register = new JButton("注册");//注册按钮
	JTextField UName = new JTextField(20);
	JPasswordField PName = new JPasswordField(20);
	JPanel P1 = new JPanel(); //标题容器
	JPanel P2 = new JPanel(); 
//	JPanel P3 = new JPanel(); 
	public boolean temp ;
	JFrame frame;
	Home()
	{
		frame = new JFrame("登陆查看");
		Container content=frame.getContentPane();
//		this.setResizable(false); //不可调节大小
		frame.setBounds(450,200,500,400);
		frame.setLayout(null); 
		P1.setBounds(0,0,500,400);
		content.add(P1);
		P1.setLayout(null);
		J1.setFont(new Font("",1,20));
		J1.setBounds(150,20,390,20);//横坐标，纵坐标，宽，高
		P1.add(J1);
		User.setBounds(100,100,100,20);
		UName.setBounds(250,100,150,25);
		Password.setBounds(100,200,100,20);
		PName.setBounds(250,200,150,25);
		Log_in.setBounds(100,300,100,20);
		Register.setBounds(280,300,100,20); 
		P1.add(User); P1.add(UName);
		P1.add(Password); P1.add(PName);
		P1.add(Log_in); P1.add(Register);
		//P1.setVisible(true);
		Log_in.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
				
					String Pass = new String(PName.getPassword()).trim();
					String User = UName.getText();
					temp = Mydb.login(User,Pass);
					if(temp)
					{
						Two Demo = new Two();
						Demo.Next();
						frame.dispose();
					}
					else
					{ 
		  				JOptionPane.showMessageDialog(null, "您输入的用户不存在","有点问题",JOptionPane.ERROR_MESSAGE);
//						if(n==JOptionPane.OK_OPTION)
//						{
//							System.exit(0);
//						}
					
						UName.setText("");
						PName.setText("");
					}
				}
			
			}
		);
		Register.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					new Register();
					
				}
			
			} 
		);
		frame.setVisible(true);
	}
}

public class Log_in 
{
	public static void main(String[] args) 
	{
		new Home();
		

	}

}
