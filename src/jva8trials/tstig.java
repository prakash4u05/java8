package jva8trials;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

//@FunctionalInterface
public class tstig {
	public static void main(String [] args){
	    String name="WelcomeJava";
	    Runnable r1=() -> System.out.println(name);
	    String name1="";
	    name1=name.toUpperCase();
	  //  Runnable r2=() -> System.out.println(name1);
	    r1.run();
	  }


}
