package com.example.mybatispluspractice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatispluspractice.entity.Directory;
import com.example.mybatispluspractice.mapper.DirMapper;
import com.example.mybatispluspractice.service.IDirService;
import org.springframework.stereotype.Service;

@Service
public class DirServiceImpl extends ServiceImpl<DirMapper, Directory> implements IDirService {
}
