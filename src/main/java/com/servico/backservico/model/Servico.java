package com.servico.backservico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "servico")
public class Servico {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String nomeCliente;

  private String descricaoServico;

  private String status; // "PENDENTE", "REALIZADO" ou "CANCELADO"

  @Temporal(TemporalType.DATE)
  private Date dataInicio = new Date();

  @Temporal(TemporalType.DATE)
  private Date dataTermino;

  @Temporal(TemporalType.DATE)
  private Date dataPagamento;

  private Double valorServico;

  private Double valorPago;

}
