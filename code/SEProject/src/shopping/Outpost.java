package shopping;

import java.util.ArrayList;
import error.*;
import inventory.*;
import spaceship.*;

/**
 * Class Outpost 
 * User can buy food and medicine, provided they have enough money to do so.  
 * @author mwi67, amo174
 *
 */
public class Outpost {
	
	public Outpost() {
	}
	/**
	 * Creates an Array list for ChocoCookie.
	 * And  keeps trace how many we have and adds it to inventory list,
	 * @param quantity    To add to list
	 * @return cookieList    Array list of cookies
	 */
	public ArrayList<ChocoCookie> createCookies(int quantity){
		ArrayList<ChocoCookie> cookieList = new ArrayList<ChocoCookie>(); 
		for(int counter = 0; counter < quantity; counter++) {
			cookieList.add(new ChocoCookie());
		}
		return cookieList;
	}
	
	/**
	 * check the cookie price times quantity
	 * if Money available minus purchase price great than zero then calls createCookies(int quantity).
	 * 
	 * @param cookie  type of ChocoCookie.
	 * @param quantity  integer number of cookies to purchases.
	 * @param spaceShip type Spaceship.
	 */
	public void purchaseCookie(ChocoCookie cookie, int quantity, Spaceship spaceShip) {
		int purchasePrice = cookie.getPrice() * quantity;
		int moneyAvailable = spaceShip.getMoney();
		
		if ((moneyAvailable - purchasePrice) >= 0) {
			spaceShip.addInventoryList(createCookies(quantity));
			spaceShip.minusMoney(purchasePrice);
		}
		else {
			throw new NoNegativeException("You don't have enough money sorry");
		}

	}
	/**
	 *  Creates an Array list for  medicine Maxhealth.
	 * @param quantity    To add to list
	 * @return ArrayList     list of Maxhealth medicine
	 */
	public ArrayList<MaxHealth> createMaxHealth(int quantity){
		ArrayList<MaxHealth> maxHealthList = new ArrayList<MaxHealth>(); 
		for(int counter = 0; counter < quantity; counter++) {
		maxHealthList.add(new MaxHealth());
		}
		return maxHealthList;
	}
	/**
	 * check the MaxHealth medicine price times quantity
	 * if Money available minus purchase price great than zero then calls createMaxHealth(int quantity).
	 * @param maxHealth        type of medicine
	 * @param quantity         number of it  needed 
	 * @param spaceShip        Type of Spaceship
	 */
	public void purchaseMaxHealth(MaxHealth maxHealth, int quantity, Spaceship spaceShip) {
		int purchasePrice = maxHealth.getPrice() * quantity;
		int moneyAvailable = spaceShip.getMoney();
		
		if ((moneyAvailable - purchasePrice) >= 0) {
			spaceShip.addInventoryList(createMaxHealth(quantity));
			spaceShip.minusMoney(purchasePrice);
		}
		else {
			throw new NoNegativeException("You don't have enough money sorry");
		}
	}
	/**
	 *   Creates an Array list for  medicine antiPlague.
	 * @param quantity  To add to list
	 * @return ArrayList     list of  AntiPlague medicine
	 */
	public ArrayList<AntiPlague> createAntiPlague(int quantity){
		ArrayList<AntiPlague> antiPlagueList = new ArrayList<AntiPlague>(); 
		for(int counter = 0; counter < quantity; counter++) {
			antiPlagueList.add(new AntiPlague());
		}
		return antiPlagueList;
	}
	/**
	 *  check the AntiPlague medicine price times quantity
	 * if Money available minus purchase price great than zero then calls createMaxHealth(int quantity).
	 * @param antiPlague       type of medicine
	 * @param quantity         number of it  needed 
	 * @param spaceShip        Type of Spaceship
	 */
	public void purchaseAntiPlague(AntiPlague antiPlague, int quantity, Spaceship spaceShip) {
		int purchasePrice = antiPlague.getPrice() * quantity;
		int moneyAvailable = spaceShip.getMoney();
		
		if ((moneyAvailable - purchasePrice) >= 0) {
			spaceShip.addInventoryList(createAntiPlague(quantity));
			spaceShip.minusMoney(purchasePrice);
		}
		else {
			throw new NoNegativeException("You don't have enough money sorry");
		}
	}
	/**
	 *   Creates an Array list for  medicine tiredness
	 * @param quantity    To add to list
	 * @return  ArrayList     list of  AntiTiredness medicine
	 */
	public ArrayList<AntiTiredness> createAntiTiredness(int quantity){
		ArrayList<AntiTiredness> antiTirednessList = new ArrayList<AntiTiredness>(); 
		for(int counter = 0; counter < quantity; counter++) {
			antiTirednessList.add(new AntiTiredness());
		}
		return antiTirednessList;
	}
	/**
	 *  check the AntiTirness medicine price times quantity
	 * if Money available minus purchase price great than zero then calls createAntiTiredness(int quantity).
	 * @param antiTiredness               type of medicine
	 * @param quantity                    number of it  needed
	 * @param spaceShip                   Type of Spaceship
	 */
	public void purchaseAntiTiredness(AntiTiredness antiTiredness, int quantity, Spaceship spaceShip) {
		int purchasePrice = antiTiredness.getPrice() * quantity;
		int moneyAvailable = spaceShip.getMoney();
		
		if ((moneyAvailable - purchasePrice) >= 0) {
			spaceShip.addInventoryList(createAntiTiredness(quantity));
			spaceShip.minusMoney(purchasePrice);
		}
		else {
			throw new NoNegativeException("You don't have enough money sorry");
		}
	}
	/**
	 * Creates an Array list for Apple.
	 * And  keeps trace how many we have and adds it to inventory list,
	 * @param quantity     number of it  needed
	 * @return ArrayList   Array list of Apples
	 */
	public ArrayList<Apple> createApple(int quantity){
		ArrayList<Apple> appleList = new ArrayList<Apple>(); 
		for(int counter = 0; counter < quantity; counter++) {
			appleList.add(new Apple());
		}
		return appleList;
	}
	/**
	 *  check the Apples price times quantity
	 * if Money available minus purchase price great than zero then calls createCookies(int quantity).
	 * @param apple         type of apple
	 * @param quantity       number of it needed     
	 * @param spaceShip      type of spaceship
	 */
	public void purchaseApple(Apple apple, int quantity, Spaceship spaceShip) {
		int purchasePrice = apple.getPrice() * quantity;
		int moneyAvailable = spaceShip.getMoney();
		
		if ((moneyAvailable - purchasePrice) >= 0) {
			spaceShip.addInventoryList(createApple(quantity));
			spaceShip.minusMoney(purchasePrice);
		}
		else {
			throw new NoNegativeException("You don't have enough money sorry");
		}
	}
	/**
	 * Creates an Array list for CheeseBurger.
	 * And  keeps trace how many we have and adds it to inventory list,
	 * @param quantity    number of it  needed
	 * @return ArrayList   Array list of CheeseBurger
	 */
	public ArrayList<CheeseBurger> createCheeseBurger(int quantity){
		ArrayList<CheeseBurger> cheeseBurgerList = new ArrayList<CheeseBurger>(); 
		for(int counter = 0; counter < quantity; counter++) {
			cheeseBurgerList.add(new CheeseBurger());
		}
		return cheeseBurgerList;
	}
	/**
	 *   check the CheeseBurger price times quantity
	 * if Money available minus purchase price great than zero then calls createCheeseBurger(int quantity).
	 * @param cheeseBurger   type of CheeseBurger
	 * @param quantity       number of it needed     
	 * @param spaceShip      type of spaceship
	 */
	public void purchaseCheeseBurger(CheeseBurger cheeseBurger, int quantity, Spaceship spaceShip) {
		int purchasePrice = cheeseBurger.getPrice() * quantity;
		int moneyAvailable = spaceShip.getMoney();
		
		if ((moneyAvailable - purchasePrice) >= 0) {
			spaceShip.addInventoryList(createCheeseBurger(quantity));
			spaceShip.minusMoney(purchasePrice);
		}
		else {
			throw new NoNegativeException("You don't have enough money sorry");
		}
	}
	/**
	 * Creates an Array list for RoastChicken.
	 * And  keeps trace how many we have and adds it to inventory list,
	 * @param quantity    number of it  needed
	 * @return ArrayList   Array list of RoastChicken
	 */
	public ArrayList<RoastChicken> createRoastChicken(int quantity){
		ArrayList<RoastChicken> roastChickenList = new ArrayList<RoastChicken>(); 
		for(int counter = 0; counter < quantity; counter++) {
			roastChickenList.add(new RoastChicken());
		}
		return roastChickenList;
	}
	/**
	 * check the RoastChicken price times quantity
	 * if Money available minus purchase price great than zero then calls createRoastChicken(int quantity).
	 * @param roastChicken   type of RoastChicken
	 * @param quantity       number of it needed     
	 * @param spaceShip      type of spaceship
	 */
	public void purchaseRoastChicken(RoastChicken roastChicken, int quantity, Spaceship spaceShip) {
		int purchasePrice = roastChicken.getPrice() * quantity;
		int moneyAvailable = spaceShip.getMoney();
		
		if ((moneyAvailable - purchasePrice) >= 0) {
			spaceShip.addInventoryList(createRoastChicken(quantity));
			spaceShip.minusMoney(purchasePrice);
		}
		else {
			throw new NoNegativeException("You don't have enough money sorry");
		}
	}
	/**
	 *Creates an Array list for Sandwich.
	 * And  keeps trace how many we have and adds it to inventory list,
	 * @param quantity    number of it  needed
	 * @return ArrayList   Array list of Sandwich
	 */
	public ArrayList<Sandwich> createSandwich(int quantity){
		ArrayList<Sandwich> sandwichList = new ArrayList<Sandwich>(); 
		for(int counter = 0; counter < quantity; counter++) {
			sandwichList.add(new Sandwich());
		}
		return sandwichList;
	}
	/**
	 * check the Sandwich price times quantity
	 * if Money available minus purchase price great than zero then calls createSandwich(int quantity).
	 * @param sandwich     type of Sandwich
	 * @param quantity       number of it needed     
	 * @param spaceShip      type of spaceship
	 */
	public void purchaseSandwich(Sandwich sandwich, int quantity, Spaceship spaceShip) {
		int purchasePrice = sandwich.getPrice() * quantity;
		int moneyAvailable = spaceShip.getMoney();
		
		if ((moneyAvailable - purchasePrice) >= 0) {
			spaceShip.addInventoryList(createSandwich(quantity));
			spaceShip.minusMoney(purchasePrice);
		}
		else {
			throw new NoNegativeException("You don't have enough money sorry");
		}
	}
	/**
	 * Creates an Array list for Water.
	 * And  keeps trace how many we have and adds it to inventory list,
	 * @param quantity    number of it  needed
	 * @return ArrayList   Array list of Water
	 */
	public ArrayList<Water> createWater(int quantity){
		ArrayList<Water> waterList = new ArrayList<Water>(); 
		for(int counter = 0; counter < quantity; counter++) {
			waterList.add(new Water());
		}
		return waterList;
	}
	/**
	 * check the Water price times quantity
	 * if Money available minus purchase price great than zero then calls createWater(int quantity).
	 * @param water     type of Water
	 * @param quantity       number of it needed     
	 * @param spaceShip      type of spaceship
	 */
	public void purchaseWater(Water water, int quantity, Spaceship spaceShip) {
		int purchasePrice = water.getPrice() * quantity;
		int moneyAvailable = spaceShip.getMoney();
		
		if ((moneyAvailable - purchasePrice) >= 0) {
			spaceShip.addInventoryList(createWater(quantity));
			spaceShip.minusMoney(purchasePrice);
		}
		else {
			throw new NoNegativeException("You don't have enough money sorry");
		}
	}
	
}

