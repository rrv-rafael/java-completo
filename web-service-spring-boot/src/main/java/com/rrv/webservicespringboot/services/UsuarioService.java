package com.rrv.webservicespringboot.services;

import com.rrv.webservicespringboot.entidades.Usuario;
import com.rrv.webservicespringboot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long codUsuario) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(codUsuario);

        return optionalUsuario.orElse(null);
    }

    public Usuario insert(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(Long codUsuario) {
        usuarioRepository.deleteById(codUsuario);
    }

    public Usuario update(Long codUsuario, Usuario usuario) {
        Usuario entidadeUsuario = usuarioRepository.getReferenceById(codUsuario);
        updateData(entidadeUsuario, usuario);

        return usuarioRepository.save(entidadeUsuario);
    }

    private void updateData(Usuario entidadeUsuario, Usuario usuario) {
        entidadeUsuario.setNome(usuario.getNome());
        entidadeUsuario.setEmail(usuario.getEmail());
        entidadeUsuario.setTelefone(usuario.getTelefone());
    }
}
