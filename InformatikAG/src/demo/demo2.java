package demo;

import util.Result;
import util.Utils;
import alg.Greedy;
import alg.Recursive;
import kpp.Element;
import kpp.KnapSack;
import kpp.Problem;

/**
 * 	Demo to show why/when greedy algorithm fails.
 */
public class demo2
{
	public static void main(String[] args)
	{	
		Element[] elements = {new Element(9, 19), // e = 2,111111111
				
							  // the greedy algorithm will take this element, ignoring the 
							  // possible profit of the combination of all other elements
				
							  new Element(2, 4), // e = 2 (for each element)
							  new Element(2, 4),
							  new Element(2, 4),
							  new Element(2, 4),
							  new Element(2, 4)};
		
		Problem greedyFail = new Problem(new KnapSack(10), elements);	
		
		Result greedyResult = Utils.getResult(new Greedy(), greedyFail);
		System.out.println(greedyResult.toString());

		Result recursiveResult = Utils.getResult(new Recursive(), greedyFail);
		System.out.println(recursiveResult.toString());
	}
}