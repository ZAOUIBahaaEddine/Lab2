package org.zaouibahaddin;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
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

        /*
        Calculatrice c = new Calculatrice ();
        int result = c.additionner (2,3);


        Assertions.assertEquals(5, result);
        */




        //TODO : Appel de la méthode à tester
        // ...
        //TODO : Vérification du résultat
        // ...
        //TODO : Vérification que la méthode "additionner" a été appelée
        // avec les arguments 2 et 3, utiliser la directive « verify »
        //TODO : Vérification qu'aucune autre méthode n'a été appelée sur
        //l'objet après l'appel de la méthode "additionner", utiliser la
        // méthode « verifyNoMoreInteractions »
        // TODO : Vérification de l'état de l'objet après l'appel de la
        //méthode "additionner", penser à utiliser la méthode
        //« getState() » de la directive « verify » : // exemple: verify(objet).getState()
    }
}


