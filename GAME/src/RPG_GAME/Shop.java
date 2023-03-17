package RPG_GAME;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Item> itemList = new ArrayList<>();

	public Shop() {
		int kind = Item.WEAPON;
		String name = "언데드소울다이아케인";
		int power = 3;
		int price = 1000;
		Item temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.WEAPON;
		name = "화투패";
		power = 5;
		price = 2000;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.WEAPON;
		name = "고양이발";
		power = 7;
		price = 2500;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.ARMOR;
		name = "언데드소울다이아셔츠";
		power = 1;
		price = 300;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.ARMOR;
		name = "거적떼기";
		power = 4;
		price = 800;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.ARMOR;
		name = "고양이잠옷";
		power = 7;
		price = 1500;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.RING;
		name = "언데드소울다이아링";
		power = 7;
		price = 3000;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.RING;
		name = "금반지";
		power = 17;
		price = 6000;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.RING;
		name = "고양이방울반지";
		power = 35;
		price = 20000;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.HAT;
		name = "언데드소울다이아헬멧";
		power = 5;
		price = 2000;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.HAT;
		name = "중절모";
		power = 15;
		price = 2000;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.HAT;
		name = "고양이귀";
		power = 85;
		price = 100000;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.SHOES;
		name = "언데드소울다이아슈즈";
		power = 6;
		price = 3500;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.SHOES;
		name = "고무신";
		power = 19;
		price = 10000;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);

		kind = Item.SHOES;
		name = "고양이발바닥";
		power = 35;
		price = 15000;
		temp = new Item(kind, name, power, price);
		this.itemList.add(temp);
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
				else if (selKind == Item.SHOES)
					System.out.println("=========== [신발] ============");
				printItems(selKind);
				System.out.println("[골드 : " + Player.getMoney() + "]");
				System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
				int selNum = MainGame.inputNumber();
				if (selNum == 0)
					break;

				buyItem(selKind, selNum);
			}
		}
	}

	private void buyItem(int selKind, int selNum) {
		int count = 0;
		int index = -1;
		for (int i = 0; i < this.itemList.size(); i++) {
			if (this.itemList.get(i).getKind() == selKind) {
				count++;
				if (count == selNum) {
					index = i;
					break;
				}
			}
		}
		if (index == -1) {
			System.out.println("존재하지 않는 아이템 번호입니다");
			return;
		}

		if (Player.getMoney() < this.itemList.get(index).getPrice()) {
			System.out.println("보유하고 있는 금액이 부족합니다");
			return;
		}

		Player.inven.addItem(this.itemList.get(index));
		int moneyTemp = Player.getMoney() - this.itemList.get(index).getPrice();
		Player.setMoney(moneyTemp);
		System.out.println("[" + this.itemList.get(index).getName() + "] 을 구입했습니다.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void printItems(int kind) {
		int count = 0;
		for (int i = 0; i < this.itemList.size(); i++) {
			if (this.itemList.get(i).getKind() != kind)
				continue;
			System.out.print("[" + (count + 1) + "번]");
			System.out.print("[이름 : " + this.itemList.get(i).getName() + "]");
			System.out.print("[능력 : " + this.itemList.get(i).getPower() + "]");
			System.out.print("[가격 : " + this.itemList.get(i).getPrice() + "]");
			System.out.println("");
			count++;
		}
	}

	public ArrayList<Item> getItemList() {
		return (ArrayList<Item>) this.itemList.clone();
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

}