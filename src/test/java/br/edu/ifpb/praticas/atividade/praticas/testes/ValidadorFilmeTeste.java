
package br.edu.ifpb.praticas.atividade.praticas.testes;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Estado;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import br.edu.ifpb.praticas.atividade.praticas.validacao.ValidadorFilme;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Edilva
 */
public class ValidadorFilmeTeste {
    
    private ValidadorFilme vf = new ValidadorFilme();
    
    @Test
    public void naoPermiteDuracaoZero(){
        Filme filme = new Filme(1, "A lagoa Azul", "Romance", 0, Estado.DISPONIVEL);
        Assert.assertFalse(vf.validar(filme));
                
    }
    
    @Test
    public void naoPermiteGeneroNull(){
        Filme filme = new Filme(1, "A lagoa Azul", null, 0, Estado.DISPONIVEL);
        Assert.assertFalse(vf.validar(filme));           
    }
    
    @Test
    public void naoPermiteTituloComMaisDe50Caracteres(){
        Filme filme = new Filme(1, "A lagoa Azul mais aulgumas coisas para o títilo ficar maior", "Romance", 100, Estado.DISPONIVEL);
        Assert.assertFalse(vf.validar(filme));
                
    }
}
