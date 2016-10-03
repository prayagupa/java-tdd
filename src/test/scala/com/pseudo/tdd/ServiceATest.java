package com.pseudo.tdd;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Map;

import static org.mockito.Matchers.eq;

/**
 * Created by prayagupd
 * on 10/3/16.
 */

public class ServiceATest {

    @Test
    public void testThings() {
        ServiceA serviceA = new ServiceA();
        serviceA.serviceB = Mockito.mock(ServiceB.class);

        serviceA.method1("1");

        Mockito.verify(serviceA.serviceB).method2("1-once", "1-again");

        ArgumentCaptor<String> captor1 = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Map> captor2 = ArgumentCaptor.forClass(Map.class);
        ArgumentCaptor<Map> captor3 = ArgumentCaptor.forClass(Map.class);

        Mockito.verify(serviceA.serviceB).method3(captor1.capture());

        assert captor1.getValue() == "1";

        Mockito.verify(serviceA.serviceB).method4(captor2.capture());
        assert captor2.getValue().get("key") == "1";

        //

        Mockito.verify(serviceA.serviceB).method5(eq("1"), captor3.capture());
        assert captor2.getValue().get("key") == "1";
    }
}