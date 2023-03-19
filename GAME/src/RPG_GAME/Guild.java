package RPG_GAME;

import java.util.ArrayList;

public class Guild {
	private final int PARTY_MAX = 4;
	private ArrayList<Unit> guildList = new ArrayList<>();
	private Unit[] partyList;
	private Unit guildMaster;
	private RandomBuff guildBuff = new RandomBuff();

	public void setGuild() {
		Unit temp = new Unit("아무거나도하", 100, 100, 10, 5, 0);
		this.guildList.add(temp);
		temp = new Unit("가위바위보진경", 20, 80, 7, 3, 0);
		this.guildList.add(temp);
		temp = new Unit("예지렁이", 70, 50, 3, 1, 0);
		this.guildList.add(temp);
		temp = new Unit("월세전세린", 1, 1000, 5, 2, 0);
		this.guildList.add(temp);
		temp = new Unit("나무늘보석", 14, 200, 4, 8, 0);
		this.guildList.add(temp);
		temp = new Unit("지은도끼금도끼", 80, 120, 11, 7, 0);
		this.guildList.add(temp);
		for (int i = 0; i < 4; i++) {
			this.guildList.get(i).setParty(true);
		}
		this.partyList = new Unit[this.PARTY_MAX];
		int n = 0;
		for (int i = 0; i < this.guildList.size(); i++) {
			if (this.guildList.get(i).isParty() == true) {
				this.partyList[n] = this.guildList.get(i);
				n += 1;
			}
		}

		this.guildMaster = this.guildList.get(0);
	}

	public void addGuildList(Unit unit) {
		this.guildList.add(unit);
	}

	public ArrayList<Unit> getGuildList() {
		ArrayList<Unit> reqObjs = new ArrayList<Unit>();
		for (int i = 0; i < this.guildList.size(); i++) {
			Unit temp = this.guildList.get(i);
			String name = temp.getName();
			int level = temp.getLevel();
			int hp = temp.getHp();
			int maxHp = temp.getMaxHp();
			int att = temp.getAtt();
			int def = temp.getDef();
			int exp = temp.getExp();
			boolean party = temp.isParty();
			Item weapon = temp.getWeapon();
			Item armor = temp.getArmor();
			Item ring = temp.getRing();
			Item hat = temp.getHat();
			Item shoes = temp.getShoes();

			Unit reqObj = new Unit(name, level, maxHp, att, def, exp, party);
			reqObj.setHp(hp);
			reqObj.setItem(weapon, armor, ring, hat, shoes);
			reqObjs.add(reqObj);
		}

		return reqObjs;
	}

	public int getGuildListSize() {
		return this.guildList.size();
	}

	public int getPartyListSize() {
		return this.partyList.length;
	}
	
	public RandomBuff getGuildBuff() {
		return guildBuff;
	}

	public void setGuildBuff(RandomBuff guildBuff) {
		this.guildBuff = guildBuff;
	}

	public void setGuildList(ArrayList<Unit> guildList) {
		this.guildList = guildList;
	}

	public Unit[] getPartyList() {
		return (Unit[]) this.partyList.clone();
	}

	public void setPartyList(Unit[] partyList) {
		this.partyList = partyList;
	}

	public void addUnitToPartyList(Unit newUnit) {
		Unit[] temp = this.partyList;
		this.partyList = new Unit[getPartyListSize() + 1];
		for (int i = 0; i < getPartyListSize() - 1; i++) {
			this.partyList[i] = temp[i];
		}
		this.partyList[getPartyListSize() - 1] = newUnit;
		newUnit.setParty(true);
	}

	public void removeUnitToPartyList(Unit delUnit) {
		Unit[] temp = this.partyList;
		this.partyList = new Unit[getPartyListSize() - 1];
		int index = 0;
		for (int i = 0; i < getPartyListSize() + 1; i++) {
			if (!(temp[i].equals(delUnit))) {
				this.partyList[index++] = temp[i];
				System.out.println(temp[i].getName());
			}
		}
		delUnit.setParty(false);
	}

