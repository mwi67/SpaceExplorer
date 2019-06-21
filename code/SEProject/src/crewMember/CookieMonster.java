package crewMember;
/**
 * CookieMonster class extents crewMember class
 * Has crew name, skill, image, occupation, Repair and search efficiency.
 * @author mwi67, amo174
 *
 */
public class CookieMonster extends CrewMember{
	public CookieMonster(String crewName) {
	super.crewName = crewName;
	super.skill = "he eats too much";
	super.pic = "/Simages/coo_occ.jpg";
	super.occupation = "CookieMonster";
	super.search = 100;
	super.repair = 5;
	}
}
