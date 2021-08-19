package br.com.stefanini.projetoum.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.stefanini.projetoum.interfaces.ICustomerValidation;

public class CustomerValidation implements ICustomerValidation {

	public Boolean isNameCustomer(String name) {
		if(name==null) {
			return false;
		}else if(name.length()<3) {
			return false;
		}
		return true;
	}
	public Boolean isEmail(String email) {
		Pattern p = Pattern.compile("[a-zA-Z0-9]+@+\\.[a-z]+");
		Matcher m = p.matcher(email);
		return m.matches();
	}
}
