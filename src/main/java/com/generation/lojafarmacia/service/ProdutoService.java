package com.generation.lojafarmacia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.lojafarmacia.model.Produto;
import com.generation.lojafarmacia.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public boolean verificarEstoque(Long produtoId, Integer quantidadeSolicitada) {

		Produto produto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado"));

		if (produto.getQtdEstoque() >= quantidadeSolicitada) {
			return true;
		} else {
			throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
		}
	}
}
