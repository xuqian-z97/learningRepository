package com.zxq.dutychain.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SensitiveWordDTO {

    private String word;

    private int length;

}
