package jwt.jwt.Controller;


import jwt.jwt.Context.Exception.ErrorMessage;
import jwt.jwt.Context.Exception.UserServiceException;
import jwt.jwt.Enams.RequestOperationName;
import jwt.jwt.Enams.RequestOperationStatus;
import jwt.jwt.Model.DTO.UserDto;
import jwt.jwt.Model.LoginModel.UserDetailsRequestModel;
import jwt.jwt.Model.LoginModel.UserRest;
import jwt.jwt.Model.Responce.OperationStatusModel;
import jwt.jwt.Security.CurrentUser;
import jwt.jwt.Service.AuthService;
import jwt.jwt.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;
    @Autowired
    AuthService authService;

    @PostMapping( path = "/signUp"
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public OperationStatusModel createUser(@RequestBody UserDetailsRequestModel userDetail) throws Exception{
        if (userDetail.getEmail().isEmpty()) throw new UserServiceException(ErrorMessage.MISSING_REQUIRED_FIELD.getErrorMessages());
//        UserDto userDto=new UserDto();
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(userDetail , userDto);

        UserDto createUser=userService.createUser(userDto);
        UserRest returnValue=new UserRest();
        OperationStatusModel operationStatusModel=new OperationStatusModel();

        if (userDto.getId()==null) {
            operationStatusModel.setOperationName(RequestOperationName.CREATE.name());
            operationStatusModel.setOperationResult(RequestOperationStatus.ERROR.name());
        }
        operationStatusModel.setOperationName(RequestOperationName.CREATE.name());
        operationStatusModel.setOperationResult(RequestOperationStatus.SUCCESS.name());

        return operationStatusModel;
    }


    @GetMapping(path="/checkCardNumb"
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Boolean> findCardnumb(@RequestParam(value = "cardNumber") BigInteger cardNumber){
        System.out.println(cardNumber);
        boolean returnValue = userService.findbyCardNumb(cardNumber);
        return ResponseEntity.ok(returnValue);
    }


    @GetMapping(path="/checkEmailAvailability"
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public boolean findEmail(@RequestParam(value = "email") String email){
        System.out.println(email);
        boolean returnValue = userService.findByEmail(email);
        return returnValue;
    }


    @GetMapping(path ="/getCurrentUser")
    public UserRest getCurrentUser(@CurrentUser String email){
        System.out.println("Auth Controler");
        System.out.println(email);

        UserDto userDto =authService.findCurrentUserByEmail(email);
        System.out.println(userDto.getStatus());
        UserRest userRest =new UserRest();
        BeanUtils.copyProperties(userDto, userRest);
        return userRest;
    }

}
