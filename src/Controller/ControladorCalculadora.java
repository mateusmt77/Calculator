package Controller;

import java.util.Deque;

import Model.ModeloCalculadora;

public class ControladorCalculadora {

    private final ModeloCalculadora modelo;
    private final ValidadorEntrada validadorEntrada = new ValidadorEntrada();

    public ControladorCalculadora(ModeloCalculadora modelo) {
        this.modelo = modelo;
    }

    public boolean anexarToken(String token) {
        String tokenNormalizado = validadorEntrada.normalizarToken(token);
        if (!validadorEntrada.tokenValido(tokenNormalizado)) {
            return false;
        }
        return modelo.anexarToken(tokenNormalizado);
    }

    public void enviandoExpressaoModel(String expressao) {
        if ((!expressao.contains(" ")) && (!expressao.isBlank())) {
            modelo.adicionandoExpressao(expressao);
        }
    }

    public String obterExpressaoAtual() {
        return modelo.obterExpressao();
    }

    public String calcularResultado() {
        return modelo.calcular();
    }

    public void limpar() {
        modelo.limpar();
    }

    public Deque<String> historicoOperacoes() {
        return modelo.obterHistoricoExpressao();
    }
}
