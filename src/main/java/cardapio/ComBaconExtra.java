package cardapio;

public class ComBaconExtra implements ItemCardapio {

    private ItemCardapio comBaconExtra;

    public ComBaconExtra(ItemCardapio comBaconExtra) {
        this.comBaconExtra = comBaconExtra;
    }

    @Override
    public String getDescricao() {
        return comBaconExtra.getDescricao() + " + bacon extra";
    }

    @Override
    public double getPreco() {
        return comBaconExtra.getPreco() + 6.00;
    }
}
