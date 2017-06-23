package com.unit.test.command;

import android.content.Context;
import android.content.Intent;
import android.icu.text.NumberFormat;
import android.support.test.uiautomator.UiDevice;

/**
 * Created by zhenwei on 2017/6/22.
 */

public class LaunchAppCom implements ICommand {

    private Context context;
    private Intent launchIntent;
    private String packageName;

    public LaunchAppCom(Context context, Intent intent, String packageName){
        this.context = context;
        this.launchIntent = intent;
        this.packageName = packageName;
    }

    /**
     *
     * @param uiDevice
     */
    @Override
    public void execute(UiDevice uiDevice) {
        /*if(objs != null &&
                objs.length == 2 &&
                objs[0] instanceof Context &&
                objs[1] instanceof Intent &&
                objs[2] instanceof String){

            Context context = (Context)objs[0];
            Intent launchIntent = (Intent)objs[1];
            String packageName = (String) objs[2];


        }*/

        context.startActivity(launchIntent);
        while (true) {
            String curPackageName = uiDevice.getCurrentPackageName();
            System.out.println("pn=" + curPackageName);
            if (curPackageName.equals(packageName)){
                break;
            }else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
