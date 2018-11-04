package jva8trials;

import java.util.stream.IntStream;

/*Given an array of length n find if there are two numbers whose sum is S
 * AR[2,2,5,6] S=11
 * 
 */


public class GetSum{
	
	public static int BinarySearch(int[] intArray,int l,int n,int num)
	{
		return num;
	}
	
	
	public static void main(String[] args) {

		int[] intArray = {2,2,3,5,6,8,1,7};
		int num = 8;  
		/*Without Java 8 = n^2*/
		for (int i = 0; i < intArray.length; i++) {
			for (int j = i+1; j < intArray.length; j++) {
				int tempSum=intArray[i]+intArray[j];
				if(tempSum==num)
				{
					System.out.println("Sum of "+intArray[i]+"and"+intArray[j]);
				}
			}
			
		}
		
		int[] SortedArray=IntStream.of(intArray).sorted().toArray();
		//System.out.println(SortedArray[2]);
		
		for (int i = 0; i < intArray.length; i++) {
	        int n = SortedArray.length;
	        int numToSearch = num-intArray[i];
	        int otherNum=BinarySearch(SortedArray,0,n-1,numToSearch);
		}

	}

	
}