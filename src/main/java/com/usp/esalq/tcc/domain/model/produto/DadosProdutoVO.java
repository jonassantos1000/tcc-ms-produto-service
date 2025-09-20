package com.usp.esalq.tcc.domain.model.produto;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record DadosProdutoVO(String descricao, BigDecimal preco) {

}
