package jogogourmet;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import jogogourmet.service.Mensagens;
import jogogourmet.util.Constantes;


public class Jogo {

    private Mensagens mensagemService;

    HashMap<String, String> pratosMassa = new HashMap<>();
    HashMap<String, String> pratosOutros = new HashMap<>();

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
            if(!pratosMassa.isEmpty()){
                verificaMassa();
            }
            verificaPadrao(Constantes.LASAGNA);
        } else {
            if(!pratosOutros.isEmpty()){
                VerificaOutros();
            }
            verificaPadrao(Constantes.BOLO);
        }
        iniciarJogo();
    }

    private void verificaMassa() {
        for (Map.Entry<String, String> prato : pratosMassa.entrySet()) {
            opcaoSelecionada = mensagemService.confirmarPrato(prato.getKey());
            if (opcaoSelecionada == JOptionPane.YES_OPTION) {
                opcaoSelecionada = mensagemService.confirmarPrato(prato.getValue());
                if (opcaoSelecionada == JOptionPane.YES_OPTION) {
                    mensagemService.sucessoMensagem();
                    iniciarJogo();
                }
            }
        }
    }

    private void VerificaOutros() {
        for (Map.Entry<String, String> prato : pratosOutros.entrySet()) {
            opcaoSelecionada = mensagemService.confirmarPrato(prato.getKey());
            if (opcaoSelecionada == JOptionPane.YES_OPTION) {
                opcaoSelecionada = mensagemService.confirmarPrato(prato.getValue());
                if (opcaoSelecionada == JOptionPane.YES_OPTION) {
                    mensagemService.sucessoMensagem();
                    iniciarJogo();
                }
            }
        }
    }

    private void verificaPadrao(String pratoPadrao) {
        opcaoSelecionada = mensagemService.confirmarPrato(pratoPadrao);
        if (opcaoSelecionada == JOptionPane.YES_OPTION) {
            mensagemService.sucessoMensagem();
            iniciarJogo();
        }

        novoPrato(pratoPadrao);
    }

    private void novoPrato(String pratoPadrao) {
        String novoPrato = mensagemService.caixaDeInputPrato(Constantes.QUAL_PRATO, Constantes.DESISTO);
        if (novoPrato == null) {
            sairJogo();
        } else if (novoPrato.isEmpty()){
            mensagemService.invalidoMensagem();
            novoPrato(pratoPadrao);
        }

        String novoTipo = mensagemService.caixaDeInputTipo(novoPrato, pratoPadrao, Constantes.COMPLETE);

        if (pratoPadrao.equals(Constantes.LASAGNA)) {
            pratosMassa.put(novoTipo, novoPrato);
        } else {
            pratosOutros.put(novoTipo, novoPrato);
        }

        iniciarJogo();
    }
}