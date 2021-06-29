package br.edu.infnet.SpringMVCPU;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.infnet.SpringMVCPU.model.negocio.Aluno;
import br.edu.infnet.SpringMVCPU.model.negocio.Disciplina;
import br.edu.infnet.SpringMVCPU.model.negocio.Email;
import br.edu.infnet.SpringMVCPU.model.repository.IAlunoRepository;
import br.edu.infnet.SpringMVCPU.model.repository.IDisciplinaRepository;
import br.edu.infnet.SpringMVCPU.model.repository.IEmailRepository;

@SpringBootApplication
public class SpringMvcpuApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcpuApplication.class, args);
	}
	
//	  @Bean
//	    public CommandLineRunner mappingDemo(IAlunoRepository alunoRepository,
//	                                         IEmailRepository emailRepository) {
//	        return (String[] args) -> {
//
//	            Aluno aluno = new Aluno("Marcello", "99874543");
//	            alunoRepository.save(aluno);
//	            System.out.println("Aluno salvo: " + aluno);
//	            
//	            emailRepository.save(new Email("teste@teste.com", aluno));
//	            emailRepository.save(new Email("teste2@teste2.com", aluno));
//	            emailRepository.save(new Email("teste3@teste3.com", aluno));
//	            
//	            aluno = alunoRepository.findById(aluno.getId()).get();
//	            System.out.println("Aluno lido: " + aluno);
//	        };
//	    }
	  
//	    @Bean
//	    public CommandLineRunner mappingDemo(IAlunoRepository alunoRepository,
//	                                         IDisciplinaRepository disciplinaRepository) {
//	        return (String[] args) -> {
//
//	            Set<Disciplina> disciplinas = new HashSet<>();
//	            disciplinas.add(new Disciplina("Java", "100"));
//	            disciplinas.add(new Disciplina("Java Web", "101"));
//	            
//	            Aluno aluno = new Aluno("Joao", "123456789");
//	            aluno.setDisciplinas(disciplinas);
//	            alunoRepository.save(aluno);
//	        };
//	    }  

}
