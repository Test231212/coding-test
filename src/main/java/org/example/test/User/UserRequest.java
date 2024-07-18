package org.example.test.User;

import lombok.Data;

public class UserRequest {

    @Data
    public static class AddDTO {

        private Long id;
        private String name;

        public User toEntity(){
            return User.builder()
                    .name(name)
                    .build();
        }
    }

    @Data
    public static class UpdateDTO {
        private Long id;
        private String name;
    }
}
