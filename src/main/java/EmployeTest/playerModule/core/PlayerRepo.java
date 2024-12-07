package EmployeTest.playerModule.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepo extends JpaRepository<Player,Long> {

    @Query("select distinct p.country , p.name , clb.name , clb.playingyear from Player p join p.clubList clb where clb.name=:club ")
    List<Object[]> getTotalplayerOfAClub(@Param("club") String club);
}
