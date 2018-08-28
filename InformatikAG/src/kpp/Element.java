package kpp;

public class Element
{
	private final int weight;
	private final int profit;
	private final double efficiency;
	
	public Element(int weight, int profit)
	{
		this.weight = weight;
		this.profit = profit;
		this.efficiency = (double)this.profit / this.weight;
	}
	
	public Element copy()
	{
		return new Element(this.weight,  this.profit);
	}

	public int getWeight()
	{
		return this.weight;
	}

	public int getProfit()
	{
		return this.profit;
	}

	public double getEfficiency()
	{
		return this.efficiency;
	}
	
	@Override
	public String toString()
	{
		return String.format("Element: %d(w)\t%d(p)\t%.3f(e)\n", this.weight, this.profit, this.efficiency);
	}
}