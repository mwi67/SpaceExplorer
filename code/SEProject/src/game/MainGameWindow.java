package game;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import crewMember.*;
import error.*;
import planet.*;
import spaceship.*;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
/**
 * The MainGame GUI window
 * @author amo174, mwi67
 *
 */
public class MainGameWindow {

	private JFrame frame;
	/**
	 * The Class Game game variable
	 */
	private Game game;
	private JProgressBar progressBar;
	// JLables
	private JLabel lblProgress;
	private JLabel daysLable;
	private JLabel lblHealth;
	private JLabel lblTiredness;
	private JLabel lblHunger;
	private JLabel lblPlague;
	private JLabel lblHealth2;
	private JLabel lblTiredness2;
	private JLabel lblHunger2;
	private JLabel lblPlague2;
	private JLabel lblHealth3;
	private JLabel lblTiredness3;
	private JLabel lblHunger3;
	private JLabel lblPlague3;
	private JLabel lblHealth4;
	private JLabel lblTiredness4;
	private JLabel lblHunger4;
	private JLabel lblPlague4;
	private JLabel currentMoneylbl;
	private JLabel lblCurrentLoc; 
	private JLabel lblAction1; 
	private JLabel lblAction2; 
	private JLabel lblAction3;
	private JLabel lblAction4; 
	private JLabel lblNumberOfPart;
	// JCheckBox
	private JCheckBox chckbxPlayer1; 
	private JCheckBox chckbxPlayer2;
	private JCheckBox chckbxPlayer3;
	private JCheckBox chckbxPlayer4; 

	/**
	 * The crewmember1 variable
	 */
	private CrewMember crewMember1;
	/**
	 * The crewmember2 variable
	 */
	private CrewMember crewMember2;
	/**
	 * The crewmember3 variable
	 */
	private CrewMember crewMember3;
	/**
	 * The crewmember4 variable
	 */
	private CrewMember crewMember4;
	
	/**
	 * The crewListAction ArrayList<Crewmember> 
	 */
	private ArrayList <CrewMember> crewListAction = new ArrayList<>();
	/**
	 * The playerList ArrayList<Crewmember> 
	 */
	private ArrayList <CrewMember> playerList = new ArrayList<>();
	/**
	 * The Spaceship variable
	 */
	private Spaceship playerShip;
	/**
	 *  The planet saturn instance
	 */
	private Planet saturn = new Saturn();
	/**
	 *  The planet venus instance
	 */
	private Planet venus = new Venus();
	/**
	 *  The planet mercury instance
	 */
	private Planet mercury = new Mercury();
	/**
	 *  The planet mars instance
	 */
	private Planet mars = new Mars();
	/**
	 *  The planet pluto instance
	 */
	private Planet pluto = new Pluto();
	/**
	 *  The planet earth instance
	 */
	private Planet earth = new Earth();
	/**
	 *  The planet uranus instance
	 */
	private Planet uranus = new Uranus();
	/**
	 *  The planet neptune instance
	 */
	private Planet neptune = new Neptune();
	/**
	 *  The planet jupiter instance
	 */
	private Planet jupiter = new Jupiter();
	/**
	 *  The planet moon instance
	 */
	private Planet moon = new Moon();




