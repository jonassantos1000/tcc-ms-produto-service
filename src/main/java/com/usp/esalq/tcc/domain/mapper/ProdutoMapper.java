package com.usp.esalq.tcc.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.usp.esalq.tcc.domain.entity.ProdutoEntity;
import com.usp.esalq.tcc.domain.entity.UsuarioEntity;
import com.usp.esalq.tcc.domain.model.produto.DadosProdutoVO;
import com.usp.esalq.tcc.domain.model.produto.ProdutoVO;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
	
	@Mapping(target = "id", ignore = true)
	ProdutoEntity toProdutoEntity(DadosProdutoVO dadosProduto, UsuarioEntity usuario);

	ProdutoVO toProdutoVO(ProdutoEntity produto);

	@Mapping(target = "produto.usuario", source = "usuario")
	void merge(@MappingTarget ProdutoEntity produto, DadosProdutoVO dadosProduto, UsuarioEntity usuario);
}
