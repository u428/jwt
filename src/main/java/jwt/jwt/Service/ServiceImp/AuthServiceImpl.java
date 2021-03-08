package jwt.jwt.Service.ServiceImp;


import jwt.jwt.Model.DTO.UserDto;
import jwt.jwt.Model.Entity.UserEntity;
import jwt.jwt.Repository.UserRepository;
import jwt.jwt.Service.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto findCurrentUserByEmail(String email) {
        UserDto userDto=new UserDto();
        UserEntity userEntity=userRepository.findUserByEmail(email);
        BeanUtils.copyProperties(userEntity, userDto);
        System.out.println(userEntity.getStatus());
        System.out.println(userDto.getStatus());
        return userDto;
    }
}
