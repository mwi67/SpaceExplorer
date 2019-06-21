package planet;

import java.util.ArrayList;
import java.util.Arrays;

import inventory.Item;
import inventory.Money;
import inventory.Part;
/**
 * Pluto class extension of Planet class
 * It has 8 items to pick up when searched.
 * @author amo174, mwi67
 *
 **/
public class Pluto extends Planet{
	public Pluto() {
		super.planetName = "Pluto";
		
		super.pickUpList = new ArrayList<Item>(Arrays.asList(new Part(), new Money(50), new Money(50), new Money(50), new Money(1), new Money(1), new Money(2), new Money(500)));
	}

}
