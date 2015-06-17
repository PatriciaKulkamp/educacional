/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.to;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pati
 */
@Entity
@Table(name = "situacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situacao.findAll", query = "SELECT s FROM Situacao s"),
    @NamedQuery(name = "Situacao.findByIdSituacao", query = "SELECT s FROM Situacao s WHERE s.idSituacao = :idSituacao"),
    @NamedQuery(name = "Situacao.findByNome", query = "SELECT s FROM Situacao s WHERE s.nome = :nome")})
public class Situacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_situacao")
    private Integer idSituacao;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nome")
    private String nome;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSituacao")
    private Collection<Matricula> matriculaCollection;
    

    public Situacao() {
    }

    public Situacao(Integer idSituacao) {
        this.idSituacao = idSituacao;
    }

    public Situacao(Integer idSituacao, String nome) {
        this.idSituacao = idSituacao;
        this.nome = nome;
    }

    public Integer getIdSituacao() {
        return idSituacao;
    }

    public void setIdSituacao(Integer idSituacao) {
        this.idSituacao = idSituacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSituacao != null ? idSituacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situacao)) {
            return false;
        }
        Situacao other = (Situacao) object;
        if ((this.idSituacao == null && other.idSituacao != null) || (this.idSituacao != null && !this.idSituacao.equals(other.idSituacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.to.Situacao[ idSituacao=" + idSituacao + " ]";
    }
    
}
