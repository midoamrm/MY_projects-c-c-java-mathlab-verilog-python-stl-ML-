package javaos;

import java.util.ArrayList;

public abstract class Scheduler {

    String[] scheduler_Type = {"FCFS , SJF_P , SJF_NP , PERIORITY_P , PERIORITY_NP , RR"};
    int num_Of_Processes;
    float time_Quantum;
    float avgWaitingTime = 0;
    ArrayList<Process> processes_Queue = new ArrayList<>();
    ArrayList<Process> running_Process = new ArrayList<>();
    boolean preemptive;

    public abstract void processHandling();
}

