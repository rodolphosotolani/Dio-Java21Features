package br.com.rts.estudos.java21.domain;

import br.com.rts.estudos.java21.domain.enums.PasswordType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordTypeTest {

    @Test
    void deveriaCriarPlainTextPassword(){

        var excpectedPassword = "123456";
        var actualPassword = PasswordType.PLAIN.create(excpectedPassword);

        Assertions.assertEquals(excpectedPassword, actualPassword.value());
    }

}