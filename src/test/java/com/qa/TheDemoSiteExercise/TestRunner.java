package com.qa.TheDemoSiteExercise;



import org.junit.runner.JUnitCore;
//import org.junit.runner.*; 
import org.junit.runner.Result; 
//import org.junit.runner.notification.*;


public class TestRunner {

	public static void main(String[] args)
	{ 
		Result res = JUnitCore.runClasses(TestSuiteDemo.class);
		
		System.out.println("The Number of Tests that have been run:  " + res.getRunCount()); 
		
		
	}
}
