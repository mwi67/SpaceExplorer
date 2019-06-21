package planet;

import java.util.ArrayList;
import java.util.Arrays;

import inventory.AntiPlague;
import inventory.AntiTiredness;
import inventory.Apple;
import inventory.CheeseBurger;
import inventory.ChocoCookie;
import inventory.Item;
import inventory.Money;
import inventory.Part;
import inventory.Sandwich;
/**
 * Moon class extension of Planet class
 * It has 8 items to pick up when searched.
 * @author amo174, mwi67
 *
 **/
public class Moon extends Planet{
	public Moon() {
		super.planetName = "Moon";
		super.hasLanded = true;
		super.pickUpList = new ArrayList<Item>(Arrays.asList(new CheeseBurger(), new AntiTiredness(), new Sandwich(), new ChocoCookie(), new AntiPlague(), new Apple(), new Money(100), new Part()));
		
	}

}
