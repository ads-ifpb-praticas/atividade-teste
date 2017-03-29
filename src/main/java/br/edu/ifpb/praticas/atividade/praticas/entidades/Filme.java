
package br.edu.ifpb.praticas.atividade.praticas.entidades;

import java.util.Objects;

/**
 *
 * @author Edilva
 */
public class Filme {
    private int id;
    private String titulo;
    private String genero;
    private double duracao;
    private Estado estado;

    public Filme(int id, String titulo, String genero, double duracao, Estado estado) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.estado = estado;
    }

    public Filme(String titulo, String genero, double duracao, Estado estado) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.estado = estado;
    }

    public Filme() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.titulo);
        hash = 47 * hash + Objects.hashCode(this.genero);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.duracao) ^ (Double.doubleToLongBits(this.duracao) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.estado);
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
        final Filme other = (Filme) obj;
        if (Double.doubleToLongBits(this.duracao) != Double.doubleToLongBits(other.duracao)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Filme{" + "titulo=" + titulo + ", genero=" + genero + ", duracao=" + duracao + ", estado=" + estado + '}';
    }
    
    
}
