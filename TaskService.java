package com.ThingsReminder;

import java.util.List;
import java.util.Scanner;

public class TaskService
{
    public Task createTask()           // Method for creating new task
    {
        Task task = new Task();

        Scanner ad = new Scanner(System.in);
        System.out.print("\nEnter task Serial No : ");
        task.setsNo(ad.nextInt());

        ad.nextLine();          // clear Input Stream
        System.out.print("Enter Task : ");
        task.setName(ad.nextLine());

        System.out.print("Do you add some Description about the task (Y/N) : ");
        char ch = ad.next().charAt(0);

        if (ch == 'Y' || ch == 'y')
        {
            ad.nextLine();
            System.out.print("Description : ");
            task.setDesc(ad.nextLine());
        }
        else {
            task.setDesc("Not Available");
        }
        Scanner sct = new Scanner(System.in);
        System.out.print("Enter date and time (dd/MM/yyyy hh:mm) : ");
        task.setDateAndTime(Util.stringToDate(sct.nextLine()));

        NotificationService notificationService = new NotificationService();
        notificationService.showNewTaskNotification(task);
        System.out.println("Task Added Successfully");
        ad.nextLine();
        return task;
    }

    public void showAllTask(List<Task> taskList)          // Method for display tasks
    {
        System.out.println("***************************************************************");
        System.out.println("*  Serial No   *\tTasks\t*    Description    *\t Date & Time *");
        System.out.println("****************************************************************");
        //System.out.println("********************************************");

        for (Task task : taskList)
        {
            System.out.print("      \n     " + task.getsNo() + "   \t\t" + task.getName() + "\t\t" + task.getDesc() + "\t\t" + task.getDateAndTime().toString());
        }

    }

    public void editTask(List<Task> taskList)     // Method for edit tasks
    {
        showAllTask(taskList);
        System.out.print("\n\n\nEdit Task :- \n1.By Serial No\n2.By Task Name\n\nEnter Your choice : ");
        Scanner erd = new Scanner(System.in);
        int ed = erd.nextInt();
        switch (ed)
        {
            case 1:
                System.out.print("Enter Serial No : ");
                int num = erd.nextInt();
                for (Task task : taskList) {
                    if (task.getsNo() == num)
                    {
                        System.out.print("Do you want to edit Serial No (Y/N) : ");
                        char ds = erd.next().charAt(0);
                        if (ds == 'Y' || ds == 'y') {
                            System.out.print("Enter New Serial No : ");
                            task.setsNo(erd.nextInt());
                            System.out.println("Serial No changed successfully.\n");
                        } else
                            System.out.println("Serial No not changed.\n");

                        System.out.print("Do you want to edit Task Name (Y/N) : ");
                        char ds1 = erd.next().charAt(0);
                        if (ds1 == 'Y' || ds1 == 'y')
                        {
                            System.out.print("Enter new Task Name : ");
                            erd.nextLine();
                            task.setName(erd.nextLine());
                            System.out.println("Task Name changed successfully");
                        }
                        else
                            System.out.println("Task Name not Changed");

                        System.out.print("Do you want to edit Task Description (Y/N) : ");
                        char bg = erd.next().charAt(0);
                        if (bg == 'Y' || bg == 'y')
                        {
                            System.out.print("Enter New Description : ");
                            erd.nextLine();
                            task.setDesc(erd.nextLine());
                            System.out.println("Task Description changed Successfully");
                        }
                        else
                            System.out.println("Task Description not changed ");

                        System.out.print("Do you want to edit Task Date&Time (Y/N) : ");
                        char bg1 = erd.next().charAt(0);
                        if(bg1 == 'Y' || bg1 == 'y')
                        {
                            erd.nextLine();
                            System.out.print("Enter new Date&Time : ");
                            task.setDateAndTime(Util.stringToDate(erd.nextLine()));
                            System.out.println("Task Date&Time changed Successfully");
                        }
                        else
                            System.out.println("Task Date&Time not changed");
                    }
                    else
                        System.out.println("Entered Serial No is Not match plz enter correct Serial No");
                }
                break;

            case 2:
                erd.nextLine();
                System.out.print("Enter Task Name : ");
                String bnn = erd.nextLine();
                for (Task task : taskList) {
                    if (task.getName().equals(bnn)) {
                        System.out.print("\nDo you want to edit Serial No (Y/N) : ");
                        char sd = erd.next().charAt(0);
                        if (sd == 'Y' || sd == 'y') {
                            System.out.print("Enter new Serial No : ");
                            erd.nextLine();
                            task.setsNo(erd.nextInt());
                            System.out.println("Serial No changed Successfully\n");
                        } else
                            System.out.println("Serial No not changed\n");
                        System.out.println("\nDo you want to edit Task Name (Y/N) : ");
                        char sd1 = erd.next().charAt(0);
                        if (sd1 == 'Y' || sd1 == 'y') {
                            System.out.print("Enter new Task Name : ");
                            erd.nextLine();
                            task.setName(erd.nextLine());
                            System.out.println("Task Name changed successfully");
                        } else
                            System.out.println("Task Name not Changed");

                        System.out.print("Do you want to edit Task Description (Y/N) : ");
                        char bg = erd.next().charAt(0);
                        if (bg == 'Y' || bg == 'y')
                        {
                            System.out.print("Enter New Description : ");
                            erd.nextLine();
                            task.setDesc(erd.nextLine());
                            System.out.println("Task Description changed Successfully");
                        }
                        else
                            System.out.println("Task Description not changed ");

                        System.out.print("Do you want to edit Task Date&Time (Y/N) : ");
                        char bg1 = erd.next().charAt(0);
                        if(bg1 == 'Y' || bg1 == 'y')
                        {
                            erd.nextLine();
                            System.out.print("Enter new Date&Time : ");
                            task.setDateAndTime(Util.stringToDate(erd.nextLine()));
                            System.out.println("Task Date&Time changed Successfully");
                        }
                        else
                            System.out.println("Task Date&Time not changed");
                    }
                    else
                        System.out.println("Entered Task Name is Not match plz enter correct Task Name");
                }
                break;
        }
    }

    public Task removeTask(List<Task> taskList)     // Method for remove tasks
    {
        Scanner ffg = new Scanner(System.in);
        showAllTask(taskList);

        System.out.print("\n\nEnter the Serial No. of the Task to be removed : ");
        int rd = ffg.nextInt();

        for (Task task : taskList)
        {
           if(task.getsNo() == rd)
           {
               System.out.println("delete successfully");
               return task;
           }
        }
        return null;
    }

}

