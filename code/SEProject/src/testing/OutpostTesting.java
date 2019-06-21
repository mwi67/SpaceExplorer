package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import inventory.ChocoCookie;
import shopping.Outpost;
import spaceship.Spaceship;

class OutpostTesting {
	
	@Test
	public void purchaseCookiesTest() {
		Outpost shop = new Outpost();
		Spaceship yamato = new Spaceship("yamato");
		ChocoCookie cookie = new ChocoCookie();
		shop.purchaseCookie(cookie, 3, yamato);
		assertEquals(3, yamato.getItemListLength());
		assertEquals(94, yamato.getMoney());
	}

}

//Done-----------------------------------------