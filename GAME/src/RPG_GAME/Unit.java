package RPG_GAME;

public class Unit {
	private String name;
	private int level;
	private int hp;
	private int maxHp;
	private int att;
	private int def;
	private int exp;
	private boolean party;
	private Item weapon;
	private Item armor;
	private Item ring;
	private Item hat;
	private Item shoes;

	public Unit(String n, int l, int h, int a, int d, int e) {
		this.name = n;
		this.level = l;
		this.maxHp = h;
		this.att = a;
		this.def = d;
		this.exp = e;
		this.hp = maxHp;
		this.party = false;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
		this.hat = null;
		this.shoes = null;
	}

	public Unit(String n, int l, int h, int a, int d, int e, boolean p) {
		this.name = n;
		this.level = l;
		this.maxHp = h;
		this.att = a;
		this.def = d;
		this.exp = e;
		this.hp = maxHp;
		this.party = p;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public int getHp() {
		return hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getAtt() {
		return att;
	}

	public int getDef() {
		return def;
	}

	public int getExp() {
		return exp;
	}

	public boolean isParty() {
		return party;
	}

	public Item getWeapon() {
		return weapon;
	}

	public Item getArmor() {
		return armor;
	}

	public Item getRing() {
		return ring;
	}

	public Item getHat() {
		return hat;
	}

	public Item getShoes() {
		return shoes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setParty(boolean party) {
		this.party = party;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}

	public void setHat(Item hat) {
		this.hat = hat;
	}

	public void setShoes(Item shoes) {
		this.shoes = shoes;
	}
	
	public void setEquipByIndex(int index) {
		
	}

	public void setItem(Item w, Item a, Item r, Item h, Item s) {
		this.weapon = w;
		this.armor = a;
		this.ring = r;
		this.hat = h;
		this.shoes = s;
	}

	public void printStatus() {
		System.out.print("[이름 : " + this.getName() + "]");
		System.out.print(" [레벨 : " + this.level + "]");
		if (this.ring != null) {
			System.out.print(" [체력 : " + this.hp + " + " + this.ring.getPower());
		} else {
			System.out.print(" [체력 : " + this.hp);
		}
		if (this.ring != null) {
			System.out.println(" / " + this.maxHp + " + " + this.ring.getPower() + "]");
		} else {
			System.out.println(" / " + this.maxHp + "]");
		}
		if (this.weapon != null) {
			System.out.print("[공격력 : " + this.att + " + " + this.weapon.getPower() + "]");
		} else {
			System.out.print("[공격력 : " + this.att + "]");
		}
		if (this.armor != null) {
			System.out.print(" [방어력 : " + this.def + " + " + this.armor.getPower() + "]");
		} else {
			System.out.print(" [방어력 : " + this.def + "]");
		}
		if (this.hat != null) {
			System.out.print("[공격력 : " + this.att + " + " + this.hat.getPower() + "]");
		} else {
			System.out.print("[공격력 : " + this.att + "]");
		}
		if (this.shoes != null) {
			System.out.print(" [방어력 : " + this.def + " + " + this.shoes.getPower() + "]");
		} else {
			System.out.print(" [방어력 : " + this.def + "]");
		}
		System.out.printf(" [파티중 : %s]", this.party ? "O" : "X");
	}

	public void printEquitedItem() {
		if (this.weapon == null) {
			System.out.println("[무기 : 없음 ]");
		} else {
			System.out.println("[무기 : " + this.weapon.getName() + "]");
		}
		if (this.armor == null) {
			System.out.println("[방어구 : 없음 ]");
		} else {
			System.out.println("[방어구 : " + this.armor.getName() + "]");
		}
		if (this.ring == null) {
			System.out.println("[반지 : 없음 ]");
		} else {
			System.out.println("[반지 : " + this.ring.getName() + "]");
		}
		if (this.hat == null) {
			System.out.println("[모자 : 없음 ]");
		} else {
			System.out.println("[모자 : " + this.hat.getName() + "]");
		}
		if (this.shoes == null) {
			System.out.println("[신발 : 없음 ]");
		} else {
			System.out.println("[신발 : " + this.shoes.getName() + "]");
		}

	}
}