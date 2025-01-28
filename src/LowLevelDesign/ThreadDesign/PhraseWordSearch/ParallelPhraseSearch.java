package LowLevelDesign.ThreadDesign.PhraseWordSearch;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class ParallelPhraseSearch {

    public static void main(String[] args) {
        // Input: folder path and phrases to search for
        String folderPath = "C:\\Users\\Shriniwas\\Desktop\\cards";
        List<String> phrases = Arrays.asList("Shrini", "is", "Raju");

        File rootFolder = new File(folderPath);
        if (!rootFolder.exists() || !rootFolder.isDirectory()) {
            System.out.println("Invalid folder path.");
            return;
        }

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();
        PhraseSearchTask task = new PhraseSearchTask(rootFolder, phrases);

        // Invoke the ForkJoin task
        Map<String, List<String>> searchResults = pool.invoke(task);

        // Print results
        System.out.println("Search Results:");
        searchResults.forEach((phrase, files) -> {
            System.out.println("Phrase: \"" + phrase + "\"");
            if (files.isEmpty()) {
                System.out.println("  No matches found.");
            } else {
                System.out.println("  Found in files:");
                files.forEach(file -> System.out.println("    - " + file));
            }
        });
    }
}
