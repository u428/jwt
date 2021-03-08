package jwt.jwt.Service.ServiceImp;

import jwt.jwt.Context.Exception.ErrorMessage;
import jwt.jwt.Context.Exception.UserServiceException;
import jwt.jwt.Enams.StatusMode;
import jwt.jwt.Model.DTO.UserDto;
import jwt.jwt.Model.Entity.UserEntity;
import jwt.jwt.Model.Responce.Utils;
import jwt.jwt.Repository.UserRepository;
import jwt.jwt.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {
        if (userRepository.findUserByEmail(user.getEmail())!=null)throw new RuntimeException("Record Already Exists");



//        List<Game_User> list=new ArrayList<>();
//        for (int i = 0; i < user.getAdresses().size(); i++) {
//            Game_User addressEntity=new Game_User();
//            BeanUtils.copyProperties(user.getAdresses().get(i), addressEntity);
//            list.add(addressEntity);
//        }


        UserEntity userEntity=new UserEntity();
//        BeanUtils.copyProperties(user, userEntity);
        ModelMapper modelMapper=new ModelMapper(); //berdanam yaxshi ishlamadi bi ModelMapper
        userEntity=modelMapper.map(user, UserEntity.class);
        String publicUserId=utils.generatedId(30);
        userEntity.setUserId(publicUserId);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setEmailVerificationStatus(false); // Bini ozim false atdim bolmasa ishlamadi
        userEntity.setStatus(StatusMode.USER_ROLE);
        UserEntity storedUserDetails =userRepository.save(userEntity);

        UserDto returnValue=modelMapper.map(storedUserDetails, UserDto.class);

        return returnValue;
    }

    @Override
    public UserDto getUser(String email) {
        UserEntity userEntity=userRepository.findUserByEmail(email);
        if (userEntity==null) throw new UsernameNotFoundException(email);
        UserDto returnValue=new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);
        return returnValue;
    }

    @Override
    public UserDto getUserbyUserId(String userId) {
        UserEntity userEntity=userRepository.findUserEntityByUserId(userId);
        if (userEntity==null) throw new UsernameNotFoundException(userId);
        UserDto returnValue=new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);
        return returnValue;
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        UserEntity userEntity=userRepository.findUserEntityByUserId(userId);
        if (userEntity==null) throw new UserServiceException(ErrorMessage.NO_RECORD_FOUND.getErrorMessages());
        UserDto returnValue=new UserDto();

        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());

        UserEntity userEntity1=userRepository.save(userEntity);
        BeanUtils.copyProperties(userEntity1, returnValue);
        return returnValue;
    }

    @Override
    public void deleteUser(String userId) {
        UserEntity userEntity=userRepository.findUserEntityByUserId(userId);
        if (userEntity==null) throw new UserServiceException(ErrorMessage.NO_RECORD_FOUND.getErrorMessages());

        userRepository.delete(userEntity);
    }

    @Override
    public List<UserDto> getUsers(int page, int limit) {
        if (page>0) --page;
        List<UserDto> returnValue= new ArrayList<>();
        Pageable pageable= PageRequest.of(page, limit);
        Page<UserEntity> page1= userRepository.findAll(pageable);
        List<UserEntity> list=page1.getContent();

        for (UserEntity userEntity : list) {
            UserDto userDto=new UserDto();
            BeanUtils.copyProperties(userEntity, userDto);
            returnValue.add(userDto);
        }
        return returnValue;
    }


    @Override
    public boolean findbyCardNumb(BigInteger cardNumb) {
        UserEntity userEntity = userRepository.findByCardNumber(cardNumb);
        if (userEntity==null){
            return true;
        }
        return false;
    }

    @Override
    public boolean findByEmail(String email) {
        UserEntity userEntity = userRepository.findUserByEmail(email);
        if (userEntity==null){
            return true;
        }
        return false;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity=userRepository.findUserByEmail(email);
        if (userEntity==null) throw new UsernameNotFoundException(email);
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), getAuthorities(userEntity));
    }


    private static Collection<? extends GrantedAuthority> getAuthorities(UserEntity user) {
//        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(String.valueOf(user.getStatus()));
        return authorities;
    }

}
