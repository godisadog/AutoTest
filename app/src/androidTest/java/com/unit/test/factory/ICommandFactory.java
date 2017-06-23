package com.unit.test.factory;

import android.content.Context;
import android.content.Intent;

import com.unit.test.command.ICommand;
import com.unit.test.command.SwipeCom;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhenwei on 2017/6/22.
 */

public interface ICommandFactory {
    ICommand createClickCommand(int clickCount);
    ICommand createLaunchAppCommand(Context context, Intent launchIntent, String packageName);
    ICommand createPressHomeCommand();
    ICommand createSwipeCommand(SwipeCom.ORIENTATION orientation);
    ICommand createWaitCommand(long time, TimeUnit unit);
}
