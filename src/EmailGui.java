import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenu;
import java.awt.ScrollPane;
import java.awt.TextArea;
import javax.swing.UIManager;
import java.awt.Choice;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JProgressBar;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Button;



public class EmailGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static JProgressBar progressBar;
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//System.out.print(Helper.read_Password() + " " + Helper.read_Username());

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailGui frame = new EmailGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmailGui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final TextArea textArea = new TextArea();
		textArea.setFont(UIManager.getFont("Button.font"));
		textArea.setBounds(23, 10, 878, 411);
		contentPane.add(textArea);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(753, 500, 146, 14);
		contentPane.add(progressBar);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				progressBar.setValue(0);

				String em = "";
				String sub ="";
				String msg ="";
				Frame s = new Frame();
				boolean b1,b2,b3;
				
				if(textArea.getText().length()>2)
				{
					msg = textArea.getText();
					b1=true;
				}
				else
				{
					
					JOptionPane.showMessageDialog(s, "Please Enter more words");
					b1=false;
				}
				
				if(textField.getText().length()>11)
				{
					em = textField.getText();
				}
				else
				{
					em = "nikieme2@gmail.com";
				}
				
				if(textField_1.getText().length()>2)
				{
					sub = textField_1.getText();
				}
				else
				{
					sub = "Mom Email";
				}
				progressBar.setValue(50);
				if(b1)
				{
					try {
						Thread tt = new SendMailTLS(em, sub, msg);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//tt.start();
					
					progressBar.setValue(100);
					
				}
				
				
			}
		});
		

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(753, 527, 148, 78);
		contentPane.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(23, 427, 720, 178);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("General", null, layeredPane, null);
		
		JLabel lblTo = new JLabel("To :-");
		lblTo.setBounds(12, 86, 56, 16);
		layeredPane.add(lblTo);
		
		textField = new JTextField();
		textField.setBounds(12, 113, 189, 22);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSubject = new JLabel("Subject :-");
		lblSubject.setBounds(12, 13, 56, 16);
		layeredPane.add(lblSubject);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 42, 371, 22);
		layeredPane.add(textField_1);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Settings", null, layeredPane_1, null);
		
		JLabel lblPassword = new JLabel("Password :-");
		lblPassword.setBounds(12, 85, 79, 16);
		layeredPane_1.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					Helper.write_Password(passwordField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		passwordField.setBounds(12, 114, 131, 22);
		layeredPane_1.add(passwordField);
		
		JButton btnSavePassword = new JButton("Save Password");
		btnSavePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Helper.write_Password(passwordField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSavePassword.setBounds(155, 113, 131, 25);
		layeredPane_1.add(btnSavePassword);
		
		JLabel lblEmailId = new JLabel("Email ID :-");
		lblEmailId.setBounds(12, 13, 79, 16);
		layeredPane_1.add(lblEmailId);
		
		JButton btnSaveEmailId = new JButton("Save Email ID");
		btnSaveEmailId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Helper.write_Username(textField_3.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSaveEmailId.setBounds(155, 42, 131, 25);
		layeredPane_1.add(btnSaveEmailId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(528, 43, 175, 22);
		layeredPane_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCheckConnection = new JButton("Check Connection");
		btnCheckConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s;
				if(Helper.isInternetReachable())
				{
					s = "Internet On";
					textField_2.setText(s);
				}
				else 
				{
					s = "Error, Internet Off";
					textField_2.setText(s);
				}
							
			}
		});
		btnCheckConnection.setBounds(351, 42, 154, 25);
		layeredPane_1.add(btnCheckConnection);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Helper.write_Username(textField_3.getText());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		textField_3.setBounds(12, 42, 131, 22);
		layeredPane_1.add(textField_3);
		textField_3.setColumns(10);
		
		Button button_2 = new Button("reset");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Everything has be reset. Enter your password and email again then restart the application.");
				try {
					Helper.write_Username("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Helper.write_Password("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(662, 112, 43, 24);
		layeredPane_1.add(button_2);
		
		Button button = new Button("Clear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				progressBar.setValue(0);
			}
		});
		button.setBounds(790, 470, 79, 24);
		contentPane.add(button);
		
		Button button_1 = new Button("How To ?");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame s = new Frame();
				JOptionPane.showMessageDialog(s, "1. Once you have entered your paragraph in big empty\n    " +
						"space click on SEND and wait for progress bar to fill completely.\n" +
						"2. To clear the text entered Click on Clear\n"+
						"3. To change your email / Password go to settings tab and enter your email and password.\n    " +
						"After entering don't forget to click save button.\n" +
						"4. To Check your internet connection go to settings tab and click on check internet\n" +
						"5. To add subject go to general tab and type your subject subject\n" +
						"6. To send email to someone else enter different email in ' To:- '\n" +
						"7. To reset everything go to settings then click on reset it will delete pass and email.");
				
			}
		});
		button_1.setBounds(790, 440, 79, 24);
		contentPane.add(button_1);
		
	
	}
	
	public static class progressThread extends Thread
	{
		
		
		public void run()
		{
			for(int i=0;i<=100;i++)
			{
				progressBar.setValue(22);
				try {
					this.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