	/**
	 * Create the application.
	 */
	public MainGameWindow(Game game) {
		this.game = game;
		playerShip = game.getSpaceship();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * method to uncheck the checkboxes.
	 */
	public void uncheckCheckbox() {
	
		chckbxPlayer1.setSelected(false);
		chckbxPlayer2.setSelected(false);
		chckbxPlayer3.setSelected(false);
		chckbxPlayer4.setSelected(false);
		
	}
	
	/**
	 * Methods to update the  parts collected section of lblNumberOfPart label
	 */
	public void updatePartscollectedlbl() {
		if (!(playerShip.getPartsCollected() == 0)) {
			lblNumberOfPart.setText("Number of part found : " + Integer.toString(playerShip.getPartsCollected()));
		}
		
	}
	
	/**
	 *Updates the details of the players
	 * Labels for tabs, every time "updatePlayerDetrails()"  is called
	 */
	public void updatePlayerDetails() {
		progressBar.setValue(playerShip.getShieldLevel());
		lblProgress.setText(Integer.toString(playerShip.getShieldLevel()));
		int count = 0;
		 for (CrewMember name : playerList) {
			 if (count == 0 ) {
				 lblAction1.setText( Integer.toString(name.getAction()));
				 if (name.getHealth() > 0) {
					 lblHealth.setText("Health : " + name.getHealth());
					 }else {
						 lblHealth.setText("Health : He is Dead");
						 name.setCrewMemberDead();
						 chckbxPlayer1.setEnabled(false);
						 name.setCrewMemberDead();
						 lblAction1.setText( Integer.toString(name.getAction()));
					 }
				 lblTiredness.setText("Tiredness : " + Integer.toString(name.getTiredness()));
				 lblHunger.setText("Hunger : " + Integer.toString(name.getFullness()));
				 if (name.getPlague() == true) {
					 lblPlague.setText("Plague : " + name.getPlagueResult());
					 }else {
						 lblPlague.setText("Plague : " + name.getPlagueResult());
					 }
			 }
			 else if (count == 1) {

				 lblAction2.setText(Integer.toString(name.getAction()));
				 if (name.getHealth() > 0) {
					 lblHealth2.setText("Health : " + name.getHealth());
					 }else {
						 lblHealth2.setText("Health : He is Dead");
						 name.setCrewMemberDead();
						 chckbxPlayer2.setEnabled(false);
						 lblAction2.setText( Integer.toString(name.getAction()));
					 }
				 
				 lblTiredness2.setText("Tiredness : " + Integer.toString(name.getTiredness()));
				 lblHunger2.setText("Hunger : " + Integer.toString(name.getFullness()));
				 if (name.getPlague() == true) {
					 lblPlague2.setText("Plague : " + name.getPlagueResult());
					 }else {
						 lblPlague2.setText("Plague : " + name.getPlagueResult());
					 }
			 }
			 else if (count == 2) {
				 lblAction3.setText(Integer.toString(name.getAction()));
				 if (name.getHealth() > 0) {
					 lblHealth3.setText("Health : " + name.getHealth());
					 }else {
						 lblHealth3.setText("Health : He is Dead");
						 name.setCrewMemberDead();
						 chckbxPlayer3.setEnabled(false);
						 lblAction3.setText( Integer.toString(name.getAction()));
					 }
				
				 lblTiredness3.setText("Tiredness : " + Integer.toString(name.getTiredness()));
				 lblHunger3.setText("Hunger : " + Integer.toString(name.getFullness()));
				 if (name.getPlague() == true) {
					 lblPlague3.setText("Plague : " + name.getPlagueResult());
					 }else {
						 lblPlague3.setText("Plague : " + name.getPlagueResult());
					 }
			
			 }
			 else if (count == 3) {
				 lblAction4.setText(Integer.toString(name.getAction()));
				 if (name.getHealth() > 0) {
					 lblHealth4.setText("Health : " + name.getHealth());
					 }else {
						 lblHealth4.setText("Health : He is Dead");
						 name.setCrewMemberDead();
						 chckbxPlayer4.setEnabled(false);
						 lblAction4.setText( Integer.toString(name.getAction()));
					 }
				 
				 lblTiredness4.setText("Tiredness : " + Integer.toString(name.getTiredness()));
				 lblHunger4.setText("Hunger : " + Integer.toString(name.getFullness()));
				 if (name.getPlague() == true) {
					 lblPlague4.setText("Plague : " + name.getPlagueResult());
					 }else {
						 lblPlague4.setText("Plague : " + name.getPlagueResult());
					 }
			
			 }
			 
			 count += 1;
		 }	
	}
	
	/**
	 * Method to refresh money label
	 */
	public void refreshMoney() {
		currentMoneylbl.setText(String.valueOf(playerShip.getMoney()));
	}
	
	/**
	 * Creates a new Inventory window
	 * @param crew   type of crew member to perform the action
	 */
	public void createInventoryWindow(CrewMember crew) {
		InventoryWindow inventory = new InventoryWindow(crew, playerShip, this);
		inventory.frame.setVisible(true);
		inventory.btnConsume.setEnabled(true);	
	}
	
	/**
	 * Creates a new CurrentLocation window
	 */
	public void createChangeLocationWindow() {
		CurrentLocation changeLocation = new CurrentLocation(game, playerShip, this);
		changeLocation.frame.setVisible(true);
		changeLocation.btnChangeLocation.setEnabled(true);	
	}
	
	/**
	 * Update planetDetails updates the current location of the planet
	 */
	public void planetDetailsUpdate() {
		 lblCurrentLoc.setText("Your Current Location is : " + playerShip.getLocation().getPlanetName());
	}
	
	/**
	 * Pilot method is called from different planet buttons.
	 * it checks if what planet we are at and pilots only to another planet.
	 * It has error message showMessageDialog to handle errors
	 */
	public void pilot(Planet name) {
		if (name.getHasLanded() == true) {
			uncheckCheckbox();
			crewListAction.clear();
			JOptionPane.showMessageDialog(null, "You are already visited or at " + name.getPlanetName(),"Can't Pilot", JOptionPane.INFORMATION_MESSAGE); 
			JOptionPane.showMessageDialog(null, "If you want to revisit a planet you previous visited, Click Change Location ","Can't Pilot", JOptionPane.INFORMATION_MESSAGE); 
		}else {
			CrewMember pilot1 = null;
			CrewMember pilot2 = null;
		
			int size = crewListAction.size();
			if (size == 2) {
				pilot1 = crewListAction.remove(0);
				pilot2 = crewListAction.remove(0);
				if (pilot1.getAction() > 0 && pilot2.getAction() > 0 ) {
					pilot1.minusAction();
					pilot2.minusAction();
					pilot1.addTiredness(25);
					pilot2.addTiredness(25);
					uncheckCheckbox();
					updatePlayerDetails();
					Random rand = new Random();
					int randomElement = rand.nextInt(10);
					
					if(randomElement > 8) {
						playerShip.getAsteroidAttack();
						JOptionPane.showMessageDialog(null, "Astroid Attack going back to the previous planet NOW!","alert", JOptionPane.WARNING_MESSAGE); 
						JOptionPane.showMessageDialog(null, "Your shield Health went down","alert", JOptionPane.WARNING_MESSAGE);
						updatePlayerDetails();
						if (playerShip.getShieldLevel() < 0) {
							 closeThisWindow();
						}
					}
					
					else {
						///  set current location to new location
						Planet previousPlanet = playerShip.getLocation();
						previousPlanet.setLanded(false);
						playerShip.setLocation(name);
						game.addPlanets(name);
						name.setLanded(true);
						lblCurrentLoc.setText("Your Current Location is : " + name.getPlanetName());
						uncheckCheckbox();
						crewListAction.clear();
						updatePlayerDetails();
					}
				}
								
			else {
				uncheckCheckbox();
				crewListAction.clear();
				
				JOptionPane.showMessageDialog(null, "Your Selected crew members don't have action left to pilot","CAN'T PILOT", JOptionPane.ERROR_MESSAGE); 
				}
			}else {
				
				uncheckCheckbox();
				crewListAction.clear();
				JOptionPane.showMessageDialog(null, "You need exactly two members to pilot, not more, not less","CHOOSE TWO CREW MEMBERS TO PILOT", JOptionPane.ERROR_MESSAGE); 
			}
			}
	}
	
	/**
	 * Creates an OutPost window
	 */
	public void createOutpostWindow() {
		OutpostWindow outpost = new OutpostWindow(playerShip, this);
	}
	
	/**
	 * Gets list of Crew member from Game(game manager class) 
	 */
	public ArrayList<CrewMember> setPlayers() {
		this.playerList =  game.getCrewList();
		return playerList;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 10));
		frame.setBounds(100, 100, 1361, 777);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/**
		 * List of planet buttons
		 * Creates a class type of individual planets
		 * Then class pilot() method.
		 */
		JButton btnSaturn = new JButton("Saturn");
		btnSaturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pilot(saturn);
			}
		});
		btnSaturn.setBounds(631, 160, 90, 25);
		frame.getContentPane().add(btnSaturn);
		
		JButton btnVenus = new JButton("Venus");
		btnVenus.setBounds(286, 294, 90, 25);
		btnVenus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					pilot(venus);
				}
		});
		frame.getContentPane().add(btnVenus);
		
		JButton btnMercury = new JButton("Mercury");
		btnMercury.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pilot(mercury);
			}
		});
		btnMercury.setBounds(321, 467, 90, 25);
		frame.getContentPane().add(btnMercury);
		
		JButton btnEarth = new JButton("Earth");
		btnEarth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pilot(earth);
			}
		});
		btnEarth.setBounds(466, 439, 71, 25);
		frame.getContentPane().add(btnEarth);
		
		JButton btnJupiter = new JButton("Jupiter");
		btnJupiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pilot(jupiter);
			}
		});
		btnJupiter.setBounds(594, 379, 90, 25);
		frame.getContentPane().add(btnJupiter);
		
		JButton btnUranus = new JButton("Uranus");
		btnUranus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				pilot(uranus);
			}
		});
		btnUranus.setBounds(783, 245, 101, 25);
		frame.getContentPane().add(btnUranus);
		
		JButton btnNeptune = new JButton("Neptune");
		btnNeptune.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pilot(neptune);
			}
		});
		btnNeptune.setBounds(784, 99, 93, 25);
		frame.getContentPane().add(btnNeptune);
		
		JButton btnPluto = new JButton("Pluto");
		btnPluto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pilot(pluto);
			}
		});
		btnPluto.setBounds(906, 99, 71, 25);
		frame.getContentPane().add(btnPluto);
		
		JButton btnMars = new JButton("Mars");
		btnMars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				pilot(mars);
			}
		});
		btnMars.setBounds(432, 294, 71, 25);
		frame.getContentPane().add(btnMars);
		
		JButton btnMoon = new JButton("Moon");
		btnMoon.setBounds(381, 352, 71, 25);
		btnMoon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				pilot(moon);
			}
		});
		frame.getContentPane().add(btnMoon);
		
		/*
		 * End of planet buttons 
		 */
		
		JLabel nameOfSpaceshipUserGiven = new JLabel("");
		nameOfSpaceshipUserGiven.setBounds(1025, 445, 299, 15);
		nameOfSpaceshipUserGiven.setFont(new Font("Dialog", Font.BOLD, 10));
		if(game.getSpaceship().getSpaceshipNmae() != null) {
			nameOfSpaceshipUserGiven.setText(game.getSpaceship().getSpaceshipNmae());
		}
		frame.getContentPane().add(nameOfSpaceshipUserGiven);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(1015, 493, 336, 244);
		frame.getContentPane().add(tabbedPane);
		  
		  
		  
		  // ** player 1  of JPanel** //
		    
		    JPanel crewM1Details = new JPanel();
		    tabbedPane.addTab("   ", null, crewM1Details, null);
		    crewM1Details.setLayout(null);
		    
		    JLabel lblActionsLeft = new JLabel("Actions left :");
		    lblActionsLeft.setBounds(12, 36, 101, 15);
		    crewM1Details.add(lblActionsLeft);
		    
		    lblAction1 = new JLabel("");// + crew_member1.getAction() );
		    lblAction1.setBounds(146, 36, 66, 15);
		    crewM1Details.add(lblAction1);
		    
		    lblHealth = new JLabel("Health : " );
		    lblHealth.setBounds(12, 63, 167, 15);
		    crewM1Details.add(lblHealth);
		    
		    lblTiredness = new JLabel("Tiredness :");
		    lblTiredness.setBounds(12, 139, 222, 15);
		    crewM1Details.add(lblTiredness);
		    
		    
		    lblHunger = new JLabel("Hunger :");
		    lblHunger.setBounds(12, 177, 153, 15);
		    crewM1Details.add(lblHunger);
		    
		    lblPlague = new JLabel("Plague : ");
		    lblPlague.setBounds(12, 101, 167, 15);
		    crewM1Details.add(lblPlague);
		    
		    JLabel occ = new JLabel("Occupation : ");
		    occ.setBounds(38, 12, 191, 15);
		    crewM1Details.add(occ);
		  
		  
		  // ** player 2  of JPanel** //
		  
		  JPanel crewM2Details = new JPanel();
		  tabbedPane.addTab("   ", null, crewM2Details, null);
		  crewM2Details.setLayout(null);
		  
		  JLabel lblActionsLeft2 = new JLabel("Actions left :");
		  lblActionsLeft2.setBounds(12, 36, 101, 15);
		  crewM2Details.add(lblActionsLeft2);
		  
		  lblAction2 = new JLabel("");
		  lblAction2.setBounds(139, 28, 66, 15);
		  crewM2Details.add(lblAction2);
		  
		  lblHealth2 = new JLabel("Health :");
		  lblHealth2.setBounds(12, 63, 222, 15);
		  crewM2Details.add(lblHealth2);
		  
		  lblTiredness2 = new JLabel("Tiredness :");
		  lblTiredness2.setBounds(12, 139, 222, 15);
		  crewM2Details.add(lblTiredness2);
		  
		  
		  lblHunger2 = new JLabel("Hunger :");
		  lblHunger2.setBounds(12, 177, 232, 15);
		  crewM2Details.add(lblHunger2);
		  
		  
		  lblPlague2 = new JLabel("Plague : ");
		  lblPlague2.setBounds(12, 101, 209, 15);
		  crewM2Details.add(lblPlague2);
		  
		  JLabel occ2 = new JLabel("Occupation : ");
		  occ2.setBounds(30, 9, 191, 15);
		  crewM2Details.add(occ2);
		  
		  
		  
		  
		  // ** player3  of JPanel ** //
		  
		  JPanel crewM3Details = new JPanel();
		  tabbedPane.addTab("   ", null, crewM3Details, null);
		  crewM3Details.setLayout(null);
		  
		  JLabel lblActionsLeft3 = new JLabel("Actions left :");
		  lblActionsLeft3.setBounds(12, 36, 101, 15);
		  crewM3Details.add(lblActionsLeft3);
		  
		  lblAction3 = new JLabel("");//+ crew_member3.getAction() );
		  lblAction3.setBounds(125, 28, 66, 15);
		  crewM3Details.add(lblAction3);
		  
		  lblHealth3 = new JLabel("Health :");
		  lblHealth3.setBounds(12, 63, 179, 15);
		  crewM3Details.add(lblHealth3);
		  
		  lblTiredness3 = new JLabel("Tiredness :");
		  lblTiredness3.setBounds(12, 139, 224, 15);
		  crewM3Details.add(lblTiredness3);
		  
		  lblHunger3 = new JLabel("Hunger :");
		  lblHunger3.setBounds(12, 177, 224, 15);
		  crewM3Details.add(lblHunger3);
		  
		  
		  lblPlague3 = new JLabel("Plague : ");
		  lblPlague3.setBounds(12, 101, 224, 15);
		  crewM3Details.add(lblPlague3);
		  
		  JLabel occ3 = new JLabel("Occupation : ");
		  occ3.setBounds(34, 12, 191, 15);
		  crewM3Details.add(occ3);
		  
		  
		  //** player4  of JPanel**//
		  
		  JPanel crewM4Details = new JPanel();
		  tabbedPane.addTab("   ", null, crewM4Details, null);
		  crewM4Details.setLayout(null);
		  
		  JLabel lblActionsLeft4 = new JLabel("Actions left :");
		  lblActionsLeft4.setBounds(12, 36, 101, 15);
		  crewM4Details.add(lblActionsLeft4);
		  
		  lblAction4 = new JLabel("");
		  lblAction4.setBounds(139, 28, 66, 15);
		  crewM4Details.add(lblAction4);
		  
		  lblHealth4 = new JLabel("Health :");
		  lblHealth4.setBounds(12, 63, 229, 15);
		  crewM4Details.add(lblHealth4);
		  
		  lblTiredness4 = new JLabel("Tiredness : ");
		  lblTiredness4.setBounds(12, 139, 229, 15);
		  crewM4Details.add(lblTiredness4);
		  
		  lblHunger4 = new JLabel("Hunger :");
		  lblHunger4.setBounds(12, 177, 229, 15);
		  crewM4Details.add(lblHunger4);
		  
		  lblPlague4 = new JLabel("Plague : ");
		  lblPlague4.setBounds(12, 101, 229, 15);
		  crewM4Details.add(lblPlague4);
		  
		  JLabel occ4 = new JLabel("Occupation : ");
		  occ4.setBounds(37, 9, 191, 15);
		  crewM4Details.add(occ4);
		  
		  /// *** End of display player panels *** ///
		  
		
		
		
		
		/**
		 * daysLable Displays the current day as an integer
		 */
		  
		daysLable = new JLabel("");
		daysLable.setBounds(906, 16, 48, 37);
		daysLable.setForeground(Color.RED);
		daysLable.setFont(new Font("IPAPGothic", Font.BOLD, 18));
		daysLable.setText("1");
		frame.getContentPane().add(daysLable);
		
		JLabel lblDay = new JLabel("Day :");
		lblDay.setBounds(833, 4, 66, 60);
		lblDay.setForeground(Color.RED);
		lblDay.setFont(new Font("IPAPGothic", Font.BOLD, 18));
		frame.getContentPane().add(lblDay);
		
		
		/**
		 * Start game button starts the game 
		 * sets players user given names
		 * depending on how many crew member the user has chosen using a for-loop it enables the properties respectively
		 * number of crew member == number of check box enabled
		 * sets money, current location, and starts the game 
		 */
		
		JButton btnStartGame = new JButton("Start game ");
		btnStartGame.setFont(new Font("Dialog", Font.BOLD, 18));
		btnStartGame.setForeground(Color.RED);
		btnStartGame.setBounds(1015, 4, 336, 488);
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				 setPlayers();
				 int count = 0;
				 for (CrewMember name : playerList) {
					 if (count == 0 ) {
						 crewMember1 = name;
						 tabbedPane.addTab(name.getName(), null, crewM1Details, null);
						 chckbxPlayer1.setText(name.getName()); 
						 chckbxPlayer1.setEnabled(true);
						 occ.setText(name.getOccupation());
					 }else if (count == 1) {
						 crewMember2 = name;
						 tabbedPane.addTab(name.getName(), null, crewM2Details, null);
						 chckbxPlayer2.setText(name.getName()); 
						 chckbxPlayer2.setEnabled(true);
						 occ2.setText(name.getOccupation());
					 }else if (count == 2) {
						 crewMember3 = name;
						 tabbedPane.addTab(name.getName(), null, crewM3Details, null);
						 chckbxPlayer3.setText(name.getName()); 
						 chckbxPlayer3.setEnabled(true);
						 occ3.setText(name.getOccupation());
					 }else if (count == 3) {
						 crewMember4 = name;
						 tabbedPane.addTab(name.getName(), null, crewM4Details, null);
						 chckbxPlayer4.setText(name.getName()); 
						 chckbxPlayer4.setEnabled(true);
						 occ4.setText(name.getOccupation());
					
					 }
					 
					 count += 1;
				 }
				 currentMoneylbl.setText(Integer.toString(playerShip.getMoney()));
				 
				 playerShip.setLocation(moon);
				 game.addPlanets(moon);
				 lblCurrentLoc.setText("Your Current Location is : " + playerShip.getLocation().getPlanetName());
				 updatePlayerDetails();
				 btnStartGame.setVisible(false);
			
			}
		});
		frame.getContentPane().add(btnStartGame);
		
		/**
		 * Outpost button takes you to outpost for the user to buy food, medicine, and money
		 * Calls the method createOutpostWindow() and creates a new window;
		 */
		JButton btnOutpost = new JButton("OutPost");
	
		btnOutpost.setBounds(1086, 83, 194, 25);
		btnOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createOutpostWindow();

			}

		});
		frame.getContentPane().add(btnOutpost);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setBounds(1086, 147, 194, 25);
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InventoryWindow inventory = new InventoryWindow(null, null, null);
				inventory.frame.setVisible(true);
				inventory.btnConsume.setEnabled(false);
		
			}
		});
		frame.getContentPane().add(btnInventory);
		
		/**
		 * Moves on to next day by calling proceedDay() from game class.
		 * and updates player details when done.
		 */
		JButton moveOnBtn = new JButton("Move on to next to day");
		moveOnBtn.setBounds(1089, 205, 191, 25);
		moveOnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crewListAction.clear();
				uncheckCheckbox();
				if (game.proceedDay() == true){
					updatePlayerDetails();
					daysLable.setText(Integer.toString(game.getCurrentday()));
				} else {
					updatePlayerDetails();
					closeThisWindow();					
				}
			
				 updatePlayerDetails();
			}
		});
		frame.getContentPane().add(moveOnBtn);
		// Labels  // 
		JLabel lblOnceYouMove = new JLabel("Once you move on to next day, you can't come back  ");
		lblOnceYouMove.setBounds(1038, 184, 313, 15);
		lblOnceYouMove.setFont(new Font("Dialog", Font.BOLD, 9));
		frame.getContentPane().add(lblOnceYouMove);
		
		JLabel lblCheckWhatYou = new JLabel("To Check what you have in storage, go to inventory ");
		lblCheckWhatYou.setBounds(1048, 120, 301, 15);
		lblCheckWhatYou.setFont(new Font("Dialog", Font.BOLD, 9));
		frame.getContentPane().add(lblCheckWhatYou);
		
		JLabel lblToBuyMore = new JLabel("To Buy more products visit outpost");
		lblToBuyMore.setBounds(1083, 56, 221, 15);
		lblToBuyMore.setFont(new Font("Dialog", Font.BOLD, 9));
		frame.getContentPane().add(lblToBuyMore);
		
		JLabel lblMoney = new JLabel("Money :  $");
		lblMoney.setBounds(1036, 29, 101, 15);
		lblMoney.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(lblMoney);
		
		currentMoneylbl = new JLabel("");
		currentMoneylbl.setBounds(1149, 29, 104, 15);
		currentMoneylbl.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(currentMoneylbl);
		
		JLabel lblSpaceshipShielLevel = new JLabel("Spaceship-Shiel Level :");
		lblSpaceshipShielLevel.setBounds(1028, 466, 130, 15);
		lblSpaceshipShielLevel.setFont(new Font("Dialog", Font.BOLD, 10));
		frame.getContentPane().add(lblSpaceshipShielLevel);
		
		JLabel lblYouNeedAt = new JLabel("Each crew member require at least one action ");
		lblYouNeedAt.setBounds(1029, 251, 322, 15);
		lblYouNeedAt.setFont(new Font("Dialog", Font.BOLD, 12));
		frame.getContentPane().add(lblYouNeedAt);
		
		JLabel lblPickToPeople = new JLabel("Pick two people to pilot");
		lblPickToPeople.setBounds(610, 570, 299, 15);
		lblPickToPeople.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPickToPeople.setForeground(Color.RED);
		frame.getContentPane().add(lblPickToPeople);
		
		JLabel lblNewLabel = new JLabel(" if you wanna get to another planet");
		lblNewLabel.setBounds(584, 596, 336, 15);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.RED);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panelCheckbox = new JPanel();
		panelCheckbox.setBounds(456, 640, 521, 60);
		frame.getContentPane().add(panelCheckbox);
		
	
		//  Check Boxes //
		chckbxPlayer1 = new JCheckBox("None               ");
		chckbxPlayer1.setEnabled(false);
		chckbxPlayer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxPlayer1.isSelected() ) {
					crewListAction.add(crewMember1);

				}else {
					crewListAction.remove(crewMember1);
				}
			}
		});
		panelCheckbox.add(chckbxPlayer1);
		
		chckbxPlayer2 = new JCheckBox("None               ");
		chckbxPlayer2.setEnabled(false);
		chckbxPlayer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxPlayer2.isSelected() ) {
					crewListAction.add(crewMember2);
				}else {
					crewListAction.remove(crewMember2);
				}

			}
		});
		panelCheckbox.add(chckbxPlayer2);
		
		chckbxPlayer3 = new JCheckBox("None               ");
		chckbxPlayer3.setEnabled(false);
		chckbxPlayer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxPlayer3.isSelected() ) {
					crewListAction.add(crewMember3);
				}else {
					crewListAction.remove(crewMember3);
				}

			}
		});
		
		panelCheckbox.add(chckbxPlayer3);
		
		chckbxPlayer4 = new JCheckBox("None                ");
		chckbxPlayer4.setEnabled(false);
		chckbxPlayer4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxPlayer4.isSelected() ) {
					crewListAction.add(crewMember4);
			
				}else {
					crewListAction.remove(crewMember4);
				}

			}
		});
		panelCheckbox.add(chckbxPlayer4);
	
		// Location Label //
		lblCurrentLoc = new JLabel("Your Current Location is : ");
		lblCurrentLoc.setBounds(381, 29, 440, 15);
		lblCurrentLoc.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCurrentLoc.setForeground(Color.RED);
		frame.getContentPane().add(lblCurrentLoc);
		
		JLabel lblNumOfPart = new JLabel("Num of part to find : " + game.getPartsNeeded());
		lblNumOfPart.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNumOfPart.setForeground(Color.RED);
		lblNumOfPart.setBounds(29, 49, 228, 15);
		frame.getContentPane().add(lblNumOfPart);
		
		lblNumberOfPart = new JLabel("Number of part found :  0" );
		lblNumberOfPart.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNumberOfPart.setForeground(Color.RED);
		lblNumberOfPart.setBounds(29, 76, 238, 15);
		frame.getContentPane().add(lblNumberOfPart);
		/**
		 * Takes user back to main window and exits the game
		 */
		JButton btnBackToMain = new JButton("Back to Main Menu");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeThisWindow();
			}
		});
		btnBackToMain.setBounds(29, 675, 181, 25);
		frame.getContentPane().add(btnBackToMain);

		
		JLabel Back = new JLabel("");
		Back.setBounds(12, -12, 1000, 749);
		Back.setFont(new Font("GFS Porson", Font.BOLD, 16));
		Back.setIcon(new ImageIcon(MainGameWindow.class.getResource("/Simages/solar-system-cute.jpg")));
		frame.getContentPane().add(Back);
		
		/**
		 *  Eat button take player to inventory to consume an item. 
		 *  Consumes food or medicine from inventory
		 */
		JButton btnEat = new JButton("Eat");
		int size = crewListAction.size();
		if (size > 1) {
			btnEat.setEnabled(false);
		} else {
			btnEat.setEnabled(true);
		}
		btnEat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				uncheckCheckbox();
				if (crewListAction.size() == 1) {
					CrewMember searchPerson = crewListAction.remove(0);	
					if (searchPerson.getAction() > 0) {
						createInventoryWindow(searchPerson);
					} else {
						JOptionPane.showMessageDialog(null, "No actions left","CAN'T EAT", JOptionPane.WARNING_MESSAGE); 
					}
				}else {
					crewListAction.clear();
					uncheckCheckbox();
					JOptionPane.showMessageDialog(null, "Select one person at a time to Search","CAN'T EAT", JOptionPane.ERROR_MESSAGE); 
				}
				crewListAction.clear();
			}
		});
		btnEat.setBounds(1025, 294, 133, 25);
		frame.getContentPane().add(btnEat);
		
		/**
		 * Search button,
		 *  searches the planet which you are in for food, medicine and parts 
		 */
		
		JButton btnSearch = new JButton("Search Planet");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uncheckCheckbox();
				if (crewListAction.size() == 1) {
					CrewMember searchPerson = crewListAction.remove(0);	
					if (searchPerson.getAction() > 0 ) {
						Planet planet = playerShip.getLocation();
						String mess = "";
						try {
						mess = playerShip.searchPlanet(planet, searchPerson);
						}
						catch(NoNegativeException e) {
							JOptionPane.showMessageDialog(null ,e.getMessage());
						}
						
						if (game.checkAllParts() == true) {
							updatePlayerDetails();
							closeThisWindow();	
						}
						crewListAction.clear();
						uncheckCheckbox();
						updatePlayerDetails();
						refreshMoney();
						JOptionPane.showMessageDialog(null , mess, "You have found", JOptionPane.OK_OPTION);
						lblNumberOfPart.setText("Number of part found : " + Integer.toString(playerShip.getPartsCollected()));
					} else {
						crewListAction.clear();
						uncheckCheckbox();
						JOptionPane.showMessageDialog(null, "This crew member has no action left","CAN'T SEARCH", JOptionPane.WARNING_MESSAGE);
					}
					
				}else {
					
					crewListAction.clear();
					uncheckCheckbox();
					JOptionPane.showMessageDialog(null, "Select one person at a time to Search","CAN'T SEARCH", JOptionPane.ERROR_MESSAGE); 
					
					
				}
				crewListAction.clear();		
				updatePlayerDetails();
				refreshMoney();//				 emptyCrewlist();
			}
		});
		btnSearch.setBounds(1023, 352, 135, 25);
		frame.getContentPane().add(btnSearch);
		
		/**
		 * Sleep Button,
		 *  helps the user to put one crew member to sleep, provided that crew member have one action left
		 */
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				uncheckCheckbox();
				if (crewListAction.size() == 1) {
					CrewMember Person = crewListAction.remove(0);
					if (Person.getAction() > 0) {
						Person.addSleep();
						updatePlayerDetails();
					} else {
						JOptionPane.showMessageDialog(null, "This crew member don't have enough action","CAN'T SLEEP", JOptionPane.WARNING_MESSAGE); 
						uncheckCheckbox();
						crewListAction.clear();
					}
					
					
					} else {
						JOptionPane.showMessageDialog(null, "Select one person at a time to Sleep","CAN'T SLEEP", JOptionPane.ERROR_MESSAGE); 
						uncheckCheckbox();
						crewListAction.clear();
						
					}
				
				crewListAction.clear();
				
			} 
				
		});
		btnSleep.setBounds(1186, 294, 138, 25);
		frame.getContentPane().add(btnSleep);
		
		/**
		 * Repair Ship button,
		 * useful for user to fix the ship
		 * 
		 */
		
		JButton btnRepairShip = new JButton("Repair Ship");
		btnRepairShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uncheckCheckbox();
				CrewMember searchPerson;
				if (crewListAction.size() == 1) {
					searchPerson = crewListAction.remove(0);
					int previousSheildlevel = playerShip.getShieldLevel();
					if (searchPerson.getAction() > 0) {
						playerShip.fixShield(searchPerson);
						progressBar.setValue(playerShip.getShieldLevel());
						int currentShieldLevel = playerShip.getShieldLevel();
						updatePlayerDetails();
						if (currentShieldLevel > previousSheildlevel) {
							JOptionPane.showMessageDialog(null, "Ship Shield level increased"," REPAIR INFO", JOptionPane.INFORMATION_MESSAGE );
							} else {
								JOptionPane.showMessageDialog(null, "Ship Shield level DID'NT increased"," REPAIR INFO", JOptionPane.WARNING_MESSAGE);
							}
					} else {
						JOptionPane.showMessageDialog(null, "This crew member no action left","CAN'T REPAIR", JOptionPane.WARNING_MESSAGE); 
					}
					} else {
						JOptionPane.showMessageDialog(null, "Select one person at a time to Repair the ship","CAN'T REPAIR", JOptionPane.ERROR_MESSAGE); 
						uncheckCheckbox();
						crewListAction.clear();
						}
				updatePlayerDetails();
				uncheckCheckbox();
				crewListAction.clear();
			}
		});
		btnRepairShip.setBounds(1186, 352, 138, 25);
		frame.getContentPane().add(btnRepairShip);
		
		progressBar = new JProgressBar();
		progressBar.setMaximum(80);
		progressBar.setBackground(Color.gray);
		progressBar.setForeground(Color.GREEN);
		progressBar.setValue(playerShip.getShieldLevel());
		progressBar.setBounds(1176, 467, 84, 25);
		frame.getContentPane().add(progressBar);
		
		JLabel lblToPerformEat = new JLabel("to perform Eat, Sleep, Search, Repair");
		lblToPerformEat.setBounds(1048, 266, 256, 15);
		frame.getContentPane().add(lblToPerformEat);
		
		lblProgress = new JLabel("progress");
		lblProgress.setBounds(1278, 472, 66, 15);
		frame.getContentPane().add(lblProgress);
		
		/**
		 * takes user to ChangeLocation window to move to a different previously visited planet
		 */
		JButton btnChangeLocation = new JButton("Change Location");
		btnChangeLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createChangeLocationWindow();
				updatePlayerDetails();
			}
		});
		btnChangeLocation.setBounds(1051, 408, 209, 25);
		frame.getContentPane().add(btnChangeLocation);
	}
	/**
	 * calls when user's game is over
	 */
	public void closeThisWindow() {
		game.CallGameOver(game, this);	
	}
	
	/**
	 * Disposes the main game window
	 */
	public void disposeWindow() {
		frame.dispose();
	}
	
	/**
	 * Take user back to main menu 
	 * To start a new game
	 */
	 public void StartOverGame() {
		 closeThisWindow();
		 game.RestartGame();
	 }
}
