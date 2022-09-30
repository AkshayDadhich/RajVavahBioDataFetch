package com.example.rajvivah.modal;

public class Selfregistrationrequest {

    public int tbl_sid;
    public String registeruser_id ,name,register_uid,registeruser_mob;
        /*    lastname,registeruser_mail,reg_can_username,reg_can_password,reg_can_pwd_lastchange_ip,del_req_madeby_id,illigile_info_from_id,illigile_info_from_descrip,ip_reg_timevarchar,admin_right_teh_reqid,admin_right_vill_reqid,admin_right_dist_reqid,admin_right_state_reqid
            ,isoperator_active_by ,admin_right_view_reqid,admin_right_operator_reqid,admin_right_super_req,admin_right_web_reqid,
            isdeleted_by_admin_remarkn,isview_active_by,path,roletype,admin_user_assign_id_by
            ,verify_state_id,verify_state_remarkn,verify_dist_id,verify_dist_remarkn
            ,verify_teh_id, verify_teh_remark,useraddbyadmin, isSHAbit,remark,isdeleted_by_admin_idn
            ;
*/
   /* public String reg_can_pwd_lastchange,createddate,activefrom,activeto,deletedfrom,admin_right_vill_date,admin_right_teh_date,admin_right_dist_date,admin_right_state_date,admin_right_view_date
            , roleId,admin_right_operator_date,admin_right_super_date,admin_right_web_date,isoperator_active,isview_active,admin_user_date,verify_state_date,verify_dist_date,verify_teh_date
            ,useraddbyadmin_date,isdeleted_by_admin_date;
*/
 /*   public String isdeleted_by_admin,istem_deactive,isdelete_byself,admin_right_vill,admin_right_teh,admin_right_dist,admin_right_state,admin_right_viewbit,admin_right_operator
            ,admin_right_superbit,admin_right_web,post_newsbit,isactivebit,isoperator,isview,admin_user,verify_state_isverify,verify_dist_isverify,verify_teh_isverify,IsSHAbit;
*/

    public int getTbl_sid() {
        return tbl_sid;
    }

    public void setTbl_sid(int tbl_sid) {
        this.tbl_sid = tbl_sid;
    }

    public String getRegisteruser_id() {
        return registeruser_id;
    }

    public void setRegisteruser_id(String registeruser_id) {
        this.registeruser_id = registeruser_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegister_uid() {
        return register_uid;
    }

    public void setRegister_uid(String register_uid) {
        this.register_uid = register_uid;
    }

    public String getRegisteruser_mob() {
        return registeruser_mob;
    }

    public void setRegisteruser_mob(String registeruser_mob) {
        this.registeruser_mob = registeruser_mob;
    }
}

