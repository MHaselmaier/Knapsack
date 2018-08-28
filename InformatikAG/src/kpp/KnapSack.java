package kpp;

import java.util.ArrayList;
import java.util.List;

public class KnapSack
{
	private List<Element> elements = new ArrayList<Element>();
	
	private int currentWeight;
	private int currentProfit;
	
	private final int maxWeight;
	
	public KnapSack(int maxWeight)
	{
		this.maxWeight = maxWeight;
	}
	
	public KnapSack copy()
	{
		KnapSack newKS = new KnapSack(this.maxWeight);
		
		newKS.currentProfit = this.currentProfit;
		newKS.currentWeight = this.currentWeight;
		
		ArrayList<Element> copyElements = new ArrayList<>();
		for (Element currentElement: this.elements)
		{
			copyElements.add(currentElement.copy());
		}
		newKS.elements = copyElements;
		
		return newKS;
	}	
	
	public int getMaxWeight()
	{
		return this.maxWeight;
	}

	public int getCurrentWeight()
	{
		return this.currentWeight;
	}

	public void setCurrentWeight(int currentWeight)
	{
		this.currentWeight = currentWeight;
	}

	public int getCurrentProfit()
	{
		return this.currentProfit;
	}

	public int getFreeSpace()
	{
		return this.maxWeight - this.currentWeight;
	}

	public void addElement(Element elem) throws KPOverflowException
	{
		
		if (elem.getWeight() > (this.maxWeight - this.currentWeight))
			throw new KPOverflowException();
		
		this.elements.add(elem);
		
		this.currentWeight += elem.getWeight();
		this.currentProfit += elem.getProfit();
		
	}
	
	public void removeElement(Element elem)
	{	
		if (!this.elements.isEmpty() && this.elements.contains(elem))
		{
			this.elements.remove(elem);
			
			this.currentProfit -= elem.getProfit();
			this.currentWeight -= elem.getWeight();
		}
	}	

	@Override
	public String toString()
	{
		// get content of all elements:
		String elementsString = "";
		for (Element el: this.elements)
		{
			elementsString = elementsString + el.toString();
		}
		if (elementsString.equals(""))
		{
			elementsString = "None";
		}
		
		return String.format("Knapsack profit: %d\nweight: %d/%d\nElements: %s", 
							 this.currentProfit, this.currentWeight, this.maxWeight, elementsString);
	}

	public void reset()
	{
		this.elements = new ArrayList<Element>();
		this.currentProfit = 0;
		this.currentWeight = 0;
	}
}