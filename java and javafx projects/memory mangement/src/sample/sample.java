/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

/**
 *
 * @author SOLUTIONS
 */
public class  sample extends Application {
    
     Text definscale6(float i,String s,int co){
    
    Text t = new Text (200, 70+20*i, s);
     co=(co)%3;
      if(co==0){
    
       t.setFill(Color.BLACK );
    }
        if(co==1){
    
        t.setFill(Color.RED );
    }
          if(co==2){
    
        t.setFill(Color.BLUE );
    }
        
    
    
     return t;
    
    
    }
     Text definscale66(float i,String s,int co){
    
    Text t = new Text (0, 70+20*i, s);
     co=(co)%3;
      if(co==0){
    
       t.setFill(Color.BLACK );
    }
        if(co==1){
    
        t.setFill(Color.RED );
    }
          if(co==2){
    
        t.setFill(Color.BLUE );
    }
        
    
    
     return t;
    
    
    }
     Text definscale32(float i,String s,int co){
    
    Text t = new Text (600, 70+20*i, s);
     co=(co)%3;
      if(co==0){
    
       t.setFill(Color.BLACK );
    }
        if(co==1){
    
        t.setFill(Color.RED );
    }
          if(co==2){
    
        t.setFill(Color.BLUE );
    }
        
    
    
     return t;
    
    
    }
    
    Text defin(float i,String s,Map t1,Map t2 ,float scale){
     Text t = new Text (500, 1+1*i, s);
     
    t.setOnMouseEntered(e->{
    
        System.out.println( t.getText());
        System.out.println(t1.get(t.getText()));
        t.setText(s+"("+"base address::"+t1.get(t.getText())+","+"limt address::"+t2.get(t.getText())+")");
       
    
    });
      t.setOnMouseExited(e->{
    
        System.out.println( t.getText());
        System.out.println(t1.get(t.getText()));
        t.setText(s);
       
    
    });
     
    t.setOnMouseClicked(e->{
    
        System.out.println( );
        System.out.println( "deallocted");
        
       
    
    });
      
     return t;
    }
    
     Text defin2(float i,String s ){
     Text t = new Text (500, 1+1*i, s);
     
   
     
    t.setOnMouseClicked(e->{
    
        System.out.println( );
        System.out.println( "deallocted");
        
       
    
    });
      
     return t;
    }
    
    
     Text definscale(float i,String s,int co,float scale){
    
    Text t = new Text (200, 1+1*i, s);
     co=(co)%3;
      if(co==0){
    
       t.setFill(Color.BLACK );
    }
        if(co==1){
    
        t.setFill(Color.RED );
    }
          if(co==2){
    
        t.setFill(Color.BLUE );
    }
        
    
    
     return t;
    
    
    }
     Text definscale2(float i,String s,int co){
    
    Text t = new Text (200, 1+1*i, s);
     co=(co)%3;
      if(co==0){
    
       t.setFill(Color.BLACK );
    }
        if(co==1){
    
        t.setFill(Color.RED );
    }
          if(co==2){
    
        t.setFill(Color.BLUE );
    }
        
    
    
     return t;
    
    
    }
     Line definli(float t,float t11,float t22,int co,float scale){
    Line raw1=new Line(310,1+t11*1,900,1+t22*1);
    co=(co)%3;
      if(co==0){
    
       raw1.setStroke(Color.BLACK);
    }
        if(co==1){
    
       raw1.setStroke(Color.RED);
    }
          if(co==2){
    
       raw1.setStroke(Color.BLUE);
    }
        raw1.setStrokeWidth(5);
    
    return raw1;
    }
     
