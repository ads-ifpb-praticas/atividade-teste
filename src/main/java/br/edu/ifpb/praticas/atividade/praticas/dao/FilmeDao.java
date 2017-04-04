
package br.edu.ifpb.praticas.atividade.praticas.dao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface FilmeDao {
    
    public boolean salvar(Filme filme);
    public boolean editar(Filme filme);
    public boolean excluir(int id);
    public List<Filme> listar();
    public Filme getFilme(int id);
}
