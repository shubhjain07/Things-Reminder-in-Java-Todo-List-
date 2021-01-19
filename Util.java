package com.ThingsReminder;

import java.text.ParseException;
import java.text.SimpleDateFormat;    //The java.text.SimpleDateFormat class provides methods to format and parse date and time in java
import java.util.Date;         //The java.util.Date class represents date and time in java

public class Util
{
    public static Date stringToDate(String stringDate)    //this method used to convert string into date
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            return sdf.parse(stringDate);   // this is a checked exception an it can occur when you fail to parse a String that is ought to have a special format
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return null;
    }

}

