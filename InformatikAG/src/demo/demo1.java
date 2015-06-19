package demo;

import alg.CGreedy;
import alg.CRecursive;
import util.CResult;
import util.CUtils;
import kpp.CProblem;

/*
 * 
 * 	Default demo to show general usage of the classes
 * 
 */


public class demo1 {

	public static void main(String[] args){
		
		// create a demo problem:
		CProblem problem = new CProblem();
		// show the problem:
		System.out.println(problem.toString());
		
//		// try the algorithms:
//		long greedy = CUtils.measureTime(new CGreedy(), problem);
//		long recursive = CUtils.measureTime(new CRecursive(), problem);
//		
//		System.out.print(String.format("Greedy time: %d, Recursive time: %d", greedy, recursive));
//		
		
		CResult greedyResult = CUtils.getResult(new CGreedy(), problem);
		System.out.println(greedyResult.toString());

		CResult recursiveResult = CUtils.getResult(new CRecursive(), problem);
		System.out.println(recursiveResult.toString());
		
	}
	
	
}
