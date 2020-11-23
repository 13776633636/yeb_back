package com.xxxx.server.pojo;

import java.util.Objects;

public class Emm {
    String name;
    String workId;
    String email;
    String phone;
    String deptName;
    String marketName;

    public Emm() {
    }

    public Emm(String name, String workId, String email, String phone, String deptName, String marketName) {
        this.name = name;
        this.workId = workId;
        this.email = email;
        this.phone = phone;
        this.deptName = deptName;
        this.marketName = marketName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    @Override
    public String toString() {
        return "Emm{" +
                "name='" + name + '\'' +
                ", workId='" + workId + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", deptName='" + deptName + '\'' +
                ", marketName='" + marketName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emm emm = (Emm) o;
        return Objects.equals(name, emm.name) &&
                Objects.equals(workId, emm.workId) &&
                Objects.equals(email, emm.email) &&
                Objects.equals(phone, emm.phone) &&
                Objects.equals(deptName, emm.deptName) &&
                Objects.equals(marketName, emm.marketName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, workId, email, phone, deptName, marketName);
    }
}
