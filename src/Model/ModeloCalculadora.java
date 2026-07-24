package Model;

import java.util.ArrayDeque;
import java.util.Deque;

public class ModeloCalculadora {

    private final AvaliadorExpressao avaliador = new AvaliadorExpressao();
    private final StringBuilder construtorExpressao = new StringBuilder();
    private final Deque<String> historicoOperacoes = new ArrayDeque<>(20);

    public boolean anexarToken(String token) {
        if (token == null || token.isBlank()) {
            return false;
        }

        if (tokenPermitido(token)) {
            construtorExpressao.append(token);
            return true;
        }
        return false;
    }

    public void adicionandoExpressao(String expressaoEntrada) {
        adicionarExpressaoHistorico(expressaoEntrada);
    }

    public void adicionarExpressaoHistorico(String expressaoTratada) {
        if (historicoOperacoes.size() == 20) {
            historicoOperacoes.removeFirst();
            historicoOperacoes.add(expressaoTratada);
        } else {
            historicoOperacoes.add(expressaoTratada);
        }
    }

    public Deque<String> obterHistoricoExpressao() {
        return historicoOperacoes;
    }

    public String obterExpressao() {
        return construtorExpressao.toString();
    }

    public String calcular() {
        String expressao = obterExpressao();
        if (expressao.isBlank()) {
            return "";
        }

        double resultado = avaliador.avaliar(expressao);
        construtorExpressao.setLength(0);
        return formatarResultado(resultado);
    }

    public void limpar() {
        construtorExpressao.setLength(0);
    }

    public void limparCaracter() {
        int posicaoUltimoCaract = construtorExpressao.toString().length() - 1;
        construtorExpressao.deleteCharAt(posicaoUltimoCaract); 
    }

    private boolean tokenPermitido(String token) {
        return token.matches("[0-9]") || token.matches("[+\\-*/().]");
    }

    private String formatarResultado(double valor) {
        if (valor == (long) valor) {
            return String.valueOf((long) valor);
        }
        return String.valueOf(valor);
    }
}
