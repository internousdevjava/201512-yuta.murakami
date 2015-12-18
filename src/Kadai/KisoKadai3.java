package Kadai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class KisoKadai3 {

	public static void main(String[] args) {
		System.out.println("開始します");
		System.out.println("数字を入力して選んでください");
		System.out.println("新規ファイル←場所指定できません。既存のファイルに追記もしくは上書き←実装できていません。");
		System.out.println("新規のファイル作成[1],既存のファイルに追記もしくは上書き[2]");

		int choise = 0;
		int choise1 = numkeytyping(choise);

		switch (choise1) {
		case 1:
			System.out.println("新規ファイルを作ります");
			makeFile();
			break;
		case 2:
			System.out.println("既存のファイルを編集します");
//			existingFile();
			break;
		}

		// File file = new File(choosed);

	}

	/*
	 * private static boolean checkBeforeReadFile(File file) { if
	 * (file.exists()) { if (file.isFile() && file.canRead()) { return true; } }
	 * return false; } private static boolean closefile() {
	 *
	 *
	 * } private static String choosedFile() {
	 *
	 * }
	 */
	public static String charkeytyping() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			System.out.println(e);
			;
		}
		System.out.println(str);
		return str;
	}

	public static int numkeytyping(int choise) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String charnum = null;
		try {
			charnum = br.readLine();
		} catch (IOException e) {
			System.out.println(e);
		}
		int num = Integer.parseInt(charnum);
		System.out.println(num);
		return num;
	}

	public static void makeFile() {

		// 新規ファイルに名づけ。
		System.out.println("作成するファイル名を英数字で入力してください。");
		System.out.println("\".txt\"は自動で追加されます。");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			System.out.println(e);
		}
		File newfile = new File(str + ".txt");

		// 新規ファイル作成。
		try {
			if (newfile.createNewFile()) {
				System.out.println("ファイルの作成に成功しました");
			} else {
				System.out.println("ファイルの作成に失敗しました");
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		System.out.println(newfile + "が生成されました。このまま書き込めます");

		// 新規ファイルに一行書き込み
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String str2 = null;
		try {
			str2 = br2.readLine();
		} catch (IOException e) {
			System.out.println(e);
			;
		}
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(newfile)));
		} catch (IOException e) {
			System.out.println(e);
			;
		}
		pw.println(str2);
		System.out.println("とりあえず終了します。");
		pw.close();
	}

//	public static void existingFile() {
//		System.out.println("フォルダ位置を指定してください。");
//		System.out.println("入力例：" + "C:\\\\eclipse\\\\pleiades\\\\workspace\\\\HelloWorld");
//
//		// フォルダ位置をパスで入力
//		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
//		String str3 = null;
//		try {
//			str3 = br3.readLine();
//		} catch (IOException e) {
//			System.out.println(e);
//		}
//
//		// 指定されたフォルダ内容の確認
//		File checkdir = new File(str3);
//		if (checkReadFile(checkdir)) {
//			String filelist[] = checkdir.list();
//			for (int j = 0; j < filelist.length; j++) {
//				System.out.println(filelist[j]);
//			}
//			System.out.println("使用したいファイルの名前を入れてください");
//			System.out.println("\".txt\"は自動で追加されます。");
//		}
//
//		// 使用したいファイルをファイル名で指定
//		BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
//		String str4 = null;
//		try {
//			str4 = br4.readLine();
//		} catch (IOException e) {
//			System.out.println(e);
//		}
//		try {
//			File existfilewrite = new File(str3 + "\\\\" + str4 + ".txt");
//			if (checkBeforeReadFile(existfilewrite)) {
//
//				System.out.println(existfilewrite + "に上書きします");
//
//				// 既存ファイルに上書き
//				BufferedReader br5 = new BufferedReader(new InputStreamReader(System.in));
//				String str5 = null;
//				try {
//					str5 = br5.readLine();
//				} catch (IOException e) {
//					System.out.println(e);
//				}
//				PrintWriter pw = null;
//				try {
//					pw = new PrintWriter(new BufferedWriter(new FileWriter(existfilewrite)));
//				} catch (IOException e) {
//					System.out.println(e);
//					;
//				}
//				pw.println(str5);
//				pw.close();
//			}
//	}
//
//	private static boolean checkReadFile(File checkdir) {
//		if (checkdir.exists()) {
//			if (checkdir.isFile() || checkdir.isDirectory()) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	private static boolean checkBeforeReadFile(File existfilewrite) {
//		if (existfilewrite.exists()) {
//			if (existfilewrite.isFile() && existfilewrite.canWrite()) {
//				return true;
//			}
//		}
//		return false;
//	}

}

