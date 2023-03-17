package RPG_GAME;

public class Item {
	public static final int WEAPON = 1;
	public static final int ARMOR = 2;
	public static final int RING = 3;
	public static final int HAT = 4;
	public static final int SHOES = 5;
	private int kind;
	private String name;
	private int power;
	private int price;

	public Item(int k, String n, int p, int pr) {
		this.kind = k;
		this.name = n;
		this.power = p;
		this.price = pr;
	}

	public int getKind() {
		return this.kind;
	}

	public String getName() {
		return this.name;
	}

	public int getPower() {
		return this.power;
	}

	public int getPrice() {
		return this.price;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}