class User {
	def login
	def name
	def surname
	def email
	def password

	void setPassword(String password) {
		this.password = hashPassword(password)
	}

	String hashPassword(String password) {
		def digest = java.security.MessageDigest.getInstance("SHA-256")
		digest.update( password.bytes )
		return new BigInteger(1,digest.digest()).toString(16).padLeft(32, '0')
	}
 
	String toString() {
		return "$name $surname ($login) - $email, $password"
	}
}