package com.crudcarros;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Modelo> carros = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Carro");
            System.out.println("2. Listar Carros");
            System.out.println("3. Atualizar Carro");
            System.out.println("4. Remover Carro");
            System.out.println("5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    adicionarCarro();
                    break;
                case 2:
                    listarCarros();
                    break;
                case 3:
                    atualizarCarro();
                    break;
                case 4:
                    removerCarro();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void adicionarCarro() {
        System.out.println("Digite o nome do modelo:");
        String nomeModelo = scanner.nextLine();

        System.out.println("Digite o nome do fabricante:");
        String nomeFabricante = scanner.nextLine();
        Fabricante fabricante = new Fabricante(nomeFabricante);

        System.out.println("Digite a cor do carro:");
        String nomeCor = scanner.nextLine();
        Cor cor = new Cor(nomeCor);

        Modelo carro = new Modelo(nomeModelo, fabricante, cor);
        carros.add(carro);
        System.out.println("Carro adicionado com sucesso!");
    }

    private static void listarCarros() {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
        } else {
            for (int i = 0; i < carros.size(); i++) {
                System.out.println((i + 1) + ". " + carros.get(i));
            }
        }
    }

    private static void atualizarCarro() {
        listarCarros();
        if (!carros.isEmpty()) {
            System.out.println("Digite o número do carro que deseja atualizar:");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Consumir a nova linha

            if (index >= 0 && index < carros.size()) {
                System.out.println("Digite o novo nome do modelo:");
                String novoNomeModelo = scanner.nextLine();

                System.out.println("Digite o novo nome do fabricante:");
                String novoNomeFabricante = scanner.nextLine();
                Fabricante novoFabricante = new Fabricante(novoNomeFabricante);

                System.out.println("Digite a nova cor do carro:");
                String novoNomeCor = scanner.nextLine();
                Cor novaCor = new Cor(novoNomeCor);

                Modelo carroAtualizado = new Modelo(novoNomeModelo, novoFabricante, novaCor);
                carros.set(index, carroAtualizado);
                System.out.println("Carro atualizado com sucesso!");
            } else {
                System.out.println("Índice inválido!");
            }
        }
    }

    private static void removerCarro() {
        listarCarros();
        if (!carros.isEmpty()) {
            System.out.println("Digite o número do carro que deseja remover:");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Consumir a nova linha

            if (index >= 0 && index < carros.size()) {
                carros.remove(index);
                System.out.println("Carro removido com sucesso!");
            } else {
                System.out.println("Índice inválido!");
            }
        }
    }
}
