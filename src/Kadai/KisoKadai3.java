package Kadai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KisoKadai3 {

	public static void main(String[] args) {

		for (;;) {
			System.out.println("現在参照しているフォルダはこちら。");
			System.out.println("デフォルトはCドライブ内を参照します。");
			File dirlook = new File("c:\\");

			dirLook(dirlook);

			System.out.println("\nどの作業を行いますか？番号を入力してください。");
			System.out.println("[1]このフォルダを使用　[2]指定のフォルダに移動　[99]終了");

			int numint = numberTyping();
			if (numint == 1) {
				System.out.println("このフォルダを使用します");

				File usedir=askMkDir(dirlook);

				for (;;) {
					System.out.println("\n\nどの作業を行いますか？番号を入力してください。");
					boolean answer = newOrExisting(usedir);// 新規もしくは既存ファイルを作成し、作業を行った場合、最初まで戻る。
					if (answer) {
						break;
					} else {
						continue;
					}
				}
				continue;

			} else if (numint == 2) {
				System.out.println("指定のフォルダに移動します。");

				dirWork();

				continue;

			} else if (numint == 99) {
				System.out.println("終了します。");
				break;
			} else {
				System.out.println("指定した数値を入力してください");
				continue;
			}
		}
		System.out.println("プログラムを終了します。");
	}

	//指定したディレクトリ内での作業
	private static void dirWork() {
		for (;;) {
			String placestr = finddir();// ディレクトリを検索
			File placedir = new File(placestr);
			if(dirLook(placedir)){
			}else{
				break;
			}
			System.out.println("\nどの作業を行いますか？番号を入力してください。");
			System.out.println("[1]このフォルダを使用　[2]再度フォルダを指定　[99]最初のメニューに戻る");

			int choice = threeChoice();
			if (choice == 1) {
				System.out.println("このフォルダを使用します。");

				File usedir=askMkDir(placedir);

				System.out.println("\nどの作業を行いますか？番号を入力してください。");

				boolean answer = newOrExisting(usedir);// 新規もしくは既存ファイルを作成し、作業を行った場合、最初まで戻る。
				if (answer) {
					break;
				} else {
					continue;
				}

			} else if (choice == 2) {
				System.out.println("再度フォルダの指定をしてください。");
				continue;
			} else if (choice == 99) {
				System.out.println("終了します。");
				break;
			}

		}
	}

	// ディレクトリの確認をするメソッド
	private static boolean dirLook(File f) {
		try{
		String path=f.getAbsolutePath();
		System.out.println("このフォルダは"+path);
		System.out.println("---------------------フォルダ内容---------------------");
		File[] filelist = f.listFiles();
		for (int i = 0; i < filelist.length; i++) {
			if (filelist[i].isFile()) {
				System.out.println("[ファイル]" + filelist[i].getName());
			} else if (filelist[i].isDirectory()) {
				System.out.println("[フォルダ]" + filelist[i].getName());
			}
		}
		System.out.println("------------------フォルダ内容ここまで---------------------");
		return true;
		}catch(NullPointerException e){
			System.out.println("フォルダが見つかりません。再度指定してください。");
			return false;
		}
	}

	// ディレクトリ指定の入力仕様に適しているか確認するメソッド「c:\\
	private static String finddir() {
		for (;;) {
			System.out.println("移動先のフォルダを指定してください");
			System.out.println("入力例：　c:\\\\フォルダ名\\\\フォルダ名");
			String str = charKeyTyping();
			String regex = "^c:\\\\";
			String regex2 = "^C:\\\\";
			Pattern p = Pattern.compile(regex);
			Pattern p2 = Pattern.compile(regex2);
			Matcher m = p.matcher(str);
			Matcher m2 = p2.matcher(str);
			if (m.find() || m2.find()) {
				System.out.println(str + "を探します。");
				return str;
			} else {
				System.out.println("入力フォーマットに合いません。再度入力してください。");
				continue;
			}
		}
	}

	// ファイル指定の入力仕様に適しているか確認するメソッド「.txt」
	private static String checkTxt() {
		for (;;) {
			System.out.println("使用するファイル名を入力してください。");
			System.out.println("入力例：　sample.txt");
			String str = charKeyTyping();
			String regex = ".txt$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(str);
			if (m.find()) {
				System.out.println(str + "を確認します。");
				return str;
			} else {
				System.out.println("入力フォーマットに合いません。再度入力してください。");
				continue;
			}
		}
	}

	// 文字入力用メソッド（return str）
	public static String charKeyTyping() {
		for (;;) {
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

	// 入力を数字でのみ受け付けるメソッド(return numint)
	public static int numberTyping() {
		while (true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String numstr = br.readLine();
				int numint = Integer.parseInt(numstr);
				return numint;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("数字を入れてください。");
				continue;
			}
		}
	}

	// 2択をチェックするメソッド
	private static int twoChoice() {
		for (;;) {
			System.out.println("入力してください。");
			int numint = numberTyping();
			if (numint == 1 || numint == 2) {
				return numint;
			} else {
				System.out.println("適さない入力内容です。");
				continue;
			}
		}
	}

	// 3択をチェックするメソッド
	private static int threeChoice() {
		for (;;) {
			System.out.println("入力してください。");
			int numint = numberTyping();
			if (numint == 1 || numint == 2 || numint == 99) {
				return numint;
			} else {
				System.out.println("適さない入力内容です。");
				continue;
			}
		}
	}

	// 新規作成か既存ファイルを編集か
	private static boolean newOrExisting(File f) {
		for(;;){
		System.out.println("このフォルダの内容はこちら↓です。");
		dirLook(f);

		System.out.println("[1]ここに新規ファイルを作成　[2]既存ファイルを編集　[99]再度フォルダの指定");
		int choice = threeChoice();

		if (choice == 1) {
			System.out.println("新規ファイルを作成");
			if(newFile(f)){
				return true;
			}else{
				continue;
			}
		} else if (choice == 2) {
			System.out.println("既存のファイルを編集");
			choiceFile(f);
			return true;
		} else if (choice == 99) {
			System.out.println("再度フォルダを指定");
			return false;
		}
		return false;
		}
	}

	// 既存ファイルを選択するメソッド（retrun File型 該当ファイルのpath）
	private static boolean choiceFile(File f) {
		for (;;) {
			String filename = checkTxt();
			File usefile = new File(f + "\\\\" + filename);
			if (usefile.exists()) {
				System.out.println("使用するファイルを決定しました。");
				System.out.println(usefile + "に書き込みます。");

				fileLook(usefile);
				System.out.println("このファイルには追記・上書きのどちらを行いますか？");
				System.out.println("[1]追記　[2]上書き");
				boolean truefalse = trueFalse();
				System.out.println("入力可能です。入力してください。");
				String str = charKeyTyping();
				fileWrite(usefile, str, truefalse);
				return true;

			} else {
				System.out.println("ファイル名を間違えているかもしれません。新規ファイルを作るか、再度選択をしてください");
				return false;
			}
		}
	}

	// 新規ディレクトリを作成するメソッド（retrun File型 該当ファイルのpath）
	private static File newDir(File f) {
		for (;;) {
			String dirname = charKeyTyping();
			File usefile = new File(f + "\\\\" + dirname);

			if (usefile.mkdir()) {
				System.out.println(usefile + "は生成されました");
				return usefile;
			} else {
				System.out.println("フォルダの生成に失敗しました。");
				System.out.println("フォルダが既に存在するか、作成ができない場所である可能性があります。");
				askMkDir(f);
			}

		}
	}

	// 新規ファイルを作成するメソッド（retrun File型 該当ファイルのpath）
	private static boolean newFile(File f) {
		for (;;) {
			String filename = checkTxt();
			File usefile = new File(f + "\\\\" + filename);
			try {
				if (usefile.createNewFile()) {
					System.out.println(usefile + "は生成されました");
					System.out.println(usefile+"に入力可能です。入力してください。");
					String str = charKeyTyping();
					fileWrite(usefile, str, false);
					return true;
				} else {
					System.out.println("ファイルの生成に失敗しました。");
					System.out.println("ファイルが既に存在するか、ファイルの作成ができない場所である可能性があります。");
					System.out.println("再度ファイル名を入力してみてください。");
					return false;
				}
			} catch (IOException e) {
				System.out.println(e);
				continue;
			}
		}
	}

	// ファイルへの書き込みメソッド
	private static void fileWrite(File writefile, String str, boolean truefalse) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(writefile, truefalse)));
			pw.println(str);
			System.out.println("この入力内容を保存しています。");
			pw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// 追記・上書きの指定
	private static boolean trueFalse() {
		int choise = twoChoice();
		if (choise == 1) {
			System.out.println("追記します。");
			return true;
		} else {
			System.out.println("上書きします。");
			return false;
		}

	}

	// ファイルの内容を表示するメソッド
	private static void fileLook(File f) {
		try {
			FileReader filereader = new FileReader(f);
			String name = f.getName();
			System.out.println("\n\n-----------------------------------"+name + "を表示しています");
			int ch;
			while ((ch = filereader.read()) != -1) {
				System.out.print((char) ch);
			}
			System.out.println("-----------------------------------内容は以上です。\n\n");
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	//ディレクトリの作成を確認するメソッド
	private static File askMkDir(File f) {
		System.out.println("ここにフォルダを作りますか？");
		System.out.println("[1]作成する　[2]作成しない");
		int choise=twoChoice();
		if(choise==1){
			System.out.println("ここに新規フォルダを作ります。");
			System.out.println("作成するフォルダ名を入力してください");
			return newDir(f);
		}else{
			return f;
		}
	}
}
