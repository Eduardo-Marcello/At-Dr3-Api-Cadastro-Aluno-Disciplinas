package br.edu.infnet.SpringMVCPU.AppController;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.SpringMVCPU.model.negocio.Aluno;
import br.edu.infnet.SpringMVCPU.model.service.AlunoService;


@Controller
public class AppController {
	
	@Autowired
	private AlunoService alunoService;
	
    @RequestMapping("/cadastro")
    public String cadastro(Model model) 
    {
        Aluno aluno = new Aluno();
        model.addAttribute("aluno", aluno);
        return "cadastro";
    }
    
    @RequestMapping("/cadastrar")
    public String cadastrar(Model model, Aluno aluno) throws SQLException {
    	alunoService.salvar(aluno);
        return "redirect:/consulta";
    }
    
    @RequestMapping("/")
    public String consulta(Model model) {
    	model.addAttribute("lista", alunoService.consultar());
        return "consulta";
    }
    
    @RequestMapping("excluir")
    public String excluir(@RequestParam int id) {
    	alunoService.excluir(id);
        return "redirect:/consulta";
    }
    
    @RequestMapping("alterar")
    public ModelAndView alterar(@RequestParam int id) {
        
        ModelAndView mav = new ModelAndView("alterar");
        Aluno aluno = alunoService.consultarPorID(id);
        mav.addObject("aluno", aluno);
        return mav;
    }
    
    @RequestMapping("/login")
    public String login(){
    	return "login";
    }
    
    @RequestMapping(value = "salvaraluno", method = RequestMethod.POST)
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
    	alunoService.salvar(aluno);
        return "redirect:/consulta";
    }
    
    @RequestMapping("procura")
    public ModelAndView procura(@RequestParam String keyword) {
        List<Aluno> result = alunoService.procura(keyword);
        ModelAndView mav = new ModelAndView("procura");
        mav.addObject("result", result);
        return mav;
    }
}