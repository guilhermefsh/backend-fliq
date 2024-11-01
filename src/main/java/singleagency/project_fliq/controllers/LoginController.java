package singleagency.project_fliq.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import singleagency.project_fliq.dto.LoginRequest;
import singleagency.project_fliq.dto.LoginResponse;
import singleagency.project_fliq.services.LoginService;

@RestController
@AllArgsConstructor
@RequestMapping("/fliq/api/auth")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        var response = loginService.authenticateUser(loginRequest);
        return ResponseEntity.ok(response);
    }

}
