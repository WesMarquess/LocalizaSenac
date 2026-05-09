package programm;

import model.Algoritmo;
import model.Grafo;
import model.Local;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Grafo<String> grafo = new Grafo<>();
    static Algoritmo<String> algoritmo;

    public static void main(String[] args) {
        inicializaGrafo();
        algoritmo = new Algoritmo<>(grafo);
        menu();
    }

    public static void inicializaGrafo() {
        // vertices
        grafo.adicionarLocal(new Local<>("Portão 1"));
        grafo.adicionarLocal(new Local<>("Biblioteca"));
        grafo.adicionarLocal(new Local<>("P1"));
        grafo.adicionarLocal(new Local<>("Portão 2"));
        grafo.adicionarLocal(new Local<>("Prédio 1"));
        grafo.adicionarLocal(new Local<>("P2"));
        grafo.adicionarLocal(new Local<>("P3"));
        grafo.adicionarLocal(new Local<>("Prédio 2"));
        grafo.adicionarLocal(new Local<>("Portão 3"));

        // arestas
        grafo.adicionarCaminho(2.0, "Portão 1", "Biblioteca");
        grafo.adicionarCaminho(3.0, "Portão 1", "P1");
        grafo.adicionarCaminho(4.0, "Portão 1", "Portão 2");
        grafo.adicionarCaminho(5.0, "P1", "Portão 2");
        grafo.adicionarCaminho(7.0, "Biblioteca", "Portão 2");
        grafo.adicionarCaminho(5.0, "Biblioteca", "Prédio 1");
        grafo.adicionarCaminho(2.0, "Portão 2", "Prédio 1");
        grafo.adicionarCaminho(2.0, "Prédio 1", "P2");
        grafo.adicionarCaminho(3.0, "Portão 2", "P2");
        grafo.adicionarCaminho(4.0, "Prédio 1", "P3");
        grafo.adicionarCaminho(5.0, "P2", "P3");
        grafo.adicionarCaminho(3.0, "Prédio 1", "Prédio 2");
        grafo.adicionarCaminho(6.0, "Prédio 2", "Portão 3");
        grafo.adicionarCaminho(5.0, "P3", "Portão 3");
        grafo.adicionarCaminho(11.0, "Portão 2", "Portão 3");
    }

    public static void menu() {
        System.out.println("Digite a origem:");
        String origem = input.nextLine();

        System.out.println("Digite o destino:");
        String destino = input.nextLine();

        if (origem.trim().equals("") || destino.trim().equals("")) {
            throw new IllegalArgumentException("Digite os valores válidos");
        }
        busca(origem, destino);
    }

    public static void busca(String nomeOrigem, String nomeDestino) {
        algoritmo.dijkistra(nomeOrigem.trim().toLowerCase(), nomeDestino.trim().toLowerCase());
    }
}