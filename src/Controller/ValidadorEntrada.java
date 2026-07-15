package Controller;

import java.util.Set;

public class ValidadorEntrada {

    private static final Set<String> TOKENS_PERMITIDOS = Set.of(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "+", "-", "*", "/", "(", ")", "."
    );

    public boolean tokenValido(String token) {
        return TOKENS_PERMITIDOS.contains(token);
    }

    public String normalizarToken(String token) {
        return "x".equals(token) ? "*" : token;
    }
}
