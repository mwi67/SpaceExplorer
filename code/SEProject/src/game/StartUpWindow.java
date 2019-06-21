package game;



import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import spaceship.*;
import crewMember.*;


/**
 * Start up window.
 * Collects information.
 * @author mwi67, amo174
 *
 */
public class StartUpWindow {

	private JFrame mainSpaceExplorer;
	private JTextField spaceshipName;
	private JComboBox<Integer> numDays; 
	private JComboBox<String> crewCB1;
	private JComboBox<String> crewCB2;
	private JComboBox<String> crewCB3;
	private JComboBox<String> crewCB4;
	private JLabel lblC1;
	private JLabel blC2;
	private JLabel blC3;
	private JLabel blC4;
	private JTextField playerName;
	private JTextField crewM1;
	private JTextField crewM2;
	private JTextField crewM3;
	private JTextField crewM4;
	/**
	 * The player1 CrewMember
	 */
	private CrewMember player1;
	/**
	 * The player2 CrewMember
	 */
	private CrewMember player2;
	/**
	 * The player3 CrewMember
	 */
	private CrewMember player3;
	/**
	 * The player4 CrewMember
	 */
	private CrewMember player4;
	/**
	 * The Game game
	 */
	private Game game;
	/**
	 * The CrewMember ArrayList 
	 */
	private ArrayList <CrewMember> crewList = new ArrayList<>();
	
	/**
	 * Creates a instance of player type
	 * @param type   String
	 * @param name   user given name 
	 * @return member CrewMember type
	 */
	public CrewMember createPlayer(String type,String name) {
		CrewMember member;
		switch(type) {
			case "Captain":
				member = new Captain(name);
				break;
			case "Programmer":
				member = new Programmer(name);
				break;
			case "Doctor":
				member = new Doctor(name);
				break;
			case "Engineer":
				member = new Engineer(name);
				break;
			case "CookieMonster":
				member = new CookieMonster(name);
				break;
			case "Scientist":
				member = new Scientist(name);
				break;
			default:
				member = new Captain(name);
		}
		return member;
	}
	

	/**
	 * Create the application.
	 */
	public StartUpWindow(Game game) {
		this.game = game;
		initialize();
		mainSpaceExplorer.setVisible(true);
	}
	
		
	/**
	* Initialize the contents of the frame.
	*/
	private void initialize() {
		mainSpaceExplorer = new JFrame();
		mainSpaceExplorer.setIconImage(Toolkit.getDefaultToolkit().getImage(StartUpWindow.class.getResource("/Simages/solar-system-cute.jpg")));
		mainSpaceExplorer.getContentPane().setForeground(Color.WHITE);
		mainSpaceExplorer.getContentPane().setLayout(null);
		
		spaceshipName = new JTextField();

		spaceshipName.setFont(new Font("IPAPGothic", Font.BOLD, 16));
		spaceshipName.setBounds(551, 79, 256, 28);
		mainSpaceExplorer.getContentPane().add(spaceshipName);
		spaceshipName.setColumns(14);
		
		JLabel lblNewLabel1 = new JLabel("Welcome to Space Explorer !!!");
		lblNewLabel1.setForeground(Color.RED);
		lblNewLabel1.setFont(new Font("IPAPGothic", Font.BOLD, 21));
		lblNewLabel1.setBounds(250, 22, 515, 45);
		mainSpaceExplorer.getContentPane().add(lblNewLabel1);
		
		JLabel lblNewLabel = new JLabel("Enter Player's Spaceship  Name                 --->");
		lblNewLabel.setFont(new Font("IPAPGothic", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(120, 79, 440, 33);
		mainSpaceExplorer.getContentPane().add(lblNewLabel);
		
		JLabel lblNumOfDays = new JLabel("Enter Number Of Days You Want to Play  ---->");
		lblNumOfDays.setForeground(Color.RED);
		lblNumOfDays.setFont(new Font("IPAPGothic", Font.BOLD, 16));
		lblNumOfDays.setBounds(120, 134, 407, 15);
		mainSpaceExplorer.getContentPane().add(lblNumOfDays);
		
		JLabel lblChooseYourCrew = new JLabel("Choose Your Crew Members");
		lblChooseYourCrew.setForeground(Color.RED);
		lblChooseYourCrew.setFont(new Font("IPAPGothic", Font.BOLD, 16));
		lblChooseYourCrew.setBounds(120, 217, 249, 15);
		mainSpaceExplorer.getContentPane().add(lblChooseYourCrew);
		
		JButton crewDetailsButton = new JButton("More Details about Crew");
		crewDetailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrewDetails window = new CrewDetails();
				window.frame.setVisible(true);
			}
		});
		crewDetailsButton.setFont(new Font("IPAPGothic", Font.BOLD, 16));
		crewDetailsButton.setBounds(109, 506, 309, 47);
		mainSpaceExplorer.getContentPane().add(crewDetailsButton);
		
