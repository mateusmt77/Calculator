package Model;

import java.util.ArrayList;
import java.util.List;

public class Data_Operations {

    private Double valor1;
    private Double valor2;
    private List<String> operadores = List.of("+", "-", "/", "x", "(", ")", ".");
    private List<String> operadoresLista = new ArrayList<>(operadores);
    public String expressaoCompleta = "";

    public void validandoEntrada(String inputUsuario) {
        if ((inputUsuario.matches("^[+-]?\\d+(\\.\\d+)?$")) || (operadoresLista.contains(inputUsuario))) {
            armazenandoValoresLista(inputUsuario);
        }
    }

    private void armazenandoValoresLista(String entrada) {
        this.expressaoCompleta += entrada;
    }

    public Double retornoExpressao() {

        EvalExpressao op = new EvalExpressao();
        List<String> tokens = op.token(expressaoCompleta); 
        List<String> rpn = op.toRpn(tokens);

        expressaoCompleta = "";

        return op.evalRpn(rpn);  
    }

    public void limpandoExpressao() {
        this.expressaoCompleta = "";
    }

    public Double add(Double v1, Double v2) {
        this.valor1 = v1;
        this.valor2 = v2;
        return valor1 + valor2;
    }

    public Double sub(Double v1, Double v2) {
        this.valor1 = v1;
        this.valor2 = v2;
        return valor1 - valor2;
    }

    public Double mult(Double v1, Double v2) {
        this.valor1 = v1;
        this.valor2 = v2;
        return valor1 * valor2;
    }

    public Double div(Double v1, Double v2) {
        this.valor1 = v1;
        this.valor2 = v2;
        if (valor2 == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida");
        }
        return valor1 / valor2;
    }
}
