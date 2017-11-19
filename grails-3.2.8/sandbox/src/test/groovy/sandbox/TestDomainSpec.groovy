package sandbox

import grails.test.mixin.TestFor
import spock.lang.Specification

import java.time.Year

@TestFor(TestDomain)
class TestDomainSpec extends Specification {

    void "Dynamic finder should work with java.time.Year"() {
        given:
        new TestDomain(year: Year.of(2000)).save(flush: true, failOnError: true)

        expect:
        TestDomain.findByYear(Year.of(2000))
    }

}
