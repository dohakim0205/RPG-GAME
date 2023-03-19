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
		System.out.print(" [체력 : " + this.hp + isItemNullForPower(this.ring) + isGuildBuff("체력"));
		System.out.println(" / " + this.maxHp + isItemNullForPower(this.ring) + isGuildBuff("체력") + "]");
		System.out.print("[공격력 : " + this.att + isItemNullForPower(this.weapon) + isItemNullForPower(this.hat) + isGuildBuff("공격력") + "]");
		System.out.print(" [방어력 : " + this.def + isItemNullForPower(this.armor) + isItemNullForPower(this.shoes) + isGuildBuff("방어력") + "]");
		System.out.printf(" [파티중 : %s]\n", this.party ? "O" : "X");
	}

	private String isItemNullForPower(Item item) {
		String power = "";
		if (item != null) {
			power += " + " + item.getPower();
		}

		return power;
	}
	
	private String isGuildBuff(String kind) {
		RandomBuff buff = Player.guild.getGuildBuff();
		if(buff.isBuffStatus() && buff.getBuffName().equals(kind)) {
			return " + " + Player.guild.getGuildBuff().getPower() +"(길드 버프)";
		}
		
		else
			return "";
	}

	private String isItemNullForName(Item item) {
		String name = "없음";
		if (item != null) {
			name = item.getName();
		}

		return name;
	}

	public void printEquitedItem() {
		System.out.println("[무기 : " + isItemNullForName(this.weapon) + "]");
		System.out.println("[방어구 : " + isItemNullForName(this.armor) + "]");
		System.out.println("[반지 : " + isItemNullForName(this.ring) + "]");
		System.out.println("[모자 : " + isItemNullForName(this.hat) + "]");
		System.out.println("[신발 : " + isItemNullForName(this.shoes) + "]");
	}

	public void setEquip(Item item) {
		if (item.getKind() == Item.WEAPON) {
			setWeapon(item);
		}

		else if (item.getKind() == Item.ARMOR) {
			setArmor(item);
		}

		else if (item.getKind() == Item.RING) {
			setRing(item);
		}

		else if (item.getKind() == Item.HAT) {
			setHat(item);
		}

		else if (item.getKind() == Item.SHOES) {
			setShoes(item);
		}
	}
}