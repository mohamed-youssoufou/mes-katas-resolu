package ci.dojo.TondeuseKata.core;

import com.sun.istack.internal.NotNull;

import java.util.UUID;

public class Tondeuse {
    private UUID id;
    private String name;
    private Coordonner coordonner;

    private Terrain terrain;

    private Object currentPosition;

    public Tondeuse(UUID id, String name, Coordonner coordonner, Terrain terrain) {
        this.id = id;
        this.name = name;
        this.coordonner = coordonner;
        this.terrain = terrain;
    }

    public Coordonner getCoordonner() {
        return coordonner;
    }

    //Gauche: WEST
    //Droite: EAST
    //Devant: NORTH
    //Derrière: SOUTH

    public void pilot(@NotNull String deplacement) {
        Object[] positions = deplacement.toUpperCase().split("");
        for (Object currentPosition: positions) {
            
            this.currentPosition = currentPosition;

            if(!not_go_out_workspace()){
                continue;
            }

            if(from_north_turned_left()){
                turned_west(); continue;
            }
            if(from_north_turned_right()){
                turned_east(); continue;
            }

            if(from_south_turned_left()){
                turned_east(); continue;
            }

            if(from_south_turned_right()){
                turned_west(); continue;
            }

            if(from_east_turned_left()){
                turned_north(); continue;
            }
            
            if(from_east_turned_right()){
                turned_south(); continue;
            }

            if(from_west_turned_left()){
                turned_south(); continue;
            }
            
            if(from_west_turned_right()){
                turned_north(); continue;
            }

            if(from_west_go_ahead()){
                go_turned_left(); continue;
            }

            if(from_south_go_ahead()){
                go_turned_bottom(); continue;
            }

            if(from_east_go_ahead()){
                go_turned_right(); continue;
            }

            if(from_north_go_ahead())
                go_turned_top();
        }
    }

    private boolean from_north_go_ahead() {
        return this.coordonner.getDirection().equals("N") && this.currentPosition.equals("A");
    }

    private boolean from_east_go_ahead() {
        return this.coordonner.getDirection().equals("E") && this.currentPosition.equals("A");
    }

    private boolean from_south_go_ahead() {
        return this.coordonner.getDirection().equals("S") && this.currentPosition.equals("A");
    }

    private boolean from_west_go_ahead() {
        return this.coordonner.getDirection().equals("W") && this.currentPosition.equals("A");
    }

    private boolean from_west_turned_right() {
        return this.coordonner.getDirection().equals("W") && this.currentPosition.equals("D");
    }

    private boolean from_west_turned_left() {
        return this.coordonner.getDirection().equals("W") && this.currentPosition.equals("G");
    }

    private boolean from_east_turned_right() {
        return this.coordonner.getDirection().equals("E") && this.currentPosition.equals("D");
    }

    private boolean from_east_turned_left() {
        return this.coordonner.getDirection().equals("E") && this.currentPosition.equals("G");
    }

    private boolean from_south_turned_right() {
        return this.coordonner.getDirection().equals("S") && this.currentPosition.equals("D");
    }

    private boolean from_north_turned_left() {
        return this.coordonner.getDirection().equals("N") && this.currentPosition.equals("G");
    }

    private boolean from_north_turned_right(){
        return this.coordonner.getDirection().equals("N") && this.currentPosition.equals("D");
    }

    private  boolean from_south_turned_left(){
        return this.coordonner.getDirection().equals("S") && this.currentPosition.equals("G");
    }

    private void turned_west(){
        this.coordonner.setDirection("W");
    }

    private void turned_south(){
        this.coordonner.setDirection("S");
    }

    private void turned_north(){
        this.coordonner.setDirection("N");
    }

    private void turned_east(){
        this.coordonner.setDirection("E");
    }

    private void go_turned_left(){
        this.coordonner.setX(this.coordonner.getX()-1);
    }

    private void go_turned_bottom(){
        this.coordonner.setY(this.coordonner.getY()-1);
    }
    private void go_turned_right() {
        this.coordonner.setX(this.coordonner.getX() + 1);
    }

    private void go_turned_top() {
        this.coordonner.setY(this.coordonner.getY()+1);
    }

    private boolean not_go_out_workspace(){
        if(this.coordonner.getDirection().equals("W") && this.coordonner.getX() == 0 && this.currentPosition.equals("A")){
            return false;
        }
        if(this.coordonner.getDirection().equals("E") && this.coordonner.getX() == 5 && this.currentPosition.equals("A")){
            return false;
        }
        if(this.coordonner.getDirection().equals("S") && this.coordonner.getY() == 0 && this.currentPosition.equals("A")){
            return false;
        }
        if(this.coordonner.getDirection().equals("N") && this.coordonner.getY() == 5 && this.currentPosition.equals("A")){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return coordonner.getX()+ " | "+ coordonner.getY() + " | "+ coordonner.getDirection();
    }

}
