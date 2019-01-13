package com.isamm.linkedin.DAO;

import com.isamm.linkedin.beans.*;
import java.util.*;

public interface FriendsDAO {

    public boolean add(Friends friend);
    public boolean delete(Friends friend);
    public boolean edit(Friends friend);
    public List<Friends> getAll();
    public List<Users> getFriends(int id);
    public List<Users> getNoFriends(int id);
    public Friends friend(int id) ;

    void addFriend(int id1, int id2);
    void deleteFriend(int id1,int id2);

}
