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
	JLabel User = new JLabel("�������û�����"); //��ǩ
	JLabel Password = new JLabel("���������룺"); 
	JLabel J1 = new JLabel("��ӭע��"); 
	JButton OK = new JButton("ȷ��");//��¼��ť
	JButton Clear = new JButton("ȡ��");//ע�ᰴť
	JTextField UName = new JTextField(20);
	JPasswordField PName = new JPasswordField(20);
	JPanel P1 = new JPanel(); //��������
	JPanel P2 = new JPanel(); 
//	JPanel P3 = new JPanel(); 
	JFrame frame = new JFrame("ע�ᴰ��");
	Register()
	{
		frame.setBounds(450,200,500,400);
		frame.setLayout(null); 
		P1.setBounds(0,0,500,400);
		frame.getContentPane().add(P1);
		P1.setLayout(null);
		J1.setFont(new Font("",1,20));
		J1.setBounds(200,20,100,20);//�����꣬�����꣬����
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
							if(!Mydb.login(User,Pass))//ע��ʧ��
							{
								JOptionPane.showMessageDialog(null, "ע��ʧ��","ʧ��",JOptionPane.ERROR_MESSAGE);
								
							}
							
							frame.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "�û����ظ���","�ظ�",JOptionPane.ERROR_MESSAGE);
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
