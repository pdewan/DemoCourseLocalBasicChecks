package gradingTools.comp999.assignment1.testcases;
import util.annotations.Explanation;
//@StructurePattern(StructurePatternNames.POINT_PATTERN)
@Explanation("Location in Java coordinate System.")
public interface Point {
	public int getX(); 
	public int getY(); 	
	public double getAngle(); 
	public double getRadius();
//	void print(String aString, ECPoint aPoint); 
	void print(); 
	Point translate(int anXDelta, int aYDelta); 


}
