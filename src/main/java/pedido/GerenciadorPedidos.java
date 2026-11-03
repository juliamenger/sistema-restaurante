package pedido;

import java.util.HashMap;

public class GerenciadorPedidos {

    private HashMap<Integer, Pedido> pedidos = new HashMap<>();
    private int contadorPedidos = 1;

    public Pedido criarPedido(String nomeCliente) {
        //gera o número, cria o Pedido, guarda no mapa e devolve o pedido criado
        Pedido novo = new Pedido(contadorPedidos, nomeCliente);
        pedidos.put(novo.getIdPedido(), novo);
        contadorPedidos++;
        return novo;
    }

    public Pedido buscarPedido(int idPedido) {
        //devolve o Pedido daquele número, ou null se não existir
        return pedidos.get(idPedido);
    }

    public HashMap<Integer, Pedido> getPedidos() {
        //devolve a coleção de pedidos para quem for exibir
        return pedidos;
    }

    public double calcularTotalDoDia() {
        //percorre todos os pedidos e soma o calcularTotal() de cada um
        double totalDia = 0;
        for (Pedido pedido : pedidos.values()) {
            totalDia += pedido.calcularTotal();
        }
        return totalDia;
    }
}
