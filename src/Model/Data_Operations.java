package Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Data_Operations { 

    private Double valor1;
    private Double valor2; 
    private List <String> operadores = List.of("+", "-", "/", "x", "(", ")");
    private List <String> operadoresLista = new ArrayList<>(operadores); 
    public static String expressaoCompleta = "";

    public void validandoEntrada(String inputUsuario){
        if((inputUsuario.matches("^[+-]?\\d+(\\.\\d+)?$")) || (operadoresLista.contains(inputUsuario))){
            armazenandoValoresLista(inputUsuario);
        } 
    }

    public void armazenandoValoresLista(String entrada){ 
        this.expressaoCompleta += entrada; 
    }
    
    // OPERAÇÕES COM RETORNO 
    public BigDecimal add(Double v1, Double v2){
        this.valor1 = v1;
        this.valor2 = v2;

        BigDecimal resultado = add(valor1, valor2);  
        return resultado;
    } 

    public BigDecimal sub(Double v1, Double v2){
        this.valor1 = v1;
        this.valor2 = v2;

        BigDecimal resultado = sub(valor1, valor2); 
        return resultado;
    } 

    public BigDecimal mult(Double v1, Double v2){
        this.valor1 = v1;
        this.valor2 = v2;

        BigDecimal resultado = mult(valor1, valor2); 
        return resultado;
    } 

    public BigDecimal div(Double v1, Double v2){
        this.valor1 = v1;
        this.valor2 = v2;

        BigDecimal resultado = div(valor1, valor2);  
        return resultado;
    }  
}