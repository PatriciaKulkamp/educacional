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
   // @NamedQuery(name = "Matricula.todas", query = "SELECT m.id_matricula, m.data_matricula, pl.ano as ano, m.id_unidade, u.nome as nome_unidade,m.id_classe, c.nome as nome_classe,m.id_serie, se.nome as nome_fase,m.id_situacao, s.nome as situacao_matricula FROM matricula AS m LEFT JOIN periodo_letivo AS pl ON (pl.id_pletivo = m.id_pletivo) LEFT JOIN unidade_escolar AS u ON (u.id_unidade = m.id_unidade) LEFT JOIN classe AS c ON (c.id_classe = m.id_classe) LEFT JOIN serie AS se ON (se.id_serie = m.id_serie) LEFT JOIN situacao AS s ON (s.id_situacao = m.id_situacao)"),
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
    private String dataMatricula;
    
  
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Classe")
    private Integer id_Classe;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Pletivo")
    private Integer id_Pletivo;
    
    
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Situacao")
    private Integer id_Situacao;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Unidade")
    private Integer id_Unidade;
    
    
    
    public Matricula() {
    }

    public Matricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Matricula(Integer idMatricula, String dataMatricula, Integer id_Classe, Integer id_Pletivo, Integer id_Situacao, Integer id_Unidade) {
        this.idMatricula = idMatricula;
        this.dataMatricula = dataMatricula;
        this.id_Classe = id_Classe;
        this.id_Pletivo = id_Pletivo;
        this.id_Situacao = id_Situacao;
        this.id_Unidade = id_Unidade;
        
       
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

    

    public Integer getId_Classe() {
        return id_Classe;
    }

    public void setId_Classe(Integer id_Classe) {
        this.id_Classe = id_Classe;
    }

    public Integer getId_Pletivo() {
        return id_Pletivo;
    }

    public void setId_Pletivo(Integer id_Pletivo) {
        this.id_Pletivo = id_Pletivo;
    }

   

    public Integer getId_Situacao() {
        return id_Situacao;
    }

    public void setId_Situacao(Integer id_Situacao) {
        this.id_Situacao = id_Situacao;
    }

    public Integer getId_Unidade() {
        return id_Unidade;
    }

    public void setId_Unidade(Integer id_Unidade) {
        this.id_Unidade = id_Unidade;
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
