package org.example.test.User;

import lombok.RequiredArgsConstructor;
import org.example.test._core.errors.exception.Exception400;
import org.example.test._core.errors.exception.Exception404;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserJPARepository userJPARepository;

    @Transactional
    public UserResponse.등록DTO 회원등록(UserRequest.AddDTO reqDTO){
        Optional<User> userOP = userJPARepository.findByName(reqDTO.getName());
        if(userOP.isPresent()){
            throw new Exception400("중복된 유저네임입니다");
        }
        User user = userJPARepository.save(reqDTO.toEntity());

        return new UserResponse.등록DTO(user);
    }

    public UserResponse.조회DTO 회원조회(Long id){
        User user = userJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("회원정보를 찾을 수 없습니다"));
        return new UserResponse.조회DTO(user);
    }

    @Transactional
    public SessionUser 회원수정(Long id, UserRequest.UpdateDTO reqDTO){
        User user = userJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("회원정보를 찾을 수 없습니다"));
        user.updateUser(reqDTO.getId(),reqDTO.getName());
        userJPARepository.save(user);

        return new SessionUser(user);
    }
}
