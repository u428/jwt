package jwt.jwt.Controller;


import jwt.jwt.Model.DTO.GameDTO;
import jwt.jwt.Model.LoginModel.Gaming.ReturnGame;
import jwt.jwt.Service.GameService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("game")
public class GameController {

    @Autowired
    public GameService gameService;

    @GetMapping
    public List<ReturnGame> getAllGames(){
        List<ReturnGame> list=new ArrayList<>();
        List<GameDTO> gameDTO = gameService.getAllGames();
        for (int  i=0;i<gameDTO.size();i++){
            ReturnGame returnGame=new ReturnGame();
            BeanUtils.copyProperties(returnGame, gameDTO.get(i));
            list.add(returnGame);
        }
        return list;
    }



}
