package RPG_GAME;

import java.util.ArrayList;

public class Guild {
	private final int PARTY_SIZE = 4;
	private String name;
	private ArrayList<Unit> guildList = new ArrayList<>();

	private Unit[] partyList;

	public void setGuild() {
		this.name = "";
		Unit temp = new Unit("아무거나도하", 1, 100, 10, 5, 0);
		guildList.add(temp);
		temp = new Unit("가위바위보진경", 1, 80, 7, 3, 0);
		guildList.add(temp);
		temp = new Unit("예지렁이", 1, 50, 3, 1, 0);
		guildList.add(temp);
		temp = new Unit("월세전세린", 1, 70, 5, 2, 0);
		guildList.add(temp);
		temp = new Unit("나무늘보석", 1, 200, 4, 8, 0);
		guildList.add(temp);
		temp = new Unit("지은도끼금도끼", 1, 120, 11, 7, 0);
		guildList.add(temp);
		for (int i = 0; i < 4; i++) {
			guildList.get(i).party = true;
		}
		partyList = new Unit[PARTY_SIZE];
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).party == true) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}
	}
	
	public void addGuildList(Unit unit) {
		guildList.add(unit);
	}
	
	public ArrayList<Unit> getGuildList() {
		ArrayList<Unit> reqObjs = new ArrayList<Unit>();
		for(int i = 0; i < guildList.size(); i ++) {
			Unit temp = guildList.get(i);
			String name = temp.name;
			int level = temp.level;
			int hp = temp.hp;
			int maxHp = temp.maxHp;
			int att = temp.att;
			int def = temp.def;
			int exp = temp.exp;
			boolean party = temp.party;
			Item weapon = temp.weapon;
			Item armor = temp.armor;
			Item ring = temp.ring;
			Item hat = temp.hat;
			Item shoes = temp.shoes;
			
			Unit reqObj = new Unit(name, level, maxHp, att, def, exp, party);
			reqObj.hp = hp;
			reqObj.setItem(weapon, armor, ring, hat, shoes);
			reqObjs.add(reqObj);
		}
		
		return reqObjs;
	}
	
	public int getGuildListSize() {
		return this.guildList.size();
	}
	
	public void setGuildList(ArrayList<Unit> guildList) {
		this.guildList = guildList;
	}

	public Unit[] getPartyList() {
		return partyList;
	}

	public void setPartyList(Unit[] partyList) {
		this.partyList = partyList;
	}

	public int getPARTY_SIZE() {
		return PARTY_SIZE;
	}
	
	public Unit getGuildUnit(int num) {
		return guildList.get(num);
	}
	
	public void printAllUnitStaus() {
		System.out.println("======================================");
		System.out.println("[골드 : " + Player.getMoney() + "]");
		System.out.println("============= [길드원] =================");
		for (int i = 0; i < guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + guildList.get(i).name + "]");
			System.out.print(" [레벨 : " + guildList.get(i).level + "]");
			System.out.print(" [체력 : " + guildList.get(i).hp);
			System.out.println(" / " + guildList.get(i).maxHp + "]");
			System.out.print("[공격력 : " + guildList.get(i).att + "]");
			System.out.print(" [방어력 : " + guildList.get(i).def + "]");
			System.out.printf(" [파티중 : %s ]", guildList.get(i).party? "O" : "X");
			System.out.println("");
		}
		System.out.println("=================================");
	}

	public void printUnitStaus(int num) {
		guildList.get(num).printStatus();
	}

	public void printUnitItem(int num) {
		guildList.get(num).printEquitedItem();
	}

	public void buyUnit() {
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

		guildList.add(temp);
		int money = Player.getMoney() - 5000;
		Player.setMoney(money);
	}

	public void removeUnit() {
		printAllUnitStaus();
		System.out.println("삭제할 번호를 입력하세요 ");
		int sel = MainGame.scan.nextInt();
		if (guildList.get(sel - 1).party) {
			System.out.println("파티중인 멤버는 삭제할수 없습니다.");
		} else {
			System.out.println("=================================");
			System.out.print("[이름 : " + guildList.get(sel - 1).name + "]");
			System.out.println("길드원을 삭제합니다.");
			System.out.println("=================================");
			guildList.remove(sel - 1);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void printParty() {
		System.out.println("================ [파티원] ===============");
		for (int i = 0; i < PARTY_SIZE; i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + partyList[i].name + "]");
			System.out.print(" [레벨 : " + partyList[i].level + "]");
			System.out.print(" [체력 : " + partyList[i].hp);
			System.out.println(" / " + partyList[i].maxHp + "]");
			System.out.print("[공격력 : " + partyList[i].att + "]");
			System.out.print(" [방어력 : " + partyList[i].def + "]");
			System.out.println(" [파티중 : " + guildList.get(i).party + "]");
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

		partyList[partyNum - 1].party = false;
		guildList.get(guildNum - 1).party = true;

		System.out.println("====================================");
		System.out.print("[이름 : " + partyList[partyNum - 1].name + "]");
		System.out.print("에서 ");
		System.out.print("[이름 : " + guildList.get(guildNum - 1).name + "]");
		System.out.println("으로 교체 합니다. ");
		System.out.println("====================================");

		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).party) {
				partyList[n] = guildList.get(i);
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
			System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]\n" + "[4.파티원교체] [5.정렬]  [0.뒤로가기]");
			int sel = MainGame.scan.nextInt();
			if (sel == 1) {
				printAllUnitStaus();
			} else if (sel == 2) {
				buyUnit();
			} else if (sel == 3) {
				removeUnit();
			} else if (sel == 4) {
				partyChange();
			} else if (sel == 0) {
				break;
			}
		}
	}

}