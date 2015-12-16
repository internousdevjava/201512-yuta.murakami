package Kadai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KisoKadai1 {

	public static void main(String args[]) {

		Calculate calculate = new Calculate();
		Instruction instruction = new Instruction();

		while (true) {
			// x軸の入力
			instruction.setZ("X軸（横軸）");
			instruction.Shiteibun();
			try {
				BufferedReader xbr = new BufferedReader(new InputStreamReader(System.in));
				String xnumb = xbr.readLine();
				int xnum = Integer.parseInt(xnumb);
				calculate.setY(xnum);
				break;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("数字を入れてね。");
				continue;
			}
		}

		while (true) {
			// y軸の入力
			instruction.setZ("Y軸（縦軸）");
			instruction.Shiteibun();
			try {
				BufferedReader ybr = new BufferedReader(new InputStreamReader(System.in));
				String ynumb = ybr.readLine();
				int ynum = Integer.parseInt(ynumb);
				calculate.setY(ynum);
				break;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("数字を入れてね。");
				continue;
			}
		}

		calculate.result();

	}
}

class Calculate {
	int yjiku, xjiku;

	void setY(int newyjiku) {
		yjiku = newyjiku;
	}

	void setX(int newxjiku) {
		xjiku = newxjiku;
	}

	void result() {
		for (int y = 1; y <= yjiku; y++) {
			for (int x = 1; x <= xjiku; x++) {
				System.out.printf(" %5d", x * y);
			}
			System.out.println();
		}
	}
}

class Instruction {
	String Z;

	void setZ(String newZ) {
		Z = newZ;
	}

	void Shiteibun() {
		System.out.println(Z + "の数を数字で指定してください");
		System.out.println("範囲は1～100です。");
	}

}
