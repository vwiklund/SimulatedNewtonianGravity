import java.awt.*;
import java.util.*;

public class PlanetsModel {
    private PlanetsView view;
    final private Planet PLANETONE = new Planet(0.9700436*5, -0.24308753*5, 0.466203685*5, 0.43236573*5, 1, 10, Color.YELLOW);
    final private Planet PLANETTWO = new Planet(-0.9700436*5, 0.24308753*5, 0.466203685*5, 0.43236573*5, 1, 4, Color.BLUE);
    final private Planet PLANETTHREE = new Planet(0, 0, -2*0.466203685*5, -2*0.43236573*5, 1, 6, Color.ORANGE);

    private ArrayList<Planet> planets=new ArrayList<>();

    public PlanetsModel(PlanetsView view) {
        this.view = view;
        planets.add(PLANETONE);
        planets.add(PLANETTWO);
        planets.add(PLANETTHREE);
    }

    public void update(double dt) {
        for(int i=0;i<2;i++) {
            for (Planet p : planets) {
                updateA();
                if(i==0) {
                    p.updPos(dt);
                }
                p.updVel(p.getAx(), p.getAy(), dt);
            }
        }

        view.clear();
        for(Planet p: planets)
            view.showPlanet(p);
        view.repaint();
    }

    private void updateA(){
        for (Planet p : planets) {
            double[] vect = {0, 0};
            for (Planet q : planets) {
                if (p == q) {
                    continue;
                } else {
                    vect[0] += p.axCalc(q);
                    vect[1] += p.ayCalc(q);
                }
            }
            p.setAx(vect[0]);
            p.setAy(vect[1]);
        }
    }
}