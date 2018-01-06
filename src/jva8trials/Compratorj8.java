	package jva8trials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Compratorj8  {
	
	
	
	public static void main(String[] args) {
		
	
//	Comparator<String>  comp = new Comparator<String>() {
//		
//		@Override
//		public int compare(String o1, String o2) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//	};
		List<String> Slist =new ArrayList<String>();
		Slist.add("Prakash");
		Slist.add("Rekhs");
		Slist.add("rohan");
		Map<String, String> maplist=new HashMap<>();
		maplist.put("1", "pkp");
		maplist.put("2", "AKA");
		Comparator<String> compobj = (o1,o2) ->{return 1;};
		Slist.sort(compobj);
		Slist.forEach(listobj->System.out.println(listobj));
		maplist.forEach((K,V)->{if(K.equals("1"))System.out.println(V);});
		
		Stream.iterate(17, count->count+1)  
        .filter(num->num%17==0)  
        .limit(10)  
        .forEach(System.out::println); 
		
		String word= "Hello World";
		//String up1=
			//	Stream.of(word).map(String::toUpperCase).reduce(x->x);
		//System.out.println(up1);
		
		List<String> x1= Arrays.asList("me","pk","ok");
		String concatx1=String.join("", x1);
		System.out.println(concatx1);
		List<List<Integer>> listOfListOfNumber = new ArrayList<>(); 
		listOfListOfNumber.add(Arrays.asList(2, 4)); 
		listOfListOfNumber.add(Arrays.asList(3, 9));
		listOfListOfNumber.add(Arrays.asList(4, 16)); 
		System.out.println("list of list : " + listOfListOfNumber); 
		// let's use flatMap() to flatten this list into 
		// list of integers i.e. 2,4,3,9,4,16 
		List<Integer> listOfIntegers = listOfListOfNumber.stream().flatMap( list -> list.stream()).map(x->x+2).collect(Collectors.toList());
		listOfIntegers.forEach(System.out::println);
		//Read more: http://javarevisited.blogspot.com/2016/03/difference-between-map-and-flatmap-in-java8.html#ixzz51G6iDEyf
		//String upcase =
	
	}
}
