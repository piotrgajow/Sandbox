package sandbox

import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(User)
@Build(User)
class UserSpec extends Specification {

    @Unroll
    void "isAdult should return valid result"() {
        given:
        def user = User.build(age: age)

        expect:
        User.get(user.id).isAdult() == expected

        where:
        age | expected
        1   | false
        17  | false
        18  | true
        50  | true
    }

}
