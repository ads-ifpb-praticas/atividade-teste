
package br.edu.ifpb.praticas.atividade.praticas.dao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import br.edu.ifpb.praticas.atividade.praticas.exception.FilmeException;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface FilmeDao {
    
    public boolean salvar(Filme filme) throws FilmeException;
    public boolean editar(Filme filme) throws FilmeException;
    public boolean excluir(int id) throws FilmeException;
    public List<Filme> listar() throws FilmeException;
    public Filme getFilme(int id) throws FilmeException;
    public Filme getFilmePorTitulo(String titulo) throws FilmeException;
}
