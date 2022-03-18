package org.sqli.authentification.dao;

import org.sqli.authentification.entitie.UserGroup;

import java.util.Optional;

public interface UserGroupDao {
    Optional<UserGroup> findByName(final String name);
}
