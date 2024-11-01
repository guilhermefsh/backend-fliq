package singleagency.project_fliq.controllers;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import singleagency.project_fliq.dto.CreateUserDto;
import singleagency.project_fliq.services.UserRegisterService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fliq/api/auth")
public class UserRegisterController {

    private final UserRegisterService userRegisterService;

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<Void> registerUsers(@RequestBody CreateUserDto createUserDto){
        userRegisterService.registerUsers(createUserDto);
        return ResponseEntity.ok().build();
    }
}
