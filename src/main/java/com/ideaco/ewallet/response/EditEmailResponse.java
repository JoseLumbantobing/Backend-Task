package com.ideaco.ewallet.response;

import com.ideaco.ewallet.dto.EditEmailDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EditEmailResponse extends BaseResponse{
    private EditEmailDTO data;

    public EditEmailDTO getData() {
        return data;
    }

    public void setData(EditEmailDTO data) {
        this.data = data;
    }
}
