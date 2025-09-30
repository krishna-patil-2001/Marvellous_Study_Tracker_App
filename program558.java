import java.util.*;
import java.io.FileWriter;
import java.lang.classfile.instruction.SwitchCase;
import java.time.Duration;
import java.time.LocalDate;


class StudyLog
{
    public LocalDate Date; 
    public String Subject;
    public double Duration;
    public String Descreption;

    public StudyLog(LocalDate A, String B, double C, String D)
    {
        this.Date = A;
        this.Subject = B;
        this.Duration = C;
        this.Descreption = D;
    }

    public String toString()
    {
        return  Date+" | "+Subject+" | "+Duration+" | "+Descreption;
    }

    public LocalDate getDate()
    {
        return Date;
    }

    public String getSubject()
    {
        return Subject;
    }

    public double getDuration()
    {
        return Duration;
    }

    public String getDescreption()
    {
        return Descreption;
    }
}

class StudyTracker
{
    // Data Structure to hold the data about study
   private ArrayList<StudyLog> database = new ArrayList<StudyLog>();

   public void InsertLog()
   {
       Scanner scanersobj = new Scanner(System.in);

       System.out.println("----------------------------------------------------------------");
       System.out.println("--------- Please Enter the Valid Details Of Your Study ---------");
       System.out.println("----------------------------------------------------------------");

       LocalDate dateobj = LocalDate.now();

       System.out.println("Please provide the name of subject like C/C++/Java/OS/DS");
       String sub = scanersobj.nextLine();

       System.out.println("Enter the time period if your study in hours");
       double dur = scanersobj.nextDouble();
       scanersobj.nextLine();

       System.out.println("Please provide the description about the study for future referecne");
       String desc = scanersobj.nextLine();

       StudyLog studyobj = new StudyLog(dateobj, sub, dur, desc);

       database.add(studyobj);

        System.out.println("Study Log gets stored succesfully");
        System.out.println("----------------------------------------------------------------------");
   }

   public void DisplayLog()
   {
      System.out.println("------------------------------------------------------------------------");

      if(database.isEmpty())
      {
            System.out.println("Nothing to display as database is empty");
            System.out.println("------------------------------------------------------------------");
            return;
      }

        System.out.println("----------------------------------------------------");
        System.out.println("---- Log report from Marvellous Study Tracker ------");
        System.out.println("----------------------------------------------------");

        for(StudyLog sobj : database)
        {
            System.out.println(sobj);
        }

        System.out.println("----------------------------------------------------");
   }

   public void ExportCSV()
   {
       if(database.isEmpty())
        {
            System.out.println("----------------------------------------------------");
            System.out.println("Nothing to export as database is empty");
            System.out.println("----------------------------------------------------");
            return;
        }

        String FileName = "MarvellousStudy.csv";

        // Create new file
        try(FileWriter fwobj = new FileWriter(FileName))
        {

        // Write CSV header
        fwobj.write("Date,Subject,Duration,Description\n");

        // Travel database
        for(StudyLog sobj : database)
        {
            // Write each record in CSV
            fwobj.write(sobj.getDate() + ","+
                       sobj.getSubject().replace(",", " ") + ","+
                       sobj.getDuration() + ","+
                       sobj.getDescreption().replace(",", " ") + "\n"
            );
        }

       System.out.println("Log created Succesfully");
     }

    catch(Exception eobj)
        {
            System.out.println("Exception occured while creating the CSV.");
            System.out.println("Report this issue to Marvellous Infosystems");
        }
    }

    public void SummaryByDate()
    {
        System.out.println("----------------------------------------------------");
       
        if(database.isEmpty())
        {
            System.out.println("Nothing to display as database is empty");
            System.out.println("----------------------------------------------------");
            return;
        }

        System.out.println("----------------------------------------------------");
        System.out.println("-- Summary By Date from Marvellous Study Tracker ---");
        System.out.println("----------------------------------------------------");

        TreeMap<LocalDate,Double> tobj = new TreeMap<LocalDate,Double>();

        LocalDate lobj = null;
        double d,old;

        for(StudyLog sobj : database)
        {
            lobj = sobj.getDate();
            d = sobj.getDuration();

            if(tobj.containsKey(lobj))
            {
                old = tobj.get(lobj);
                tobj.put(lobj, old+d);
            }
            else
            {
                tobj.put(lobj, d);
            }
        }

         // Display the details as per date
        for(LocalDate ldobj : tobj.keySet())
        {
            System.out.println("Date : "+ldobj+" Total Study "+tobj.get(ldobj));
        }

        System.out.println("----------------------------------------------------");
    }

    public void SummaryBySubject()
    {
        System.out.println("----------------------------------------------------");
       
        if(database.isEmpty())
        {
            System.out.println("Nothing to display as database is empty");
            System.out.println("----------------------------------------------------");
            return;
        }

        System.out.println("----------------------------------------------------");
        System.out.println("-- Summary By Subject from Marvellous Study Tracker ---");
        System.out.println("----------------------------------------------------");

        TreeMap<String,Double> tobj = new TreeMap<String,Double>();

        String s;
        double d,old;

        for(StudyLog sobj : database)
        {
            s = sobj.getSubject();
            d = sobj.getDuration();

            if(tobj.containsKey(s))
            {
                old = tobj.get(s);
                tobj.put(s, old+d);
            }
            else
            {
                tobj.put(s, d);
            }
        }

         // Display the details as per Subject
        for(String str : tobj.keySet())
        {
            System.out.println("Subject : "+str+" Total Study "+tobj.get(str));
        }

        System.out.println("----------------------------------------------------");
    }
}


class program558  // StudyTrackerStarter
{
    public static void main(String[] args) 
    {
        StudyTracker stobj = new StudyTracker();

        int iChoice = 0;

        Scanner scanerobj = new Scanner(System.in);

        System.out.println("----------------------------------------------------");
        System.out.println("--Welcome to Marvellous Study Tracker Application --");
        System.out.println("----------------------------------------------------");

        do
        {

            System.out.println("Please Select the Appropriate option");
            System.out.println("1 : Insert New Study Log into Database");
            System.out.println("2 : View All Study Logs");
            System.out.println("3 : Summary of StudyLog by Date");
            System.out.println("4 : Summary of StudyLog by Subject");
            System.out.println("5 : Export Study Log to CSV file");
            System.out.println("6 : Exit the application");

            iChoice = scanerobj.nextInt();
            
            switch(iChoice)
            {
                case 1:       // Insert new Study Log into Databse
                    stobj.InsertLog();
                    break;

                case 2:     // View All Study Logs
                    stobj.DisplayLog();
                    break;

                case 3:   // Summary of Study Log by Date
                     stobj.SummaryByDate();   
                    break;

                case 4:     // Summary of Study Log by Subject
                    stobj.SummaryBySubject();
                    break;

                case 5:    // Export Study Log to CSV file
                    stobj.ExportCSV();
                    break;

                case 6:   // Exit the application
                     System.out.println("----------------------------------------------------");
                     System.out.println("Thank you for using Marvellous Study Log application");
                     System.out.println("----------------------------------------------------");
                     break;

                     default:
                          System.out.println("Please enter the valid option");
            }

        }while(iChoice != 6);

    }
}