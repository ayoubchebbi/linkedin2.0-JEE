package com.isamm.linkedin.services;

import com.isamm.linkedin.DAO.*;
import com.isamm.linkedin.DAO.*;
import com.isamm.linkedin.beans.*;

import java.util.List;

public class LikeServiceImpl implements LikeService {

    LikeDAO likeDAO = new LikeDAOImpl();

    @Override
    public boolean add(Like like) {
        return likeDAO.add(like);
    }

    @Override
    public boolean delete(Like like) {
        return likeDAO.delete(like);
    }

    @Override
    public boolean edit(Like like) {
        return likeDAO.edit(like);
    }

    @Override
    public List<Like> getAll() {
        return likeDAO.getAll();
    }

    @Override
    public Like like(int id) {
        return likeDAO.like(id);
    }

    @Override
    public Like exist(int id,int id1) {
        return likeDAO.exist(id,id1);
    }
}
