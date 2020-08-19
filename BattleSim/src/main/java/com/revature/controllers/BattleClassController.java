package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.revature.models.BattleClass;

import com.revature.services.BattleClassServiceImpl;

public class BattleClassController {

	public static Gson gson = new Gson();
	public static BattleClassServiceImpl battleClassService = new BattleClassServiceImpl();

	public static void getAllBattleClass(HttpServletRequest request, HttpServletResponse response) {
		List<BattleClass> classes = battleClassService.getAllBattleClass();

		try {
			if (classes == null) {
				response.getWriter().append("{}");
			} else
				response.getWriter().append(gson.toJson(classes));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void getBattleClassById(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id").toString());
		
		BattleClass bc = battleClassService.getBattleClass(id);
		
		try {
			if (bc == null) {
				response.getWriter().append("{}");
			} else
				response.getWriter().append(gson.toJson(bc));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void addBattleClass(HttpServletRequest request, HttpServletResponse response) {
		try {
			BattleClass bc = gson.fromJson(request.getReader(), BattleClass.class);
			
			if(bc != null) {
				bc.setClassId(battleClassService.addBattleClass(bc));
			
			response.getWriter().append(gson.toJson(bc));
			
			}
			else response.getWriter().append("{}");
			
			
		} catch (JsonSyntaxException | JsonIOException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
