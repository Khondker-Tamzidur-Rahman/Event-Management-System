package EventManagementSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import java.awt.Color;
import java.awt.color.*;
public class Login implements ActionListener{
	
	public static JLabel userlebel;
    public static JTextField userText;
    public static JLabel passwordlebel;
    public static JPasswordField passwordText;
    public static JButton button;
    public static JLabel success;
    public static JFrame frame;
    public static void LogIn() {
        frame=new JFrame();
        JPanel panel=new JPanel();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit  when the program is closed
        frame.setVisible(true);    //to make visible in the screen
        frame.add(panel);

        panel.setLayout(null);
        panel.setBackground(Color.pink);
        userlebel = new JLabel("UserName");
        userlebel.setBounds(10,10,50,50);//10 means XY axis
        panel.add(userlebel);

        userText = new JTextField(20);//not sure its column
        userText.setBounds(110,25, 150,25);
        panel.add(userText);

        passwordlebel = new JLabel("Password");
        frame.setVisible(true);
        passwordlebel.setBounds(10, 45, 100, 50);
        panel.add(passwordlebel);


        passwordText = new JPasswordField();//for ****
        passwordText.setBounds(110, 60, 150,25);
        panel.add(passwordText);
        frame.setVisible(true);

        button = new JButton("Log In");
        button.setBounds(110,100,80,25);
        button.addActionListener(new Login());//to make action if the password is true
        panel.add(button);

        success = new JLabel("");
        success.setBounds(110, 150, 100, 25);
        panel.add(success);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user= userText.getText();
        String password=passwordText.getText();
        System.out.println(user+", "+password);
        
        	try {
        		String path = "F://Java workspace//abcd//src//abcd//data.txt";
				
				
				FileReader fr = new FileReader(path);
	            BufferedReader br = new BufferedReader(fr);
	            
	            boolean isLoginSuccess = false,isfromNSU=false;
	            int u=0;
	            String line, fuser, fpass;
	            
	            
	            while((line = br.readLine()) != null)
	            {	
	            	fuser = line.split(" ")[0];
	                fpass = line.split(" ")[1];
	               
	                
	              
   					
	                
	                if (fuser.equals(user)  && fpass.equals(password)) {
	                	isLoginSuccess = true;
	                	System.out.println("SUCCESS");
	                	success.setText("Login Successful");
	                	JOptionPane.showMessageDialog(null, "Successfully Logged in! ","Confirmation", JOptionPane.WARNING_MESSAGE);
	                	frame.setVisible(false);
	                	Menu m = new Menu();
	                	//splash.showSplashScreen();
		                break;
	                }
	                
	            }
                if(!isLoginSuccess) {
                	success.setText("Wrong Password");
                }
                
               /* SplashScreen .showSplashScreen();
        		SplashScreen .doSomething(); // Simulating some tasks
        		SplashScreen . closeSplashScreen();
        		SplashScreen .showMainApplication(); */
                
        	}
       
        catch (Exception ep) {
			System.out.println("ERROR 404! File-Not-Found");
           
        }
        
        
    }

}
