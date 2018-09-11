package com.major.demo.mapper;

import com.major.demo.entiy.SysUser;
import com.major.demo.util.MyMapper;

import java.util.List;

// 自定义 Wrapper
public interface SysUserMapperCustom extends MyMapper<SysUser> {

    List<SysUser> queryUserSimplyInfoById(String id);

}