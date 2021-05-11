import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class Main {

    static int[][] grille;
    static int grilleX;
    static int grilleY;

    static FileReader fr ;
    static BufferedReader br;

    static List<String> listPos ;
    static List<String> listMovement ;

    static int xPos;
    static int yPos;

    static int nbLigne = 0;
    public static void main(String[] args) throws Exception
    {
        if (args.length != 1)
        {
            throw new Exception("More Arguments");
        }

        fr = new FileReader(args[0]);
        br = new BufferedReader(fr);
        String str;
        listPos = new ArrayList<>();
        listMovement = new ArrayList<>();
        String[] taille = new String[2];


        while((str=br.readLine()) != null)
        {
            if(nbLigne == 0){
                taille = str.split(" ");
            } else if(nbLigne % 2 == 1){
                listPos.add(str);
            } else if(nbLigne % 2 == 0){
                listMovement.add(str);
            }
            nbLigne++;
        }
        fr.close();

        if (isNumerique(taille[0]) && isNumerique(taille[1]) ) {
            grilleX = Integer.parseInt(taille[0]);
            grilleY = Integer.parseInt(taille[1]);
        }
        else {
            throw new Exception("Grille is invalid.");
        }

        grille = new int[grilleX][grilleY];

        if(listPos.size() == listMovement.size())
        {
            for (int i = 0; i < listPos.size(); i++)
            {
                String[] pos = listPos.get(i).split(" ");

                if (isNumerique(pos[0]) && isNumerique(pos[1]) && Integer.parseInt(pos[0]) <= grilleX && Integer.parseInt(pos[1]) <= grilleY) {
                    xPos = Integer.parseInt(pos[0]);
                    yPos = Integer.parseInt(pos[1]);
                }else {
                    throw new Exception("Coordonnee is unknown.");
                }

                String dir = null;
                if ((pos[2]).equals("N") || (pos[2]).equals("S") || (pos[2]).equals("E") || (pos[2]).equals("W")){
                    dir = pos[2];
                }
                else {
                    dir = pos[2];
                    throw new Exception("Orientation " + dir + " is unknown.");
                }

                Coordonee mycoordonee = new Coordonee(xPos,yPos,dir);
                Rover myRobot = new Rover(mycoordonee);
                System.out.println("Rover : " + i );
                myRobot.receiveCommand(listMovement,i,grilleX,grilleY);
                System.out.println(myRobot.getCoordinates().toString());
            }
        }
    }

    private static boolean isNumerique(String num){
        boolean isnum ;
        isnum = num.chars().allMatch( Character::isDigit );
        return isnum ;
    }

}