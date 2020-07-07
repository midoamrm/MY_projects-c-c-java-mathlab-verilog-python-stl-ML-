package sample;

public class SegmentOrHole implements Comparable<SegmentOrHole> {

    private String type;
    private int processNumber;
    private float holeStartingAddress;
    private float segmentStartingAddress;
    private String segmentsName;
    private float segmentsSize;
    private float holeSize;
    public static boolean trickyCompare = false;

    public SegmentOrHole(float holeStartingAddress, float holeSize) {  //hole constructor
        this.type = "hole";
        this.holeStartingAddress = holeStartingAddress;
        this.holeSize = holeSize;
    }

    public SegmentOrHole(int processNumber, String segmentsName, float segmentsSize) { //segment constructor
        this.type = "segment";
        this.processNumber = processNumber;
        this.segmentsName = segmentsName;
        this.segmentsSize = segmentsSize;
    }

    public String getType() {
        return type;
    }

    public int getProcessNumber() {
        return processNumber;
    }

    public float getHoleStartingAddress() {
        return holeStartingAddress;
    }

    public float getSegmentStartingAddress() {
        return segmentStartingAddress;
    }

    public String getSegmentsName() {
        return segmentsName;
    }

    public float getSegmentsSize() {
        return segmentsSize;
    }

    public float getHoleSize() {
        return holeSize;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHoleStartingAddress(float holeStartingAddress) {
        this.holeStartingAddress = holeStartingAddress;
    }

    public void setSegmentStartingAddress(float segmentStartingAddress) {
        this.segmentStartingAddress = segmentStartingAddress;
    }

    public void setHoleSize(float holeSize) {
        this.holeSize = holeSize;
    }

    public void setSegmentsSize(float segmentsSize) {
        this.segmentsSize = segmentsSize;
    }

    public float getEndAddress(){
        if(type.equals("hole"))
            return this.holeStartingAddress + this.holeSize;
        else
            return this.segmentStartingAddress + this.segmentsSize;
    }

    @Override
    public int compareTo(SegmentOrHole segmentOrHole) {

        if(trickyCompare){

            if(this.getEndAddress() > segmentOrHole.getEndAddress())
                return 1;
            else if(this.getEndAddress() == segmentOrHole.getEndAddress())
                return 0;
            else
                return -1;
        }
        if(this.holeSize > segmentOrHole.holeSize)
            return 1;
        else if(this.holeSize == segmentOrHole.holeSize)
            return 0;
        else
            return -1;
    }



}
