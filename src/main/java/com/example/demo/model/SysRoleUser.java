package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_role_user")
/* loaded from: SysRoleUser.class */
public class SysRoleUser {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "create_user_id")
    private String createUserId;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SysRoleUser)) {
            return false;
        }
        SysRoleUser other = (SysRoleUser) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$id = getId();
        Object other$id = other.getId();
        if (this$id == null) {
            if (other$id != null) {
                return false;
            }
        } else if (!this$id.equals(other$id)) {
            return false;
        }
        Object this$userId = getUserId();
        Object other$userId = other.getUserId();
        if (this$userId == null) {
            if (other$userId != null) {
                return false;
            }
        } else if (!this$userId.equals(other$userId)) {
            return false;
        }
        Object this$roleId = getRoleId();
        Object other$roleId = other.getRoleId();
        if (this$roleId == null) {
            if (other$roleId != null) {
                return false;
            }
        } else if (!this$roleId.equals(other$roleId)) {
            return false;
        }
        Object this$createUserId = getCreateUserId();
        Object other$createUserId = other.getCreateUserId();
        return this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId);
    }

    protected boolean canEqual(Object other) {
        return other instanceof SysRoleUser;
    }

    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $userId = getUserId();
        int result2 = (result * 59) + ($userId == null ? 43 : $userId.hashCode());
        Object $roleId = getRoleId();
        int result3 = (result2 * 59) + ($roleId == null ? 43 : $roleId.hashCode());
        Object $createUserId = getCreateUserId();
        return (result3 * 59) + ($createUserId == null ? 43 : $createUserId.hashCode());
    }

    public String toString() {
        return "SysRoleUser(id=" + getId() + ", userId=" + getUserId() + ", roleId=" + getRoleId() + ", createUserId=" + getCreateUserId() + ")";
    }

    public Integer getId() {
        return this.id;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public String getCreateUserId() {
        return this.createUserId;
    }
}