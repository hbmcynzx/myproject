package cn.hbmcynzx.dict.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@TableName("dict_cate")
@Data
public class DictCate {
    @TableId(type = IdType.ASSIGN_UUID)
    private String cateId;
    private String cateEname;
    private String cateCname;
    private String cateRemark;
    private Boolean status;
    private Integer orderNum;
    private String createUser;
    private Date createTime;
    private String updateUser;
    private Date updateTime;
    private String delStatus;

}
