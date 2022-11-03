package com.example.foro.models.Dao;

import java.util.List;

import com.example.foro.models.Entity.Usuario;

public interface IUsuarioDao {
    
    public List<Usuario> findAll();

  public void save(Usuario usuario);

    public Usuario findOne(Long id);

    public void delete(Long id);
}
