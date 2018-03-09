package com.example.administrator.christie.entity;

import android.util.Log;

import com.example.administrator.christie.util.AESUtil;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/12/6 0006.
 */

public class User {
    private String mId;
    private String mPwd;
    private static final String masterPassword = "FORYOU"; // AES加密算法的种子
    private static final String JSON_ID = "user_id";
    private static final String JSON_PWD = "user_pwd";
    private static final String TAG = "User";

    public User(String id, String pwd) {
        this.mId = id;
        this.mPwd = pwd;
    }

    public User(JSONObject json) throws Exception {
        if (json.has(JSON_ID)) {
            String id = json.getString(JSON_ID);
            String pwd = json.getString(JSON_PWD);
            // 解密后存放
            mId = AESUtil.decrypt(masterPassword, id);
            mPwd = AESUtil.decrypt(masterPassword, pwd);
        }
    }

    public JSONObject toJSON() throws Exception {
        // 使用AES加密算法加密后保存
        String id = AESUtil.encrypt(masterPassword, mId);
        String pwd = AESUtil.encrypt(masterPassword, mPwd);
        Log.i(TAG, "加密后:" + id + "  " + pwd);
        JSONObject json = new JSONObject();
        try {
            json.put(JSON_ID, id);
            json.put(JSON_PWD, pwd);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String getId() {
        return mId;
    }

    public String getPwd() {
        return mPwd;
    }
}
