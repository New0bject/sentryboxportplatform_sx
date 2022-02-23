package com.example.demo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_group")
/* loaded from: SysGroup.class */
public class SysGroup {
    @Id
    @Column(name = "id_")
    private String id;
    @Column(name = "name_")
    private String name;
    @Column(name = "parent_id_")
    private String parentId;
    @Column(name = "sn_")
    private Integer sn;
    @Column(name = "code_")
    private String code;
    @Column(name = "grade_")
    private String grade;
    @Column(name = "desc_")
    private String desc;
    private String address;
    @Column(name = "detail_address")
    private String detailAddress;
    @Column(name = "manage_organization")
    private String manageOrganization;
    @Column(name = "charge_person_id")
    private String chargePersonId;
    @Column(name = "contact_way")
    private String contactWay;
    @Column(name = "establishment_date")
    private Date establishmentDate;
    @Column(name = "create_time_")
    private Date createTime;
    @Column(name = "create_by_")
    private String createBy;
    @Column(name = "update_time_")
    private Date updateTime;
    @Column(name = "update_by_")
    private String updateBy;
    private String lat;
    private String lng;
    @Column(name = "dept_code")
    private String deptCode;
    private Integer sort;
    @Column(name = "type_id")
    private Integer typeId;
    @Column(name = "pic_url")
    private String picUrl;
    @Column(name = "group_principal")
    private String groupPrincipal;
    @Column(name = "group_principal_phone")
    private String groupPrincipalPhone;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public void setManageOrganization(String manageOrganization) {
        this.manageOrganization = manageOrganization;
    }

