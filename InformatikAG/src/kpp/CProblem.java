package kpp;

import java.util.Arrays;
import java.util.Random;

public class CProblem {
	
	private static final int DEFAULT_AMOUNT_ELEMENTS = 20;
	private static final int DEFAULT_MAX_CAPACITY = 60;
	private static final int DEFAULT_MAX_WEIGHT = 30;
	private static final int DEFAULT_MAX_PROFIT = 30;
	
	
	private CKnapSack ks;
	private CElement[] elements;
	
	
	public CProblem(){
		this(DEFAULT_AMOUNT_ELEMENTS, DEFAULT_MAX_CAPACITY);
	}
	
	public CProblem(int nElements, int maxCapacity) {
		this(nElements, maxCapacity, System.currentTimeMillis());
	}
	
	public CProblem(int nElements, int maxCapacity, long seed){
		this.ks = new CKnapSack(maxCapacity);
		this.elements = new CElement[nElements];
		
		Random generator = new Random(seed);
		
		for( int i = 0; i < nElements; i++ ){
			this.elements[i] = new CElement(generator.nextInt(DEFAULT_MAX_WEIGHT) + 1,
								   			generator.nextInt(DEFAULT_MAX_PROFIT) + 1);	
		}
	}
	
	public CProblem(CKnapSack ks, CElement[] elements){
		this.ks = ks;
		this.elements = elements;
	}
	
	
	public boolean equals(CProblem other){
		return ( this.ks.equals(other.ks) && Arrays.equals(this.elements, other.elements) );
	}
	

	// dont give away the 'original' problem
	
	public CKnapSack getKnapSack(){
		return this.ks.copy();
	}
	public CElement[] getElements(){
		CElement[] copyArray = new CElement[this.elements.length];
		System.arraycopy(this.elements, 0, copyArray, 0, this.elements.length);
		return copyArray;
	}
	
	public String toString(){
		
		return String.format("Problem description:\nGiven the knapsack:\n%s\nand the\n%s", 
								this.ks.toString(), Arrays.toString(this.elements));
	
	}
	
	public void show(){
		
		// obsolete, better use: toString();
		
		System.out.println("Problem description:\n");
		System.out.println("Given the Knapsack: ");
		this.ks.show();
		System.out.println();
		System.out.println("Given the elements: ");
		for(CElement currentElement : this.elements) currentElement.print();
		System.out.println();
		
	}
	
	
}
