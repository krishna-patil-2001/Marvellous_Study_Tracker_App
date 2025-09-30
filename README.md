# Marvellous_Study_Tracker_App
the Marvellous Study Tracker App is a Consoled-based java application design to help students systematically log, track, summarize and export their  study activities.
it allows users to mentain daily study records, view Sumarise grouped by date or subject, and export all logs into a CSV file for offline reference.
this project demonstrates practical uses of Java Collections, File I/O, and Object Oriented Design in a real-word, utility-driven application.

Key Features

* Insert Study Log
  - Record study sessions with date (auto-generated), subject, duration, and description.

* Display Logs
  - View all study logs currently stored in memory.

* Summary by Date
  - Calculate & Display total study hours grouped by date.

* Summary by Subject
  - Calculate & Display total study hours grouped by subject.

* Export to CSV
  - Export all study logs into a CSV file (MarvellousStudy.CSV) for offline tracking.

* User-Friendly Console Menu
  - Menu-driven interface with switch-case navigation for ease of use.

Technologies Used
  
* Language: Java

* Packages & APIs:
  - java.util.* -> Data structures (ArrayList, TreeMap), user input via Scanner.
  - java.time.LocalDate -> Auto-captures the current date for study logs.
  - java.io.* -> File handeling and CSV export.
 
* Project Flow
  1. Launch the Application -> Main Menu Displayed.
  2. Choice 1: Insert new study log -> User provides subject, duration, description -> date auto-generated.
  3. Choice 2: Display all study logs stored in memory.
  4. Choice 3: Display summary grouped by date (total hours per day).
  5. Choice 4: Display summary grouped by subject (total hours per subject).
  6. Choice 5: Export all study logs to MarvellousStudy.CSV.
  7. Choice 6: Exit application.

 Classes & Responsibilities
 
  * StudyLog
   - Represent a single study session.
   - Attributes: LocalDate date, String subject, double duration, String description.
   -  Methods: Constructors, getters, toString().

  * StudyTracker
   - Manages all logs in memory.
   - Attributes: ArrayList<StudyLog> database.
   - Methods: InsertLog(), DisplayLog(), SummaryByDate(), SummaryBySubject(), ExportCSV().

  * StudyTrackerApp (Main Class)
   - Contains main() method.
   - Handels menu-driven interface and user input.
   - Calls appropriate methods from Study Tracker.
