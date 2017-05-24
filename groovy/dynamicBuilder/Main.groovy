class Builder {
	def inst
 
	def forClass(Class clazz) {
		inst = clazz.newInstance()
		return this
	}
 
	def methodMissing(String name, args) {
		if (name.startsWith('with')) {
			name = "${name[4].toLowerCase()}${name[5..-1]}"
			if (inst.hasProperty(name)) {
				inst."$name" = args[0]
				return this;
			}
		}
	}
 
	def build() {
		return inst;
	}
}
 
def builder = new Builder()
println builder.forClass(User).withName('Jan').withSurname('Kowalski').withLogin('jankow').withEmail('jan.kowalski@gmail.com').withPassword('kow123').build()
println builder.forClass(User).withLogin('jan').build()