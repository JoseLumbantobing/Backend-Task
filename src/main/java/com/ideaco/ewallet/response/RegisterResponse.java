package com.ideaco.ewallet.response;

import com.ideaco.ewallet.dto.RegisterDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class RegisterResponse extends BaseResponse {
    private RegisterDTO data;

    public RegisterDTO getData() {
        return data;
    }

    public void setData(RegisterDTO data) {
        this.data = data;
    }
}
