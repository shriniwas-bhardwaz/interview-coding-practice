package LowLevelDesign.ThreadDesign.FolderDocumnetByteCount;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class FolderStats {

    private final AtomicInteger folderCount = new AtomicInteger(0);
    private final AtomicInteger documentCount = new AtomicInteger(0);
    private final AtomicLong totalSize = new AtomicLong(0);

    public void incrementFolderCount() {
        folderCount.incrementAndGet();
    }

    public void incrementDocumentCount() {
        documentCount.incrementAndGet();
    }

    public void addTotalSize(long size) {
        totalSize.addAndGet(size);
    }

    public AtomicInteger getFolderCount() {
        return folderCount;
    }

    public AtomicInteger getDocumentCount() {
        return documentCount;
    }

    public AtomicLong getTotalSize() {
        return totalSize;
    }
}
