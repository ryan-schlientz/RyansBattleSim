package com.revature.serf;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.InventoryController;
import com.revature.controllers.ItemController;
import com.revature.controllers.StatsController;
import com.revature.controllers.AccountController;

public class RequestHelper {

	public static void requestdirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AccountController ac = new AccountController();
		String uri = request.getRequestURI();

		switch (uri) {
		case "/BattleSim/getUser.do":
			ac.getUser(request, response);
			break;
		case "/BattleSim/addUser.do":
			ac.addUser(request, response);
			break;
		case "/BattleSim/login.do":
			ac.login(request, response);
			break;
		case "/BattleSim/addCharacter.do":
			ac.addCharacter(request, response);
			break;
		case "/BattleSim/getCharacter.do":
			ac.getCharacter(request, response);
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
			InventoryController.getInventory(request, response);
			break;
		case "/BattleSim/addInventory.do":
			InventoryController.addInventory(request, response);
			break;
		case "/BattleSim/getAllInventory.do":
			InventoryController.getAllInventory(request, response);
			break;
		case "/BattleSim/deleteUser.do":
			ac.deleteUser(request, response);
			break;
		case "/BattleSim/deleteCharacter.do":
			ac.deleteCharacter(request, response);
			break;
		case "/BattleSim/deleteCreature.do":
			break;
		case "/BattleSim/deleteItem.do":
			break;
		case "/BattleSim/deleteInventory.do":
			break;
		case "/BattleSim/updateUser.do":
			ac.updateUser(request, response);
			break;
		case "/BattleSim/updateCharacter.do":
			ac.updateCharacter(request, response);
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
