package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MMU{


    private float totalMemorySize;
    private String allocationMethodology;
    private List<SegmentOrHole> segmentOrHoles;

    public MMU(float totalMemorySize, String allocationMethodology , List<SegmentOrHole> segmentOrHoles) {
        this.totalMemorySize = totalMemorySize;
        this.allocationMethodology = allocationMethodology;
        this.segmentOrHoles = segmentOrHoles;
        virtualFillingArray();
    }

    public void setAllocationMethodology(String allocationMethodology) {
        this.allocationMethodology = allocationMethodology;
    }

    private void virtualFillingArray() {

        int processCounter = 0;
        for (int i = 0; i < this.segmentOrHoles.size(); i+=2) {
            int size = this.segmentOrHoles.size();
            if (i==0) {
                if(this.segmentOrHoles.get(0).getHoleStartingAddress() != 0){
                    processCounter--;
                    this.segmentOrHoles.add(0, new SegmentOrHole(processCounter, "" + processCounter
                            , this.segmentOrHoles.get(0).getHoleStartingAddress()));
                    this.segmentOrHoles.get(0).setSegmentStartingAddress(0);
                } else
                    i--;

                if(size==1){
                    if(this.totalMemorySize==this.segmentOrHoles.get(this.segmentOrHoles.size() - 1).getEndAddress())
                        break;
                    processCounter--;
                    this.segmentOrHoles.add(new SegmentOrHole(processCounter, "" + processCounter, this.totalMemorySize - this.segmentOrHoles.get(i+1).getEndAddress()));
                    this.segmentOrHoles.get(this.segmentOrHoles.size()-1).setSegmentStartingAddress(this.segmentOrHoles.get(this.segmentOrHoles.size()-2).getEndAddress());
                    break;
                }
            } else if (i == this.segmentOrHoles.size() - 1) {
                if(this.segmentOrHoles.get(i).getHoleStartingAddress()!=this.segmentOrHoles.get(i - 1).getEndAddress()){
                    processCounter--;
                    this.segmentOrHoles.add(i, new SegmentOrHole(processCounter, "" + processCounter
                            , this.segmentOrHoles.get(i).getHoleStartingAddress() - this.segmentOrHoles.get(i - 1).getEndAddress()));
                    this.segmentOrHoles.get(i).setSegmentStartingAddress(this.segmentOrHoles.get(i-1).getEndAddress());
                    i++;
                }
                if(this.totalMemorySize==this.segmentOrHoles.get(this.segmentOrHoles.size() - 1).getEndAddress())
                    break;
                processCounter--;
                this.segmentOrHoles.add(new SegmentOrHole(processCounter, "" + processCounter, this.totalMemorySize - this.segmentOrHoles.get(i).getEndAddress()));
                this.segmentOrHoles.get(this.segmentOrHoles.size()-1).setSegmentStartingAddress(this.segmentOrHoles.get(this.segmentOrHoles.size()-2).getEndAddress());
                break;
            } else if(this.segmentOrHoles.get(i).getHoleStartingAddress()!=this.segmentOrHoles.get(i - 1).getEndAddress()) {
                processCounter--;
                this.segmentOrHoles.add(i, new SegmentOrHole(processCounter, "" + processCounter
                        , this.segmentOrHoles.get(i).getHoleStartingAddress() - this.segmentOrHoles.get(i - 1).getEndAddress()));
                this.segmentOrHoles.get(i).setSegmentStartingAddress(this.segmentOrHoles.get(i-1).getEndAddress());
            }else {
                this.segmentOrHoles.get(i-1).setHoleSize(this.segmentOrHoles.get(i-1).getHoleSize()+this.segmentOrHoles.get(i).getHoleSize());
                this.segmentOrHoles.remove(i);
                i-=2;
            }
        }
    }

    public String deallocate(int processNumber){

        String check="Process or Segment isn't Found";
        for(int i=0 ; i<this.segmentOrHoles.size() ; i++){
            if(processNumber == this.segmentOrHoles.get(i).getProcessNumber() && !this.segmentOrHoles.get(i).getType().equals("hole")){
                this.segmentOrHoles.get(i).setType("hole");
                this.segmentOrHoles.get(i).setHoleSize(this.segmentOrHoles.get(i).getSegmentsSize());
                this.segmentOrHoles.get(i).setHoleStartingAddress(this.segmentOrHoles.get(i).getSegmentStartingAddress());

                if(i!=this.segmentOrHoles.size()-1){

                    if(this.segmentOrHoles.get(i+1).getType().equals("hole") && this.segmentOrHoles.get(i).getEndAddress()==this.segmentOrHoles.get(i+1).getHoleStartingAddress()) {
                        this.segmentOrHoles.get(i).setHoleSize(this.segmentOrHoles.get(i + 1).getHoleSize() + this.segmentOrHoles.get(i).getSegmentsSize());
                        this.segmentOrHoles.get(i).setSegmentsSize(this.segmentOrHoles.get(i).getHoleSize());
                        this.segmentOrHoles.remove(i + 1);
                    }
                }

                if(i>0){

                    if(this.segmentOrHoles.get(i-1).getType().equals("hole") && this.segmentOrHoles.get(i-1).getEndAddress()==this.segmentOrHoles.get(i).getSegmentStartingAddress()){
                        this.segmentOrHoles.get(i-1).setHoleSize(this.segmentOrHoles.get(i-1).getHoleSize()+this.segmentOrHoles.get(i).getSegmentsSize());
                        this.segmentOrHoles.remove(i);
                        i--;
                    }
                }
                check = "Process and Segments Deallocated Successfuly";
            }
        }
        return check;
    }

    public String deallocate(String segmentName){

        for (SegmentOrHole segmentOrHole : this.segmentOrHoles) {
            if (segmentName.equals(segmentOrHole.getSegmentsName())) {
                return deallocate(segmentOrHole.getProcessNumber());
            }
        }

        /*for(int i=0 ; i<this.segmentOrHoles.size() ; i++){
            if(segmentName.equals(this.segmentOrHoles.get(i).getSegmentsName())){
                this.segmentOrHoles.get(i).setType("hole");
                this.segmentOrHoles.get(i).setHoleSize(this.segmentOrHoles.get(i).getSegmentsSize());
                this.segmentOrHoles.get(i).setHoleStartingAddress(this.segmentOrHoles.get(i).getSegmentStartingAddress());

                if(i!=this.segmentOrHoles.size()-1){

                    if(this.segmentOrHoles.get(i+1).getType().equals("hole") && this.segmentOrHoles.get(i).getEndAddress()==this.segmentOrHoles.get(i+1).getHoleStartingAddress()) {
                        this.segmentOrHoles.get(i).setHoleSize(this.segmentOrHoles.get(i+1).getHoleSize() + this.segmentOrHoles.get(i).getSegmentsSize());
                        this.segmentOrHoles.remove(i + 1);
                    }
                }
                if(i>0){

                    if(this.segmentOrHoles.get(i-1).getType().equals("hole") && this.segmentOrHoles.get(i-1).getEndAddress()==this.segmentOrHoles.get(i).getSegmentStartingAddress()){
                        this.segmentOrHoles.get(i-1).setHoleSize(this.segmentOrHoles.get(i-1).getHoleSize()+this.segmentOrHoles.get(i).getSegmentsSize());
                        this.segmentOrHoles.remove(i);
                    }
                }
                return "success";
            }
        }*/

       return "Segmentisn't Found";
    }

    public String handling(SegmentOrHole segment){

        //virtualFillingArray();
        if(this.allocationMethodology.equals("First_Fit")){

            for(int i=0 ; i<this.segmentOrHoles.size() ; i++){

                if(this.segmentOrHoles.get(i).getType().equals("hole")){
                    if(this.segmentOrHoles.get(i).getHoleSize()>=segment.getSegmentsSize()){
                        segment.setSegmentStartingAddress(this.segmentOrHoles.get(i).getHoleStartingAddress()); //setting starting address of new segment.
                        this.segmentOrHoles.get(i).setHoleStartingAddress(segment.getEndAddress());     //configure the starting address of hole after allocating of new segment.
                        this.segmentOrHoles.get(i).setHoleSize(this.segmentOrHoles.get(i).getHoleSize()-segment.getSegmentsSize()); //to adjust the size of hole after allocating of new segment.
                        if(this.segmentOrHoles.get(i).getHoleSize()==0) this.segmentOrHoles.remove(i); //if hole size = 0 then remove from array.
                        this.segmentOrHoles.add( i , segment); //to add process and shift hole.
                        return "done";
                    }
                }
            }
            return "Process Doesn't fit";

        } else if (this.allocationMethodology.equals("Best_Fit")){
            Collections.sort(this.segmentOrHoles);
            for(int i=0 ; i<this.segmentOrHoles.size() ; i++){

                if(this.segmentOrHoles.get(i).getType().equals("hole")){
                    if(this.segmentOrHoles.get(i).getHoleSize()>=segment.getSegmentsSize()){
                        segment.setSegmentStartingAddress(this.segmentOrHoles.get(i).getHoleStartingAddress()); //setting starting address of new segment.
                        this.segmentOrHoles.get(i).setHoleStartingAddress(segment.getEndAddress());     //configure the starting address of hole after allocating of new segment.
                        this.segmentOrHoles.get(i).setHoleSize(this.segmentOrHoles.get(i).getHoleSize()-segment.getSegmentsSize()); //to adjust the size of hole after allocating of new segment.
                        if(this.segmentOrHoles.get(i).getHoleSize()==0) this.segmentOrHoles.remove(i); //if hole size = 0 then remove from array.
                        this.segmentOrHoles.add( i , segment); //to add process and shift hole.
                        return "done";
                    }
                }
            }
            return "Process doesn't fit";
        }
        return "Invalid_Type";
    }

    public void sortedMemory(){

        SegmentOrHole.trickyCompare=true;
        Collections.sort(this.segmentOrHoles);
        SegmentOrHole.trickyCompare=false;
    }

    public List<SegmentOrHole> getSegmentOrHoles() { //for GUI
        sortedMemory();
        return segmentOrHoles;
    }

    @Override
    public String toString() {
        sortedMemory();
        String output="[\n";
        for (SegmentOrHole segmentOrHole : segmentOrHoles) {

            if (segmentOrHole.getType().equals("hole"))
                output += "( type: " + segmentOrHole.getType() + " , starting address: " + segmentOrHole.getHoleStartingAddress() + " , End address: " + segmentOrHole.getEndAddress() + "),\n";
            else
                output += "( type: " + segmentOrHole.getSegmentsName() + " , starting address: " + segmentOrHole.getSegmentStartingAddress() + " , End address: " + segmentOrHole.getEndAddress() + "),\n";
        }
        return output+"]";
    }
}