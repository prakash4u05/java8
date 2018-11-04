package javatest;

public class Marckdown {
	
	public static String markDown(String header){
		
		int index = header.trim().indexOf(" ");
		
		boolean flag= (index>=1 && index<=6) ? true : false;
		
		return flag?"<h"+index+">"+header.trim().substring(index).trim()+"</h"+index+">":header;
		//return null;
	}

	public static void main(String[] args) {
		System.out.println(markDown("###header"));
	}
}
