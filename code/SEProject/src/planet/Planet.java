package planet;


import java.util.ArrayList;
import inventory.*;
/**
 * Planet class.
 * Helps manage and access Planet sub classes.
 * @author amo174, mwi67
 *
 **/
public abstract class Planet {
	/**
	 * The planet name
	 */
	protected String planetName;
	/**
	 * The status of if we visited a planet
	 */
	protected boolean hasLanded = false;
	/**
	 * The list of things got picked up from different planets.
	 */
	protected ArrayList<Item> pickUpList;
	
    /**
     *Gets planet name. 
     * @return String planet name
     */
	public String getPlanetName() {
		return planetName;
	}
	/**
	 * Checks if we have previous landed in a planet.
	 * @return boolean
	 */
	public boolean getHasLanded() {
		return hasLanded;
	}
	/**
	 * Sets true when we land on a planet. 
	 * @param value takes boolean 
	 */
	public void setLanded(boolean value) {
		value = hasLanded;
	}
	/**
	 * Returns how many times we picked up.
	 * @return integer size
	 */
	public int getPickUpListLength() {
		return pickUpList.size();
	}
	/**
	 * removes an item form the array of items we picked up or bought. 
	 * @param item Item
	 */
	public void removePickUpItem(Item item) {
		pickUpList.remove(item);
		
	}
	/**
	 * Returns a string, name of the planet how many things it has left.
	 */
	public String toString() {
		return String.format("%s: It has %s items", getPlanetName(),getPickUpListLength());
	}
	/**
	 * Returns removed picked up item .
	 * @return an item type.
	 */
	public Item giveRandomItem(int index) {
		return pickUpList.remove(index);
	}
	/**
	 * Adds item in a planet
	 * @param item
	 */
	public void addPickUpList(Item item) {
		pickUpList.add(item);
	}

}
