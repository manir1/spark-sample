package com.m101j.routes;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkRoutes {

	public static void main(String[] args) {
		Spark.setPort(8081);
		Spark.get("/", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				return "Hello World from Spark!";
			}
		});
		
		Spark.get("/test", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				return "This is a test page";
			}
		});
		
		Spark.get("/echo/:thing", new Route() {
			
			@Override
			public Object handle(Request request, Response response) throws Exception {
				// TODO Auto-generated method stub
				return "This is a request param page: " + request.params(":thing");
			}
		});

	}

}
