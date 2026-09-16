package com.vittorhonorato.cadernoDev.repository;

import com.vittorhonorato.cadernoDev.entity.Caderno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadernoRepository extends JpaRepository<Caderno, Long> {
}
