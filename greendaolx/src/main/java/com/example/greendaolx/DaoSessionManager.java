package com.example.greendaolx;

import android.content.Context;

import com.example.greendaolx.dao.DaoMaster;
import com.example.greendaolx.dao.DaoSession;

/**
 * author:Created by jiangkerun on 2018/5/14.
 */
public class DaoSessionManager {
    private final String DB_NAME = "android.db";
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private DaoSessionManager() {
    }

    public static DaoSessionManager mInstance ;

    public static DaoSessionManager getInstace() {
        if(mInstance==null){
            synchronized (DaoSessionManager.class){
                if (null==mInstance){
                    mInstance = new DaoSessionManager();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getDaoMaster(Context mContext) {

        DaoMaster.DevOpenHelper mHelper = new DaoMaster
                .DevOpenHelper(mContext, DB_NAME, null);
        daoMaster = new DaoMaster(mHelper.getWritableDatabase());
        return daoMaster;
    }

    public DaoSession getDaoSession(Context mContext) {

        if (daoSession == null) {

            if (daoMaster == null) {
                getDaoMaster(mContext);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

}
