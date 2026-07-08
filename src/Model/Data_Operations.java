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

        Double resultado = add(valor1, valor2);
        return resultado;
    }

    public Double sub(Double v1, Double v2) {
        this.valor1 = v1;
        this.valor2 = v2;

        Double resultado = sub(valor1, valor2);
        return resultado;
    }

    public Double mult(Double v1, Double v2) {
        this.valor1 = v1;
        this.valor2 = v2;

        Double resultado = mult(valor1, valor2);
        return resultado;
    }

    public Double div(Double v1, Double v2) {
        this.valor1 = v1;
        this.valor2 = v2;

        Double resultado = div(valor1, valor2);
        return resultado;
    }
}
