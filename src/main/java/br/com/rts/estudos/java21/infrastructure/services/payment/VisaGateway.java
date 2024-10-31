package br.com.rts.estudos.java21.infrastructure.services.payment;

import br.com.rts.estudos.java21.domain.entities.PaymentMethod;

public record VisaGateway() implements PaymentGateway {

    @Override
    public String execute(PaymentMethod paymentMethod) {
        return null;
    }
}
