package br.com.prosper.casejava01.service;

import br.com.prosper.casejava01.entity.ProdutoEntity;
import br.com.prosper.casejava01.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoEntity> getAll()
    {
        return produtoRepository.findAll();
    }

    public ProdutoEntity getById(Long id) throws Exception
    {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);
        return produtoEntity.orElseThrow(
                ()-> new Exception(
                        "Produto com id " + id + " não encontrado!"
                )
        );
    }

    public ProdutoEntity create(ProdutoEntity produtoEntity)
    {
        return produtoRepository.save(produtoEntity);
    }

    public ProdutoEntity update(Long id, ProdutoEntity produtoEntity) throws Exception {
        ProdutoEntity updatedProduto = getById(id);

        if (produtoEntity != null){
            produtoEntity.setNome(updatedProduto.getNome());
            produtoEntity.setPreco(updatedProduto.getPreco());
            produtoEntity.setDescricao(updatedProduto.getDescricao());
        }

        return produtoRepository.save(produtoEntity);
    }

    public void delete(Long id) throws Exception {
        produtoRepository.findById(id).orElseThrow(
                ()-> new Exception(
                        "Produto com id " + id + " não encontrado"
                )
        );
    }
}
