package com.isikef.club.controller;

import com.isikef.club.entities.Club;
import com.isikef.club.exceptions.ResourceNotFound;
import com.isikef.club.forms.ClubForm;
import com.isikef.club.repository.ClubRepository;
import com.isikef.club.service.IClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clubs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClubController {
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private IClubService iClubService;

    @PostMapping("/create")
    public ResponseEntity createClub(@Valid @RequestBody ClubForm clubForm) {
        Club club = iClubService.createClub(clubForm.getName() , clubForm.getDescription());
        if(club != null)
            return ResponseEntity.ok(club);

        else
            return ResponseEntity.badRequest().body("Club already exists");

    }
    @GetMapping
    public ResponseEntity getClub(){
        List<Club> clubList = iClubService.getAllClubs();
        return ResponseEntity.ok(clubList);
    }
    @GetMapping("/get")
    public ResponseEntity getClubs(@RequestParam Long id) throws ResourceNotFound{
        Club club= iClubService.getClubById(id);
        return ResponseEntity.ok().body(club);
    }
    @DeleteMapping
    public ResponseEntity deleteClub(@RequestParam Long id) throws ResourceNotFound {
        iClubService.deleteClub(id);
        Map<String,Boolean> resp = new HashMap<>();
        resp.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(resp);
    }
}
