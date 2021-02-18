package jogogourmet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import jogogourmet.service.Mensagens;
import jogogourmet.util.Constantes;


public class Jogo {

    private Mensagens mensagemService;

    ArrayList<String> pratosMassa = new ArrayList(Arrays.asList(Constantes.LASAGNA));
    ArrayList<String> pratosOutros = new ArrayList(Arrays.asList(Constantes.BOLO));

    private Integer opcaoSelecionada = null;

    public void iniciarJogo() {
        mensagemService = new Mensagens();
        opcaoSelecionada = mensagemService.primeiraMensagem();
        if (opcaoSelecionada == JOptionPane.OK_OPTION) {
            iniciarPerguntas();
        }
        sairJogo();
    }
    public void sairJogo() {
        opcaoSelecionada = mensagemService.sairMensagem();
        if (opcaoSelecionada == JOptionPane.OK_OPTION) {
            mensagemService.ultimaMensagem();
            System.exit(0);
        } else {
            iniciarJogo();
        }
    }

    private void iniciarPerguntas() {

        opcaoSelecionada = mensagemService.confirmarPrato(Constantes.MASSA);
        if (opcaoSelecionada == JOptionPane.YES_OPTION) {
            verificaMassa();
        } else {
            VerificaOutros();
        }
        iniciarJogo();
    }

    private void verificaMassa() {
        for (String prato : pratosMassa) {
            opcaoSelecionada = mensagemService.confirmarPrato(prato);
            if (opcaoSelecionada == JOptionPane.YES_OPTION) {
                mensagemService.sucessoMensagem();
                iniciarJogo();
            }
        }
        novoPrato(Constantes.MASSA);
    }

    private void VerificaOutros() {
        for (String prato : pratosOutros) {
            opcaoSelecionada = mensagemService.confirmarPrato(prato);
            if (opcaoSelecionada == JOptionPane.YES_OPTION) {
                mensagemService.sucessoMensagem();
                iniciarJogo();
            }
        }
        novoPrato(Constantes.OUTROS);
    }

    private void novoPrato(String tipo) {
        String novoPrato = mensagemService.caixaDeInput(Constantes.QUAL_PRATO, Constantes.DESISTO);
        if (novoPrato == null) {
            sairJogo();
        } else if (novoPrato.isEmpty()){
            mensagemService.invalidoMensagem();
            novoPrato(tipo);
        }

        if (tipo.equals(Constantes.MASSA)) {
            pratosMassa.add(novoPrato);
        } else {
            pratosOutros.add(novoPrato);
        }

        iniciarJogo();
    }
}