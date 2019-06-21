package crewMember;
/**
 * Doctor class extents crewMember class
 * Has crew name, skill, image, occupation, Repair and search efficiency.
 * @author mwi67, amo174
 *
 */
public class Doctor extends CrewMember{
	public Doctor(String crewName) {
		super.crewName = crewName;
		super.skill = "He does'nt get sick";
		super.pic = "/Simages/occ_doc.png";
		super.occupation = "Doctor";
		super.repair = 70;
		super.search = 30;
	}
}
