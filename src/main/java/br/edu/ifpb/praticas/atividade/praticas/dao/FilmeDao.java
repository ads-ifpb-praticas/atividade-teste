
package br.edu.ifpb.praticas.atividade.praticas.dao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import br.edu.ifpb.praticas.atividade.praticas.exception.FilmeException;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface FilmeDao {
    
    boolean salvar(Filme filme) throws FilmeException;
    boolean editar(Filme filme) throws FilmeException;
    boolean excluir(int id) throws FilmeException;
    List<Filme> listar() throws FilmeException;
    Filme getFilme(int id) throws FilmeException;
    Filme getFilmePorTitulo(String titulo) throws FilmeException;
}
