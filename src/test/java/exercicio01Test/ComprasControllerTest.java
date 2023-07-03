package exercicio01Test;

import org.example.exercicio01.Alimento;
import org.example.exercicio01.AlimentoEntrada;
import org.example.exercicio01.ComprasController;
import org.example.exercicio01.TipoAlimento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ComprasControllerTest {

    @Mock
    AlimentoEntrada alimentoEntrada = new AlimentoEntrada();

    @Mock
    Alimento alimento = new Alimento();

    @InjectMocks
    ComprasController comprasController = new ComprasController(alimentoEntrada);
    @Test
    public void comprarAlimentoTest(){
        TipoAlimento tipoAlimentoEsperado = TipoAlimento.VERDURA;
        BigDecimal quantidadeEsperada = new BigDecimal("3.0");

        when(alimentoEntrada.lerTipoAlimento()).thenReturn(tipoAlimentoEsperado);
        when(alimentoEntrada.lerQuantidade(tipoAlimentoEsperado)).thenReturn(quantidadeEsperada);

        alimento = comprasController.comprarAlimento();

        assertEquals(tipoAlimentoEsperado, alimento.getTipoAlimento());
        assertEquals(quantidadeEsperada, alimento.getQuantidade());
    }
}
