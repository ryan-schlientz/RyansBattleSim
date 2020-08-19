package com.revature.serf;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.InventoryController;
import com.revature.controllers.ItemController;
import com.revature.controllers.StatsController;

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
			ItemController.getItem(request, response);
			break;
		case "/BattleSim/getAllItems.do":
			ItemController.getAllItems(request, response);
			break;
		case "/BattleSim/addItems.do":
			ItemController.addItem(request, response);
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
			StatsController.addStats(request, response);
			break;
		case "/BattleSim/getStats.do":
			StatsController.getStats(request, response);
			break;
		case "/BattleSim/getAllStats.do":
			StatsController.getAllStats(request, response);
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
