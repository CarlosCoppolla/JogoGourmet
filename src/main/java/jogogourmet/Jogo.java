package jogogourmet;

import javax.swing.JOptionPane;

import jogogourmet.model.Prato;
import jogogourmet.service.Mensagens;
import jogogourmet.util.Constantes;


public class Jogo {

    private Mensagens mensagemService;

    private final Prato pratos;

    private Integer opcaoSelecionada = null;

    public Jogo() {
        pratos = new Prato(Constantes.MASSA);
        pratos.setMassa(new Prato(Constantes.LASAGNA));
        pratos.setOutros(new Prato(Constantes.BOLO));
    }

    public void iniciarJogo() {
        mensagemService = new Mensagens();
        opcaoSelecionada = mensagemService.primeiraMensagem();
        if (opcaoSelecionada == JOptionPane.OK_OPTION) {
            iniciarPerguntas();
        }
        sairJogo();
    }

    private void sairJogo() {
        opcaoSelecionada = mensagemService.sairMensagem();
        if (opcaoSelecionada == JOptionPane.OK_OPTION) {
            mensagemService.ultimaMensagem();
            System.exit(0);
        } else {
            iniciarJogo();
        }
    }

    private void iniciarPerguntas() {
        opcaoSelecionada = mensagemService.confirmarPrato(pratos.getValor());
        if (opcaoSelecionada == JOptionPane.YES_OPTION) {
            verificaPratos(pratos.getMassa());
        } else if (opcaoSelecionada == JOptionPane.CLOSED_OPTION) {
            sairJogo();
        } else {
            verificaPratos(pratos.getOutros());
        }
        iniciarJogo();
    }

    private void verificaPratos(Prato prato) {
        opcaoSelecionada = mensagemService.confirmarPrato(prato.getValor());
        if (opcaoSelecionada == JOptionPane.YES_OPTION && !prato.hasMassa() && !prato.hasOutros()) {
            mensagemService.sucessoMensagem();
            iniciarJogo();
        } else if (opcaoSelecionada == JOptionPane.CLOSED_OPTION) {
            sairJogo();
        } else {
            if (opcaoSelecionada == JOptionPane.YES_OPTION && prato.hasOutros()) {
                verificaPratos(prato.getOutros());
            } else if (opcaoSelecionada == JOptionPane.NO_OPTION && prato.hasMassa()) {
                verificaPratos(prato.getMassa());
            } else {
                novoPrato(prato);
            }
        }
    }

    private void novoPrato(Prato prato) {
        String novoPrato = mensagemService.caixaDeInputPrato(Constantes.QUAL_PRATO, Constantes.DESISTO);
        if (novoPrato == null) {
            sairJogo();
        } else if (novoPrato.isEmpty()){
            mensagemService.invalidoMensagem();
            novoPrato(prato);
        }
        String novoTipo = mensagemService.caixaDeInputTipo(novoPrato, pratos.getValor(), Constantes.COMPLETE);

        String ultimoPrato = prato.getValor();
        prato.setMassa(new Prato(ultimoPrato));
        prato.setOutros(new Prato(novoPrato));
        prato.setValor(novoTipo);

        iniciarJogo();
    }
}