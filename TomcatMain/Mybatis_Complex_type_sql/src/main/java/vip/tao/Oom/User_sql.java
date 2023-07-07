package vip.tao.Oom;

import java.util.Date;

public class User_sql {

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User_sql{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", depId=" + depId +
                ", creationTime=" + creationTime +
                ", updatedBy=" + updatedBy +
                ", updateTime=" + updateTime +
                '}';
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

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
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

    /** @pdOid c94d080a-f08f-4b6e-a008-594cbcc00652 */
    public int userId;
    /** @pdOid ef43968a-a47e-4f9c-b01f-634b17f624fe */
    public java.lang.String userName;
    /** @pdOid 6634ba36-14aa-47bc-8c10-7314e3537015 */
    public java.lang.String userPassword;

    public User_sql(int userId, String userName, String userPassword, int depId, Date creationTime, Date updatedBy, Date updateTime) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.depId = depId;
        this.creationTime = creationTime;
        this.updatedBy = updatedBy;
        this.updateTime = updateTime;
    }

    /** @pdOid 183c0d78-d415-4065-8674-6285995325cc */
    public int  depId;
    public java.util.Date creationTime;
    /** @pdOid 6d6a7919-124f-4e0d-aa04-78d2b084e8de */
    public java.util.Date updatedBy;
    /** @pdOid bfe49423-6e84-4485-a6de-462b0905dcc9 */
    public java.util.Date updateTime;
}

