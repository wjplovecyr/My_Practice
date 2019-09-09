package java_The_Best_Homeworke;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.Vector;


class Two extends JFrame implements ActionListener
{
	JMenuBar JM;//菜单栏
	JMenu M1,M2,M3;//菜单选项
	JMenuItem t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	JMenuItem t[] = {t1,t2,t3,t4,t5,t6,t7,t8,t9,t10};//选项卡
	
	JButton btn1,btn2,btn3,btn4;//店铺增添，删除，修改，我的收藏
	JButton btn5,btn6,btn7,btn8;//菜品增添，删除，修改，我的收藏
	
	JLabel First;//开始
	JLabel Name1,Sp,Tell,Hello,add_mistake1,add_mistake2,area;//增添标签
	JLabel Name2,Del,del_mistake,Select1,shop1;//删除标签
	JLabel Name3,Sp3,Tell3,Re,Ps1,re_mistake1,re_mistake2,shop_sel;//修改标签
	JLabel Me,Find,Result,list1,My_mistake;//我的收藏标签
	JLabel Name11,Kind1,Price1,Top1,add2_mistake1,add2_mistake2;//增添菜品标签
	JLabel Name22,Top2,del2_mistake,Select2,food;//删除菜品标签
	JLabel Name33,Kind3,Price3,Top3,Ps2,re2_mistake1,re2_mistake2,food_sel;//修改菜品标签
	JLabel Me2,Find2,Result2,list2,My2_mistake;//我的收藏标签
	
	JTextField N1,S,T;//增添文本
	JTextField N2;//删除文本
	JTextField N3,S3,T3;//修改文本
	JTextField find;//我的收藏文本	
	JTextArea All;//我的收藏文本框
	JTextField N11,P11,K11;//增添菜品文本
	JTextField N22;//删除菜品文本
	JTextField N33,P33,K33;//修改菜品文本
	JTextField find2;//我的收藏文本	
	JTextArea All2;//我的收藏文本框
	
	JTable shop_table;//店铺表
	JTable food_table;//食物表
	JTable shop_table1;//修改店铺表
	JTable food_table1;//修改菜品表
	
	

	//面板容器
	JPanel P1 = new JPanel(); 
	JPanel P2 = new JPanel(); 
	JPanel P3 = new JPanel(); 
	JPanel P4 = new JPanel();
	JPanel P5 = new JPanel();
	JPanel P6 = new JPanel();
	JPanel P7 = new JPanel();
	JPanel P8 = new JPanel();
	JPanel n=P1;//上一个点开页面
	
