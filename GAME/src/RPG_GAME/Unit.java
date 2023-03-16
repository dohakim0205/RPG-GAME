package RPG_GAME;

public class Unit {
	String name;
	int level;
	int hp;
	int maxHp;
	int att;
	int def;
	int exp;
	boolean party;
	Item weapon;
	Item armor;
	Item ring;
	Item hat;
	Item shoes;

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

	public void setItem(Item w, Item a, Item r, Item h, Item s) {
		this.weapon = w;
		this.armor = a;
		this.ring = r;
		this.hat = h;
		this.shoes = s;
	}

	public void printStatus() {
		System.out.print("[이름 : " + this.name + "]");
		System.out.print(" [레벨 : " + this.level + "]");
		if (this.ring != null) {
			System.out.print(" [체력 : " + this.hp + " + " + this.ring.power);
		} else {
			System.out.print(" [체력 : " + this.hp);
		}
		if (this.ring != null) {
			System.out.println(" / " + this.maxHp + " + " + this.ring.power + "]");
		} else {
			System.out.println(" / " + this.maxHp + "]");
		}
		if (this.weapon != null) {
			System.out.print("[공격력 : " + this.att + " + " + this.weapon.power + "]");
		} else {
			System.out.print("[공격력 : " + this.att + "]");
		}
		if (this.armor != null) {
			System.out.print(" [방어력 : " + this.def + " + " + this.armor.power + "]");
		} else {
			System.out.print(" [방어력 : " + this.def + "]");
		}
		System.out.println(" [파티중 : " + this.party + "]");
	}

	public void printEquitedItem() {
		if (this.weapon == null) {
			System.out.println("[무기 : 없음 ]");
		} else {
			System.out.println("[무기 : " + this.weapon.name + "]");
		}
		if (this.armor == null) {
			System.out.println("[방어구 : 없음 ]");
		} else {
			System.out.println("[방어구 : " + this.armor.name + "]");
		}
		if (this.ring == null) {
			System.out.println("[반지 : 없음 ]");
		} else {
			System.out.println("[반지 : " + this.ring.name + "]");
		}
		if (this.hat == null) {
			System.out.println("[모자 : 없음 ]");
		} else {
			System.out.println("[모자 : " + this.hat.name + "]");
		}
		if (this.shoes == null) {
			System.out.println("[신발 : 없음 ]");
		} else {
			System.out.println("[신발 : " + this.shoes.name + "]");
		}
		
	}
}