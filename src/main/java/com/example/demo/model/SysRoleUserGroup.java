package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_role_user_group")
/* loaded from: SysRoleUserGroup.class */
public class SysRoleUserGroup {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    @Column(name = "role_user_id")
    private Integer roleUserId;
    @Column(name = "group_id")
    private String groupId;
    @Column(name = "create_user_id")
    private String createUserId;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRoleUserId(Integer roleUserId) {
        this.roleUserId = roleUserId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SysRoleUserGroup)) {
            return false;
        }
        SysRoleUserGroup other = (SysRoleUserGroup) o;
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
        Object this$roleUserId = getRoleUserId();
        Object other$roleUserId = other.getRoleUserId();
        if (this$roleUserId == null) {
            if (other$roleUserId != null) {
                return false;
            }
        } else if (!this$roleUserId.equals(other$roleUserId)) {
            return false;
        }
        Object this$groupId = getGroupId();
        Object other$groupId = other.getGroupId();
        if (this$groupId == null) {
            if (other$groupId != null) {
                return false;
            }
        } else if (!this$groupId.equals(other$groupId)) {
            return false;
        }
        Object this$createUserId = getCreateUserId();
        Object other$createUserId = other.getCreateUserId();
        return this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId);
    }

    protected boolean canEqual(Object other) {
        return other instanceof SysRoleUserGroup;
    }
    @Override
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $roleUserId = getRoleUserId();
        int result2 = (result * 59) + ($roleUserId == null ? 43 : $roleUserId.hashCode());
        Object $groupId = getGroupId();
        int result3 = (result2 * 59) + ($groupId == null ? 43 : $groupId.hashCode());
        Object $createUserId = getCreateUserId();
        return (result3 * 59) + ($createUserId == null ? 43 : $createUserId.hashCode());
    }
    @Override
    public String toString() {
        return "SysRoleUserGroup(id=" + getId() + ", roleUserId=" + getRoleUserId() + ", groupId=" + getGroupId() + ", createUserId=" + getCreateUserId() + ")";
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getRoleUserId() {
        return this.roleUserId;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getCreateUserId() {
        return this.createUserId;
    }
}