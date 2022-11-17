package com.servico.backservico.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servico.backservico.model.Servico;
import com.servico.backservico.service.ServicoService;

import lombok.AllArgsConstructor;

@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/servico")
public class ServicoController {

  private ServicoService servicoService;

  @GetMapping("/")
  public List<Servico> buscarTodos() {
    return servicoService.buscarTodos();
  }

  @GetMapping("/pagamentoPendente")
  public List<Servico> buscarServicosPagamentoPendente() {
    return servicoService.buscarServicosPagamentoPendente();
  }

  @GetMapping("/cancelados")
  public List<Servico> buscarServicosCancelados() {
    return servicoService.buscarServicosCancelados();
  }

  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  @CrossOrigin("http://localhost:3000")
  public Servico inserir(@RequestBody Servico servico) {
    return servicoService.inserir(servico);
  }

  @PostMapping("/{id}")
  public ResponseEntity<Void> cancelar(@PathVariable("id") Long id) {
    servicoService.cancelarServico(id);
    return ResponseEntity.ok().build();
  }

  @PutMapping("/")
  public Servico alterar(@RequestBody Servico servico) {
    return servicoService.alterar(servico);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
    servicoService.excluir(id);

    return ResponseEntity.ok().build();
  }

}
