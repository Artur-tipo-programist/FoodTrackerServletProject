package ua.external.servlets.dao;

import ua.external.servlets.entity.User;

import java.util.Optional;

/**
 * Interface that implements additional behavior for UserDao
 */
public interface IUserDao {
    Optional<User> findByLogin(String login) throws DaoException;
    boolean userIsExist(String login, String password) throws DaoException;
}
