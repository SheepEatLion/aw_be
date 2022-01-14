package com.mynameisjunyeong.aw_be.domain.user;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class UserRepositorySupport extends QuerydslRepositorySupport {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     */
    public UserRepositorySupport() {
        super(User.class);
    }
}
