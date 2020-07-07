package javaos;

public class RR extends Scheduler {

    private float time_Counter=0;

    public void delay(float time , int running_Process_Index) {

        boolean flag=true;
        if(processes_Queue.get(running_Process_Index).getArrival_TIme()>time_Counter)
            time_Counter=processes_Queue.get(running_Process_Index).getArrival_TIme();

        processes_Queue.get(running_Process_Index).setStart(time_Counter);

        for (int i = 1; i <= time; i++) {

            time_Counter++;
            //processes_Queue.get(running_Process_Index).setRemaining_Time(time-i);
            processes_Queue.get(running_Process_Index).setRemaining_Time(time-
                    ((time_Counter)-processes_Queue.get(running_Process_Index).getStartCopy()));
            if (time_Quantum < time) {
                time_Counter+=time_Quantum-1;
                processes_Queue.get(running_Process_Index).setRemaining_Time(time-
                        ((time_Counter)-processes_Queue.get(running_Process_Index).getStartCopy()));
                flag=true;
                break;
            }
        }
        if(processes_Queue.get(running_Process_Index).getRemaining_Time()>0
                && processes_Queue.get(running_Process_Index).getRemaining_Time()<1 && flag){
            time_Counter+=processes_Queue.get(running_Process_Index).getRemaining_Time();
            processes_Queue.get(running_Process_Index).setRemaining_Time(0);
        }

        processes_Queue.get(running_Process_Index).setEnd(time_Counter);
    }

    @Override
    public void processHandling() {


        for(int current_Process=0 ; processes_Queue.size()!=0 ; current_Process = (current_Process+1)%processes_Queue.size()){

            boolean flag=false;
            delay(processes_Queue.get(current_Process).getRemaining_Time() , current_Process);
            running_Process.add(processes_Queue.get(current_Process));
            processes_Queue.get(current_Process).getProcessStatus();
            if (processes_Queue.size()>1 && current_Process!=processes_Queue.size()-1) {
                if (processes_Queue.get(current_Process).getEndCopy() < processes_Queue.get(current_Process + 1).getArrival_TIme()
                        && processes_Queue.size() > 1) {
                   flag=true;
                }
            }
            /*System.out.println(processes_Queue.get(current_Process).getProcessStatus());
            System.out.println("...Start at : "+processes_Queue.get(current_Process).getStart()+" Ends at : "+processes_Queue.get(current_Process).getEnd());*/
            if(processes_Queue.get(current_Process).getRemaining_Time()==0) {
                processes_Queue.remove(current_Process);
                if (processes_Queue.size() == 0) break;   //as to avoid dividing by zero when all processes finished
                current_Process--;
            }
            if (flag) current_Process=-1;
        }

    }
}