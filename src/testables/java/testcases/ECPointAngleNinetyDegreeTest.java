package testables.java.testcases;


//import org.junit.Test;
import org.junit.Test;

public class ECPointAngleNinetyDegreeTest extends ECPointAngleTest {	
	@Test
	public void test() {
		test(0, 10, 10.0, Math.PI / 2); // 90 degree angle
	}

}
