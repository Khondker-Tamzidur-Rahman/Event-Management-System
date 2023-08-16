package EventManagementSystem;

import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;


public class Registration extends JFrame implements ActionListener{
	
	private static final ActionListener LogIn = null;
	JLabel label1,label2,label3,label4,label5,label6;
	JTextField t1,t2,t3;
	JRadioButton male,female;
	JComboBox day,month,year;
	JTextArea ta1;
	JCheckBox terms;
	JButton submit,next;
	JLabel msg;
	JTextArea screen;
	boolean check=false;
	String path = "F://Java workspace//abcd//src//abcd//data.txt";
	
	Registration(){
		setTitle("Registration Form");
		setSize(700,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(null);
		c.setVisible(true);
		
		label1=new JLabel("Name");
		label1.setBounds(20,50,100,20);
		c.add(label1);
		
		t1=new JTextField();
		t1.setBounds(130,50,100,20);
		c.add(t1);
		
		label2=new JLabel("Mobile Num");
		label2.setBounds(20,100,100,20);
		c.add(label2);
		
		t2=new JTextField();
		t2.setBounds(130,100,100,20);
		c.add(t2);
		
		label3=new JLabel("Gender");
		label3.setBounds(20,150,100,20);
		c.add(label3);
		
		male=new JRadioButton("Male");
		female=new JRadioButton("Female");
		
		male.setBounds(130,150,80,20);
		female.setBounds(220,150,80,20);
		male.setSelected(true);
		c.add(male);
		c.add(female);
		
		ButtonGroup gen=new ButtonGroup();
		gen.add(male);
		gen.add(female);
		
		label4=new JLabel("DOB");
		label4.setBounds(20,200,100,20);
		c.add(label4);
		
		String[] days= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String[] months= {"jan","feb","mar","apr","may","june","july","aug","sep","oct","nov","dec"};
		String[] years= {"2023","2022","2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987","1986","1985"};
		
		
		day=new JComboBox(days);
	    month=new JComboBox(months);
		year=new JComboBox(years);
		
		day.setBounds(130,200,50,20);
		month.setBounds(190,200,50,20);
		year.setBounds(250,200,60,20);
		
		c.add(day);
		c.add(month);
		c.add(year);
		
		label5=new JLabel("Password");
		label5.setBounds(20,300,100,20);
		c.add(label5);
        c.setVisible(true);
		
		ta1=new JTextArea();
		ta1.setBounds(130,300,100,20);
		c.add(ta1);
		
		label6=new JLabel("username");
		label6.setBounds(20,240,100,20);
		c.add(label6);
		
		t3=new JTextField();
		t3.setBounds(130,240,100,20);
		c.add(t3);
		
		terms=new JCheckBox("Please accept terms and conditions");
		terms.setBounds(70,370,250,20);		
		c.add(terms);
		
		submit=new JButton("submit");
		submit.setBounds(150,420,80,20);
		c.add(submit);
		
		submit.addActionListener(this);
		
		
		
		
		screen=new JTextArea();
		screen.setBounds(350,50,300,300);
		c.add(screen);
		
		msg=new JLabel();
		msg.setBounds(20,400,250,20);
		c.add(msg);
		c.setBackground(Color.PINK);
		
		setVisible(true);
		
	}
	
	public boolean check(String username)
	{
		String line;
		try {
			FileReader fr = new FileReader(path);
	        BufferedReader br = new BufferedReader(fr);
	        
	        while ((line = br.readLine()) != null)
	        {
	        	System.out.print("->" + line.split(" ")[0] + "=" + username);
	        	if(username.equalsIgnoreCase(line.split(" ")[0]))
	        	{
	        		return true;
	        	}
	        }
		}
		catch (Exception ep) {
			System.out.println("ERROR 404! File-Not-Found");
            
        }
		return false;
	}

  
	public void actionPerformed(ActionEvent e) {
		boolean done=false; 
		if(terms.isSelected()) {
			
			msg.setText("Registration Successful");
			
			String name=t1.getText();
			String mobile=t2.getText();
			String username=t3.getText();
			String gender="male";
			
			if(female.isSelected()) {
				gender="female";
			}
			
			String DOB=day.getSelectedItem()+"-"+month.getSelectedItem()+"-"+year.getSelectedItem();
			String password=ta1.getText();
			
			screen.setText("Name :"+name+"\n"+"Mobile :"+mobile+"\n"+"Gender :"+gender+"\n"+ "DOB :"+DOB+"\n"+"Username :"+username+"\n"+"Password :"+password+ "\n");
			//Save data
			
			
			try
			{
			      if(!check(username))
			      {
			    	  done=true;
			    	  FileWriter myWriter = new FileWriter(path,true);
			    	  myWriter.write(username+" "+password+"\n");
				      myWriter.close();
				      
				      this.setVisible(false);
				      JOptionPane.showMessageDialog(null, "Successfully Registered! Please Login to continue...","Confirmation", JOptionPane.WARNING_MESSAGE);
			      }
			      else
			      {
			    	  JOptionPane.showMessageDialog(null, "Username already in use!","Confirmation", JOptionPane.WARNING_MESSAGE);
			      }
			 }
			catch (IOException ep) {
			      System.out.println("ERROR 404! File-Not-Found");
			      ep.printStackTrace();
			}
			
			
			
			System.out.print("test");
			
			Login.LogIn();
			
			
			
		
		}
		
		
		else {
			
			
			msg.setText("Accept Terms and Condition to continue");
			
			screen.setText("");
			
		}
		 
	}
	

}
