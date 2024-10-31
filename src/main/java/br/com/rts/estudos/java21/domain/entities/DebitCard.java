package br.com.rts.estudos.java21.domain.entities;

import br.com.rts.estudos.java21.domain.enums.BrandEnum;

public record DebitCard(Double amount, String cardNumber, String cardHolder, String expirationDate, String cvv, BrandEnum brand) implements PaymentMethod {
}