	public void Next()
	{
		this.setBounds(350,20,700,700);
		//this.setLayout(new FlowLayout());
//		this.getContentPane().add(P1);
//		this.getContentPane().add(P2);
		//设置菜单栏
		JM = new JMenuBar();
		this.setLayout(null);//设置布局为空布局
		this.add(JM);
		JM.setBounds(0,0,2500,30);
		M1 = new JMenu("我喜爱的店铺");
		M2 = new JMenu("我喜爱的菜品");
		M3 = new JMenu("退出");
		t[0] = new JMenuItem("添加店铺");
		t[1] = new JMenuItem("删除店铺");
		t[2] = new JMenuItem("修改店铺");
		t[3] = new JMenuItem("我的收藏");
		
		t[4] = new JMenuItem("添加菜品");
		t[5] = new JMenuItem("删除菜品");
		t[6] = new JMenuItem("修改菜品");
		t[7] = new JMenuItem("我的收藏");
		
		t[8] = new JMenuItem("不定了");
		t[9] = new  JMenuItem("注销用户");
		JM.add(M1);	JM.add(M2);	JM.add(M3);
		M1.add(t[0]);	M1.add(t[1]);	M1.add(t[2]);	M1.add(t[3]);
		M2.add(t[4]);	M2.add(t[5]);	M2.add(t[6]);	M2.add(t[7]);
		M3.add(t[8]);	M3.add(t[9]);
		//this.getContentPane().setLayout(new FlowLayout());
		First = new JLabel("感谢您使用本套订餐系统");
		this.getContentPane().add(First);
		First.setFont(new Font("",1,30));
		First.setBounds(170,200,500,100);
		
		
		this.getContentPane().add(P1);//增添页面
		P1.setBounds(0,30,700,670);
//		P1.setBackground(Color.gray);
		P1.setLayout(null);
		
		this.getContentPane().add(P2);//删除页面
		P2.setBounds(0,30,700,670);
//		P1.setBackground(Color.gray);
		P2.setLayout(null);
		
		this.getContentPane().add(P3);//修改页面
		P3.setBounds(0,30,700,670);
//		P1.setBackground(Color.gray);
		P3.setLayout(null);

		this.getContentPane().add(P4);//我的收藏页面
		P4.setBounds(0,30,700,670);
//		P1.setBackground(Color.gray);
		P4.setLayout(null);
		
		this.getContentPane().add(P5);//添加菜品页面
		P5.setBounds(0,30,700,670);
//		P1.setBackground(Color.gray);
		P5.setLayout(null);
		
		this.getContentPane().add(P6);//删除菜品页面
		P6.setBounds(0,30,700,670);
//		P1.setBackground(Color.gray);
		P6.setLayout(null);
		
		this.getContentPane().add(P7);//修改菜品页面
		P7.setBounds(0,30,700,670);
//		P1.setBackground(Color.gray);
		P7.setLayout(null);
		
		this.getContentPane().add(P8);//我的菜品页面
		P8.setBounds(0,30,700,670);
//		P1.setBackground(Color.gray);
		P8.setLayout(null);
		
		
		//令面板不可见
		P1.setVisible(false);
		P2.setVisible(false);
		P3.setVisible(false);
		P4.setVisible(false);
		P5.setVisible(false);
		P6.setVisible(false);
		P7.setVisible(false);
		P8.setVisible(false);
		
		
//		JLabel lblImage1 = new JLabel(new ImageIcon("C:\\Users\\35351\\Pictures\\d1048982.jpg"));    //创建一个带图片的 JLabel
//		lblImage1.setBounds(0, 0, P1.getWidth(), P1.getHeight());    //设置 图片的横坐标、纵坐标、宽、高
//		P1.add(lblImage1);    //放置这个 JLabel 到你的 JPanel 上面
//		lblImage1.setOpaque(false);
//添加图片
		ImageIcon img=new ImageIcon("E:/java_The_Best_Homeworke/src/e344170e544938bdb355de35afd3f267.gif");
		JLabel imgLabel=new JLabel(img);
		imgLabel.setBounds(250,300,100,100);
		this.getContentPane().setBackground(Color.WHITE);
		this.add(imgLabel);
		
		ImageIcon img2=new ImageIcon("E:/java_The_Best_Homeworke/src/179866361514009911.png");	
		JLabel imgLabel2=new JLabel(img2);
		imgLabel2.setBounds(400,330,50,50);
		this.add(imgLabel2);
		
		ImageIcon img3=new ImageIcon("E:/java_The_Best_Homeworke/src/703737403660019529.png");
		JLabel imgLabel3=new JLabel(img3);
		imgLabel3.setBounds(330,330,60,50);
		this.add(imgLabel3);
		
		ImageIcon img4=new ImageIcon("E:/java_The_Best_Homeworke/src/110489704975840860.png");
		JLabel imgLabel4=new JLabel(img4);
		imgLabel4.setBounds(460,330,50,50);
		this.add(imgLabel4);
		
		
		
		//加每一页的动图
		JLabel imgLabel_1 = null,imgLabel_2 = null,imgLabel_3 = null,imgLabel_4 = null,imgLabel_5 = null,imgLabel_6 = null,imgLabel_7 = null,imgLabel_8 = null;

		insert(imgLabel_1,P1);
		insert(imgLabel_2,P2);
		insert(imgLabel_3,P3);
		insert(imgLabel_4,P4);
		insert(imgLabel_5,P5);
		insert(imgLabel_6,P6);
		insert(imgLabel_7,P7);
		insert(imgLabel_8,P8);
		

		//增加店铺组件布局
		Name1 = new JLabel("店铺名称：");
		Name1.setBounds(100,100,100,50);
		Sp = new JLabel("店铺位置：");
		Sp.setBounds(100,200,100,50);
		Tell = new JLabel("店铺电话：");
		Tell.setBounds(100,300,100,50);
		area = new JLabel("面积大小：");
		area.setBounds(100,400,100,50);
		
		N1 = new JTextField(10);
		N1.setBounds(300,110,200,30);
		S = new JTextField(10);
		S.setBounds(300,210,200,30);
		T = new JTextField(10);
		T.setBounds(300,310,200,30);
		JTextField Area1 = new JTextField(10);
		Area1.setBounds(300,410,200,30);
		
		add_mistake1= new JLabel("店铺名重复！");
		add_mistake1.setBounds(550,110,100,30);
		add_mistake1.setForeground(Color.RED);
		add_mistake1.setVisible(false);
		add_mistake2= new JLabel("输入格式有误！");
		add_mistake2.setBounds(550,310,100,30);
		add_mistake2.setForeground(Color.RED);
		add_mistake2.setVisible(false);
		Hello = new JLabel("请输入您要增添的店铺");
		Hello.setBounds(230,30,300,50);//横坐标，纵坐标，宽，高
		Hello.setFont(new Font("",1,15));
		btn1 = new JButton("确定添加");
		btn1.setBounds(500,500,100,40);	
		
		P1.add(Hello);
		//Hello.setBounds(250,300,40,40);
		P1.add(Name1);	P1.add(N1);
		P1.add(Sp);		P1.add(S);
		P1.add(Tell);	P1.add(T);
		P1.add(btn1); 	P1.add(add_mistake1);
		P1.add(add_mistake2);
		P1.add(area);	P1.add(Area1);
		btn1.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					add_mistake1.setVisible(false);
					add_mistake2.setVisible(false);
					boolean tf = Mydb.cheak("Shop","Shop_Name",N1.getText());
					if(tf)
					{
						if(isNumeric(T.getText()))
						{
							Mydb.add_shop(N1.getText(),S.getText(),T.getText(),Area1.getText());
			  				N1.setText("");
			  				S.setText("");
			  				T.setText("");
			  				Area1.setText("");
						}
						else
						{
							add_mistake2.setVisible(true);
						}
					}
					else
					{
						add_mistake1.setVisible(true);
					}
				
	  				
				}
			}
			
		);
		
		
		
		//删除店铺组件布局
		Del = new JLabel("请输入需要删除的店铺名称");
		Del.setBounds(230,30,300,50);
		Del.setFont(new Font("",1,15));
		btn2 = new JButton("确定删除");
		btn2.setBounds(500,500,100,40);	
		Name2 = new JLabel("店铺名称：");
		Name2.setBounds(100,100,100,50);
		N2 = new JTextField(10);
		N2.setBounds(300,110,200,30);
