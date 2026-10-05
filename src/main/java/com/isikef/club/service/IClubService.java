package com.isikef.club.service;

import com.isikef.club.entities.Club;

import java.util.List;

public interface IClubService {
    public Club createClub(String name , String description);
    public Club updateClub(Long id , Club club);
    public void deleteClub(Long id);
    public Club getClubById(long id);
    public List<Club> getAllClubs();
}