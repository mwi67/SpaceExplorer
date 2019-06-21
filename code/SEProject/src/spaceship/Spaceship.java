package spaceship;

import java.util.ArrayList;
import java.util.Random;
import crewMember.*;
import inventory.*;
import planet.*;
/**
 * Class spaceship 
 * Handles Location, Shields level, parts collected etc.
 * @author mwi67, amo174
 *
 */
public class Spaceship {
	/**
	 * Takes a string for user set spaceship.
	 * @param shipName String 
	 */
	public Spaceship(String shipName) {
		shieldLevel = 1;
		currentMoney = new Money(100);
		inventoryList = new ArrayList<Item>();
		partsCollected = new ArrayList<Part>();
		this.shipName = shipName;
	}
	/**
	 * The spaceship name
	 */
	private String shipName;
	/**
	 * The amount of Money crew has.
	 */
	private Money currentMoney;
	/**
	 * The inventory list of the crew.
	 */
	public static ArrayList<Item> inventoryList;
	/**
	 * The crew list
	 */
	private ArrayList<CrewMember> crewList;
	/**
	 * The Shield level
	 */
	private static int shieldLevel;
	/**
	 * The current location
	 */
	private Planet currentLocation;
	/**
	 * The list of spaceship parts collected
	 */
	private ArrayList<Part> partsCollected;
	
	/**
	 * Reduces the shield's level
	 * @param down integer
	 */
	public void minusShield(int down) {
		shieldLevel -= down;
	}
	/**
	 * Returns user set spaceship name. 
	 * @return
	 */
	public String getSpaceshipNmae() {
		return shipName;
	}
	/**
	 * Return current shield level.
	 * @return integer shield level.
	 */
	public int getShieldLevel() {
		return shieldLevel;
	}
	/**
	 * Increases shield level 
	 * @param  up integer
	 */
	public void addShield(int up) {
		shieldLevel += up;
	}
	/**
	 * Sets current location
	 * @param planet  Planet 
	 */
	public void setLocation(Planet planet) {
		currentLocation = planet;
	}
	/**
	 * Gets the current location.
	 * @return Planet type planet
	 */
	public Planet getLocation() {
		return currentLocation;
	}
	/**
	 * Returns amount of  money crew has.
	 * @return currentMoney  amount of money
	 */
	public int getMoney() {
		return currentMoney.getAmount();
	}
	/**
	 * Adds money to crew's  money
	 * @param amount integer
	 */
	public void addMoney(int amount) {
		currentMoney.addMoney(amount);
	}
	/**
	 * Reduces crew's money when purchased something
	 * @param amount integer 
	 */
	public void minusMoney(int amount) {
		currentMoney.minusMoney(amount);
	}
	/**
	 * Returns number of parts collected.
	 * @return integer length of array list.
	 */
	public int getPartsCollected() {
		if (partsCollected.size() == 0) {
			return 0;
		}else {
			return partsCollected.size();
			}
	}

	/**
	 * Gets the inventory list.
	 * @return Array list of Items
	 */
	public ArrayList<Item> getItemList(){
		return inventoryList;
	}
	/**
	 * Gets the length of the inventory list.
	 * @return integer size
	 */
	public int getItemListLength() {
		return inventoryList.size();
	}
	/**
	 * Takes items and adds it to the list.
	 * @param toAddList Item 
	 */
	public void addInventoryList(ArrayList<? extends Item> toAddList){
		inventoryList.addAll(toAddList);
	}
	/**
	 * Reduces shield level by 1 if hit by asteroid belt
	 * @return String message for user
	 */
	public String getAsteroidAttack() {
		minusShield(2);
		return "Got damaged from the asteroid belt!!";
	}
		
	//Actions----------------------------------------------------------------------------\
	/**
	 * Searches a planet with one action from one crew member.
	 * @param planet   type of  Planet 
	 * @param member  type of CrewMember 
	 * @return what user found by searching  a planet if the find an item,
	 *  else return String they could'nt find anything.
	 */
	public String searchPlanet(Planet planet, CrewMember member) {
		
		member.minusAction();
		member.addFullness(50);
		
		Random rand = new Random();
		int randomElement = rand.nextInt(100) + 1;
		
		if (! (member instanceof Captain)) {
			member.addTiredness(25);
		
			} 
		
		if (member.getSearch() >= randomElement) {
			
			int pickUpListLength = planet.getPickUpListLength();
			
			if(pickUpListLength <= 0) {
				return "No items on the planet";
			}
			
			int index = rand.nextInt(pickUpListLength);
			
			Item itemFound = planet.giveRandomItem(index);
			
			if(itemFound instanceof Part){
				shieldLevel += 1;
				partsCollected.add((Part)itemFound);
				planet.removePickUpItem(itemFound);
				return itemFound.getItemInfo();
				
			}
			else if(itemFound instanceof Money) {
				currentMoney.addMoney(((Money) itemFound).getAmount());
				planet.removePickUpItem(itemFound);
				return itemFound.getItemInfo();
			}
			else {
				inventoryList.add(itemFound);
				return itemFound.getItemInfo();
				
			}
		}
		else {
			return "Couldn't find anything";
		}
	}
	
	/**
	 * Repairs ship by a crew member with one action. 
	 * @param member   type of CrewMember
	 */
	public void fixShield(CrewMember member) {
		
		member.minusAction();
		
		Random rand = new Random();
		int randomElement = rand.nextInt(100);
		
		if(randomElement <= member.getRepair()) {
			// Increases progress bar
			shieldLevel += 1;
		}
		
		if (! (member instanceof Engineer)) {
			member.minusTiredness(20);
			} 
	}
	/**
	 * Removes an item from inventory.
	 * @param item type of Item.
	 */
	public void removeInventoryList(Item item) {
		inventoryList.remove(item);
	}
	/**
	 * Adds crew member to crewList
	 * @param crew CrewMember
	 */
	public void addCrew(CrewMember crew) {
		crewList.add(crew);
	}
	/**
	 * Adds part to the parts collected list.
	 * @param pList part type of Item
	 */
	public void addPart(ArrayList<Part> pList) {
		partsCollected.addAll(pList);
	}

}
