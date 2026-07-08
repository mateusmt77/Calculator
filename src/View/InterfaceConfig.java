package View;

import java.awt.event.ActionListener;
import java.sql.Time;
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

    ActionListener listenerNum;

    public void CalculadoraGUI() {
        start = new JFrame("CALCULADORA");
        start.setDefaultCloseOperation(EXIT_ON_CLOSE);
        start.setSize(400, 400);
        start.setLayout(new java.awt.BorderLayout());

        display.setEditable(false);
        display.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
        display.setBackground(java.awt.Color.BLACK);
        display.setForeground(java.awt.Color.GREEN);
        start.add(display, java.awt.BorderLayout.NORTH);

        JPanel painel = new JPanel(new java.awt.GridLayout(4, 4, 5, 5));

        JButton botao0 = new JButton("0");
        botao0.setBackground(java.awt.Color.GRAY);
        botao0.setForeground(java.awt.Color.WHITE);
        botao0.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao0);

        JButton botao1 = new JButton("1");
        botao1.setBackground(java.awt.Color.GRAY);
        botao1.setForeground(java.awt.Color.WHITE);
        botao1.addActionListener(event -> handleEntrada(event.getActionCommand())); 
        painel.add(botao1);

        JButton botao2 = new JButton("2");
        botao2.setBackground(java.awt.Color.GRAY);
        botao2.setForeground(java.awt.Color.WHITE);
        botao2.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao2);

        JButton botao3 = new JButton("3");
        botao3.setBackground(java.awt.Color.GRAY);
        botao3.setForeground(java.awt.Color.WHITE);
        botao3.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao3);

        JButton botao4 = new JButton("4");
        botao4.setBackground(java.awt.Color.GRAY);
        botao4.setForeground(java.awt.Color.WHITE);
        botao4.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao4);

        JButton botao5 = new JButton("5");
        botao5.setBackground(java.awt.Color.GRAY);
        botao5.setForeground(java.awt.Color.WHITE);
        botao5.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao5);

        JButton botao6 = new JButton("6");
        botao6.setBackground(java.awt.Color.GRAY);
        botao6.setForeground(java.awt.Color.WHITE);
        botao6.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao6);

        JButton botao7 = new JButton("7");
        botao7.setBackground(java.awt.Color.GRAY);
        botao7.setForeground(java.awt.Color.WHITE);
        botao7.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao7);

        JButton botao8 = new JButton("8");
        botao8.setBackground(java.awt.Color.GRAY);
        botao8.setForeground(java.awt.Color.WHITE);
        botao8.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao8);

        JButton botao9 = new JButton("9");
        botao9.setBackground(java.awt.Color.GRAY);
        botao9.setForeground(java.awt.Color.WHITE);
        botao9.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botao9);

        JButton botaoAdd = new JButton("+");
        botaoAdd.setBackground(java.awt.Color.GRAY);
        botaoAdd.setForeground(java.awt.Color.WHITE);
        botaoAdd.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoAdd);

        JButton botaoSub = new JButton("-");
        botaoSub.setBackground(java.awt.Color.GRAY);
        botaoSub.setForeground(java.awt.Color.WHITE);
        botaoSub.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoSub);

        JButton botaoMult = new JButton("x");
        botaoMult.setBackground(java.awt.Color.GRAY);
        botaoMult.setForeground(java.awt.Color.WHITE);
        botaoMult.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoMult);

        JButton botaoDiv = new JButton("/");
        botaoDiv.setBackground(java.awt.Color.GRAY);
        botaoDiv.setForeground(java.awt.Color.WHITE);
        botaoDiv.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoDiv);

        JButton botaoPar1 = new JButton("(");
        botaoPar1.setBackground(java.awt.Color.GRAY);
        botaoPar1.setForeground(java.awt.Color.WHITE);
        botaoPar1.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoPar1);

        JButton botaoPar2 = new JButton(")");
        botaoPar2.setBackground(java.awt.Color.GRAY);
        botaoPar2.setForeground(java.awt.Color.WHITE);
        botaoPar2.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoPar2);

        JButton botaoPonto = new JButton(".");
        botaoPonto.setBackground(java.awt.Color.GRAY);
        botaoPonto.setForeground(java.awt.Color.WHITE);
        botaoPonto.addActionListener(event -> handleEntrada(event.getActionCommand()));
        painel.add(botaoPonto); 

        JButton botaoIgual = new JButton("=");
        botaoIgual.setBackground(java.awt.Color.GRAY);
        botaoIgual.setForeground(java.awt.Color.WHITE);
        botaoIgual.addActionListener(event -> handleResultado(event.getActionCommand()));  
        painel.add(botaoIgual);

        JButton botaoLimparTela = new JButton("C");
        botaoLimparTela.setBackground(java.awt.Color.GRAY);
        botaoLimparTela.setForeground(java.awt.Color.WHITE);
        botaoLimparTela.addActionListener(event -> handleCleanScreen(event.getActionCommand())); 
        painel.add(botaoLimparTela); 

        start.add(painel, java.awt.BorderLayout.CENTER);
    } 

    public void handleEntrada(String entrada) {
        Validations entradaCalculadora = new Validations(); 

        switch (entrada) {
            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "x", "/", "(", ")", "." -> {
                entradaCalculadora.armazenandoValores(entrada);
                display.setText(display.getText() + entrada);
            }
        }
    }

    public void handleResultado(String sinalIgual) {
        Data_Operations op = new Data_Operations();

        try {
            double resultadoFinal = op.retornoExpressao();
            display.setText(String.valueOf(resultadoFinal));

        } catch (IllegalArgumentException e) {
            ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

            Runnable limparDisplay = () -> {
                display.setText("Erro!");
                op.limpandoExpressao();
            };

            timer.schedule(limparDisplay, 3, TimeUnit.SECONDS); 
            display.setText(""); 
        }
    } 

    public void handleCleanScreen(String cleanBotton){
        Data_Operations limpeza = new Data_Operations(); 
        limpeza.limpandoExpressao(); 
        display.setText(""); 
    }
}
