package br.edu.ifpb.praticas.atividade.praticas.dao;

import br.edu.ifpb.praticas.atividade.praticas.conexao.Conexao;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Estado;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class FilmeDaoBD implements FilmeDao {

    private Conexao conexao = new Conexao();
    

    public FilmeDaoBD() {

    }

    @Override
    public boolean salvar(Filme filme) {
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
            Logger.getLogger(FilmeDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean editar(Filme filme) {
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
            Logger.getLogger(FilmeDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean excluir(int id) {
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
            Logger.getLogger(FilmeDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public List<Filme> listar() {
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
            Logger.getLogger(FilmeDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filmes;
    }

    @Override
    public Filme getFilme(int id) {
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
            Logger.getLogger(FilmeDaoBD.class.getName()).log(Level.SEVERE, null, ex);
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
