package h1java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator extends Validator {

	@Override
	public boolean check(String s) {
//		//diawali dengan + atau 0
//		char first = s.charAt(0);
//		if(first != '+' && first != '0') return false;
//		
//		//selanjutnya angka
//		for(int i = 0; i < s.length();i++){
//			char c = s.charAt(i);
//			if(c < '0' || c > '9') return false;
//		}
		
		Pattern p = Pattern.compile("[+0][0-9]+$");
		Matcher m = p.matcher(s);
		
		return m.find();
		
	}

}
