package com.m101j.routes;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSparkFreemarkerStyle {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");
		Spark.get("/", new Route() {

			public Object handle(Request arg0, Response arg1) throws Exception {
				Template helloTemplate = configuration.getTemplate("hello.ftl");
				StringWriter writer = new StringWriter();
				Map<String, Object> dataModel = new HashMap<String, Object>();
				dataModel.put("name", "Freemarker");
				helloTemplate.process(dataModel, writer);
				System.out.println(writer);
				return writer;
			}
		});
	}

}
