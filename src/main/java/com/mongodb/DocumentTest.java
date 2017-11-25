package com.mongodb;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import static util.helper.Helpers.printJson;
public class DocumentTest {

	public static void main(String[] args) {
		Document document = new Document()
							.append("string", "Hello , MongoDB!")
							.append("int", 100)
							.append("long", 1L)
							.append("double", 1000.00D)
							.append("float", 100.00f)
							.append("boolean", true)
							.append("Date", new Date())
							.append("List", Arrays.asList("Pen","Paper"));
		List<String> result = (List<String>) document.get("List");
		System.out.println(result.toString());
		printJson(document);
		
	}

}
