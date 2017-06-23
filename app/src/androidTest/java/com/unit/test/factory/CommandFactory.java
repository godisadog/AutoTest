package com.unit.test.factory;

import android.content.Context;
import android.content.Intent;

import com.unit.test.command.ClickCom;
import com.unit.test.command.ICommand;
import com.unit.test.command.LaunchAppCom;
import com.unit.test.command.PressHomeCom;
import com.unit.test.command.SwipeCom;
import com.unit.test.command.SwipeCom.ORIENTATION;
import com.unit.test.command.WaitCom;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhenwei on 2017/6/22.
 */

public class CommandFactory implements ICommandFactory {

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        return FactoryHolder.factoryInstance;
    }

    /**
     * 点击
     *
     * @param clickCount 点击次数
     * @return
     */
    @Override
    public ICommand createClickCommand(int clickCount) {
        return new ClickCom(clickCount);
    }

    /**
     * 启动app
     *
     * @param context
     * @param launchIntent
     * @param packageName
     * @return
     */
    @Override
    public ICommand createLaunchAppCommand(Context context, Intent launchIntent, String packageName) {

        return new LaunchAppCom(context, launchIntent, packageName);
    }

    @Override
    public ICommand createPressHomeCommand() {
        return new PressHomeCom();
    }

    @Override
    public ICommand createSwipeCommand(ORIENTATION orientation) {
        return new SwipeCom(orientation);
    }

    @Override
    public ICommand createWaitCommand(long time, TimeUnit unit) {
        return new WaitCom(time, unit);
    }

    private static class FactoryHolder {
        private static CommandFactory factoryInstance = new CommandFactory();
    }
}
