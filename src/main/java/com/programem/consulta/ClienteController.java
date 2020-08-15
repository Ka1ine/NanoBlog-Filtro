package com.programem.consulta;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;

  private ClienteLista clientelista = new ClienteLista();

  @GetMapping("/")
  public String clienteForm(){
    return "ClienteForm";
  }

  @PostMapping(path="/Insere") // Map ONLY POST Requests
  public @ResponseBody String addNewCliente (
    @RequestParam String nome
    ,@RequestParam Integer idade
    ,@RequestParam String endereco
  ) {
      Cliente c = new Cliente();
      c.setNome(nome);
      c.setIdade(idade);
      c.setEndereco(endereco);
      clienteRepository.save(c);
      return nome+" "+idade+" "+endereco;
    } 

  @GetMapping(path="/ClienteLista")
  public @ResponseBody String getAllCliente() {
    Iterable<Cliente> resultado = clienteRepository.findAll();
    return clientelista.listaCliente(resultado);
  }

  @GetMapping(path="/Filtro")
  public @ResponseBody String getCliente(@RequestParam Integer idade) {
    Iterable<Cliente> resultado = clienteRepository.findCliente(idade);
    return clientelista.listaCliente(resultado);
  } 

  @GetMapping(path="/FiltroForm")
  public String filtroForm() {
    return "FiltroForm";
  } 

  @GetMapping(path="/updadeForm")
  public String updadeForm() {
    return "updadeForm";
  } 

  @PostMapping(path="/update")
  public @ResponseBody String updateCliente(
  @RequestParam Integer idade,
  @RequestParam Integer id) 
  {
    clienteRepository.findById(id);
    Optional<Cliente> o = clienteRepository.findById(id);
    if(o.isPresent()){
      Cliente c = o.get();
      c.setIdade(idade);
      clienteRepository.save(c);
    }
    return "updateResposta";
  } 
   
  @GetMapping(path="/deleteForm")
  public String deleteForm() {
    return "deleteForm";
  } 

  @PostMapping(path="/delete")
  public @ResponseBody String deleteCliente(
  @RequestParam Integer id) 
  {
    clienteRepository.deleteById(id);
    return "updateResposta";
  } 
}
