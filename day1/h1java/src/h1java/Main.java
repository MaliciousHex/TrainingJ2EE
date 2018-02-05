package h1java;

import test.*;

public class Main  {
	
	public static void main(String[] args) {
		String email = "test@gmail.com";
		String phone = "083820202307";
		
		ValidatorBuilder v = new ValidatorBuilder();
//		chain method
		v.addRule(new EmailValidator())
		.addRule(new PhoneValidator())
		.addValue(email)
		.addValue(phone);
		
		System.out.println(v.check());
		
	}
}
