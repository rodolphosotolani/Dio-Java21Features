package br.com.rts.estudos.java21.infrastructure.controllers.requests;

import br.com.rts.estudos.java21.domain.enums.PasswordType;

public record UserRequest(String email, PasswordType passwordType, String plainPassword) {
}
