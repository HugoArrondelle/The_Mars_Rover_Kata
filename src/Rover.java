import java.util.List;

public class Rover {

    private Coordonee coordonee;

    public Rover(Coordonee coordinatesValue)
    {
        setCoordinates(coordinatesValue);
    }

    public void setCoordinates(Coordonee value)
    {
        coordonee = value;
    }

    public Coordonee getCoordinates()
    {
        return coordonee;
    }

    public void receiveCommand (List<String> listMovement , int i , int Xgrill , int Ygrill) throws Exception
    {
        for(char c : listMovement.get(i).toCharArray())
        {
            switch(c)
            {
                case 'L':
                    getCoordinates().changeDirection("L");
                    break;
                case 'R':
                    getCoordinates().changeDirection("R");
                    break;
                case 'M':
                    getCoordinates().move();
                    if(getCoordinates().getX() > Xgrill  || getCoordinates().getY() > Ygrill || getCoordinates().getX() < 0 || getCoordinates().getY() < 0){
                        throw new Exception("Rover is not in the grille");
                    }
                    break;
                default:
                    throw new Exception("Command " + c + " is unknown.");
            }
        }
    }
}