package br.com.rts.estudos.java21.domain;

import br.com.rts.estudos.java21.infrastructure.services.password.SHA1Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SHA1PasswordTest {

    @Test
    @DisplayName("SHA1Password - deveria hasear a senha e nao ser igual ao plainText")
    public void deveriaHashearASenha() {

        String plainText = "123456";

        var sha1Password = SHA1Password.create(plainText);

        assertNotEquals(plainText, sha1Password.value());

    }

       @Test
    @DisplayName("SHA1Password - deveria dar match nas senhas haseadas")
    public void deveriaDarMatchNasSenhas() {

        String plainText = "123456";

        var sha1Password = SHA1Password.create(plainText);

        assertTrue(sha1Password.validate(plainText));

    }


}