package br.com.rts.estudos.java21.infrastructure.services.payment;

import br.com.rts.estudos.java21.domain.entities.PaymentMethod;

public record MasterCardGatewat() implements PaymentGateway {
    @Override
    public String execute(PaymentMethod paymentMethod) {
        return null;
    }
}
