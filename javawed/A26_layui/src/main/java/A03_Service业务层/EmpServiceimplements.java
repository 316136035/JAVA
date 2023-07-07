package A03_Service业务层;

import A02_Dao操作数据库.EmpDaoimplements;
import A02_Dao操作数据库.MysqlUtils;
import A04_实体类.Emp;
import A04_实体类.Emprole;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.sql.Connection;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class EmpServiceimplements implements EmpServiceinterface {
    EmpDaoimplements empDaoimplements;

    public EmpServiceimplements() {
        empDaoimplements = new EmpDaoimplements();
    }

    @Override
    public JSONObject addEmp(int id, String name, int age, int sex, Date date, int deptid) {
        int i = 0;
        Connection connection = null;
        try {
            connection = MysqlUtils.getConnection();
            i = empDaoimplements.addEmp(connection, id, name, age, sex, date, deptid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                MysqlUtils.close(connection, null, null);
            }
        }
        HashMap<Object, Object> HashMap = new HashMap<>();
        if (i == 1) {
            HashMap.put("Code", 200);
        } else {
            HashMap.put("Code", 500);
        }
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(HashMap);
        return jsonObject;
    }

    @Override
    public JSONObject deleteEmp(int id) {
        Connection connection = null;
        int i = -1;
        try {
            connection = MysqlUtils.getConnection();
            i = empDaoimplements.deleteEmp(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                MysqlUtils.close(connection, null, null);
            }
        }
        HashMap<Object, Object> HashMap = new HashMap<>();
        if (i == 1) {
            HashMap.put("Code", 200);
        } else {
            HashMap.put("msg", 500);
        }
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(HashMap);
        return jsonObject;
    }

    @Override
    public JSONObject upDateEmp(int id, String name, int age, int sex, Date date, int deptid) {
        int i = -1;
        Connection connection = null;
        try {
            connection = MysqlUtils.getConnection();
            i = empDaoimplements.upDateEmp(connection, id, name, age, sex, date, deptid);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MysqlUtils.close(connection, null, null);
        }
        HashMap<Object, Object> HashMap = new HashMap<>();
        if (i == 1) {
            HashMap.put("Code", 200);
        } else {
            HashMap.put("msg", 500);
        }
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(HashMap);

        return jsonObject;
    }


    @Override
    public JSONObject getEmp(int page, int limit) {
        Connection connection = null;
        connection = MysqlUtils.getConnection();
        List<Emp> emplist = empDaoimplements.getEmp(connection, page, limit);
        int count = this.Getcount();
        HashMap<String, Object> Listobjects = new HashMap<>();
        Listobjects.put("Code", 200);
        Listobjects.put("count", count);
        Listobjects.put("emplist", emplist);
        JSONObject JSONObject = (JSONObject) JSON.toJSON(Listobjects);

        System.out.println(JSONObject.toJSONString());




        return JSONObject;
    }

    @Override
    public int Getcount() {
        Connection connection = null;
        int getcount = 0;
        try {
            connection = MysqlUtils.getConnection();
            getcount = empDaoimplements.Getcount(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                MysqlUtils.close(connection, null, null);
            }
        }

        return getcount;
    }

    @Override
    public JSONObject GetEmprole() {
        Connection connection = null;
        List<Emprole> emproles = null;
        try {
            connection = MysqlUtils.getConnection();
            emproles = empDaoimplements.GetEmprole(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                MysqlUtils.close(connection, null, null);
            }
        }
        HashMap<String, Object> Listobjects = new HashMap<>();
        Listobjects.put("Code", 200);
        Listobjects.put("msg", 500);
        Listobjects.put("emprolelist", emproles);

        JSONObject JSONObject = (JSONObject) JSON.toJSON(Listobjects);
        return JSONObject;
    }


}
