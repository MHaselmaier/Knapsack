package util;

import alg.Algorithm;
import kpp.KnapSack;

/**
 * This class is more like a struct.
 * It is used to hold the given solution, used algorithm and needed time.
 */
public class Result
{
	private String algorithm;
	private long time;
	private KnapSack solution;
	
	public Result()
	{
		this("DEFAULT RESULT", -1L, null);
	}
	
	public Result(String algorithm, long time, KnapSack solution)
	{
		this.algorithm = algorithm;
		this.time = time;
		this.solution = solution;
	}
	
	public Result(Algorithm algorithm, long time, KnapSack solution)
	{
		this.algorithm = algorithm.getClass().getName();
		this.time = time;
		this.solution = solution;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s found in %d [ms] the solution: \n%s\n", this.algorithm, this.time, this.solution);
	}
	
	public String getAlgorithm()
	{
		return algorithm;
	}

	public void setAlgorithm(String algorithm)
	{
		this.algorithm = algorithm;
	}

	public long getTime()
	{
		return time;
	}

	public void setTime(long time)
	{
		this.time = time;
	}

	public KnapSack getSolution()
	{
		return solution;
	}

	public void setSolution(KnapSack solution)
	{
		this.solution = solution;
	}
}