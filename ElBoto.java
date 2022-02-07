package brain;

import java.util.ArrayList;

import actor.BotBrain;
import actor.GameObject;
import actor.Rock;
import grid.Location;

public class ElBoto extends BotBrain {
    Location myLoc = new Location(getRow(), getCol());
    @Override
    public int chooseAction() {
        updateMyLoc();
        return 0;
    }
    /**
     * will be repeatedly called to update my location
     */
    public void updateMyLoc(){
        myLoc = new Location(getRow(), getCol());
    }

    public int getToRock(Location rockLoc){
        GameObject[][] arena = getArena();
        int dirToRock = myLoc.getDirectionToward(rockLoc);
        
        return 0;
    }
    /**
     * 
     * Gets an arraylist of all the rocks
     * then goes through and checks which rock has the closest straight line distance
     * and stores it as closest loc
     * 
     * 
     * @return the location of the closest rock
     */
    public Location getClosestRock(){
        GameObject[][] arena = getArena();
        Location closestRoc = new Location(0,0);;
        double closestDistance = 1000;
        double nowDistance = 0;
        ArrayList<Location> rockLocs = new ArrayList<Location>();
        for(int i =0; i<arena.length; i++){
            for(int j = 0; j<arena[0].length;j++){
                if(arena[i][j] instanceof Rock){
                   rockLocs.add(new Location(i,j));
                }
            }
    
        }
        for(Location rockLoc : rockLocs){
            nowDistance = Math.sqrt(((rockLoc.getRow()-getRow())*(rockLoc.getRow()-getRow()))+((rockLoc.getCol()-getCol())*(rockLoc.getCol()-getCol())));
            if(nowDistance<closestDistance){
                closestDistance = nowDistance;
                closestRoc = rockLoc;
            }
        }
        return closestRoc;
    }

    
    
}
