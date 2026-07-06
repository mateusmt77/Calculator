package Model;

import java.util.Map;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EvalExpressao { 

    static Map <String, Integer> operadoresPrecedencia = Map.of(
        "+", 1, "-", 1, "x", 2, "/", 2); 

    static List <String> token(String expressaoCompleta){

        expressaoCompleta = expressaoCompleta.replaceAll(" ", "");
        List <String> tkn = new ArrayList<>(); 

        for(int i = 0; i < expressaoCompleta.length(); i++){
            char c = expressaoCompleta.charAt(i);  

            if((Character.isDigit(c)) || (c == '.')){
                int x = i; 
                while(x < expressaoCompleta.length() && (Character.isDigit(expressaoCompleta.charAt(x))||expressaoCompleta.charAt(x)=='.')) x++;
                tkn.add(expressaoCompleta.substring(i, x)); 
            } else{
                if(c == '-' && (i == 0 || "+-*/^(".indexOf(expressaoCompleta.charAt(i-1))>=0)){ 
                    int x = i + 1; 
                    if(x < expressaoCompleta.length() && (Character.isDigit(expressaoCompleta.charAt(x))||expressaoCompleta.charAt(x)=='.')){
                        while(x < expressaoCompleta.length() && (Character.isDigit(expressaoCompleta.charAt(x))||expressaoCompleta.charAt(x)=='.')) x++;
                        tkn.add(expressaoCompleta.substring(i,x)); i=x; 
                } else{
                    tkn.add("-1"); tkn.add("*");  
                } 

                tkn.add(String.valueOf(c)); i++;
            }
        }
    }

    return tkn; 
    
    }

    static List <String> toRpn(List <String> tokens){
        LinkedList <String> saida = new LinkedList<>();
        LinkedList <String> operadores = new LinkedList<>(); 

        for (String tokenAtual : tokens) {
            Predicate <String> isNumber = valor -> valor.matches("-?\\d+(\\.\\d+)?");
            Predicate <String> isBracketLeft = valor -> valor.equals("(");
            Predicate <String> isBracketRight = valor -> valor.equals(")"); 

            if(isNumber.test(tokenAtual)){
                saida.add(tokenAtual); 

            } else if (isBracketLeft.test(tokenAtual)){ 
                operadores.add(tokenAtual); 

            } else if (isBracketRight.test(tokenAtual)){
                while (!operadores.isEmpty() || (!operadores.peek().equals("("))) { 
                    saida.add(operadores.pop()); 
  
                }

            }  else{ 

            }
        
    }
            
        }

        
}
