package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.revature.models.Inventory;
import com.revature.services.InventoryService;
import com.revature.services.InventoryServiceImpl;

public class InventoryController {

	public static InventoryService is = new InventoryServiceImpl();
	public static Gson gson = new Gson();

	public static void getInventory(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Inventory s = new Inventory();
		s = is.getInventory(id);
		if (s != null) {
			response.getWriter().append(gson.toJson(s));
		} else {
			response.getWriter().append("{}");
		}

	}

	public static void addInventory(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		Inventory s = gson.fromJson(request.getReader(), Inventory.class);
		int id = is.addInventory(s);
		if (id > 0) {
			response.getWriter().append(gson.toJson(s));
		} else {
			response.getWriter().append("{}");
		}

	}

	public static void getAllInventory(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List<Inventory> InventoryList = is.getAllInventories();
		response.getWriter().append(gson.toJson(InventoryList));

	}

	public static void updateInventory(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		Inventory s = gson.fromJson(request.getReader(), Inventory.class);
		is.updateInventory(s);
		

	}

	public static void deleteInventory(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		Inventory s = gson.fromJson(request.getReader(), Inventory.class);
		is.deleteInventory(s.getID());

	}

}