//		Select1 = new JLabel("");
//		Select1.setBounds(300,100,200,200);
		shop1 = new JLabel("已存在的店铺：");
		shop1.setBounds(100,100,200,200);
		
//		Vector content = new Vector();
//		Vector column = new Vector();
		
//		column.add("已存在店铺");
//		TableColumnModel column=new DefaultTableColumnModel("已存在店铺");
		String[][] datas = {};
	    String[] titles = { "已存在店铺"};
		DefaultTableModel model = new DefaultTableModel(datas,titles);
		
		
		shop_table = new JTable(model);
		shop_table.setBounds(250,200,200,200);
		
		P2.add(Del);
		P2.add(Name2);
		P2.add(N2);
		P2.add(btn2);
//		P2.add(Select1);
		P2.add(shop1);
		P2.add(shop_table);
		
		
		
		t[1].addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					
					DefaultTableModel model =(DefaultTableModel) shop_table.getModel();
					while(model.getRowCount()>0){
					model.removeRow(model.getRowCount()-1);
					}
//					model.addColumn("已存在店铺");
					for(int i=0;i<Mydb.shop_table().size();i++)
					{
						model.addRow(new Object[] {Mydb.shop_table().get(i)});
					}
	  				
				}
			}
			
		);
		btn2.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					if(!Mydb.cheak("Shop","Shop_Name",N2.getText()))
					{	
						int n =JOptionPane.showConfirmDialog(null, "你确定删除吗?","删除！",JOptionPane.OK_CANCEL_OPTION);
						if(n==JOptionPane.OK_OPTION)
						{
							Mydb.Del_shop(N2.getText());
							N2.setText("");
						}
					}	
					else
					{
						JOptionPane.showMessageDialog(null, "您要删除的数据不存在！","错误",JOptionPane.ERROR_MESSAGE);
						N2.setText("");
					}
	  				
				}
			}
			
		);
		
		shop_table.getSelectionModel().addListSelectionListener
		(
			new ListSelectionListener() 
			{
				public void valueChanged(ListSelectionEvent e) 
				{
	                if (!e.getValueIsAdjusting()) 
	                {
	                    //支持拖动多选
	                    int[] rows = shop_table.getSelectedRows();
	                    // int[] cols = table.getSelectedColumns();//选中的列
	                    for (int i : rows) 
	                    {
	                    	N2.setText(shop_table.getValueAt(i, 0)+"");
	                    }
	                     
	                    //支持单选
//	                  int row=table.getSelectedRow();//选中行
//	                  //int col=table.getSelectedColumn();//选中列
//	                  System.out.println("方法一:"+table.getValueAt(row, 0)+"\t"+table.getValueAt(row, 1));
	                }
				}
			}
		);
		//修改店铺组件布局
		Re = new JLabel("请输入需要修改的店铺名称");
		Re.setBounds(230,30,300,50);
		Re.setFont(new Font("",1,15));

		Name3 = new JLabel("店铺名称：");
		Name3.setBounds(100,100,100,50);
		Ps1 = new JLabel("请输入需要修改的信息");
		Ps1.setFont(new Font("",1,15));
		Ps1.setBounds(245,150,300,50);
		Sp3 = new JLabel("店铺位置：");
		Sp3.setBounds(100,200,100,50);
		Tell3 = new JLabel("店铺电话：");
		Tell3.setBounds(100,300,100,50);
		shop_sel = new JLabel("已存在店铺:");
		shop_sel.setBounds(100,400,100,50);
		
		re_mistake1= new JLabel("店铺不存在！");
		re_mistake1.setBounds(550,110,100,30);
		re_mistake1.setForeground(Color.RED);
		re_mistake1.setVisible(false);
		re_mistake2= new JLabel("输入格式有误！");
		re_mistake2.setBounds(550,310,100,30);
		re_mistake2.setForeground(Color.RED);
		re_mistake2.setVisible(false);
		N3 = new JTextField(10);
		N3.setBounds(300,110,200,30);
		S3 = new JTextField(10);
		S3.setBounds(300,210,200,30);
		T3 = new JTextField(10);
		T3.setBounds(300,310,200,30);
		

		btn3 = new JButton("确定修改");
		btn3.setBounds(500,500,100,40);	
		
		
		String[][] datas2 = {};
	    String[] titles2 = { "已存在店铺"};
		DefaultTableModel model2 = new DefaultTableModel(datas2,titles2);
		
		
		shop_table1 = new JTable(model2);
		

		P3.add(Re);
		//Hello.setBounds(250,300,40,40);
		P3.add(Name3);	P3.add(N3);
		P3.add(Sp3);	P3.add(S3);
		P3.add(Tell3);	P3.add(T3);
		P3.add(btn3); 	P3.add(Ps1);
		P3.add(re_mistake1);
		P3.add(re_mistake2);
		P3.add(shop_sel);
		
		P3.add(shop_table1);
		shop_table1.setBounds(200,420,200,200);
		
		t[2].addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					
					DefaultTableModel model2 =(DefaultTableModel) shop_table1.getModel();
					while(model2.getRowCount()>0){
					model2.removeRow(model2.getRowCount()-1);
					}
