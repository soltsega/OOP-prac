package JavaLab; 
import java.util.Scanner;
public class QuadrantFinder{
 
    public static void main(String[] args) {
        double angle;
        System.out.println("Enter the angle to determine the quadrant of: ");
        Scanner scanner = new Scanner(System.in);
        angle = scanner.nextDouble();
        scanner.nextLine();
        double r = angle%360; 
        if(r==0 || r==90 || r==180 || r==270 || r==-90 || r==-180 || r==-270){
            System.out.println("The angle lands on axes");
        }else if((r>0 && r<90)||(r>-360 && r<-270)){
            System.out.println("Quadrant 1");
        } 
        else if((r>90 && r<180)||(r>-270 && r<-180)){
            System.out.println("Quadrant 2");
        }
        else if((r>180 && r<270)||(r>-180 && r<-90)){
            System.out.println("Quadrant 3");
        }
        else{
            System.out.println("Quadrant 4");
        }
        scanner.close();
    }

    }

