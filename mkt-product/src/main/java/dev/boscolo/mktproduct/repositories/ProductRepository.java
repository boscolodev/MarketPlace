package dev.boscolo.mktproduct.repositories;

import dev.boscolo.mktproduct.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Boolean existsByName(String name);
}
