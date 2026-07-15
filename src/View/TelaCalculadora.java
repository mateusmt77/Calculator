package View;

import Controller.ControladorCalculadora;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TelaCalculadora extends JFrame {

    private final JTextField visor = new JTextField();
    private final ControladorCalculadora controlador;
    private static final String[] ROTULOS_BOTOES = {
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "0"
    };

    private static final String[] ROTULOS_OPERADORES = {
            "+", "=", "-", "(", "*",
            ")", "/", ".", "C", "CE",
    };

    public TelaCalculadora(ControladorCalculadora controlador) {
        this.controlador = controlador;
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(30, 30, 30));
    }

    public void exibirInterface() {
        configurarVisor();
        add(criarPainelNumeros(), BorderLayout.CENTER); // -> painel de números
        add(criarPainelOperadores(), BorderLayout.EAST); // -> painel de operadores
        
        JPanel painelInferior = new JPanel(new BorderLayout());
        painelInferior.setBackground(new Color(30, 30, 30));
        painelInferior.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));
        painelInferior.add(criarBotao("Calcs"), BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void configurarVisor() {
        visor.setEditable(false);
        visor.setFont(new Font("Segoe UI", Font.BOLD, 46)); // Fonte moderna e maior
        visor.setBackground(new Color(30, 30, 30));
        visor.setForeground(Color.WHITE); // Texto branco clean
        visor.setHorizontalAlignment(JTextField.RIGHT);
        visor.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Mais margem
        visor.setPreferredSize(new java.awt.Dimension(0, 120)); // Visor um pouco mais alto
        add(visor, BorderLayout.NORTH);
    }

    private JPanel criarPainel(String[] listBottons) {
        JPanel painel = new JPanel();
        painel.setBackground(new Color(30, 30, 30));
        painel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (String botao : listBottons) {
            painel.add(criarBotao(botao));
        }

        return painel;
    }

    private JPanel criarPainelNumeros() {
        JPanel painelNumeros = criarPainel(ROTULOS_BOTOES);
        painelNumeros.setLayout(new GridLayout(0, 3, 5, 5));
        return painelNumeros;
    }

    private JPanel criarPainelOperadores() {
        JPanel painelOperadores = criarPainel(ROTULOS_OPERADORES);
        painelOperadores.setLayout(new GridLayout(0, 2, 5, 5));
        return painelOperadores;
    }

    private JButton criarBotao(String rotulo) {
        JButton botao = new JButton(rotulo);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 24)); // Fonte moderna
        botao.setFocusPainted(false);
        botao.setForeground(determinarCorTextoBotao(rotulo));
        botao.setBackground(determinarCorBotao(rotulo));
        botao.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Deixa os botões com estilo "Flat"
        botao.addActionListener(criarOuvidorBotao(rotulo));
        return botao;
    }

    private Color determinarCorBotao(String rotulo) {
        return switch (rotulo) {
            case "=" -> new Color(0, 120, 215); // Azul elegante (estilo Windows)
            case "+", "-", "*", "/", "(", ")", "C", "CE", "Calcs" -> new Color(45, 45, 45); // Cinza escuro para operadores e ações
            default -> new Color(60, 60, 60); // Cinza mais claro para os números
        };
    }

    private Color determinarCorTextoBotao(String rotulo) {
        return switch (rotulo) {
            case "C", "CE" -> new Color(255, 100, 100); // Vermelho suave para "limpar"
            case "+", "-", "*", "/" -> new Color(100, 180, 255); // Azul suave para operadores matemáticos
            case "(", ")" -> new Color(170, 170, 170); // Cinza claro
            default -> Color.WHITE;
        };
    }

    private ActionListener criarOuvidorBotao(String rotulo) {
        return evento -> {
            switch (rotulo) {
                case "=" -> tratarCalculo();
                case "C", "CE" -> tratarLimpar();
                default -> tratarEntrada(rotulo);
            }
        };
    }

    private void tratarEntrada(String token) {
        if (controlador.anexarToken(token)) {
            visor.setText(controlador.obterExpressaoAtual());
        }
    }

    private void tratarCalculo() {
        try {
            String resultado = controlador.calcularResultado();
            visor.setText(resultado);
        } catch (IllegalArgumentException e) {
            visor.setText("Erro");
            Timer timer = new Timer(2000, evento -> {
                controlador.limpar();
                visor.setText("");
                ((Timer) evento.getSource()).stop();
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void tratarLimpar() {
        controlador.limpar();
        visor.setText("");
    }
}
