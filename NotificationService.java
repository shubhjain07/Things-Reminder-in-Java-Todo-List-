package com.ThingsReminder;

import java.awt.*;       //Java AWT (Abstract Window Toolkit) is an API to develop GUI or window-based applications

public class NotificationService
{

    public static TrayIcon getTrayIconConfig() throws AWTException     // System tray Design method
    {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Lenovo\\Desktop\\rem.png");
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Shubham's Project");

        tray.add(trayIcon);
        return trayIcon;
    }

    public void showNewTaskNotification(Task task)      //  System Tray notify
    {
        try
        {
            getTrayIconConfig().displayMessage("" + task.getName() + " (Task Name)", "" + task.getDesc() + "\nNew Task Added", TrayIcon.MessageType.INFO);
        }
        catch (Exception ed)
        {
            System.out.print(ed);
        }
    }

}
