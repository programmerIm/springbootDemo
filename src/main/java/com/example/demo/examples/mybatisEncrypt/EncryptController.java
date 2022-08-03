package com.example.demo.examples.mybatisEncrypt;

import com.example.demo.dao.mapper.CustomerMapper;
import com.example.demo.domain.common.ResponseResult;
import com.example.demo.examples.mybatisEncrypt.domain.Customer;
import com.example.demo.examples.mybatisEncrypt.domain.CustomerVo;
import com.example.demo.examples.mybatisEncrypt.domain.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: liming522
 * @description:
 * @date: 2022/8/2 3:11 PM
 * @hope: The newly created file will not have a bug
 */
@RestController
@RequestMapping("/api/encrypt")
public class EncryptController {

    @Autowired
    private CustomerMapper customerMapper;

    // 测试加密
    @PostMapping("/add")
    @ResponseBody
    public ResponseResult insertEncrypt(@RequestBody CustomerVo customerVo) {
        customerMapper.addCustomer(new Encrypt(customerVo.getPhone()),customerVo.getAddress());
        return new ResponseResult(200, "success","success");
    }

    // 测试解密
    @GetMapping("/select")
    @ResponseBody
    public ResponseResult selectEncrypt(String phone) {
        return new ResponseResult(200, customerMapper.selectByPhone(new Encrypt(phone)),"success");
    }
}