    public void setChargePersonId(String chargePersonId) {
        this.chargePersonId = chargePersonId;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setGroupPrincipal(String groupPrincipal) {
        this.groupPrincipal = groupPrincipal;
    }

    public void setGroupPrincipalPhone(String groupPrincipalPhone) {
        this.groupPrincipalPhone = groupPrincipalPhone;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SysGroup)) {
            return false;
        }
        SysGroup other = (SysGroup) o;
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
        Object this$name = getName();
        Object other$name = other.getName();
        if (this$name == null) {
            if (other$name != null) {
                return false;
            }
        } else if (!this$name.equals(other$name)) {
            return false;
        }
        Object this$parentId = getParentId();
        Object other$parentId = other.getParentId();
        if (this$parentId == null) {
            if (other$parentId != null) {
                return false;
            }
        } else if (!this$parentId.equals(other$parentId)) {
            return false;
        }
        Object this$sn = getSn();
        Object other$sn = other.getSn();
        if (this$sn == null) {
            if (other$sn != null) {
                return false;
            }
        } else if (!this$sn.equals(other$sn)) {
            return false;
        }
        Object this$code = getCode();
        Object other$code = other.getCode();
        if (this$code == null) {
            if (other$code != null) {
                return false;
            }
        } else if (!this$code.equals(other$code)) {
            return false;
        }
        Object this$grade = getGrade();
        Object other$grade = other.getGrade();
        if (this$grade == null) {
            if (other$grade != null) {
                return false;
            }
        } else if (!this$grade.equals(other$grade)) {
            return false;
        }
        Object this$desc = getDesc();
        Object other$desc = other.getDesc();
        if (this$desc == null) {
            if (other$desc != null) {
                return false;
            }
        } else if (!this$desc.equals(other$desc)) {
            return false;
        }
        Object this$address = getAddress();
        Object other$address = other.getAddress();
        if (this$address == null) {
            if (other$address != null) {
                return false;
            }
        } else if (!this$address.equals(other$address)) {
            return false;
        }
        Object this$detailAddress = getDetailAddress();
        Object other$detailAddress = other.getDetailAddress();
        if (this$detailAddress == null) {
            if (other$detailAddress != null) {
                return false;
            }
        } else if (!this$detailAddress.equals(other$detailAddress)) {
            return false;
        }
        Object this$manageOrganization = getManageOrganization();
        Object other$manageOrganization = other.getManageOrganization();
        if (this$manageOrganization == null) {
            if (other$manageOrganization != null) {
                return false;
            }
        } else if (!this$manageOrganization.equals(other$manageOrganization)) {
            return false;
        }
        Object this$chargePersonId = getChargePersonId();
        Object other$chargePersonId = other.getChargePersonId();
        if (this$chargePersonId == null) {
            if (other$chargePersonId != null) {
                return false;
            }
        } else if (!this$chargePersonId.equals(other$chargePersonId)) {
            return false;
        }
        Object this$contactWay = getContactWay();
        Object other$contactWay = other.getContactWay();
        if (this$contactWay == null) {
            if (other$contactWay != null) {
                return false;
            }
        } else if (!this$contactWay.equals(other$contactWay)) {
            return false;
        }
        Object this$establishmentDate = getEstablishmentDate();
        Object other$establishmentDate = other.getEstablishmentDate();
        if (this$establishmentDate == null) {
            if (other$establishmentDate != null) {
                return false;
            }
        } else if (!this$establishmentDate.equals(other$establishmentDate)) {
            return false;
        }
        Object this$createTime = getCreateTime();
        Object other$createTime = other.getCreateTime();
        if (this$createTime == null) {
            if (other$createTime != null) {
                return false;
            }
        } else if (!this$createTime.equals(other$createTime)) {
            return false;
        }
        Object this$createBy = getCreateBy();
        Object other$createBy = other.getCreateBy();
        if (this$createBy == null) {
            if (other$createBy != null) {
                return false;
            }
        } else if (!this$createBy.equals(other$createBy)) {
            return false;
        }
        Object this$updateTime = getUpdateTime();
        Object other$updateTime = other.getUpdateTime();
        if (this$updateTime == null) {
            if (other$updateTime != null) {
                return false;
            }
        } else if (!this$updateTime.equals(other$updateTime)) {
            return false;
        }
        Object this$updateBy = getUpdateBy();
        Object other$updateBy = other.getUpdateBy();
        if (this$updateBy == null) {
            if (other$updateBy != null) {
                return false;
            }
        } else if (!this$updateBy.equals(other$updateBy)) {
            return false;
        }
        Object this$lat = getLat();
        Object other$lat = other.getLat();
        if (this$lat == null) {
            if (other$lat != null) {
                return false;
            }
        } else if (!this$lat.equals(other$lat)) {
            return false;
        }
        Object this$lng = getLng();
        Object other$lng = other.getLng();
        if (this$lng == null) {
            if (other$lng != null) {
                return false;
            }
        } else if (!this$lng.equals(other$lng)) {
            return false;
        }
        Object this$deptCode = getDeptCode();
        Object other$deptCode = other.getDeptCode();
        if (this$deptCode == null) {
            if (other$deptCode != null) {
                return false;
            }
        } else if (!this$deptCode.equals(other$deptCode)) {
            return false;
        }
        Object this$sort = getSort();
        Object other$sort = other.getSort();
        if (this$sort == null) {
            if (other$sort != null) {
                return false;
            }
        } else if (!this$sort.equals(other$sort)) {
            return false;
        }
        Object this$typeId = getTypeId();
        Object other$typeId = other.getTypeId();
        if (this$typeId == null) {
            if (other$typeId != null) {
                return false;
            }
        } else if (!this$typeId.equals(other$typeId)) {
            return false;
        }
        Object this$picUrl = getPicUrl();
        Object other$picUrl = other.getPicUrl();
        if (this$picUrl == null) {
            if (other$picUrl != null) {
                return false;
            }
        } else if (!this$picUrl.equals(other$picUrl)) {
            return false;
        }
        Object this$groupPrincipal = getGroupPrincipal();
        Object other$groupPrincipal = other.getGroupPrincipal();
        if (this$groupPrincipal == null) {
            if (other$groupPrincipal != null) {
                return false;
            }
        } else if (!this$groupPrincipal.equals(other$groupPrincipal)) {
            return false;
        }
        Object this$groupPrincipalPhone = getGroupPrincipalPhone();
        Object other$groupPrincipalPhone = other.getGroupPrincipalPhone();
        return this$groupPrincipalPhone == null ? other$groupPrincipalPhone == null : this$groupPrincipalPhone.equals(other$groupPrincipalPhone);
    }

    protected boolean canEqual(Object other) {
        return other instanceof SysGroup;
    }

    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $name = getName();
        int result2 = (result * 59) + ($name == null ? 43 : $name.hashCode());
        Object $parentId = getParentId();
        int result3 = (result2 * 59) + ($parentId == null ? 43 : $parentId.hashCode());
        Object $sn = getSn();
        int result4 = (result3 * 59) + ($sn == null ? 43 : $sn.hashCode());
        Object $code = getCode();
        int result5 = (result4 * 59) + ($code == null ? 43 : $code.hashCode());
        Object $grade = getGrade();
        int result6 = (result5 * 59) + ($grade == null ? 43 : $grade.hashCode());
        Object $desc = getDesc();
        int result7 = (result6 * 59) + ($desc == null ? 43 : $desc.hashCode());
        Object $address = getAddress();
        int result8 = (result7 * 59) + ($address == null ? 43 : $address.hashCode());
        Object $detailAddress = getDetailAddress();
        int result9 = (result8 * 59) + ($detailAddress == null ? 43 : $detailAddress.hashCode());
        Object $manageOrganization = getManageOrganization();
        int result10 = (result9 * 59) + ($manageOrganization == null ? 43 : $manageOrganization.hashCode());
        Object $chargePersonId = getChargePersonId();
        int result11 = (result10 * 59) + ($chargePersonId == null ? 43 : $chargePersonId.hashCode());
        Object $contactWay = getContactWay();
        int result12 = (result11 * 59) + ($contactWay == null ? 43 : $contactWay.hashCode());
        Object $establishmentDate = getEstablishmentDate();
        int result13 = (result12 * 59) + ($establishmentDate == null ? 43 : $establishmentDate.hashCode());
        Object $createTime = getCreateTime();
        int result14 = (result13 * 59) + ($createTime == null ? 43 : $createTime.hashCode());
        Object $createBy = getCreateBy();
        int result15 = (result14 * 59) + ($createBy == null ? 43 : $createBy.hashCode());
        Object $updateTime = getUpdateTime();
        int result16 = (result15 * 59) + ($updateTime == null ? 43 : $updateTime.hashCode());
        Object $updateBy = getUpdateBy();
        int result17 = (result16 * 59) + ($updateBy == null ? 43 : $updateBy.hashCode());
        Object $lat = getLat();
        int result18 = (result17 * 59) + ($lat == null ? 43 : $lat.hashCode());
        Object $lng = getLng();
        int result19 = (result18 * 59) + ($lng == null ? 43 : $lng.hashCode());
        Object $deptCode = getDeptCode();
        int result20 = (result19 * 59) + ($deptCode == null ? 43 : $deptCode.hashCode());
        Object $sort = getSort();
        int result21 = (result20 * 59) + ($sort == null ? 43 : $sort.hashCode());
        Object $typeId = getTypeId();
        int result22 = (result21 * 59) + ($typeId == null ? 43 : $typeId.hashCode());
        Object $picUrl = getPicUrl();
        int result23 = (result22 * 59) + ($picUrl == null ? 43 : $picUrl.hashCode());
        Object $groupPrincipal = getGroupPrincipal();
        int result24 = (result23 * 59) + ($groupPrincipal == null ? 43 : $groupPrincipal.hashCode());
        Object $groupPrincipalPhone = getGroupPrincipalPhone();
        return (result24 * 59) + ($groupPrincipalPhone == null ? 43 : $groupPrincipalPhone.hashCode());
    }

    public String toString() {
        return "SysGroup(id=" + getId() + ", name=" + getName() + ", parentId=" + getParentId() + ", sn=" + getSn() + ", code=" + getCode() + ", grade=" + getGrade() + ", desc=" + getDesc() + ", address=" + getAddress() + ", detailAddress=" + getDetailAddress() + ", manageOrganization=" + getManageOrganization() + ", chargePersonId=" + getChargePersonId() + ", contactWay=" + getContactWay() + ", establishmentDate=" + getEstablishmentDate() + ", createTime=" + getCreateTime() + ", createBy=" + getCreateBy() + ", updateTime=" + getUpdateTime() + ", updateBy=" + getUpdateBy() + ", lat=" + getLat() + ", lng=" + getLng() + ", deptCode=" + getDeptCode() + ", sort=" + getSort() + ", typeId=" + getTypeId() + ", picUrl=" + getPicUrl() + ", groupPrincipal=" + getGroupPrincipal() + ", groupPrincipalPhone=" + getGroupPrincipalPhone() + ")";
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getParentId() {
        return this.parentId;
    }

    public Integer getSn() {
        return this.sn;
    }

    public String getCode() {
        return this.code;
    }

    public String getGrade() {
        return this.grade;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getAddress() {
        return this.address;
    }

    public String getDetailAddress() {
        return this.detailAddress;
    }

    public String getManageOrganization() {
        return this.manageOrganization;
    }

    public String getChargePersonId() {
        return this.chargePersonId;
    }

    public String getContactWay() {
        return this.contactWay;
    }

    public Date getEstablishmentDate() {
        return this.establishmentDate;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    public String getDeptCode() {
        return this.deptCode;
    }

    public Integer getSort() {
        return this.sort;
    }

    public Integer getTypeId() {
        return this.typeId;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getGroupPrincipal() {
        return this.groupPrincipal;
    }

    public String getGroupPrincipalPhone() {
        return this.groupPrincipalPhone;
    }
}