package service.impl;

import entity.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    static List<User> listUser = new ArrayList<>();
    static User currentUser;
    @Override
    public boolean register(User user) {
        if(user ==null || user.getPassWord().length()<8){
            return false;
        }

        for (User list: listUser){
            if (list.getUserName()== user.getUserName()){
                return false;
            }
        }
        listUser.add(user);
        return true;
    }

    @Override
    public boolean login(String userName, String passWord) {
        for (User list:listUser){
            if(list.getUserName().equals(userName) && list.getPassWord().equals(passWord)){
                currentUser = list;
                return true;
            }
        }
        return false;
    }

    @Override
    public void getAll() {
        for(User list:listUser){
            System.out.println(list);
        }
    }

    @Override
    public User viewCurrentUserInfor() {
        return this.currentUser;
    }

    @Override
    public boolean logout() {
        if (this.currentUser==null){
            return false;
        }
        this.currentUser=null;
        return true;
    }
}
