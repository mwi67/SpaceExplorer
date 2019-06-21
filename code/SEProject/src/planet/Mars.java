package planet;

import java.util.ArrayList;
import java.util.Arrays;

import inventory.Apple;
import inventory.CheeseBurger;
import inventory.ChocoCookie;
import inventory.Item;
import inventory.Part;
import inventory.RoastChicken;
import inventory.Sandwich;
import inventory.Water;
/**
 * Mars class extension of Planet class
 * It has 8 items to pick up when searched.
 * @author amo174, mwi67
 *
 **/
public class Mars extends Planet{
	public Mars() {
		super.planetName = "Mars";
		
		super.pickUpList = new ArrayList<Item>(Arrays.asList(new Apple(), new CheeseBurger(), new ChocoCookie(), new RoastChicken(), new CheeseBurger(), new Sandwich(), new Water(), new Part()));
	}

}
