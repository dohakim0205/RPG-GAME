package RPG_GAME;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> itemList = new ArrayList<>();

	public void inventoryMenu() {
		while (true) {
			System.out.println("============ [인벤메뉴] =============");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int sel = MainGame.scan.nextInt();
			if (sel == 0)
				break;
			if (sel == 1) {
				equipMenu();
			}
			if (sel == 2) {
				sellMenu();
			}
		}
	}

	public void equipMenu() {
		Player.getGuild().printAllUnitStaus();
		System.out.println("아이템 착용할 길드원을 선택하세요 ");
		int selUnit = MainGame.scan.nextInt();
		while (true) {
			Player.getGuild().printUnitStaus(selUnit - 1);
			Player.getGuild().printUnitItem(selUnit - 1);
			printItemList();
			System.out.println("착용할 아이템 번호를 입력하세요 [0.뒤로가기]");
			int selEquip = MainGame.scan.nextInt();
			if (selEquip == 0)
				break;
			selEquip--;
			
			Item[] unitItem = new Item [getItemListSize()];
			Unit unit = Player.getGuildUnit(selUnit - 1);
			unitItem[0] = unit.getWeapon();
			unitItem[1] = unit.getArmor();
			unitItem[2] = unit.getRing();
			unitItem[3] = unit.getHat();
			unitItem[4] = unit.getShoes();
			
			for(int i = 0; i < unitItem.length; i ++) {
				for(int j = Item.WEAPON; j <= Item.SHOES; j ++) {
					int kind = this.itemList.get(selEquip).getKind();
					if(kind == j) {
						if (unitItem[i] != null) {
							this.itemList.add(unitItem[i]);
						}
						
						unit.setWeapon(this.itemList.get(selEquip));
					}
				}
			}
			
			if (this.itemList.get(selEquip).getKind() == Item.WEAPON) {
				
			} else if (this.itemList.get(selEquip).getKind() == Item.ARMOR) {
				if (Player.getGuildUnit(selUnit - 1).getArmor() != null) {
					this.itemList.add(Player.getGuildUnit(selUnit - 1).getArmor());
				}
				Player.getGuildUnit(selUnit - 1).setArmor(this.itemList.get(selEquip));
			} else if (this.itemList.get(selEquip).getKind() == Item.RING) {
				if (Player.getGuildUnit(selUnit - 1).getRing() != null) {
					this.itemList.add(Player.getGuildUnit(selUnit - 1).getRing());
				}
				Player.getGuildUnit(selUnit - 1).setRing(this.itemList.get(selEquip));
			} else if (this.itemList.get(selEquip).getKind() == Item.HAT) {
				if (Player.getGuildUnit(selUnit - 1).getHat() != null) {
					this.itemList.add(Player.getGuildUnit(selUnit - 1).getHat());
				}
				Player.getGuildUnit(selUnit - 1).setHat(this.itemList.get(selEquip));
			} else if (this.itemList.get(selEquip).getKind() == Item.SHOES) {
				if (Player.getGuildUnit(selUnit - 1).getShoes() != null) {
					this.itemList.add(Player.getGuildUnit(selUnit - 1).getShoes());
				}
				Player.getGuildUnit(selUnit - 1).setShoes(this.itemList.get(selEquip));
			}
			this.itemList.remove(selEquip);
		}
	}

	public void printItemList() {
		System.out.println("============ [아이템리스트] ==============");
		for (int i = 0; i < this.itemList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print("[이름 : " + this.itemList.get(i).getName() + "]");
			System.out.print("[능력 : " + this.itemList.get(i).getPower() + "]");
			System.out.print("[가격 : " + this.itemList.get(i).getPrice() + "]");
			System.out.println("");
		}
	}

	private int checkSelNum() {
		int selNum = MainGame.inputNumber() - 1;
		if (selNum < 0 || selNum >= this.getItemListSize()) {
			selNum = -1;
		}

		return selNum;
	}

	public void sellMenu() {
		printItemList();
		System.out.println("[골드 : " + Player.getMoney() + "]");
		System.out.println("판매할 아이템 번호를 입력하세요. (50 % 세금) [0.뒤로가기]");
		int selNum = checkSelNum();
		if (selNum == -1) {
			return;
		}
		System.out.println("=================================");
		System.out.println(this.itemList.get(selNum).getName() + "을 판매합니다.");
		System.out.println("=================================");
		int money = Player.getMoney() + (this.itemList.get(selNum).getPrice() / 2);
		Player.setMoney(money);
		this.itemList.remove(selNum);
		System.out.println("[골드 잔액 : " + Player.getMoney() + "]");
		System.out.println("=================================");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}

	public int getItemListSize() {
		return this.itemList.size();
	}

	public ArrayList<Item> getItemList() {
		return (ArrayList) this.itemList.clone();
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	public void addItem(Item item) {
		this.itemList.add(item);
	}

}