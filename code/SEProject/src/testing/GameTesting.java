package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import crewMember.CrewMember;
import crewMember.*;
import game.Game;
import planet.*;

class GameTesting {

	@Test
	public void addPlanetsTest() {
		Game game = new Game();
		Mars mars = new Mars();
		game.addPlanets(mars);
		assertEquals(1, game.getPlanetListLength());
	}
	
	@Test
	public void isEveryoneAliveTest() {
		Game game = new Game();
		ArrayList<CrewMember> crewList2 = new ArrayList<CrewMember>(Arrays.asList(new Doctor("mayuko"),new Captain("mayu")));
		game.setCrewList(crewList2);
		assertEquals(true, game.isEveryoneAlive());
	}
	
	@Test
	public void getAliveCrewsTest() {
		Game game = new Game();
		ArrayList<CrewMember> crewList2 = new ArrayList<CrewMember>(Arrays.asList(new Doctor("mayuko"),new Captain("mayu")));
		game.setCrewList(crewList2);
		assertEquals(2, game.getAliveCrews());
	}

}
