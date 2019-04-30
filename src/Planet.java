import java.awt.*;

public class Planet {
    private double x,y,vx,vy,mass;
    private int radius;
    private Color color;
    private double ax,ay=0;

    //private static final double G = 4 * Math.PI * Math.PI;
    private static final double G = 125;

    public Planet(double x, double y, double vx, double vy, double mass, int radius, Color color){
        this.x=x;
        this.y=y;
        this.vx=vx;
        this.vy=vy;
        this.mass=mass;
        this.radius=radius;
        this.color=color;
    }

    private double distanceTo(Planet p){
        return Math.sqrt((this.x-p.getX())*(this.x-p.getX())+
                (this.y-p.getY())*(this.y-p.getY()));
    }

    public double axCalc(Planet p) {
        return G*p.getMass()/(distanceTo(p)*distanceTo(p))*(p.getX()-this.x)/distanceTo(p);
    }

    public double ayCalc(Planet p) {
        return G*p.getMass()/(distanceTo(p)*distanceTo(p))*(p.getY()-this.y)/distanceTo(p);
    }

    public void updVel(double ax, double ay, double dt){
        this.vx+=1.0/2*ax*dt;
        this.vy+=1.0/2*ay*dt;
    }

    public void updPos(double dt){
        this.x+=this.vx*dt+1.0/2*this.ax*dt*dt;
        this.y+=this.vy*dt+1.0/2*this.ay*dt*dt;
    }


    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getMass(){
        return this.mass;
    }

    public int getRadius() {
        return this.radius;
    }

    public Color getColor() {
        return this.color;
    }

    public double getAx() {
        return this.ax;
    }

    public double getAy() {
        return this.ay;
    }

    public void setAx(double ax){
        this.ax=ax;
    }

    public void setAy(double ay){
        this.ay=ay;
    }
}