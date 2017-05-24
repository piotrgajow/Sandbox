def builder = new Builder()

println builder.forClass(User).withName('Jan').withSurname('Kowalski').withLogin('jankow').withEmail('jan.kowalski@gmail.com').withPassword('kow123').build()
def user = builder.forClass(User).withLogin('jan').build()
println user
assert user.toString() == 'null null (jan) - null, null'