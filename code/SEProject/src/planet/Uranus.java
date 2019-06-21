package planet;

import java.util.ArrayList;
import java.util.Arrays;

import inventory.CheeseBurger;
import inventory.ChocoCookie;
import inventory.Item;
import inventory.MaxHealth;
import inventory.Money;
import inventory.Part;
import inventory.RoastChicken;
/**
 * Uranus class extension of Planet class
 * It has 8 items to pick up when searched.
 * @author amo174, mwi67
 *
 **/
public class Uranus extends Planet{
	public Uranus() {
		super.planetName = "Uranus";
		
		super.pickUpList = pickUpList = new ArrayList<Item>(Arrays.asList(new Part(), new MaxHealth(), new ChocoCookie(), new ChocoCookie(), new ChocoCookie(), new RoastChicken(), new CheeseBurger(), new Money(100)));
	}

}
