package gradingTools.fileIO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class TestResourceAsStream {
	public static void main (String[] args) {
		InputStream aStream = TestResourceAsStream.class.getResourceAsStream("assignmentXYZ/input1.txt");
		if (aStream == null) {
			File aFile = new File ("assignmentXYZ/input1.txt");
			if (!aFile.exists()) {
				System.out.println("No file:" + "assignmentXYZ/input1.txt" );
				return;
			}
		}
		try {
			int anInt = aStream.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
