package EmployeTest.playerModule.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/player")
public class PlayerController {

@Autowired
private PlayerRepo playerRepo;
@Autowired
private ClubRepo clubRepo;

    @PostMapping("/create")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('PLAYER_ADMIN')")
    public ResponseEntity<?> addPlayer(@RequestBody Player player){
    playerRepo.save(player);
    return  new ResponseEntity<>(player, HttpStatus.OK);
    }

   @GetMapping("/get/{id}")
   //@PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('PLAYER_ADMIN')")
    public ResponseEntity<?> getById(@PathVariable Long id){
        playerRepo.deleteById(id);
        return  new ResponseEntity<>("Successfull", HttpStatus.OK);
    }

    @PutMapping("/update")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('PLAYER_ADMIN')")
    public ResponseEntity<?> update(@RequestBody Player player){
    playerRepo.save(player);
    return  new ResponseEntity<>(player, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('PLAYER_ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        playerRepo.deleteById(id);
        return  new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @GetMapping("/countPlayerByClub/{location}")
    //@PreAuthorize("hasAuthority('SUPER_ADMIN') or hasAuthority('PLAYER_ADMIN')")
    public ResponseEntity<?> playerByClubName(@PathVariable String location){
    List<String> emptyList=new ArrayList<>();
    List<Map<String,Object>> lst  = clubRepo.getTotalplayerOfAClub(emptyList,location);
    return  new ResponseEntity<>(lst, HttpStatus.OK);
    }


}
