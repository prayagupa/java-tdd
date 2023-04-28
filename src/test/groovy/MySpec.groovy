import spock.lang.Specification

class MySpec extends Specification {

    def "multiplication with 1 should be itself"() {
        when:
        def a = 5

        then:
        a * 1  == a
    }
}
