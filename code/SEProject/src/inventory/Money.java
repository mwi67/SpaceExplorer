package inventory;
/**
 * Class Money extends Item
 * @author mwi67, amo174
 *
 */
public class Money extends Item{
	/**
	 * The amount of money
	 */
	protected int amount;
	/**
	 * The amount as string
	 */
	protected String amount_str;
	/**
	 * Type of item Money
	 * and its value as amount
	 * @param amount
	 */
	public Money(int amount) {
		super.itemName = "Money";
		this.amount = amount;
	}
	/**
	 * Gets current about crew has
	 * @return
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * Sets amount value
	 * @param num integer
	 */
	public void setAmount(int num) {
		amount = num;
	}
	/**
	 * Adds money value to current amount 
	 * @param amount integer
	 */
	public void addMoney(int amount) {
		this.amount += amount;
	}
	/**
	 * Reduces the money when money spend on something
	 * @param amount integer
	 */
	public void minusMoney(int amount) {
		this.amount -= amount;
	}
	/**
	 * Returns String.format
	 */
	public String toString() {
		return String.format(" %s",getAmount());
	}

}
