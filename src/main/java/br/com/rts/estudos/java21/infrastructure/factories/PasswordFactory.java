package br.com.rts.estudos.java21.infrastructure.factories;

import br.com.rts.estudos.java21.infrastructure.services.password.PBKDF2Password;
import br.com.rts.estudos.java21.infrastructure.services.password.Password;
import br.com.rts.estudos.java21.infrastructure.services.password.PlainTextPassword;
import br.com.rts.estudos.java21.infrastructure.services.password.SHA1Password;

public class PasswordFactory {

    public static String create(String passworType, String password) {

        Password passwordStrategy = new PlainTextPassword(password);

        /*
        Record Patterns[440] - Valida se o password é do tipo plainText e ja utiliza o objeto retornado no if
         */
        if (passwordStrategy instanceof PlainTextPassword(String passworw)){
            System.out.println(password);
        }

        /*
        Patter Matching for Switch[441] - Ja utiliza do objeto do switch para executar uma açao retornada no case
         */
        return switch (passwordStrategy) {
            case PlainTextPassword(String pass) -> pass;
            case SHA1Password(String pass) -> pass;
            case PBKDF2Password pwd -> pwd.value();
        };
    }
}
