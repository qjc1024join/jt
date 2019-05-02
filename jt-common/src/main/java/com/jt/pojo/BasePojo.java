package com.jt.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@Data
@Accessors(chain = true)
public class BasePojo implements Serializable {
    private Date created;
    private Date updated;
}
