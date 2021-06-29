package br.edu.infnet.SpringMVCPU.AppController;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.SpringMVCPU.model.negocio.Aluno;
import br.edu.infnet.SpringMVCPU.model.service.AlunoService;
import br.edu.infnet.SpringMVCPU.model.service.DisciplinaService;

@Controller
public class AlunoController {
	@Autowired
	private AlunoService alunoService;
	
    @GetMapping("/aluno/cadastro")
    public String cadastro(Model model) 
    {
        Aluno aluno = new Aluno();
        model.addAttribute("aluno", aluno);
        return "/aluno/cadastro";
    }
    
    @PostMapping("/aluno/cadastrar")
    public String cadastrar(Model model, Aluno aluno) throws SQLException {
    	System.out.println(aluno);
    	alunoService.salvar(aluno);
        return "redirect:/aluno/consulta";
    }
    
    @GetMapping("/aluno/consulta")
    public String consulta(Model model) {
    	model.addAttribute("lista", alunoService.consultar());
        return "/aluno/consulta";
    }
    
    @GetMapping("/aluno/excluir")
    public String excluir(@RequestParam int id) {
    	alunoService.excluir(id);
        return "redirect:/aluno/consulta";
    }
    
    @GetMapping("/aluno/alterar")
    public ModelAndView alterar(@RequestParam int id) {
        
        ModelAndView mav = new ModelAndView("/aluno/alterar");
        Aluno aluno = alunoService.consultarPorID(id);
        mav.addObject("aluno", aluno);
        return mav;
    }
    
    @PostMapping(value = "/aluno/salvaraluno")
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
    	alunoService.salvar(aluno);
        return "redirect:/aluno/consulta";
    }
    
    @GetMapping("/aluno/procura")
    public ModelAndView procura(@RequestParam String keyword) {
        List<Aluno> result = alunoService.procura(keyword);
        ModelAndView mav = new ModelAndView("/aluno/procura");
        mav.addObject("result", result);
        return mav;
    }
}
