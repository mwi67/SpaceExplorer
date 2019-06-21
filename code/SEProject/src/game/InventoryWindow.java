package game;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JButton;
import crewMember.CrewMember;
import inventory.Item;
import spaceship.Spaceship;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
/**
 * Inventory GUI
 * @author amo174, mwi67
 *
 */
public class InventoryWindow {
	
	public JFrame frame;
	public JButton btnConsume;
	/**
	 * The boolean variable
	 */
	private boolean fromInventory = false;
	/**
	 *The crew CrewMember
	 */
	private CrewMember crew;
	/**
	 * The spaceship Spaceship
	 */
	private Spaceship spaceship;
	private JComboBox<Item> foodComboBox;
	/**
	 * The window MainGameWindow
	 */
	private MainGameWindow window;
	
	

	/**
	 * Create the application.
	 */
	public InventoryWindow(CrewMember crew, Spaceship spaceship, MainGameWindow window) {
		this.crew = crew;
		this.spaceship = spaceship;
		this.window = window;
		initialize();
	}
	/**
	 * refreshes the foodComboBox and updates its content
	 */
	public void refreshItems() {
		foodComboBox.removeAllItems();
		for (Item item:Spaceship.inventoryList) {
			foodComboBox.addItem(item);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 788, 407);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(50, 50, 105, 531);
		frame.getContentPane().add(tabbedPane);
		
		JPanel KitchenTab = new JPanel();
		KitchenTab.setBackground(new Color(153, 204, 255));
		KitchenTab.setToolTipText("");
		tabbedPane.addTab("Kitchen", null, KitchenTab, null);
		KitchenTab.setLayout(null);
		
		JLabel lblQuantity = new JLabel("Inventory List");
		lblQuantity.setFont(new Font("Dialog", Font.BOLD, 20));
		lblQuantity.setBounds(198, 37, 326, 33);
		KitchenTab.add(lblQuantity);
		
		
		JButton btnGoBackTo = new JButton("Go back to Game");
		btnGoBackTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnConsume.setEnabled(true);
				frame.dispose();
			}
		});
		btnGoBackTo.setBounds(51, 249, 185, 43);
		KitchenTab.add(btnGoBackTo);
				
		foodComboBox = new JComboBox<Item>();
		foodComboBox.setBounds(86, 95, 418, 43);
		KitchenTab.add(foodComboBox);
		refreshItems();
		
		
		/**
		 * consumes the food or medicine
		 */
		btnConsume = new JButton("Consume");
		
		btnConsume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Item chosenItem = (Item) foodComboBox.getSelectedItem();
				if (crew.getAction() > 0) {
					crew.eatItem(chosenItem);
					spaceship.removeInventoryList(chosenItem);
					refreshItems();
					window.updatePlayerDetails();
				} else {
					btnConsume.setEnabled(false);
					JOptionPane.showMessageDialog(null, "No Actions left","CAN'T EAT", JOptionPane.ERROR_MESSAGE); 
				}

			}
		});
		btnConsume.setBounds(579, 95, 121, 43);
		KitchenTab.add(btnConsume);
	}
	

}
