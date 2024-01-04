package com.ideaco.ewallet.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EditEmailDTO {
    private int userId;
    private String userEmail;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
