package Startup.Iterator;

import java.io.*;
import java.util.*;

public class WordDirectoryOOM implements Iterator<String> {

    private Queue<File> fileQueue;  // Stores files to be processed
    private BufferedReader bufferedReader; // Reads words from the current file
    private Queue<String> wordQueue; // Stores words from the current file

    public WordDirectoryOOM(String rootDirectory) {
        this.fileQueue = new LinkedList<>();
        this.wordQueue = new LinkedList<>();
        this.bufferedReader = null;

        collectFilesDFS(new File(rootDirectory));  // DFS-based file traversal
//      collectFilesBFS(new File(rootDirectory));  // Uncomment for BFS traversal

        try {
            loadNextFile();  // Start processing the first file
        } catch (IOException e) {
            throw new RuntimeException("Error initializing iterator..", e);
        }
    }

    /**
     * Collect files using DFS (Process deepest files first)
     */
    private void collectFilesDFS(File directory) {
        Stack<File> directoryStack = new Stack<>();
        directoryStack.push(directory);

        while (!directoryStack.isEmpty()) {
            File currentDir = directoryStack.pop();
            File[] files = currentDir.listFiles();

            if (files != null) {
                List<File> subDirectories = new ArrayList<>();
                List<File> fileList = new ArrayList<>();

                for (File file : files) {
                    if (file.isDirectory()) {
                        subDirectories.add(file);
                    } else {
                        fileList.add(file);
                    }
                }

                // Push directories in reverse order to ensure correct DFS traversal
                Collections.reverse(subDirectories);
                for (File subDir : subDirectories) {
                    directoryStack.push(subDir);
                }

                // Process files after handling subdirectories
                fileQueue.addAll(fileList);
            }
        }
    }

    /**
     * Collect files using BFS (Process files level-wise)
     */
    private void collectFilesBFS(File directory) {
        Queue<File> directoryQueue = new LinkedList<>();
        directoryQueue.add(directory);

        while (!directoryQueue.isEmpty()) {
            File currentDir = directoryQueue.poll();
            File[] files = currentDir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        directoryQueue.add(file);
                    } else {
                        fileQueue.offer(file);
                    }
                }
            }
        }
    }

    /**
     * Loads the next file and starts processing it
     */
    private void loadNextFile() throws IOException {
        // Close the previous file's reader if open
        if (bufferedReader != null) {
            bufferedReader.close();
        }

        // Process files one at a time
        while (!fileQueue.isEmpty()) {
            File file = fileQueue.poll();
            bufferedReader = new BufferedReader(new FileReader(file));
            wordQueue.clear(); // Ensure the queue is empty before loading new words

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");  // Split words by spaces
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordQueue.offer(word);
                    }
                }
            }

            // If words were found in the file, return; else move to the next file
            if (!wordQueue.isEmpty()) {
                return;
            }

            bufferedReader.close(); // Close if no words were found
        }
    }

    @Override
    public boolean hasNext() {
        return !wordQueue.isEmpty() || !fileQueue.isEmpty();
    }

    @Override
    public String next() {
        if (wordQueue.isEmpty()) {
            try {
                loadNextFile();  // Load the next file if no words are left
            } catch (IOException e) {
                throw new RuntimeException("Error reading files", e);
            }
        }

        if (wordQueue.isEmpty()) {
            throw new NoSuchElementException("No more words available");
        }

        return wordQueue.poll();
    }

    public static void main(String[] args) {
        try {
            WordDirectoryOOM iterator = new WordDirectoryOOM("C:\\Users\\Shriniwas\\Documents\\testing");
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
