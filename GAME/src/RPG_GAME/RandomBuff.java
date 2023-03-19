package RPG_GAME;

import java.util.Random;

public class RandomBuff {
	private Random random;
	private boolean buffStatus;
	private int buffPower;
	private String buffName;
	private String[] buffList = { "체력", "공격력", "방어력" };

	public RandomBuff() {
		this.random = new Random();
	}

	public void getGuildBuff() {
		this.buffName = buffList[this.random.nextInt(3)];
		this.buffPower = random.nextInt(5) + 1;
		if (this.buffName == "체력") {
			this.buffPower *= 10;
		}

		this.buffStatus = true;
		printGuildBuff();
	}

	public int getPower() {
		return buffPower;
	}

	public void setPower(int power) {
		this.buffPower = power;
	}

	public String getBuffName() {
		return buffName;
	}

	public void setBuffName(String buffName) {
		this.buffName = buffName;
	}

	public boolean isBuffStatus() {
		return buffStatus;
	}

	public void setBuffStatus(boolean isbuff) {
		this.buffStatus = isbuff;
	}

	public void printGuildBuff() {
		System.out.println("[길드 버프 : " + this.buffName + " +" + this.buffPower + "]");
		System.out.println("===================================");
		for (int i = 0; i < Player.guild.getGuildListSize(); i++) {
			Player.guild.getGuildUnit(i).printStatus();
		}
	}
}
