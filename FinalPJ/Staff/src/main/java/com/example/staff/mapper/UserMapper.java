package com.example.staff.mapper;

import com.example.staff.controller.Request.BranchCount;
import com.example.staff.controller.Request.ChangeBranch;
import com.example.staff.controller.Request.Register;
import com.example.staff.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    Staff findStaff(Register req);
    void insertStaff(Register req);

    List<Integer> findAllStaff(BranchCount branchID);
    void changeBranch(ChangeBranch req);
}
