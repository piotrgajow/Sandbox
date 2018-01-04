package sandbox

import grails.buildtestdata.mixin.Build
import spock.lang.Specification

@Build([Base, Extended])
class TestSpec extends Specification {

    void 'Get does not find Base instance, but it should'() {
        given:
        def instance = Extended.build()

        expect:
        instance.id == 1
        Base.get(1)?.id == null // FIXME expected 1
    }

    void 'findById does find Base instance'() {
        given:
        def instance = Extended.build()

        expect:
        instance.id == 1
        Base.findById(1)?.id == 1
    }

    void 'load does find Base instance'() {
        given:
        def instance = Extended.build()

        expect:
        instance.id == 1
        Base.load(1)?.id == 1
    }

    void 'Calling Base.list() makes get find Base instance'() {
        given:
        def instance = Extended.build()
        Base.list()

        expect:
        instance.id == 1
        Base.get(1)?.id == 1
    }

    void 'Calling Extended.list() makes get find Base instance'() {
        given:
        def instance = Extended.build()
        Extended.list()

        expect:
        instance.id == 1
        Base.get(1)?.id == 1
    }

}
