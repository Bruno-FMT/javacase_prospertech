package br.com.prosper.casejava01.controller;

import br.com.prosper.casejava01.entity.ProdutoEntity;
import br.com.prosper.casejava01.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoEntity> getAllProdutos(){
        return produtoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoEntity> getProdutoById(@PathVariable Long id) throws Exception {
        ProdutoEntity produtoEntity = produtoService.getById(id);
        return produtoEntity !=null
                ? ResponseEntity.ok(produtoEntity)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ProdutoEntity postProduto(@RequestBody ProdutoEntity produtoEntity)
    {
        return produtoService.create(produtoEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> updateProduto(@PathVariable Long id, @RequestBody ProdutoEntity produtoEntity) throws Exception {
        ProdutoEntity updatedProduto = produtoService.update(id, produtoEntity);

        return produtoEntity != null
                ? ResponseEntity.ok(updatedProduto)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) throws Exception {
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
