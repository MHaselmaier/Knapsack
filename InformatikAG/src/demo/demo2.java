package demo;

import util.CResult;
import util.CUtils;
import alg.CGreedy;
import alg.CRecursive;
import kpp.CElement;
import kpp.CKnapSack;
import kpp.CProblem;

/*
 * 
 * 	Demo to show why/when greedy algorithm fails
 * 
 */

public class demo2 {

	public static void main(String[] args){
		
		
		CElement[] elements = {	 new CElement(9, 19), // e = 2,111111111
				
								// the greedy algorithm will take this element, ignoring the 
								// possible profit of the combination of all other elements
				
								 new CElement(2, 4), // e = 2 (for each element)
								 new CElement(2, 4),
								 new CElement(2, 4),
								 new CElement(2, 4),
								 new CElement(2, 4) };
		
		// System.out.println(Arrays.toString(elements));
		
		CProblem greedyFail = new CProblem(	new CKnapSack(10), elements	);	
		
		CResult greedyResult = CUtils.getResult(new CGreedy(), greedyFail);
		System.out.println(greedyResult.toString());

		CResult recursiveResult = CUtils.getResult(new CRecursive(), greedyFail);
		System.out.println(recursiveResult.toString());

	}
	
}
