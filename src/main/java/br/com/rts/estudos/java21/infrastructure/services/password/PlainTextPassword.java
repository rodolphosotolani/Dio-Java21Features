package br.com.rts.estudos.java21.infrastructure.services.password;

public record PlainTextPassword(String value) implements Password {

    public static PlainTextPassword create(final String plainPassword){
        return new PlainTextPassword(plainPassword);
    }

    public static PlainTextPassword restore(final String password){
        return new PlainTextPassword(password);
    }
    @Override
    public boolean validate(final String password) {
        return value().equals(password);
    }
}
