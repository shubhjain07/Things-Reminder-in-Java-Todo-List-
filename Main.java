package com.ThingsReminder;    // User Defined Package

import java.util.ArrayList;    // ArrayList class is a resizable array,which can be found in the java.util package
import java.util.List;
import java.util.Scanner;   //  Scanner class is used to get user input, and it is found in the java.util package.

public class Main      //  Main Class or Driver class of the project 😀😀😀
{
    List<Task> taskList;                      // Declaration of List Obejct
    TaskService taskService;                     // Declaration of TaskService class object
    ReminderService reminderService;            // Declaration of ReminderService class object

    public Main()                         // Default constructor used to provide the default values to the object 🤩🤩
    {
        taskList = new ArrayList<>();
        taskService = new TaskService();
        reminderService = new ReminderService();
    }

    void showMenu()    //
    {
        Scanner sc = new Scanner(System.in);
        boolean quit = true;
        String mainMenu = "\n" + "\n1.Add Task\n" + "2.View Task\n" + "3.Edit Task\n" + "4.Remove Task\n" + "5.Exit\n\n" + "Enter Your Choice : ";

        while (quit)                   // while loop  is used here to display the menu continuously
        {
            System.out.print(mainMenu);
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    taskList.add(taskService.createTask());
                    break;

                case 2:
                    taskService.showAllTask(taskList);
                    break;

                case 3:
                    taskService.editTask(taskList);
                    break;

                case 4:
                    taskList.remove(taskService.removeTask(taskList));
                    break;

                case 5:
                    quit = false;
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter correct choice");
            }
        }
    }

    void startReminderService()
    {
        reminderService.startReminder(taskList);       // call the Reminder class Method
    }



    public static void main(String[] args)
    {
        Main todo = new Main();                           // create object of Main class

        new Thread(todo::showMenu).start();                  // it is used to start the thread that continuously monitoring menu driven
        new Thread(todo::startReminderService).start();       // it is used to monitor the reminder notification
    }
}
