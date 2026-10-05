package com.isikef.club.service;

import com.isikef.club.entities.Club;
import com.isikef.club.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClubServiceImp implements IClubService {

    @Autowired
    ClubRepository clubRepository;
    @Override
    public Club createClub(String name, String description) {
        Club club = null ;
        boolean exist = clubRepository.existsByNameIgnoreCase(name);
        if(!exist){
            club  = new Club();
            club.setName(name);
            club.setDescription(description);
            club.setCreateDate(LocalDateTime.now());
            club.setUpdateDate(LocalDateTime.now());
            club = clubRepository.save(club);
        }
        return club;
    }

    @Override
    public Club updateClub(Long id, Club club) {
        return null;
    }

    @Override
    public void deleteClub(Long id) {
        Club club = getClubById(id);
        clubRepository.delete(club);
    }

    @Override
    public Club getClubById(long id) {
        return clubRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("the club with id : "+id+"not found or has been deleted.")
        );
    }

    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }
}
