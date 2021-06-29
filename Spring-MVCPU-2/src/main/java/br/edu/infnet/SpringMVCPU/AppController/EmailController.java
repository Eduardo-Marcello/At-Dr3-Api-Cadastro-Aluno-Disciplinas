package br.edu.infnet.SpringMVCPU.AppController;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.SpringMVCPU.model.negocio.Aluno;
import br.edu.infnet.SpringMVCPU.model.negocio.Email;
import br.edu.infnet.SpringMVCPU.model.service.AlunoService;
import br.edu.infnet.SpringMVCPU.model.service.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService es;
	
	@Autowired
	private AlunoService as;
	
	@GetMapping("/email/cadastro")
    public String cadastro(Model model) 
    {
        Email email = new Email();
        
        model.addAttribute("email", email);
        model.addAttribute("alunos", as.consultar());
        return "email/cadastro";
        
    }
    
    @PostMapping("/email/cadastrar")
    public String cadastrar(Model model, Email email, Aluno aluno) throws SQLException {
    	System.out.println(email);
    	System.out.println(aluno);
    	System.out.println(email.getAluno());
    	es.salvar(email, aluno);
        return "redirect:/email/consulta";
    }
    
    @GetMapping("/email/consulta")
    public String consulta(Model model) {
    	model.addAttribute("lista", es.consultar());
        return "/email/consulta";
    }
    
    @GetMapping("/email/excluir")
    public String excluir(@RequestParam int id) {
    	es.excluir(id);
        return "redirect:/email/consulta";
    }
}
