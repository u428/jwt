package jwt.jwt.Controller;


import jwt.jwt.Context.Exception.ErrorMessage;
import jwt.jwt.Context.Exception.UserServiceException;
import jwt.jwt.Enams.RequestOperationName;
import jwt.jwt.Enams.RequestOperationStatus;
import jwt.jwt.Model.DTO.UserDto;
import jwt.jwt.Model.Entity.UserEntity;
import jwt.jwt.Model.LoginModel.UserDetailsRequestModel;
import jwt.jwt.Model.LoginModel.UserRest;
import jwt.jwt.Model.Responce.OperationStatusModel;
import jwt.jwt.Security.CurrentUser;
import jwt.jwt.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path="/{userId}"
//    produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public UserRest getUser(@PathVariable String userId, @CurrentUser String email){
        UserRest returnValue= new UserRest();
        UserDto createUser=userService.getUserbyUserId(userId);
        BeanUtils.copyProperties(createUser , returnValue);
        return returnValue;
    }



//    @PutMapping(path="/{userId}"
////            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE},
////            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
//    )
//    public UserRest updateUser(@PathVariable String userId, @RequestBody UserDetailsRequestModel userDetail){
//        UserRest returnValue= new UserRest();
//
//        UserDto userDto=new UserDto();
//
//        BeanUtils.copyProperties(userDetail , userDto);
//
//        UserDto updateUser=userService.updateUser(userId, userDto);
//
//        BeanUtils.copyProperties(updateUser , returnValue);
//
//        return returnValue;
//    }
//
    @DeleteMapping(path="/{userId}")
    public OperationStatusModel deleteUser(@PathVariable String userId){
        OperationStatusModel returnValue=new OperationStatusModel();
        userService.deleteUser(userId);
        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        return returnValue;
    }
//
//    @GetMapping(produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    public List<UserRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
//                                   @RequestParam(value = "limit", defaultValue = "25") int limit){
//
//        List<UserRest> returnValue=new ArrayList<>();
//        List<UserDto> users=userService.getUsers(page, limit);
//        for (UserDto userDto: users){
//            UserRest userRest=new UserRest();
//            BeanUtils.copyProperties(userDto , userRest);
//            returnValue.add(userRest);
//        }
//        return returnValue;
//
//    }
//
//
//    @GetMapping(path="/{userId}/addresses/",
//            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    public List<AddressRest> getUserAddresses(@PathVariable String userId){
//        ModelMapper modelMapper=new ModelMapper();
//        List<AddressRest> returnValue= new ArrayList<>();
//        List<GameUserDTO> addressesDTO=addressService.getAddresses(userId);
//        if (addressesDTO!=null&&!addressesDTO.isEmpty()) {
//            Type listType = new TypeToken<List<AddressRest>>() {
//            }.getType();
//            returnValue.add(modelMapper.map(addressesDTO, listType));
//        }
//
//        return returnValue;
//    }
//
//    @GetMapping(path="/{userId}/addresses/{addressId}",
//            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    public AddressRest getUserAddress(@PathVariable String addressId){
//        GameUserDTO gameUSerDTO =addressService.getAddress(addressId);
//
//        ModelMapper modelMapper=new ModelMapper();
//
//        return modelMapper.map(gameUSerDTO, AddressRest.class);
//    }

}
