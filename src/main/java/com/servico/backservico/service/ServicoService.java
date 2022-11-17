package com.servico.backservico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.servico.backservico.model.Servico;
import com.servico.backservico.repository.ServicoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ServicoService {

  private ServicoRepository servicoRepository;

  public List<Servico> buscarTodos() {
    return servicoRepository.findAll();
  }

  public List<Servico> buscarServicosPagamentoPendente() {
    return servicoRepository.buscarServicosPagamentoPendente();
  }

  public List<Servico> buscarServicosCancelados() {
    return servicoRepository.buscarServicosCancelados();
  }

  public Servico inserir(Servico servico) {
    if (servico.getValorPago() == null || servico.getValorPago() == 0 || servico.getDataPagamento() == null) {
      servico.setStatus("PENDENTE");
    }
    return servicoRepository.saveAndFlush(servico);

  }

  public Servico alterar(Servico servico) {
    if (servico.getValorPago() != null && servico.getValorPago() > 0 && servico.getDataPagamento() != null) {
      servico.setStatus("REALIZADO");
    }
    return servicoRepository.saveAndFlush(servico);
  }

  public void cancelarServico(Long id) {
    Servico servico = servicoRepository.findById(id).get();
    servico.setStatus("CANCELADO");
    servicoRepository.save(servico);
  }

  public void excluir(Long id) {
    Servico servico = servicoRepository.findById(id).get();
    servicoRepository.delete(servico);
  }

}
