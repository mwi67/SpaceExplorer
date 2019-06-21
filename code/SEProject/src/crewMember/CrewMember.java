package crewMember;





import javax.swing.JOptionPane;
import inventory.*;

/**
 *This class implements crews who will be on the spaceship.
 *
 * @author amo174, mwi67
 * @version 1.1, 23 May 2019 
 *  
 */
public abstract class CrewMember {
	/**
	 *  The Name of crewMember
	 */
	protected String crewName;
	/**
	 *The skill of crewMember
	 */
	protected String skill;
	/**
	 *Image of crewMember 
	 */
	protected String pic;
	/**
	 * ActionsLeft of crewMember
	 */
	protected int actionsLeft = 2;
	/**
	 * The health of crewMember
	 */
	protected int health = 100;
	/**
	 * Hunger level of crewMember
	 */
	protected int hunger = 0;
	/**
	 * Tiredness level of crewMember 
	 */
	protected int tiredness = 0;
	/**
	 * Search efficiency of  level of crewMember
	 */
	protected int search;
	/**
	 * Repair efficiency of  level of crewMember
	 */
	protected int repair;
	/**
	 * Plague status
	 */
	protected boolean hasPlague = false;
	/**
	 * Health status
	 */
	protected boolean isAlive = true;
	/**
	 * The occupation of crewMember 
	 */
	protected String occupation;
	
	
	/**
	 * This returns the current name of the crew member.
	 * @return this crew member's name
	 */
	public String getName() {
		return crewName;
	}
	/**
	 * This returns the current occupation of the crew member.
	 * @return this crew member's occupation.
	 */
	public String getOccupation() {
		return occupation;
	}
	/**
	 * Return true if alive and false if dead.
	 * @return boolean true or false.
	 */
	
	public boolean isCrewMemberAlive() {
		return isAlive;
	}
	/**
	 * Updates/sets crew member dead
	 */
	
	public void setCrewMemberDead() {
		isAlive = false;
	}
	/**
	 * Different types crew member has different skills.
	 * @return skill
	 */
			
	public String getSkills(){
		return skill;
	}
	/**
	 * Putting a face for each crew member
	 * @return image
	 */
	public String getimage(){
		return pic;
	}	
	/**
	 * Current health status
	 * @return health of crew member 
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * Sets/ Updates health
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	/**
	 * Reduces health, takes Integer down and reduces it accordingly.
	 * @param down Integer
	 */
	public void minusHealth(int down) {
		health -= down;
		if (health < 0) {
			health = 0;
		}
	}
	/**
	 * Increases health when consumed medicine.
	 */
	
	public void addHealth(int up) {
		health += up;
		if (health > 100) {
			health = 100;
		}
	}
	/**
	 * Returns current tiredness level.
	 * @param tiredness
	 */
	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	}
	/**
	 * Reduces tiredness, takes Integer down and reduces it accordingly.
	 * @param down integer
	 */
	public void minusTiredness(int down) {
		tiredness -= down;
		if (tiredness < 0) {
			tiredness = 0;
		}
	}
	/**
	 * Increases tiredness after an action.
	 * @param up
	 */
	public void addTiredness(int up) {
		tiredness += up;
		if (tiredness >= 100) {
			tiredness = 100;
			}
	}
	/**
	 * returns current tiredness level.
	 * @return
	 */
	public int getTiredness() {
		return tiredness;
	}
	/**
	 * Sets the hunger level.
	 * @param fullness
	 */
	public void setFulness(int fullness) {
		this.hunger = fullness;
	}
	/**
	 * Reduces hunger by given amount when consumed food.
	 * @param down
	 */
	public void minusFullness(int down) {
		hunger -= down;
		if (hunger > 100) {
			hunger = 100;
		}
		if (hunger < 0) {
			hunger = 0;
		}
	}
	/**
	 * Adds hunger to crew member if they have'nt consumed food over a day.
	 * @param up
	 */
	public void addFullness(int up) {
		hunger += up;
		if (hunger > 100) {
			hunger = 100;
		}
		if (hunger < 0) {
			hunger = 0;
		}
	}
	/**
	 * Gets current hunger level.
	 * @return Hunger level.
	 */
	public int getFullness() {
		return hunger;
	}
	/**
	 * Sets search efficiency for each crew member.
	 * @param search
	 */
	public void setSearch(int search) {
		this.search = search;
	}
	/**
	 * Gets search level of each crew member.
	 * @return search
	 */
	public int getSearch() {
		return search;
	}
	/**
	 * Sets Repair efficiency for each crew member.
	 * @param repair
	 */
	public void setRepair(int repair) {
		this.repair = repair;
	}
	/**
	 * Gets Repair Efficiency of crew member.
	 * @return
	 */
	public int getRepair() {
		return repair;
	}
	/**
	 * Sets plague boolean status.
	 * @param hasPlague
	 */
	public void setPlague(boolean hasPlague) {
		this.hasPlague = hasPlague;
	}
	/**
	 * Returns plague boolean status. 
	 * @return boolean
	 */
	public boolean getPlague() {
		return hasPlague;
	}
	/**
	 * Gets a string result for plague of a crew member
	 * @return String 
	 */
	public String getPlagueResult() {
		if (hasPlague == true) {
			return "He is Sick";
		} else {
			return "He is Good";
		}
	}
	
	
	
	//Actions----------------------------------------------------------------------------------------------
	/**
	 * Returns action left
	 * @return actionsLeft Integer 
	 */
	public int getAction() {
		return actionsLeft;
	}
	/**
	 * Reduces one action when an action is performed.
	 */
	public void minusAction() {
		if (actionsLeft <= 0) {
			JOptionPane.showMessageDialog(null ,"This crew member dont have any actions left, go to next day");
			
		}else {
			actionsLeft -= 1;
		}
	}
	/**
	 * Sets different number of action depending on crew member situation.
	 */
	public void setAction() {
		if (getHealth() == 0) {
			actionsLeft = 0;
		} else if (tiredness == 100) {
			actionsLeft = 1;
		}else {
			actionsLeft = 2;
		}
		
	}
	/**
	 * Decreases tiredness when sleep action is performed.
	 */
	public void addSleep() {
		if (actionsLeft > 0) {
			tiredness -= 50;
			if (tiredness < 0) {
				tiredness = 0;
			}
			actionsLeft -= 1;
		}
	}
	/**
	 * Consumes an item, provided they crew member has an action left. 
	 * @param item Item
	 */
	public void eatItem(Item item) {
		
		if (actionsLeft > 0) {
			if (item instanceof Food) {
				hunger -= ((Food) item).getHealth();
				if (hunger < 0) {
					hunger = 0;
				}
			} else if (item instanceof MaxHealth) {
				health = 100;
			}else if (item instanceof AntiPlague) {
				hasPlague = false;
			}else if (item instanceof AntiTiredness) {
				tiredness = 0;
			}
			actionsLeft -= 1;
		}
	}
}
