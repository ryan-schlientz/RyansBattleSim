package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.revature.models.Stats;
import com.revature.services.StatsService;
import com.revature.services.StatsServiceImpl;

public class StatsController {

	public static StatsService ss = new StatsServiceImpl();
	public static Gson gson = new Gson();

	public static void getStats(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Stats s = new Stats();
		s = ss.getStats(id);
		if (s != null) {
			response.getWriter().append(gson.toJson(s));
		} else {
			response.getWriter().append("{}");
		}

	}

	public static void addStats(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {

		Stats s = gson.fromJson(request.getReader(), Stats.class);
		int id = ss.addStats(s);
		if (id > 0) {
			s.setId(id);
			response.getWriter().append(gson.toJson(s));
		} else {
			response.getWriter().append("{}");
		}

	}

	public static void getAllStats(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List<Stats> StatsList = ss.getAllStats();
		response.getWriter().append(gson.toJson(StatsList));

	}

	public static void updateStats(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Stats stats = gson.fromJson(request.getReader(), Stats.class);
		ss.updateStats(stats);

	}

	public static void deleteStats(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Stats stats = gson.fromJson(request.getReader(), Stats.class);
		ss.deleteStats(stats);
	}

}
