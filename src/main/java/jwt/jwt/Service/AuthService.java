package jwt.jwt.Service;

import jwt.jwt.Model.DTO.UserDto;

public interface AuthService {

    UserDto findCurrentUserByEmail(String email);
}
