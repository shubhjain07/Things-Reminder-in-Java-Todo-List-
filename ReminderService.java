package com.ThingsReminder;

import java.awt.*;
import java.util.Calendar;
import java.util.List;

public class ReminderService
{
    void startReminder(List<Task> taskList)
    {
        while (true)
        {
            for (Task task : taskList)
            {
                Calendar calendar = Calendar.getInstance();
                if (!task.isCompleted() && calendar.getTime().toString().equals(task.getDateAndTime().toString()))
                {
                    remind(task);
                }
            }

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    void remind(Task task)
    {
        try {
            NotificationService.getTrayIconConfig().displayMessage("" + task.getName() + " (Task Name)", "" + task.getDesc(), TrayIcon.MessageType.INFO);
            task.setCompleted(true);
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }
    }

}
