package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName(value = "tb_item")
//创建商品对象
public class Item extends BasePojo{
    /*商品id*/
    @TableId(type = IdType.AUTO)
    private Long id;
    /*商品名称*/
    private String title;
    /*商品卖点*/
    private String sellPoint;
    /*商品价格*/
    private Long    price;
    /*商品数量*/
    private Integer num;
    /*条形码*/
    private String barcode;
    /*商品的图片路径*/
    private String image;
    /*商品分类信息*/
    private Long   cid;
    /*商品状态*/
    private Integer status;

}
