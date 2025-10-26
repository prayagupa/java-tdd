package com.golai.tdd;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by prayagupd
 * on 10/3/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ServiceATest {

    private static final String SOME_ARG = "1";

    @Mock
    private ServiceB serviceB;

    @InjectMocks
    private ServiceA serviceA;

    @Captor
    private ArgumentCaptor<String> stringCaptor;

    @Captor
    private ArgumentCaptor<Map<String, String>> mapCaptor;

    @Captor
    private ArgumentCaptor<Map<String, String>> secondMapCaptor;

    @Test
    public void testExecuteSomethingDelegatesToCollaborators() {
        // when
        serviceA.executeSomething(SOME_ARG);

        // then
        verify(serviceB).doSomething1(SOME_ARG + "-once", SOME_ARG + "-again");

        verify(serviceB).doSomething2(stringCaptor.capture());
        assertEquals(SOME_ARG, stringCaptor.getValue());

        verify(serviceB).doSomething3(mapCaptor.capture());
        assertEquals(SOME_ARG, mapCaptor.getValue().get("key"));

        verify(serviceB).doSomething4(eq(SOME_ARG), secondMapCaptor.capture());
        assertEquals(SOME_ARG, secondMapCaptor.getValue().get("key"));

        verifyNoMoreInteractions(serviceB);
    }
}
