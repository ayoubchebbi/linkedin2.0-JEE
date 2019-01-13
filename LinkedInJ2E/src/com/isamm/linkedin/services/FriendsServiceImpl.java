package com.isamm.linkedin.services;

import com.isamm.linkedin.DAO.*;
import com.isamm.linkedin.beans.*;

import java.util.List;

public class FriendsServiceImpl implements FriendsService {

    FriendsDAO friendsService = new FriendsDAOImpl();
    UserDAO userService = new UserDAOImpl();

    @Override
    public boolean add(Friends friend) {
        return friendsService.add(friend);
    }

    @Override
    public boolean delete(Friends friend) {
        return friendsService.delete(friend);
    }

    @Override
    public boolean edit(Friends friend) {
        return friendsService.edit(friend);
    }

    @Override
    public List<Friends> getAll() {
        return friendsService.getAll();
    }

    @Override
    public Friends friend(int id) {
        return friendsService.friend(id);
    }

    @Override
    public List<Users> getFriendListService(Users user){
        return friendsService.getFriends(user.getId());
    }
    @Override
    public List<Users> getFriendSearshService(String name){
        return userService.searshFriends(name);
    }
    @Override
    public List<Users> getNoFriendListService(Users user){
        return friendsService.getNoFriends(user.getId());
    }
    @Override
    public void addFriendService(int id1, int id2){
        friendsService.addFriend(id1,id2);
    }
    @Override
    public void deleteFriendService(int id1, int id2){
        friendsService.deleteFriend(id1,id2);
    }
}
