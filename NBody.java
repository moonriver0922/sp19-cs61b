import java.util.Scanner;
public class NBody {

    public static double readRadius(String a){
        In in = new In(a);
        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }
    public  static Body[] readBodies(String s){
        In in = new In(s);
        int N = in.readInt();
        double R = in.readDouble();
        Body[] ret = new Body[N];
        for(int i = 0; i < N; i++){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double vX = in.readDouble();
            double vY = in.readDouble();
            double m = in.readDouble();
            String ss = in.readString();
            ret[i] = new Body(xP, yP, vX, vY, m, s);
        }
        return ret;
    }

    public static void main(String[] args) {
        double t = 0;
        Scanner s = new Scanner(System.in);
        double T = s.nextDouble();
        double dt = s.nextDouble();
        String filename = s.next();
        NBody.readRadius(filename);
        NBody.readBodies(filename);
        double[] NetForceX = new double[5];
        double[] NetForceY = new double[5];
        String[] imgFileName1 = {"./image/earth.gif", "./image/mars.gif", "./image/mercury.gif", "./image/sun.gif", "./image/venus.gif"};
        Body[] bodies = NBody.readBodies(filename);//这一步比较关键，最后才想到，之前都是用了ret
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-NBody.readRadius(filename), NBody.readRadius(filename));
        while(t<T){
            StdDraw.clear();
            StdDraw.picture(-NBody.readRadius(filename), NBody.readRadius(filename), "./image/starfield.jpg");
            StdDraw.picture(NBody.readRadius(filename), -NBody.readRadius(filename), "./image/starfield.jpg");
            StdDraw.picture(NBody.readRadius(filename), NBody.readRadius(filename), "./image/starfield.jpg");
            StdDraw.picture(-NBody.readRadius(filename), -NBody.readRadius(filename), "./image/starfield.jpg");
            for(int i = 0; i < 5; i++){
                StdDraw.picture(bodies[i].xxPos, bodies[i].yyPos, imgFileName1[i]);}
                for(int i = 0; i < 5; i++){
                    NetForceX[i] = bodies[i].calcNetForceExertedByX(bodies);
                    NetForceY[i] = bodies[i].calcNetForceExertedByY(bodies);
                }
                for(int j = 0; j < 5; j++){
                    bodies[j].update(dt, NetForceX[j], NetForceY[j]);
                }
                StdDraw.show();
                StdDraw.pause(10);
                t += dt;
        }


    }


}
