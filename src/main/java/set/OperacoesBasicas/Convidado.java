package main.java.set.OperacoesBasicas;

import java.util.Objects;

public class Convidado {
    //atributos
    private String nome;
    private int codigoConvide;

    //construct

    public Convidado(String nome, int codigoConvide) {
        this.nome = nome;
        this.codigoConvide = codigoConvide;
    }

    //get
    public String getNome() {
        return nome;
    }
    public int getCodigoConvide() {
        return codigoConvide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Convidado convidado)) return false;
        return getCodigoConvide() == convidado.getCodigoConvide();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigoConvide());
    }

    @Override
    public String toString() {
        return "Convidado{" +
                "nome='" + nome + '\'' +
                ", codigoConvide=" + codigoConvide +
                '}';
    }
}
