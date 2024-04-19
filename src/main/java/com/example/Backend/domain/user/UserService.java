package com.example.Backend.domain.user;

import com.example.Backend.domain.user.dto.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//Java에서는 인터페이스 타입으로 변수를 선언할 수 있습니다.이러한 방법은 객체 지향 프로그래밍에서 다형성을 활용하는 데 중요한 역할을 함.
    private final UserRepository userRepository;

    //생성자 주입 방식으로 의존성 주입!
    @Autowired// Autowired는 스프링에게 해당 생성자를 사용하여 의존성을 주입하라는 지시를 한다.
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(UserRegisterDto userRegisterDto){
        User newUser= new User();
        newUser.setName(userRegisterDto.getName());
        newUser.setEmail(userRegisterDto.getEmail());
        newUser.setPassword(userRegisterDto.getPassword());// 실제 서비스에서는 비밀번호를 암호화하여 저장해야 합니다.
        return userRepository.save(newUser);


    }
    public String encodePassword(String password, PasswordEncoder passwordEncoder){
        return passwordEncoder.encode(password);
    }// "단일 책임 원칙(Single Responsibility Principle, SRP)"과 "분리 및 추상화 지키기위해 User.java에서 Userservice로이동
//UserService 사용자의 데이터를 처리하고 관리하는 데 필요한 로직을 캡슐화 -> 여기가 적합.

}