package com.example.foro.models.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.foro.models.Entity.Usuario;

@Repository("UsuarioDaoJPA")
public class UsuarioDaoImp implements IUsuarioDao {

    @PersistenceContext
    private EntityManager em;
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return em.createQuery("from Usuario").getResultList();
    }
    @Override
    @Transactional
    public void save(Usuario usuario) {
        if(usuario.getId() != null && usuario.getId()>0){
            em.merge(usuario);
        }
        else{
            em.persist(usuario);
        }
        
    }
    @Override
    @Transactional
    public Usuario findOne(Long id) {
        return em.find(Usuario.class, id);
    }
    @Override
    @Transactional
    public void delete(Long id) {

        Usuario usuario = findOne(id);
        em.remove(usuario);
        
    } 
    
}
