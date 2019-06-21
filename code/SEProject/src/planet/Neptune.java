package planet;

import java.util.ArrayList;
import java.util.Arrays;

import inventory.AntiPlague;
import inventory.Apple;
import inventory.Item;
import inventory.Part;
import inventory.RoastChicken;
import inventory.Sandwich;
/**
 * Neptune class extension of Planet class
 * It has 8 items to pick up when searched.
 * @author amo174, mwi67
 *
 **/
public class Neptune extends Planet{
	public Neptune() {
		super.planetName = "Neptune";
		
		super.pickUpList = new ArrayList<Item>(Arrays.asList(new Part(), new Sandwich(), new RoastChicken(), new Apple(), new Apple(), new Apple(), new AntiPlague(), new AntiPlague()));
	}

}