//					model.addColumn("已存在店铺");
					for(int i=0;i<Mydb.shop_table().size();i++)
					{
						model2.addRow(new Object[] {Mydb.shop_table().get(i)});
					}
	  				
				}
			}
			
		);
		
		btn3.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					re_mistake1.setVisible(false);
					re_mistake2.setVisible(false);
					boolean tf = Mydb.cheak("Shop","Shop_Name",N3.getText());
					if(!tf)
					{
						
						if(isNumeric(T3.getText()))
						{
							int n =JOptionPane.showConfirmDialog(null, "你确定修改吗?","修改！",JOptionPane.OK_CANCEL_OPTION);
							if(n==JOptionPane.OK_OPTION)
							{
								Mydb.Alter(N3.getText(),S3.getText(),T3.getText());
				  				N3.setText("");
				  				S3.setText("");
				  				T3.setText("");
							}
						}
						else
						{
							re_mistake2.setVisible(true);
						}
					}
					else
					{
						re_mistake1.setVisible(true);
					}
				
					
	  				
				}
			}
			
		);
		
		shop_table1.getSelectionModel().addListSelectionListener
		(
			new ListSelectionListener() 
			{
				public void valueChanged(ListSelectionEvent e) 
				{
	                if (!e.getValueIsAdjusting()) 
	                {
	                    
	                    int[] rows = shop_table1.getSelectedRows();
	                    
	                    for (int i : rows) 
	                    {
	                    	N3.setText(shop_table1.getValueAt(i, 0)+"");
	                    }
	                     
	                }
				}
			}
		);
		
		//增加我的收藏组件Me,Find,Result
		Me = new JLabel("我的收藏");
		Me.setBounds(300,30,100,50);
		Me.setFont(new Font("",1,15));
		list1 = new JLabel("店铺列表");
		list1.setBounds(150,45,100,50);
		Me.setForeground(new Color(200,20,20));
		Find = new JLabel("请输入您需要查询的店铺名称");
		Find.setBounds(150,300,200,50);
		My_mistake = new JLabel("你输入的店铺不存在!");
		My_mistake.setForeground(Color.red);
		My_mistake.setBounds(350, 300, 200, 50);
		My_mistake.setVisible(false);
		Result = new JLabel("");
		Result.setBounds(150,400,400,50);
		
		
		find = new JTextField(10);
		find.setBounds(150,350,350,40);
		All = new JTextArea();
		All.setBounds(150,100,350,200);
		
		btn4 = new JButton("开始查询");
		btn4.setBounds(550,350,100,40);
		
		P4.add(Me);		P4.add(Find);
		P4.add(Result);	P4.add(find);
		P4.add(All);	P4.add(btn4);
		P4.add(list1);	P4.add(My_mistake);
		
		
		btn4.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					Result.setText("");
					boolean tf = Mydb.cheak("Shop","Shop_Name",find.getText());
					if(!tf)
					{
						Result.setText(Mydb.MyShop(find.getText()));
					}
					else
					{
						My_mistake.setVisible(true);
					}
				}
			}
			
		);
		
		//增加菜品组件布局
		Name11 = new JLabel("菜品名称：");
		Name11.setBounds(100,100,100,50);
		Kind1 = new JLabel("菜品种类：");
		Kind1.setBounds(100,200,100,50);
		Price1 = new JLabel("菜品价格：");
		Price1.setBounds(100,300,100,50);
		
		N11 = new JTextField(10);
		N11.setBounds(300,110,200,30);
		K11 = new JTextField(10);
		K11.setBounds(300,210,200,30);
		P11 = new JTextField(10);
		P11.setBounds(300,310,200,30);
		add2_mistake1= new JLabel("菜品名重复！");
		add2_mistake1.setBounds(550,110,100,30);
		add2_mistake1.setForeground(Color.RED);
		add2_mistake1.setVisible(false);
		add2_mistake2= new JLabel("输入格式有误！");
		add2_mistake2.setBounds(550,310,100,30);
		add2_mistake2.setForeground(Color.RED);
		add2_mistake2.setVisible(false);
		
		Top1 = new JLabel("请输入您要增添的菜品");
		Top1.setBounds(230,30,300,50);//横坐标，纵坐标，宽，高
		Top1.setFont(new Font("",1,15));
		btn5 = new JButton("确定添加");
		btn5.setBounds(500,500,100,40);	
		
		
		P5.add(Top1);
		//Hello.setBounds(250,300,40,40);
		P5.add(Name11);	P5.add(N11);
		P5.add(Kind1);	P5.add(K11);
		P5.add(Price1);	P5.add(P11);
		P5.add(btn5); 	P5.add(add2_mistake1);
		P5.add(add2_mistake2);
		

		btn5.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					add2_mistake1.setVisible(false);
					add2_mistake2.setVisible(false);
					boolean tf = Mydb.cheak("Food","Food_Name",N11.getText());
					if(tf)
					{
						
						if((P11.getText().indexOf(".")!=-1) || isNumeric(P11.getText()))
						{
							
							Mydb.add_Food(N11.getText(),K11.getText(),P11.getText());
			  				N11.setText("");
			  				K11.setText("");
			  				P11.setText("");
						}
						else
						{
							add2_mistake2.setVisible(true);
						}
					}
					else
					{
						add2_mistake1.setVisible(true);
					}
	  				
				}
			}
			
		);


		
		//增加删除菜品组件
		Top2 = new JLabel("请输入需要删除的菜品名称");
		Top2.setBounds(230,30,300,50);
		Top2.setFont(new Font("",1,15));
		btn6 = new JButton("确定删除");
		btn6.setBounds(500,500,100,40);	
		Name22 = new JLabel("菜品名称：");
		Name22.setBounds(100,100,100,50);
		N22 = new JTextField(10);
		N22.setBounds(300,110,200,30);

		
		String[][] datas1 = {};
	    String[] titles1 = { "已存在菜品"};
		DefaultTableModel model1 = new DefaultTableModel(datas1,titles1);
		food_table = new JTable(model1);
		food_table.setBounds(250,200,200,200);
		
		food = new JLabel("已存在的菜品：");
		food.setBounds(100,100,200,200);
		P6.add(food_table);
		P6.add(food);
		P6.add(Top2);
		P6.add(btn6);
		P6.add(Name22);
		P6.add(N22);
		
		t[5].addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					DefaultTableModel model1 =(DefaultTableModel) food_table.getModel();
					while(model1.getRowCount()>0){
					model1.removeRow(model1.getRowCount()-1);
					}
					for(int i=0;i<Mydb.shop_table().size();i++)
					{
						model1.addRow(new Object[] {Mydb.food_table().get(i)});
					}
	  				
				}
			}
			
		);
		
		btn6.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					if(!Mydb.cheak("Food","Food_Name",N22.getText()))
					{
						int n =JOptionPane.showConfirmDialog(null, "你确定删除吗?","删除！",JOptionPane.OK_CANCEL_OPTION);
						if(n==JOptionPane.OK_OPTION)
						{
							Mydb.Del_Food(N22.getText());
							N22.setText("");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "您要删除的数据不存在！","错误",JOptionPane.ERROR_MESSAGE);
						N22.setText("");
					}
					
	  				
				}
			}
			
		);
		food_table.getSelectionModel().addListSelectionListener
		(
			new ListSelectionListener() 
			{
				public void valueChanged(ListSelectionEvent e) 
				{
	                if (!e.getValueIsAdjusting()) 
	                {
	                    
	                    int[] rows = food_table.getSelectedRows();
	                    
	                    for (int i : rows) 
	                    {
	                    	N22.setText(food_table.getValueAt(i, 0)+"");
	                    }
	                     
	                }
				}
			}
		);
		
		//修改菜品组件增加
		Top3 = new JLabel("请输入需要修改的菜品名称");
		Top3.setBounds(230,30,300,50);
		Top3.setFont(new Font("",1,15));

		Name33 = new JLabel("菜品名称：");
		Name33.setBounds(100,100,100,50);
		Ps2 = new JLabel("请输入需要修改的信息");
		Ps2.setFont(new Font("",1,15));
		Ps2.setBounds(245,150,300,50);
		Kind3 = new JLabel("菜品种类：");
		Kind3.setBounds(100,200,100,50);
		Price3 = new JLabel("菜品价格：");
		Price3.setBounds(100,300,100,50);
		food_sel = new JLabel("已存在菜品:");
		food_sel.setBounds(100,400,100,50);
		
		re2_mistake1= new JLabel("菜品不存在！");
		re2_mistake1.setBounds(550,110,100,30);
		re2_mistake1.setForeground(Color.RED);
		re2_mistake1.setVisible(false);
		re2_mistake2= new JLabel("输入格式有误！");
		re2_mistake2.setBounds(550,310,100,30);
		re2_mistake2.setForeground(Color.RED);
		re2_mistake2.setVisible(false);
		
		N33 = new JTextField(10);
		N33.setBounds(300,110,200,30);
		K33 = new JTextField(10);
		K33.setBounds(300,210,200,30);
		P33 = new JTextField(10);
		P33.setBounds(300,310,200,30);
		

		btn7 = new JButton("确定修改");
		btn7.setBounds(500,500,100,40);	
		
		

		String[][] datas3 = {};
	    String[] titles3 = { "已存在菜品"};
		DefaultTableModel model3 = new DefaultTableModel(datas3,titles3);
		
		
		food_table1 = new JTable(model3);
		
		P7.add(Top3);
		//Hello.setBounds(250,300,40,40);
		P7.add(Name33);	P7.add(N33);
		P7.add(Kind3);	P7.add(K33);
		P7.add(Price3);	P7.add(P33);
		P7.add(btn7); 	P7.add(Ps2);
		P7.add(re2_mistake1);P7.add(re2_mistake2);
		P7.add(food_sel);
		P7.add(food_table1);
		food_table1.setBounds(200,420,200,200);
		
		t[6].addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					
					DefaultTableModel model3 =(DefaultTableModel) food_table1.getModel();
					while(model3.getRowCount()>0){
					model3.removeRow(model3.getRowCount()-1);
					}
