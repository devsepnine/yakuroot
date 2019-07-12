package member.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SamplePw {
	
		public static String random(int len) {
			Random r = new Random();
			
			List<String> capital = new ArrayList<>();
			for (char i = 'A'; i <= 'Z'; i++) {
				capital.add(String.valueOf(i));
			}
			
			List<String> small = new ArrayList<>();
			for (char i = 'a'; i <= 'z'; i++) {
				small.add(String.valueOf(i));
			}
			
			List<String> num = new ArrayList<>();
			for (int i = 0; i <= 9; i++) {
				num.add(String.valueOf(i));
			}
			
		
			List<String> pw = new ArrayList<>();
			pw.addAll(capital);
			pw.addAll(small);
			pw.addAll(num);
			
			String npw = "";
			
			for (int i = 0; i < len; i++) {
				int index = r.nextInt(pw.size());
				npw = npw + pw.get(index);
			}
		
			return npw;
		}
	}