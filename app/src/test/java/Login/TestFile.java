package Login;//package com.upb.nodesperdicio;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

import Login.ControladorLogin;
import Login.LoginIterface;

@RunWith(MockitoJUnitRunner.class)
public class TestFile {

    @Mock
    ControladorLogin controladorLogin;

    @Mock
    LoginIterface.View view;

    @Before
    public void setUp() {
        controladorLogin = new ControladorLogin(view);
    }

    @Test
    public void testValidarCampoUsuarioVacioERROR() {
        assertEquals(controladorLogin.validarLogin("", "usuario"), false);
    }

    @Test
    public void testValidarCampoPasswordVacioERROR() {
        assertEquals(controladorLogin.validarLogin("", "password"), false);
    }

    @Test
    public void testValidarCampoMayor5UsuarioERROR() {
        assertEquals(controladorLogin.validarLogin("1234", "usuario"), false);
    }

    @Test
    public void testValidarCampoMayor5PasswordERROR() {
        assertEquals(controladorLogin.validarLogin("1234", "password"), false);
    }

    @Test
    public void testValidarCampoUsuarioVacioOK() {
        assertEquals(controladorLogin.validarLogin("123456", "usuario"), true);
    }

    @Test
    public void testValidarCampoPasswordVacioOK() {
        assertEquals(controladorLogin.validarLogin("123456", "password"), true);
    }

    @Test
    public void testAutorizarUsuarioOK() {
        assertEquals(controladorLogin.usuarioPermitido("prueba", "12345"), true);
    }
    @Test
    public void testAutorizarUsuarioERROR() {
        assertEquals(controladorLogin.usuarioPermitido("pru", "12345"), false);
    }

}