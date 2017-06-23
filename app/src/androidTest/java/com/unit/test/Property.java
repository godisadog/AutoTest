package com.unit.test;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;

import com.unit.test.command.ICommand;
import com.unit.test.command.SwipeCom;
import com.unit.test.factory.CommandFactory;

import java.util.List;

/**
 * Created by zhenwei on 2017/6/21.
 */

public class Property {


    public static final String PACKAGE_NAME = "com.unit.test";
    private static Context context;
    private static Intent startIntent;

    static {
        context = InstrumentationRegistry.getContext();
        findStartAppIntent();
        actions = createCommands();
    }

    public static ICommand[] actions;

    private static void findStartAppIntent() {
        Context context = InstrumentationRegistry.getContext();

        PackageManager pm = context.getPackageManager();

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfoList = pm.queryIntentActivities(intent, 0);
        if (resolveInfoList != null && !resolveInfoList.isEmpty()) {
            for (ResolveInfo info : resolveInfoList) {
                if (info.activityInfo.packageName.equals(PACKAGE_NAME)) {
                    startIntent = new Intent();
                    startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startIntent.setComponent(new ComponentName(PACKAGE_NAME, info.activityInfo.name));
                }
            }
        }
    }

    /**
     * 在这里添加修改要执行的命令
     * @return
     */
    private static ICommand[] createCommands(){
        return new ICommand[]{
                CommandFactory.getInstance().createPressHomeCommand(),
                CommandFactory.getInstance().createLaunchAppCommand(context, startIntent, PACKAGE_NAME),
                /*CommandFactory.getInstance().createClickCommand(50),*/
                CommandFactory.getInstance().createSwipeCommand(SwipeCom.ORIENTATION.LEFT),
//                CommandFactory.getInstance().createClickCommand(50),
//                CommandFactory.getInstance().createSwipeCommand(SwipeCom.ORIENTATION.RIGHT),
//                CommandFactory.getInstance().createClickCommand(50),
//                CommandFactory.getInstance().createSwipeCommand(SwipeCom.ORIENTATION.LEFT)
        };
    }

}
