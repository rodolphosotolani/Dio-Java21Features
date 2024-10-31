package br.com.rts.estudos.java21.infrastructure.services.payment;

import br.com.rts.estudos.java21.domain.entities.PaymentMethod;

public sealed interface PaymentGateway permits EloGateway, MasterCardGatewat, PixGateway, VisaGateway {


    String execute(PaymentMethod paymentMethod);
}
