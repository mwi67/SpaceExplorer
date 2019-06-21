package inventory;
/**
 * Class AntiPlague extents from Medicine
 * Has medicine name, price and its use
 * @author mwi67, amo174
 *
 */
public class AntiPlague extends Medicine{
	
	public AntiPlague() {
		super.itemName = "AntiPlague";
		super.price = 50;
		super.medUsage = "To treat plague infection";
	}
}