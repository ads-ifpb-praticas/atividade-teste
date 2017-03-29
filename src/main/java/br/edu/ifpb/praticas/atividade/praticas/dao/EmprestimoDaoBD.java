
package br.edu.ifpb.praticas.atividade.praticas.dao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Emprestimo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilva
 */
public class EmprestimoDaoBD implements EmprestimoDao{
    
    public Connection connection;

    public EmprestimoDaoBD() {
        try {
            this.connection = DriverManager.getConnection("jdbc:h2:mem:;" +
						"INIT=RUNSCRIPT FROM './src/main/resources/create_schema.sql'\\;", "sa", "");
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void salvar(Emprestimo emprestimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Emprestimo emprestimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emprestimo> salvar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Emprestimo getFilme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
