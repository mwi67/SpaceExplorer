package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import crewMember.Doctor;
import crewMember.Engineer;
import inventory.AntiPlague;
import inventory.*;

class CrewMemberTesting {
	
	@Test
	public void getNameTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		assertEquals("Mayuko", testDoctor.getName());
	}
	
	@Test
	public void isCrewMemberAliveTest(){
		Doctor testDoctor = new Doctor("Mayuko");
		assertEquals(true, testDoctor.isCrewMemberAlive());
		testDoctor.setCrewMemberDead();
		assertEquals(false, testDoctor.isCrewMemberAlive());
	}
	
	@Test
	public void getSkillsTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		assertEquals("He does'nt get sick", testDoctor.getSkills());
	}
	
	@Test
	public void getActionTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.minusAction();
		assertEquals(1, testDoctor.getAction());
	}
	
	@Test
	public void getHealthTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		assertEquals(100, testDoctor.getHealth());
		testDoctor.minusHealth(50);
		assertEquals(50, testDoctor.getHealth());

	}
	
	@Test
	public void getOccupationTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		assertEquals("Doctor", testDoctor.getOccupation());
	}
	
	@Test
	public void setHealthTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.setHealth(20);
		assertEquals(20, testDoctor.getHealth());
	}

	@Test
	public void minusHealthTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.minusHealth(50);
		assertEquals(50, testDoctor.getHealth());
		testDoctor.minusHealth(150);
		assertEquals(0, testDoctor.getHealth());
	}
	
	@Test
	public void addHealthTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.minusHealth(50);
		testDoctor.addHealth(30);
		assertEquals(80, testDoctor.getHealth());
		testDoctor.addHealth(150);
		assertEquals(100, testDoctor.getHealth());
	}
	
	@Test
	public void setTirednessTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.setTiredness(50);
		assertEquals(50, testDoctor.getTiredness());
	}
	
	@Test void minusTirednessTest(){
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.addTiredness(50);
		testDoctor.minusTiredness(30);
		assertEquals(20, testDoctor.getTiredness());
		testDoctor.minusTiredness(150);
		assertEquals(0, testDoctor.getTiredness());
	}
	
	@Test void addTirednessTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.addTiredness(50);
		assertEquals(50, testDoctor.getTiredness());
		testDoctor.addTiredness(150);
		assertEquals(100, testDoctor.getTiredness());
	}
	
	@Test
	public void getTirednessTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		assertEquals(0, testDoctor.getTiredness());
	}
	
	@Test
	public void setFulnessTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.setFulness(50);
		assertEquals(50, testDoctor.getFullness());
	}
	
	@Test void minusFullnessTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.addFullness(70);
		testDoctor.minusFullness(50);
		assertEquals(20, testDoctor.getFullness());
		testDoctor.minusFullness(150);
		assertEquals(0, testDoctor.getFullness());
	}
	
	@Test void addFullnessTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.addFullness(20);
		assertEquals(20, testDoctor.getFullness());
		testDoctor.addFullness(150);
		assertEquals(100, testDoctor.getFullness());
	}
	
	@Test
	public void getFullnessTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.setFulness(60);
		assertEquals(60, testDoctor.getFullness());
	}
	
	@Test
	public void setSearchTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.setSearch(5);		
		assertEquals(5, testDoctor.getSearch());
	}
	
	@Test
	public void getSearchTest() {
		Doctor testDoctor = new Doctor("Mayuko");	
		assertEquals(30, testDoctor.getSearch());
	}
	
	@Test
	public void setRepairTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.setRepair(5);
		assertEquals(5, testDoctor.getRepair());
	}
	
	@Test
	public void getRepairTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		assertEquals(70, testDoctor.getRepair());
	}
	
	@Test void setPlagueTest(){
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.setPlague(true);
		assertEquals(true, testDoctor.getPlague());
	}
	
	@Test
	public void getPlagueTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		assertEquals(false, testDoctor.getPlague());
		testDoctor.setPlague(true);
		assertEquals(true, testDoctor.getPlague());
	}
	
	@Test
	public void getPlagueResultTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		assertEquals("He is Good", testDoctor.getPlagueResult());
		testDoctor.setPlague(true);
		assertEquals("He is Sick", testDoctor.getPlagueResult());
	}
	
	
	@Test void minusActionTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.minusAction();
		assertEquals(1, testDoctor.getAction());
	}
	
	@Test void setActionTest() {
		Engineer testEngineer = new Engineer("Mayuko");
		testEngineer.setAction();
		assertEquals(2, testEngineer.getAction());
		testEngineer.addTiredness(100);
		testEngineer.setAction();
		assertEquals(1, testEngineer.getAction());
		testEngineer.minusHealth(100);
		testEngineer.setAction();
		assertEquals(0, testEngineer.getAction());
	}
	
	@Test void addSleepTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.addTiredness(50);
		testDoctor.addSleep();
		assertEquals(0, testDoctor.getTiredness());
		assertEquals(1, testDoctor.getAction());
		testDoctor.addSleep();
		assertEquals(0, testDoctor.getTiredness());
		assertEquals(0, testDoctor.getAction());
	}
	
	@Test void eatItemTest() {
		Doctor testDoctor = new Doctor("Mayuko");
		testDoctor.addFullness(100);
		Water h2o = new Water();
		testDoctor.eatItem(h2o);
		assertEquals(70, testDoctor.getFullness());
		assertEquals(1, testDoctor.getAction());
		MaxHealth maxh = new MaxHealth();
		testDoctor.eatItem(maxh);
		assertEquals(100, testDoctor.getHealth());
		assertEquals(0, testDoctor.getAction());
		testDoctor.setAction();
		testDoctor.setPlague(true);
		AntiPlague antip = new AntiPlague();
		testDoctor.eatItem(antip);
		assertEquals(false, testDoctor.getPlague());
		testDoctor.addTiredness(50);
		AntiTiredness nottired = new AntiTiredness();
		testDoctor.eatItem(nottired);
		assertEquals(0, testDoctor.getTiredness());
		assertEquals(0, testDoctor.getAction());
	}
}

//Done---------------------------------------------------------------
