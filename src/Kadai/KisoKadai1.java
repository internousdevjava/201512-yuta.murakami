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
				xlimit(xnum);
				boolean xcheck = xlimit(xnum);
				if (xcheck) {
				} else {
					System.out.println("桁が大きすぎます。");
					continue;
				}
				calculate.setX(xnum);
				break;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("整数の数字を入れてね。");
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
				ylimit(ynum);
				boolean ycheck = ylimit(ynum);
				if (ycheck) {
				} else {
					System.out.println("桁が大きすぎます。");
					continue;
				}
				calculate.setY(ynum);
				break;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("整数の数字を入れてね。");
				continue;
			}
		}

		calculate.result();
		System.out.println("出来上がり。");

	}

	private static boolean xlimit(int xnum) {
		if (xnum <= 100) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean ylimit(int ynum) {
		if (ynum <= 100) {
			return true;
		} else {
			return false;
		}
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
