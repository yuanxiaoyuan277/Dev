package com.fc.controller;

import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public PageInfo<Student> findAll(@RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "3") Integer pageSize){
        return studentService.findAll(pageNum,pageSize);
    }

    @PostMapping("{name}/{age}/{gender}/{info}")
    public Map<String,Object> add(Student student){
        HashMap<String, Object> result = new HashMap<>();

        int i = studentService.add(student);

        if (i > 0){
            result.put("code", 200);
            result.put("message", "添加成功");
            result.put("success", true);
        }else {
            result.put("code", -1000);
            result.put("message", "添加失败");
            result.put("success", false);
        }
        result.put("date",null);
        return result;
    }

    @PutMapping("{id}/{info}")
    public Map<String,Object> update(Student student){
        Map<String, Object> result = new HashMap<>();

        int i = studentService.update(student);

        if (i > 0){
            result.put("code", 200);
            result.put("message", "添加成功");
            result.put("success", true);
        }else {
            result.put("code", -1000);
            result.put("message", "添加失败");
            result.put("success", false);
        }
        result.put("date",null);
        return result;
    }

    @DeleteMapping("{id}")
    public Map<String,Object> delete(@PathVariable("id") Integer id){
        Map<String, Object> result = new HashMap<>();

        int i = studentService.delete(id);

        if (i > 0){
            result.put("code", 200);
            result.put("message", "添加成功");
            result.put("success", true);
        }else {
            result.put("code", -1000);
            result.put("message", "添加失败");
            result.put("success", false);
        }
        result.put("date",null);
        return result;
    }
}
