package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import inventory.*;
import planet.Mars;

class PlanetTesting {

	@Test
	public void getPickUpListLengthTest() {
		Mars mars = new Mars();
		assertEquals(8, mars.getPickUpListLength());
	}
	
	@Test
	public void addPickUpListTest() {
		Mars mars = new Mars();
		Apple apple = new Apple();
		mars.addPickUpList(apple);
		assertEquals(9, mars.getPickUpListLength());
	}
	
	@Test
	public void removePickUpItemTest() {
		Mars mars = new Mars();
		Apple apple = new Apple();
		mars.addPickUpList(apple);
		assertEquals(9, mars.getPickUpListLength());
		mars.removePickUpItem(apple);
		assertEquals(8, mars.getPickUpListLength());
	}
	
	@Test
	public void giveRandomItem() {
		Mars mars = new Mars();
		Apple apple = new Apple();
		mars.addPickUpList(apple);
		assertEquals(apple, mars.giveRandomItem(8));
	}
}

//Done-----------------------------------------------------------------------------
