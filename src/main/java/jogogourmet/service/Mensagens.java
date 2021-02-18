package jogogourmet.service;

import jogogourmet.util.Constantes;

import javax.swing.JOptionPane;

public class Mensagens {

    public int primeiraMensagem() {
        return JOptionPane.showConfirmDialog(null, Constantes.PENSE_EM_UM_PRATO, Constantes.TITULO,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    public int ultimaMensagem() {
        return JOptionPane.showConfirmDialog(null, Constantes.FIM_DE_JOGO, Constantes.TITULO,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    public int sairMensagem() {
        String message = Constantes.SAIR;
        return JOptionPane.showConfirmDialog(null, message, null, JOptionPane.YES_NO_OPTION);
    }

    public int confirmarPrato(String prato) {
        String message = String.format(Constantes.PRATO_QUE_PENSOU, prato);
        return JOptionPane.showConfirmDialog(null, message, null, JOptionPane.YES_NO_OPTION);
    }

    public String caixaDeInput(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
    }

    public void sucessoMensagem() {
        JOptionPane.showMessageDialog(null, Constantes.SUCESSO);
    }

    public void invalidoMensagem() {
        JOptionPane.showMessageDialog(null, Constantes.INVALIDO);
    }


}
