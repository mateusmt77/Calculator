package Controller;

import Model.Data_Operations;

public class Validations { 

    public void armazenandoValores(String entrada){ 

        if (entrada.contains(" ")){ 
            entrada.replaceAll(" ", "");  

            Data_Operations transferencia = new Data_Operations();
            transferencia.validandoEntrada(entrada.trim());  

        }  else {
            Data_Operations transferencia = new Data_Operations();
            transferencia.validandoEntrada(entrada.trim());  
        }
 
    }
}