//					model.addColumn("已存在店铺");
					for(int i=0;i<Mydb.food_table().size();i++)
					{
						model3.addRow(new Object[] {Mydb.food_table().get(i)});
					}
	  				
				}
			}
			
		);
		btn7.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					re2_mistake1.setVisible(false);
					re2_mistake2.setVisible(false);
					boolean tf = Mydb.cheak("Food","Food_Name",N33.getText());
					if(!tf)
					{
						
						if(isNumeric(P33.getText()) || P33.getText().indexOf(".")!=-1)
						{
							int n =JOptionPane.showConfirmDialog(null, "你确定修改吗?","修改！",JOptionPane.OK_CANCEL_OPTION);
							if(n==JOptionPane.OK_OPTION)
							{
								Mydb.Alter_Food(N33.getText(),K33.getText(),P33.getText());
								N33.setText("");
								K33.setText("");
								P33.setText("");
							}
						}
						else
						{
							re2_mistake2.setVisible(true);
						}
					}
					else
					{
						re2_mistake1.setVisible(true);
					}
					
	  				
				}
			}
			
		);
		
		food_table1.getSelectionModel().addListSelectionListener
		(
			new ListSelectionListener() 
			{
				public void valueChanged(ListSelectionEvent e) 
				{
	                if (!e.getValueIsAdjusting()) 
	                {
	                    
	                    int[] rows = food_table1.getSelectedRows();
	                    
	                    for (int i : rows) 
	                    {
	                    	N33.setText(food_table1.getValueAt(i, 0)+"");
	                    }
	                     
	                }
				}
			}
		);
		
		
		//增加菜品我的收藏组件Me2,Find2,Result2
		Me2 = new JLabel("我的收藏");
		Me2.setBounds(300,30,100,50);
		Me2.setFont(new Font("",1,15));
		list2 = new JLabel("菜品列表");
		list2.setBounds(150,45,100,50);
		Me2.setForeground(new Color(200,20,20));
		Find2 = new JLabel("请输入您需要查询的菜品名称");
		Find2.setBounds(150,300,200,50);
		Result2 = new JLabel("");
		Result2.setBounds(150,400,400,50);
		
		My2_mistake = new JLabel("你输入的菜品不存在!");
		My2_mistake.setForeground(Color.red);
		My2_mistake.setBounds(350, 300, 200, 50);
		My2_mistake.setVisible(false);
		
		
		find2 = new JTextField(10);
		find2.setBounds(150,350,350,40);
		All2 = new JTextArea();
		All2.setBounds(150,100,350,200);
		
		btn8 = new JButton("开始查询");
		btn8.setBounds(550,350,100,40);
		
		P8.add(Me2);		P8.add(Find2);
		P8.add(Result2);	P8.add(find2);
		P8.add(All2);		P8.add(btn8);
		P8.add(list2);		P8.add(My2_mistake);
		btn8.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					
					Result2.setText("");
					boolean tf = Mydb.cheak("Food","Food_Name",find2.getText());
					if(!tf)
					{
						Result2.setText(Mydb.MyFood(find2.getText()));
					}
					else
					{
						My2_mistake.setVisible(true);
					}
				}
			}
			
		);
		
		
		/*
		  * 为菜单栏增加监听
		 */
		for(int i=0;i<t.length-1;i++)
		{
			t[i].addActionListener(this);
		}
		//增加退出功能
		t[8].addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
	  				int n =JOptionPane.showConfirmDialog(null, "你确定不定了吗?","不定了！",JOptionPane.OK_CANCEL_OPTION);
					if(n==JOptionPane.OK_OPTION)
					{
						System.exit(0);
					}
				}
			}
		);
		//设置注销
		t[9].addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					int n =JOptionPane.showConfirmDialog(null, "您确定注销吗?","注销！",JOptionPane.OK_CANCEL_OPTION);
					if(n==JOptionPane.OK_OPTION)
					{
						Mydb.Cancellation();
						System.exit(0);
					}
				}
			}
		);

		
		this.setVisible(true);
		
	}
	


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == t[0])
		{
			First.setVisible(false);
			n.setVisible(false);
			P1.setVisible(true);
			n = P1;
		}
		else if(e.getSource() == t[1])
		{
			First.setVisible(false);
			n.setVisible(false);
			P2.setVisible(true);
			n = P2;
		}
		else if(e.getSource() == t[2])
		{
			First.setVisible(false);
			n.setVisible(false);
			P3.setVisible(true);
			n = P3;
		}
		else if(e.getSource() == t[3])
		{
			First.setVisible(false);
			n.setVisible(false);
			P4.setVisible(true);
			n = P4;
			All.setText(Mydb.My_Shop());
		}
		else if(e.getSource() == t[4])
		{
			First.setVisible(false);
			n.setVisible(false);
			P5.setVisible(true);
			n = P5;
		}
		else if(e.getSource() == t[5])
		{
			First.setVisible(false);
			n.setVisible(false);
			P6.setVisible(true);
			n = P6;
		}
		else if(e.getSource() == t[6])
		{
			First.setVisible(false);
			n.setVisible(false);
			P7.setVisible(true);
			n = P7;
		}
		else if(e.getSource() == t[7])
		{
			First.setVisible(false);
			n.setVisible(false);
			P8.setVisible(true);
			n = P8;
			All2.setText(Mydb.My_Food());
		}
		
	}

	
	public void insert(JLabel imgLabel,JPanel P) 
	{
		ImageIcon img_1=new ImageIcon("E:/java_The_Best_Homeworke/src/f1e0589ea12b8703364cee30e61d1a18.gif");	
		
		imgLabel=new JLabel(img_1);
		imgLabel.setBounds(100,530,100,100);
		P.setBackground(Color.white);
		P.add(imgLabel);
	}
	public static boolean isNumeric(String str)
	{
		for (int i = str.length();--i>=0;)
		{
			if (!Character.isDigit(str.charAt(i)))
			{
				return false;
	
			}
		}
		return true;
	}	
}

public class shopmain {

	public static void main(String[] args) {
		Two tw = new Two();
		tw.Next();

	}


}
