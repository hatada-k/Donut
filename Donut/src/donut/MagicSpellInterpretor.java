package donut;

import java.util.ArrayList;

public class MagicSpellInterpretor {
	public static String MagicSpell(char list[][]){
		 String answer = "";
		 int[] dir = { -1, 0, 1 };

        @SuppressWarnings("unchecked")
        ArrayList<String>[][] parts = new ArrayList[26][201];
        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < parts[i].length; j++) {
                parts[i][j] = new ArrayList<String>();
            }
        }

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                for (int k = 0; k < dir.length; k++) {
                    for (int l = 0; l < dir.length; l++) {
                        if (dir[k] == dir[l] && dir[k] == 0) {
                            continue;
                        }

                        int nowi = i;
                        int nowj = j;
                        StringBuilder sb = new StringBuilder();
                        sb.append(list[nowi][nowj]);

                        while (true) {
                            nowi = (nowi + dir[k] + list.length) % list.length;
                            nowj = (nowj + dir[l] + list[0].length) % list[0].length;

                            if (nowi == i && nowj == j) {
                                break;
                            }

                            sb.append(list[nowi][nowj]);

                            char init = (char) (list[i][j] - 'A');
                            String seq = sb.toString();
                            int length = sb.length();

                            if (parts[init][length].contains(seq)) {
                                if (length > answer.length()) {
                                    answer = seq;
                                } else if (length == answer.length()) {
                                    if (answer.compareTo(seq) > 0) {
                                        answer = seq;
                                    }
                                }
                            } else if (length >= 2) {
                                parts[init][length].add(seq);
                            }
                        }
                    }
                }

            }
        }
        return answer;
	}
}
