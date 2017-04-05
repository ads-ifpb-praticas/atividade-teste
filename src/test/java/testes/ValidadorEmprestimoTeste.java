
package testes;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Emprestimo;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Estado;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import br.edu.ifpb.praticas.atividade.praticas.validacao.ValidadorEmprestimo;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Edilva
 */
public class ValidadorEmprestimoTeste {
    
    private ValidadorEmprestimo ve = new ValidadorEmprestimo();
    
    @Test
    public void validacao(){
        Filme filme = new Filme(1, "A lagoa Azul", "Romance", 100, Estado.DISPONIVEL);
        Emprestimo emprestimo = new Emprestimo(filme, LocalDate.now(), LocalDate.now().plusDays(1));
        ve.validar(emprestimo);
        Emprestimo emprestimo1 = new Emprestimo(filme, LocalDate.now(), LocalDate.now());
        Assert.assertTrue(ve.validar(emprestimo1));
    }
    
    @Test
    public void dataEmprestimoRetroativa(){
        Filme filme = new Filme(1, "A lagoa Azul", "Romance", 100, Estado.DISPONIVEL);
        Emprestimo emprestimo = new Emprestimo(filme, LocalDate.of(2017, Month.MARCH, 16), LocalDate.now());
        Assert.assertFalse(ve.validar(emprestimo));
        Emprestimo emprestimo2 = new Emprestimo(filme, LocalDate.of(2017, Month.SEPTEMBER, 16), LocalDate.now());
        Assert.assertFalse(ve.validar(emprestimo2));
    }
    
    @Test
    public void dataDevolucaoRetroativa(){
        Filme filme = new Filme(1, "A lagoa Azul", "Romance", 100, Estado.DISPONIVEL);
        Emprestimo emprestimo = new Emprestimo(filme, LocalDate.of(2017, Month.MARCH, 16), LocalDate.now().plusDays(-1));
        Assert.assertFalse(ve.validar(emprestimo));
    }
        
}
