package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import crewMember.*;
import inventory.*;
import planet.Mars;
import spaceship.Spaceship;


class SpaceshipTesting {
	
	
	
	@Test
	public void minusShieldTest() {
		Spaceship yamato = new Spaceship("Yamato");
		yamato.minusShield(1);
		assertEquals(0, yamato.getShieldLevel());
	}
	
	@Test
	public void addShieldTest() {
		Spaceship yamato = new Spaceship("Yamato");
		yamato.addShield(1);
		assertEquals(2, yamato.getShieldLevel());
	}
	
	@Test
	public void getMoneyTest() {
		Spaceship yamato = new Spaceship("Yamato");
		assertEquals(100, yamato.getMoney());
	}
	
	@Test
	public void addMoneyTest() {
		Spaceship yamato = new Spaceship("Yamato");
		yamato.addMoney(50);
		assertEquals(150, yamato.getMoney());
	}
	
	@Test
	public void minusMoneyTest() {
		Spaceship yamato = new Spaceship("Yamato");
		yamato.minusMoney(50);
		assertEquals(50, yamato.getMoney());
	}
	
	@Test
	public void getPartsCollectedTest() {
		Spaceship yamato = new Spaceship("Yamato");
		assertEquals(0, yamato.getPartsCollected());
		ArrayList<Part> partList = new ArrayList<Part>(Arrays.asList(new Part(), new Part()));
		yamato.addPart(partList);
		assertEquals(2, yamato.getPartsCollected());
	}
	
	@Test
	public void getItemListLengthTest() {
		Spaceship yamato = new Spaceship("Yamato");
		ArrayList<Item> appleList = new ArrayList<Item>(Arrays.asList(new Apple(), new Apple()));
		yamato.addInventoryList(appleList);
		assertEquals(2, yamato.getItemListLength());
	}
	
	@Test
	public void addInventoryListTest() {
		Spaceship yamato = new Spaceship("Yamato");
		ArrayList<Item> appleList = new ArrayList<Item>(Arrays.asList(new Apple(), new Apple()));
		yamato.addInventoryList(appleList);
		assertEquals(2, yamato.getItemListLength());
	}
	
	@Test
	public void getAsteroidAttackTest() {
		Spaceship yamato = new Spaceship("Yamato");
		yamato.addShield(4);
		yamato.getAsteroidAttack();
		assertEquals(3, yamato.getShieldLevel());
	}
	
	@Test
	public void searchPlanetTest() {
		Spaceship yamato = new Spaceship("Yamato");
		Mars mars = new Mars();
		Doctor mayuko = new Doctor("mayuko");
		Captain mayu = new Captain("mayu");
		
		yamato.searchPlanet(mars, mayuko);
		assertEquals(1, mayuko.getAction());
		assertEquals(50, mayuko.getFullness());
		assertEquals(25, mayuko.getTiredness());
		
		yamato.searchPlanet(mars, mayu);
		assertEquals(1, mayu.getAction());
		assertEquals(50, mayu.getFullness());
		assertEquals(0, mayu.getTiredness());
	}
}

//Done-------------------------------------------------------------------------------------------------------
