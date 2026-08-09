package carrinho;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.*;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
    private Carrinho car;
    private Produto prod1;
    private Produto prod2;
    private Produto prod3;

    @BeforeEach
    public void inicializa() {
        car = new Carrinho();
        prod1 = new Produto("Livro", 40);
        prod2 = new Produto("Caneta", 5);
        prod3 = new Produto("Caneca", 20);

        car.addItem(prod1);
        car.addItem(prod2);
        car.addItem(prod3);
    }

    @Test
    public void testQuantidadeTotalCarrinho() {
        assertEquals(3, car.getQtdeItems());
    }

    @Test
    public void testValorTotalCarrinho(){
        assertEquals(65, car.getValorTotal());
    }

    @Test
    public void testProdutosIguais() {
        assertNotSame(prod2, prod3);

    }

    @Test
    public void assertionComHamcrestMatcher() {
        assertThat(prod1.getPreco(), equalTo(40.0));
        assertThat(prod1.getNome(), notNullValue());
        assertThat(prod1.getNome(), containsString("Livro"));
        assertThat(prod1, instanceOf(Produto.class));
    }

    @Test
    public void testEsvaziarCarrinho() {
        car.esvazia();
        assertEquals(0, car.getQtdeItems());
    }

    @Test
    public void testRetirarItem() throws ProdutoNaoEncontradoException {
        car.removeItem(prod1);
        assertEquals(25, car.getValorTotal());
    }

}