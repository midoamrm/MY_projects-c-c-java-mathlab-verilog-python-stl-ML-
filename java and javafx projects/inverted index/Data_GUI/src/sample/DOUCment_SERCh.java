/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author SOLUTIONS
 */
public class DOUCment_SERCh extends Application {

    MergeInFile mergeInFile;
    Trie t=new Trie();

    Text show(int i,String s){
        Text  l1=new Text (50,50+i*15,s);
        return  l1;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Button btn = new Button();
        btn.setText("Build Inverted Index");
        btn.setLayoutX(100);
        btn.setLayoutY(100);

        Label LoggingMessege = new Label("Building Inverted Index");
        LoggingMessege.setLayoutX(100);
        LoggingMessege.setLayoutY(150);

        ProgressBar progressBar = new ProgressBar();
        progressBar.setLayoutX(100);
        progressBar.setLayoutY(50);
        progressBar.setProgress(0);

        Image pic3= new Image("sample/nun.jpg");
        ImageView ivpic3=new ImageView(pic3);
        ivpic3.setFitHeight(500);
        ivpic3.setFitWidth(500);
        btn.setStyle("-fx-background-color: White");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                //my code:
                //--------

                Image pic= new Image("sample/nun.jpg");

                ImageView ivpic=new ImageView(pic);
                ivpic.setFitHeight(500);
                ivpic.setFitWidth(500);

                Image pic2= new Image("sample/se.jpg");
                ImageView ivpic2=new ImageView(pic2);
                ivpic2.setFitHeight(20);
                ivpic2.setFitWidth(40);

                GridPane grid=new  GridPane();

                StackPane root = new StackPane();
                root.getChildren().addAll(ivpic,grid);

                Scene scene2 = new Scene(root, 500, 300);
                Stage neww=new Stage();
                neww.setTitle("");
                neww.setScene(scene2);


                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            mergeInFile = new MergeInFile(100_002 , progressBar);
                            File file = new File("F:\\data\\wholeDocuments.txt");
                            BufferedReader reader = new BufferedReader(new FileReader(file));
                            for(int i=0 ; i<100_002; i++) {
                                String s = reader.readLine();
                                s=s.replaceAll("[^a-zA-Z0-9- ]", " ").toLowerCase();
                                s=s.replaceAll("-" , "");
                                List<String> al =  Arrays.asList(s.split(" "));
                                for (int k=0 ; k<al.size() ; k++){
                                    if(al.get(k).trim().equals(""))
                                        continue;
                                    t.insert(al.get(k),i);
                                }
                            }
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    primaryStage.close();
                                    neww.show();
                                }
                            });
                        } catch (Exception exc) {
                            //we don't care about this
                        }
                    }
                };

                new Thread(task).start();


                Button btn = new Button();
                btn.setStyle("-fx-background-color: White");
                btn.setMaxWidth(400);
                btn.setMaxHeight(400);
                btn.setGraphic(ivpic2);
                btn.setText("");
                Text  l1=new Text ("");
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

                TextField t1=new TextField("Search");
                TextField t2=new TextField();
                TextField t3=new TextField();
                TextField t4=new TextField();
                TextField t5=new TextField();
                TextField t6=new TextField();
                TextField t7=new TextField("Don't Put Input Here");
                //GridPane grid=new  GridPane();
                grid.setAlignment(Pos.CENTER);
                grid.setVgap(10);
                grid.setHgap(10);
                grid.setPadding(new javafx.geometry.Insets(25,25,25,25));

                btn.setOnAction(EventHandler->{

                    //my code

                    ArrayList<Integer> wordsId = new ArrayList<>();
                    if(t.search(t1.getText().replaceAll("[^a-zA-Z0-9 ]",""))){
                        wordsId = t.GET_id(t1.getText().replaceAll("[^a-zA-Z0-9 ]",""));
                    }else{
                        wordsId.add(-1);
                        System.out.println("Not Found");
                    }


                    /////////////////////////////////////////////////////////////////////////////////////////////////////


                    Text wordsearch1 =new Text (50,100,"wordsearch:");
                    Text  wordsid1=new Text (50,200,"words_id:");

                    wordsearch1  .setStyle("-fx-font: 28 arial;");
                    wordsid1 .setStyle("-fx-font: 28 arial;");

                    String wordsIdString;
                    if(wordsId.get(0)>=0)
                        wordsIdString = wordsId.toString();
                    else
                        wordsIdString = "Not Found";
                    Text wordsearch=new Text(210,100,t1.getText());
                    //Text wordsfreq=new Text(220,200,words.get(words.size()-1).getFreq()+"");
                    Text wordsid=new Text(180,200, wordsIdString);

                    wordsearch  .setStyle("-fx-font: 28 arial;");

                    wordsearch.setFill(Color.BLUEVIOLET);

                    wordsid  .setStyle("-fx-font: 28 arial;");

                    wordsid.setFill(Color.BLUEVIOLET);


                    Group root2=new Group();
                    Button btn2 = new Button("Show Documents");
                    btn2.setLayoutX(400);
                    btn2.setLayoutY(500);
                    root2.getChildren().addAll(wordsearch1,wordsid1,wordsearch , btn2, wordsid);
                    ScrollPane scrollPane = new ScrollPane();
                    scrollPane.setFitToHeight(true);
                    scrollPane.setFitToWidth(true);
                    scrollPane.setContent(root2);

                    Scene scene222 = new Scene(scrollPane, 500, 600,Color. AQUA);
                    Stage newww=new Stage();
                    newww.setTitle("Word searching data");
                    newww.setScene(scene222);

                    ArrayList<Integer> finalWordsId = wordsId;
                    btn2.setOnAction(EventHandler3->{

                        Group root3=new Group();
                        try {
                            int count=0;
                            File file = new File("F:\\data\\wholeDocuments.txt");
                            BufferedReader reader = new BufferedReader(new FileReader(file));
                            for (int i=0 ; i<mergeInFile.getNumberOfFiles() ; i++){
                                String s = reader.readLine();
                                if(i==finalWordsId.get(count)) {
                                    root3.getChildren().add(show(count,"Document num_"+i+": "+s));
                                    count++;
                                    if(count>= finalWordsId.size())
                                        break;
                                }
                            }
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                        ScrollPane scrollPane3 = new ScrollPane();
                        scrollPane3.setFitToHeight(true);
                        scrollPane3.setFitToWidth(true);
                        scrollPane3.setContent(root3);
                        Scene scene22 = new Scene(scrollPane3, 800, 600,Color.ANTIQUEWHITE);
                        Stage newwww=new Stage();
                        newwww.setTitle("doucment you secrched for");
                        newwww.setScene(scene22);
                        newwww.show();

                    });
                    newww.show();
                });
                grid.add(l1,0,0);
                grid.add(t1,4,4);
                grid.add(btn,5,4);
            }
        });

        Group root = new Group();
        root.getChildren().add(ivpic3);
        root.getChildren().add(progressBar);
        root.getChildren().add(LoggingMessege);
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("WELLcome page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
