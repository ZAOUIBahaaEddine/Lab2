package org.zaouibahaddin.EXO2And3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;
    @Captor
    private ArgumentCaptor<Utilisateur> utilisateurArgumentCaptor;
    // I did not use this attribute
    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // Exercise 2
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }
    @Test
    public void testCreerUtilisateurExceptionExercice3Vol1() throws ServiceException {
        // Exercise 3 Question 1
        doThrow(new ServiceException("Echec de la création de l'utilisateur")).when(utilisateurApiMock).creerUtilisateur(any(Utilisateur.class));
        UserService userService = new UserService(utilisateurApiMock);
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        try {
            userService.creerUtilisateur(utilisateur);
        } catch (ServiceException e) {
            assert e.getMessage() != null && e.getMessage().equals("Echec de la création de l'utilisateur");
        }
    }

    @Test
    public void testCreerUtilisateurValidationError() throws ServiceException {
        doThrow(new ServiceException("Erreur de validation")).when(utilisateurApiMock).creerUtilisateur(any(Utilisateur.class));
        UserService userService = new UserService(utilisateurApiMock);
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        try {
            userService.creerUtilisateur(utilisateur);
        } catch (ServiceException e) {
            assert e.getMessage() != null && e.getMessage().equals("Erreur de validation");
            verify(utilisateurApiMock, never()).creerUtilisateur(utilisateur);
        }
    }

    @Test
    public void testCreerUtilisateurEXO3Vol3() throws ServiceException {
        // Exercise 3 Question 3
        // This part must be reimplemented,
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        int idUtilisateur = 123;
        doAnswer(invocation -> {
            Utilisateur capturedUtilisateur = invocation.getArgument(0);
            capturedUtilisateur.setId(123);
            return null;
        }).when(utilisateurApiMock).creerUtilisateur(utilisateur);
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);
        assert utilisateur.getId() == idUtilisateur;
    }

    @Test
    public void testCreerUtilisateurEXO3Vol4() throws ServiceException {

        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        doNothing().when(utilisateurApiMock).creerUtilisateur(any(Utilisateur.class));
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();

        assert utilisateurCapture.getNom().equals(utilisateur.getNom());
        assert utilisateurCapture.getPrenom().equals(utilisateur.getPrenom());
        assert utilisateurCapture.getEmail().equals(utilisateur.getEmail());
    }

}
