package br.edu.ifpb.praticas.atividade.praticas.dao;

import br.edu.ifpb.praticas.atividade.praticas.conexao.Conexao;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Estado;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import br.edu.ifpb.praticas.atividade.praticas.exception.FilmeException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class FilmeDaoBD implements FilmeDao {

    private Conexao conexao = new Conexao();
    

    public FilmeDaoBD() {

    }

    @Override
    public boolean salvar(Filme filme) throws FilmeException{
        boolean resultado = false;
        PreparedStatement ps;
        try {
            conexao.conecta();
            ps = conexao.con.prepareStatement("INSERT INTO filme (titulo, genero, duracao, estado) VALUES (?, ?, ?, ?)");
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setDouble(3, filme.getDuracao());
            ps.setString(4, filme.getEstado().name());
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
            ps.close();
            conexao.desconecta();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FilmeException("Não foi possível cadastrar filme. " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean editar(Filme filme) throws FilmeException{
        boolean resultado = false;
        PreparedStatement ps;
        try {
            conexao.conecta();
            ps = conexao.con.prepareStatement("UPDATE filme SET titulo = ?, genero = ?, duracao = ?, estado = ? WHERE id = ?");
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setDouble(3, filme.getDuracao());
            ps.setString(4, filme.getEstado().name());
            ps.setInt(5, filme.getId());
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
            ps.close();
            conexao.desconecta();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FilmeException("Não foi possível atualizar filme. " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean excluir(int id) throws FilmeException{
        boolean resultado = false;
        PreparedStatement ps;
        try {
            conexao.conecta();
            ps = conexao.con.prepareStatement("DELETE FROM filme WHERE id = ?");
            ps.setInt(1, id);
            Filme filme = getFilme(id);
            if (filme.getEstado().equals(Estado.DISPONIVEL)) {
                if (ps.executeUpdate() > 0) {
                    resultado = true;
                }
            }
            ps.close();
            conexao.desconecta();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FilmeException("Não foi possível remover filme. " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public List<Filme> listar() throws FilmeException{
        PreparedStatement ps;
        List<Filme> filmes = new ArrayList<>();
        try {
            conexao.conecta();
            ps = conexao.con.prepareStatement("SELECT * FROM filme");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                filmes.add(dadosFilme(rs));
            }
            ps.close();
            conexao.desconecta();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FilmeException("Não foi possível listar filme. " + ex.getMessage());
        }
        return filmes;
    }

    @Override
    public Filme getFilme(int id) throws FilmeException{
        PreparedStatement ps;
        Filme filme = null;
        try {
            conexao.conecta();
            ps = conexao.con.prepareStatement("SELECT * FROM filme WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                filme = dadosFilme(rs);
            }
            ps.close();
            conexao.desconecta();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FilmeException("Não foi possível exibir filme. " + ex.getMessage());
        }
        return filme;
    }
    
    public Filme getFilmePorTitulo(String titulo) throws FilmeException{
        PreparedStatement ps;
        Filme filme = null;
        try {
            conexao.conecta();
            ps = conexao.con.prepareStatement("SELECT * FROM filme WHERE titulo = ?");
            ps.setString(1, titulo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                filme = dadosFilme(rs);
            }
            ps.close();
            conexao.desconecta();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FilmeException("Não foi possível exibir filme. " + ex.getMessage());
        }
        return filme;
    }

    private Filme dadosFilme(ResultSet rs) throws SQLException {
        Filme filme = new Filme();
        filme.setId(rs.getInt("id"));
        filme.setTitulo(rs.getString("titulo"));
        filme.setGenero(rs.getString("genero"));
        filme.setEstado((Estado.valueOf(rs.getString("estado"))));
        filme.setDuracao(rs.getInt("duracao"));
        return filme;
    }

}
