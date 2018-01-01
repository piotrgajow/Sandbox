package sandbox

class User {

    Long id
    Long age
    String name

    static constraints = {
    }

    boolean isAdult() {
        return age >= 18
    }

}
