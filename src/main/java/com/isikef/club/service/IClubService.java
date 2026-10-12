package com.isikef.club.service;

import com.isikef.club.entities.Club;
import com.isikef.club.exceptions.ResourceNotFound;

import java.util.List;

public interface IClubService {
    public Club createClub(String name , String description);
    public Club updateClub(Long id , Club club);
    public void deleteClub(Long id) throws ResourceNotFound;
    public Club getClubById(long id) throws ResourceNotFound;
    public List<Club> getAllClubs();
}