package LowLevelDesign.ThreadDesign.PhraseWordSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

public  class PhraseSearchTask extends RecursiveTask<Map<String, List<String>>> {
    private final File folder;
    private final List<String> phrases;

    public PhraseSearchTask(File folder, List<String> phrases) {
        this.folder = folder;
        this.phrases = phrases;
    }

    @Override
    protected Map<String, List<String>> compute() {
        Map<String, List<String>> result = new HashMap<>();
        phrases.forEach(phrase -> result.put(phrase, new ArrayList<>()));

        if (folder == null || !folder.exists() || !folder.isDirectory()) {
            return result;
        }

        File[] files = folder.listFiles();
        if (files == null) {
            return result;
        }

        List<PhraseSearchTask> subTasks = new ArrayList<>();

        for (File file : files) {
            if (file.isDirectory()) {
                // Fork a new task for each subdirectory
                PhraseSearchTask task = new PhraseSearchTask(file, phrases);
                subTasks.add(task);
                task.fork();
            } else if (file.isFile()) {
                // Process the file for matching phrases
                searchInFile(file, phrases, result);
            }
        }

        // Combine results from subtasks
        for (PhraseSearchTask task : subTasks) {
            Map<String, List<String>> subTaskResult = task.join();
            for (String phrase : phrases) {
                result.get(phrase).addAll(subTaskResult.get(phrase));
            }
        }

        return result;
    }

    private void searchInFile(File file, List<String> phrases, Map<String, List<String>> result) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder fileContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append(" ");
            }
            String content = fileContent.toString().trim();

            // Search for individual words or phrases in the content
            for (String phrase : phrases) {
                String phraseToSearch = phrase.trim();
                if (content.contains(phraseToSearch)) {
                    result.get(phrase).add(file.getAbsolutePath());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getAbsolutePath());
        }
    }
}
