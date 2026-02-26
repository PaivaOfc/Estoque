package org.example;

import entities.Product;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String name;
        String description;
        double price;
        int stock;
        int opcao;

        ArrayList<Product> produtos = new ArrayList<>();
        do {

            IO.println("Sistema de cadastro de Estoque!");
            IO.println("Selecione a opção que deseja:");
            IO.println("1 - Verificar Estoque.");
            IO.println("2 - Adicionar produto.");
            IO.println("3 - Remover produto.");
            IO.println("4 - Adicionar Estoque");
            IO.println("0 - Finalizar programa.");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    IO.println("Produtos cadastrados:");
                    for (Product p : produtos) {
                        IO.println(p.getId() + " | Produto: " + p.getName() + " | Descrição: " + p.getDescription() + " | Preço: " + p.getPrice() + " | Quantidade de stock: " + p.getStock());
                    }

                    break;
                case 2:
                    do {
                        IO.println("Insira o nome do produto:");
                        name = sc.nextLine();
                    } while (name.isEmpty());
                    do {
                        IO.println("Insira uma descrição:");
                        description = sc.nextLine();
                    } while (description.isEmpty());
                    do {
                        IO.println("Insira o preço:");
                        price = sc.nextDouble();
                    } while (price <= 0);
                    do {
                        IO.println("Insira a quantidade de estoque:");
                        stock = sc.nextInt();
                    } while (stock <= 0);


                    produtos.add(new Product(produtos.size() +1, name, description, price, stock));
                    IO.println("Novo produto cadastrado: ");
                    IO.println(produtos.size() +1 + " | Produto: " + name + " | Descrição: " + description + " | Preço: " + price + " | Quantidade de stock: " + stock);
                    break;
                case 3:
                    IO.println("Produtos cadastrados:");
                    for (Product p: produtos) {
                        IO.println(p.getId() + " | Produto: " + p.getName() + " | Descrição: " + p.getDescription() + " | Preço: " + p.getPrice() + " | Quantidade de stock: " + p.getStock());
                    }
                    IO.println("\n Qual produto deseja remover? insira o ID:");
                    int remove = sc.nextInt();
                    //Object element = produtos.remove(remove+1);
                    //IO.println(element);
                    for (int i = 0; i < produtos.size(); i++) {
                        Product produto = produtos.get(i);

                        if (produto.getId() == remove) {
                            produtos.remove(produto);
                            IO.println("Produto " + produto.getName() + " removido com sucesso!");
                            break;
                        }
                    }
                case 4:
                    IO.println("Produtos cadastrados:");
                    for (Product p: produtos) {
                        IO.println(p.getId() + " | Produto: " + p.getName() + " | Descrição: " + p.getDescription() + " | Preço: " + p.getPrice() + " | Quantidade de stock: " + p.getStock());
                    }
                    IO.println("\n Qual produto deseja adicionar estoque? insira o ID:");
                    int adicionar = sc.nextInt();
                    IO.println("Adicione a nova quantidade de estoque: ");
                    int novoEstoque = sc.nextInt();
                    for (int i = 0; i < produtos.size(); i++) {
                        Product produto = produtos.get(i);
                        if (produto.getId() == adicionar) {
                            int estoque = novoEstoque;
                            produto.setStock(estoque);
                        }
                    }


                default:
                    if (opcao != 0) {
                        IO.println("Numero não reconhecido");
                    }
                    break;
            }
        } while (opcao != 0);
        IO.println("Programa finalizado. Obrigado!");
        sc.close();
    }
}

