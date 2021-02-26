package jogogourmet.service;

import jogogourmet.util.Constantes;

import javax.swing.JOptionPane;

public class Mensagens {

    public int primeiraMensagem() {
        return JOptionPane.showConfirmDialog(null, Constantes.PENSE_EM_UM_PRATO, Constantes.TITULO,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    public void ultimaMensagem() {
        JOptionPane.showConfirmDialog(null, Constantes.FIM_DE_JOGO, Constantes.TITULO,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    public int sairMensagem() {
        String mensagem = Constantes.SAIR;
        return JOptionPane.showConfirmDialog(null, mensagem, null, JOptionPane.YES_NO_OPTION);
    }

    public int confirmarPrato(String prato) {
        String mensagem = String.format(Constantes.PRATO_QUE_PENSOU, prato);
        return JOptionPane.showConfirmDialog(null, mensagem, null, JOptionPane.YES_NO_OPTION);
    }

    public String caixaDeInputPrato(String mensagem, String titulo) {
        return JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
    }

    public String caixaDeInputTipo(String prato, String pratoPadrao, String titulo) {
        String mensagem = String.format(Constantes.QUAL_TIPO, prato, pratoPadrao);
        return JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
    }

    public void sucessoMensagem() {
        JOptionPane.showMessageDialog(null, Constantes.SUCESSO);
    }

    public void invalidoMensagem() {
        JOptionPane.showMessageDialog(null, Constantes.INVALIDO);
    }


}
