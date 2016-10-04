import java.io.*;
import ecs100.*;

public class line{
    private double x = 0;
    private double y = 100;

    private double x2 = 200;
    private double y2 = 100;

    private double xOffset = 220;
    private double yOffset = 50;
        
    private PrintStream output;
    public line(){
        UI.initialise();
        UI.setDivider(0.5);
        UI.addButton("Generate Line (and save it)", this::calculate);
        try{
            output = new PrintStream(new File("FinalDrawingLine.txt"));
        }
        catch(FileNotFoundException e){
        }
    }

    public void calculate(){
        print(x, y, x2,y2);
    }

    public void print(double x, double y, double x2, double y2){
        UI.drawLine(x, y, x2, y2);
        UI.println("Line created");
        output.println((xOffset+x)+" "+(yOffset+y)+" 1");
        output.println((xOffset+x2)+" "+(yOffset+y2)+" 1");
    }
}
