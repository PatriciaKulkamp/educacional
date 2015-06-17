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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "unidade_escolar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadeEscolar.findAll", query = "SELECT u FROM UnidadeEscolar u"),
    @NamedQuery(name = "UnidadeEscolar.findByIdUnidade", query = "SELECT u FROM UnidadeEscolar u WHERE u.idUnidade = :idUnidade"),
    @NamedQuery(name = "UnidadeEscolar.findByNome", query = "SELECT u FROM UnidadeEscolar u WHERE u.nome = :nome")})
public class UnidadeEscolar implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unidade")
    private Integer idUnidade;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nome")
    private String nome;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidade")
    private Collection<Matricula> matriculaCollection;

    public UnidadeEscolar() {
    }

    public UnidadeEscolar(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public UnidadeEscolar(Integer idUnidade, String nome) {
        this.idUnidade = idUnidade;
        this.nome = nome;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
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
        hash += (idUnidade != null ? idUnidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadeEscolar)) {
            return false;
        }
        UnidadeEscolar other = (UnidadeEscolar) object;
        if ((this.idUnidade == null && other.idUnidade != null) || (this.idUnidade != null && !this.idUnidade.equals(other.idUnidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.to.UnidadeEscolar[ idUnidade=" + idUnidade + " ]";
    }
    
}
