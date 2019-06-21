package crewMember;
/**
 * Scientist class extents crewMember class
 * Has crew name, skill, image, occupation, Repair and search efficiency.
 * @author mwi67, amo174
 *
 */
public class Scientist extends CrewMember{
	public Scientist(String crewName) {
		super.crewName = crewName;
		super.skill = "He can survive without food longer";
		super.pic = "/Simages/sci_occ.jpg";
		super.occupation = "Scientist";
		super.repair = 20;
		super.search = 80;
	}
}
