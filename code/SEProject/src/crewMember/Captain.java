package crewMember;
/**
 * Captain class extents crewMember class
 * Has crew name, skill, image, occupation, Repair and search efficiency.
 * @author mwi67, amo174
 *
 */
public class Captain extends CrewMember{
	public Captain(String crewName) {
		super.crewName = crewName;
		super.skill = "He is good at everything";
		super.pic = "/Simages/cap_occ.jpg";
		super.occupation = "Captain";
		super.repair = 100;
		super.search = 100;
	}
	
}