package Kadai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KisoKadai2 {
	public static void main(String[] args) {

		for (;;) {
			int answer1 = new java.util.Random().nextInt(99);
			int answer = answer1 + 1;
			while (true) {
				System.out.println("1から100までの整数を入力してください。");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String num = null;
				try {
					num = br.readLine();
					int numli = Integer.parseInt(num);
					numlimit(numli);
					boolean numcheck = numlimit(numli);
					if (numcheck) {
					} else {
						System.out.println("範囲外の数字です。");
						continue;
					}
					if (numli == answer) {
						System.out.println("正解！答えは" + answer + "です！");
						break;
					} else if (numli < answer - 10) {
						System.out.println("小さい！");
					} else if (numli < answer && numli > answer - 10) {
						System.out.println("ちょっと小さい……。");
					} else if (numli > answer + 10) {
						System.out.println("大きい！");
					} else if (numli > answer && numli < answer + 10) {
						System.out.println("ちょっと大きい……。");
					}
				} catch (IOException e) {
					System.out.println(e);
					System.out.println("もう一度入力してみてください。");
					continue;
				} catch (NumberFormatException e) {
					System.out.println("整数の数字を入れてね。");
					continue;
				}
			}

		}
	}

	private static boolean numlimit(int numli) {
		if (numli >= 1 && numli <= 100) {
			return true;
		} else {
			return false;
		}
	}
}
