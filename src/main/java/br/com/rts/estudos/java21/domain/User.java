package br.com.rts.estudos.java21.domain;

import br.com.rts.estudos.java21.domain.enums.PasswordType;
import br.com.rts.estudos.java21.infrastructure.services.password.Password;

public record User(String id, String email, Password password) {

    public static User create(String email, PasswordType passwordType, String plainPassword){

        return new User(IdGenerator.nextId(), email, passwordType.create(plainPassword));
    }

    public static User restore(String id, String email, PasswordType passwordType, String plainPassword){

        return new User(id, email, passwordType.restore(plainPassword));
    }
}
