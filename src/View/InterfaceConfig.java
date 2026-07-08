package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Validations;
import Model.Data_Operations;

public class InterfaceConfig extends JFrame {

    public JFrame start;
    public JTextField display = new JTextField();
    private final Data_Operations dataOperations = new Data_Operations();
    private final Validations entradaCalculadora = new Validations(dataOperations);

    public void CalculadoraGUI() {
        start = new JFrame("CALCULADORA");
        start.setDefaultCloseOperation(EXIT_ON_CLOSE);
        start.setSize(600, 600);
        start.setLayout(new java.awt.BorderLayout(10, 10));
        start.getContentPane().setBackground(new Color(30, 30, 30));

        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 28)); 
        display.setBackground(new Color(20, 20, 20));
        display.setForeground(new Color(0, 255, 120));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        display.setPreferredSize(new java.awt.Dimension(0, 90));
        start.add(display, java.awt.BorderLayout.NORTH);

        JPanel painel = new JPanel(new GridLayout(5, 4, 8, 8));
        painel.setBackground(new Color(30, 30, 30));
        painel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton botao0 = new JButton("0");
        styleButton(botao0);
        botao0.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao0);

        JButton botao1 = new JButton("1");
        styleButton(botao1);
        botao1.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao1);

        JButton botao2 = new JButton("2");
        styleButton(botao2);
        botao2.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao2);

        JButton botao3 = new JButton("3");
        styleButton(botao3);
        botao3.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao3);

        JButton botao4 = new JButton("4");
        styleButton(botao4);
        botao4.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao4);

        JButton botao5 = new JButton("5");
        styleButton(botao5);
        botao5.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao5);

        JButton botao6 = new JButton("6");
        styleButton(botao6);
        botao6.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao6);

        JButton botao7 = new JButton("7");
        styleButton(botao7);
        botao7.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao7);

        JButton botao8 = new JButton("8");
        styleButton(botao8);
        botao8.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao8);

        JButton botao9 = new JButton("9");
        styleButton(botao9);
        botao9.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao9);

        JButton botaoAdd = new JButton("+");
        styleButton(botaoAdd);
        botaoAdd.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoAdd);

        JButton botaoSub = new JButton("-");
        styleButton(botaoSub);
        botaoSub.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoSub);

        JButton botaoMult = new JButton("x");
        styleButton(botaoMult);
        botaoMult.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoMult);

        JButton botaoDiv = new JButton("/");
        styleButton(botaoDiv);
        botaoDiv.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoDiv);

        JButton botaoPar1 = new JButton("(");
        styleButton(botaoPar1);
        botaoPar1.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoPar1);

        JButton botaoPar2 = new JButton(")");
        styleButton(botaoPar2);
        botaoPar2.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoPar2);

        JButton botaoPonto = new JButton(".");
        styleButton(botaoPonto);
        botaoPonto.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoPonto);

        JButton botaoIgual = new JButton("=");
        styleButton(botaoIgual, new Color(0, 180, 255));
        botaoIgual.addActionListener(event -> handleResultado(event.getActionCommand()));
        painel.add(botaoIgual);

        JButton botaoLimparTela = new JButton("C");
        styleButton(botaoLimparTela, new Color(255, 120, 120));
        botaoLimparTela.addActionListener(event -> handleCleanScreen(event.getActionCommand()));
        painel.add(botaoLimparTela);

        start.add(painel, java.awt.BorderLayout.CENTER);
        start.setLocationRelativeTo(null);
        start.setVisible(true);
    } 

    private void styleButton(JButton button) {
        styleButton(button, new Color(80, 80, 80));
    }

    private void styleButton(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
    }

    public void handleEntrada(String entrada) {
        switch (entrada) {
            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "x", "/", "(", ")", "." -> {
                entradaCalculadora.armazenandoValores(entrada);
                display.setText(display.getText() + entrada);
            }
        }
    }

    public void handleResultado(String sinalIgual) {
        try {
            double resultadoFinal = dataOperations.retornoExpressao();
            display.setText(String.valueOf(resultadoFinal));

        } catch (IllegalArgumentException e) {
            ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

            Runnable limparDisplay = () -> {
                display.setText("Erro!");
                dataOperations.limpandoExpressao();
            };

            timer.schedule(limparDisplay, 3, TimeUnit.SECONDS);
            display.setText("");
        }
    }

    public void handleCleanScreen(String cleanBotton) {
        dataOperations.limpandoExpressao();
        display.setText("");
    }
}
