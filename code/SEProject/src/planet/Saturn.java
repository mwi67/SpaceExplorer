package planet;

import java.util.ArrayList;
import java.util.Arrays;

import inventory.Apple;
import inventory.CheeseBurger;
import inventory.ChocoCookie;
import inventory.Item;
import inventory.MaxHealth;
import inventory.Part;
/**
 * Saturn class extension of Planet class
 * It has 8 items to pick up when searched.
 * @author amo174, mwi67
 *
 **/
public class Saturn extends Planet{
	public Saturn() {
		super.planetName = "Saturn";
		
		super.pickUpList = new ArrayList<Item>(Arrays.asList(new Part(), new ChocoCookie(), new ChocoCookie(), new CheeseBurger(), new CheeseBurger(), new Apple(), new Apple(), new MaxHealth()));
	}

}
