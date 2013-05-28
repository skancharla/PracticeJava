package org.lookout.interview;

import java.util.Arrays;

public class Quiz {
public void foobar(){
	  for (int i = 1; i <=100; i++) {
		if(i%3==0 && i%5==0){
			System.out.println("FooBar");
		}
		else if(i%5==0){
			System.out.println("Bar");
		}
		else if(i%3==0){
			System.out.println("Foo");
		}
		else{
			System.out.println(i);
		}
	}
	
}

public boolean isPalindrome(char[] input){
	 if(input==null || input.length==0){
		 System.out.println("input is either empty array or null");
		 return false;
	 }
	 if(input.length==1){
		 return true;
	 }
	 int i=0;
	 int j=input.length-1;
	 while(i<j){
		 if(input[i]!=input[j])
			 return false;
		 i++;
		 j--;
	 }
	 return true;
}

public boolean sumExists(final int[] intArray , final int sum){
	  if(intArray==null){
		  System.out.println("array is null");
		  return false;
	  }
	  if(intArray.length==0 || intArray.length==1){
		  System.out.println("array length is :"+intArray.length);
		  return false;
	  }
	  Arrays.sort(intArray);
	  int i=0;
	  int j=intArray.length-1;
	  while(i<j){
		  if(intArray[i]+intArray[j]==sum){
			  return true;
		  }
		  else {
			  if(intArray[i]+intArray[j]>sum)
				  j--;
			  if(intArray[i]+intArray[j]<sum)
				  i++;
		  }
	  }
	  
	  return false;
	
}

public long treeSum(TreeNode node){
	if(node==null){
		return 0;
	}
	
	return node.value+treeSum(node.leftSubtree)+treeSum(node.rightSubTree);
}
	public static void main(String[] args) {
		//new Quiz().foobar();
		//System.out.println(new Quiz().isPalindrome("".toCharArray()));
		int[] input={1,5,2,10,13};
		System.out.println(new Quiz().sumExists(input, 11));

	}

}
