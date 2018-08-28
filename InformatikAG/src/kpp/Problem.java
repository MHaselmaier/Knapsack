package kpp;

import java.util.Arrays;
import java.util.Random;

public class Problem
{	
	private static final int DEFAULT_AMOUNT_ELEMENTS = 20;
	private static final int DEFAULT_MAX_CAPACITY = 60;
	private static final int DEFAULT_MAX_WEIGHT = 30;
	private static final int DEFAULT_MAX_PROFIT = 30;	
	
	private KnapSack ks;
	private Element[] elements;
	
	public Problem()
	{
		this(DEFAULT_AMOUNT_ELEMENTS, DEFAULT_MAX_CAPACITY);
	}
	
	public Problem(int nElements, int maxCapacity)
	{
		this(nElements, maxCapacity, System.currentTimeMillis());
	}
	
	public Problem(int nElements, int maxCapacity, long seed)
	{
		this.ks = new KnapSack(maxCapacity);
		this.elements = new Element[nElements];
		
		Random generator = new Random(seed);
		for (int i = 0; nElements > i; ++i)
		{
			this.elements[i] = new Element(generator.nextInt(DEFAULT_MAX_WEIGHT) + 1,
								   		   generator.nextInt(DEFAULT_MAX_PROFIT) + 1);	
		}
	}
	
	public Problem(KnapSack ks, Element[] elements)
	{
		this.ks = ks;
		this.elements = elements;
	}
	
	
	public boolean equals(Problem other)
	{
		return (this.ks.equals(other.ks) &&
				Arrays.equals(this.elements, other.elements));
	}
	
	public KnapSack getKnapSack()
	{
		return this.ks.copy();
	}
	
	public Element[] getElements()
	{
		Element[] copyArray = new Element[this.elements.length];
		System.arraycopy(this.elements, 0, copyArray, 0, this.elements.length);
		return copyArray;
	}
	
	@Override
	public String toString()
	{	
		return String.format("Problem description:\nGiven the knapsack:\n%s\nand the elements:\n%s", 
							 this.ks.toString(), Arrays.toString(this.elements));
	}	
}