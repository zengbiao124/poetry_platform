package cn.com.poetry_platform.service;

import cn.com.poetry_platform.dao.UserDao;
import cn.com.poetry_platform.pojo.User;
import cn.com.poetry_platform.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    /**
     * 用于普通用户登录、通过用户名密码进行核验
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        UserDao userDao = new UserDao();
        // 密码需要MD5校验
        password = MD5Utils.stringToMD5(password);
        User user = userDao.selectUserByUsernameAndPassword(username, password);
        return user;
    }
    /**
     * 普通用户注册
     * @param user
     * @return
     */
    public boolean addUserBuy(User user) {
        // 需要把密码进行MD5加密。
        String password = user.getPassword();
        password = MD5Utils.stringToMD5(password);
        user.setPassword(password);
        /////////////////////////
        UserDao userDao = new UserDao();
        int ret = userDao.insertUser(user);
        return ret > 0 ? true : false;
    }

    /**
     * 用于管理员用户注册
     * @param user
     * @return
     */
    public boolean addUser(User user) {
        // 需要把密码进行MD5加密。
        String password = user.getPassword();
        password = MD5Utils.stringToMD5(password);
        user.setPassword(password);
        /////////////////////////
        UserDao userDao = new UserDao();
        int ret = userDao.insertManagerUser(user);
        return ret > 0 ? true : false;
    }

    /**
     * 用于用户注册时，核验用户名是否被占用，
     * @param username
     * @return
     */
    public boolean checkUsernameIsHaving(String username) {
        User user = new UserDao().selectByUsername(username);
        if(user == null) {
            // 没被占用，可以用的。
            return true;
        }
        return false;
    }

    /**
     * 用于修改用户信息
     * @param user
     * @return
     */
    public boolean modifyUser(User user){
        UserDao userDao=new UserDao();
        int ret=userDao.updateUser(user);
        return ret>0?true:false;
    }

    /**
     * 用于用户修改密码
     * @param username
     * @param password
     * @return
     */
    public boolean updateUserPassword(String username , String password){

        UserDao userDao = new UserDao();
        int ret = userDao.updateUserByName(username, password);
        return ret >0 ? true:false;
    }
}
