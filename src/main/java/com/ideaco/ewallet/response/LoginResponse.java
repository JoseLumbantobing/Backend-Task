package com.ideaco.ewallet.response;

import com.ideaco.ewallet.dto.LoginDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse extends BaseResponse {
    private LoginDTO data;

    public LoginDTO getData() {
        return data;
    }

    public void setData(LoginDTO data) {
        this.data = data;
    }
}
