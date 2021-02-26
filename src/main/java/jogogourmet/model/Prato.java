package jogogourmet.model;

public class Prato {

    private String valor;

    private Prato massa;

    private Prato outros;

    public Prato(String valor) {
        super();
        this.valor = valor;
    }

    public boolean hasMassa() {
        return this.massa != null;
    }

    public boolean hasOutros() {
        return this.outros != null;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Prato getMassa() {
        return massa;
    }

    public void setMassa(Prato massa) {
        this.massa = massa;
    }

    public Prato getOutros() {
        return outros;
    }

    public void setOutros(Prato outros) {
        this.outros = outros;
    }

}