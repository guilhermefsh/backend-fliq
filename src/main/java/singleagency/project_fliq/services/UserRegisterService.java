package singleagency.project_fliq.services;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import singleagency.project_fliq.dto.CreateUserDto;
import singleagency.project_fliq.entities.Users;
import singleagency.project_fliq.enums.Roles;
import singleagency.project_fliq.exceptions.UserAlreadyExistsException;
import singleagency.project_fliq.repositories.UserRepository;

@Service
@AllArgsConstructor
public class UserRegisterService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bPasswordEncoder;

    public void registerUsers(@RequestBody @Valid CreateUserDto createUserDto){

        var basicRole = Roles.RESTAURANT_PLAN_A;

        var userExist = userRepository.findByEmail(createUserDto.email());
        if(userExist.isPresent()){
            throw new UserAlreadyExistsException();
        }

        var user = new Users();
        user.setName(createUserDto.name());
        user.setEmail(createUserDto.email());
        user.setPassword(bPasswordEncoder.encode(createUserDto.password()));
        user.setRoles(basicRole);

        userRepository.save(user);

    }
}
