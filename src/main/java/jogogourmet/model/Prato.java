package jogogourmet.model;

public class Prato {

    private String value;

    private Prato massa;

    private Prato outros;

    public Prato(String value) {
        super();
        this.value = value;
    }

    public boolean hasMassa() {
        return this.massa != null;
    }

    public boolean hasOutros() {
        return this.outros != null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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