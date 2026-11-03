package app;

import pedido.Pedido;

import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MenuConsole menu = new MenuConsole();
        RestauranteFacade facade = new RestauranteFacade();

        int opcaoMenu = -1;

        while(opcaoMenu !=0) {
            menu.exibirMenu();
            opcaoMenu = menu.lerOpcao();

            switch (opcaoMenu) {

                case 1: //criando um novo pedido
                    String nomeCliente = menu.lerNomeCliente();
                    Pedido pedido = facade.criarPedido(nomeCliente);
                    int lanche = menu.lerOpcaoLanche();
                    ArrayList<Integer> adicionais = menu.lerAdicionais();

                    facade.adicionarLanche(lanche, adicionais, menu.lerIngredientes(), pedido);

                    //perguntando se quer adicionar outro lanche ao pedido
                    int opcaoAdd = -1;

                    while(opcaoAdd !=2) {
                        opcaoAdd = menu.adicionarLanche();

                        if (opcaoAdd == 1) {
                        int novoLanche = menu.lerOpcaoLanche();
                        ArrayList<Integer> novosAdicionais = menu.lerAdicionais();

                        facade.adicionarLanche(novoLanche, novosAdicionais, menu.lerIngredientes(), pedido);
                        }
                    }
                    break;

                case 2:
                    HashMap<Integer, Pedido> pedidos = facade.listarPedidos();
                    menu.exibirPedidos(pedidos);
                    break;

                case 3:
                    double total = facade.calcularTotalDoDia();
                    menu.exibirFechamentoDoDia(total);
                    break;

                case 0:
                    menu.sair();
                    break;

                default:
                    menu.opcaoInvalida();
            }
        }

    }
}
