package alg;

import util.Utils;
import kpp.Element;
import kpp.KnapSack;
import kpp.Problem;
import kpp.KPOverflowException;

public class Greedy implements Algorithm
{
	@Override
	public KnapSack solve(Problem problem)
	{
		KnapSack solution = problem.getKnapSack();
		Element[] elements = problem.getElements();
		
		// sort elements by efficiency:
		Element[] sorted = Utils.sortByEfficiency(elements);

		for (int i = 0; sorted.length > i; ++i)
		{
			// enough space left in knapsack?
			if (solution.getFreeSpace() >= sorted[i].getWeight())
			{
				// add the element to the solution then
				try
				{
					solution.addElement(sorted[i]);
				}
				catch (KPOverflowException e) {}
			}
		}

		return solution;
	}
}