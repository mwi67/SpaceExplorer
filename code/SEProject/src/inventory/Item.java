package inventory;
/**
 * Class Item
 * @author mwi67, amo174
 *
 */
public  abstract class Item {
	/**
	 * The item name
	 */
	protected String itemName;
	/**
	 * The price of an item
	 */
	protected int price;
	/**
	 * Returns item name
	 * @return itemName String
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * Returns price of an item
	 * @return price integer
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * returns string
	 * @return String.format
	 */
	public String getItemInfo() {
		return String.format("You picked up %s!", getItemName());
	}
	
}