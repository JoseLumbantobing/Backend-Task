package com.ideaco.ewallet.service;

import com.ideaco.ewallet.dto.BalanceDTO;
import com.ideaco.ewallet.exception.UserNotFoundException;
import com.ideaco.ewallet.model.BalanceModel;
import com.ideaco.ewallet.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopupService {
    @Autowired
    private BalanceRepository balanceRepository;

    public BalanceDTO topup(int userId, int topupAmount) throws UserNotFoundException {
        Optional<BalanceModel> balanceModelOptional = balanceRepository.findByUserId(userId);
//        int topupUser = 0;
        if(balanceModelOptional.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        BalanceModel balanceModel = balanceModelOptional.get();
        int topupUser = balanceModel.getBalance() + topupAmount;

        balanceModel.setBalance(topupUser);
        balanceRepository.save(balanceModel);

        return convertDTO(balanceModel);
    }

    private BalanceDTO convertDTO(BalanceModel balanceModel) {
        BalanceDTO balanceDTO = new BalanceDTO();
        balanceDTO.setUserId(balanceModel.getUserId());
        balanceDTO.setBalance(balanceModel.getBalance());

        return balanceDTO;
    }
}
