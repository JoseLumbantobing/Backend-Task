package com.ideaco.ewallet.service;

import com.ideaco.ewallet.dto.EditEmailDTO;
import com.ideaco.ewallet.exception.UserNotFoundException;
import com.ideaco.ewallet.model.UserModel;
import com.ideaco.ewallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public EditEmailDTO editUserEmail(int userId, String newEmail) throws UserNotFoundException {
        Optional<UserModel> userModelOptional = userRepository.findById(userId);
        if(userModelOptional.isEmpty()){
            throw new UserNotFoundException("Invalid user");
        }

        UserModel userModel = userModelOptional.get();
        userModel.setUserEmail(newEmail);

        userRepository.save(userModel);

        return convertDTO(userModel);
    }

    public EditEmailDTO convertDTO(UserModel userModel){
        EditEmailDTO editEmailDTO = new EditEmailDTO();
        editEmailDTO.setUserId(userModel.getUserId());
        editEmailDTO.setUserEmail(userModel.getUserEmail());
        return editEmailDTO;
    }
}
