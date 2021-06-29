package br.edu.infnet.SpringMVCPU.model.negocio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private int id;
    private String nomeAluno;
    private String telefone;
    
    @OneToMany(mappedBy = "aluno", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Email> emails;

    public Set<Email> getEmails() {
        return emails;
    }
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "alunos_disciplinas", 
        joinColumns = { @JoinColumn(name = "id_aluno") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_disciplina") }
    )
    
    Set<Disciplina> disciplinas = new HashSet<>();
    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Aluno() {
    }
    
    public Aluno(String nomeAluno, String telefone) {
        this.nomeAluno = nomeAluno;
        this.telefone = telefone;
    }
    
    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	@Override
    public String toString() {
            return id + " " + nomeAluno + " " + telefone;
    }
}