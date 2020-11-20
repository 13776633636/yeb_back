package com.xxxx.server.pojo;

/**
 * 六表联查
 */
public class EmpMsg extends Employee {
    //民族
    private Nation nation;
    //职位
    private Position position;
    //职业等级
    private Joblevel joblevel;
    //部门
    private Department department;
    //政治面貌
    private PoliticsStatus politicsStatus;

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Joblevel getJoblevel() {
        return joblevel;
    }

    public void setJoblevel(Joblevel joblevel) {
        this.joblevel = joblevel;
    }

    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public PoliticsStatus getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(PoliticsStatus politicsStatus) {
        this.politicsStatus = politicsStatus;
    }
}
