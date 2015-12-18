package Kadai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KisoKadai3 {

	// 全体図
	public static void main(String[] args) {
		System.out.println("開始します");

		// 新規ファイルか既存ファイルかの確認
		System.out.println("数字を入力して選んでください");
		System.out.println("[1]新規のファイル作成,[2]既存のファイルに上書き");

		for (;;) {
			for (;;) {
				int x = choise1or2();

				if (x == 1) {
					System.out.println("新規ファイルを作成します。");
					makeFile();
					break;
				} else if (x == 2) {
					System.out.println("既存のファイルを編集します。");
					existingFile();
					break;
				} else {
					System.out.println("指定した数字を入れてください");
				}
			}

			System.out.println("継続しますか？");
			System.out.println("[1]終了　[2]継続");
			int endor = choise1or2();

			if (endor == 1) {
				System.out.println("終了します。");
				break;
			} else if (endor == 2) {
				System.out.println("続けます。");
				System.out.println("続けられないので終わります。");
			} else {
				System.out.println("指定した数字を入れてください");
			}
		}

		// 新規ファイルの作成場所を表示

		System.out.println("終了しました。");
	}

	public boolean checkStringNumber(String number) {
		Pattern p = Pattern.compile("^[0-9]*$");
		Matcher m = p.matcher(number);

		return m.find();
	}

	// 文字入力のメソッド
	public static String charkeytyping() {
		for(;;){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			str = br.readLine();
			System.out.println(str);
			return str;
		} catch (IOException e) {
			System.out.println(e);
		}
		}

	}

	// ２択をさせるメソッド
	public static int choise1or2() {
		while (true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String num = br.readLine();
				int xnum = Integer.parseInt(num);
				if (xnum == 1) {
					return xnum;
				} else if (xnum == 2) {
					return xnum;
				} else {
					System.out.println("指定した数字を入れてください。");
					continue;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("数字を入れてください。");
				continue;
			}
		}
	}

	//新規ファイルを作るメソッド

	// 新規ファイル作成のメソッド
	public static void makeFile() {

		// 新規ファイルに名づけ。
//		System.out.println("c:\\\\User内に「KisoKadai3」フォルダを作成します。");
//		System.out.println("OKですか？");
//		System.out.println("[1]OK　[2]別途ファイル作成");
//		int ans=choise1or2();
//
//		File dir = new File(usedir(ans));


		File dir = new File(usedir2());

		System.out.println("作成するファイル名を英数字で入力してください。");
		System.out.println("\".txt\"は自動で追加されます。");

		String str = charkeytyping();

		File newfile = new File(dir + "\\\\" +str + ".txt");

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
		String str2 = charkeytyping();
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

	// 既存ファイル編集のメソッド

	//既存のファイルを編集するメソッド
	public static void existingFile() {
		System.out.println("フォルダ位置を指定してください。");
		System.out.println("入力例：" + "C:\\\\eclipse\\\\pleiades\\\\workspace\\\\HelloWorld");

		// フォルダ位置をパスで入力
		String dirstr = charkeytyping();

		// 指定されたフォルダ内容の確認
		File checkdir = new File(dirstr);
		if (checkReadFile(checkdir)) {
			String filelist[] = checkdir.list();
			for (int j = 0; j < filelist.length; j++) {
				System.out.println(filelist[j]);
			}
			System.out.println("使用したいファイルの名前を入れてください");
			System.out.println("\".txt\"は自動で追加されます。");
		}

		// 使用したいファイルをファイル名で指定
		String filestr = charkeytyping();
		File existfilewrite = new File(dirstr + "\\\\" + filestr + ".txt");
		if (checkBeforeReadFile(existfilewrite)) {

			System.out.println(existfilewrite + "に上書きします");

			// 既存ファイルに上書き
			String textstr = charkeytyping();

			PrintWriter pw = null;
			try {
				pw = new PrintWriter(new BufferedWriter(new FileWriter(existfilewrite)));
			} catch (IOException e) {
				System.out.println(e);
				;
			}
			pw.println(textstr);
			pw.close();
		}
	}

	// ディレクトリか、ファイルなのかを確認
	private static boolean checkReadFile(File checkdir) {
		if (checkdir.exists()) {
			if (checkdir.isFile() || checkdir.isDirectory()) {
				return true;
			}
		}
		return false;
	}

	// 書き込み可能なファイルなのか確認
	private static boolean checkBeforeReadFile(File existfilewrite) {
		if (existfilewrite.exists()) {
			if (existfilewrite.isFile() && existfilewrite.canWrite()) {
				return true;
			}
		}
		return false;
	}

	//フォルダの中がファイルなのか、ディレクトリなのか確認。
	public static void checkdir(String dirstr) {
		File directory = new File(dirstr);

		File[] filelist = directory.listFiles();
		for (int i = 0; i < filelist.length; i++) {
			if (filelist[i].isFile()) {
				System.out.println("[ファイル]"+filelist[i].getName());
			} else if (filelist[i].isDirectory()) {
				System.out.println("[フォルダ]"+filelist[i].getName());
			} else {
				System.out.println("[その他]"+filelist[i].getName());
			}
		}
	}

	//新規ディレクトリの作成をするメソッド
//	private static String usedir(int ans) {
//		if (ans==1) {
//			File kisokadai3 = new File("c:\\Users\\Kisokadai3");
//			if (kisokadai3.mkdir()) {
//				System.out.println("フォルダを作成しました。");
//			}else{
//				System.out.println("作成に失敗したか、すでにフォルダが存在しています。");
//			}
//			String defaultdir = "C:\\Users\\KisoKadai3";
//			return defaultdir;
//		}else{
//			System.out.println("フォルダ位置を指定してください。");
//			System.out.println("入力例：" + "C:\\\\eclipse\\\\pleiades\\\\workspace\\\\HelloWorld");
//			System.out.println("\\マークは2つ並べて入力してください。");
//
//			// フォルダ位置をパスで入力
//			String dirstr = charkeytyping();
//			File dir = new File(dirstr);
//			if (checkReadFile(dir)) {
//				String filelist[] = dir.list();
//				for (int j = 0; j < filelist.length; j++) {
//					System.out.println(filelist[j]);
//				}
//				System.out.println("この内容のフォルダにファイルを作成します。");
//				return dirstr;
//			}
//		}
//		return null;
//
//	}

	//取り急ぎのディレクトリ指定
	private static String usedir2() {
			System.out.println("フォルダ位置を指定してください。");
			System.out.println("入力例：" + "C:\\\\eclipse\\\\pleiades\\\\workspace\\\\HelloWorld");
			System.out.println("\\マークは2つ並べて入力してください。");

			// フォルダ位置をパスで入力
			String dirstr = charkeytyping();
			File dir = new File(dirstr);
			if (checkReadFile(dir)) {
				String filelist[] = dir.list();
				for (int j = 0; j < filelist.length; j++) {
					System.out.println(filelist[j]);
				}
				System.out.println("この内容のフォルダにファイルを作成します。");
			}
			return dirstr;
	}
}
