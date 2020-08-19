package com.revature.serf;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static void requestdirect(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String uri = request.getRequestURI();

		switch (uri) {
		case "/BattleSim/getUser.do":
			break;
		case "/BattleSim/addUser.do":
			break;
		case "/BattleSim/login.do":
			break;
		case "/BattleSim/getCharacter.do":
			break;
		case "/BattleSim/getCreature.do":
			break;
		case "/BattleSim/addCreature.do":
			break;
		case "/BattleSim/getAllCreatures.do":
			break;
		case "/BattleSim/getItem.do":
			break;
		case "/BattleSim/getAllItems.do":
			break;
		case "/BattleSim/getInventory.do":
			break;
		case "/BattleSim/deleteUser.do":
			break;
		case "/BattleSim/deleteCharacter.do":
			break;
		case "/BattleSim/deleteCreature.do":
			break;
		case "/BattleSim/deleteItem.do":
			break;
		case "/BattleSim/deleteInventory.do":
			break;
		case "/BattleSim/updateUser.do":
			break;
		case "/BattleSim/updateCharacter.do":
			break;
		case "/BattleSim/updateCreature.do":
			break;
		case "/BattleSim/updateItem.do":
			break;
		case "/BattleSim/updateInventory.do":
			break;
		case "/BattleSim/addStats.do":
			break;
		case "/BattleSim/getStats.do":
			break;
		case "/BattleSim/updateStats.do":
			break;
		case "/BattleSim/deleteStats.do":
			break;
		default: response.sendError(418, "I'm a Teapot");
			break;
		}
	}

}
