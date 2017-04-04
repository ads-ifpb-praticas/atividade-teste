
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
    public void validacao(){
        Filme filme = new Filme(1, "A lagoa Azul", "Romance", 100, Estado.DISPONIVEL);
        Assert.assertTrue(vf.validar(filme));
                
    }
}
