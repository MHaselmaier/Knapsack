package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;

import alg.Algorithm;
import kpp.Element;
import kpp.KnapSack;
import kpp.Problem;

/**
 * Class for general Utility 
 * 
 * Can prepare problems for algorithms (presort for greedy), 
 * print solutions to files and such
 */
public class Utils
{
	private static final double EPSILON = 1E-6;	
	
	/**
	 * Sorts an array of Element's by their efficiency.
	 * Used sorting algorithm by Arrays.sort() is QuickSort
	 * 
	 * QuickSort is O(n^2) but has good average speed.
	 */
	public static Element[] sortByEfficiency(Element[] elements)
	{
		Arrays.sort(elements, (e1, e2) ->
		{
			double efficiency1 = e1.getEfficiency();
			double efficiency2 = e2.getEfficiency();
			
			if (Math.abs(efficiency1 - efficiency2) <= EPSILON) return 0;
			return (efficiency1 < efficiency2 ? 1 : -1);
		});
		return elements;
	}
	
	/**
	 * Lets the given algorithm solve the given problem
	 * 
	 * returns time in ms
	 */
	public static long measureTime(Algorithm alg, Problem problem)
	{
		Result result = getResult(alg, problem);
		return result.getTime();
	}
	
	/**
	 * Lets the given algorithm solve the given problem
	 * 
	 * returns the Result
	 */
	public static Result getResult(Algorithm alg, Problem problem)
	{	
		long startTime, endTime;
		
		startTime = System.currentTimeMillis();
		KnapSack solution = alg.solve(problem);
		endTime = System.currentTimeMillis();
		
		return new Result(alg, endTime - startTime, solution);
	}
	
	
	/**
	 * Prints the given problem and solution to the file
	 * which is found at the filepath 
	 */
	public static void saveSolution(Problem problem, KnapSack solution, String filepath)
	{	
		try (PrintStream ps = new PrintStream(new File(filepath)))
		{	
			ps.print(problem.toString());
			ps.print(solution.toString());
			
			ps.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}