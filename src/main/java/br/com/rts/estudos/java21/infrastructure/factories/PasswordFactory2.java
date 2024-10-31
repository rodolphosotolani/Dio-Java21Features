package br.com.rts.estudos.java21.infrastructure.factories;

import br.com.rts.estudos.java21.infrastructure.services.password.PBKDF2Password;
import br.com.rts.estudos.java21.infrastructure.services.password.Password;
import br.com.rts.estudos.java21.infrastructure.services.password.PlainTextPassword;
import br.com.rts.estudos.java21.infrastructure.services.password.SHA1Password;

public class PasswordFactory2 {

    public static String create(String passworType, String plainPassword) {

        Object passwordStrategy = new PlainTextPassword(plainPassword);

        /*
        Record Patterns[440] - Valida se o password é do tipo plainText e ja utiliza o objeto retornado no if
         */
        if (passwordStrategy instanceof PlainTextPassword(String password)){
            System.out.println(password);
        }

        /*
        Patter Matching for Switch[441] - Ja utiliza do objeto do switch para executar uma açao retornada no case
        Utiliza-se do WHEN para validar se as duas expressoes sao corretas...
        Valida se ele é uma implementacao da interface Password, se for:
            E tambem for do tipo de instancia dos cases, entao executa o codigo solicitado
         */
        return switch (passwordStrategy) {
            case Password p when p instanceof PlainTextPassword(String pass) -> pass;
            case Password p when p instanceof SHA1Password(String shaPass) -> shaPass;
            case Password p when p instanceof PBKDF2Password pwd -> pwd.value();
            default -> throw new IllegalStateException("Unexpected value: " + passwordStrategy);
        };
    }
}
