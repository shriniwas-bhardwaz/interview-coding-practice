package LowLevelDesign.ThreadDesign.FolderDocumnetByteCount;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class ParallelFolderStatistics {

    public static void main(String[] args) {

        String folderPath = "C:\\Users\\Shriniwas\\Resume";
        File rootFolder = new File(folderPath);


        if(!rootFolder.exists() || !rootFolder.isDirectory()) {
            System.out.println("Invalid Folder path...");
            return;
        }

        ForkJoinPool pool = new ForkJoinPool();  // Create a ForkJoinPool
        FolderTask task = new FolderTask(rootFolder, true);

        FolderStats stats = pool.invoke(task);

        System.out.println("Folder statistics ...");
        System.out.println("Total Folders: " + stats.getFolderCount());
        System.out.println("Total Documents: " + stats.getDocumentCount());
        System.out.println("Total Size (bytes): " + stats.getTotalSize());
    }
}
