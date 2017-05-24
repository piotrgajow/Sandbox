def builder = new Builder()
println builder.forClass(User).withName('Jan').withSurname('Kowalski').withLogin('jankow').withEmail('jan.kowalski@gmail.com').withPassword('kow123').build()
println builder.forClass(User).withLogin('jan').build()