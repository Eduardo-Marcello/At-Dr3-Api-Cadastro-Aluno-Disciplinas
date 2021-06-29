package br.edu.infnet.SpringMVCPU.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.SpringMVCPU.model.negocio.Aluno;
import br.edu.infnet.SpringMVCPU.model.negocio.Email;
import br.edu.infnet.SpringMVCPU.model.repository.IEmailRepository;

@Service
public class EmailService {

	@Autowired
	private IEmailRepository er;
	
	public void salvar(Email email, Aluno aluno)
	{
		er.save(email);
	}
	
	public List<Email> consultar()
	{
		return (List<Email>) er.findAll();
	}
	
	public Optional<Email> consultarPorID(Integer id)
	{
		return er.findById(id);
	}
	
	public void excluir(Integer id) 
	{
		er.deleteById(id);
	}
}
