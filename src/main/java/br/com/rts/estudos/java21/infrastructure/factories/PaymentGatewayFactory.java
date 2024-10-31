package br.com.rts.estudos.java21.infrastructure.factories;

import br.com.rts.estudos.java21.domain.entities.PaymentMethod;
import br.com.rts.estudos.java21.domain.entities.Pix;
import br.com.rts.estudos.java21.infrastructure.services.payment.PixGateway;
import br.com.rts.estudos.java21.infrastructure.services.payment.VisaGateway;
import br.com.rts.estudos.java21.domain.entities.CreditCard;
import br.com.rts.estudos.java21.domain.entities.DebitCard;
import br.com.rts.estudos.java21.infrastructure.services.payment.EloGateway;
import br.com.rts.estudos.java21.domain.enums.BrandEnum;
import br.com.rts.estudos.java21.infrastructure.services.payment.PaymentGateway;
import br.com.rts.estudos.java21.infrastructure.services.payment.MasterCardGatewat;

public class PaymentGatewayFactory {

    public PaymentGateway execute(PaymentMethod paymentMethod) {

        return switch (paymentMethod) {

            case CreditCard cc when cc.brand().equals(BrandEnum.VISA) -> new VisaGateway();
            case CreditCard cc when cc.brand().equals(BrandEnum.MASTERCARD) -> new MasterCardGatewat();
            case CreditCard cc -> new EloGateway();

            case DebitCard dc when dc.brand().equals(BrandEnum.VISA) -> new VisaGateway();
            case DebitCard dc when dc.brand().equals(BrandEnum.MASTERCARD) -> new MasterCardGatewat();
            case DebitCard dc -> new EloGateway();

            case Pix pix -> new PixGateway();
        };
    }
}
