package EventManagementSystem;

import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Menu extends JFrame implements ActionListener{
	
	private static final ActionListener a = null;
	JLabel label1,label2,label3,label4,label5,label6, label7,label8,label9,label10,msg;
	JRadioButton wedding, birthday, anniversary, reception, conference;
	JComboBox t, v, m, f, ms, d;
	JCheckBox terms;
	JButton submit,next;
	JTextArea screen;
	
	Menu(){
		setTitle("Event Menu");
		setSize(1000,1000);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(null);
		c.setVisible(true);
		
		
		
		label3=new JLabel("Events:");
		label3.setBounds(20,145,100,20);
		label3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		c.add(label3);
		
		wedding=new JRadioButton("Wedding");
		birthday=new JRadioButton("Birthday");
		anniversary=new JRadioButton("Anniversary");
		reception=new JRadioButton("Reception");
		conference=new JRadioButton("Conference");
	
		
		wedding.setBounds(130,150,80,20);
		birthday.setBounds(220,150,80,20);
		anniversary.setBounds(310,150,100,20);
		reception.setBounds(420,150,90,20);
		conference.setBounds(520,150,100,20);
		
		wedding.setSelected(true);
		c.add(wedding);
		c.add(birthday);
		c.add(anniversary);
		c.add(reception);
		c.add(conference);
		
		
		ButtonGroup gen=new ButtonGroup();
		gen.add(wedding);
		gen.add(birthday);
		gen.add(anniversary);
		gen.add(reception);
		gen.add(conference);
		
		
		label4=new JLabel("Services: ");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label4.setBounds(20,200,100,20);
		c.add(label4);
		

		label5=new JLabel("Theme:");
		label5.setBounds(130,200,100,20);
		c.add(label5);
		
		label6=new JLabel("Venue:");
		label6.setBounds(240,200,200,20);
		c.add(label6);
		
		label7 = new JLabel("Momentary capture:");
		label7.setBounds(450,200,160,20);
		c.add(label7);
		
		label8=new JLabel("Foodvendor:");
		label8.setBounds(130,260,100,20);
		c.add(label8);
		
		label9=new JLabel("Music stage:");
		label9.setBounds(240,260,100,20);
		c.add(label9);
		
		label10=new JLabel("Decorations:");
		label10.setBounds(350,260,100,20);
		c.add(label10);
		
		label2=new JLabel("Welcome to our menu!");
		label2.setBounds(200,40,1000,30);
		label2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		c.add(label2);
		
		String[] theme= {"Cultural", "Indoor", "Outdoor", "Retro","Bollywood", "Religious", "DisneyLand", "FairyTale", "Marvel", "Princess", "Disco", "Traditional", "Modern", "None"};
		String[] venue= {"Secret Garden", "ICCB", "Regency Hotel & Resort", "Six Seasons Banquet", "Aziz Manzil", "Sena Malancha", "The WaterFront Convention Hall", "BAF Falcon Hall", "BGB Banquet Hall", "Emmanuelle's Party Center", "Others"};
		String[] momentary_capture= {"Photography", "Videography", "Cinematography", "Photography+Videography", "All", "None"};
		String[] foodvendor= {"Bengali", "Pakistani", "Indian", "Chinese", "Italian", "Japanese", "Turkish", "Others", "None"};
		String[] music_stage= {"DJ", "Band", "Stage", "Solo Singer", "Sound System", "None"};
		String[] decorations= {"Floral", "Lightings", "Balloons", "Crafting", "Others", "None"};
		
		
		
		t =new JComboBox(theme);
		v=new JComboBox(venue);
		m=new JComboBox(momentary_capture);
		f =new JComboBox(foodvendor);
		ms=new JComboBox(music_stage);
		d=new JComboBox(decorations);
		
		
		t.setBounds(130,220,100,20);
		v.setBounds(240,220,200,20);
		m.setBounds(450,220,160,20);
		f.setBounds(130,280,100,20);
		ms.setBounds(240,280,100,20);
		d.setBounds(350,280,100,20);
		
		c.add(t);
		c.add(v);
		c.add(m);
		c.add(f);
		c.add(ms);
		c.add(d);
		
		
		
		terms=new JCheckBox("Confirm to save the following information");
		terms.setBounds(130,330,280,20);		
		c.add(terms);
		
		submit=new JButton("Next");
		submit.setBounds(230,380,80,20);
		c.add(submit);
		
		submit.addActionListener(this);
		
		next=new JButton("Log Out");
		next.setBounds(230,500,80,20);
		c.add(next);
		
		
		next.addActionListener(this);
		
		
		screen=new JTextArea();
		screen.setBounds(650,50,300,300);
		c.add(screen);
		
		
		
		
		msg=new JLabel();
		msg.setBounds(20,400,250,20);
		
		c.add(msg);
		c.setBackground(Color.PINK);
		
		setVisible(true);
		
	}

	//@Override
	public void actionPerformed(ActionEvent e) {
		
		if (terms.isSelected()) {
			
			msg.setText("Thank you! Your booking has been confirmed. You can log out now.");
			msg.setBounds(100,420,400,20);
			

			
			String event= "Wedding";
			
			if (birthday.isSelected()) {
				event="Birthday";}
			else if(anniversary.isSelected()){
				event="Anniversary";}
			else if(reception.isSelected()) {
					event="Reception";}
			else if(conference.isSelected()) {
					event="Conference";}

			
			String theme=(String)t.getSelectedItem();
			String venue=(String)v.getSelectedItem();
			String momentary_capture=(String)m.getSelectedItem();
			String foodvendor=(String)f.getSelectedItem();
			String music_stage=(String)ms.getSelectedItem();
			String decorations=(String)d.getSelectedItem();
			
			screen.setText("Event: "+event+"\nTheme: "+theme+"\nVanue: "+venue+"\nMomrntary Capture: "+momentary_capture+"\nFoodvendor: "+foodvendor+"\nMusic Stage: "+music_stage+"\nDecorations: "+decorations);
			
			//save
			String path = "E://menudata.txt";
			
			try {
				FileWriter myWriter = new FileWriter(path,true);
				
		    	myWriter.write(theme+" "+venue+" "+momentary_capture+" "+ foodvendor+" "+ music_stage+" "+decorations+"\n");
			    myWriter.close();
			  
			}
		    catch (IOException ep) {
			      System.out.println("ERROR 404! File-Not-Found");
			      ep.printStackTrace();
			}
		
		}
		
		if (e.getSource() == next) {
			this.setVisible(false);
			Cost ct = new Cost();
			
			
		}
		
		
		
	}
}