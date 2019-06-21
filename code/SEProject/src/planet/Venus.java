package planet;

import java.util.ArrayList;
import java.util.Arrays;

import inventory.AntiPlague;
import inventory.AntiTiredness;
import inventory.ChocoCookie;
import inventory.Item;
import inventory.Money;
import inventory.Part;
import inventory.RoastChicken;
/**
 * Venus class extension of Planet class
 * It has 8 items to pick up when searched.
 * @author amo174, mwi67
 *
 **/
public class Venus extends Planet{
	public Venus(){
		super.planetName = "Venus";
		super.pickUpList = new ArrayList<Item>(Arrays.asList(new ChocoCookie(), new RoastChicken(), new AntiPlague(), new AntiTiredness(), new Money(100), new Money(500), new Money(5), new Part()));
	}
}
