package br.edu.ifpb.praticas.atividade.praticas.validacao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Edilva
 */
public class ValidadorFilme {

    public boolean validar(Filme filme) {
        if (filme.getDuracao() <= 0) {
            return false;
        }
        if (filme.getGenero() == null) {
            return false;
        }
        if (filme.getTitulo().length() > 50) {
            return false;
        }
//        Pattern p = Pattern.compile("^[a-zA-Z0-9!#?]*$");
//        Matcher matcher = p.matcher(filme.getTitulo());
//        return matcher.matches();
        return true;
    }
}
