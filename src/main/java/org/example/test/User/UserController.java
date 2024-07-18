package org.example.test.User;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.test._core.utils.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    @PostMapping("/users")
    public ResponseEntity<?> add(@RequestBody UserRequest.AddDTO reqDTO, Errors errors) {
        UserResponse.등록DTO respDTO = userService.회원등록(reqDTO);
        return ResponseEntity.ok(respDTO);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<?> userinfo(@PathVariable Long id){
        UserResponse.조회DTO respDTO = userService.회원조회(id);
        return ResponseEntity.ok(respDTO);
    }

    @PostMapping("/api/users/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserRequest.UpdateDTO reqDTO, Errors errors) {
        SessionUser newSessionUser = userService.회원수정(id, reqDTO);
        return ResponseEntity.ok(newSessionUser);
    }
}
