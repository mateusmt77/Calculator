package Controller;

import Model.Data_Operations;

public class Validations {

    private final Data_Operations transferencia;

    public Validations(Data_Operations transferencia) {
        this.transferencia = transferencia;
    }

    public void armazenandoValores(String entrada) {
        String entradaLimpa = entrada.replace(" ", "");
        transferencia.validandoEntrada(entradaLimpa.trim());
    }
}
