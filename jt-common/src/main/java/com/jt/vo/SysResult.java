package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysResult implements Serializable {
    private Integer status;
    private String msg;
    private Object data;

    public static SysResult ok(){
        return new SysResult(200,"调用成功",null);
    }
    public static SysResult ok(Object data){
        return new SysResult(200,"调用成功",data);
    }

    public static SysResult ok(String msg,Object data){
        return new SysResult(200,msg,data);
    }
    public static SysResult fail(){
        return new SysResult(201,null,null);
    }
    public static SysResult fail(String msg){
        return new SysResult(201,msg,null);
    }

}
