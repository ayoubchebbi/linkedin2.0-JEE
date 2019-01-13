package com.isamm.linkedin.DAO;

import com.isamm.linkedin.beans.*;

import java.util.List;

public interface LikeDAO {

    public boolean add(Like like);
    public boolean delete(Like like);
    public boolean edit(Like like);
    public List<Like> getAll();
    public Like like(int id) ;
    public Like exist(int id,int id1) ;

}
