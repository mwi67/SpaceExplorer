package game;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import crewMember.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Crew Details GUI
 * @author amo174, mwi67
 *
 */
public class CrewDetails {
	private JLabel displayNameLable;
	private JLabel displayLable;
	private JComboBox Select;
	private JLabel displayPic;
	

	protected JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewDetails window = new CrewDetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrewDetails() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.getContentPane().setLayout(null);
		/**
		 * Lets the user pick a type of crew member from the list provided 
		 */
		Select = new JComboBox();
		Select.setModel(new DefaultComboBoxModel(CrewOccupation.values()));
		Select.setBounds(154, 62, 314, 24);
		frame.getContentPane().add(Select);
		Select.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        changeName(CrewOccupation.values()[Select.getSelectedIndex()]);
		    }
		});
		
		JLabel lblChooseACrew = new JLabel("Choose a crew member to find details about them ");
		lblChooseACrew.setBounds(137, 12, 426, 15);
		frame.getContentPane().add(lblChooseACrew);
		
		displayPic = new JLabel("");
		displayPic.setIcon(null);
		displayPic.setBounds(509, 108, 224, 265);
		frame.getContentPane().add(displayPic);
		
		
		JLabel lblName = new JLabel("Occupation    :");
		lblName.setBounds(23, 220, 132, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblSkills = new JLabel("Skills   :");
		lblSkills.setBounds(23, 358, 132, 15);
		frame.getContentPane().add(lblSkills);
		
		displayNameLable = new JLabel("");
		displayNameLable.setBounds(144, 220, 241, 15);
		frame.getContentPane().add(displayNameLable);
		
		
		
		displayLable = new JLabel("");
		displayLable.setBounds(133, 358, 269, 15);
		frame.getContentPane().add(displayLable);
		/**
		 * Takes user to Startup Window
		 */
		JButton btnBackToMain = new JButton("Back to Main Window");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnBackToMain.setBounds(491, 462, 211, 25);
		frame.getContentPane().add(btnBackToMain);
		frame.setForeground(Color.BLACK);
		frame.setBounds(100, 100, 745, 560);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	}
	
	/**
	 * matches the string from combo box to the crew member classes and displays their deatils
	 * @param name  Type of crew member
	 */
	public void changeName(CrewOccupation name) {
		CrewMember member;
		switch(name) {
		case Captain:
			member = new Captain(name.name());
			break;
		case Programmer:
			member = new Programmer(name.name());
			break;
		case Doctor:
			member = new Doctor(name.name());
			break;
		case Engineer:
			member = new Engineer(name.name());
			break;
		case CookieMonster:
			member = new CookieMonster(name.name());
			break;
		case Scientist:
			member = new Scientist(name.name());
			break;
		case None:
			displayNameLable.setText("Choose a Member");
			displayLable.setText("Choose a Member");
			displayPic.setIcon(new ImageIcon(StartUpWindow.class.getResource("/Simages/Gb.jpeg")));
		default:
		
			return;
		
		}
		displayNameLable.setText(member.getName());
		displayLable.setText(member.getSkills());
		displayPic.setIcon(new ImageIcon(StartUpWindow.class.getResource(member.getimage())));
		
	}
}
