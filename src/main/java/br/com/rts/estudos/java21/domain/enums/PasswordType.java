package br.com.rts.estudos.java21.domain.enums;

import br.com.rts.estudos.java21.infrastructure.services.password.PBKDF2Password;
import br.com.rts.estudos.java21.infrastructure.services.password.Password;
import br.com.rts.estudos.java21.infrastructure.services.password.PlainTextPassword;
import br.com.rts.estudos.java21.infrastructure.services.password.SHA1Password;

import java.util.function.Function;

public enum PasswordType {

    PLAIN(PlainTextPassword::create, PlainTextPassword::restore),
    SHA1(SHA1Password::create, SHA1Password::restore),
    PBKDF2(PBKDF2Password::create, PBKDF2Password::restore);

    private final Function<String, Password> createFn;

    private final Function<String, Password> restoreFn;

    PasswordType(Function<String, Password> createFn, Function<String, Password> restoreFn) {
        this.createFn = createFn;
        this.restoreFn = restoreFn;
    }

    public Password create(final String plainPassword){
        return createFn.apply(plainPassword);
    }

    public Password restore(final String plainPassword){
        return restoreFn.apply(plainPassword);
    }
}
