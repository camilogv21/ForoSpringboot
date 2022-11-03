package com.example.foro.models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.foro.models.Dao.IUsuarioDao;
import com.example.foro.models.Entity.Usuario;

@Service
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }
    @Override
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
        
    }
    @Override
    public Usuario findOne(Long id) {
        return usuarioDao.findOne(id);
    }
    @Override
    public void delete(Long id) {
        usuarioDao.delete(id);
        
    } 
    
    
}
