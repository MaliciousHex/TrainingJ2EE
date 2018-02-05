package h1java;

import java.util.Vector;

public class ValidatorBuilder {
	Vector<Validator> rules;
	Vector<String> values;
	
	public ValidatorBuilder() {
		// TODO Auto-generated constructor stub
		rules = new Vector<Validator>();
		values = new Vector<String>();
	}
	
	public ValidatorBuilder addRule(Validator v){
		rules.add(v);
		return this;
	}
	
	public ValidatorBuilder addValue(String s){
		values.add(s);
		return this;
	}
	
	public boolean check(){
		
		if(rules.size() != values.size()) return false;
		
		for(int i = 0; i < rules.size();i++){
			Validator v = rules.elementAt(i);
			String s = values.elementAt(i);
			if(!v.check(s)) return false;
		}
		
		return true;
	}
}
