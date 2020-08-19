package com.revature.serf;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.BattleClassController;
import com.revature.controllers.CreatureController;

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
			CreatureController.getCreatureById(request, response);
			break;
		case "/BattleSim/addCreature.do":
			CreatureController.addCreature(request, response);
			break;
		case "/BattleSim/getAllCreatures.do":
			CreatureController.getAllCreatures(request, response);
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
		case "/BattleSim/getBattleClass.do":
			BattleClassController.getBattleClassById(request, response);
			break;
		case "/BattleSim/getAllBattleClasses.do":
			BattleClassController.getAllBattleClass(request, response);
			break;
		case "/BattleSim/addBattleClass.do":
			BattleClassController.addBattleClass(request, response);
			break;
		default: response.sendError(418, "I'm a Teapot");
			break;
		}
	}

}
