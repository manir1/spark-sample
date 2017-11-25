package com.m101j.routes;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkFreemarkerRoutes {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(SparkFreemarkerRoutes.class, "/");
		Spark.get("/", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				try{
					Template fruitPickerTemplate = configuration.getTemplate("fruitPicker.ftl");
					StringWriter writer = new StringWriter();
					Map<String, Object> dataModel = new HashMap<String,Object>();
					dataModel.put("fruits", Arrays.asList("Apple","Orange","Banana","Mango"));
					fruitPickerTemplate.process(dataModel, writer);
					System.out.println(writer);
					return writer;
					
				}catch(Exception e){
					Spark.halt(500);
					return null;
				}
				
			}
		});
		
		Spark.post("/favorite_fruit", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				final String fruit = request.queryParams("fruit");
				if(fruit == null){
					return "Why don't you pick one?";
				}else{
					return "Your favorite fruit is " + fruit;
				}
				
			}
		});
		
	}

}
