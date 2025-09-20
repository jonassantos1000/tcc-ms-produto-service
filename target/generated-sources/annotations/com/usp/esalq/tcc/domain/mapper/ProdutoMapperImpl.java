package com.usp.esalq.tcc.domain.mapper;

import com.usp.esalq.tcc.domain.entity.ProdutoEntity;
import com.usp.esalq.tcc.domain.entity.UsuarioEntity;
import com.usp.esalq.tcc.domain.model.produto.DadosProdutoVO;
import com.usp.esalq.tcc.domain.model.produto.ProdutoVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-20T15:08:38-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public ProdutoEntity toProdutoEntity(DadosProdutoVO dadosProduto, UsuarioEntity usuario) {
        if ( dadosProduto == null && usuario == null ) {
            return null;
        }

        ProdutoEntity produtoEntity = new ProdutoEntity();

        if ( dadosProduto != null ) {
            produtoEntity.setDescricao( dadosProduto.descricao() );
            produtoEntity.setPreco( dadosProduto.preco() );
        }
        produtoEntity.setUsuario( usuario );

        return produtoEntity;
    }

    @Override
    public ProdutoVO toProdutoVO(ProdutoEntity produto) {
        if ( produto == null ) {
            return null;
        }

        ProdutoVO.ProdutoVOBuilder produtoVO = ProdutoVO.builder();

        produtoVO.descricao( produto.getDescricao() );
        produtoVO.id( produto.getId() );
        produtoVO.preco( produto.getPreco() );

        return produtoVO.build();
    }

    @Override
    public void merge(ProdutoEntity produto, DadosProdutoVO dadosProduto, UsuarioEntity usuario) {
        if ( dadosProduto == null && usuario == null ) {
            return;
        }

        if ( dadosProduto != null ) {
            produto.setDescricao( dadosProduto.descricao() );
            produto.setPreco( dadosProduto.preco() );
        }
        if ( usuario != null ) {
            produto.setUsuario( usuario );
            produto.setId( usuario.getId() );
        }
    }
}
