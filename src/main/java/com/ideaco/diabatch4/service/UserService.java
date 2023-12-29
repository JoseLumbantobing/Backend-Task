package com.ideaco.diabatch4.service;

import com.ideaco.diabatch4.model.UserModel;
import com.ideaco.diabatch4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getDataList() {
        List<UserModel> data = userRepository.findAllUsers();
        return data;
    }

    public Optional<UserModel> getDataOptional(int userId) {
        Optional<UserModel> data = userRepository.findByJPQLUser(userId);
        return data;
    }

    public String registerUser(String userEmail, String userPassword) {
        Optional<UserModel> existingUser = userRepository.findByUserEmail(userEmail);
        if (existingUser.isPresent()) {
            return "Account already registered";
        } else {
            UserModel newUser = new UserModel();
            newUser.setUserEmail(userEmail);
            newUser.setUserPassword(userPassword);
            userRepository.save(newUser);
            return "Registration successful";
        }
    }

    public String loginUser(String userEmail, String userPassword) {
        Optional<UserModel> userLogin = userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
        return (userLogin != null) ? "Login successful" : "Invalid credentials";
    }

    public List<UserModel> createMultipleUser(List<UserModel> userModels) {
        return userRepository.saveAll(userModels);
    }

    public UserModel updateUserWithBody(UserModel userModel) {
        int userId = userModel.getUserId();
        Optional<UserModel> userModelOptional = userRepository.findById(userId);

        if(userModelOptional.isEmpty()) {
            return null;
        }

        return userRepository.save(userModel);
    }

    public UserModel updateUserWithParams(int userId, String userName) {
        Optional<UserModel> userModelOptional = userRepository.findById(userId);

        UserModel userModel = userModelOptional.get();
        userModel.setUserName(userName);

        return userRepository.save(userModel);
    }

    public boolean deleteUser(int userId) {
        Optional<UserModel> userModelOptional = userRepository.findById(userId);

        if(userModelOptional.isEmpty()) {
            return false;
        }

        userRepository.deleteById(userId);
        return true;
    }
}
