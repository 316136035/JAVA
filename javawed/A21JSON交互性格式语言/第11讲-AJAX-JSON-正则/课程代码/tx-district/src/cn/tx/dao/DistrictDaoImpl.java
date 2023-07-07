package cn.tx.dao;

import cn.tx.model.District;
import cn.tx.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DistrictDaoImpl implements DistrictDao {
    @Override
    public List<District> listDistrictByPid(Integer pId) {

        {
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<District> districts = new ArrayList<>();
            try {

                String sql = "select * from t_district where pid = ? order BY id";
                connection = JdbcUtils创建sql连接池返回链接.getConnection();
                ps = connection.prepareStatement(sql);
                ps.setInt(1,pId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    District district = new District(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4));
                    districts.add(district);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JdbcUtils创建sql连接池返回链接.close(connection,ps,rs);
            }
            return districts;
        }
    }
}
