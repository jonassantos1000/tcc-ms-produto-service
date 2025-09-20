package com.usp.esalq.tcc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usp.esalq.tcc.domain.model.produto.DadosProdutoVO;
import com.usp.esalq.tcc.domain.model.produto.ProdutoVO;
import com.usp.esalq.tcc.services.ProdutoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

	private final ProdutoService produtoService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	private ProdutoVO cadastrar(@RequestBody DadosProdutoVO dadosProduto) {
		return produtoService.cadastrar(dadosProduto);
	}
	
	@PutMapping("/{id}")
	private void atualizar(@PathVariable Long id, @RequestBody DadosProdutoVO dadosProduto) {
		produtoService.atualizar(id, dadosProduto);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	private void remover(@PathVariable Long id) {
		produtoService.remover(id);
	}
}
