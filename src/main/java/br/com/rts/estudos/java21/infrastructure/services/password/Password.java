package br.com.rts.estudos.java21.infrastructure.services.password;

public sealed interface Password permits PlainTextPassword, SHA1Password, PBKDF2Password {

    String value();

    boolean validate(String password);
}
