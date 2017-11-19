package sandbox

import grails.test.hibernate.HibernateSpec
import grails.test.mixin.TestFor

import java.time.Year

@TestFor(TestDomain)
class TestDomainSpec extends HibernateSpec {

    void "Dynamic finder should work with java.time.Year"() {
        given:
        new TestDomain(year: Year.of(2000)).save(flush: true, failOnError: true)

        expect:
        TestDomain.findByYear(Year.of(2000))
    }

    List getDomainClasses() {
        return [TestDomain]
    }

}
