package com.github.enriqueabsurdum.interfaces;

import com.github.enriqueabsurdum.models.User;

public interface UserDao extends GenericDao<User, Integer> {

    public User getLogin(String username, String password);

    public User getByRun(String value);
}
