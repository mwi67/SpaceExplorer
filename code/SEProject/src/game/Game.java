package game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import crewMember.*;
import event.*;
//import inventory.*;
import planet.*;
//import game.*;
import spaceship.*;
import shopping.*;
/**
 * Class game 
 * Manages all other GUIs and classes
 * @author amo174, mwi67
 *
 */
public class Game {
	/**
	 * Number of parts needed
	 */
	private int partsNeeded;
	/**
	 * The current day
	 */
	private int currentDay;
	/**
	 * The number maximum days 
	 */
	private int maxDays;
	/**
	 * The list of planets visited
	 */
	
	private ArrayList<Planet> planetVisitedList = new ArrayList<Planet>();
	/**
	 * The Spaceship spaceship
	 */
	private Spaceship spaceship;
	/**
	 * The game over boolean
	 */
	private boolean isGameFinished = false;
	/**
	 * The list of crew members
	 */
	private ArrayList<CrewMember> crewList;

	/**
	 * returns length of the list of planets visited
	 * @return Integer Array length
	 */
	public int getPlanetListLength() {
		return planetVisitedList.size();
	}
	
	
	/**
	 * adds planet to list of planets visited
	 * @param planet  Type of Planet
	 */
	public void addPlanets(Planet planet) {
		planetVisitedList.add(planet);
	}
	
