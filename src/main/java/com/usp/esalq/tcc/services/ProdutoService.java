package com.usp.esalq.tcc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usp.esalq.tcc.domain.entity.ProdutoEntity;
import com.usp.esalq.tcc.domain.mapper.ProdutoMapper;
import com.usp.esalq.tcc.domain.model.produto.DadosProdutoVO;
import com.usp.esalq.tcc.domain.model.produto.ProdutoVO;
import com.usp.esalq.tcc.exceptions.MsgException;
import com.usp.esalq.tcc.repository.ProdutoRepository;
import com.usp.esalq.tcc.utils.SecurityContextUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {
	
	private final ProdutoMapper mapper;
	private final ProdutoRepository produtoRepository;
	
	public ProdutoVO cadastrar(DadosProdutoVO dadosProduto) {
		ProdutoEntity produto = produtoRepository.save(mapper.toProdutoEntity(dadosProduto, SecurityContextUtils.getUsuario()));
		return mapper.toProdutoVO(produto);
	}

	public void atualizar(Long id, DadosProdutoVO dadosProduto) {
		Optional<ProdutoEntity> produto = produtoRepository.findById(id);
		
		if (produto.isEmpty()) {
			throw new MsgException("Produto não encontrado");
		}
		ProdutoEntity produtoEntity = produto.get();
		mapper.merge(produtoEntity, dadosProduto, SecurityContextUtils.getUsuario());
	}

	public void remover(Long id) {
		
		Optional<ProdutoEntity> produto = produtoRepository.findById(id);
		
		if (produto.isEmpty()) {
			throw new MsgException("Produto não encontrado");
		}
		
		produtoRepository.deleteById(id);
	}
}
