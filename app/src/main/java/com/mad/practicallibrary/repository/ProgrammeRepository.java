package com.mad.practicallibrary.repository;

import com.mad.practicallibrary.model.Programme;
import com.mad.practicallibrary.model.SourceFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProgrammeRepository {

    private static ProgrammeRepository instance;
    private final List<Programme> programmes;

    private ProgrammeRepository() {
        programmes = new ArrayList<>();
        initializeData();
    }

    public static synchronized ProgrammeRepository getInstance() {
        if (instance == null) {
            instance = new ProgrammeRepository();
        }
        return instance;
    }

    private void initializeData() {
        // --- Programme 1 ---
        Programme p1 = new Programme(
                1,
                "Text Color Changer",
                "Changes TextView color dynamically through Red, Blue, Green, and Magenta on Button click.",
                "com.example.myapplication1",
                "Cycles through Color.RED, Color.BLUE, Color.GREEN, and Color.MAGENTA."
        );
        p1.addSourceFile(new SourceFile("MainActivity.java", "programmes/programme1/MainActivity.java", "app/src/main/java/com/example/myapplication1/MainActivity.java", "Java Source", false));
        p1.addSourceFile(new SourceFile("activity_main.xml", "programmes/programme1/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p1.addSourceFile(new SourceFile("AndroidManifest.xml", "programmes/programme1/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p1.addSourceFile(new SourceFile("strings.xml", "programmes/programme1/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p1.addSourceFile(new SourceFile("colors.xml", "programmes/programme1/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        programmes.add(p1);

        // --- Programme 2 ---
        Programme p2 = new Programme(
                2,
                "Registration Form",
                "Collects user details (Name, Password, Address, Gender RadioGroup, Age, DOB DatePicker, Course Spinner) and displays summary on Submit.",
                "com.example.myapplication2",
                "Implements RadioGroup, DatePicker dialog/view, and Spinner adapter in Android."
        );
        p2.addSourceFile(new SourceFile("MainActivity.java", "programmes/programme2/MainActivity.java", "app/src/main/java/com/example/myapplication2/MainActivity.java", "Java Source", false));
        p2.addSourceFile(new SourceFile("activity_main.xml", "programmes/programme2/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p2.addSourceFile(new SourceFile("AndroidManifest.xml", "programmes/programme2/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p2.addSourceFile(new SourceFile("strings.xml", "programmes/programme2/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p2.addSourceFile(new SourceFile("colors.xml", "programmes/programme2/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        programmes.add(p2);

        // --- Programme 3 ---
        Programme p3 = new Programme(
                3,
                "AlertDialog Demo",
                "Displays an Android AlertDialog with custom title, message, and an OK dismiss button upon user interaction.",
                "com.example.myapplication3",
                "Standard AlertDialog.Builder usage for modal popups."
        );
        p3.addSourceFile(new SourceFile("MainActivity.java", "programmes/programme3/MainActivity.java", "app/src/main/java/com/example/myapplication3/MainActivity.java", "Java Source", false));
        p3.addSourceFile(new SourceFile("activity_main.xml", "programmes/programme3/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p3.addSourceFile(new SourceFile("AndroidManifest.xml", "programmes/programme3/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p3.addSourceFile(new SourceFile("strings.xml", "programmes/programme3/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p3.addSourceFile(new SourceFile("colors.xml", "programmes/programme3/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        programmes.add(p3);

        // --- Programme 4 ---
        Programme p4 = new Programme(
                4,
                "ProgressDialog Demo",
                "Shows a ProgressDialog for 3 seconds simulating a background task, followed by a completion Toast.",
                "com.example.myapplication4",
                "ProgressDialog is deprecated since API 26; still compiles & runs with targetSdk 32."
        );
        p4.addSourceFile(new SourceFile("MainActivity.java", "programmes/programme4/MainActivity.java", "app/src/main/java/com/example/myapplication4/MainActivity.java", "Java Source", false));
        p4.addSourceFile(new SourceFile("activity_main.xml", "programmes/programme4/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p4.addSourceFile(new SourceFile("AndroidManifest.xml", "programmes/programme4/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p4.addSourceFile(new SourceFile("strings.xml", "programmes/programme4/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p4.addSourceFile(new SourceFile("colors.xml", "programmes/programme4/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        programmes.add(p4);

        // --- Programme 5 ---
        Programme p5 = new Programme(
                5,
                "Start/Stop Toast Demo",
                "Two interactive buttons that trigger 'Process Started' and 'Process Stopped' feedback Toasts.",
                "com.example.myapplication5",
                "Demonstrates event handling and Android Toast notification messages."
        );
        p5.addSourceFile(new SourceFile("MainActivity.java", "programmes/programme5/MainActivity.java", "app/src/main/java/com/example/myapplication5/MainActivity.java", "Java Source", false));
        p5.addSourceFile(new SourceFile("activity_main.xml", "programmes/programme5/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p5.addSourceFile(new SourceFile("AndroidManifest.xml", "programmes/programme5/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p5.addSourceFile(new SourceFile("strings.xml", "programmes/programme5/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p5.addSourceFile(new SourceFile("colors.xml", "programmes/programme5/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        programmes.add(p5);

        // --- Programme 6 ---
        Programme p6 = new Programme(
                6,
                "Explicit & Implicit Intent",
                "Explicit Intent navigates to second Activity (new6), while Implicit Intent opens Google URL in browser.",
                "com.example.myapplication6",
                "NOTICE: In the original project, 'new6' Activity is NOT declared in AndroidManifest.xml (causes ActivityNotFoundException if run). Add <activity android:name=\".new6\" /> to run in Android Studio. Extra files new6.xml and res_new6 from the original project are preserved below."
        );
        p6.addSourceFile(new SourceFile("MainActivity.java", "programmes/programme6/MainActivity.java", "app/src/main/java/com/example/myapplication6/MainActivity.java", "Java Source", false));
        p6.addSourceFile(new SourceFile("new6.java", "programmes/programme6/new6.java", "app/src/main/java/com/example/myapplication6/new6.java", "Java Source (Second Activity)", false));
        p6.addSourceFile(new SourceFile("activity_main.xml", "programmes/programme6/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p6.addSourceFile(new SourceFile("AndroidManifest.xml", "programmes/programme6/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest (Original)", false));
        p6.addSourceFile(new SourceFile("new6.xml", "programmes/programme6/new6.xml", "app/src/main/res/values/new6.xml", "Resource XML (Extra)", true));
        p6.addSourceFile(new SourceFile("res_new6", "programmes/programme6/res_new6", "app/src/main/res/new6", "Resource File (Extra)", true));
        p6.addSourceFile(new SourceFile("strings.xml", "programmes/programme6/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p6.addSourceFile(new SourceFile("colors.xml", "programmes/programme6/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        programmes.add(p6);

        // --- Programme 7 ---
        Programme p7 = new Programme(
                7,
                "Layout Manager Demo",
                "Showcases LinearLayout hierarchy structuring TextView, EditText, and Button elements with orientation & margins.",
                "com.example.myapplication7",
                "Focuses on XML layout design, view attributes, and hierarchy."
        );
        p7.addSourceFile(new SourceFile("MainActivity.java", "programmes/programme7/MainActivity.java", "app/src/main/java/com/example/myapplication7/MainActivity.java", "Java Source", false));
        p7.addSourceFile(new SourceFile("activity_main.xml", "programmes/programme7/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p7.addSourceFile(new SourceFile("AndroidManifest.xml", "programmes/programme7/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p7.addSourceFile(new SourceFile("strings.xml", "programmes/programme7/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p7.addSourceFile(new SourceFile("colors.xml", "programmes/programme7/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        programmes.add(p7);

        // --- Programme 8 ---
        Programme p8 = new Programme(
                8,
                "Options Menu Demo",
                "Inflates an Options Menu with Home, About, and Exit items, handling item selection actions and toasts.",
                "com.example.myapplication8",
                "Uses onCreateOptionsMenu and onOptionsItemSelected. Extra draft files (menu_ma.xml, menu_mai.xml, and unused stub new6.java) from the original project are preserved below."
        );
        p8.addSourceFile(new SourceFile("MainActivity.java", "programmes/programme8/MainActivity.java", "app/src/main/java/com/example/myapplication8/MainActivity.java", "Java Source", false));
        p8.addSourceFile(new SourceFile("activity_main.xml", "programmes/programme8/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p8.addSourceFile(new SourceFile("menu_main.xml", "programmes/programme8/menu_main.xml", "app/src/main/res/menu/menu_main.xml", "Menu XML (Active)", false));
        p8.addSourceFile(new SourceFile("menu_ma.xml", "programmes/programme8/menu_ma.xml", "app/src/main/res/menu/menu_ma.xml", "Menu XML (Draft/Extra)", true));
        p8.addSourceFile(new SourceFile("menu_mai.xml", "programmes/programme8/menu_mai.xml", "app/src/main/res/menu/menu_mai.xml", "Menu XML (Draft/Extra)", true));
        p8.addSourceFile(new SourceFile("new6.java", "programmes/programme8/new6.java", "app/src/main/java/com/example/myapplication8/new6.java", "Java Stub (Unused/Extra)", true));
        p8.addSourceFile(new SourceFile("AndroidManifest.xml", "programmes/programme8/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p8.addSourceFile(new SourceFile("strings.xml", "programmes/programme8/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p8.addSourceFile(new SourceFile("colors.xml", "programmes/programme8/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        programmes.add(p8);

        // --- Programme 9 ---
        Programme p9 = new Programme(
                9,
                "Simple Calculator",
                "Arithmetic calculator supporting Addition (+), Subtraction (-), Multiplication (*), and Division (/) on two user inputs.",
                "com.example.myapplication9",
                "Includes input parsing, arithmetic operations, and division error handling."
        );
        p9.addSourceFile(new SourceFile("MainActivity.java", "programmes/programme9/MainActivity.java", "app/src/main/java/com/example/myapplication9/MainActivity.java", "Java Source", false));
        p9.addSourceFile(new SourceFile("activity_main.xml", "programmes/programme9/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p9.addSourceFile(new SourceFile("AndroidManifest.xml", "programmes/programme9/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p9.addSourceFile(new SourceFile("strings.xml", "programmes/programme9/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p9.addSourceFile(new SourceFile("colors.xml", "programmes/programme9/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        programmes.add(p9);

        // --- Programme 10 ---
        Programme p10 = new Programme(
                10,
                "Number Guessing Game",
                "Interactive game generating a pseudo-random number (1-10) and validating the user's guess with Win/Lose results.",
                "com.example.myapplication10",
                "Uses java.util.Random and comparison logic with visual feedback."
        );
        p10.addSourceFile(new SourceFile("MainActivity.java", "programmes/programme10/MainActivity.java", "app/src/main/java/com/example/myapplication10/MainActivity.java", "Java Source", false));
        p10.addSourceFile(new SourceFile("activity_main.xml", "programmes/programme10/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p10.addSourceFile(new SourceFile("AndroidManifest.xml", "programmes/programme10/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p10.addSourceFile(new SourceFile("strings.xml", "programmes/programme10/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p10.addSourceFile(new SourceFile("colors.xml", "programmes/programme10/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        programmes.add(p10);
    }

    public List<Programme> getAllProgrammes() {
        return new ArrayList<>(programmes);
    }

    public Programme getProgrammeByNumber(int number) {
        for (Programme p : programmes) {
            if (p.getNumber() == number) {
                return p;
            }
        }
        return null;
    }

    public List<Programme> searchProgrammes(String query) {
        if (query == null || query.trim().isEmpty()) {
            return getAllProgrammes();
        }
        String q = query.trim().toLowerCase(Locale.getDefault());
        List<Programme> results = new ArrayList<>();
        for (Programme p : programmes) {
            if (String.valueOf(p.getNumber()).equals(q)
                    || p.getFormattedNumber().equals(q)
                    || p.getTitle().toLowerCase(Locale.getDefault()).contains(q)
                    || p.getDescription().toLowerCase(Locale.getDefault()).contains(q)
                    || p.getPackageName().toLowerCase(Locale.getDefault()).contains(q)) {
                results.add(p);
                continue;
            }
            // Check if any file matches
            for (SourceFile sf : p.getSourceFiles()) {
                if (sf.getName().toLowerCase(Locale.getDefault()).contains(q)) {
                    results.add(p);
                    break;
                }
            }
        }
        return results;
    }
}
