package com.example.foro.models.Service;

import java.util.List;

import com.example.foro.models.Entity.Usuario;

public interface IUsuarioService {

    public List<Usuario> findAll();

    public void save(Usuario usuario);

    public Usuario findOne(Long id);

    public void delete(Long id); 
    
}
