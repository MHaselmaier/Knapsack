package kpp;

import java.util.ArrayList;
import java.util.List;

public class CKnapSack  {

	private List<CElement> elements = new ArrayList<CElement>();
	
	private int currentWeight;
	private int currentProfit;
	
	private final int maxCapacity;
	
	public CKnapSack(int capacity) {
		// TODO Auto-generated constructor stub
		this.maxCapacity = capacity;
	}
	
	public CKnapSack copy(){
		CKnapSack newKS = new CKnapSack(this.maxCapacity);
		
		newKS.currentProfit = this.currentProfit;
		newKS.currentWeight = this.currentWeight;
		
		ArrayList<CElement> copyElements = new ArrayList<>();
		for( CElement currentElement : this.elements){
			copyElements.add(currentElement.copy());
		}
		
		newKS.elements = copyElements;
		
		return newKS;
	}
	
	public void show(){
		System.out.printf("KnapSack:\tCapacity:%d", this.maxCapacity);
	}
	
	
	/**
	 * @return the maxCapacity
	 */
	public int getMaxCapacity() {
		return maxCapacity;
	}

	/**
	 * @return the currentWeight
	 */
	public int getCurrentWeight() {
		return currentWeight;
	}

	/**
	 * @param currentWeight the currentWeight to set
	 */
	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}

	/**
	 * @return the currentProfit
	 */
	public int getCurrentProfit() {
		return currentProfit;
	}

	public int getFreeSpace() {
		return this.maxCapacity - this.currentWeight;
	}

	public void addElement(CElement elem) throws KPOverflowException{
		
		if(elem.getWeight() > (this.maxCapacity - this.currentWeight))	// check if we have enough capacity left
			throw new KPOverflowException();
		
		elements.add(elem);
		
		this.currentWeight += elem.getWeight();
		this.currentProfit += elem.getProfit();
		
	}
	
	public void removeElement(CElement elem){
		
		if(!elements.isEmpty() && elements.contains(elem)){
			
			elements.remove(elem);
			
			this.currentProfit -= elem.getProfit();
			this.currentWeight -= elem.getWeight();
		}
		
	}	

	public String toString(){
		// get content of all elements:
		String elementsString = "";
		for(CElement el : this.elements) elementsString = elementsString + el.toString();
		
		return String.format("Knapsack profit: %d\nweight: %d/%d\nElements: %s", 
							 this.currentProfit, this.currentWeight, this.maxCapacity, elementsString);
	}

	
	public void reset(){
		this.elements = new ArrayList<CElement>();
		
		this.currentProfit =
		this.currentWeight = 0;
	}
	
}
