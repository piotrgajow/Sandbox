package sandbox

import grails.buildtestdata.mixin.Build
import spock.lang.Specification

@Build([Base, Extended])
class TestSpec extends Specification {

    void 'Base instance is not fount, but it should be'() {
        given:
        def instance = Extended.build()

        expect:
        instance.id == 1
        Base.get(1)?.id == null // expected 1
    }

    void 'Workaround version 1'() {
        given:
        def instance = Extended.build()
        Base.list()

        expect:
        instance.id == 1
        Base.get(1)?.id == 1
    }

    void 'Workaround version 2'() {
        given:
        def instance = Extended.build()
        Extended.list()

        expect:
        instance.id == 1
        Base.get(1)?.id == 1
    }

}
