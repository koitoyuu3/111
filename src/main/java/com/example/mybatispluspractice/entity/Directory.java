package com.example.mybatispluspractice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.File;

@Data
public class Directory {
    @TableId(type= IdType.AUTO)
    private Long id;
    private String name;
    private String phone;
    private String email;
}
