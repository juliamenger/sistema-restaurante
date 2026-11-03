package pedido;

import cardapio.ItemCardapio;
import cardapio.Lanche;

import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private String nomeCliente;

    private ArrayList<ItemCardapio> itens = new ArrayList<>();

    public Pedido(int idPedido, String nomeCliente) {
        this.idPedido = idPedido;
        setNomeCliente(nomeCliente);
    }

    public void setNomeCliente(String nomeCliente) {
        if(nomeCliente==null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
    }

    public ArrayList<ItemCardapio> getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemCardapio item : itens) {
            total += item.getPreco();

        }
        return total;
    }
}
