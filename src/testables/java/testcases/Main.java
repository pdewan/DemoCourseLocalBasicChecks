package testables.java.testcases;

import java.util.Scanner;

import testables.java.correct.ACorrectTestableCartesianPoint;
import testables.java.correct.TestablePoint;

public class Main {
	public static void main(String args[]) {
		Scanner aScanner = new Scanner (System.in);
		String anXLine = aScanner.nextLine();
		String aYLine = aScanner.nextLine();
		int anX = Integer.parseInt(anXLine);
		int aY = Integer.parseInt(aYLine);
		TestablePoint aPoint =  new ACorrectTestableCartesianPoint (anX, aY);
		System.out.println ("" + aPoint.getRadius());
		System.out.println ("" + aPoint.getAngle());
//		
	}

}
