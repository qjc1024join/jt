package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor //无参构造
@AllArgsConstructor //定义有参构造
public class EasyUIData<T> {
    private Integer total;
    private List<T> rows;
}
