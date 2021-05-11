


public class Coordonee {

    static int x;
    static int y;
    static String orientation;


    public Coordonee(int valueX, int valueY, String orientation)
    {
        setX(valueX);
        setY(valueY);
        setOrientation(orientation);

    }

    public void setX(int valueX)
    {
        x = valueX;
    }

    public void setY(int valueY)
    {
        y = valueY;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setOrientation(String orientation)
    {
        this.orientation = orientation;
    }

    public String getOrientation()
    {
        return orientation;
    }

    public void changeDirection(String input){
        if(orientation.equals("N") && input.equals("L")){
            orientation = "W";
        } else if(orientation.equals("N") && input.equals("R")){
            orientation = "E";
        }else if(orientation.equals("W") && input.equals("L")){
            orientation = "S";
        }else if(orientation.equals("W") && input.equals("R")){
            orientation = "N";
        }else if(orientation.equals("S") && input.equals("L")){
            orientation = "E";
        }else if(orientation.equals("S") && input.equals("R")){
            orientation = "W";
        }else if(orientation.equals("E") && input.equals("L")){
            orientation = "N";
        }else if(orientation.equals("E") && input.equals("R")){
            orientation = "S";
        }
    }

    public void move(){
        if(orientation.equals("N")){
            y++;
        }else if(orientation.equals("W")){
            x--;
        }else if(orientation.equals("S")){
            y--;
        }else if(orientation.equals("E")){
            x++;
        }
    }


    @Override
    public String toString() {
        return getX() + " " + getY() + " " + getOrientation() ;
    }

}