	public int getPartySize() {
		return this.partyList.length;
	}

	public Unit getGuildUnit(int num) {
		Unit temp = this.guildList.get(num);
		String name = temp.getName();
		int level = temp.getLevel();
		int hp = temp.getHp();
		int maxHp = temp.getMaxHp();
		int att = temp.getAtt();
		int def = temp.getDef();
		int exp = temp.getExp();
		boolean party = temp.isParty();
		Item weapon = temp.getWeapon();
		Item armor = temp.getArmor();
		Item ring = temp.getRing();
		Item hat = temp.getHat();
		Item shoes = temp.getShoes();

		Unit reqObj = new Unit(name, level, maxHp, att, def, exp, party);
		reqObj.setHp(hp);
		reqObj.setItem(weapon, armor, ring, hat, shoes);
		return reqObj;
	}

	public void setGuildUnitEquip(Unit unit, Item item) {
		int index = indexOfUnit(unit);
		this.guildList.get(index).setEquip(item);
	}

	private int indexOfUnit(Unit unit) {
		int index = -1;
		for (Unit temp : this.guildList) {
			if (temp.getName().equals(unit.getName())) {
				index = this.guildList.indexOf(temp);
			}
		}

		return index;
	}

	public void printAllUnitStaus() {
		System.out.println("======================================");
		System.out.println("[골드 : " + Player.getMoney() + "]");
		System.out.println("============= [길드원] =================");
		for (int i = 0; i < this.getGuildListSize(); i++) {
			System.out.print("[" + (i + 1) + "번 길드원]");
			System.out.print(" [이름 : " + this.guildList.get(i).getName() + "]");
			System.out.print(" [레벨 : " + this.guildList.get(i).getLevel() + "]");
			System.out.print(" [체력 : " + this.guildList.get(i).getHp());
			System.out.println(" / " + this.guildList.get(i).getMaxHp() + "]");
			System.out.print("[공격력 : " + this.guildList.get(i).getAtt() + "]");
			System.out.print(" [방어력 : " + this.guildList.get(i).getDef() + "]");
			System.out.printf(" [파티중 : %s]", this.guildList.get(i).isParty() ? "O" : "X");
			System.out.println("");
		}
		System.out.println("=================================");
	}

	public void printisNotPartyUnit(ArrayList<Unit> unitsIsNotParty) {
		System.out.println("========= [파티 중이 아닌 길드원] =============");
		for (int i = 0; i < unitsIsNotParty.size(); i++) {
			System.out.print("[" + (i + 1) + "번 길드원]");
			Unit unit = unitsIsNotParty.get(i);
			printUnitStaus(this.guildList.indexOf(unit));
			System.out.println("");
		}
	}

	public void printUnitStaus(int num) {
		this.guildList.get(num).printStatus();
	}

	public void printUnitItem(int num) {
		this.guildList.get(num).printEquitedItem();
	}

