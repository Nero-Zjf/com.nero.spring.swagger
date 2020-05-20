package com.nero.spring.swagger;

import com.nero.spring.swagger.domain.User;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "用户管理类")
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public Object hello() throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("msg", "hello");
        return map;
    }

    /**
     * 增加人物
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/user")
    @ApiOperation(value = "新增一个用户", notes = "新增之后返回对象")
    @ApiResponse(code = 400, message = "参数没有填好", response = String.class)
    public String insert(@RequestBody User user) {
        return "success";
    }

    /**
     * 删除单个用户
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/user/{id}")
    @ApiOperation(value = "删除用户", notes = "根据成员id删除单个用户")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户id", required = true, dataType = "Integer")
    @ApiResponse(code = 400, message = "参数没有填好", response = String.class)
    public String delete(@PathVariable("id") Integer id) {
        return "success";
    }

    /**
     * 修改单个成员
     *
     * @param user
     * @return
     */
    @PutMapping(value = "/user")
    @ApiOperation(value = "修改用户信息", notes = "根据成员id修改单个用户")
    public String update(@RequestBody User user) {
        return "success";
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @GetMapping(value = "/user/list")
    @ApiOperation(value = "查询全部用户", notes = "默认根据升序查询全部用户信息")
    public List<User> findAll() {
        return new ArrayList<>();
    }

    /**
     * 获取所有成员,升序排列
     *
     * @return
     */
    @GetMapping(value = "/user/page")
    @ApiOperation(value = "查询用户分页信息", notes = "查询用户分页信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "sort", value = "排序方式:asc|desc", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "pagenumber", value = "第几页", dataType = "Integer", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "分页数", dataType = "Integer", required = true)
    })
    public List<User> findAllByPage(String sort, Integer pageNumber, Integer pageSize) {
        return new ArrayList<>();
    }
}
