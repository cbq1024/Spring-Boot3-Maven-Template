package dev.cbq.security.help;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.Random;

public abstract class PasswordEncoderHelper {

    static final Random RANDOM = new Random();

    public static String encryptPassword(String password) {
        int number = RANDOM.nextInt(2);
        return

                switch (number) {
                    case 0 -> _encrypt("{bcrypt}", new BCryptPasswordEncoder(), password);
                    case 1 -> _encrypt("{pbkdf2@SpringSecurity_v5_8}",
                            Pbkdf2PasswordEncoder
                                    .defaultsForSpringSecurity_v5_8(), password);

                    // other algorithms ...

                    default -> throw new IllegalArgumentException();
                };

    }

    static String _encrypt(String prefix, PasswordEncoder encoder, String password) {
        return prefix + encoder.encode(password);
    }

}
