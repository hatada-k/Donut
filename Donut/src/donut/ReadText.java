package donut;

import java.util.Scanner;

public class ReadText {

	public static char[][] Text(Scanner file){
		int H = file.nextInt();
       int W = file.nextInt();
		if (H == 0 && W == 0) {
			file.close();
			return null;
		}

       char[][] table = new char[H][];
       for (int i = 0; i < table.length; i++) {
    	   // 与えられるテーブルをしまっておく
    	   table[i] = file.next().toCharArray();
       }
       return table;
	}
}
