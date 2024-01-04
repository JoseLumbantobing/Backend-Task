package com.ideaco.ewallet.service;

import com.ideaco.ewallet.dto.BalanceDTO;
import com.ideaco.ewallet.exception.UserNotFoundException;
import com.ideaco.ewallet.model.BalanceModel;
import com.ideaco.ewallet.repository.BalanceRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BalanceService {
    @Autowired
    private BalanceRepository balanceRepository;

    public BalanceDTO userBalance(int userId) throws UserNotFoundException {
        Optional<BalanceModel> balanceModelOptional = balanceRepository.findByUserId(userId);

        if(balanceModelOptional.isEmpty()) {
            throw new UserNotFoundException("Invalid user");
        }

        BalanceModel balanceModel = balanceModelOptional.get();
        return convertDTO(balanceModel);
    }

    private BalanceDTO convertDTO(BalanceModel item) {
        BalanceDTO balanceDTO = new BalanceDTO();
        balanceDTO.setUserId(item.getUserId());
        balanceDTO.setBalance(item.getBalance());

        return balanceDTO;
    }
}
