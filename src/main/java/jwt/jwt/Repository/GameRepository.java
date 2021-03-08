package jwt.jwt.Repository;

import jwt.jwt.Model.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {


}
