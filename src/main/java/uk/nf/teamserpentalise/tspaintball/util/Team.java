package uk.nf.teamserpentalise.tspaintball.util;

import net.minecraft.util.IStringSerializable;
import uk.nf.teamserpentalise.tspaintball.TSPaintball;


public enum Team implements IStringSerializable
{
    WHITE("Referee","white"),
    RED("Red Team","red"),
    GREEN("Green Team","green"),
    BLUE("Blue Team","blue");


    private String name;
    private String Color;

    Team(String name, String color)
    {
        this.name = name;
        Color = color;
    }
    public static Team getFromColor(String color)
    {
        TSPaintball.LOG.info(color);
        if(color.matches("red")){return Team.RED;}
        if(color.matches("green")){return Team.GREEN;}
        if(color.matches("blue")){return Team.BLUE;}
        if(color.matches("white")){return Team.WHITE;}
        return null;
    }
    @Override
    public String getSerializedName()
    {
        return this.name + ":" + this.Color;
    }
    public static String GetColor(Team T){
        return T.Color;
    }
    public static int GetIndex(Team team)
    {
        if(team == Team.WHITE){return 0;}
        if(team == Team.RED){return 1;}
        if(team == Team.GREEN){return 2;}
        if(team == Team.BLUE){return 3;}
        return 4;
    }
}
