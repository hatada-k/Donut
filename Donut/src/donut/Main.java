package donut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
 class Main {
	public static void main(String[] args) throws IOException {
		Scanner scan = null;
		try{
			File file = new File("src/donut/B.in");
			scan = new Scanner(file);
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
		while (true) {
			char[][] table = ReadText.Text(scan);
			if(table == null){
				break;
			}
           String answer = MagicSpellInterpretor.MagicSpell(table);
           if(answer == ""){
        	   answer = "0";
           }
           System.out.println(answer);

		}

	}
}
