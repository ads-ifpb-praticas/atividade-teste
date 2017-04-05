
package br.edu.ifpb.praticas.atividade.praticas.validacao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Emprestimo;
import java.time.LocalDate;

/**
 *
 * @author Edilva
 */
public class ValidadorEmprestimo {
    
    public boolean validar(Emprestimo emprestimo){
        if(!emprestimo.getDataEnprestimo().equals(LocalDate.now())){
            return false;
        }
        if(emprestimo.getDataDevolucao().isBefore(emprestimo.getDataEnprestimo())){
            return false;
        }
        return true;
    }
}
