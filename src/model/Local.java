package model;

import java.util.ArrayList;

public class Local<TIPO> {
    private String nome;
    private ArrayList<Caminho<TIPO>> caminhosEntrada;
    private ArrayList<Caminho<TIPO>> caminhosSaida;

    public Local(String valor) {
        this.nome = valor;
        this.caminhosEntrada = new ArrayList<Caminho<TIPO>>();
        this.caminhosSaida = new ArrayList<Caminho<TIPO>>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Caminho<TIPO>> getCaminhosEntrada() {
        return caminhosEntrada;
    }

    public void setCaminhosEntrada(ArrayList<Caminho<TIPO>> caminhosEntrada) {
        this.caminhosEntrada = caminhosEntrada;
    }

    public ArrayList<Caminho<TIPO>> getCaminhosSaida() {
        return caminhosSaida;
    }

    public void setCaminhosSaida(ArrayList<Caminho<TIPO>> caminhosSaida) {
        this.caminhosSaida = caminhosSaida;
    }

    public void adicionarCaminhoEntrada(Caminho<TIPO> caminho) {
        this.caminhosEntrada.add(caminho);
    }

    public void adicionarCaminhoSaida(Caminho<TIPO> caminho) {
        this.caminhosSaida.add(caminho);
    }
}