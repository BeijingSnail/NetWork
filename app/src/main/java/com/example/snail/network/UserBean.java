package com.example.snail.network;

import java.util.List;


/**
 * 账号密码登陆 短信登陆 token 登陆 返回实体类
 * 用戶信息实体类
 */
public class UserBean  {

    public AccBean acc;
    public int isOk;
    public List<String> companyPower;

    @Override
    public String toString() {
        return "UserBean{" +
                "acc=" + acc +
                ", isOk=" + isOk +
                ", companyPower=" + companyPower +
                '}';
    }

    public static class AccBean {
        public String birthdate;
        public String city;
        public String company; // 公司id
        public String companyPower;
        public String companylevel;
        public String companypart;
        public String country;
        public String email;
        public String headImgUrl;
        public int id;
        public int isEmail;
        public String lastDate;
        public String mphone;
        public String nickname;
        public String openId;
        public String password;
        public String province;
        public String quanxian;
        public long rdate;
        public String realName;
        public int sex;
        public String token;
        public int type;
        public String username;
        public String yzmLogin;
        public String yzmXiuGai;
        public List<String> roomList;//个人拥有权限的房间名称

        @Override
        public String toString() {
            return "AccBean{" +
                    "birthdate='" + birthdate + '\'' +
                    ", city='" + city + '\'' +
                    ", company=" + company +
                    ", companyPower='" + companyPower + '\'' +
                    ", companylevel='" + companylevel + '\'' +
                    ", companypart='" + companypart + '\'' +
                    ", country='" + country + '\'' +
                    ", email='" + email + '\'' +
                    ", headImgUrl='" + headImgUrl + '\'' +
                    ", id=" + id +
                    ", isEmail=" + isEmail +
                    ", lastDate='" + lastDate + '\'' +
                    ", mphone='" + mphone + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", openId='" + openId + '\'' +
                    ", password='" + password + '\'' +
                    ", province='" + province + '\'' +
                    ", quanxian='" + quanxian + '\'' +
                    ", rdate=" + rdate +
                    ", realName='" + realName + '\'' +
                    ", sex=" + sex +
                    ", token='" + token + '\'' +
                    ", type=" + type +
                    ", username='" + username + '\'' +
                    ", yzmLogin='" + yzmLogin + '\'' +
                    ", yzmXiuGai='" + yzmXiuGai + '\'' +
                    ", roomList='" + roomList + '\'' +
                    '}';
        }

    }
}
