package jwt.jwt.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class RoleController {

    @PostMapping("/adding")
    public String addRole(){

        return "true";
    }
}
