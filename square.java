import java.io.*;
import ecs100.*;

public class square{
    private double x = 0;
    private double y = 0;
    private double x2;
    private double y2;
    
    private double width = 50; //we want 50 mm 

    private double xOffset = 320;
    private double yOffset = 150;
    
    private PrintStream output;
    public square(){
        UI.initialise();
        UI.setDivider(0.5);
        UI.addButton("Generate Circle (and save it)", this::calculate);
        try{
            output = new PrintStream(new File("FinalDrawingSquare.txt"));
        }
        catch(FileNotFoundException e){
        }
    }

    public void calculate(){
        //the 4 lines of a cirlce 
        print(x, y);
        print(x+width, y);
        print(x, y+width);
        print(x-width, y);
        print(x, y-width);
    }

    public void print(double x2, double y2){
        UI.drawLine(x+100, y+100, x2+100, y2+100);
        x = x2;
        y = y2;
        UI.println("x: "+(xOffset+x));
        UI.println("y: "+(yOffset+y));
        output.println((xOffset+x)+" "+(yOffset+y)+" 1");
    }
}
