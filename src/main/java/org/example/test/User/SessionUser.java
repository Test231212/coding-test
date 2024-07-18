package org.example.test.User;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class SessionUser {
    private Long id;
    private String name;

    @Builder
    public SessionUser(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SessionUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
