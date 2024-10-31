package br.com.rts.estudos.java21.domain.entities;

public sealed interface PaymentMethod permits CreditCard, DebitCard, Pix {

}
