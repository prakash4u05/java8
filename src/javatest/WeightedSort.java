package javatest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*56 65 75 34 92 474 100*/
public class WeightedSort {
	
	public static String weightSort(String weightString)
	{
		if(weightString==null)
		{
			return weightString;
		}
		
		String[] weightList=weightString.split(" ");
		Arrays.sort(weightList);
		Arrays.sort(weightList,(str1,str2)->{
			System.out.println(str1+" "+str2);
			System.out.println((weight(Integer.parseInt(str1))+" "+weight(Integer.parseInt(str2))));
			return (weight(Integer.parseInt(str1))-weight(Integer.parseInt(str2)));
			//return str1.compareTo(str2);
		});
		return Arrays.asList(weightList).stream().collect(Collectors.joining(" "));
	}
	public static String weightSort1(String weightString)
	{
		if(weightString==null)
		{
			return weightString;
		}
		
		String[] weightList=weightString.split(" ");
		//Arrays.sort(weightList);
		Arrays.sort(weightList,(str1,str2)->{
			int i=0;
			System.out.println(str1+" "+str2);
			for (char c : (str1+" "+str2).toCharArray()){
				if(c==' ')
				{
					//System.out.println(c);
					i=-i;
					continue;
				}
				i+=(c-48);
				
			}
			System.out.println(i);
			return i;
		});
		return Arrays.asList(weightList).stream().collect(Collectors.joining(" "));
	}
	/*To check the weight*/
	private static int weight(int parseInt) {
		int sum =0;
		while(parseInt!=0){
			int digit = parseInt%10;
			sum=sum+digit;
			parseInt=parseInt/10;
		}
		return sum;
	
}
public static void main(String[] args) {
		
		System.out.println(weightSort("65 56 65 75 34 92 474 100"));
		System.out.println(weightSort1("65 56 65 75 34 92 474 100"));
		
	}

}
