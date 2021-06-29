package br.edu.infnet.SpringMVCPU.AppController;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.SpringMVCPU.model.negocio.Aluno;
import br.edu.infnet.SpringMVCPU.model.negocio.Disciplina;
import br.edu.infnet.SpringMVCPU.model.service.AlunoService;
import br.edu.infnet.SpringMVCPU.model.service.DisciplinaService;

@Controller
public class DisciplinaController {

	@Autowired
	private DisciplinaService ds;
	
	@Autowired
	private AlunoService as;
	
	@GetMapping("/disciplina/cadastro")
    public String cadastro(Model model) 
    {
        Disciplina disciplina = new Disciplina();
        
        model.addAttribute("disciplina", disciplina);
        model.addAttribute("alunos", as.consultar());
        return "disciplina/cadastro";
        
    }
    
    @PostMapping("/disciplina/cadastrar")
    public String cadastrar(Model model, Disciplina disciplina, Aluno aluno, Integer id) throws SQLException {
    	System.out.println(id);
    	System.out.println(aluno);
    	System.out.println(disciplina.getAlunos());
    	ds.salvar1(disciplina, aluno);
        return "redirect:/disciplina/consulta";
    }
    
    @GetMapping("/disciplina/consulta")
    public String consulta(Model model) {
    	model.addAttribute("lista", ds.consultar());
        return "/disciplina/consulta";
    }
    
    @GetMapping("/disciplina/excluir")
    public String excluir(@RequestParam int id) {
    	ds.excluir(id);
        return "redirect:/disciplina/consulta";
    }
    
    @GetMapping("/disciplina/alterar")
    public ModelAndView alterar(@RequestParam int id) {
        
        ModelAndView mav = new ModelAndView("/disciplina/alterar");
        Disciplina disciplina = ds.consultarPorID(id);
        mav.addObject("disciplina", disciplina);
        return mav;
    }
    
    @PostMapping(value = "/disciplina/salvardisciplina")
    public String salvarDisciplina(@ModelAttribute("disciplina") Disciplina disciplina) {
    	ds.salvar2(disciplina);
        return "redirect:/disciplina/consulta";
    }
    
    @GetMapping("/disciplina/procura")
    public ModelAndView procura(@RequestParam String keyword) {
        List<Disciplina> result = ds.procura(keyword);
        ModelAndView mav = new ModelAndView("/disciplina/procura");
        mav.addObject("result", result);
        return mav;
    }
}
