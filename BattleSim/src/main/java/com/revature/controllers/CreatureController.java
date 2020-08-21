package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.revature.models.Creature;
import com.revature.services.CreatureServiceImpl;

public class CreatureController {
	public static CreatureServiceImpl creatureaService = new CreatureServiceImpl();
	public static Gson gson = new Gson();

	public static void getAllCreatures(HttpServletRequest request, HttpServletResponse response) {
		List<Creature> creatures = creatureaService.getAllCreatures();

		try {
			if (creatures == null) {
				response.getWriter().append("{}");
			} else
				response.getWriter().append(gson.toJson(creatures));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getCreatureById(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id").toString());

		Creature creature = creatureaService.getCreature(id);
		try {
			if (creature == null) {
				response.getWriter().append("{}");
			} else
				response.getWriter().append(gson.toJson(creature));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void getRandomCreature(HttpServletRequest request, HttpServletResponse response) {
		
		Creature creature = creatureaService.getRandomCreature();
		try {
			if (creature == null) {
				response.getWriter().append("{}");
			} else
				response.getWriter().append(gson.toJson(creature));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void addCreature(HttpServletRequest request, HttpServletResponse response) {
		try {
			Creature creature = gson.fromJson(request.getReader(), Creature.class);
			
			if(creature != null) {
			creature.setCrId(creatureaService.addCreature(creature));
			
			response.getWriter().append(gson.toJson(creature));
			
			}
			else response.getWriter().append("{}");
			
			
		} catch (JsonSyntaxException | JsonIOException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void deleteCreature(HttpServletRequest request, HttpServletResponse response) {
		try {
			Creature creature = gson.fromJson(request.getReader(), Creature.class);
			
			if(creature != null) {
			creatureaService.deleteCreature(creature.getCrId());
			
			}
			else response.getWriter().append("{}");
			
			
		} catch (JsonSyntaxException | JsonIOException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void updateCreature(HttpServletRequest request, HttpServletResponse response) {
		try {
			Creature creature = gson.fromJson(request.getReader(), Creature.class);
			
			if(creature != null) {
			creatureaService.updateCreature(creature);
			
			response.getWriter().append(gson.toJson(creature));
			
			}
			else response.getWriter().append("{}");
			
			
		} catch (JsonSyntaxException | JsonIOException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
