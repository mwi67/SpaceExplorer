package game;

import java.awt.EventQueue;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import planet.*;
import spaceship.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GUI to change the location to one of the previously visited planets
 * @author amo174, mwi67
 *
 */
public class CurrentLocation {

	public JFrame frame;
	private JComboBox<Planet> planeListCombo;
	/**
	 * The main game window GUI
	 */
	private MainGameWindow window;
	/**
	 * The Spaceship class
	 */
	private Spaceship spaceship;
	/**
	 * The game game
	 */
	private Game game;
	JButton btnChangeLocation;
	private JLabel lblItAlsoTells;
	private JButton btnBcakToGame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrentLocation window = new CurrentLocation();
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
	public CurrentLocation(Game game, Spaceship spaceship,  MainGameWindow window) {
		this.game = game;
		this.spaceship = spaceship;
		this.window = window;
		initialize();
	}
	
	public void refreshPlanet() {
		planeListCombo.removeAllItems();
		for (Planet p :game.getPlanetList()) {
			planeListCombo.addItem(p);
		}
	}
	public CurrentLocation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 687, 663);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		planeListCombo = new JComboBox<Planet> ();
		planeListCombo.setBounds(198, 192, 231, 36);
		frame.getContentPane().add(planeListCombo);
		refreshPlanet();
		/**
		 * Changes the location to a different previously visited planet chosen by the user
		 */
		btnChangeLocation = new JButton("Change Location ");
		btnChangeLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Planet chosenPlanet = (Planet) planeListCombo.getSelectedItem();
				spaceship.setLocation(chosenPlanet);
				window.planetDetailsUpdate();
			}
		});
		btnChangeLocation.setBounds(227, 355, 204, 25);
		frame.getContentPane().add(btnChangeLocation);
		
		JLabel label = new JLabel("You can only visit planet you already visited");
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(142, 86, 398, 15);
		frame.getContentPane().add(label);
		
		lblItAlsoTells = new JLabel("It also tells you how many things left in each planet");
		lblItAlsoTells.setFont(new Font("Dialog", Font.BOLD, 14));
		lblItAlsoTells.setBounds(126, 127, 455, 15);
		frame.getContentPane().add(lblItAlsoTells);
		/**
		 * takes user back  to main game
		 */
		btnBcakToGame = new JButton("Back to game");
		btnBcakToGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnBcakToGame.setBounds(227, 407, 202, 25);
		frame.getContentPane().add(btnBcakToGame);
		
	

	}
}

