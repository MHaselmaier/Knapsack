package alg;

import kpp.Element;
import kpp.KnapSack;
import kpp.Problem;
import kpp.KPOverflowException;

public class Recursive implements Algorithm
{
	@Override
	public KnapSack solve(Problem problem)
	{
		KnapSack solution = problem.getKnapSack();
		Element[] elements = problem.getElements();

		if (0 == elements.length) return solution;
		
		Element currentElement = elements[0];
		Element[] newElements = new Element[elements.length - 1];
		
		if (1 < elements.length)
			System.arraycopy(elements, 1, newElements, 0, elements.length - 1);
		
		KnapSack rec_ks1 = solution.copy();
		KnapSack rec_ks2 = solution.copy();
		
		try
		{
			rec_ks1.addElement(currentElement);
		}
		catch (KPOverflowException e) {}
		
		KnapSack rec_sol1 = new Recursive().solve(new Problem(rec_ks1, newElements));
		KnapSack rec_sol2 = new Recursive().solve(new Problem(rec_ks2, newElements));
		
		return (rec_sol1.getCurrentProfit() > rec_sol2.getCurrentProfit() ? rec_sol1 : rec_sol2);
	}
}