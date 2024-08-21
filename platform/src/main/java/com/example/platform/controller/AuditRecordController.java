package com.example.platform.controller;

import com.example.platform.entity.AuditRecord;
import com.example.platform.entity.Game;
import com.example.platform.entity.User;
import com.example.platform.service.AuditRecordService;
import com.example.platform.utils.Result;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//可以接受客户端的请求了
@RestController
//@RequestMapping("/auditor")    //注入UserService
@RequestMapping("/auditor")    //注入UserService
//注解@RequestMapping中的"/user"是这个控制器类的基路由
public class AuditRecordController {
    @Resource
    private AuditRecordService arService;
    //@Autowired
    //@Resource
    //TokenService tokenService;

    //@PostMapping("/record")
    //@GetMapping("/record")
    @RequestMapping(value = "/record",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<List<AuditRecord>> showController(@RequestParam int ID){
        List<AuditRecord> aRecordList = arService.showService(ID);
        if(aRecordList!=null){
            return Result.success(aRecordList,"展示成功！");
        }else{
            return Result.error("456","展示失败！");
        }
    }

    @PostMapping("/add")
    public Result<AuditRecord> registerController(@RequestBody AuditRecord newRecord){
        AuditRecord record = arService.addService(newRecord);
        if(record!=null){
            return Result.success(record,"创建成功！");
        }else{
            return Result.error("456","创建失败！");
        }
    }

    //@PostMapping("/update")
    @RequestMapping(value = "/update",method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    public Result<AuditRecord> updateController(@RequestParam int resultID,@RequestParam int auditorID,@RequestParam String desc,@RequestParam int aRid) throws JSONException {
        AuditRecord record = arService.updateService(resultID,auditorID,desc,aRid);
        if(record!=null){
            return Result.success(record,"修改成功！");
        }else{
            return Result.error("456","修改失败！");
        }
    }
}
