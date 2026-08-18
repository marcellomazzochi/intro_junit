import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Deve somar dois números inteiros positivos")
    void deveSomarDoisNumerosPositivos() {
        int resultado = calculadora.soma(5, 3);
        assertEquals(8, resultado);
    }

    @Test
    @DisplayName("Deve subtrair dois números inteiros")
    void deveSubtrairNumerosCorretamente() {
        int resultado = calculadora.subtracao(10, 4);
        assertEquals(6, resultado);
    }

    @Test
    @DisplayName("Deve multiplicar dois números inteiros")
    void deveMultiplicarNumerosCorretamente() {
        int resultado = calculadora.multiplicacao(4, 3);
        assertEquals(12, resultado);
    }

    @Test
    @DisplayName("Deve dividir dois números inteiros quando divisor for diferente de zero")
    void deveDividirNumerosValidos() {
        int resultado = calculadora.divisao(10, 2);
        assertEquals(5, resultado);
    }

    @Test
    @DisplayName("Deve lançar ArithmeticException ao tentar dividir por zero")
    void deveLancarExcecaoAoDividirPorZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.divisao(10, 0);
        });
    }

    @Test
    @DisplayName("Deve somar inteiros em um intervalo inclusive")
    void deveSomarNumerosNoIntervalo() {
        // Soma de 1 a 5 = 1 + 2 + 3 + 4 + 5 = 15
        int resultado = calculadora.somatoria(5);
        assertEquals(15, resultado);
    }

    @Test
    @DisplayName("Deve validar se número é positivo")
    void deveVerificarSeNumeroEhPositivo() {
        assertTrue(calculadora.ehPositivo(10));
    }

    @Test
    @DisplayName("Deve comparar dois inteiros e identificar igualdade ou maior valor")
    void deveCompararDoisValores() {
        assertEquals(0, calculadora.compara(5, 5));
        assertEquals(1, calculadora.compara(10, 5));
        assertEquals(-1, calculadora.compara(3, 7));
    }
}
