package model;

import java.util.ArrayList;

public class Algoritmo<TIPO> {
    private Grafo<TIPO> grafo;

    public Algoritmo(Grafo<TIPO> grafo) {
        this.grafo = grafo;
    }

    public int distanciaMinima(ArrayList<Double> distancias, boolean[] visitados) {
        double menor = Double.MAX_VALUE;
        int indice = -1;

        for (int i = 0; i < distancias.size(); i++) {
            if (!visitados[i] && distancias.get(i) < menor) {
                menor = distancias.get(i);
                indice = i;
            }
        }
        return indice;
    }

    public void dijkistra(String nomeOrigem, String nomeDestino) {

        Local<TIPO> origem = grafo.getLocal(nomeOrigem);
        Local<TIPO> destino = grafo.getLocal(nomeDestino);

        if (origem == null || destino == null) {
            System.out.println("Origem ou destino não encontrados. Verifique com a ADM para adicionar o caminho.");
            return;
        }

        ArrayList<Local<TIPO>> locais = grafo.getLocais();
        int tamanho = locais.size();

        ArrayList<Double> distancias = new ArrayList<>();
        ArrayList<Integer> anteriores = new ArrayList<>();
        boolean[] visitados = new boolean[tamanho];

        // Inicializa as estruturas com valores infinitos
        for (int i = 0; i < tamanho; i++) {
            distancias.add(Double.MAX_VALUE);
            anteriores.add(-1);
            visitados[i] = false;
        }

        int indiceOrigem = locais.indexOf(origem);
        int indiceDestino = locais.indexOf(destino);

        distancias.set(indiceOrigem, 0.0);

        while (true) {

            int atual = distanciaMinima(distancias, visitados);

            if (atual == -1) {
                break;
            }

            visitados[atual] = true;
            Local<TIPO> localAtual = locais.get(atual);

            for (Caminho<TIPO> caminho : localAtual.getCaminhosSaida()) {
                int vizinho = locais.indexOf(caminho.getFim());

                if (visitados[vizinho]) {
                    continue;
                }

                double novaDistancia = distancias.get(atual) + caminho.getDistancia();

                if (novaDistancia < distancias.get(vizinho)) {
                    distancias.set(vizinho, novaDistancia);
                    anteriores.set(vizinho, atual);
                }
            }
        }

        ArrayList<String> caminhoFinal = new ArrayList<>();

        int atual = indiceDestino;

        //Reconstroi o caminho do destino até a origem e adiciona no início da lista
        while (atual != -1) {
            caminhoFinal.add(0, locais.get(atual).getNome());
            atual = anteriores.get(atual);
        }
        mostrarCaminho(caminhoFinal, nomeOrigem, nomeDestino, distancias.get(indiceDestino));
    }

    public void mostrarCaminho(ArrayList<String> caminhoFinal, String origem, String destino, Double distancia) {
        System.out.println("Menor caminho entre " + origem + " e " + destino + ":");
        for (int i = 0; i < caminhoFinal.size(); i++) {
            System.out.print(caminhoFinal.get(i));
            if (i < caminhoFinal.size() - 1) {
                System.out.print(" -> " + " ");
            }
        }
        System.out.println();
        System.out.println("Distância total: " + distancia);
    }
}
