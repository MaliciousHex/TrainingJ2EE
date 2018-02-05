package h1java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator extends Validator {

	@Override
	public boolean check(String s) {
//			// harus ada@
//			if(s.indexOf("@") < 0) return false;
//			// @ cuma boleh ada 1
//			if(s.indexOf("@") != s.lastIndexOf("@"))return false;
//			// ada . setelah @
//			if(s.indexOf("@") > s.lastIndexOf(".")) return false;
//			// @ dan . tidak boleh di depan
//			char first = s.charAt(0);
//			if(first == '@') return false;
//			if(first == '.') return false;
//			// @ dan . tidak boleh di belakang
//			char last = s.charAt(s.length() -1);
//			if(last == '@') return false;
//			if(last == '.') return false;
			
			Pattern p = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
			// + infinite $ akhir dari regex
			
			Matcher m = p.matcher(s);
			return m.find();
	
	}

}
