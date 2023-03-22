package RPG_GAME;

import java.util.Random;

public class Sauna {
	private String[] saunaName = { "황토방", "수정방", "얼음방" };
	private int[] price = { 1000, 2000, 5000 };
	private Random ran;

	public void payfee() {
		System.out.println("안녕하세요 여기는 사우나~♪");
		System.out.println("방을 골라주세요");
		System.out.println("1) 황토가 옷에 묻어요 황토방\n2) 내가 또 너한테 소금방\n3) 엘사성 뺏어서 지은 얼음방\n0) 안 해요");
		System.out.printf("%s : %d원\t%s : %d원\t%s : %d원\n", this.saunaName[0], this.price[0], this.saunaName[1],
				this.price[1], this.saunaName[2], this.price[2]);
		int sel = MainGame.inputNumber();
		if (sel == 1) {
			System.out.println("*비용은 1000원입니다*");
			Player.setMoney(Player.getMoney() - this.price[0]);
			System.out.printf("[남은 골드 : %d원]\n", Player.getMoney());
			enterZzimzilbang("황토방");
		} else if (sel == 2) {
			System.out.println("*비용은 2000원입니다*");
			Player.setMoney(Player.getMoney() - this.price[1]);
			System.out.printf("[남은 골드 : %d원]\n", Player.getMoney());
			enterZzimzilbang("소금방");
		} else if (sel == 3) {
			System.out.println("*비용은 5000원입니다*");
			Player.setMoney(Player.getMoney() - this.price[2]);
			System.out.printf("[남은 골드 : %d원]\n", Player.getMoney());
			enterZzimzilbang("얼음방");
		} else
			return;
	}

	private void enterZzimzilbang(String name) {
		System.out.println("===== " + name + " 입장 ====");

		timeDelay(1000);
		if (name == "황토방")
			System.out.println("황토구이 되는 중...");

		else if (name == "소금방")
			System.out.println("소금에 짜지는 중...");

		else if (name == "얼음방")
			System.out.println("얼음에 혀 대는 중...");

		int time = 10;
		timeDelay(1000);
		while (time > 0) {
			System.out.printf("\n남은 시간 %d초\n\n", time);
			cuteDog();
			timeDelay(1000);
			time--;
		}
		System.out.println("끝났습니다.");
	}

	private void cuteDog() {
		this.ran = new Random();
		String[] music = { "♪", "♬", "♩" };
		int[] ranIdx = new int[6];
		String[] ranPrint = new String[8];
		for (int i = 0; i < 8; i++) {
			ranPrint[i] = " ";
			for (int j = 0; j < 6; j++) {
				ranIdx[j] = ran.nextInt(50);
				ranPrint[i] += ranIdx[j] >= 3 ? " " : music[ranIdx[j]];
			}
		}

		System.out.println("\t신나요...!\t");
		System.out.println("\t" + ranPrint[0] + ranPrint[7]);
		System.out.print(ranPrint[4] + "\t|\\_/|\t" + ranPrint[1] + "\n");
		System.out.print(ranPrint[5] + "\t|o o|\t" + ranPrint[2] + "\n");
		System.out.print(ranPrint[6] + "\t >^< \t" + ranPrint[3] + "\n");
	}

	private void timeDelay(int num) {
		try {
			Thread.sleep(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
