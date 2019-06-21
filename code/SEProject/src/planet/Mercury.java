package planet;

import java.util.ArrayList;
import java.util.Arrays;

import inventory.AntiPlague;
import inventory.AntiTiredness;
import inventory.ChocoCookie;
import inventory.Item;
import inventory.MaxHealth;
import inventory.Money;
import inventory.Part;
/**
 * Mercury class extension of Planet class
 * It has 8 items to pick up when searched.
 * @author amo174, mwi67
 *
 **/
public class Mercury extends Planet{
	public Mercury() {
		super.planetName = "Mercury";
		
		super.pickUpList = new ArrayList<Item>(Arrays.asList(new AntiPlague(), new AntiTiredness(), new MaxHealth(), new ChocoCookie(), new ChocoCookie(), new Money(5), new Money(100), new Part()));
	}

}
