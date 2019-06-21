package planet;

import java.util.ArrayList;
import java.util.Arrays;

import inventory.AntiPlague;
import inventory.AntiTiredness;
import inventory.Apple;
import inventory.Item;
import inventory.MaxHealth;
import inventory.Part;
import inventory.Sandwich;
/**
 * Jupiter class extension of Planet class
 * It has 8 items to pick up when searched.
 * @author amo174, mwi67
 *
 **/
public class Jupiter extends Planet{
	public Jupiter() {
		super.planetName = "Jupiter";
		
		super.pickUpList = new ArrayList<Item>(Arrays.asList(new Sandwich(), new Sandwich(), new Apple(), new Apple(), new AntiTiredness(), new AntiPlague(), new MaxHealth(), new Part()));
	}

}
