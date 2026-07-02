package Model;

import java.util.Map;
import java.util.ArrayList;
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
}
