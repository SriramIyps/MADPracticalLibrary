package com.madlibrary;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * MADLibrary provides programmatic access to the 10 Mobile Application Development (MAD)
 * practical programmes, their source files (Java, XML, AndroidManifest.xml, menus, resources),
 * and helper methods for clipboard copying and formatting.
 */
public final class MADLibrary {

    private static final Map<Integer, ProgrammeDetails> PROGRAMME_MAP = new LinkedHashMap<>();

    static {
        initializeProgrammes();
    }

    private MADLibrary() {
        // Utility class
    }

    private static void initializeProgrammes() {
        // Programme 1
        List<SourceFileDetails> p1Files = new ArrayList<>();
        p1Files.add(new SourceFileDetails("MainActivity.java", "programmes/programme1/MainActivity.java", "app/src/main/java/com/example/myapplication1/MainActivity.java", "Java Source", false));
        p1Files.add(new SourceFileDetails("activity_main.xml", "programmes/programme1/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p1Files.add(new SourceFileDetails("AndroidManifest.xml", "programmes/programme1/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p1Files.add(new SourceFileDetails("strings.xml", "programmes/programme1/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p1Files.add(new SourceFileDetails("colors.xml", "programmes/programme1/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        PROGRAMME_MAP.put(1, new ProgrammeDetails(1, "Text Color Changer", "Changes TextView color dynamically through Red, Blue, Green, and Magenta on Button click.", "com.example.myapplication1", "Cycles through Color.RED, Color.BLUE, Color.GREEN, and Color.MAGENTA.", p1Files));

        // Programme 2
        List<SourceFileDetails> p2Files = new ArrayList<>();
        p2Files.add(new SourceFileDetails("MainActivity.java", "programmes/programme2/MainActivity.java", "app/src/main/java/com/example/myapplication2/MainActivity.java", "Java Source", false));
        p2Files.add(new SourceFileDetails("activity_main.xml", "programmes/programme2/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p2Files.add(new SourceFileDetails("AndroidManifest.xml", "programmes/programme2/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p2Files.add(new SourceFileDetails("strings.xml", "programmes/programme2/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p2Files.add(new SourceFileDetails("colors.xml", "programmes/programme2/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        PROGRAMME_MAP.put(2, new ProgrammeDetails(2, "Registration Form", "Collects user details (Name, Password, Address, Gender RadioGroup, Age, DOB DatePicker, Course Spinner) and displays summary on Submit.", "com.example.myapplication2", "Implements RadioGroup, DatePicker dialog/view, and Spinner adapter in Android.", p2Files));

        // Programme 3
        List<SourceFileDetails> p3Files = new ArrayList<>();
        p3Files.add(new SourceFileDetails("MainActivity.java", "programmes/programme3/MainActivity.java", "app/src/main/java/com/example/myapplication3/MainActivity.java", "Java Source", false));
        p3Files.add(new SourceFileDetails("activity_main.xml", "programmes/programme3/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p3Files.add(new SourceFileDetails("AndroidManifest.xml", "programmes/programme3/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p3Files.add(new SourceFileDetails("strings.xml", "programmes/programme3/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p3Files.add(new SourceFileDetails("colors.xml", "programmes/programme3/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        PROGRAMME_MAP.put(3, new ProgrammeDetails(3, "AlertDialog Demo", "Displays an Android AlertDialog with custom title, message, and an OK dismiss button upon user interaction.", "com.example.myapplication3", "Standard AlertDialog.Builder usage for modal popups.", p3Files));

        // Programme 4
        List<SourceFileDetails> p4Files = new ArrayList<>();
        p4Files.add(new SourceFileDetails("MainActivity.java", "programmes/programme4/MainActivity.java", "app/src/main/java/com/example/myapplication4/MainActivity.java", "Java Source", false));
        p4Files.add(new SourceFileDetails("activity_main.xml", "programmes/programme4/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p4Files.add(new SourceFileDetails("AndroidManifest.xml", "programmes/programme4/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p4Files.add(new SourceFileDetails("strings.xml", "programmes/programme4/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p4Files.add(new SourceFileDetails("colors.xml", "programmes/programme4/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        PROGRAMME_MAP.put(4, new ProgrammeDetails(4, "ProgressDialog Demo", "Shows a ProgressDialog for 3 seconds simulating a background task, followed by a completion Toast.", "com.example.myapplication4", "ProgressDialog is deprecated since API 26; still compiles & runs with targetSdk 32.", p4Files));

        // Programme 5
        List<SourceFileDetails> p5Files = new ArrayList<>();
        p5Files.add(new SourceFileDetails("MainActivity.java", "programmes/programme5/MainActivity.java", "app/src/main/java/com/example/myapplication5/MainActivity.java", "Java Source", false));
        p5Files.add(new SourceFileDetails("activity_main.xml", "programmes/programme5/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p5Files.add(new SourceFileDetails("AndroidManifest.xml", "programmes/programme5/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p5Files.add(new SourceFileDetails("strings.xml", "programmes/programme5/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p5Files.add(new SourceFileDetails("colors.xml", "programmes/programme5/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        PROGRAMME_MAP.put(5, new ProgrammeDetails(5, "Start/Stop Toast Demo", "Two interactive buttons that trigger 'Process Started' and 'Process Stopped' feedback Toasts.", "com.example.myapplication5", "Demonstrates event handling and Android Toast notification messages.", p5Files));

        // Programme 6
        List<SourceFileDetails> p6Files = new ArrayList<>();
        p6Files.add(new SourceFileDetails("MainActivity.java", "programmes/programme6/MainActivity.java", "app/src/main/java/com/example/myapplication6/MainActivity.java", "Java Source", false));
        p6Files.add(new SourceFileDetails("new6.java", "programmes/programme6/new6.java", "app/src/main/java/com/example/myapplication6/new6.java", "Java Source (Second Activity)", false));
        p6Files.add(new SourceFileDetails("activity_main.xml", "programmes/programme6/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p6Files.add(new SourceFileDetails("AndroidManifest.xml", "programmes/programme6/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest (Original)", false));
        p6Files.add(new SourceFileDetails("new6.xml", "programmes/programme6/new6.xml", "app/src/main/res/values/new6.xml", "Resource XML (Extra)", true));
        p6Files.add(new SourceFileDetails("res_new6", "programmes/programme6/res_new6", "app/src/main/res/new6", "Resource File (Extra)", true));
        p6Files.add(new SourceFileDetails("strings.xml", "programmes/programme6/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p6Files.add(new SourceFileDetails("colors.xml", "programmes/programme6/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        PROGRAMME_MAP.put(6, new ProgrammeDetails(6, "Explicit & Implicit Intent", "Explicit Intent navigates to second Activity (new6), while Implicit Intent opens Google URL in browser.", "com.example.myapplication6", "NOTICE: In the original project, 'new6' Activity is NOT declared in AndroidManifest.xml (causes ActivityNotFoundException if run). Add <activity android:name=\".new6\" /> to run in Android Studio. Extra files new6.xml and res_new6 from the original project are preserved.", p6Files));

        // Programme 7
        List<SourceFileDetails> p7Files = new ArrayList<>();
        p7Files.add(new SourceFileDetails("MainActivity.java", "programmes/programme7/MainActivity.java", "app/src/main/java/com/example/myapplication7/MainActivity.java", "Java Source", false));
        p7Files.add(new SourceFileDetails("activity_main.xml", "programmes/programme7/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p7Files.add(new SourceFileDetails("AndroidManifest.xml", "programmes/programme7/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p7Files.add(new SourceFileDetails("strings.xml", "programmes/programme7/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p7Files.add(new SourceFileDetails("colors.xml", "programmes/programme7/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        PROGRAMME_MAP.put(7, new ProgrammeDetails(7, "Layout Manager Demo", "Showcases LinearLayout hierarchy structuring TextView, EditText, and Button elements with orientation & margins.", "com.example.myapplication7", "Focuses on XML layout design, view attributes, and hierarchy.", p7Files));

        // Programme 8
        List<SourceFileDetails> p8Files = new ArrayList<>();
        p8Files.add(new SourceFileDetails("MainActivity.java", "programmes/programme8/MainActivity.java", "app/src/main/java/com/example/myapplication8/MainActivity.java", "Java Source", false));
        p8Files.add(new SourceFileDetails("activity_main.xml", "programmes/programme8/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p8Files.add(new SourceFileDetails("menu_main.xml", "programmes/programme8/menu_main.xml", "app/src/main/res/menu/menu_main.xml", "Menu XML (Active)", false));
        p8Files.add(new SourceFileDetails("menu_ma.xml", "programmes/programme8/menu_ma.xml", "app/src/main/res/menu/menu_ma.xml", "Menu XML (Draft/Extra)", true));
        p8Files.add(new SourceFileDetails("menu_mai.xml", "programmes/programme8/menu_mai.xml", "app/src/main/res/menu/menu_mai.xml", "Menu XML (Draft/Extra)", true));
        p8Files.add(new SourceFileDetails("new6.java", "programmes/programme8/new6.java", "app/src/main/java/com/example/myapplication8/new6.java", "Java Stub (Unused/Extra)", true));
        p8Files.add(new SourceFileDetails("AndroidManifest.xml", "programmes/programme8/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p8Files.add(new SourceFileDetails("strings.xml", "programmes/programme8/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p8Files.add(new SourceFileDetails("colors.xml", "programmes/programme8/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        PROGRAMME_MAP.put(8, new ProgrammeDetails(8, "Options Menu Demo", "Inflates an Options Menu with Home, About, and Exit items, handling item selection actions and toasts.", "com.example.myapplication8", "Uses onCreateOptionsMenu and onOptionsItemSelected. Extra draft files (menu_ma.xml, menu_mai.xml, and unused stub new6.java) from the original project are preserved.", p8Files));

        // Programme 9
        List<SourceFileDetails> p9Files = new ArrayList<>();
        p9Files.add(new SourceFileDetails("MainActivity.java", "programmes/programme9/MainActivity.java", "app/src/main/java/com/example/myapplication9/MainActivity.java", "Java Source", false));
        p9Files.add(new SourceFileDetails("activity_main.xml", "programmes/programme9/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p9Files.add(new SourceFileDetails("AndroidManifest.xml", "programmes/programme9/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p9Files.add(new SourceFileDetails("strings.xml", "programmes/programme9/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p9Files.add(new SourceFileDetails("colors.xml", "programmes/programme9/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        PROGRAMME_MAP.put(9, new ProgrammeDetails(9, "Simple Calculator", "Arithmetic calculator supporting Addition (+), Subtraction (-), Multiplication (*), and Division (/) on two user inputs.", "com.example.myapplication9", "Includes input parsing, arithmetic operations, and division error handling.", p9Files));

        // Programme 10
        List<SourceFileDetails> p10Files = new ArrayList<>();
        p10Files.add(new SourceFileDetails("MainActivity.java", "programmes/programme10/MainActivity.java", "app/src/main/java/com/example/myapplication10/MainActivity.java", "Java Source", false));
        p10Files.add(new SourceFileDetails("activity_main.xml", "programmes/programme10/activity_main.xml", "app/src/main/res/layout/activity_main.xml", "Layout XML", false));
        p10Files.add(new SourceFileDetails("AndroidManifest.xml", "programmes/programme10/AndroidManifest.xml", "app/src/main/AndroidManifest.xml", "Manifest", false));
        p10Files.add(new SourceFileDetails("strings.xml", "programmes/programme10/strings.xml", "app/src/main/res/values/strings.xml", "Resource XML", false));
        p10Files.add(new SourceFileDetails("colors.xml", "programmes/programme10/colors.xml", "app/src/main/res/values/colors.xml", "Resource XML", false));
        PROGRAMME_MAP.put(10, new ProgrammeDetails(10, "Number Guessing Game", "Interactive game generating a pseudo-random number (1-10) and validating the user's guess with Win/Lose results.", "com.example.myapplication10", "Uses java.util.Random and comparison logic with visual feedback.", p10Files));
    }

    /**
     * Returns total number of available practical programmes (10).
     */
    public static int getTotalProgrammes() {
        return PROGRAMME_MAP.size();
    }

    /**
     * Returns details for all 10 programmes.
     */
    public static List<ProgrammeDetails> getAllProgrammes() {
        return new ArrayList<>(PROGRAMME_MAP.values());
    }

    /**
     * Returns details for a specified programme number (1-10).
     *
     * @param programmeNumber 1 to 10
     * @return ProgrammeDetails, or null if invalid number
     */
    public static ProgrammeDetails getProgramme(int programmeNumber) {
        return PROGRAMME_MAP.get(programmeNumber);
    }

    /**
     * Returns the list of filenames for a specified programme.
     *
     * @param programmeNumber 1 to 10
     * @return list of filenames (e.g. ["MainActivity.java", "activity_main.xml", ...])
     */
    public static List<String> getFileNames(int programmeNumber) {
        ProgrammeDetails prog = getProgramme(programmeNumber);
        if (prog != null) {
            return prog.getFileNames();
        }
        return Collections.emptyList();
    }

    /**
     * Reads and returns the content of a specific source file for a programme.
     *
     * @param context         Android Context (required to access packaged assets)
     * @param programmeNumber 1 to 10
     * @param fileName        name of the file (e.g. "MainActivity.java")
     * @return source code as a String, or error message if not found
     */
    public static String getFileContent(Context context, int programmeNumber, String fileName) {
        ProgrammeDetails prog = getProgramme(programmeNumber);
        if (prog == null) {
            return "// Error: Programme " + programmeNumber + " does not exist (valid range is 1-10).";
        }
        for (SourceFileDetails file : prog.getFiles()) {
            if (file.getName().equalsIgnoreCase(fileName)) {
                return readAsset(context, file.getAssetPath());
            }
        }
        return "// Error: File '" + fileName + "' not found in Programme " + programmeNumber + ".";
    }

    /**
     * Returns a Map containing all source files and their contents for a specified programme.
     *
     * @param context         Android Context
     * @param programmeNumber 1 to 10
     * @return Map where key is fileName and value is file content
     */
    public static Map<String, String> getProgrammeFiles(Context context, int programmeNumber) {
        Map<String, String> filesMap = new LinkedHashMap<>();
        ProgrammeDetails prog = getProgramme(programmeNumber);
        if (prog == null) {
            return filesMap;
        }
        for (SourceFileDetails file : prog.getFiles()) {
            filesMap.put(file.getName(), readAsset(context, file.getAssetPath()));
        }
        return filesMap;
    }

    /**
     * Returns formatted source code of all files for a programme, ready for display or copying.
     *
     * @param context         Android Context
     * @param programmeNumber 1 to 10
     * @return formatted String with headers and separators
     */
    public static String getFormattedSourceCode(Context context, int programmeNumber) {
        ProgrammeDetails prog = getProgramme(programmeNumber);
        if (prog == null) {
            return "// Error: Programme " + programmeNumber + " does not exist.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("================================================================================\n");
        sb.append("PROGRAMME ").append(prog.getNumber()).append(": ").append(prog.getTitle().toUpperCase()).append("\n");
        sb.append("Package: ").append(prog.getPackageName()).append("\n");
        if (prog.getNotes() != null && !prog.getNotes().isEmpty()) {
            sb.append("Note: ").append(prog.getNotes()).append("\n");
        }
        sb.append("Total Files: ").append(prog.getFiles().size()).append("\n");
        sb.append("================================================================================\n\n");

        List<SourceFileDetails> files = prog.getFiles();
        for (int i = 0; i < files.size(); i++) {
            SourceFileDetails file = files.get(i);
            sb.append("--------------------------------------------------------------------------------\n");
            sb.append("FILE [").append(i + 1).append("/").append(files.size()).append("]: ").append(file.getName()).append("\n");
            sb.append("TYPE: ").append(file.getFileType()).append(file.isExtra() ? " (Extra File)" : "").append("\n");
            sb.append("STUDIO PATH: ").append(file.getProjectPath()).append("\n");
            sb.append("--------------------------------------------------------------------------------\n");
            sb.append(readAsset(context, file.getAssetPath()));
            sb.append("\n\n");
        }

        return sb.toString();
    }

    /**
     * Copies a specific file's content to the Android clipboard.
     *
     * @param context         Android Context
     * @param programmeNumber 1 to 10
     * @param fileName        name of the file
     * @return true if copied successfully
     */
    public static boolean copyFileToClipboard(Context context, int programmeNumber, String fileName) {
        String content = getFileContent(context, programmeNumber, fileName);
        return copyToSystemClipboard(context, fileName, content);
    }

    /**
     * Copies all source files for a programme to the Android clipboard with headers and separators.
     *
     * @param context         Android Context
     * @param programmeNumber 1 to 10
     * @return true if copied successfully
     */
    public static boolean copyProgrammeToClipboard(Context context, int programmeNumber) {
        String content = getFormattedSourceCode(context, programmeNumber);
        ProgrammeDetails prog = getProgramme(programmeNumber);
        String label = (prog != null) ? "Programme " + prog.getNumber() + " Source Code" : "MAD Source Code";
        return copyToSystemClipboard(context, label, content);
    }

    private static boolean copyToSystemClipboard(Context context, String label, String text) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboard != null) {
            ClipData clip = ClipData.newPlainText(label, text);
            clipboard.setPrimaryClip(clip);
            return true;
        }
        return false;
    }

    private static String readAsset(Context context, String assetPath) {
        try (InputStream is = context.getAssets().open(assetPath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            return "// Error reading asset '" + assetPath + "': " + e.getMessage();
        }
    }
}
