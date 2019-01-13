package com.isamm.linkedin.services;

import com.isamm.linkedin.beans.*;
import java.util.*;

public interface FriendsService {

    public boolean add(Friends friend);
    public boolean delete(Friends friend);
    public boolean edit(Friends friend);
    public List<Friends> getAll();
    public Friends friend(int id) ;

    List<Users> getFriendListService(Users user);
    List<Users> getFriendSearshService(String name);
    List<Users> getNoFriendListService(Users user);
    void addFriendService(int id1, int id2);
    void deleteFriendService(int id1, int id2);
}
