package game;


import java.awt.Font;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import error.*;
import inventory.*;
import shopping.*;
import spaceship.*;
/**
 * OutPost GUI
 * @author amo174, mwi67
 *
 */
public class OutpostWindow {

	public JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JLabel lblKidding;
	/**
	 * The Spaceship playerShip
	 */
	private Spaceship playerShip;
	/**
	 * The Outpost outpost GUI
	 */
	private Outpost outpost;
	/**
	 * MainGameWindow window GUI
	 */
	private MainGameWindow window;

	/**
	 * Create the application.
	 */
	public OutpostWindow(Spaceship playerShip, MainGameWindow window) {
		outpost = new Outpost();
		this.playerShip = playerShip;
		this.window = window;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(68, 78, 818, 531);
		frame.getContentPane().add(tabbedPane);
		
		JPanel foodTab = new JPanel();
		foodTab.setToolTipText("");
		tabbedPane.addTab("Food", null, foodTab, null);
		foodTab.setLayout(null);
		
		JLabel lblApple = new JLabel("$ 10 ea  Apple");
		lblApple.setBounds(60, 62, 212, 15);
		foodTab.add(lblApple);
		
		JLabel lblCheeseBurger = new JLabel("$ 20 ea  Cheese Burger");
		lblCheeseBurger.setBounds(60, 115, 212, 15);
		foodTab.add(lblCheeseBurger);
		
		JLabel lblChococookie = new JLabel("$ 2 ea  ChocoCookie");
		lblChococookie.setBounds(60, 168, 212, 15);
		foodTab.add(lblChococookie);
		
		JLabel lblRoastChicken = new JLabel("$ 100 ea  Roast Chicken");
		lblRoastChicken.setBounds(60, 220, 212, 15);
		foodTab.add(lblRoastChicken);
		
		JLabel lblSandwich = new JLabel("$ 10 ea  Egg sandwich");
		lblSandwich.setBounds(60, 272, 212, 15);
		foodTab.add(lblSandwich);
		
		JLabel lblWater = new JLabel("$ 20 ea  Water");
		lblWater.setBounds(60, 336, 212, 15);
		foodTab.add(lblWater);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(340, 12, 66, 15);
		foodTab.add(lblQuantity);
		
		SpinnerModel sm = new SpinnerNumberModel(0, 0, 5, 1);
		JSpinner spinnerApple = new JSpinner(sm);
		spinnerApple.setBounds(350, 62, 38, 18);
		
		foodTab.add(spinnerApple);
		
		SpinnerModel sm1 = new SpinnerNumberModel(0, 0, 5, 1);
		JSpinner spinnerBurger = new JSpinner(sm1);
		spinnerBurger.setBounds(350, 113, 38, 20);
		foodTab.add(spinnerBurger);
		
		SpinnerModel sm2 = new SpinnerNumberModel(0, 0, 5, 1);
		JSpinner spinnerCookie = new JSpinner(sm2);
		spinnerCookie.setBounds(350, 166, 38, 20);
		foodTab.add(spinnerCookie);
		
		SpinnerModel sm3 = new SpinnerNumberModel(0, 0, 5, 1);
		JSpinner spinnerChicken = new JSpinner(sm3);
		spinnerChicken.setBounds(350, 218, 38, 20);
		foodTab.add(spinnerChicken);
		
		SpinnerModel sm4 = new SpinnerNumberModel(0, 0, 5, 1);
		JSpinner spinnerSandwich = new JSpinner(sm4);
		spinnerSandwich.setBounds(350, 270, 38, 20);
		foodTab.add(spinnerSandwich);
		
		SpinnerModel sm5 = new SpinnerNumberModel(0, 0, 5, 1);
		JSpinner spinnerWater = new JSpinner(sm5);
		spinnerWater.setBounds(350, 334, 38, 20);
		foodTab.add(spinnerWater);
		/**
		 * Each button buys its type of things
		 */
		JButton btnBuyApples = new JButton("Buy Apples");
		btnBuyApples.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int purchaseNum = (Integer)spinnerApple.getValue();
				try {
				outpost.purchaseApple(new Apple(), purchaseNum, playerShip);
				window.refreshMoney();
				window.updatePlayerDetails();
				} catch (NoNegativeException e) {
					JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
				}
				
			}
		});
		btnBuyApples.setBounds(491, 62, 193, 25);
		foodTab.add(btnBuyApples);
		
		JButton btnBuyCheeseBurger = new JButton("Buy Cheese Burger");
		btnBuyCheeseBurger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int purchaseNum = (Integer)spinnerBurger.getValue();
				try {
				outpost.purchaseCheeseBurger(new CheeseBurger(), purchaseNum, playerShip);
				window.refreshMoney();
				window.updatePlayerDetails();

				} catch (NoNegativeException e) {
					JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
				}
			}
		});
		btnBuyCheeseBurger.setBounds(491, 110, 201, 25);
		foodTab.add(btnBuyCheeseBurger);
		
		JButton btnBuyChocolateCookies = new JButton("Buy Chocolate Cookies");
		btnBuyChocolateCookies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					int purchaseNum = (Integer)spinnerCookie.getValue();
					ChocoCookie cookie = new ChocoCookie();
					try {
					outpost.purchaseCookie(cookie, purchaseNum, playerShip);
					window.refreshMoney();
					window.updatePlayerDetails();

					} catch (NoNegativeException e) {
						JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
					}
			}
		});
		btnBuyChocolateCookies.setBounds(491, 163, 193, 25);
		foodTab.add(btnBuyChocolateCookies);
		
		JButton btnNewButton = new JButton("Buy Roast Chicken");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int purchaseNum = (Integer)spinnerChicken.getValue();

				try {
				outpost.purchaseRoastChicken(new RoastChicken(), purchaseNum, playerShip);
				window.refreshMoney();
				window.updatePlayerDetails();

				} catch (NoNegativeException e) {
					JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
				}
			}
		});
		btnNewButton.setBounds(491, 215, 201, 25);
		foodTab.add(btnNewButton);
		
		JButton btnNewButton1 = new JButton("Buy Egg Sandwich");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int purchaseNum = (Integer)spinnerSandwich.getValue();
				try {
				outpost.purchaseSandwich(new Sandwich(), purchaseNum, playerShip);
				window.refreshMoney();
				window.updatePlayerDetails();

				} catch (NoNegativeException e) {
					JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
				}
			}
		});
		btnNewButton1.setBounds(491, 267, 201, 25);
		foodTab.add(btnNewButton1);
		
		JButton btnBuyWater = new JButton("Buy Water");
		btnBuyWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int purchaseNum = (Integer)spinnerWater.getValue();
				try {
				outpost.purchaseWater(new Water(), purchaseNum, playerShip);
				window.refreshMoney();
				window.updatePlayerDetails();

				} catch (NoNegativeException e) {
					JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
				}
			}
		});
		btnBuyWater.setBounds(491, 331, 193, 25);
		foodTab.add(btnBuyWater);
		
		JPanel medTab = new JPanel();
		tabbedPane.addTab("Medicine", null, medTab, null);
		medTab.setLayout(null);
		
		JLabel lblPlagueMedicine = new JLabel("$ 50 ea Plague Medicine");
		lblPlagueMedicine.setBounds(92, 59, 220, 15);
		medTab.add(lblPlagueMedicine);
		
		JLabel lblProteinForTiredness = new JLabel("$ 100 ea Protein for Tiredness");
		lblProteinForTiredness.setBounds(92, 121, 240, 15);
		medTab.add(lblProteinForTiredness);
		
		JLabel lblVitamins = new JLabel("$ 100 ea Vitamins for Health");
		lblVitamins.setBounds(97, 186, 215, 15);
		medTab.add(lblVitamins);
		
		SpinnerModel sm6 = new SpinnerNumberModel(0, 0, 5, 1);
		JSpinner spinnerPlague = new JSpinner(sm6);
		spinnerPlague.setBounds(444, 57, 50, 20);
		medTab.add(spinnerPlague);
		
		SpinnerModel sm7 = new SpinnerNumberModel(0, 0, 5, 1);
		JSpinner spinnerProtein = new JSpinner(sm7);
		spinnerProtein.setBounds(444, 119, 50, 20);
		medTab.add(spinnerProtein);
		
		SpinnerModel sm8 = new SpinnerNumberModel(0, 0, 5, 1);
		JSpinner spinnerVitamin = new JSpinner(sm8);
		spinnerVitamin.setBounds(444, 172, 50, 20);
		medTab.add(spinnerVitamin);
		
		JButton btnBuyPlagueMedicine = new JButton("Buy Plague Medicine");
		btnBuyPlagueMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int purchaseNum = (Integer)spinnerPlague.getValue();
				try {
				outpost.purchaseAntiPlague(new AntiPlague(), purchaseNum, playerShip);
				window.refreshMoney();
				window.updatePlayerDetails();

				} catch (NoNegativeException e) {
					JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
				}
			}
		});
		btnBuyPlagueMedicine.setBounds(602, 54, 176, 25);
		medTab.add(btnBuyPlagueMedicine);
		
		JButton btnBuyProtein = new JButton("Buy Protein");
		btnBuyProtein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int purchaseNum = (Integer)spinnerProtein.getValue();
				try {
				outpost.purchaseAntiTiredness(new AntiTiredness(), purchaseNum, playerShip);
				window.refreshMoney();
				window.updatePlayerDetails();

				} catch (NoNegativeException e) {
					JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
				}
			}
		});
		btnBuyProtein.setBounds(602, 116, 176, 25);
		medTab.add(btnBuyProtein);
		
		JButton btnBuyVitamin = new JButton("Buy Vitamin");
		btnBuyVitamin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int purchaseNum = (Integer)spinnerVitamin.getValue();
				try {
				outpost.purchaseMaxHealth(new MaxHealth(), purchaseNum, playerShip);
				window.refreshMoney();
				window.updatePlayerDetails();

				} catch (NoNegativeException e) {
					JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
				}
			}
		});
		btnBuyVitamin.setBounds(602, 176, 176, 25);
		medTab.add(btnBuyVitamin);
		
		JPanel moneyTab = new JPanel();
		tabbedPane.addTab("Money", null, moneyTab, null);
		moneyTab.setLayout(null);
		
		JLabel lblIfYouDont = new JLabel("If you dont have enough game money , You can buy more with real money.  :)  :)  :)");
		lblIfYouDont.setBounds(78, 75, 723, 45);
		moneyTab.add(lblIfYouDont);
		
		JLabel lblHowMuchYou = new JLabel("How much you want to you want to spend");
		lblHowMuchYou.setBounds(78, 154, 307, 19);
		moneyTab.add(lblHowMuchYou);
		
		textField1 = new JTextField();
		textField1.setBounds(403, 152, 124, 19);
		moneyTab.add(textField1);
		textField1.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(349, 194, 256, 81);
		moneyTab.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Credit Crad");
		rdbtnNewRadioButton.setBounds(8, 8, 144, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnDebitCard = new JRadioButton("Debit Card");
		rdbtnDebitCard.setBounds(8, 50, 144, 23);
		panel.add(rdbtnDebitCard);
		
		JLabel lblCardNumber = new JLabel("Card Number ");
		lblCardNumber.setBounds(96, 296, 216, 15);
		moneyTab.add(lblCardNumber);
		
		JLabel lblCcc = new JLabel("CCC");
		lblCcc.setBounds(96, 343, 175, 15);
		moneyTab.add(lblCcc);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setBounds(96, 386, 146, 15);
		moneyTab.add(lblExpiryDate);
		
		textField2 = new JTextField();
		textField2.setBounds(309, 294, 285, 19);
		moneyTab.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(309, 341, 124, 19);
		moneyTab.add(textField3);
		textField3.setColumns(10);
		
		textField4 = new JTextField();
		textField4.setBounds(309, 384, 124, 19);
		moneyTab.add(textField4);
		textField4.setColumns(10);
		
		JButton btnClickToConfirm = new JButton("Click to confirm Purchase");
		btnClickToConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Just Kidding, this game is freeeeeeee   ","INFOMATION", JOptionPane.OK_OPTION); 
				lblKidding.setText(" :) :) :) :) :) :) :) :) :) :) :) :) :) :) :)"); 
				lblKidding.setFont(new Font("IPAPGothic", Font.BOLD, 16));
				lblKidding.setForeground(Color.RED);
			}
		});
		btnClickToConfirm.setBounds(319, 441, 286, 25);
		moneyTab.add(btnClickToConfirm);
		
		lblKidding = new JLabel("");
		lblKidding.setBounds(209, 29, 318, 34);
		moneyTab.add(lblKidding);
		
		JLabel lblMoneyAvailable = new JLabel("Money Available:  " );//+ getAmount());
		lblMoneyAvailable.setBounds(587, 51, 140, 15);
		frame.getContentPane().add(lblMoneyAvailable);
		
		JLabel lblMoney = new JLabel("");
		lblMoney.setBounds(749, 51, 90, 15);

		frame.getContentPane().add(lblMoney);
		
		JButton btnBcakToGame = new JButton("Back to Game");
		btnBcakToGame.setBounds(87, 30, 190, 25);
		frame.getContentPane().add(btnBcakToGame);
		btnBcakToGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		frame.setBounds(100, 100, 959, 675);
		
	}
}
