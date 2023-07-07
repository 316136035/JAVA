package vip.tao.cache.mapper;

import vip.tao.cache.oom.User_Cache;

import java.util.List;

public interface User_Cache_mapper {
    /**
     * 测试mybatis一级缓存
     **/
    User_Cache selectUser(int userId);

    /**
     * 测试mybatis二级缓存
     **/
    User_Cache selectUser_Cache(int userId);

    /**
     * 测试mybatis自定义缓存
     **/
    List<User_Cache> customsSelectUserList_CustomCache();


}