	public void buyUnit() {
		System.out.println("[유닛 추가 : 5000골드]");
		System.out.println("추가 하시겠습니까? 1) 네 2) 아니오");
		int yes = MainGame.scan.nextInt();

		if (yes != 1) {
			return;
		}

		if (Player.getMoney() < 5000)
			return;

		String[] n1 = { "박", "고", "김", "최", "유", "차", "정" };
		String[] n2 = { "양", "도", "아", "보", "혜", "유", "이" };
		String[] n3 = { "연", "설", "윤", "빈", "리", "이", "현" };

		String name = n1[MainGame.ran.nextInt(n1.length)];
		name += n2[MainGame.ran.nextInt(n1.length)];
		name += n3[MainGame.ran.nextInt(n1.length)];
		int ran = MainGame.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;
		Unit temp = new Unit(name, 1, hp, att, def, 0);

		System.out.println("=====================================");
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + 1 + "]");
		System.out.print(" [체력 : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[공격력 : " + att + "]");
		System.out.println(" [방어력 : " + def + "]");
		System.out.println("길드원을 추가합니다.");
		System.out.println("=====================================");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.guildList.add(temp);
		int money = Player.getMoney() - 5000;
		Player.setMoney(money);
	}

	public void removeUnit() {
		if (this.getGuildListSize() == 0) {
			System.out.println("삭제할 수 있는 길드원이 없습니다");
			return;
		}

		printAllUnitStaus();
		System.out.println("삭제할 번호를 입력하세요 ");
		int sel = MainGame.scan.nextInt();
		if (this.guildList.get(sel - 1).isParty()) {
			System.out.println("파티중인 멤버는 삭제할 수 없습니다.");
		} else {
			System.out.println("=================================");
			System.out.print("[이름 : " + this.guildList.get(sel - 1).getName() + "]");
			System.out.println("길드원을 삭제합니다.");
			System.out.println("=================================");
			this.guildList.remove(sel - 1);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Unit> unitIsNotParty() {
		ArrayList<Unit> unitsIsNotParty = new ArrayList<Unit>();
		for (int i = 0; i < this.getGuildListSize(); i++) {
			Unit unit = this.getGuildUnit(i);
			if (unit.isParty() == false) {
				unitsIsNotParty.add(unit);
			}
		}

		return unitsIsNotParty;
	}

	public void printParty() {
		System.out.println("================ [파티원] ===============");
		for (int i = 0; i < this.partyList.length; i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + this.partyList[i].getName() + "]");
			System.out.print(" [레벨 : " + this.partyList[i].getLevel() + "]");
			System.out.print(" [체력 : " + this.partyList[i].getHp());
			System.out.println(" / " + this.partyList[i].getMaxHp() + "]");
			System.out.print("[공격력 : " + this.partyList[i].getAtt() + "]");
			System.out.print(" [방어력 : " + this.partyList[i].getDef() + "]");
			System.out.printf(" [파티중 : %s]\n", this.partyList[i].isParty() ? "O" : "X");
			System.out.println("");
		}
		System.out.println("=====================================");
	}

	public void partyChange() {

		printParty();
		System.out.println("교체할 번호를 입력하세요 ");
		int partyNum = MainGame.scan.nextInt();
		printAllUnitStaus();
		System.out.println("참가할 번호를 입력하세요 ");
		int guildNum = MainGame.scan.nextInt();

		this.partyList[partyNum - 1].setParty(false);
		this.guildList.get(guildNum - 1).setParty(true);

		System.out.println("========================================");
		System.out.print("[이름 : " + this.partyList[partyNum - 1].getName() + "]");
		System.out.print("에서 ");
		System.out.print("[이름 : " + this.guildList.get(guildNum - 1).getName() + "]");
		System.out.println("으로 교체 합니다. ");
		System.out.println("========================================");

		int n = 0;
		for (int i = 0; i < this.guildList.size(); i++) {
			if (this.guildList.get(i).isParty()) {
				this.partyList[n] = this.guildList.get(i);
				n += 1;
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void guildMenu() {
		while (true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println(
					"[1.길드목록] [2.길드원추가] [3.길드원삭제] [4.길드마스터 변경] [5.정렬]\n" + "[6.파티원교체]  [7.파티원추가] [8.파티원삭제] [0.뒤로가기]");
			int sel = MainGame.scan.nextInt();
			if (sel == 1) {
				printAllUnitStaus();
			} else if (sel == 2) {
				buyUnit();
			} else if (sel == 3) {
				removeUnit();
			} else if (sel == 4) {
				changeGuildMaster();
			} else if (sel == 5) {
				setArray();
			} else if (sel == 6) {
				partyChange();
			} else if (sel == 7) {
				addPartyUnit();
			} else if (sel == 8) {
				deletePartyUnit();
			} else if (sel == 0) {
				break;
			}
		}
	}

	public void changeGuildMaster() {
		System.out.println("[현재 길드마스터 : " + this.guildMaster.getName() + "]");
		printAllUnitStaus();
		System.out.println("길드마스터로 변경할 길드원을 선택해주세요");
		int index = MainGame.inputNumber() - 1;
		if (index < 0 || index >= this.guildList.size()) {
			System.out.println("존재하지 않는 번호입니다");
			return;
		}

		if (index == this.guildList.indexOf(this.guildMaster)) {
			System.out.println("이미 길드마스터인 길드원입니다");
			return;
		}

		this.guildMaster = this.guildList.get(index);
		System.out.println("[변경된 길드마스터 : " + this.guildMaster.getName() + "]");

	}

	private void sortGuildList(String whatKindOf) {
		for (int i = 0; i < getGuildListSize(); i++) {
			Unit unit = this.guildList.get(i);
			int index = i;

			for (int j = i + 1; j < getGuildListSize(); j++) {
				Unit findUnit = this.guildList.get(j);
				if (whatKindOf == "이름") {
					if (unit.getName().compareTo(findUnit.getName()) > 0) {
						unit = findUnit;
						index = j;
					}
				}

				else if (whatKindOf == "레벨") {
					if (unit.getLevel() - findUnit.getLevel() < 0) {
						unit = findUnit;
						index = j;
					}
				}
			}

			Unit standardUnit = this.guildList.get(i);
			this.guildList.set(i, unit);
			this.guildList.set(index, standardUnit);
		}

		printAllUnitStaus();
		System.out.println("정렬 되었습니다");
	}

	private void setArray() {
		System.out.println("1) 이름 순 정렬");
		System.out.println("2) 레벨 순 정렬");
		int select = MainGame.inputNumber();

		if (select != 1 && select != 2) {
			System.out.println("존재하지 않는 메뉴입니다");
		}

		else if (select == 1) {
			sortGuildList("이름");
		}

		else if (select == 2) {
			sortGuildList("레벨");
		}

	}

	private void addPartyUnit() {
		if (this.partyList.length == this.PARTY_MAX) {
			System.out.println("4명 이상 파티원을 추가할 수 없습니다.");
			return;
		}
		printParty();
		ArrayList<Unit> unitsIsNotParty = unitIsNotParty();
		printisNotPartyUnit(unitsIsNotParty);
		System.out.println("추가할 파티원을 선택하세요");
		int index = MainGame.inputNumber() - 1;
		Unit unit = null;
		try {
			unit = unitsIsNotParty.get(index);
		} catch (Exception e) {
			System.out.println("추가할 수 있는 파티원이 아닙니다");
			return;
		}

		System.out.println("=================================");
		System.out.print("[이름 : " + unit.getName() + "]");
		System.out.println("파티원을 등록합니다.");
		System.out.println("=================================");
		addUnitToPartyList(unit);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void deletePartyUnit() {
		if (this.partyList.length == 0) {
			System.out.println("더 이상 파티원을 삭제할 수 없습니다.");
			return;
		}
		printParty();
		System.out.println("삭제할 파티원을 선택하세요");
		int index = MainGame.inputNumber() - 1;
		Unit unit = null;
		try {
			unit = partyList[index];
		} catch (Exception e) {
			System.out.println("파티 중인 파티원이 아닙니다");
			return;
		}
		System.out.println("=================================");
		System.out.print("[이름 : " + unit.getName() + "]");
		System.out.println("파티원을 삭제합니다.");
		System.out.println("=================================");
		removeUnitToPartyList(unit);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void guildBuffStatus() {
		if(!this.guildBuff.isBuffStatus()) {
			System.out.println("길드 버프를 생성합니다");
			this.guildBuff.getGuildBuff();
		}
		
		else
			this.guildBuff.printGuildBuff();
	}

}