		// Number of days player choose //
		numDays = new JComboBox<Integer>();
		numDays.setToolTipText("");
		numDays.setModel(new DefaultComboBoxModel(new Integer[] {3, 4, 5, 6, 7, 8, 9, 10}));

		spaceshipName.setFont(new Font("IPAPGothic", Font.BOLD, 16));
		numDays.setBounds(551, 131, 88, 24);
		mainSpaceExplorer.getContentPane().add(numDays);
		//**players**//
		crewCB1 = new JComboBox<String>();
		crewCB1.setToolTipText("");
		crewCB1.setModel(new DefaultComboBoxModel(CrewOccupation.values()));
		crewCB1.setBounds(389, 268, 138, 24);
		mainSpaceExplorer.getContentPane().add(crewCB1);
		
		crewCB2 = new JComboBox<String>();
		crewCB2.setModel(new DefaultComboBoxModel(CrewOccupation.values()));
		crewCB2.setBounds(389, 323, 138, 24);
		mainSpaceExplorer.getContentPane().add(crewCB2);
		
		crewCB3 = new JComboBox<String>();
		crewCB3.setModel(new DefaultComboBoxModel(CrewOccupation.values()));
		crewCB3.setBounds(389, 377, 138, 24);
		mainSpaceExplorer.getContentPane().add(crewCB3);
		
		crewCB4 = new JComboBox<String>();
		crewCB4.setModel(new DefaultComboBoxModel(CrewOccupation.values()));
		crewCB4.setBounds(389, 428, 138, 24);
		mainSpaceExplorer.getContentPane().add(crewCB4);

		//** labels **//
		lblC1 = new JLabel("Crew Member 1");
	
		lblC1.setForeground(Color.RED);
		lblC1.setFont(new Font("IPAPGothic", Font.BOLD, 16));
		lblC1.setBounds(120, 273, 181, 15);
		mainSpaceExplorer.getContentPane().add(lblC1);
		
		blC2 = new JLabel("Crew Member 2");
		blC2.setForeground(Color.RED);
		blC2.setFont(new Font("IPAPGothic", Font.BOLD, 16));
		blC2.setBounds(120, 328, 181, 15);
		mainSpaceExplorer.getContentPane().add(blC2);
		
		blC3 = new JLabel("Crew Member 3");
		blC3.setForeground(Color.RED);
		blC3.setFont(new Font("IPAPGothic", Font.BOLD, 16));
		blC3.setBounds(120, 382, 181, 15);
		mainSpaceExplorer.getContentPane().add(blC3);
		
		blC4 = new JLabel("Crew Member 4");
		blC4.setForeground(Color.RED);
		blC4.setFont(new Font("IPAPGothic", Font.BOLD, 16));
		blC4.setBounds(120, 433, 191, 15);
		mainSpaceExplorer.getContentPane().add(blC4);
		
		playerName = new JTextField();
		
