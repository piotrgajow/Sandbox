package sandbox

import java.time.Year

class BootStrap {

    def init = { servletContext ->
        new TestDomain(year: Year.of(2000)).save(flush: true, failOnError: true)
        assert TestDomain.findByYear(Year.of(2000))?.year == Year.of(2000)
    }
    def destroy = {
    }
}
