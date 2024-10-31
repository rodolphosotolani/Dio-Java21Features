package br.com.rts.estudos.java21.domain;

import br.com.rts.estudos.java21.infrastructure.services.password.PlainTextPassword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlainTextPasswordTest {

    @Test
    @DisplayName("PlainTextPassword - Deveria criar um Plain Text Password")
    public void deveriaCriarUmPlainPassword(){

        final var expectedPassword = "123456";

        var passwordCreated = new PlainTextPassword(expectedPassword);

        Assertions.assertTrue(passwordCreated.validate(expectedPassword));
    }

}