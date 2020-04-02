package com.cloud.vblog.auth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author aiwei
 * @since 2020-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_category_menu")
public class TCategoryMenu extends Model<TCategoryMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一uid
     */
    @TableId(value = "uid", type = IdType.AUTO)
    private String uid;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单级别
     */
    @TableField("menu_level")
    private Boolean menuLevel;

    /**
     * 简介
     */
    private String summary;

    /**
     * 父uid
     */
    @TableField("parent_uid")
    private String parentUid;

    /**
     * url地址
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序字段，越大越靠前
     */
    private Integer sort;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 是否显示 1:是 0:否
     */
    @TableField("is_show")
    private Boolean isShow;

    /**
     * 菜单类型 0: 菜单   1: 按钮
     */
    @TableField("menu_type")
    private Boolean menuType;


    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

}
