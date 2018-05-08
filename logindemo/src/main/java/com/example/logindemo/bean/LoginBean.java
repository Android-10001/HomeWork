package com.example.logindemo.bean;

/**
 * author:Created by jiangkerun on 2018/5/8.
 */
public class LoginBean {

    /**
     * msg : 登录成功
     * code : 0
     * data : {"age":null,"appkey":"cb3d5559011426ec","appsecret":"F7C800AE8AD110CAF7F4435ADA63862E","createtime":"2018-05-08T14:38:32","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18611352752","money":null,"nickname":null,"password":"7F14BAAF818358E25E2D9C5259AA47DD","praiseNum":null,"token":"091A458E79FB731EDC0277AC15090C7F","uid":14659,"userId":null,"username":"18611352752"}
     */

    private String msg;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : cb3d5559011426ec
         * appsecret : F7C800AE8AD110CAF7F4435ADA63862E
         * createtime : 2018-05-08T14:38:32
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 18611352752
         * money : null
         * nickname : null
         * password : 7F14BAAF818358E25E2D9C5259AA47DD
         * praiseNum : null
         * token : 091A458E79FB731EDC0277AC15090C7F
         * uid : 14659
         * userId : null
         * username : 18611352752
         */

        private int age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private String email;
        private String mobile;
        private String nickname;
        private String password;
        private String token;
        private int uid;
        private String username;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
