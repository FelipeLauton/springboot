	public Boolean isEmail(String email) {
		Pattern p = Pattern.compile("[a-zA-Z0-9]+@+\\.[a-z]+");
		Matcher m = p.matcher(email);
		return m.matches();
	}