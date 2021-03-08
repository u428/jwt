package jwt.jwt.Repository;

import jwt.jwt.Model.Entity.Game_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameUserRepository extends JpaRepository<Game_User, Long> {


}
