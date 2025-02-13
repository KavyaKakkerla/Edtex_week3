package com.assignemnt.LMS.model;

import jakarta.persistence.*;


@Entity
@Table(name = "leave_settings")
public class LeaveSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "leave_type")
    private String leaveType;

    @Column(name = "max_leaves")
    private int maxLeaves;

    public int getId() {
        return id;
    }

    public int getMaxLeaves() {
        return maxLeaves;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public void setMaxLeaves(int maxLeaves) {
        this.maxLeaves = maxLeaves;
    }

}