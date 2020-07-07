/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaos;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class javaos extends Application {
    
    int flag_neg=0;
    int countstringlength(String s){
        int countlength=0;
        for(int i=0;i<s.length();i++){
      if(s.charAt(i)==' ')
          countlength++;
          }
       return  countlength+1;
    }
    
    public static void merge(Process arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        Process[] L = new Process[n1];
        Process[] R = new Process[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getArrival_TIme() <= R[j].getArrival_TIme()) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(Process arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

   
    public float[] stringtoint(int n, String input ){
    
       float []arr=new float[n];
     
       int startOfNum=0,endOfNumber=1;
       
       for (int i=0 ; i<n ; i++){

            for(int k=startOfNum ;  k<input.length() ; k++) {
                if(!(input.charAt(k)==' '))endOfNumber = k + 1;
                else break;
            }
             if(input.length()>0){
                 arr[i] = Float.parseFloat(input.substring(startOfNum,endOfNumber));
             }
             if(arr[i]<0){
             arr[i]=arr[i]*-1;
             flag_neg=1;
             
             }
             
            startOfNum = endOfNumber+1;
        }
       return arr;
    }
    
    
    
 
    
    
    
    
    Text defin(int i,String s,Map t1,Map t2){
     Text t = new Text (20, i, s);
     
    t.setOnMouseClicked(e->{
    
        System.out.println( t.getText());
        System.out.println(t1.get(t.getText()));
        t.setText(s+"("+t1.get(t.getText())+","+t2.get(t.getText())+")");
       
    
    });
      t.setOnMouseMoved(e->{
    
        System.out.println( t.getText());
        System.out.println(t1.get(t.getText()));
        t.setText(s);
       
    
    });
     
    
     return t;
     
    }
    Text definscale(float i,String s,int co){
    
    Text t = new Text (100+100*i,5020, s);
    
    co=(co)%3;
      if(co==0){
    
       t.setFill(Color.BURLYWOOD );
    }
        if(co==1){
    
        t.setFill(Color.RED );
    }
          if(co==2){
    
        t.setFill(Color.BLUE );
    }
    
    
    
     return t;
    
    
    }
    
    Text texlin(int i,String S,float t11,float t22){
    
    
    Text t=new Text((100+(t11)*100)+10,i,S);
    t.setFill(Color.BLACK);
    return t;
    }
    
    Line definli(int t,float t11,float t22,int co){
        
      
    Line raw1=new Line(100+t11*100,t,100+t22*100,t);
       
    co=co%3;
      if(co==0){
    
       raw1.setStroke(Color.BURLYWOOD);
    }
        if(co==1){
    
       raw1.setStroke(Color.RED);
    }
          if(co==2){
    
       raw1.setStroke(Color.BLUE);
    }
        raw1.setStrokeWidth(8);
    
    return raw1;
    }
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        Button start=new Button("Start The Scheduler");
        Text author=new Text("Designed By Mohamed mansi&Mohamed hassn&Mohamed Melgy");
        
        author.setFill(Color.BLACK);
        Text name=new Text("OS GUI Project ");
        name.setFill(Color.CORNSILK);
        name.setStyle("-fx-font: 24 arial;");
        
        start.setOnAction(EventHandler->{
        
            
        Label l1=new Label("Select Scheduling Type From The List");
        Label l2 = new Label("");
        ObservableList<String> account=
                FXCollections.observableArrayList(
                     "FCFS","RoundRobin","SJF","Priority"   
                );
        ListView<String> ivw=new  ListView<String>(account);
        //دة جزء الخاص باخيار من الايست
        MultipleSelectionModel<String> imode=ivw.getSelectionModel();
         imode.selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                
                String alog=newValue;
                l2.setText("The Selected Scheduling Type is: "+newValue);
                
                 
                 /////////////////////////////////////////////
                 
                    Image pic= new Image("javaos/mo.jpg");
       ImageView ivpic=new ImageView(pic);
         ivpic.setFitHeight(500);
         ivpic.setFitWidth(500);
          Button btn = new Button();
        btn.setText("ENTER");
        Text  l1=new Text ("Preemptive");
        l1.setFill(Color.CORNSILK);
        Text  l2=new Text ("Number Of Processes");
         l2.setFill(Color.CORNSILK);
         
        Text  l3=new Text ("Arrival Time");
        l3.setFill(Color.CORNSILK);
         
         
           Text  l4=new Text ("Time Quantum");
        l4.setFill(Color.CORNSILK);
         
        
        Text  l5=new Text ("Priority");
         l5.setFill(Color.CORNSILK);
          Text  l6=new Text ("Time Of The Process");
        l6.setFill(Color.CORNSILK);
        Text  l7=new Text ("State Of Input");
        l7.setFill(Color.GREEN);
        
        TextField t1=new TextField();
        TextField t2=new TextField();
         TextField t3=new TextField();
        TextField t4=new TextField();
         TextField t5=new TextField();
        TextField t6=new TextField();
          TextField t7=new TextField("Don't Put Input Here");
        GridPane grid=new  GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new javafx.geometry.Insets(25,25,25,25));
     //   grid.setGridLinesVisible(true);
                
                
        btn.setOnAction(EventHandler->{
           try {
            
            float q=0;
           int extraprocess=-1;
            String arivelltime="";
            String pitorty="";
            String premtive_nonpervtive="false";
            int flag_e=0; 
            int flag_q=0;
             
                
            
          // String  premtive_nonpervtive="false";
            // "fcfs","Roundroben","sjf","pirority"  
            if(     "RoundRobin".equals(alog)){
         q=Float.parseFloat(t4.getText().toString());
         if(q<0){
           q=q*-1;
            flag_q=1;          
         }
              }
            
           if( "SJF".equals(alog)||  "Priority".equals(alog)  ){ 
              premtive_nonpervtive=t1.getText().toString();
           }
        int  no_ofprocess=Integer.parseInt(t2.getText().toString());
            System.out.println("The no of processes is : "+no_ofprocess);
        
          
          arivelltime=t3.getText().toString();
          System.out.println("The arrival of processes is : "+arivelltime);
          
             
         
          if(     "Priority".equals(alog)){
          pitorty=t5.getText().toString();         
          }
            
        String  process=t6.getText().toString();
        System.out.println("time : "+process);
         
       // extraprocess=Integer.parseInt(t7.getText().toString());
        /////////////////////////////////////////////
           System.out.println(q);
          System.out.println(premtive_nonpervtive);
            System.out.println(no_ofprocess);
              System.out.println(arivelltime);
                System.out.println(pitorty);
                  System.out.println(process);
                   System.out.println(alog);
        
        
        
        
         
         
       // stutus
       // t7.setText("G_Chart:donefor "+alog);
       ////////////////////////////////////////////////////////////////// 
            System.out.println("asjhdgjhasgdjhasfjaf");
      float[] arrivalTime = new float[no_ofprocess];
      float[] processTime = new float[no_ofprocess];
      float[] priorityProcessArray = new float[no_ofprocess];
      System.out.println("asjhdgjhasgdjhasfjaf");
      arrivalTime = stringtoint(no_ofprocess,arivelltime);
      processTime = stringtoint(no_ofprocess, process);
      priorityProcessArray = stringtoint(no_ofprocess, pitorty);
      System.out.println("asjhdgjhasgdjhasfjaf");
      Process[] p = new Process[no_ofprocess];
      int flagdraw=0;
       for(int i=0 ; i<no_ofprocess ; i++){
           System.out.println("i ama in process for");
           if(!alog.equals("Priority"))p[i]= new Process(processTime[i] , arrivalTime[i] , ""+(i+1));
           else p[i] = new Process(processTime[i] , (int)priorityProcessArray[i] , arrivalTime[i] , ""+(i+1));
       }
         sort(p , 0 , p.length-1);
         int flag_=0;
    float[] ttt1 = new float[100];//{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    float[] ttt2 = new float[100];//{3,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
    int[] pp= new int[100];//{1,2,3,4,1,3,4,2,5,6,7,9,8,10,11,12,13,14,15,16}; 
    Map< String,Float> t_1 =  
                        new HashMap< String,Float>();
      Map< String,Float> t_2 =  
                        new HashMap< String,Float>();
    
       for(int i=0 ; i<no_ofprocess ; i++){
           System.out.println("The Time of process_"+i+": "+p[i].getTime());
       }
       
       FCFS fcfs = new FCFS(); 
       SJF sjf = new SJF();
       RR rr = new RR();
       Priority priority = new Priority();
       int rrsize=0;
       float waitee=0;
       //"fcfs","Roundroben","sjf","pirority" 
       
       if(alog.equals("FCFS")){
       
           System.out.println("i am in Fcfs if:(");
        fcfs.num_Of_Processes=p.length;

        for(int i = 0 ; i<p.length; i++){
            fcfs.processes_Queue.add(p[i]);
        }

        fcfs.processHandling();
        
           System.out.println("remaining time of process 1: "+fcfs.running_Process.get(0).getRemaining_Time());

        for(int i = 0 ; i<fcfs.running_Process.size(); i++){
            
            if (i<fcfs.num_Of_Processes)
                fcfs.avgWaitingTime+=(p[i].getWaitingTime());
        }
        fcfs.avgWaitingTime=fcfs.avgWaitingTime/fcfs.num_Of_Processes;
      
         waitee=fcfs.avgWaitingTime;
  
       
       
       
       
       
       
       
       
       
       
       ////////////////////////////////////////////////////////////////////
      //////////////////////chart///////////////////////
      
    for(int f=0;f<fcfs.running_Process.size();f++){
    
       // System.out.println("hello in for before");
     ttt1[f]=fcfs.running_Process.get(f).getStart();
   // System.out.println("hello in for after");
     
    
    ttt2[f]=fcfs.running_Process.get(f).getEnd();
       int temp2=Integer.parseInt(fcfs.running_Process.get(f).getProcess_Number());
       pp[f]= temp2;
        System.out.println(ttt1[f]);
         System.out.println(ttt2[f]);
          System.out.println(temp2);
    
    
    }
       
       
       
       rrsize=fcfs.running_Process.size();
       
       }
       
       if(alog.equals("SJF")){
       
           System.out.println("hello in sjf");
        sjf.num_Of_Processes=p.length;

        for(int i = 0 ; i<p.length; i++){
            sjf.processes_Queue.add(p[i]);
        }

           System.out.println("process_QUEUE: "+sjf.processes_Queue.get(0).getTime());
        
           sjf.preemptive=Boolean.parseBoolean(premtive_nonpervtive);
           System.out.println("yalahwyyyyyyyyyyyyyyytyyyyyyyyy");
           sjf.processHandling();
           System.out.println("yalahwyyyyyyyyyyyyyyy");
        for(int i = 0 ; i<sjf.running_Process.size(); i++){
            
            if (i<sjf.num_Of_Processes)
                sjf.avgWaitingTime +=(p[i].getWaitingTime());
        }
        sjf.avgWaitingTime=sjf.avgWaitingTime/sjf.num_Of_Processes;
        waitee=  sjf.avgWaitingTime;
      
           
       ////////////////////////////////////////////////////////////////////
      //////////////////////chart///////////////////////
      
    for(int f=0;f<sjf.running_Process.size();f++){
    
       // System.out.println("hello in for before");
     ttt1[f]=sjf.running_Process.get(f).getStart();
   // System.out.println("hello in for after");
     
    
    ttt2[f]=sjf.running_Process.get(f).getEnd();
       int temp2=Integer.parseInt(sjf.running_Process.get(f).getProcess_Number());
       pp[f]= temp2;
        System.out.println(ttt1[f]);
         System.out.println(ttt2[f]);
          System.out.println(temp2);
    
    
    }
       
       
       
       rrsize=sjf.running_Process.size();
       
       }
    //"Roundroben","sjf","pirority"
    
       if(alog.equals("RoundRobin")){
       
        rr.num_Of_Processes=p.length;
         rr.time_Quantum=q;
        for(int i = 0 ; i<p.length; i++){
            rr.processes_Queue.add(p[i]);
        }

        rr.processHandling();

        for(int i = 0 ; i<rr.running_Process.size(); i++){
            
            if (i<rr.num_Of_Processes)
                rr.avgWaitingTime+=(p[i].getWaitingTime());
        }
        rr.avgWaitingTime=rr.avgWaitingTime/rr.num_Of_Processes;
      
        waitee= rr.avgWaitingTime;
        
        
     
       
       
       
       
       
       
       
       
       
       
       ////////////////////////////////////////////////////////////////////
      //////////////////////chart///////////////////////
      
    for(int f=0;f<rr.running_Process.size();f++){
    
       // System.out.println("hello in for before");
     ttt1[f]=rr.running_Process.get(f).getStart();
   // System.out.println("hello in for after");
     
    
    ttt2[f]=rr.running_Process.get(f).getEnd();
       int temp2=Integer.parseInt(rr.running_Process.get(f).getProcess_Number());
       pp[f]= temp2;
        System.out.println(ttt1[f]);
         System.out.println(ttt2[f]);
          System.out.println(temp2);
    
    
    }
       
       
       
       rrsize=rr.running_Process.size();
       
       }
       
       if(alog.equals("Priority")){
       
        priority.num_Of_Processes=p.length;

        for(int i = 0 ; i<p.length; i++){
            priority.processes_Queue.add(p[i]);
        }
         priority.preemptive=Boolean.parseBoolean(premtive_nonpervtive);
        priority.processHandling();

        for(int i = 0 ; i<priority.running_Process.size(); i++){
            
            if (i<priority.num_Of_Processes)
                priority.avgWaitingTime+=(p[i].getWaitingTime());
        }
        priority.avgWaitingTime=priority.avgWaitingTime/priority.num_Of_Processes;
      waitee= priority.avgWaitingTime;
        
        
        
     /*  System.out.println("process 1: starts: "+fcfs.running_Process.get(0).getStart());
       System.out.println("process 1: ends: "+fcfs.running_Process.get(0).getEnd());
       System.out.println("process 2: starts: "+fcfs.running_Process.get(1).getStart());
       System.out.println("process 2: ends: "+fcfs.running_Process.get(1).getEnd());
      */ 
       
       
       
       
       
       
       
       
       
       
       ////////////////////////////////////////////////////////////////////
      //////////////////////chart///////////////////////
      
    for(int f=0;f<priority.running_Process.size();f++){
    
       // System.out.println("hello in for before");
     ttt1[f]=priority.running_Process.get(f).getStart();
   // System.out.println("hello in for after");
     
    
    ttt2[f]=priority.running_Process.get(f).getEnd();
       int temp2=Integer.parseInt(priority.running_Process.get(f).getProcess_Number());
       pp[f]= temp2;
        System.out.println(ttt1[f]);
         System.out.println(ttt2[f]);
          System.out.println(temp2);
    
    
    }
       
       
       
       rrsize=priority.running_Process.size();
       
       }
               
               
    //////////////n//////////////////////
    
    int cont=0;
      
      
      int num_p=no_ofprocess;
        int  cc3=5000;
        
        Text au=new Text(500,5090,"desgindBYmohmedrMansi");
           Text  waittimename=new  Text(50,5090,"AVG Wait Time:");
         Text  waittime=new  Text(250,5090,waitee+"");
        
        au.setFill(Color.BROWN);
        Text tm=new Text(8950,4990,"<Time>");
        tm.setFill(Color.DARKBLUE );
         Line raw=new Line(100,5000,9000,5000);
         Line colum=new Line(100,0,100,5000);
          raw.setStroke(Color.BLACK);
        raw.setStrokeWidth(5);
        
          colum.setStroke(Color.BLACK);
        colum.setStrokeWidth(5);
         Group root=new Group();
            
             int xx=0;
             /*
             
             );
          System.out.println(premtive_nonpervtive);
            System.out.println(no_ofprocess);
              System.out.println(arivelltime);
                System.out.println(pitorty);
                  System.out.println(process);
                   System.out.println(alog);
             
             */
             
             /* String p_T=process.replaceAll("\\s","");
             String A_T=arivelltime.replaceAll("\\s","");
             String P_P=pitorty.replaceAll("\\s","") ;
             */
             int  p_T= countstringlength(pitorty);
             int A_T=countstringlength(arivelltime);
             int  P_P=countstringlength(process);       
             
             
             if(alog.equals("Priority")){
                 if(no_ofprocess==p_T){
                 
                 flag_e=1;
                 }
                 
             }  //process arivelltime pitorty
               if(alog.equals("Priority")){
                              
                  if(no_ofprocess!=p_T){
                  
                      
                 flag_e=2;
                 }
             }
             
             /*
             arrivalTime = new int[no_ofprocess];
      int[] processTime = new int[no_ofprocess];
      int[] priorityProcessArray
             */
          
             
               System.out.println("////////////////////");
                System.out.println("q:"+q);
                System.out.println("permptive:"+premtive_nonpervtive);
                System.out.println("no of process:"+no_ofprocess);
                System.out.println("process.length:"+(pitorty.length()+":"+P_P));
                System.out.println("arivelltime .length:"+(arivelltime.length()+":"+A_T));
                 System.out.println("pitorty .length:"+( process .length()+":"+p_T));
                System.out.println("flag:"+flag_e);
               
                     System.out.println("////////////////////");
                     
                      System.out.println(P_P);
                      System.out.println(A_T);
                      System.out.println(p_T);
                      
                     
             
             if(q>=0&&("true".equals(premtive_nonpervtive)||"false".equals(premtive_nonpervtive))&&no_ofprocess>=0&&A_T==no_ofprocess&&(flag_e==0||flag_e==1)&&P_P==no_ofprocess&&flag_neg==0&&flag_q==0){
               /*l7.setText("          valid Input   ");
            grid.add(l7,1,6);
             */
                
                 l7.setText(  "Valid Input" );
               l7.setFont(Font.font(20));
                 flagdraw=1;
               
             }
             
          
             
             
               else{
             
          
             flag_neg=0;
                 
                l7.setText(  "Invalid Input" );
               
              l7.setFill(Color.RED);   
             l7.setFont(Font.font(20));
             }
             if(extraprocess==-1&&flagdraw==1){
             for(int i=1;i<=rrsize;i++){
                 cc3=cc3-20;
                  xx=i-1;
                  String str1 = Integer.toString(pp[xx]);
                   String ss2="p"+str1;
              root.getChildren().add(defin(cc3,ss2,t_1,t_2));
             
               float t111=0;
                float t222=0;     
              if(flag_==0){
          
           t_1.put(ss2, new Float(ttt1[xx]));
           t_2.put(ss2, new Float(ttt2[xx]));
                t111=ttt1[xx];
                t222=ttt2[xx];
                flag_=1;
               
              }
              else if(flag_==1){
                  t_1.put(ss2, new Float(ttt1[xx]));
           t_2.put(ss2, new Float(ttt2[xx]));
               t111=ttt1[xx];
               t222=ttt2[xx];
              }
                   String tt1=t111+"";
                  String tt2=t222+"";
                  root.getChildren().add(definscale(t111,tt1,xx));
                   root.getChildren().add(definscale(t222,tt2,xx));
                    
                   
                   
               root.getChildren().add(definli(cc3,t111,t222,xx));
                root.getChildren().add ( texlin(cc3,ss2,t111,t222));
                   System.out.println(70+t111*20);   
                     System.out.println(70+t222*20);         
               System.out.println(ttt1[xx]);
               System.out.println(ttt2[xx]);
             }
             
             
             
             
             
        root.getChildren().addAll(raw,colum,au,tm,waittimename, waittime);
        
     ScrollPane scrollPane = new ScrollPane();
         scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(root);
        
         waittimename.setOnMouseMoved(e->{
      //  Colour color=new   Colour(); 
         waittimename.setFill(Color.color(Math.random(),Math.random(),Math.random()));
          waittimename.setFont(Font.font(20));
                     
          waittime.setFill(Color.color(Math.random(),Math.random(),Math.random()));
         waittime.setFont(Font.font(20));
        
        });
        
        
        Scene scene = new Scene(scrollPane, 1200, 400,Color.CORNSILK);
         Stage nnnn=new Stage();
       nnnn.setTitle("    <Process running>              GANTCHART");
        nnnn.setScene(scene);
       nnnn.show();
      }
      
      
      
      
             
      
          
      
      
      
        
        ///////////////////////////////////
        
        
        
        
        
        
        
        
        
            }
            catch (Exception e ) {
                
          l7.setText("Invalid Input");
            
            l7.setFill(Color.RED);
             l7.setFont(Font.font(20));    
            }
        
        
        });
        // "fcfs","Roundroben","sjf","pirority" 
        if(     "SJF".equals(alog)||"Priority".equals(alog)){
        grid.add(l1,0,0);
        grid.add(t1,1,0);
            }
        grid.add(l2,0,1);
        grid.add(t2,1,1);
           
        grid.add(l3,0,2);
         grid.add(t3,1,2);
       
        
        if(     "RoundRobin".equals(alog)){
        grid.add(l4,0,3);
         grid.add(t4,1,3);
        }
        if(     "Priority".equals(alog)){
        grid.add(l5,0,4);
         grid.add(t5,1,4);
        }
        grid.add(l6,0,5);
         grid.add(t6,1,5);
        grid.add(l7,0,6);
        // grid.add(t7,1,6);
        grid.add(btn,2,7);
        
        
        
        StackPane root = new StackPane();
        root.getChildren().addAll(ivpic,grid);
        
        Scene scene2 = new Scene(root, 500, 500);
        Stage neww=new Stage();
        neww.setTitle("                                                        <<"+alog+">>");
        neww.setScene(scene2);
         
        
      primaryStage.close();
        neww.show();
    
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
            }
    
    
    });
        
        
        ivw.setPrefSize(300,200 );
        FlowPane root=new FlowPane();
        root.setOrientation(Orientation.VERTICAL);
        root.getChildren().addAll(l1,ivw,l2);
        Scene scene = new Scene(root, 300, 250);
        Stage nww2=new Stage();
        nww2.setTitle("cpu S_C");
        nww2.setScene(scene);
        nww2.show();
            });
        
        
          Image pic= new Image("javaos/mo.jpg");
       ImageView ivpic2=new ImageView(pic);
         ivpic2.setFitHeight(500);
         ivpic2.setFitWidth(500);
           GridPane grid2=new  GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setVgap(10);
        grid2.setHgap(10);
       grid2.add(start,3,29);
        grid2.add(author,3,30);
         StackPane root5 = new StackPane();
        root5.getChildren().addAll(ivpic2,name,grid2);
        
        Scene scene4 = new Scene(root5, 500, 500);
        
        primaryStage.setTitle("cpu S_C");
        primaryStage.setScene(scene4);
        primaryStage.show();
        
        
        
        
        
        
    }
                
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
 ////////////////////////////////////////////////////////////
/*
1-awating time=
2-round robin&first come first served not needed preemptive
priority not needed time quantume
3-get instuction  needed repreanteded  "done"

*/
////////////////////////////////////////////////////