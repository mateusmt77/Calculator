package Model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class EvalExpressao { 

    static Map<String, Integer> operadoresPrecedencia = Map.of(
        "+", 1, "-", 1, "x", 2, "/", 2); 

    static List<String> token(String expressaoCompleta){
        expressaoCompleta = expressaoCompleta.replaceAll(" ", "");
        List<String> tkn = new ArrayList<>(); 

        for(int i = 0; i < expressaoCompleta.length(); i++){
            char c = expressaoCompleta.charAt(i);  

            if((Character.isDigit(c)) || (c == '.')){
                int x = i; 
                while(x < expressaoCompleta.length() && (Character.isDigit(expressaoCompleta.charAt(x)) || expressaoCompleta.charAt(x) == '.')) {
                    x++;
                }
                tkn.add(expressaoCompleta.substring(i, x)); 
                i = x - 1; 

            } else if (c == '-' && (i == 0 || "+-x/^(".indexOf(expressaoCompleta.charAt(i-1)) >= 0)){ 
                int x = i + 1; 
                if(x < expressaoCompleta.length() && (Character.isDigit(expressaoCompleta.charAt(x)) || expressaoCompleta.charAt(x) == '.')){
                    while(x < expressaoCompleta.length() && (Character.isDigit(expressaoCompleta.charAt(x)) || expressaoCompleta.charAt(x) == '.')) {
                        x++;
                    }
                    tkn.add(expressaoCompleta.substring(i, x)); 
                    i = x - 1; 
                } else {
                    tkn.add("-1"); 
                    tkn.add("x");  
                } 
            } else {
                tkn.add(String.valueOf(c));
            }
        }
        return tkn; 
    }

    static List<String> toRpn(List<String> tokens){
        LinkedList<String> saida = new LinkedList<>();
        LinkedList<String> operadores = new LinkedList<>(); 

        Predicate<String> isNumber = valor -> valor.matches("-?\\d+(\\.\\d+)?");
        Predicate<String> isBracketLeft = valor -> valor.equals("(");
        Predicate<String> isBracketRight = valor -> valor.equals(")"); 

        for (String tokenAtual : tokens) {
            if(isNumber.test(tokenAtual)){
                saida.add(tokenAtual); 

            } else if (isBracketLeft.test(tokenAtual)){ 
                operadores.push(tokenAtual); 

            } else if (isBracketRight.test(tokenAtual)){
               
                while (!operadores.isEmpty() && !operadores.peek().equals("(")) { 
                    saida.add(operadores.pop()); 
                }
                if (!operadores.isEmpty()) {
                    operadores.pop(); 
                }

            } else { 
                while (!operadores.isEmpty() && !operadores.peek().equals("(") && 
                       operadoresPrecedencia.getOrDefault(operadores.peek(), 0) >= operadoresPrecedencia.getOrDefault(tokenAtual, 0)) {  
                    saida.add(operadores.pop()); 
                }
                operadores.push(tokenAtual);  
            }
        } 

        while (!operadores.isEmpty()) {
            saida.add(operadores.pop());
        }

        return saida;
    }

    static double evalRpn(List<String> saidaNotacaoInversa) {
        Deque<Double> acumuladorNumerico = new ArrayDeque<>();  
        Predicate<String> isNumber = valor -> valor.matches("-?\\d+(\\.\\d+)?");  
        Data_Operations operacao = new Data_Operations();

        for (String cont : saidaNotacaoInversa) { 
            if (isNumber.test(cont)) {
                acumuladorNumerico.push(Double.parseDouble(cont));  
            } else {
                Double valor2 = acumuladorNumerico.pop(); 
                Double valor1 = acumuladorNumerico.pop();   

                switch (cont) { 
                    case "+":
                        acumuladorNumerico.push(operacao.add(valor1, valor2)); 
                        break;

                    case "-":
                        acumuladorNumerico.push(operacao.sub(valor1, valor2));
                        break; 

                    case "x": 
                        acumuladorNumerico.push(operacao.mult(valor1, valor2));
                        break; 

                    case "/":
                        acumuladorNumerico.push(operacao.div(valor1, valor2));
                        break;
            }
        }
    }
        return acumuladorNumerico.pop(); 
    }
}

