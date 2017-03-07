package com.pilarski.mmap.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pilarski.mmap.domain.User;
import com.pilarski.mmap.repository.RoleRepository;
import com.pilarski.mmap.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }
    
    @Override
	public User findUser(long id) {
		return userRepository.findById(id);
	}

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User findByEmailAndActiveTrue(String email) {
		return userRepository.findByEmail(email);
	}

}
