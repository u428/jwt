package jwt.jwt.Service.ServiceImp;

import jwt.jwt.Model.DTO.GameDTO;
import jwt.jwt.Model.Entity.Game;
import jwt.jwt.Repository.GameRepository;
import jwt.jwt.Service.GameService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    public GameRepository gameRepository;


    @Override
    public List<GameDTO> getAllGames() {
        List<Game> game = gameRepository.findAll();
        List<GameDTO> list =new ArrayList<>();
        for (int i = 0; i < game.size(); i++) {
            GameDTO gameDTO=new GameDTO();
            BeanUtils.copyProperties(game.get(i), gameDTO);
            list.add(gameDTO);
        }
        return list;
    }
}
