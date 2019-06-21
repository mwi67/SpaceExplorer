package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import spaceship.*;
/**
 * game won GUI
 * @author amo174, mwi67
 *
 */
public class GameWonWindow {

	private JFrame frame;
	private Game game;
	private Spaceship playerShip;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public GameWonWindow(Game game) {
		this.game = game;
		playerShip = game.getSpaceship();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(169, 169, 169));
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 582, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWonOver = new JLabel("YOU WON !!!");
		lblWonOver.setForeground(new Color(51, 51, 51));
		lblWonOver.setFont(new Font("Dialog", Font.BOLD, 26));
		lblWonOver.setBounds(139, 12, 250, 70);
		frame.getContentPane().add(lblWonOver);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnQuit.setBounds(167, 341, 174, 25);
		frame.getContentPane().add(btnQuit);
		
		JButton btnBackToMain = new JButton("Back to main menu");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.RestartGame();	
				frame.dispose();}
		});
		btnBackToMain.setBounds(167, 392, 174, 25);
		frame.getContentPane().add(btnBackToMain);
		
		JLabel lblScore = new JLabel("Score : " + Integer.toString(100*(playerShip.getPartsCollected()+ game.getCurrentday())));
		lblScore.setFont(new Font("Dialog", Font.BOLD, 18));
		lblScore.setBounds(146, 151, 222, 34);
		frame.getContentPane().add(lblScore);
		
		JLabel lblYouFoundAll = new JLabel("You Found All the parts : " + Integer.toString(playerShip.getPartsCollected()) );
		lblYouFoundAll.setFont(new Font("Dialog", Font.BOLD, 18));
		lblYouFoundAll.setBounds(139, 221, 323, 15);
		frame.getContentPane().add(lblYouFoundAll);
		
		JLabel lblNumberOfDays = new JLabel("Number Of Days Taken :  " + Integer.toString(game.getCurrentday()));
		lblNumberOfDays.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNumberOfDays.setBounds(140, 284, 333, 15);
		frame.getContentPane().add(lblNumberOfDays);
		
		JLabel shipNamelbl = new JLabel("");
		shipNamelbl.setFont(new Font("Dialog", Font.BOLD, 18));
		shipNamelbl.setBounds(139, 78, 267, 15);
		frame.getContentPane().add(shipNamelbl);
		
		JLabel lblShipName = new JLabel("");
		lblShipName.setText(playerShip.getSpaceshipNmae());
		lblShipName.setFont(new Font("Dialog", Font.BOLD, 18));
		lblShipName.setBounds(139, 108, 222, 15);
		frame.getContentPane().add(lblShipName);
	}
	/**
	 * disposes the game over window
	 */
	public void closeThisWindow() {
		frame.dispose();	
	}
	/**
	 * goes to start up game
	 */
	 public void StartOverGame() {
		 frame.dispose();	
		 game.RestartGame();
	 }
}
