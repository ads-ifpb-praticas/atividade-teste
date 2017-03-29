package br.edu.ifpb.praticas.atividade.praticas.dao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Estado;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class FilmeDaoBD implements FilmeDao {

    public Connection connection;

    public FilmeDaoBD() {
        try {
            this.connection = DriverManager.getConnection("jdbc:h2:mem:;"
                    + "INIT=RUNSCRIPT FROM './src/main/resources/create_schema.sql'\\;", "sa", "");
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void salvar(Filme filme) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO filme (titulo, genero, duracao, estado, ) VALUES (?, ?, ?, ?)");
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setDouble(3, filme.getDuracao());
            ps.setString(4, filme.getEstado().name());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void editar(Filme filme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("DELETE FROM filme WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Filme> salvar() {
        PreparedStatement ps;
        List<Filme> filmes = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM filme");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dadosFilme(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filmes;
    }

    @Override
    public Filme getFilme(int id) {
        PreparedStatement ps;
        Filme filme = new Filme();
        try {
            ps = connection.prepareStatement("SELECT * FROM filme WHERE id = ?");
            ResultSet rs = ps.executeQuery();
            filme = dadosFilme(rs);
        } catch (SQLException ex) {
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
        filme.setDuracao(rs.getDouble("duracao"));
        return filme;
    }

}
