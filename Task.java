package com.ThingsReminder;

import java.util.Date;

public class Task
{
    private int sNo;
    private String name;
    private String desc;
    private Date dateAndTime;
    private boolean isCompleted;

   // getter & setter method to set & get the values of the objects

    public int getsNo()
    {
        return sNo;
    }

    public void setsNo(int sNo)
    {
        this.sNo = sNo;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public Date getDateAndTime()
    {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime)
    {
        this.dateAndTime = dateAndTime;
    }

    public boolean isCompleted()
    {
        return isCompleted;
    }

    public void setCompleted(boolean completed)
    {
        isCompleted = completed;
    }
}
