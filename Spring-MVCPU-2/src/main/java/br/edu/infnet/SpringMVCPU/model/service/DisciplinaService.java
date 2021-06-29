package br.edu.infnet.SpringMVCPU.model.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.SpringMVCPU.model.negocio.Aluno;
import br.edu.infnet.SpringMVCPU.model.negocio.Disciplina;
import br.edu.infnet.SpringMVCPU.model.repository.IAlunoRepository;
import br.edu.infnet.SpringMVCPU.model.repository.IDisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private IDisciplinaRepository dr; 
	
	@Autowired
	private IAlunoRepository ar;
	
	public void salvar1(Disciplina disciplina, Aluno aluno)
	{	
		Set<Disciplina> disciplinas = new HashSet<>();
		disciplinas.add(disciplina);
		aluno.setDisciplinas(disciplinas);
		dr.save(disciplina);
	}
	
	public void salvar2(Disciplina disciplina)
	{	
		dr.save(disciplina);
	}
	
	public List<Disciplina> consultar()
	{
		return (List<Disciplina>) dr.findAll();
	}
	
	public Disciplina consultarPorID(Integer id)
	{
		return dr.findById(id).get();
	}
	
	public void excluir(Integer id) 
	{
		dr.deleteById(id);
	}
	
	public List<Disciplina> procura(String keyword){
		return dr.search(keyword);
	}
}
