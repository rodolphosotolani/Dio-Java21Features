package br.com.rts.estudos.java21.infrastructure.services.password;

import com.google.common.io.BaseEncoding;
import lombok.extern.log4j.Log4j2;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

@Log4j2
public record PBKDF2Password(String value, String salt) implements Password {

    @Override
    public String value() {
        return STR."\{value}$$\{salt}";
    }

    @Override
    public boolean validate(final String password) {
        return value().equals(hash(password, salt));
    }

    public static PBKDF2Password create(final String plainPassword) {

        var salt = generateSalt();

        return new PBKDF2Password(hash(plainPassword, salt), salt);
    }

    public static PBKDF2Password restore(final String password) {
        var allParts = password.split("\\$\\$");

        var pass = allParts[0];
        var salt = allParts[1];

        return new PBKDF2Password(pass, salt);
    }

    private static String hash(final String plainText, String salt) {

        try {
            var pbeKeySpec = new PBEKeySpec(plainText.toCharArray(), salt.getBytes(StandardCharsets.UTF_8), 100, 64);
            var encoded = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                    .generateSecret(pbeKeySpec)
                    .getEncoded();

            return BaseEncoding.base16().encode(encoded);
        } catch (InvalidKeySpecException e) {
            log.error("Erro ao Encodificar Senha, Invalid Key Spec. Erro: %s".formatted(e));
        } catch (NoSuchAlgorithmException e) {
            log.error("Erro ao Encodificar Senha, No Such Algoritm. Erro: %s".formatted(e));
        }

        return "";
    }

    private static String generateSalt() {

        var bytes = new byte[16];

        var randomBytes = new SecureRandom();
        randomBytes.nextBytes(bytes);

        return BaseEncoding.base16().encode(bytes);
    }
}
