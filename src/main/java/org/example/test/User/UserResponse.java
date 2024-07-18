package org.example.test.User;

import lombok.Data;

public class UserResponse {
    @Data
    public static class 등록DTO {
        private Long id;

        public 등록DTO(User user) {
            this.id = user.getId();
        }
    }

    @Data
    public static class 조회DTO {
        private Long id;
        private String name;

        public 조회DTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }
}

