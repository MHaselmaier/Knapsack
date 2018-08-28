package demo;

import alg.Greedy;
import alg.GreedySplit;
import alg.Recursive;
import util.Result;
import util.Utils;
import kpp.Problem;

/**
 * 	Default demo to show general usage of the classes.
 */
public class demo1
{
	public static void main(String[] args)
	{
		// create a demo problem:
		Problem problem = new Problem();
		// show the problem:
		System.out.println(problem.toString());
		
//		// try the algorithms:
//		long greedy = CUtils.measureTime(new CGreedy(), problem);
//		long recursive = CUtils.measureTime(new CRecursive(), problem);
//		
//		System.out.print(String.format("Greedy time: %d, Recursive time: %d", greedy, recursive));
		
		Result greedyResult = Utils.getResult(new Greedy(), problem);
		System.out.println(greedyResult.toString());
		
		Result greedySplitResult = Utils.getResult(new GreedySplit(), problem);
		System.out.println(greedySplitResult.toString());

		Result recursiveResult = Utils.getResult(new Recursive(), problem);
		System.out.println(recursiveResult.toString());	
	}	
}