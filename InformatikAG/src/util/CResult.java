package util;

import alg.IAlgorithm;
import kpp.CKnapSack;

public class CResult {
	
	/*
	 * this class is more like a struct,
	 * it's use is to hold the given solution, used algorithm and needed time
	 * 
	 */

	private String algorithm;
	private long time;
	private CKnapSack solution;
	
	public CResult(){
		this("DEFAULT RESULT", -1L, null);
	}
	
	public CResult(String algorithm, long time, CKnapSack solution) {
		this.algorithm = algorithm;
		this.time = time;
		this.solution = solution;
	}
	
	public CResult(IAlgorithm algorithm, long time, CKnapSack solution) {
		this.algorithm = algorithm.getClass().getName();
		this.time = time;
		this.solution = solution;
	}
	
	
	public String toString(){
		return String.format("%s found in %d [ms] the solution: \n%s\n", this.algorithm, this.time, this.solution);
	}
	
	/*
	 * Getters and Setters
	 */

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public CKnapSack getSolution() {
		return solution;
	}

	public void setSolution(CKnapSack solution) {
		this.solution = solution;
	}

	


}
