package org.zaouibahaddin.EXO1;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.zaouibahaddin.EXO1.Calculatrice;

import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {

    @Mock
    Calculatrice calc;
    @Test
    public void testAdditionner() {

        when(calc.additionner(2, 3)).thenReturn(5);

        int result = calc.additionner (2,3);

        Assertions.assertEquals(result,5);

        verify(calc).additionner(2,3);

        verifyNoMoreInteractions(calc);

        int state = calc.getState();

        verify(calc).getState();
    }
}


