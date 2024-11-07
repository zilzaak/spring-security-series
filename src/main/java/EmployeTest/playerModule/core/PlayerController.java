package EmployeTest.playerModule.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addPlayer(@RequestBody Player player){
    playerRepo.save(player);
    return  new ResponseEntity<>(player, HttpStatus.OK);
    }

   @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        playerRepo.deleteById(id);
        return  new ResponseEntity<>("Successfull", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Player player){
    playerRepo.save(player);
    return  new ResponseEntity<>(player, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        playerRepo.deleteById(id);
        return  new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @GetMapping("/countPlayerByClub/{location}")
    public ResponseEntity<?> playerByClubName(@PathVariable String location){
    List<String> emptyList=new ArrayList<>();
    List<Map<String,Object>> lst  = clubRepo.getTotalplayerOfAClub(emptyList,location);
    return  new ResponseEntity<>(lst, HttpStatus.OK);
    }


}
