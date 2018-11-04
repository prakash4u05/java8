package javatest;

import java.util.List;
import java.util.stream.Collectors;

class Document{
	int version;
	int type;
	String name;
	
	public Document(int version,int type,String name){
		this.version=version;
		this.type= type;
		this.name=name;
	}
	
}

public class Version {

	public static List<Document> find(List<Document> dList,int version){
		return dList.stream().filter(x->x.version>version).collect(Collectors.toList());
		
		//return null;
	}

	
	public static void main(String[] args) {
		
		
	}
}
