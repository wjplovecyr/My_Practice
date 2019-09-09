package java_The_Best_Homeworke;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JFrame 
{
	JLabel User = new JLabel("请输入用户名："); //标签
	JLabel Password = new JLabel("请输入密码："); 
	JLabel J1 = new JLabel("欢迎注册"); 
	JButton OK = new JButton("确定");//登录按钮
	JButton Clear = new JButton("取消");//注册按钮
	JTextField UName = new JTextField(20);
	JPasswordField PName = new JPasswordField(20);
	JPanel P1 = new JPanel(); //标题容器
	JPanel P2 = new JPanel(); 
//	JPanel P3 = new JPanel(); 
	JFrame frame = new JFrame("注册窗口");
	Register()
	{
		frame.setBounds(450,200,500,400);
		frame.setLayout(null); 
		P1.setBounds(0,0,500,400);
		frame.getContentPane().add(P1);
		P1.setLayout(null);
		J1.setFont(new Font("",1,20));
		J1.setBounds(200,20,100,20);//横坐标，纵坐标，宽，高
//		J1.setBackground(Color.BLUE);
		P1.add(J1);
		User.setBounds(100,100,100,20);
		UName.setBounds(250,100,150,25);
		Password.setBounds(100,200,100,20);
		PName.setBounds(250,200,150,25);
		OK.setBounds(100,300,100,20);
		Clear.setBounds(280,300,100,20); 
		P1.add(User); P1.add(UName);
		P1.add(Password); P1.add(PName);
		P1.add(OK); P1.add(Clear);
		frame.setVisible(true);
		OK.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						
						
						
						boolean tf = Mydb.cheak("UserTable","User_Name",UName.getText());
						if(tf)
						{
							String Pass = new String(PName.getPassword()).trim();
							String User = UName.getText();
							Mydb.Register(User,Pass);
	//						System.out.println(User+Pass);
							if(!Mydb.login(User,Pass))//注册失败
							{
								JOptionPane.showMessageDialog(null, "注册失败","失败",JOptionPane.ERROR_MESSAGE);
								
							}
							
							frame.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "用户名重复！","重复",JOptionPane.ERROR_MESSAGE);
							UName.setText("");
							PName.setText("");
							
						}
						
						
						
					}
				
				}
		);
		Clear.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						
						frame.dispose();
						
					}
				
				}
		);
		
	}
	public static void main(String[] args) 
	{
		new Register();

	}

}
