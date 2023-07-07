package tao.shen.jia.Pojo;

/** @pdOid 0f28b0dc-e5f6-4891-8636-07f2003ce1c3 */
public class Role {
    /** @pdOid f091aa97-9b4d-44fe-aabc-8935329310fe */
    public int deptId;
    /** @pdOid 75e7c9d0-953b-420d-9c47-f3e310b8adf3 */
    public java.lang.String rolename;

    /** @pdRoleInfo migr=no name=User assc=reference1 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
    public java.util.Collection<User> user;


    /** @pdGenerated default getter */
    public java.util.Collection<User> getUser() {
        if (user == null)
            user = new java.util.HashSet<User>();
        return user;
    }

    /** @pdGenerated default iterator getter */
    public java.util.Iterator getIteratorUser() {
        if (user == null)
            user = new java.util.HashSet<User>();
        return user.iterator();
    }






}