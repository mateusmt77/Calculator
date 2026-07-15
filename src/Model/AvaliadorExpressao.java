package Model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class AvaliadorExpressao {

    private static final Map<String, Integer> PRECEDENCIA = Map.of(
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    public double avaliar(String expressao) {
        List<String> tokens = tokenizar(expressao);
        List<String> rpn = paraRpn(tokens);
        return avaliarRpn(rpn); 
    }

    private List<String> tokenizar(String expressao) {
        expressao = expressao.replaceAll("\\s+", "");
        List<String> tokens = new ArrayList<>();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                int fim = i;
                while (fim < expressao.length()
                        && (Character.isDigit(expressao.charAt(fim)) || expressao.charAt(fim) == '.')) {
                    fim++;
                }
                tokens.add(expressao.substring(i, fim));
                i = fim - 1;
            } else if (c == '-' && (i == 0 || "+-*/(".indexOf(expressao.charAt(i - 1)) >= 0)) {
                int fim = i + 1;
                while (fim < expressao.length()
                        && (Character.isDigit(expressao.charAt(fim)) || expressao.charAt(fim) == '.')) {
                    fim++;
                }
                tokens.add(expressao.substring(i, fim));
                i = fim - 1;
            } else {
                tokens.add(String.valueOf(c));
            }
        }

        return tokens;
    }

    private List<String> paraRpn(List<String> tokens) {
        LinkedList<String> saida = new LinkedList<>();
        LinkedList<String> operadores = new LinkedList<>();
        Predicate<String> ehNumero = token -> token.matches("-?\\d+(\\.\\d+)?");

        for (String token : tokens) {
            if (ehNumero.test(token)) {
                saida.add(token);
            } else if ("(".equals(token)) {
                operadores.push(token);
            } else if (")".equals(token)) {
                while (!operadores.isEmpty() && !"(".equals(operadores.peek())) {
                    saida.add(operadores.pop());
                }
                if (!operadores.isEmpty()) {
                    operadores.pop();
                }
            } else {
                while (!operadores.isEmpty()
                        && !"(".equals(operadores.peek())
                        && PRECEDENCIA.getOrDefault(operadores.peek(), 0) >= PRECEDENCIA.getOrDefault(token, 0)) {
                    saida.add(operadores.pop());
                }
                operadores.push(token);
            }
        }

        while (!operadores.isEmpty()) {
            saida.add(operadores.pop());
        }

        return saida;
    }

    private double avaliarRpn(List<String> tokensRpn) {
        Deque<Double> pilha = new ArrayDeque<>();
        Predicate<String> ehNumero = token -> token.matches("-?\\d+(\\.\\d+)?");

        for (String token : tokensRpn) {
            if (ehNumero.test(token)) {
                pilha.push(Double.parseDouble(token)); 
            } else {
                double direito = pilha.pop();
                double esquerdo = pilha.pop();
                switch (token) {
                    case "+" -> pilha.push(esquerdo + direito);
                    case "-" -> pilha.push(esquerdo - direito);
                    case "*" -> pilha.push(esquerdo * direito);
                    case "/" -> {
                        if (direito == 0) {
                            throw new IllegalArgumentException("Divisão por zero não é permitida");
                        }
                        pilha.push(esquerdo / direito);
                    }
                    default -> throw new IllegalArgumentException("Operador desconhecido: " + token);
                }
            }
        }

        return pilha.pop();
    }
}
