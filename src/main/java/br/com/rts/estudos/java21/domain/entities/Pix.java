package br.com.rts.estudos.java21.domain.entities;

import br.com.rts.estudos.java21.domain.entities.PaymentMethod;

public record Pix(Double amount) implements PaymentMethod {
}
