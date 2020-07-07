package javaos;

public class SJF extends Scheduler {

    /*
        -Description:
        *grantProcessArrival() is to check the equals of arrival time and set is_Arrived variable as true to put them in ready to
        execute
        *min() to get the min process to execute among the ready processes
        *delay() used for several functions:
            1-run the process as in the CPU
            2-check for arrival processes during the execution of the running process
            3-if there is arrival processes during the execution then it set is_Arrival to true to put it on ready queue
            4-if preemptive then it break from the execution if there is a process arrived during the execution and there is
            a smaller process in ready queue
            5-it saves the remaining time for the preempted process.
            6-it get the index of the next process to be arrived to know when to check the ready queue.

     */

    private int next_Process;
    private float arrival_Time=0 ;
    private static final int ONE_SECOND_ITERATION = 1000;

    public void grantProcessArrival(int current_Process){

        processes_Queue.get(current_Process).setIs_Arrived(true);
        int x = processes_Queue.size();
        for (int i=current_Process+1 ; i<processes_Queue.size() ; i++)
            if(processes_Queue.get(current_Process).getArrival_TIme()>=processes_Queue.get(i).getArrival_TIme())
                processes_Queue.get(i).setIs_Arrived(true);
            else {
                if(!processes_Queue.get(i).isIs_Arrived()) next_Process=i;
                break;
            }
    }

    public int min(int assumed_Min_Process){

        for(int i=0 ; i<processes_Queue.size() ; i++){

            if(processes_Queue.get(i).isIs_Arrived()) {
                if (processes_Queue.get(assumed_Min_Process).getRemaining_Time() > processes_Queue.get(i).getRemaining_Time()) {
                    assumed_Min_Process = i;
                }
            }
            else break;
        }
        return assumed_Min_Process;
    }

    public void delay(float time , int running_Process_Index) {

        boolean flag=true;
        if(processes_Queue.get(running_Process_Index).getArrival_TIme()>arrival_Time)
            arrival_Time=processes_Queue.get(running_Process_Index).getArrival_TIme();

        processes_Queue.get(running_Process_Index).setStart(arrival_Time);

        while(processes_Queue.get(running_Process_Index).getRemaining_Time()>=1) {

            arrival_Time++;
            processes_Queue.get(running_Process_Index).setRemaining_Time(time-
                    ((arrival_Time)-processes_Queue.get(running_Process_Index).getStartCopy()));

            if (next_Process < processes_Queue.size() && next_Process>-1 && processes_Queue.size()>1) {
                if (((int)arrival_Time) >= processes_Queue.get(next_Process).getArrival_TIme()) {
                    processes_Queue.get(next_Process).setIs_Arrived(true);
                    arrival_Time=processes_Queue.get(next_Process).getArrival_TIme();
                    processes_Queue.get(running_Process_Index).setRemaining_Time(time-
                            ((arrival_Time)-processes_Queue.get(running_Process_Index).getStartCopy()));

                    if(preemptive) {
                        if (min(running_Process_Index) != running_Process_Index) {

                            flag = false;
                            arrival_Time = processes_Queue.get(next_Process).getArrival_TIme();
                            next_Process++;
                            break;
                        }
                    }
                    next_Process++;
                }
            }
        }
        if(processes_Queue.get(running_Process_Index).getRemaining_Time()>0
                && processes_Queue.get(running_Process_Index).getRemaining_Time()<1 && flag){
            arrival_Time+=processes_Queue.get(running_Process_Index).getRemaining_Time();
            processes_Queue.get(running_Process_Index).setRemaining_Time(0);
        }

        processes_Queue.get(running_Process_Index).setEnd(arrival_Time);
    }

    @Override
    public void processHandling() {

        int current_Process=0;
        //String previous_Process_Status="";
        while(processes_Queue.size()!=0){

            grantProcessArrival(current_Process);                   //set is_Arrival to the equaled arrival process
            int min_Process_Index = min(current_Process);           //check the smallest process to execute among the arrived ones
            delay(processes_Queue.get(min_Process_Index).getRemaining_Time() , min_Process_Index);  //run process
            running_Process.add(processes_Queue.get(min_Process_Index));
            processes_Queue.get(min_Process_Index).getProcessStatus();
            /*if(!previous_Process_Status.equals(processes_Queue.get(min_Process_Index).getProcessStatus()))
                System.out.println(processes_Queue.get(min_Process_Index).getProcessStatus());  //print the process status(running , finished)
            previous_Process_Status = processes_Queue.get(min_Process_Index).getProcessStatus();*/ //for not repeating the sae status
            if(processes_Queue.get(min_Process_Index).getRemaining_Time()==0){  //check if the process finished
                processes_Queue.remove(min_Process_Index);      //remove the process
                if(next_Process!=0)next_Process--;     //as you remove one process then the index of next process decreased by 1
            }
        }
    }
}