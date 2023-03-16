package RPG_GAME;

import java.util.ArrayList;

public class Shop {
	private static ArrayList<Item> itemList = new ArrayList<>();

	public Shop() {
		Item temp = new Item();
		temp.kind = Item.WEAPON;
		temp.name = "언데드소울다이아케인";
		temp.power = 3;
		temp.price = 1000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.WEAPON;
		temp.name = "화투패";
		temp.power = 5;
		temp.price = 2000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.WEAPON;
		temp.name = "고양이발";
		temp.power = 7;
		temp.price = 2500;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.ARMOR;
		temp.name = "언데드소울다이아셔츠";
		temp.power = 1;
		temp.price = 300;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.ARMOR;
		temp.name = "거적떼기";
		temp.power = 4;
		temp.price = 800;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.ARMOR;
		temp.name = "고양이잠옷";
		temp.power = 7;
		temp.price = 1500;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.RING;
		temp.name = "언데드소울다이아링";
		temp.power = 7;
		temp.price = 3000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.RING;
		temp.name = "금반지";
		temp.power = 17;
		temp.price = 6000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.RING;
		temp.name = "고양이방울반지";
		temp.power = 35;
		temp.price = 20000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.HAT;
		temp.name = "언데드소울다이아헬멧";
		temp.power = 5;
		temp.price = 2000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.HAT;
		temp.name = "중절모";
		temp.power = 15;
		temp.price = 2000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.HAT;
		temp.name = "고양이귀";
		temp.power = 85;
		temp.price = 100000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.SHOES;
		temp.name = "언데드소울다이아슈즈";
		temp.power = 6;
		temp.price = 3500;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.SHOES;
		temp.name = "고무신";
		temp.power = 19;
		temp.price = 10000;
		itemList.add(temp);

		temp = new Item();
		temp.kind = Item.SHOES;
		temp.name = "고양이발바닥";
		temp.power = 35;
		temp.price = 15000;
		itemList.add(temp);
	}

	public void shopMng() {
		while (true) {
			System.out.println("=============== [상점] ===============");
			System.out.println("[1.무기] [2.갑옷] [3.반지] [4.모자] [5.신발] [0.뒤로가기]");
			int selKind = MainGame.scan.nextInt();
			if (selKind == 0)
				return;
			while (true) {
				if (selKind == Item.WEAPON)
					System.out.println("=========== [무기] ============");
				else if (selKind == Item.ARMOR)
					System.out.println("=========== [방어구] ============");
				else if (selKind == Item.RING)
					System.out.println("=========== [반지] ============");
				else if (selKind == Item.HAT)
					System.out.println("=========== [모자] ============");
				else if (selKind == Item.HAT)
					System.out.println("=========== [신발] ============");
				printItems(selKind);
				System.out.println("[골드 : " + Player.getMoney() + "]");
				System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
				int selNum = MainGame.scan.nextInt();
				if (selNum == 0)
					break;
				int count = 0;
				for (int i = 0; i < itemList.size(); i++) {
					if (itemList.get(i).kind == selKind) {
						count++;
						if (count == selNum) {
							if (Player.getMoney() >= itemList.get(i).price) {
								Inventory invenTemp = Player.getInven();
								invenTemp.addItem(itemList.get(i));
								Player.setInven(invenTemp);
								int moneyTemp = Player.getMoney() - itemList.get(i).price;
								Player.setMoney(moneyTemp);
								System.out.println("[" + itemList.get(i).name + "] 을 구입했습니다.");
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							} else {
								System.out.println("보유하고 있는 금액이 부족합니다");
							}
							break;
						}
					}
				}
			}
		}
	}

	public void printItems(int kind) {
		int count = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).kind != kind)
				continue;
			System.out.print("[" + (count + 1) + "번]");
			System.out.print("[이름 : " + itemList.get(i).name + "]");
			System.out.print("[능력 : " + itemList.get(i).power + "]");
			System.out.print("[가격 : " + itemList.get(i).price + "]");
			System.out.println("");
			count++;
		}
	}

	public static ArrayList<Item> getItemList() {
		return itemList;
	}

	public static void setItemList(ArrayList<Item> itemList) {
		Shop.itemList = itemList;
	}

}