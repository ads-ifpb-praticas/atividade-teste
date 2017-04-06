package br.edu.ifpb.praticas.atividade.praticas.dao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Emprestimo;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import br.edu.ifpb.praticas.atividade.praticas.conexao.Conexao;
import br.edu.ifpb.praticas.atividade.praticas.exception.EmprestimoException;
import br.edu.ifpb.praticas.atividade.praticas.exception.FilmeException;
import java.util.ArrayList;

/**
 *
 * @author Edilva
 */
public class EmprestimoDaoBD implements EmprestimoDao {

    public Conexao conexao = new Conexao();

    public EmprestimoDaoBD() {
        
    }

    @Override
    public boolean salvar(Emprestimo emprestimo) throws EmprestimoException{
        boolean resultado = false;
        PreparedStatement ps;
        try {
            conexao.conecta();
            ps = conexao.con.prepareStatement("INSERT INTO emprestimo (id_filme, data_emprestimo, data_devolucao) VALUES (?, ?, ?)");
            ps.setInt(1, emprestimo.getFilme().getId());
            ps.setDate(2, Date.valueOf(emprestimo.getDataEnprestimo()));
            ps.setDate(3, Date.valueOf(emprestimo.getDataDevolucao()));
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
            ps.close();
            conexao.desconecta();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FilmeException("Não foi possível cadastrar emprestimo. " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean editar(Emprestimo emprestimo) throws EmprestimoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        boolean resultado = false;
        PreparedStatement ps;
        try {
            conexao.conecta();
            ps = conexao.con.prepareStatement("DELETE FROM emprestimo WHERE id = ?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
            ps.close();
            conexao.desconecta();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FilmeException("Não foi possível remover emprestimo. " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public List<Emprestimo> listar() throws EmprestimoException {
        PreparedStatement ps;
        List<Emprestimo> emprestimos = new ArrayList<>();
        try {
            conexao.conecta();
            ps = conexao.con.prepareStatement("SELECT * FROM emprestimo");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                emprestimos.add(dadosEmprestimo(rs));
            }
            ps.close();
            conexao.desconecta();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FilmeException("Não foi possível listar emprestimo. " + ex.getMessage());
        }
        return emprestimos;
    }

    @Override
    public Emprestimo getEmprestimo(int id) throws EmprestimoException {
        PreparedStatement ps;
        Emprestimo emprestimo = null;
        try {
            conexao.conecta();
            ps = conexao.con.prepareStatement("SELECT * FROM emprestimo WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            emprestimo = dadosEmprestimo(rs);
            conexao.desconecta();
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new FilmeException("Não foi possível exibir emprestimo. " + ex.getMessage());
        }
        return emprestimo;
    }

    private Emprestimo dadosEmprestimo(ResultSet rs) throws SQLException {
        FilmeDao filmeDao = new FilmeDaoBD();
        Filme filme = filmeDao.getFilme(rs.getInt("id_filme"));
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(rs.getInt("id"));
        emprestimo.setFilme(filme);
        emprestimo.setDataEnprestimo(rs.getDate("data_emprestimo").toLocalDate());
        emprestimo.setDataDevolucao(rs.getDate("data_devolucao").toLocalDate());
        return emprestimo;
    }

}
