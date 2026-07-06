package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Validations;

public class InterfaceConfig extends JFrame{

    public JFrame start;
    public JTextField display = new JTextField(); 

    public void CalculadoraGUI(){

        start = new JFrame("CALCULADORA");
        start.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        start.setSize(400, 400);
        start.setLayout(new java.awt.BorderLayout()); 

        // Display
        display.setEditable(false);
        display.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
        display.setBackground(java.awt.Color.BLACK);
        display.setForeground(java.awt.Color.GREEN);
        start.add(display, java.awt.BorderLayout.NORTH); 

        // Painel de botões
        JPanel painel = new JPanel(new java.awt.GridLayout(4, 4, 5, 5));

        // Números
        JButton botao0 = new JButton("0");
        botao0.setBackground(java.awt.Color.GRAY);
        botao0.setForeground(java.awt.Color.WHITE);
        painel.add(botao0);

        JButton botao1 = new JButton("1");
        botao1.setBackground(java.awt.Color.GRAY);
        botao1.setForeground(java.awt.Color.WHITE);
        painel.add(botao1);

        JButton botao2 = new JButton("2");
        botao2.setBackground(java.awt.Color.GRAY);
        botao2.setForeground(java.awt.Color.WHITE);
        painel.add(botao2);

        JButton botao3 = new JButton("3");
        botao3.setBackground(java.awt.Color.GRAY);
        botao3.setForeground(java.awt.Color.WHITE);
        painel.add(botao3);

        JButton botao4 = new JButton("4");
        botao4.setBackground(java.awt.Color.GRAY);
        botao4.setForeground(java.awt.Color.WHITE);
        painel.add(botao4);

        JButton botao5 = new JButton("5");
        botao5.setBackground(java.awt.Color.GRAY);
        botao5.setForeground(java.awt.Color.WHITE);
        painel.add(botao5);

        JButton botao6 = new JButton("6");
        botao6.setBackground(java.awt.Color.GRAY);
        botao6.setForeground(java.awt.Color.WHITE);
        painel.add(botao6);

        JButton botao7 = new JButton("7");
        botao7.setBackground(java.awt.Color.GRAY);
        botao7.setForeground(java.awt.Color.WHITE);
        painel.add(botao7);

        JButton botao8 = new JButton("8");
        botao8.setBackground(java.awt.Color.GRAY);
        botao8.setForeground(java.awt.Color.WHITE);
        painel.add(botao8);
        
        JButton botao9 = new JButton("9");
        botao9.setBackground(java.awt.Color.GRAY);
        botao9.setForeground(java.awt.Color.WHITE);
        painel.add(botao9);

        // Operadores
        JButton botaoAdd = new JButton("+");
        botaoAdd.setBackground(java.awt.Color.GRAY);
        botaoAdd.setForeground(java.awt.Color.WHITE);
        painel.add(botaoAdd);

        JButton botaoSub = new JButton("-");
        botaoSub.setBackground(java.awt.Color.GRAY);
        botaoSub.setForeground(java.awt.Color.WHITE);
        painel.add(botaoSub); 

        JButton botaoMult = new JButton("x");
        botaoMult.setBackground(java.awt.Color.GRAY);
        botaoMult.setForeground(java.awt.Color.WHITE);
        painel.add(botaoMult);

        JButton botaoDiv = new JButton("/");
        botaoDiv.setBackground(java.awt.Color.GRAY);
        botaoDiv.setForeground(java.awt.Color.WHITE);
        painel.add(botaoDiv);
        
        JButton botaoPar1 = new JButton("(");
        botaoPar1.setBackground(java.awt.Color.GRAY);
        botaoPar1.setForeground(java.awt.Color.WHITE);
        painel.add(botaoPar1); 

        JButton botaoPar2 = new JButton(")");
        botaoPar2.setBackground(java.awt.Color.GRAY);
        botaoPar2.setForeground(java.awt.Color.WHITE);
        painel.add(botaoPar2); 

        JButton botaoPonto = new JButton(".");
        botaoPonto.setBackground(java.awt.Color.GRAY);
        botaoPonto.setForeground(java.awt.Color.WHITE);
        painel.add(botaoPonto);  

        start.add(painel, java.awt.BorderLayout.CENTER);

    }
        ActionListener listenerNum;  

        public void handleNumeros(String entrada){ Validations entradaCalculadora = new Validations();

            switch (entrada) {

                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "x", "/", "(", ")", "." -> {
                    entradaCalculadora.armazenandoValores(entrada); 
                    display.setText(display.getText() + entrada);
                } 
        }
    }
} 