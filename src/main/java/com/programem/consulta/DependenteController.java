package com.programem.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Dependente")
public class DependenteController {
   
  @Autowired
  private DependenteRepository DependenteRepository;

  private DependenteLista dependenteLista = new DependenteLista();
  
  @GetMapping("/")
    public String DependenteForm(){
    return "DependenteForm";
  }

  @PostMapping(path="/DependenteInsere")
  public @ResponseBody String addNewDependente(@RequestParam String nome,
  @RequestParam Integer idade,
  @RequestParam String endereco)
  {
    Dependente d = new Dependente();
    d.setIdade(idade);
    d.setEndereco(endereco);
    d.setNome(nome);
    DependenteRepository.save(d);
    return nome + " " + idade + " " + endereco;  
  }

  @GetMapping(path="/DependenteLista")
  public @ResponseBody String getAllDependente() {
    Iterable<Dependente> resultado = DependenteRepository.findAll();
    return dependenteLista.Dependentelista(resultado);
  }
    
  @GetMapping(path="/DependenteFiltro")
  public @ResponseBody String getDependente(@RequestParam Integer idade) {
    Iterable<Dependente> resultado = DependenteRepository.findDependente(idade);
    return dependenteLista.Dependentelista(resultado);
  } 

  @GetMapping(path="/FiltroDependenteForm")
  public String filtroForm() {
    return "FiltroDependenteForm";
  } 
}
