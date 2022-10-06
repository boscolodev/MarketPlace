package dev.boscolo.mktuser.repositories;

import dev.boscolo.mktuser.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    boolean existsByAuthority(String authority);
}
