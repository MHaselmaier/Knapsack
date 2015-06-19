package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;

import alg.IAlgorithm;
import kpp.CElement;
import kpp.CKnapSack;
import kpp.CProblem;

public class CUtils {

	/*
	 * Class for general Utility 
	 * 
	 * Can prepare problems for algorithms (presort for greedy), 
	 * print solutions to files and such
	 * 
	 */
	
	private static final double EPSILON = 1E-6;	// comparing double values requires this
	
	
	/*
	 * Sorts array of CElement by their efficiency.
	 * Used sorting algorithm by Arrays.sort() is QuickSort
	 * 
	 * QuickSort is O(n^2) but has good average speed.
	 */
	public static CElement[] sortByEfficiency(CElement[] elements) {
		Arrays.sort(elements,  new Comparator<CElement>() {
			@Override
			// no java 8 -> no lambda fun :(
			public int compare(CElement o1, CElement o2) {
				double e1 = o1.getEfficiency(); double e2 = o2.getEfficiency();
				if(Math.abs(e1 - e2) <= EPSILON) return 0; // efficiency is (almost) equal
				return e1 < e2 ? 1 : -1;
			}
		});
		
		
		
		return elements;
	}
	
	
	/*
	 * Lets the given algorithm sort the given problem
	 * 
	 * return diff time in ms
	 */
	
	public static long measureTime(IAlgorithm alg, CProblem problem){
	
		long startTime, endTime;
		
		startTime = System.currentTimeMillis();
		
		alg.solve(problem);
		
		endTime = System.currentTimeMillis();
		
		return endTime - startTime;
	}
	
	
	public static CResult getResult(IAlgorithm alg, CProblem problem){
		
		long startTime, endTime;
		startTime = System.currentTimeMillis();
		CKnapSack solution = alg.solve(problem);
		endTime = System.currentTimeMillis();
		
		return new CResult(alg, endTime - startTime, solution);
	}
	
	
	/*
	 * Prints the given problem and solution to the file
	 * which is found at the filepath
	 * 
	 */
	
	public static void saveSolution(CProblem problem, CKnapSack solution, String filepath){
		
		// save result would be better
		
		File file = new File(filepath);
		try {
			PrintStream ps = new PrintStream(file);
			
			ps.print(problem.toString());
			ps.print(solution.toString());
			
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
