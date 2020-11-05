package cn.hbmcynzx.base.dict.entity;

import cn.hbmcynzx.base.mybatis.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("dict_item")
@Data
public class DictItem extends BaseEntity {
    @TableId(type = IdType.ASSIGN_UUID)
    private String itemId;
    private String cateEname;
    private String itemValue;
    private String itemText;
    private String itemRemark;
    private Boolean status;
    private Integer orderNum;
    private Integer subCount;
    private Integer treeLevel;
    private String fatherId;
    private String fatherValue;
    private String fullEname;
    private String fullCname;
    private String createUser;
    private Date createTime;
    private String updateUser;
    private Date updateTime;
    private String delStatus;

}
