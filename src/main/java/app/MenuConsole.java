package app;

import cardapio.ItemCardapio;
import cardapio.Lanche;
import pedido.Pedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MenuConsole {

    Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("=== RESTAURANTE ===\n" +
        "1 - Registrar novo pedido\n" +
        "2 - Listar pedidos do dia\n" +
        "3 - Fechar restaurante\n" +
        "0 - Sair\n" +
        "Escolha uma opção:");
    }

    public int lerOpcao() {
        int opcao;
        opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public String lerNomeCliente(){
        System.out.println("Digite seu nome:");
        String nomeCliente = sc.nextLine();
        return nomeCliente;
    }

    public int lerOpcaoLanche() {
        System.out.println("Qual lanche você quer?\n" +
                "1 - X-Burger — R$ 16,00\n" +
                "2 - X-Salada — R$ 18,00\n" +
                "3 - X-Bacon — R$ 22,00\n" +
                "Digite o número: ");
        int lanche = sc.nextInt();
        sc.nextLine();
        return lanche;
    }

    public int adicionarLanche() {
        System.out.println("Gostaria de adicionar outro lanche?\n 1 - Sim\n 2 - Não" );
        int opcaoAdd = sc.nextInt();
        sc.nextLine();
        return opcaoAdd;
    }

    public void exibirPedidos(HashMap<Integer, Pedido> pedidos) {
        for (Pedido pedido : pedidos.values()) {
            System.out.println("Cliente: " + pedido.getNomeCliente() + "\nPedido: " + pedido.getIdPedido());
            for(ItemCardapio item : pedido.getItens()) {
                System.out.println("Lanche: " + item.getDescricao());
            }
            System.out.println("Total: " + pedido.calcularTotal());
        }
    }

    public void exibirFechamentoDoDia(double total) {
        System.out.println("Restaurante fechado. Total do dia: " + total);
    }

    public void sair() {
        System.out.println("Encerrando. Agradecemos a preferência!");
    }

    public void opcaoInvalida() {
        System.out.println("Opção inválida");
    }

    public int adicional() {
        System.out.println("Qual adicional você deseja? \n 1 - Cheddar \n 2 - Bacon extra \n 3 - Não quero adicional");
        int adicionalLanche = sc.nextInt();
        sc.nextLine();
        return adicionalLanche;
    }

    public int adicionarAdicional() {
        System.out.println("Gostaria de adicionar outro adicional?\n 1 - Sim\n 2 - Não" );
        int opcaoAdicional = sc.nextInt();
        sc.nextLine();
        return opcaoAdicional;
    }

    public ArrayList<Integer> lerAdicionais() {
        ArrayList<Integer> adicionais = new ArrayList<>();

        int adicional = adicional();

        if(adicional == 3) {
            return adicionais;

        } else if(adicional == 1 || adicional == 2) {
            adicionais.add(adicional);
        }

        int add = adicionarAdicional();
        while (add == 1) {
            adicional = adicional();

            if(adicional == 3) {
                break;
            } else if(adicional == 1 || adicional == 2) {
                adicionais.add(adicional);
            }
            add = adicionarAdicional();
        }
        return adicionais;
    }

    public int lerOpcaoIngrediente() {
        System.out.println("Qual ingrediente deseja retirar? \n 1 - Queijo \n 2 - Alface \n 3 - Tomate \n 4 - Cebola");
        int ingrediente = sc.nextInt();
        sc.nextLine();
        return ingrediente;
    }

    public ArrayList<Boolean> lerIngredientes() {
        ArrayList<Boolean> ingredientes = new ArrayList<>();

        ingredientes.add(true);
        ingredientes.add(true);
        ingredientes.add(true);
        ingredientes.add(true);

        int opcaoIngrediente = 1;

        System.out.println("Deseja retirar algum ingrediente? \n 1 - Sim \n 2 - Não");
        opcaoIngrediente = sc.nextInt();
        sc.nextLine();

        while (opcaoIngrediente == 1) {
            int ingrediente = lerOpcaoIngrediente();

        switch (ingrediente) {
            case 1:
                ingredientes.set(0, false);
                break;
            case 2:
                ingredientes.set(1, false);
                break;
            case 3:
                ingredientes.set(2, false);
                break;
            case 4:
                ingredientes.set(3, false);
                break;
            default:
        }

        System.out.println("Deseja retirar outro ingrediente? \n 1 - Sim \n 2 - Não");
        opcaoIngrediente = sc.nextInt();
        sc.nextLine();

        }
        return ingredientes;
    }
}
