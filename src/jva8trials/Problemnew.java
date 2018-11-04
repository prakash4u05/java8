package jva8trials;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Properties;
import java.util.stream.Stream;

public class Problemnew {
	
	public static void main(String[] args) {
		String fileName = "/Users/prakashkumar/Documents/workspace/jva8trials/src/jva8trials/check.properties";///Users/prakashkumar/Desktop/check.txt";

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			//stream.
			stream.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
		File file = new File("/Users/prakashkumar/Documents/workspace/jva8trials/src/jva8trials/check.properties");
		FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			Enumeration enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				System.out.println(key + ": " + value);
			}
		
		}
		 catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}
}


