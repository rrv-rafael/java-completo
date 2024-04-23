package com.rrv.webservicemongodb.services;

import com.rrv.webservicemongodb.domain.Usuario;
import com.rrv.webservicemongodb.dto.UsuarioDTO;
import com.rrv.webservicemongodb.repository.UsuarioRepository;
import com.rrv.webservicemongodb.services.exception.ObjectNotFoundException;
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

    public Usuario findById(String codUsuario) {
        return usuarioRepository.findById(codUsuario).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado."));
    }

    public Usuario insert(Usuario usuario) {
        return usuarioRepository.insert(usuario);
    }

    public void deleteById(String codUsuario) {
        findById(codUsuario);
        usuarioRepository.deleteById(codUsuario);
    }

    public void update(Usuario usuarioInformado) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioInformado.getCodUsuario());

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();

            usuario.setNome(usuarioInformado.getNome());
            usuario.setEmail(usuarioInformado.getEmail());

            usuarioRepository.save(usuario);
        }

        throw new ObjectNotFoundException("Usuário não encontrado.");
    }

    public Usuario fromDTO(UsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO.getCodUsuario(), usuarioDTO.getNome(), usuarioDTO.getEmail());
    }
}
