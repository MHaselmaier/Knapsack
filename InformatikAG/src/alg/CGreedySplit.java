package alg;

import util.CUtils;
import kpp.CElement;
import kpp.CKnapSack;
import kpp.CProblem;
import kpp.KPOverflowException;

public class CGreedySplit implements IAlgorithm {

	@Override
	public CKnapSack solve(CProblem problem) {
		CKnapSack solution = problem.getKnapSack();
		CElement[] elements = problem.getElements();

		// sort elements by efficiency :
		CElement[] sorted = CUtils.sortByEfficiency(elements);

		// add mapping: presort index -> postsort index

		for (int i = 0; i < sorted.length; i++) {

			// enough space left in knapsack ?
			if (solution.getFreeSpace() >= sorted[i].getWeight()) {
				// add the element to the solution then
				try {
					solution.addElement(sorted[i]);
				} catch (KPOverflowException e) {
				}

			} else {
				break;
			}
		}

		return solution;
	}

}
