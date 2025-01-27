package LowLevelDesign.ThreadDesign.FolderDocumnetByteCount;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class FolderTask extends RecursiveTask<FolderStats> {

    private final File folder;

    private final boolean isRootFolder;

    public FolderTask(File folder, boolean isRootFolder) {
        this.folder = folder;
        this.isRootFolder = isRootFolder;
    }

    @Override
    protected FolderStats compute() {
        FolderStats stats = new FolderStats();

        if(folder == null || !folder.exists() || !folder.isDirectory()) {
            return  stats;
        }

        // Count the  folder only if its not the root folder
        if(!isRootFolder) {
            stats.incrementFolderCount();
        }

        File[] files = folder.listFiles();
        if(files == null) {
            return stats;
        }

        // Fork task for subfolders
        FolderTask[] subTasks =  Arrays.stream(files)
                .filter(File::isDirectory)
                .map(subFolder -> new FolderTask(subFolder,false))
                .toArray(FolderTask[]::new);

        for(FolderTask task : subTasks) {
            task.fork();
        }

        //Count files in the current folder
        Arrays.stream(files)
                .filter(File::isFile)
                .forEach(file -> {
                    stats.incrementDocumentCount();
                    stats.addTotalSize(file.length());
                });

        //Join results from subtasks
        for(FolderTask task : subTasks) {
            FolderStats subTaskStats = task.join();
            stats.getFolderCount().addAndGet(subTaskStats.getFolderCount().get());
            stats.getDocumentCount().addAndGet(subTaskStats.getDocumentCount().get());
            stats.getTotalSize().addAndGet(subTaskStats.getTotalSize().get());
        }

        return stats;
    }
}
