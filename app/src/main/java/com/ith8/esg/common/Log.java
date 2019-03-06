package com.ith8.esg.common;

public final class Log {

    private static boolean isLog;

    public static void d(String header,String data){
        if(isLog){
            android.util.Log.d(header,data);
        }
    }

    public static void  e(String header,String data, Throwable e){
        if(isLog){
            android.util.Log.e(header, data, e);
        }
    }



    public static final class Builder{
        private boolean isLog;

        public Builder() {
        }

        public Builder isLogEnable(boolean isLog){
            this.isLog = isLog;
            return this;
        }

        public void build(){
            Log.isLog=isLog;
        }
    }
}
