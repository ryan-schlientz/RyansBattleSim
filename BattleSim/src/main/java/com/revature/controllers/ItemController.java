package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.revature.models.Item;
import com.revature.services.ItemService;
import com.revature.services.ItemServiceImpl;

public class ItemController {
	
	public static ItemService is = new ItemServiceImpl();
	public static Gson gson = new Gson();
	
	public static void getItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Item i = new Item();
		i = is.getItem(id);
		if (i != null) {
			response.getWriter().append(gson.toJson(i));
		}
		else {
			response.getWriter().append("{}");
		}
		
	}
	
	public static void addItem(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		
		Item i = gson.fromJson(request.getReader(), Item.class);
		int id = is.addItem(i);
		if (id > 0) {
			i.setId(id);
			response.getWriter().append(gson.toJson(i));
		}
		else {
			response.getWriter().append("{}");
		}
		
	}
	
	public static void getAllItems(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Item> itemList = is.getAllItems();
		response.getWriter().append(gson.toJson(itemList));
		
	}
	
	
}
