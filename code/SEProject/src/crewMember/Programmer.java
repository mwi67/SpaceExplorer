package crewMember;
/**
 * Programmer class extents crewMember class
 * Has crew name, skill, image, occupation, Repair and search efficiency.
 * @author mwi67, amo174
 *
 */
public class Programmer extends CrewMember{
	public Programmer(String crewName) {
		super.crewName = crewName;
		super.skill = "He can find broken parts faster";
		super.pic = "/Simages/pro_occ.jpg";
		super.occupation = "Programmer";
		super.repair = 40;
		super.search = 60;
	}
}