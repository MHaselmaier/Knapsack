package alg;

import kpp.CElement;
import kpp.CKnapSack;
import kpp.CProblem;
import kpp.KPOverflowException;

public class CRecursive implements IAlgorithm{

	@Override
	public CKnapSack solve(CProblem problem) {

		CKnapSack solution = problem.getKnapSack();
		CElement[] elements = problem.getElements();

		if( elements.length == 0 )
			return solution;
		
		CElement curr_element = elements[0];
		CElement[] newElements = new CElement[elements.length - 1];
		
		if( elements.length > 1)
			System.arraycopy(elements, 1, newElements, 0, elements.length - 1);
		
		CKnapSack rec_ks1 = solution.copy();
		CKnapSack rec_ks2 = solution.copy();
		
		try {
			rec_ks1.addElement(curr_element);
		} catch (KPOverflowException e) {}
		
		CKnapSack rec_sol1 = new CRecursive().solve(new CProblem(rec_ks1, newElements));
		CKnapSack rec_sol2 = new CRecursive().solve(new CProblem(rec_ks2, newElements));
		
		return rec_sol1.getCurrentProfit() > rec_sol2.getCurrentProfit() ? rec_sol1 : rec_sol2;
		
	}
	
}
