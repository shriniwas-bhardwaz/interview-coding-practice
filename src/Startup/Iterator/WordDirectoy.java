package Startup.Iterator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordDirectoy implements Iterator<String> {

    private Queue<String> wordQueue;  // Store words to process
    private Queue<File> fileQueue;   // Store files to process
    private BufferedReader bufferedReader; // Reads word from the file

    public WordDirectoy(String rootDirectory) {
        this.wordQueue = new LinkedList<>();
        this.fileQueue = new LinkedList<>();
        this.bufferedReader = null;

        collectFilesLastFirst(new File(rootDirectory));  // Use in case of Dfs
//        collectFiles(new File(rootDirectory));    Use in case of Bfs

        try {
            loadNextFile();
        } catch (IOException e) {
            throw new RuntimeException("Error initializing iterator..",e);
        }

    }

    /* Bfs approach */
    private void collectFiles(File directory) {
        Queue<File> directoryQueue = new LinkedList<>();
        directoryQueue.add(directory);

        while (!directoryQueue.isEmpty()) {
            File currentDir = directoryQueue.poll();
            File[] files = currentDir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        directoryQueue.add(file); // Add subdirectory for processing
                    } else {
                        fileQueue.offer(file); // Add file for word extraction
                    }
                }
            }
        }
    }

    private void collectFilesLastFirst(File directory) {
        Stack<File> directoryStack = new Stack<>();
        directoryStack.push(directory);

        while (!directoryStack.isEmpty()) {
            File currentDir = directoryStack.pop();
            File[] files = currentDir.listFiles();

            if (files != null) {
                List<File> subDirectories = new ArrayList<>();
                List<File> fileList = new ArrayList<>();

                // Separate files and directories
                /* Don't use file.isDirectory() in starting. To get exception  */
                for (File file : files) {
                    if (file.isDirectory()) {  /* Don't use file.isDirectory() in starting. To get exception  */
                        subDirectories.add(file);   /* Don't use file.isDirectory() in starting. To get exception  */
                    } else {
                        fileList.add(file);  /* Only write this in starting */
                    }
                }

                // First push directories in **normal order** (so deepest is processed first)
                Collections.reverse(subDirectories);  /* Don't use this in starting */
                for (File subDir : subDirectories) {
                    directoryStack.push(subDir);
                }

                // Now process the files **after all subdirectories are handled**
                for (File file : fileList) {
                    fileQueue.offer(file);
                }
            }
        }
    }





    private void loadNextFile() throws  IOException {
        if(bufferedReader != null)  bufferedReader.close();

        while(!fileQueue.isEmpty()) {
            File file = fileQueue.poll();  // Change to peek() while writing the code
            bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            wordQueue.offer("File Read : " + file.getName() +"\n"); // Add only when required
            while((line = bufferedReader.readLine()) != null) {
                String[] words = line.trim().split(" ");
                for(String word : words) {
                    if(!word.isEmpty())
                    { wordQueue.offer(word); }
                }
                wordQueue.offer("\n");  // Add in the last  not needed in starting
            }
            wordQueue.offer("\n"); // Add only when required

        }
    }

    @Override
    public boolean hasNext() {
        return !wordQueue.isEmpty() || !fileQueue.isEmpty();  // Don't put not symbol here.
    }

    @Override
    public String next() {
        if(wordQueue.isEmpty()) {
            try {
                loadNextFile();
            } catch (IOException e) {
                throw new RuntimeException("Error reading files", e);
            }
        }
        if(wordQueue.isEmpty()) {
            throw new NoSuchElementException("No more words are avaialable");
        }
        return wordQueue.poll();  // Do peek() here instead of poll() at starting.
    }


    public static void main(String[] args) {
        try {
            WordDirectoy iterator = new WordDirectoy("C:\\Users\\Shriniwas\\Documents\\testing");
            while(iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
