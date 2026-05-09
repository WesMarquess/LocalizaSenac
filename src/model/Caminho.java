package model;

public class Caminho<TIPO> {
    private Double distancia;
    private Local<TIPO> inicio;
    private Local<TIPO> fim;

    public Caminho(Double distancia, Local<TIPO> inicio, Local<TIPO> fim) {
        this.distancia = distancia;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Local<TIPO> getInicio() {
        return inicio;
    }

    public void setInicio(Local<TIPO> inicio) {
        this.inicio = inicio;
    }

    public Local<TIPO> getFim() {
        return fim;
    }

    public void setFim(Local<TIPO> fim) {
        this.fim = fim;
    }
}