package cardapio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LancheTest {

    @Test
    void precoNegativoRecusado() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lanche("X-Burger", -26.00);
        });
        }

    @Test
    void xBaconComCheddarCusta26() {
        ItemCardapio lanche = new ComCheddar(LancheFactory.xBacon());
        assertEquals(26.0, lanche.getPreco(), 0.001);
    }

}