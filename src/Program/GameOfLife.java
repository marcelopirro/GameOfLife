package Program;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class GameOfLife extends JFrame{
    
    private int size = 50; //number of rows and columns
    private boolean cellsMap[][]; //state of the cells (alive or dead)
    private JButton cells[][]; //labeled button, represent each cell


    public GameOfLife() {
        Random rnd = new Random(); //use for set the values of arrays

        cellsMap = new boolean[size][size]; //50 rows and 50 columns
        cells = new JButton[size][size];

        //JFrame GUI
        setSize(500, 500); //px
        setLayout(new GridLayout(size, size)); //define a grid
        setResizable(false); // set whether th Jframe is resizable by the user
        setLocationRelativeTo(null); // center the JFrame on the screen

        //randomeness decide whether the cell is alive or not
        for(int i=0; i<size; i++){
            for(int j=0; j<50; j++){
                cellsMap[i][j] = rnd.nextInt(100)<50; //if less than 50 then positition is going to be true
                JButton temp = new JButton();
                //set colors on the cells
                if(cellsMap[i][j]){
                    temp.setBackground(Color.GREEN);
                }
                else {
                    temp.setBackground(Color.WHITE);
                }
                add(temp);
                cells[i][j] = temp; //add the button on array
            }
        }

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //The EXIT_ON_CLOSE value is a constant in the JFrame class that indicates that the application should exit when the frame is closed.
        

        //game loop
        Timer timer = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){

                boolean[][] temp = new boolean[size][size];

                //count all of the neighbors of a cell
                for(int i=0; i<size; i++){
                    for(int j=0; j<50; j++){
                        int count = countNeighbours(i, j);

                        //Rules  
                        if(cellsMap[i][j]){ //if a cell is alive
                            //1: if a live cell is surrounded by less than two live neighbours, the cell is going to die
                            if(count<2){ //if count is less than 2
                                temp[i][j] = false;
                            }
                            //2: if a live cell is surrounded by teo or three live neighbours, lives on the next generation
                            if(count == 3 || count == 2){
                                temp[i][j] = true;
                            }
                            //3: if a cell is surrounded by more than three live neighbours, the cell is going to die
                            if(count>3){
                                temp[i][j] = false;
                            }
                        }else{ //if a cell is dead
                            //4: if a dead cell is surrounded by exacrly three live neighbors, the cell is going to live
                            if(count==3){
                                temp[i][j] = true;
                            }
                        }
                    }
                }

                cellsMap = temp;

                for(int i=0; i<size; i++){
                    for(int j=0; j<50; j++){
                        if(cellsMap[i][j]){
                            cells[i][j].setBackground(Color.GREEN);
                        }else{
                            cells[i][j].setBackground(Color.WHITE);
                        }
                    }
                }

            }
        });

        timer.start();
    }

    //countNeighbours method
    public int countNeighbours(int a, int b){
        int count = 0;

        for(int i=a-1; i<=a+1; i++){
            for(int j=b-1; j<=b+1; j++){
                try{
                    if(cellsMap[i][j]){
                        count++; //number of Neighbours alive
                    }
                }catch(Exception e){

                }

            }
        } 

        //we don't want to include in the count the cell which called this function
        if(cellsMap[a][b]){
            count--;
        }

        return count; 
    }
    
}
