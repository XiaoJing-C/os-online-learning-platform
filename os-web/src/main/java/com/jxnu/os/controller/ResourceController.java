package com.jxnu.os.controller;

import com.jxnu.os.model.PageRequest;
import com.jxnu.os.model.Resource;
import com.jxnu.os.model.RespBean;
import com.jxnu.os.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiao
 */
@CrossOrigin
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    /**
     * 查询所有资源记录
     * @param p_id
     * @return
     */
    @GetMapping("/getAllRe")
    public List<Resource> getAllRe(Integer p_id) {
        return resourceService.getAllRe(p_id);
    }

    @PostMapping(value="/findPage")
    public Object findPage(@RequestBody(required = false) PageRequest pageQuery,Integer p_id) {
        //System.out.println(pageQuery.getPageNum());
        //System.out.println(p_id);
        return resourceService.findPage(pageQuery,p_id);
    }


    /**
     * 更新资源记录
     * @param resource
     * @return
     */
    @PutMapping("/updateRe")
    public RespBean updateRe(Resource resource) {
        if (resourceService.updateRe(resource) == 1) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/deleteById/{id}")
    public RespBean deleteById(@PathVariable Integer id) {
        if (resourceService.deleteById(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @PostMapping("/insert")
    public RespBean insert(Resource resource) {
        if(resourceService.insert(resource) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

}
