package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.Users;
import com.revature.services.CharacterService;
import com.revature.services.CharacterServiceImpl;
import com.revature.services.UsersService;
import com.revature.services.UsersServiceImpl;
import com.revature.models.Character;

public class AccountController {
	Gson gson = new Gson();
	UsersService us = new UsersServiceImpl();
	CharacterService cs = new CharacterServiceImpl();
	/*
	 * case "/BattleSim/getUser.do": break; case "/BattleSim/addUser.do": break;
	 * case "/BattleSim/login.do": break; case "/BattleSim/getCharacter.do": break;
	 * 
	 * 
	 * case "/BattleSim/deleteUser.do": break; case "/BattleSim/deleteCharacter.do":
	 * break;
	 * 
	 * case "/BattleSim/updateUser.do": break; case "/BattleSim/updateCharacter.do":
	 * break;
	 * 
	 */

	public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Users adduser = gson.fromJson(request.getReader(), Users.class);
		us.addUsers(adduser);
		response.getWriter().append(gson.toJson(adduser));
		response.setStatus(200);
	}

	public void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Users> allusers = us.getAllUsers();
		String username = "";
		Integer userid = 0;
		
		try {
			username = gson.fromJson(request.getReader(), String.class);
		} catch (Exception e) {
			userid = gson.fromJson(request.getReader(), Integer.class);
		}
		
		for(Users u : allusers) {
			if(u.getUsername().equals(username)) {
				response.getWriter().append(gson.toJson(us.getUser(username)));
				break;
			}
			if(u.getId() == userid) {
				response.getWriter().append(gson.toJson(us.getUser(userid)));
				break;
			}
				
		}
			
				
	}
	
	public void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Users> users = us.getAllUsers();

		try {
			if (users == null) {
				response.getWriter().append("{}");
			} else
				response.getWriter().append(gson.toJson(users));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Users u = gson.fromJson(request.getReader(), Users.class);
		us.updateUsers(u);
		response.setStatus(200);

	}

	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer i = gson.fromJson(request.getReader(), Integer.class);
		if(i != null)
			us.deleteUsers(i);
		response.setStatus(200);

	}

	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Users loginuser = gson.fromJson(request.getReader(), Users.class);
		loginuser = us.login(loginuser.getUsername(), loginuser.getPassword());
		if (loginuser != null) {
			HttpSession sess = request.getSession();
			sess.setAttribute("user", gson.toJson(loginuser));
			response.setStatus(200);
		} else {
			response.setStatus(401);
		}
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		sess.setAttribute("user", null);
		response.setStatus(200);
	}

	public void addCharacter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Users user = gson.fromJson(sess.getAttribute("user").toString(), Users.class);
		String battleClass = request.getParameter("battleClass").toString();
		String charName = request.getParameter("name");
		cs.addCharacter(user, battleClass, charName);
		response.setStatus(200);
	}

	public void getCharacter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer i = gson.fromJson(request.getReader(), Integer.class);
		cs.getCharacter(i);
		response.setStatus(200);

	}

	public void updateCharacter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Character c = gson.fromJson(request.getReader(), Character.class);
		cs.updateCharacter(c);
		response.setStatus(200);

	}

	public void deleteCharacter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer i = gson.fromJson(request.getReader(), Integer.class);
		cs.deleteCharacter(i);
		response.setStatus(200);

	}

}
