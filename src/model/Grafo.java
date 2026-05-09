package model;

import java.util.ArrayList;

public class Grafo<TIPO> {
    private ArrayList<Local<TIPO>> locais;
    private ArrayList<Caminho<TIPO>> caminhos;

    public Grafo() {
        this.locais = new ArrayList<Local<TIPO>>();
        this.caminhos = new ArrayList<Caminho<TIPO>>();

    }

    public ArrayList<Local<TIPO>> getLocais() {
        return locais;
    }

    public ArrayList<Caminho<TIPO>> getCaminhos() {
        return caminhos;
    }

    public void adicionarLocal(Local<TIPO> local) {
        this.locais.add(local);
    }

    public void adicionarCaminho(Double peso, String localInicio, String localFim) {
        Local<TIPO> inicio = this.getLocal(localInicio);
        Local<TIPO> fim = this.getLocal(localFim);

        // cerifica se os locais existem
        if (inicio == null || fim == null) {
            return;
        }

        // caminho de ida
        Caminho<TIPO> caminhoIda = new Caminho<TIPO>(peso, inicio, fim);
        inicio.adicionarCaminhoSaida(caminhoIda);
        fim.adicionarCaminhoEntrada(caminhoIda);
        this.caminhos.add(caminhoIda);

        // caminho de volta
        Caminho<TIPO> caminhoVolta = new Caminho<TIPO>(peso, fim, inicio);
        fim.adicionarCaminhoSaida(caminhoVolta);
        inicio.adicionarCaminhoEntrada(caminhoVolta);
        this.caminhos.add(caminhoVolta);
    }

    public Local<TIPO> getLocal(String nome) {
        for (Local<TIPO> local : locais) {
            if (local.getNome().equalsIgnoreCase(nome.trim())) {
                return local;
            }
        }
        return null;
    }
}