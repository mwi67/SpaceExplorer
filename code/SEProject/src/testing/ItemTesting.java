package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import inventory.MaxHealth;
import inventory.Water;

class ItemTesting {
	
	Water water = new Water();
	MaxHealth max = new MaxHealth();
	

	@Test
	public void getItemNameTest() {
		assertEquals("Water", water.getItemName());
		assertEquals("MaxHealth", max.getItemName());
	}
	
	@Test
	public void getPriceTest() {
		assertEquals(20, water.getPrice());
		assertEquals(100, max.getPrice());
	}
}

//Done---------------------------------------------------------------------------
