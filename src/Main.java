import Controller.ControladorCalculadora;
import Model.ModeloCalculadora;
import View.TelaCalculadora;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ControladorCalculadora controlador = new ControladorCalculadora(new ModeloCalculadora());
            TelaCalculadora tela = new TelaCalculadora(controlador);
            tela.exibirInterface();
        });
    }
}