      Line definli2(float t,float t11,float t22,int co){
    Line raw1=new Line(310,1+t11*1,900,1+t22*1);
    co=(co)%3;
      if(co==0){
    
       raw1.setStroke(Color.BLACK);
    }
        if(co==1){
    
       raw1.setStroke(Color.RED);
    }
          if(co==2){
    
       raw1.setStroke(Color.BLUE);
    }
        raw1.setStrokeWidth(5);
    
    return raw1;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
      public float[] stringtofloat(int n, String input ){
    
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
            
             
            startOfNum = endOfNumber+1;
        }
       return arr;
    }
    
      
      public String[] stringArraytoString(int n, String input ){
    
       String []arr=new String[n];
     
       int startOfNum=0,endOfNumber=1;
       
       for (int i=0 ; i<n ; i++){

            for(int k=startOfNum ;  k<input.length() ; k++) {
                if(!(input.charAt(k)==' '))endOfNumber = k + 1;
                else break;
            }
             if(input.length()>0){
                 arr[i] = input.substring(startOfNum,endOfNumber);
             }
            
             
            startOfNum = endOfNumber+1;
        }
       return arr;
    }
    
     MMU mmu;
    int tmsize=0;
    String hsad="";
    String hssize="";
    int holenum=0;
    
    @Override
    public void start(Stage primaryStage) {
       
        Button start=new Button("Start The MMU");
        Text author=new Text("Designed By Mohamed mansi");
          author.setStyle("-fx-font: 28 arial;");
        
        author.setFill(Color.BLACK);
        Text name=new Text("Memory mangment Allocation ");
        name.setFill(Color.BLUEVIOLET);
        name.setStyle("-fx-font: 34 arial;");
          
        start.setOnAction(EventHandler->{



        Label l1=new Label("Select Scheduling Type From The List");
        Label l2 = new Label("");
        ObservableList<String> account=
                FXCollections.observableArrayList(
                     "Best_Fit","First_Fit" ,"Initialize memory"
                );
        ListView<String> ivw=new  ListView<String>(account);
        //دة جزء الخاص باخيار من الايست
        MultipleSelectionModel<String> imode=ivw.getSelectionModel();
         imode.selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int alog2=0;  
                String alog=newValue;
                l2.setText("The Selected Allocation Algorithm is: "+newValue);
                
                 
                 /////////////////////////////////////////////
                 
                    Image pic= new Image("sample/mi.jpg");
       ImageView ivpic=new ImageView(pic);
         ivpic.setFitHeight(500);
         ivpic.setFitWidth(500);
          Button btn = new Button();
        btn.setText("ENTER");
        Text  l1=new Text ("Total memory size");
        l1.setFill(Color.BLACK);
        Text  l2=new Text ("Holes starting address");
         l2.setFill(Color.BLACK);
         
        Text  l3=new Text ("hole size");
        l3.setFill(Color.BLACK);
         
         
           Text  l4=new Text ("Number of segments");
        l4.setFill(Color.BLACK);
         
        
        Text  l5=new Text ("Size of segments");
         l5.setFill(Color.BLACK);
          Text  l6=new Text ("Process number");
        l6.setFill(Color.BLACK);
        Text  l7=new Text ("Number of holes");
        l7.setFill(Color.GREEN);
           Text  l8=new Text ("Name of segments");
        l8.setFill(Color.GREEN);

        TextField t1=new TextField();
        TextField t2=new TextField();
         TextField t3=new TextField();
        TextField t4=new TextField();
         TextField t5=new TextField();
        TextField t6=new TextField();
          TextField t7=new TextField("");
           TextField t8=new TextField("");
        GridPane grid=new  GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new javafx.geometry.Insets(25,25,25,25));
     //   grid.setGridLinesVisible(true);
            
    
       
            
        btn.setOnAction((ActionEvent EventHandler)->{
       
         
              int dflag=0;
             int pnu=0;   
            int  nuofseg=0;
            String nam_segmmention="";
            String sizeofseg="";
          // String  premtive_nonpervtive="false";
            // "fcfs","Roundroben","sjf","pirority"  
         
            
            
        if(alog.equals("Initialize memory")){
           hssize= t3.getText().toString();
           
              hsad=t2.getText().toString();
           
          tmsize=Integer.parseInt(t1.getText().toString());
          holenum=Integer.parseInt(t7.getText().toString());
        }
        if(alog.equals("Best_Fit")||alog.equals("First_Fit")){
                  nuofseg=Integer.parseInt(t4.getText().toString());
        
            pnu=Integer.parseInt(t6.getText().toString());
             
         
          
          sizeofseg=t5.getText().toString();  
          nam_segmmention=t8.getText().toString();  
        }
    ///////////////////////////////////////////////

            List<SegmentOrHole> holes = new ArrayList<>();
            if(alog.equals("Initialize memory")){
                float []holesStartingAddress = stringtofloat(holenum, hsad);
                float []holesSize = stringtofloat(holenum, hssize);

                for(int i=0 ; i<holenum ; i++){
                    holes.add(new SegmentOrHole(holesStartingAddress[i], holesSize[i]));
                }
                mmu = new MMU(tmsize, alog, holes);
            }


    
    
    
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
       // extraprocess=Integer.parseInt(t7.getText().toString());
        /////////////////////////////////////////////
           System.out.println("tmsize:"+tmsize);
          System.out.println("hsad:"+hsad);
            System.out.println("hsad:"+pnu);
              System.out.println("nuofseg:"+nuofseg);
                System.out.println("sizeofseg:"+sizeofseg);
                  
                        System.out.println("nam_segmention:"+nam_segmmention);
        
        
        
         /*
                   int tmsize=0;
            String hsad="";
             int pnu=0;   
            String nuofseg="";
            String sizeofseg=""; 
                   */
         
       // stutus
       // t7.setText("G_Chart:donefor "+alog);
       ////////////////////////////////////////////////////////////////// 
         
       
        int flag_=0;
        
    String []p_Of_seg=new String[100];     
    float [] t11 = new float[100];//seg 1 start
    float[] t22 = new float[100];//seg 2 end
     Map< String,Float> t_1 =  
                        new HashMap< String,Float>();
      Map< String,Float> t_2 =  
                        new HashMap< String,Float>();
      
     
      
    int cont=0;
       
       /*
     String []p_Of_seg=new String[100];     
    float [] t11 = new float[100];//seg 1 start
    float[] t22 =
    
    */
       int num_p=3;
        float  cc3=0;
        int flagt1=0;
        int flagt2=0;
         int flagt1_10=0;
        int flagt2_10=0;
    
        //////////////////////////////////////////////////
        
        
       System.out.print("////////////////out" );

       
            System.out.println("hellooooooooooooooooooooooooo");
        float[] segmentSize = stringtofloat(nuofseg , sizeofseg);
        String[] segmentName = stringArraytoString(nuofseg, nam_segmmention);
        String handlingCheck="";
        for(int i = 0 ; i<nuofseg ; i++){
            System.out.println("segmentSize["+i+"] = "+segmentSize[i]);
            System.out.println("nam_Segmmention["+i+"] = "+segmentName[i]);
        }
        mmu.setAllocationMethodology(alog);
        for(int i=0 ; i<nuofseg ; i++){
            handlingCheck = mmu.handling(new SegmentOrHole(pnu, segmentName[i] , segmentSize[i]));
            if(handlingCheck!="done") {
                mmu.deallocate(pnu);
                break;
            }
        }
         
        int iteratorMemory=0;
        for(SegmentOrHole s:mmu.getSegmentOrHoles()){
            if(s.getType().equals("hole")){
                t11[iteratorMemory]= s.getHoleStartingAddress();
                t22[iteratorMemory]= s.getEndAddress();
                p_Of_seg[iteratorMemory]= s.getType();
               
                System.out.println( t11[iteratorMemory]+":" +t22[iteratorMemory]+":"+p_Of_seg[iteratorMemory]);
            }else{
                t11[iteratorMemory]= s.getSegmentStartingAddress();
                t22[iteratorMemory]= s.getEndAddress();
                p_Of_seg[iteratorMemory]= "Process_"+s.getProcessNumber()+", Segment: "+s.getSegmentsName();
                System.out.println( t11[iteratorMemory]+":" +t22[iteratorMemory]+":"+p_Of_seg[iteratorMemory]);
            }
           iteratorMemory++;
        }

            System.out.println(mmu.toString());
        
        
        
        ///////////////////////////////////////////////
        
        float scale=0;
        Text au=new Text(1000,1,"desgindBYmohmedMansi");
        au.setFill(Color.BROWN);
        Text tm=new Text(8950,4990,"Time");
        tm.setFill(Color.DARKBLUE );
         Line raw=new Line(905,0,905,tmsize);
         Line colum=new Line(300,0,300,tmsize);
         Line down=new Line(300,tmsize,905,tmsize);
           Text intsize=new Text(200,0,"0.0");
            Text finsize=new Text(200,tmsize,"");
            Text  dellocp=new Text(1000,100,"Enter Process number you want deallocate:");
            Button  dellocp5=new  Button ("Deallocate ");
            TextField dellocp3=new  TextField("");
              Text  segtiontable=new Text(1000,300,"Enter process number to show Segmentation Table:");
               Text ceckall=new Text(1000,50,handlingCheck);
              TextField segtiontable2 =new  TextField("");
               
    segtiontable2.setStyle("-fx-font: 24 arial;");          
                Button  dellocp2=new  Button ("Show Segmentation Table");
                Button  end=new  Button ("End");

                end.setLayoutX(1000);
                end.setLayoutY(550);
                dellocp5.setLayoutX(1000);
                  dellocp5.setLayoutY(200);
                dellocp3.setLayoutX(1000);
                 dellocp3.setLayoutY(150);
                 segtiontable2 .setLayoutX(1000);
                  segtiontable2 .setLayoutY(350);
              dellocp2.setLayoutX(1000);
                dellocp2.setLayoutY(450);
          down.setStroke(Color.BLACK);
        down.setStrokeWidth(5);
         
         
          raw.setStroke(Color.BLACK);
        raw.setStrokeWidth(5);
        
          colum.setStroke(Color.BLACK);
        colum.setStrokeWidth(5);
         Group root=new Group();
            
             int xx=0;
             for(int i=1;i<mmu.getSegmentOrHoles().size()+1;i++){
                 //cc3=cc3-20;
                  String str1 = Integer.toString(i);
                   String ss2="Segmention:"+str1;
             
             
               /// Text g=new Text(100,5090,defin2(cc3,ss2,t_1,t_2)+"");
             
              xx=i-1;
               float t111=0;
                float t222=0;     
              if(flag_==0){
                   t_1.put(ss2, new Float(t11[xx])); 
       t_2.put(ss2, new Float(t22[xx]-t11[xx])); 
                t111=t11[xx]/1;
                t222=t22[xx]/1;
                flag_=1;
               scale=0.01f;
                 
                if( t11[xx]<1000&&t11[xx]>=100 ){
               t111=t11[xx]/1;
               flagt1=1;
               scale=100;
             }
                if(t11[xx]<100){
                t111=t11[xx];
                 flagt1_10=1;
                 
                }
                 if(t22[xx]<100){
                t222=t22[xx];
                 flagt2_10=1;
                }
             if(t22[xx]<1000&&t22[xx]>=100){  t222=t22[xx]/1;
             flagt2=1;
             scale=100;
             } 
              }
              else if(flag_==1){
                  t_1.put(ss2, new Float(t11[xx])); 
       t_2.put(ss2, new Float(t22[xx]-t11[xx])); 
               t111=t11[xx];
               t222=t22[xx]/1;
               scale=0.01f;
                if( t11[xx]<1000&&t11[xx]>=100){
              t111=t11[xx]/1;
              flagt1=1;
              scale=100;
             }
                
             if(t22[xx]<1000&&t22[xx]>=100){t222=t22[xx]/1;
             flagt2=1;
             scale=100;
             
             } 
                if(t11[xx]<100){
                t111=t11[xx];
                 flagt1_10=1;
                }
                if(t22[xx]<100){
                t222=t22[xx];
                 flagt2_10=1;
                }
              }
              
            
              
              cc3=(t111+ t222)/2;
             
               String tt1="";
               String tt2="";
                  if(flagt1==0||flagt1_10==0){
                  tt1=t111*1+"";
                  }
                  if(flagt1==1){
                        tt1=t111*1+"";
                  }
                   if(flagt2==0||flagt2_10==0){
                   tt2=t222*1+"";
                  }
                  if(flagt2==1){
                     tt2=t222*1+"";
                  }
                     
                  if(flagt1_10==1){
                        tt1=t111+"";
                  }
                   if(flagt2_10==1){
                     tt2=t222+"";
                  }
                 
                             
                  root.getChildren().add(definscale(t111,tt1,xx,scale));
                   root.getChildren().add(definscale(t222,tt2,xx,scale));
                  if(p_Of_seg[xx].equals("hole")){
                    root.getChildren().add(defin(cc3,"hole",t_1,t_2,scale));
                   }
                  else if(p_Of_seg[xx].charAt(8)=='-'){
                 root.getChildren().add(defin(cc3,"Process Reserved\nTo deallocate enter: ("+p_Of_seg[xx].substring(8,10)+")",t_1,t_2,scale));
                   }
                  else{
                  root.getChildren().add(defin(cc3,p_Of_seg[xx],t_1,t_2,scale));
                  }
               root.getChildren().add(definli(cc3,t111,t111,xx,scale));
                root.getChildren().add(definli(cc3,t222,t222,xx,scale));
                   System.out.println(100+t111*100);  
                   System.out.println(100+cc3*100);
                     System.out.println(100+t222*100);         
               System.out.println(t11[xx]);
               System.out.println(t22[xx]);
             
             
             flagt1=0;
             flagt2=0;
              flagt1_10=0;
             flagt2_10=0;
             }
             
             
             
        root.getChildren().addAll(raw,colum,au,down,intsize,finsize,dellocp,segtiontable,dellocp2,dellocp3,segtiontable2,dellocp5,end,ceckall);
         ScrollPane scrollPane = new ScrollPane();
         scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(root);
        int i=0;
                 
       
         
        
        Scene scene = new Scene( scrollPane,1200, 400,Color.BLACK);
        au.setOnMouseMoved(e->{
      //  Colour color=new   Colour(); 
        au.setFill(Color.color(Math.random(),Math.random(),Math.random()));
         au.setFont(Font.font(20));
        
        });
       
        
       primaryStage.setTitle("    Process Allocated                physicalMemory");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        ///////////////////////////////////////////////////////////////////
        //seg table
        
                       dellocp2.setOnAction(EventHandler4->{
                       
                       
                        int flag_6=0;
    String delp6=segtiontable2.getText().toString();
    String []p_Of_seg46=new String[100];
    float [] t146 = new float[100];
    float[] t246 = new float[100];
   
   
    int cont6=0;
    int num_p6=3;
        float  cc36=0;

        int iteratorMemory46=0;
        int counter = 0;
        for(SegmentOrHole s:mmu.getSegmentOrHoles()){
            if(!s.getType().equals("hole") && Integer.parseInt(delp6)==s.getProcessNumber()){
                t146[iteratorMemory46]= s.getSegmentStartingAddress();
                t246[iteratorMemory46]= s.getEndAddress();
                p_Of_seg46[iteratorMemory46]= s.getSegmentsName();
                counter++;
                System.out.println( t146[iteratorMemory46]+":" +t246[iteratorMemory46]+":"+p_Of_seg46[iteratorMemory46]);
            }else
                continue;
            iteratorMemory46++;
        }


                           Text au6=new Text(300,1050,"desgindBYmohmedrMansi");
        au6.setFill(Color.BROWN);
    
         Line raw6=new Line(400,0,400,1000);
         Line colum6=new Line(0,0,800,0);
         Line colum26=new Line(0,50,800,50);
         Line down6=new Line(0,1000,800,1000);
           Line down36=new Line(800,0,800,1000);
           Text base6=new Text(200,30,"Base Address");
           Text size6=new Text(600,30,"Limit Size");
           base6.setStyle("-fx-font: 24 arial;");
           size6.setStyle("-fx-font: 24 arial;");
           
          down6.setStroke(Color.BLACK);
        down6.setStrokeWidth(5);
             
          down36.setStroke(Color.BLACK);
        down36.setStrokeWidth(5);
         
             colum26.setStroke(Color.BLACK);
       colum26.setStrokeWidth(5);
          raw6.setStroke(Color.BLACK);
        raw6.setStrokeWidth(5);
        
          colum6.setStroke(Color.BLACK);
        colum6.setStrokeWidth(5);
         Group root6=new Group();
            
             int xx6=0;
             for(int i6=1;i6<counter+1;i6++){
                 
                  
             
             
               
             
              xx6=i6-1;
              
               float t1116=0;
                float t2226=0;     
              if(flag_6==0){
                   
                t1116=t146[xx6];
                t2226=t246[xx6];
                flag_6=1;
               
                 
               
             
              }
              else if(flag_6==1){
                  
               t1116=t146[xx6];
               t2226=t246[xx6];
               
               
                
             
               
               
              }
              
            
              
              cc36=(t1116+ t2226)/2;
              float  size3=-t1116+ t2226;
                 System.out.println("size3"+size3);
              
               String tt16="";
               String tt26="";
                 
                 
                  
                        tt16=t1116+"";
                 
                  
                   tt26=size3+"";
                  
                  
                   
                  /*if(delp6.equals(p_Of_seg46[xx6])){
                  root6.getChildren().add(definscale6(xx6,tt16,xx6));
                   root6.getChildren().add(definscale32(xx6,tt26,xx6));
                  }*/
                 root6.getChildren().add(definscale6(xx6,tt16,xx6));
                 root6.getChildren().add(definscale32(xx6,tt26,xx6));
                     root6.getChildren().add(definscale66(xx6,p_Of_seg46[xx6]+"::",xx6));
             
           
             }
             
             
             
        root6.getChildren().addAll(raw6,colum6,au6,down6,colum26,base6,size6, down36);
         ScrollPane scrollPane6= new ScrollPane();
         scrollPane6.setFitToHeight(true);
        scrollPane6.setFitToWidth(true);
        scrollPane6.setContent(root6);
        
       
         
        
        Scene scene6 = new Scene( scrollPane6, 800, 400,Color.BLACK);
        au6.setOnMouseMoved(e->{
      
        au6.setFill(Color.color(Math.random(),Math.random(),Math.random()));
         au6.setFont(Font.font(20));
        
        });
        Stage primaryStage444 =new Stage();
       primaryStage444.setTitle("                                                                             sebmntion table of proess:"+delp6);
        primaryStage444.setScene(scene6);
        primaryStage444.show();
    
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       });

        
        
        
        //////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////
        //dellcote 
        dellocp5.setOnAction(EventHandler3->{
           int flag5_5=0;
    String delp=dellocp3.getText().toString();
    String []p_Of_seg4=new String[100];
    float [] t14 = new float[100];
    float[] t24 = new float[100];
     Map< String,Float> t_145 =  
                        new HashMap< String,Float>();
      Map< String,Float> t_245 =  
                        new HashMap< String,Float>();


      int cont5=0;
            
    
    int num_p5=3;
        float  cc35=0;
        int flagt15=0;
        int flagt25=0;
         int flagt15_10=0;
        int flagt2_105=0;
        String deallocationCheck="";
            if(isNumeric(delp))
                deallocationCheck = mmu.deallocate(Integer.parseInt(delp));
            else
                deallocationCheck = mmu.deallocate(delp);
            System.out.println(mmu.toString());
            int iteratorMemory4=0;
            for(SegmentOrHole s:mmu.getSegmentOrHoles()) {
                if (s.getType().equals("hole")) {
                    t14[iteratorMemory4] = s.getHoleStartingAddress();
                    t24[iteratorMemory4] = s.getEndAddress();
                    p_Of_seg4[iteratorMemory4] = s.getType();

                    System.out.println(t14[iteratorMemory4] + ":" + t24[iteratorMemory4] + ":" + p_Of_seg4[iteratorMemory4]);
                } else {
                    t14[iteratorMemory4] = s.getSegmentStartingAddress();
                    t24[iteratorMemory4] = s.getEndAddress();
                    p_Of_seg4[iteratorMemory4] = "Process_" + s.getProcessNumber() + ", Segment: " + s.getSegmentsName();
                    System.out.println(t14[iteratorMemory4] + ":" + t24[iteratorMemory4] + ":" + p_Of_seg4[iteratorMemory4]);
                }
                iteratorMemory4++;
            }

                int temp = tmsize;
                Text au5 = new Text(1000, 1, "desgindBYmohmedrMansi");
                au.setFill(Color.BROWN);
                Text tm5 = new Text(8950, 4990, "Time");
                tm.setFill(Color.DARKBLUE);
                Line raw5 = new Line(905, 0, 905, temp);
                Line colum5 = new Line(300, 0, 300, temp);
                Line down5 = new Line(300, temp, 905, temp);
                  Text check=new Text(1000, 277, deallocationCheck);
                     segtiontable2.setStyle("-fx-font: 24 arial;");  
                     
                Text finsize5 = new Text(200, temp, "");
                down5.setStroke(Color.BLACK);
                down5.setStrokeWidth(5);

                raw5.setStroke(Color.BLACK);
                raw5.setStrokeWidth(5);

                colum5.setStroke(Color.BLACK);
                colum5.setStrokeWidth(5);
                Group root5 = new Group();

                int xx5 = 0;
                for (int i5 = 1; i5 < mmu.getSegmentOrHoles().size() + 1; i5++) {
                    //cc3=cc3-20;
                    String str15 = Integer.toString(i);
                    String ss25 = "Segmention:" + str15;


                    /// Text g=new Text(100,5090,defin2(cc3,ss2,t_1,t_2)+"");

                    xx5 = i5 - 1;
                    String dellateprocess = "p1";
                    float t1115 = 0;
                    float t2225 = 0;
                    if (flag5_5 == 0) {
                        t_145.put(ss25, new Float(t14[xx5]));
                        t_245.put(ss25, new Float(t24[xx5] - t14[xx5]));
                        t1115 = t14[xx5];
                        t2225 = t24[xx5];
                        flag5_5 = 1;


                        if (t14[xx5] < 1000 && t14[xx5] >= 100) {
                            t1115 = t14[xx5];
                            flagt15 = 1;
                        }
                        if (t14[xx5] < 100) {
                            t1115 = t14[xx5];
                            flagt15_10 = 1;
                        }
                        if (t24[xx5] < 100) {
                            t2225 = t24[xx5];
                            flagt2_105 = 1;
                        }
                        if (t24[xx5] < 1000 && t24[xx5] >= 100) {
                            t2225 = t24[xx5];
                            flagt25 = 1;
                        }
                    } else if (flag5_5 == 1) {
                        t_145.put(ss25, new Float(t14[xx5]));
                        t_245.put(ss25, new Float(t24[xx5] - t14[xx5]));
                        t1115 = t14[xx5];
                        t2225 = t24[xx5];

                        if (t14[xx5] < 1000 && t14[xx5] >= 100) {
                            t1115 = t14[xx5];
                            flagt15 = 1;
                        }

                        if (t24[xx5] < 1000 && t24[xx5] >= 100) {
                            t2225 = t24[xx5];
                            flagt25 = 1;
                        }
                        if (t14[xx5] < 100) {
                            t1115 = t14[xx5];
                            flagt15_10 = 1;
                        }
                        if (t24[xx5] < 100) {
                            t2225 = t24[xx5];
                            flagt2_105 = 1;
                        }
                    }


                    cc35 = (t1115 + t2225) / 2;

                    String tt15 = "";
                    String tt25 = "";
                    if (flagt15 == 0 || flagt15_10 == 0) {
                        tt15 = t1115 * 100 + "";
                    }
                    if (flagt15 == 1) {
                        tt15 = t1115 + "";
                    }
                    if (flagt25 == 0 || flagt2_105 == 0) {
                        tt25 = t2225 + "";
                    }
                    if (flagt25 == 1) {
                        tt25 = t2225 + "";
                    }

                    if (flagt15_10 == 1) {
                        tt15 = t1115 + "";
                    }
                    if (flagt2_105 == 1) {
                        tt25 = t2225 + "";
                    }


                    root5.getChildren().add(definscale2(t1115, tt15, xx5));
                    root5.getChildren().add(definscale2(t2225, tt25, xx5));
                    if (p_Of_seg4[xx5].equals("hole")) {
                        root5.getChildren().add(defin2(cc35, "hole"));
                    } else if (p_Of_seg4[xx5].charAt(8) == '-') {
                        root5.getChildren().add(defin2(cc35, "Process Reserved\nTo deallocate enter: ("+p_Of_seg4[xx5].substring(8,10)+")"));
                    } else {
                        root5.getChildren().add(defin2(cc35, p_Of_seg4[xx5]));
                    }
                    root5.getChildren().add(definli2(cc35, t1115, t1115, xx5));
                    root5.getChildren().add(definli2(cc35, t2225, t2225, xx5));
                    System.out.println(100 + t1115 * 100);
                    System.out.println(100 + cc35 * 100);
                    System.out.println(100 + t2225 * 100);
                    System.out.println(t14[xx5]);
                    System.out.println(t24[xx5]);


                    flagt15 = 0;
                    flagt25 = 0;
                    flagt15_10 = 0;
                    flagt2_105 = 0;
                }


                root5.getChildren().addAll(raw5, colum5, down5, finsize5, dellocp, segtiontable, dellocp2, dellocp3, segtiontable2, dellocp5, end, au,check,ceckall);
                ScrollPane scrollPane5 = new ScrollPane();
                scrollPane5.setFitToHeight(true);
                scrollPane5.setFitToWidth(true);
                scrollPane5.setContent(root5);
                int i5 = 0;


                Scene scene5 = new Scene(scrollPane5, 1200, 400, Color.BLACK);
                //   Stage primaryStage4444 =new Stage();
                primaryStage.setTitle("    Process              dellcated " + delp);
                primaryStage.setScene(scene5);
                // primaryStage.show();


            });
        //////////////////////////////////////////////////////////////////////////////////////////////////
        end.setOnAction(EventHandler2->{
            primaryStage.hide();
            
            
        });
      

        
       
  
       
       
       
       
       
       
       
       
       
       
       ////////////////////////////////////////////////////////////////////
      //////////////////////chart///////////////////////
      
  
       
       
       
       
       ////////////////////////////////////////////////////////////////////
      //////////////////////chart///////////////////////
      
   
       
       ////////////////////////////////////////////////////////////////////
      //////////////////////chart///////////////////////
  
    
   
    //////////////n//////////////////////
    
   
             
                   
                     
             
            
             
          
             
             
             
       
        
      
        
      
      
      
      
      
             
      
          
      
      
      
        
        ///////////////////////////////////
        
        
        
        
        
        
        
        
        
            
           
        
        
        });
        // "fcfs","Roundroben","sjf","pirority" 
    if(alog.equals("Initialize memory")){
        grid.add(l1,0,0);
        grid.add(t1,1,0);
            
        grid.add(l2,0,1);
        grid.add(t2,1,1);
           
        grid.add(l3,0,2);
         grid.add(t3,1,2);

        grid.add(l7,0,6);
        grid.add(t7,1,6);
       
    }
   if( alog.equals("Best_Fit")||alog.equals("First_Fit")){
        grid.add(l4,0,3);
         grid.add(t4,1,3);
        
       
        grid.add(l5,0,4);
         grid.add(t5,1,4);
        
       grid.add(l6,0,5);
        grid.add(t6,1,5);
       
       grid.add(l8,0,7);
         grid.add(t8,1,7);
    }

       
      
        grid.add(btn,2,8);
       
        
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
        
        
          Image pic= new Image("sample/mi.jpg");
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
