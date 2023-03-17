package RPG_GAME;

import java.util.ArrayList;

public class Player {
	private static int money;
	private static Guild guild = new Guild();
	private static Inventory inven = new Inventory();

	public Player() {
		money = 100000;
		guild.setGuild();
	}

	public void guildMenu() {
		guild.guildMenu();
	}

	public void inventoryMenu() {
		inven.inventoryMenu();
	}

	public static int getMoney() {
		return money;
	}

	public static void setMoney(int money) {
		Player.money = money;
	}

	public static Guild getGuild() {
		return guild;
	}

	public static void setGuild(Guild guild) {
		Player.guild = guild;
	}

	public static Inventory getInven() {
		return inven;
	}

	public static void setInven(Inventory inven) {
		Player.inven = inven;
	}
	
//	public int indexOfUnit(Unit unit) {
//		int index = -1;
//		ArrayList<Unit> tempList = guild.getGuildList();
//		for(Unit temp : tempList) {
//			if(temp.name.equals(unit.name)) {
//				index = guild.getGuildList().indexOf(temp);
//			}
//		}
//		
//		return index;
//	}
	
	public static void addItemToInventory(Item item) {
		inven.addItem(item);
	}
	
	public static void addUnitToGuildList(Unit unit) {
		guild.addGuildList(unit);
	}

	static public ArrayList<Unit> getGuildList() {
		return guild.getGuildList();
	}
	
	static public void setGuildList(ArrayList<Unit> list) {
		guild.setGuildList(list);
	}

	static public ArrayList<Item> getItemList() {
		return inven.getItemList();
	}

	static public Unit getGuildUnit(int num) {
		return guild.getGuildUnit(num);
	}

	static public int getGuildSize() {
		return guild.getGuildListSize();
	}

	static public int getItemSize() {
		return inven.getItemListSize();
	}
}