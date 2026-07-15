package Model;

public class ModeloCalculadora {

    private final AvaliadorExpressao avaliador = new AvaliadorExpressao(); 
    private final StringBuilder construtorExpressao = new StringBuilder(); 


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
