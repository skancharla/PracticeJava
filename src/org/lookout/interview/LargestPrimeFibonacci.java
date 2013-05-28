package org.lookout.interview;

import java.util.Iterator;
import java.util.TreeSet;

public class LargestPrimeFibonacci {

	public int getFibonacci(int n){
		      
		      int i=0;
		      int j=1;
		      int fib=0;
		      while(fib < n){
		    	  fib=i+j;
		    	  i=j;
		    	  j=fib;
		    	  
		      }
		      if(!isPrime(fib)){
		    	  while(!isPrime(fib)){
		    		  fib=i+j;
		    		  i=j;
		    		  j=fib;
		    	  }
		      }
		      return fib;
		
	}
	
	public boolean isPrime(int k){
		int count=0;
		int limit=(int) Math.sqrt(k)+1;
		for (int i = 2; i < limit; i++) {
			 if(k%i==0)
				 count++;
			 if(count>=1)
				 return false;
		}
		
		return true;
		
	}
	
	public TreeSet<Integer> printPrimeFactors(int n){
		TreeSet<Integer> treeSet=new TreeSet<Integer>();
		int i; 
		System.out.println("prime factors of "+n+" are: ");
		for(i=2;i<=n;i++) 
		{ 
		if(n%i==0) 
		{ 
		System.out.println(i);
		treeSet.add(i);
		n=n/i; 
		i--; 
		if(n==1) 
		break; 
		} 
		} 
		return treeSet;
	}
	public static void main(String[] args) {
		    TreeSet<Integer> treeSet=null;
             int n=217000;
             int k=new LargestPrimeFibonacci().getFibonacci(n);
             System.out.println(k);
             treeSet=new LargestPrimeFibonacci().printPrimeFactors(k+1);
             Iterator<Integer> it=treeSet.iterator();
             int sum=0;
             while(it.hasNext()){
            	 
            	 sum=sum+it.next();
             }
          System.out.println(sum);   
             
	}

}
