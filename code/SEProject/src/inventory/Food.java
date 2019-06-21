package inventory;
/**
 * Class food extents Class Item
 * @author amo174, mwi67
 *
 */
public abstract class Food extends Item{
	/**
	 * The health of crew member
	 */
	protected int health;
	/**
	 * Return screw member health
	 * @return health
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * Returns String
	 */
	public String toString() {
		return String.format("%s x1 Decrease your hunger level by %s", getItemName(),getHealth());

	}
}