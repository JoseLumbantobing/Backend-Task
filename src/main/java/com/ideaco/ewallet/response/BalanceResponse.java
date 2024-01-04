package com.ideaco.ewallet.response;

import com.ideaco.ewallet.dto.BalanceDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BalanceResponse extends BaseResponse {
    private BalanceDTO data;

    public BalanceDTO getData() {
        return data;
    }

    public void setData(BalanceDTO data) {
        this.data = data;
    }
}
