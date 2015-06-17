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
@Table(name = "periodo_letivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodoLetivo.findAll", query = "SELECT p FROM PeriodoLetivo p"),
    @NamedQuery(name = "PeriodoLetivo.findByIdPletivo", query = "SELECT p FROM PeriodoLetivo p WHERE p.idPletivo = :idPletivo"),
    @NamedQuery(name = "PeriodoLetivo.findByIdPletivo1", query = "SELECT p FROM PeriodoLetivo p WHERE p.idPletivo1 = :idPletivo1"),
    @NamedQuery(name = "PeriodoLetivo.findByAno", query = "SELECT p FROM PeriodoLetivo p WHERE p.ano = :ano")})
public class PeriodoLetivo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pletivo")
    private Integer idPletivo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_pletivo_1")
    private String idPletivo1;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPletivo")
    private Collection<Matricula> matriculaCollection;

    public PeriodoLetivo() {
    }

    public PeriodoLetivo(Integer idPletivo) {
        this.idPletivo = idPletivo;
    }

    public PeriodoLetivo(Integer idPletivo, String idPletivo1, int ano) {
        this.idPletivo = idPletivo;
        this.idPletivo1 = idPletivo1;
        this.ano = ano;
    }

    public Integer getIdPletivo() {
        return idPletivo;
    }

    public void setIdPletivo(Integer idPletivo) {
        this.idPletivo = idPletivo;
    }

    public String getIdPletivo1() {
        return idPletivo1;
    }

    public void setIdPletivo1(String idPletivo1) {
        this.idPletivo1 = idPletivo1;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
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
        hash += (idPletivo != null ? idPletivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodoLetivo)) {
            return false;
        }
        PeriodoLetivo other = (PeriodoLetivo) object;
        if ((this.idPletivo == null && other.idPletivo != null) || (this.idPletivo != null && !this.idPletivo.equals(other.idPletivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.to.PeriodoLetivo[ idPletivo=" + idPletivo + " ]";
    }
    
}
