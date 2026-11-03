package app;
import cardapio.*;
import pedido.GerenciadorPedidos;
import pedido.Pedido;

import java.util.ArrayList;
import java.util.HashMap;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public void adicionarLanche(int lanche, ArrayList<Integer> adicionais, ArrayList<Boolean> ingredientes, Pedido pedido) {

        Lanche novoLanche;
        ItemCardapio itemCardapio;
        //Criando o Lanche com a Factory
        switch (lanche) {
            case 1:
                novoLanche = LancheFactory.xBurger();
                break;
            case 2:
                novoLanche = LancheFactory.xSalada();
                break;
            case 3:
                novoLanche = LancheFactory.xBacon();
                break;
            default:
                throw new IllegalArgumentException("Opção inválida");
        }

        if (!ingredientes.get(0)) {
            novoLanche.setQueijo(false);
        }
        if (!ingredientes.get(1)) {
            novoLanche.setAlface(false);
        }
        if (!ingredientes.get(2)) {
            novoLanche.setTomate(false);
        }
        if (!ingredientes.get(3)) {
            novoLanche.setCebola(false);
        }

        //Aplicando o Decorator(adicional) escolhido
        itemCardapio = novoLanche;
        for (int adicional : adicionais) {
            switch (adicional) {
                case 1:
                    itemCardapio = new ComCheddar(itemCardapio);
                    break;
                case 2:
                    itemCardapio = new ComBaconExtra(itemCardapio);
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida");
            }

        }
        pedido.adicionarItem(itemCardapio);
    }


        public HashMap<Integer, Pedido> listarPedidos () {
            return gerenciador.getPedidos();
        }

        public double calcularTotalDoDia () {
            return gerenciador.calcularTotalDoDia();
        }
    }

