package singleagency.project_fliq.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import singleagency.project_fliq.dto.CreateUserDto;
import singleagency.project_fliq.services.UserRegisterService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fliq/api/auth")
public class UserRegisterController {

    private final UserRegisterService userRegisterService;

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<Void> registerUsers(@RequestBody @Valid CreateUserDto createUserDto){
        userRegisterService.registerUsers(createUserDto);
        return ResponseEntity.ok().build();
    }
}
