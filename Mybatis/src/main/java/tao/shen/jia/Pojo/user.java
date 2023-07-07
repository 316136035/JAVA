


package tao.shen.jia.Pojo;

import java.util.Date;

/** @pdOid c7818d59-3b1e-4918-9741-9232e96d3035 */
public class user {
    /** @pdOid 003b2161-ae72-4f86-8bf4-264b857539f8 */
    public int userId;
    /** @pdOid 8d455721-873e-416f-bd3d-501cd89fe6ea */
    public java.lang.String userName;

    /** @pdOid f4ede8c8-d58b-41d2-82a8-c5f4b2ce0e4a */
    public java.lang.String userPassword;

    public int depid;

    /** @pdOid 2ce74d63-1c1e-4d8d-a9ef-a4b1ca25351a */
    public java.util.Date creationTime;
    /** @pdOid 060fac33-1984-4df3-a438-c87924aaa885 */
    public java.util.Date updatedBy;

    public user(int userId, String userName, String userPassword, int depid, Date creationTime, Date updatedBy, Date updateTime) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.depid = depid;
        this.creationTime = creationTime;
        this.updatedBy = updatedBy;
        this.updateTime = updateTime;
    }

    /** @pdOid e1d73cec-a8ed-42b4-bdf5-3e15b8d0a9b5 */
    public java.util.Date updateTime;







}