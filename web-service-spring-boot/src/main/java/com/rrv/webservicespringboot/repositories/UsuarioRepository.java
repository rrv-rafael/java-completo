package com.rrv.webservicespringboot.repositories;

import com.rrv.webservicespringboot.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
