package inventory;
/**
 * Class AntiTiredness extents from Medicine
 * Has medicine name, price and its use
 * @author mwi67, amo174
 *
 */
public class AntiTiredness extends Medicine{
	
	public AntiTiredness() {
		super.itemName = "AntiTiredness";
		super.price = 100;
		super.medUsage = "To treat your tiredness";
	}
}