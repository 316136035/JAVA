package com.cn.Service业务层.Service业务层实现;
import com.cn.Dao持久层操作数据库.Dao持久层实现.EmpDaoimplements;
import com.cn.Model实体类.Emp;
import com.cn.Service业务层.Service业务层接口.EmpServiceinterface;
import com.cn.Utils工具类.Page;
import java.util.List;
import java.util.Map;


public class EmpServiceimplements implements EmpServiceinterface {
    //注入 EmpDaoimplements对象
    EmpDaoimplements empDaoimplements = new EmpDaoimplements();

    @Override
    public Page<Emp> listEmp(Map<String, Object> params) {


        //获取浏览器的当前页码
        Integer pageCode = Integer.parseInt(params.get("pageCode").toString());
        //获取浏览器的当前页面数量
        Integer pageSize = Integer.parseInt(params.get("pageSize").toString());
        //((页数-1)*每页查询的数据),每页查询的数据
        Integer start = (pageCode -1)*pageSize;
        params.put("start",start);

        // 获取所有符合条件的员工数量
        Integer count  = empDaoimplements.countEmps(params);



        // 获取所有符合条件的员工列表
        List<Emp> emps = empDaoimplements.listEmp(params);

        // 封装Page对象
        Page<Emp> page = new Page<>();
        page.setPageCode(pageCode);
        page.setPageSize(pageSize);
        page.setBeanList( emps);
        page.setTotaConunt( page.getTotalPage(count));


        return page;
    }



    @Override
    public void addEmp(Emp emp) {
        empDaoimplements.addEmp(emp);

    }

    @Override
    public Emp  selectEmp(String id) {

        Emp emp = empDaoimplements.selectEmp(id);
        return emp;
    }

    @Override
    public void UpdateEmp(Emp emp ) {
        empDaoimplements.UpdateEmp(emp);



    }

    @Override
    public void DelEmp(String id) {
        empDaoimplements.DelEmp(id);
    }


}
