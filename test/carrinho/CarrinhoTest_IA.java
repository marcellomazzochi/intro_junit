import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarrinhoTest {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
        produto1 = new Produto("Livro", 50.0);
        produto2 = new Produto("Caderno", 20.0);
    }

    @Test
    @DisplayName("Deve iniciar o carrinho vazio com valor total zerado")
    void deveInicializarVazio() {
        assertEquals(0, carrinho.getQtdeElementos());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Deve adicionar itens ao carrinho e atualizar a contagem e valor total")
    void deveAdicionarItensAoCarrinho() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(2, carrinho.getQtdeElementos());
        assertEquals(70.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Deve remover um item existente com sucesso")
    void deveRemoverItemExistente() throws Exception {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.removeItem(produto1);

        assertEquals(1, carrinho.getQtdeElementos());
        assertEquals(20.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar remover um item que não está no carrinho")
    void deveLancarExcecaoAoRemoverItemInexistente() {
        carrinho.addItem(produto1);

        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(produto2);
        });
    }

    @Test
    @DisplayName("Deve esvaziar o carrinho completamente")
    void deveEsvaziarCarrinho() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeElementos());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }
}