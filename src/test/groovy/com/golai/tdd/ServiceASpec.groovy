package com.golai.tdd

import spock.lang.Specification

public class ServiceASpec extends Specification {
    ServiceA serviceA = new ServiceA()

    //IO state assertion
    def "should deliver order and change the state"() {
        given:
        String orderId = "order-id"

        when:
        String state = serviceA.deliverOrder(orderId)

        then:
        state == orderId + "-" + "delivered"
    }

    //verify calls
    def "should execute and make relevant calls"() {
        serviceA.serviceB = Spy(ServiceB)

        given:
        String orderId = "order-id"
        when:
        serviceA.executeSomething(orderId)

        then:
        1 * serviceA.serviceB.doSomething1(_, _)
        1 * serviceA.serviceB.doSomething2(_)
        1 * serviceA.serviceB.doSomething3(_)
        1 * serviceA.serviceB.doSomething4(_, _)
    }

    //mock responses
    def "should deliver and update the state"() {
        given:
        String orderId = "order-id"
        String newState = "state change"

        serviceA.serviceB = Spy(ServiceB)
        serviceA.serviceB.deliverOrder(orderId) >> newState

        when:
        String state = serviceA.deliverOrder(orderId)

        then:
        state == orderId + "-" + newState
    }
}