	/**
	 * Returns list of planets visited
	 * @return  ArrayList of planets 
	 */
	public ArrayList<Planet> getPlanetList(){
		return planetVisitedList;
	}
	/**
	 * Returns number of required
	 * @return partsNeeded integer
	 */
	public int getPartsNeeded() {
		return partsNeeded;
	}
	/**
	 * Sets number of parts needed
	 * @param num integer
	 */
	public void setPartsNeeded(int num) {
		partsNeeded = num;
	}
	/**
	 * Sets current day
	 * @param num integer
	 */
	public void setCurrentDay(int num) {
		currentDay = num;
		
	}
	/**
	 * Gets maximum  number of days
	 * @return maxDays integer
	 */
	public int getMaxDays() {
		return maxDays;
	}
	/**
	 * Sets maxDays
	 * @param num integer
	 */
	public void setMaxDays(int num) {
		maxDays = num;
	}
	/**
	 * Checks if we user acquired all the parts needed
	 * @return boolean
	 */
	public boolean checkAllParts() {
		if (spaceship.getPartsCollected() == partsNeeded) {
			isGameFinished = true;
			return isGameFinished;
		} else {
			return isGameFinished;
		}
	}
	/**
	 * Sets Crew List
	 * @param crewList ArrayList of CrewMembers
	 */
	public void setCrewList(ArrayList<CrewMember> crewList) {
		this.crewList = crewList;
	}
	/**
	 * Sets spaceship
	 * @param ship Type Spaceship
	 */
	public void setSpaceship(Spaceship ship) {
		this.spaceship = ship;
	}
	/**
	 * Returns Current day
	 * @return currentDay integer
	 */
	public int getCurrentday() {
		return currentDay;
	}
	/**
	 * Returns spaceship
	 * @return spaceship type Spaceship
	 */
	public Spaceship getSpaceship() {
		return spaceship;
	}
	/**
	 * Creates an instance of captain
	 * @param name Type of CrewMember
	 */
	public void createCaptain(String name) {
		Captain captain = new Captain(name);
		crewList.add(captain);
	}
	/**
	 * Creates an instance of Doctor
	 * @param name Type of CrewMember
	 */
	public void createDoctor(String name) {
		Doctor doctor = new Doctor(name);
		crewList.add(doctor);
	}
	/**
	 * Creates an instance of Engineer
	 * @param name Type of CrewMember
	 */
	public void createEngineer(String name) {
		Engineer engineer = new Engineer(name);
		crewList.add(engineer);
	}
	/**
	 * Creates an instance of Programmer
	 * @param name Type of CrewMember
	 */
	public void createProgrammer(String name) {
		Programmer programmer = new Programmer(name);
		crewList.add(programmer);
	}
	/**
	 * Creates an instance of  Scientist
	 * @param name Type of CrewMember
	 */
	public void createScientist(String name) {
		Scientist scientist = new Scientist(name);
		crewList.add(scientist);
	}
	/**
	 * Creates an instance of CookieMonster
	 * @param name Type of CrewMember
	 */
	public void createCookieMonster(String name) {
		CookieMonster cookiemonster = new CookieMonster(name);
		crewList.add(cookiemonster);
	}
	/**
	 * Returns Crew List
	 * @return crewList ArrayList of type CrewMember
	 */
	public ArrayList<CrewMember> getCrewList(){
		return crewList;
	}
	/**
	 * Returns number of crew member alive 
	 * @return num integer
	 */
	public int getAliveCrews() {
		int num = 0;
		for(CrewMember crew: crewList) {
			if(crew.isCrewMemberAlive() == true) {
				num += 1;
			}
		}
		return num;
	}
	/**
	 * Checks if everyones Alive
	 * @return boolean 
	 */
	public boolean isEveryoneAlive() {
		
		int total = 0;
		
		for (CrewMember crew : crewList) {
				total += crew.getHealth();
			}
		if (total == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	/**
	 * Moves on to next day when called from main game window
	 * @return boolean
	 */
	public boolean proceedDay() {
		
		if (currentDay < maxDays ) { 
			currentDay += 1;
			List<Event> eventList = Arrays.asList(Event.values());
			Random rand = new Random();
			int randomElement = rand.nextInt(8);
			if (randomElement < 2) {
				occurEvent(eventList.get(randomElement));
			}
			//random event
			
			for (CrewMember crew: crewList) {
				crew.setAction();
				crew.addFullness(30);
				if (crew.getPlague() == true) {
					crew.minusHealth(10);
				}
				if (crew.getFullness() == 100) {
					crew.minusHealth(10);
				}
				if (crew.getTiredness() >= 50) {
					if (crew.getTiredness() == 100) {
						crew.minusHealth(25);
					}else {
					crew.minusHealth(5);
					}
					
				}
			}
			return true;
			}else {
				return false;
				}
	}
	/**
	 * Called when moving on to next day and has 20percent of chances of getting hit by plague or alien event
	 * @param event Type of random event
	 */
	public void occurEvent(Event event) {
		switch (event) {
		case PLAGUE:
			for(CrewMember crew: crewList) {
				if(!(crew instanceof Doctor)) {
				crew.setPlague(true); 
				crew.minusHealth(40);
				}
			}
			JOptionPane.showMessageDialog(null, "Your crew has been hit with Plague, you need to get plague medicine","alert", JOptionPane.ERROR_MESSAGE); 
			break;
			

		case ALIEN:
			if(spaceship.getItemListLength() > 0) {
				Random rand = new Random();
				if (spaceship.getItemListLength() > 0) {
					int randomElement = rand.nextInt(spaceship.getItemListLength());
					int removeIndex = randomElement;
					spaceship.getItemList().remove(removeIndex);
					JOptionPane.showMessageDialog(null, "Aliens stole something from you","alert", JOptionPane.ERROR_MESSAGE); 
					}
			}
			break;
		}
	}
	/**
	 * Sets isGameFinished true if all member dead or found all the parts
	 */
	public void setGameOver() {
		isGameFinished = true;
	}
	/**
	 * Checks if we found all the parts whenever we find a part
	 */
	public void isPartsCollected(Spaceship ship) {
		if (partsNeeded == ship.getPartsCollected()) {
			isGameFinished = true;
		}	
	}
	/**
	 * Checks if everyone's alive in the crew
	 * @param ship
	 */
	public void isCrewAlive(Spaceship ship) {
		
		if (isEveryoneAlive() == false) {
			isGameFinished = true;
		}	
	}
	/**
	 * Launches the main game window
	 */
	public void startGame() {
		MainGameWindow window = new MainGameWindow(this);
	}
	/**
	 * Launches the start up window
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
		StartUpWindow window = new StartUpWindow(game);
	}
	/**
	 * Restarts the game, Launches the start up window 
	 */
	public void RestartGame() {
		Game game = new Game();
		StartUpWindow window = new StartUpWindow(game);
	}
	/**
	 * Launches game over window if crew did'nt find all the parts or game won window. 
	 */
	public void CallGameOver(Game game, MainGameWindow window) {
		window.disposeWindow();
		checkAllParts();
		if (isGameFinished == false) {
			GameOverWindow over = new GameOverWindow(game);
		} else {
			GameWonWindow won = new GameWonWindow(game);
		}
	}
}


