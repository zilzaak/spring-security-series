package EmployeTest.playerModule.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ClubRepo extends JpaRepository<Club,Long> {


//    @Query("select distinct p.country , p.name , clb.name , clb.playingyear from Player p join p.clubList clb where clb.name=:club ")
//    List<Object[]> getTotalplayerOfAClub(@Param("club") String club);

//    @Query("select distinct p.country as country , p.name as playername , c.name as clubname ,  " +
//            " c.playingyear as playingyear from " +
//            "  Club c " +
//            "  left join c.player p " +
//            " where c.name=:club ")
//    List<Map<String,Object>> getTotalplayerOfAClub(@Param("club") String club);

    @Query("select distinct p.country as country , p.name as playername , c.name as clubname ,  " +
            " c.playingyear as playingyear from " +
            "  Club c " +
            "  left join c.player p " +
            " where c.name in :club or c.location=:loc ")
    List<Map<String,Object>> getTotalplayerOfAClub(@Param("club") List<String> club,
                                                   @Param("loc") String loc);


}