		playerName.setFont(new Font("IPAPGothic", Font.BOLD, 16));
		playerName.setBounds(553, 167, 241, 33);
		mainSpaceExplorer.getContentPane().add(playerName);
		playerName.setColumns(10);
		playerName.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				lblNewLabel1.setText("Welcome to Space Explorer " + playerName.getText() + " !!!");
			}
			
		});
		
		JLabel lblEnterYourName = new JLabel("Enter Your Name Explorer    --->");
		lblEnterYourName.setForeground(Color.RED);
		lblEnterYourName.setFont(new Font("IPAPGothic", Font.BOLD, 16));
		lblEnterYourName.setBounds(120, 176, 384, 15);
		mainSpaceExplorer.getContentPane().add(lblEnterYourName);
		
		crewM1 = new JTextField();
		crewM1.setText("crew member1");
		crewM1.setBounds(602, 271, 256, 19);
		mainSpaceExplorer.getContentPane().add(crewM1);
		crewM1.setColumns(10);
		crewM1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				lblC1.setText(crewM1.getText());
		    }
		});
		crewM1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				lblC1.setText(crewM1.getText());
			}
			
		});
		
		crewM2 = new JTextField();
		crewM2.setText("crew member2");
		crewM2.setBounds(602, 326, 256, 19);
		mainSpaceExplorer.getContentPane().add(crewM2);
		crewM2.setColumns(10);
		crewM2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				blC2.setText(crewM2.getText());
		    }
		});
		crewM2.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				blC2.setText(crewM2.getText());
			}
		});
		
		crewM3 = new JTextField();
		crewM3.setText("crew member3");
		crewM3.setBounds(602, 380, 256, 19);
		mainSpaceExplorer.getContentPane().add(crewM3);
		crewM3.setColumns(10);
		crewM3.addActionListener(new ActionListener() 	{
			public void actionPerformed(ActionEvent event) {
				blC3.setText(crewM3.getText());
		    }
		});
		crewM3.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				blC3.setText(crewM3.getText());
			}
		});
		
		crewM4 = new JTextField();
		crewM4.setText("crew member4");
		crewM4.setBounds(602, 431, 256, 19);
		mainSpaceExplorer.getContentPane().add(crewM4);
		crewM4.setColumns(10);
		
		
	
		/**
		 * start game button
		 */
		JButton btnStartGame = new JButton("Start Adventure");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> listOfMembers = new ArrayList<String>();
				listOfMembers.add(crewCB1.getSelectedItem().toString());
				listOfMembers.add(crewCB2.getSelectedItem().toString());
				listOfMembers.add(crewCB3.getSelectedItem().toString());
				listOfMembers.add(crewCB4.getSelectedItem().toString());
				int noneCount = 0;
				for (String s : listOfMembers) {
					if (s == "None"){
							noneCount += 1;
					}
				}
				if (noneCount > 2){
					JOptionPane.showMessageDialog(null, "You can't move forward with less than 2 people","alert", JOptionPane.ERROR_MESSAGE); 
		
				}else {
					int days = (int) numDays.getSelectedItem();
					game.setPartsNeeded(days * 2/3);
					game.setCurrentDay(1);
					game.setMaxDays(days);
					
					Spaceship playerShip = new Spaceship(spaceshipName.getText());
					
					for (String s : listOfMembers) {
						if (s != "None") {
							if (player1 == null) {
								player1 = createPlayer(s, crewM1.getText());
								crewList.add(player1);
						}else if (player2 == null) {
								player2 = createPlayer(s, crewM2.getText());
								crewList.add(player2);
						}else if (player3 == null) {
								player3 = createPlayer(s, crewM3.getText());
								crewList.add(player3);
						}else if (player4 == null) {
								player4 = createPlayer(s, crewM4.getText());
								crewList.add(player4);
							}
						}
					}	
					game.setCrewList(crewList);
					game.setSpaceship(playerShip);
					game.startGame();
					mainSpaceExplorer.dispose();
				}
			}
		});
				

		btnStartGame.setBounds(661, 508, 227, 47);
		mainSpaceExplorer.getContentPane().add(btnStartGame);
		
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setBackground(Color.BLACK);
		backGroundLabel.setForeground(Color.WHITE);
		backGroundLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		backGroundLabel.setBounds(-32, 0, 1036, 742);
		backGroundLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		backGroundLabel.setVerticalAlignment(SwingConstants.TOP);
		backGroundLabel.setIcon(new ImageIcon(StartUpWindow.class.getResource("/Simages/solar-system-cute.jpg")));
		mainSpaceExplorer.getContentPane().add(backGroundLabel);
		crewM4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				blC4.setText(crewM4.getText());
		    }
			});
		crewM4.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				blC4.setText(crewM4.getText());
			}	
		});
		mainSpaceExplorer.setTitle("Space Explorer");
		mainSpaceExplorer.setBackground(Color.WHITE);
		mainSpaceExplorer.setBounds(100, 100, 1036, 770);
		mainSpaceExplorer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
