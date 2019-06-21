package inventory;
/**
 * Class MaxHealth extents from Medicine
 * Has medicine name, price and its use
 * @author mwi67, amo174
 *
 */
public class MaxHealth extends Medicine{
	
	public MaxHealth() {
		super.itemName = "MaxHealth";
		super.price = 100;
		super.medUsage = "To put your health to max";
		
	}
}