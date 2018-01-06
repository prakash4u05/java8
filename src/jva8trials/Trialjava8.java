package jva8trials;

import java.util.ArrayList;
import java.util.List;

public class Trialjava8  {
	
	
	
	public static void main(String[] args) {
		
		//List<String> x= ArrayList<String>::new;
		System.out.println("check");
		trialInterface test = (l,b) -> {int sum =l+b;return sum;};//System.out.println(sum);};
//		Trialjava8 test= new Trialjava8(){
//			@Override
//			public void method1(){System.out.println();}
//			
//		};
		int c=test.method1(11,12);
		System.out.println(c);
		
	}

	
	

}
