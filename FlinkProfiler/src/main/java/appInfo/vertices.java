package appInfo;

/**
 * Created by y81022857 on 2017/7/13.
 */
public class vertices {

    /*
     Information form http://localhost:8081/jobs/<jobId>/vertices/
      */

    private String verticesId;
    private String verticesName;
    private int parallelism;
    private String status;
    private int startTime;
    private int endTime;
    private int duration;
    private int readBytes;
    private int writeBytes;
    private int readRecords;
    private int writeRecords;

    public String getVerticesId() {
        return verticesId;
    }

    public void setVerticesId(String verticesId) {
        this.verticesId = verticesId;
    }

    public String getVerticesName() {
        return verticesName;
    }

    public void setVerticesName(String verticesName) {
        this.verticesName = verticesName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getParallelism() {
        return parallelism;
    }

    public void setParallelism(int parallelism) {
        this.parallelism = parallelism;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getReadBytes() {
        return readBytes;
    }

    public void setReadBytes(int readBytes) {
        this.readBytes = readBytes;
    }

    public int getWriteBytes() {
        return writeBytes;
    }

    public void setWriteBytes(int writeBytes) {
        this.writeBytes = writeBytes;
    }

    public int getReadRecords() {
        return readRecords;
    }

    public void setReadRecords(int readRecords) {
        this.readRecords = readRecords;
    }

    public int getWriteRecords() {
        return writeRecords;
    }

    public void setWriteRecords(int writeRecords) {
        this.writeRecords = writeRecords;
    }

    @Override
    public String toString() {
        return "vertices{" +
                "verticesId='" + verticesId + '\'' +
                ", verticesName='" + verticesName + '\'' +
                ", parallelism=" + parallelism +
                ", status='" + status + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", duration=" + duration +
                ", readBytes=" + readBytes +
                ", writeBytes=" + writeBytes +
                ", readRecords=" + readRecords +
                ", writeRecords=" + writeRecords +
                '}';
    }
}
