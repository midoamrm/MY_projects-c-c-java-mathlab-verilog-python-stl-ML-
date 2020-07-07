
package javaos;

public class FCFS extends Scheduler {

    @Override
    public void processHandling(){

        float runTime=0;
        for(int i=0 ; i<num_Of_Processes ; i++){

            if(processes_Queue.get(i).getArrival_TIme()>runTime)
                runTime=processes_Queue.get(i).getArrival_TIme();
            processes_Queue.get(i).setStart(runTime);
            processes_Queue.get(i).setEnd(runTime+processes_Queue.get(i).getTime());
            running_Process.add(processes_Queue.get(i));
            processes_Queue.get(i).getProcessStatus();
            runTime+=processes_Queue.get(i).getTime();
        }
    }
}

