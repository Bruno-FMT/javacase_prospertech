package br.com.prosper.casejava01.repository;

import br.com.prosper.casejava01.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
