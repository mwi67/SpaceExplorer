package crewMember;
/**
 * Engineer class extents crewMember class
 * Has crew name, skill, image, occupation, Repair and search efficiency.
 * @author mwi67, amo174
 *
 */
public class Engineer extends CrewMember{
	public Engineer(String crewName) {
		super.crewName = crewName;
		super.skill = "He can build faster than others";
		super.pic = "/Simages/eng_occ.jpg";
		super.occupation = "Engineer";
		super.repair = 90;
		super.search = 30;
	}
}
