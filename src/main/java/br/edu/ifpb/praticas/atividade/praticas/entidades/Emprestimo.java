
package br.edu.ifpb.praticas.atividade.praticas.entidades;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Edilva
 */
public class Emprestimo {
    public int id;
    private Filme filme;
    private LocalDate dataEnprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(int id, Filme filme, LocalDate dataEnprestimo, LocalDate dataDevolucao) {
        this.id = id;
        this.filme = filme;
        this.dataEnprestimo = dataEnprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(Filme filme, LocalDate dataEnprestimo, LocalDate dataDevolucao) {
        this.filme = filme;
        this.dataEnprestimo = dataEnprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public LocalDate getDataEnprestimo() {
        return dataEnprestimo;
    }

    public void setDataEnprestimo(LocalDate dataEnprestimo) {
        this.dataEnprestimo = dataEnprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.filme);
        hash = 17 * hash + Objects.hashCode(this.dataEnprestimo);
        hash = 17 * hash + Objects.hashCode(this.dataDevolucao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Emprestimo other = (Emprestimo) obj;
        if (!Objects.equals(this.filme, other.filme)) {
            return false;
        }
        if (!Objects.equals(this.dataEnprestimo, other.dataEnprestimo)) {
            return false;
        }
        if (!Objects.equals(this.dataDevolucao, other.dataDevolucao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "filme=" + filme + ", dataEnprestimo=" + dataEnprestimo + ", dataDevolucao=" + dataDevolucao + '}';
    }
    
    
}
