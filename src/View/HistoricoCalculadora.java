package View;

import java.util.Deque;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class HistoricoCalculadora extends JDialog {

    DefaultListModel<String> listaOperacoes;
    JList<String> listaHistorico;

    HistoricoCalculadora(JFrame janelaMain) {
        super(janelaMain, "Histórico de Cálculos", false);
        setSize(300, 400);
        setLocationRelativeTo(janelaMain);

        listaOperacoes = new DefaultListModel<>();
        listaHistorico = new JList<>(listaOperacoes);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.add(new JScrollPane(listaHistorico));
    }

    public void preencherHistoricoCalculadora(Deque<String> operacoesFeitas) {

        listaOperacoes.clear();

        for (String operacao : operacoesFeitas) {
            if ((!operacao.isEmpty()) || (!operacao.isBlank())) {
                listaOperacoes.addElement(operacao);
            }
        }
    }
}
