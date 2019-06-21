package planet;

import java.util.ArrayList;
import java.util.Arrays;

import inventory.Item;
import inventory.Part;
import inventory.Water;
/**
 * Earth class extension of Planet class
 * It has 8 items to pick up when searched.
 * @author amo174, mwi67
 *
 */
public class Earth extends Planet{
	public Earth() {
		super.planetName = "Earth";
		super.pickUpList = new ArrayList<Item>(Arrays.asList(new Water(), new Water(), new Water(), new Water(), new Water(), new Water(), new Water(), new Part()));
		
	}

}
