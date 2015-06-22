/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.to;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pati
 */
@Entity
@Table(name = "matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByIdMatricula", query = "SELECT m FROM Matricula m WHERE m.idMatricula = :idMatricula"),
    @NamedQuery(name = "Matricula.findByDataMatricula", query = "SELECT m FROM Matricula m WHERE m.dataMatricula = :dataMatricula"),
})
public class Matricula implements Serializable {    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_matricula")    
    private Integer idMatricula;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_matricula")
    @Temporal(TemporalType.DATE)
    private String dataMatricula;
    
  
   
    
    @JoinColumn(name = "id_classe", referencedColumnName = "id_classe")
    @ManyToOne(optional = false)
    private Integer idClasse;
    
    @JoinColumn(name = "id_pletivo", referencedColumnName = "id_pletivo")
    @ManyToOne(optional = false)
    private Integer idPletivo;
    
    
    
    @JoinColumn(name = "id_situacao", referencedColumnName = "id_situacao")
    @ManyToOne(optional = false)
    private Integer idSituacao;
    
    @JoinColumn(name = "id_unidade", referencedColumnName = "id_unidade")
    @ManyToOne(optional = false)
    private Integer idUnidade;
    
    
    public Matricula() {
    }

    public Matricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Matricula(Integer idMatricula, String dataMatricula, Integer idClasse, Integer idPletivo, Integer idSituacao, Integer idUnidade) {
        this.idMatricula = idMatricula;
        this.dataMatricula = dataMatricula;
        this.idClasse = idClasse;
        this.idPletivo = idPletivo;
        this.idSituacao = idSituacao;
        this.idUnidade = idUnidade;
        
       
    }

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    

    public Integer getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public Integer getIdPletivo() {
        return idPletivo;
    }

    public void setIdPletivo(Integer idPletivo) {
        this.idPletivo = idPletivo;
    }

   

    public Integer getIdSituacao() {
        return idSituacao;
    }

    public void setIdSituacao(Integer idSituacao) {
        this.idSituacao = idSituacao;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatricula != null ? idMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idMatricula == null && other.idMatricula != null) || (this.idMatricula != null && !this.idMatricula.equals(other.idMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.to.Matricula[ idMatricula=" + idMatricula + " ]";
    }
    
}
