package com.ghostdovahkiin.LibrApi.user.services;

import com.ghostdovahkiin.LibrApi.user.User;
import com.ghostdovahkiin.LibrApi.user.UserDTO;

@FunctionalInterface
public interface SaveUserService {
    void save(User user);
}