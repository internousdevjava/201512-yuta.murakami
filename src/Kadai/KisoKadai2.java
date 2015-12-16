package Kadai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KisoKadai2 {
	public static void main(String[] args) {
		int answer = new java.util.Random().nextInt(100);
		for (;;) {
			System.out.println("0から100までの整数を入力してください。");
			// 以前のやり方→int num=new java.util.Scanner(System.in).nextInt();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String num = null;
			try {
				num = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			int num1 = Integer.parseInt(num);
			// System.out.println(ans);
			// checkStringNumberを使えるようにしたい

			if (num1 == answer) {
				System.out.println("正解！答えは" + answer + "です！");
				break;
			} else if (num1 < answer - 10) {
				System.out.println("小さい！");
			} else if (num1 < answer && num1 > answer - 10) {
				System.out.println("ちょっと小さい……。");
			} else if (num1 > answer + 10) {
				System.out.println("大きい！");
			} else if (num1 > answer && num1 < answer + 10) {
				System.out.println("ちょっと大きい……。");
			}
		}
	}
}
