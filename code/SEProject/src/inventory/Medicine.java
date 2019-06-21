package inventory;
/**
 * Class Medicine extends Item
 * @author mwi67, amo174
 *
 */
public abstract class Medicine extends Item{
	/**
	 * The use of medUsage 
	 */
	protected String medUsage;
	/**
	 * Gets med use string
	 * @return medUsage String
	 */
	public String getUsage(){
		return medUsage;
	}
	/**
	 * Returns String.format
	 */
	public String toString() {
		return String.format("%s x1 %s",getItemName(), getUsage());
	}
	
}