package cardapio;

public class ComCheddar implements ItemCardapio {

    private ItemCardapio comCheddar;

    public ComCheddar(ItemCardapio comCheddar) {
        this.comCheddar = comCheddar;
    }

    @Override
    public String getDescricao() {
        return comCheddar.getDescricao() + " + cheddar";
    }

    @Override
    public double getPreco() {
        return comCheddar.getPreco() + 4.00;
    }
}
