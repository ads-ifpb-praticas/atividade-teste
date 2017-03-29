
package br.edu.ifpb.praticas.atividade.praticas.dao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface FilmeDao {
    
    public void salvar(Filme filme);
    public void editar(Filme filme);
    public void excluir(int id);
    public List<Filme> salvar();
    public Filme getFilme(int id);
}
