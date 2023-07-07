package tao.shen.jia.Pojo;

import java.sql.Date;

public class Log4jUser {

    /** 用户ID */
    private Integer userId ;
    /** 用户账号 */
    private String userName ;
    /** 用户密码 */
    private String userPassword ;
    /** 部门 */
    private Integer depId ;
    /** 创建时间 */
    private Date creationTime ;
    /** 更新人 */
    private Date updatedBy ;
    /** 更新时间 */
    private Date updateTime ;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", depId=" + depId +
                ", creationTime=" + creationTime +
                ", updatedBy=" + updatedBy +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Date updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public  Log4jUser(Integer userId, String userName, String userPassword, Integer depId, Date creationTime, Date updatedBy, Date updateTime) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.depId = depId;
        this.creationTime = creationTime;
        this.updatedBy = updatedBy;
        this.updateTime = updateTime;
    }




}
