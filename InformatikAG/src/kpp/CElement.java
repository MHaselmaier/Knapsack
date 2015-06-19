package kpp;

public class CElement {

	private final int weight;
	private final int profit;
	private final double efficiency;
	
	public CElement(int weight, int profit){
		this.weight = weight;
		this.profit = profit;
		if( this.profit == 0){ 
			this.efficiency = 0;
		} else {
			this.efficiency = (double)this.profit / this.weight; 			
		}
	}
	
	public CElement copy(){
		return new CElement(this.weight,  this.profit);
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @return the profit
	 */
	public int getProfit() {
		return profit;
	}

	/**
	 * @return the efficiency
	 */
	public double getEfficiency() {
		return efficiency;
	}
	
	public void print(){
		// System.out.println("Element: " + this.weight + "\t" + this.profit + "\t" + this.efficiency);
		System.out.printf("Element:\tw:%d\tp:%d\te:%.3f\n", this.weight, this.profit, this.efficiency);
	}
	
	public String toString(){
		return String.format("Element: %d(w)\t%d(p)\t%.3f(e)\n", this.weight, this.profit, this.efficiency);
	}
}
