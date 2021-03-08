package jwt.jwt.Service;

import jwt.jwt.Model.DTO.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.math.BigInteger;
import java.util.List;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto user);
    UserDto getUser(String email);
    UserDto getUserbyUserId(String userId);
    UserDto updateUser(String userId, UserDto userDto);
    void deleteUser(String userId);

    List<UserDto> getUsers(int page, int limit);
    boolean findByEmail(String email);
    boolean findbyCardNumb(BigInteger cardNumb);


    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
