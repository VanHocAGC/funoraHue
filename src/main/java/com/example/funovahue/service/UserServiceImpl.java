package com.example.funovahue.service;

import com.example.funovahue.entity.Users;
import com.example.funovahue.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    @Override
    public Users getUserByUsername(String username) {
        return null;
    }
}
