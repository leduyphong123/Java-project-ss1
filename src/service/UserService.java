package service;

import entity.User;

public interface UserService {
    boolean register(User user);

    boolean login(String userName, String passWord);

    void getAll();

    User viewCurrentUserInfor();

    boolean logout();
}
