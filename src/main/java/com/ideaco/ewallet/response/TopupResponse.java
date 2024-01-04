package com.ideaco.ewallet.response;

import com.ideaco.ewallet.dto.TopupDTO;

public class TopupResponse extends BaseResponse{
    private TopupDTO data;

    public TopupDTO getData() {
        return data;
    }

    public void setData(TopupDTO data) {
        this.data = data;
    }
}
