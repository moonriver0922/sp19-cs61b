    import java.lang.Math;

    public class Body {
        double xxPos;
        double yyPos;
        double xxVel;
        double yyVel;
        double mass;
        String imgFileName;
        static double G = 6.67e-11;
        public Body(double xp, double yp, double xv, double yv, double m, String img){
            xxPos = xp;
            yyPos = yp;
            xxVel = xv;
            yyVel = yv;
            mass = m;
            imgFileName = img;
        }
        public Body(Body b){

        }
        public double calcDistance(Body a){
            return Math.sqrt(Math.pow((this.xxPos - a.xxPos),2) + Math.pow((this.yyPos - a.yyPos),2));
        }
        public double calcForceExertedBy(Body a){
            return G*this.mass*a.mass/Math.pow(calcDistance(a),2);
        }
        public double calcForceExertedByX(Body a){
            return this.calcForceExertedBy(a)*(a.xxPos-this.xxPos)/this.calcDistance(a);
        }
        public double calcForceExertedByY(Body a){
            return this.calcForceExertedBy(a)*(a.yyPos-this.yyPos)/this.calcDistance(a);
        }
        public double calcNetForceExertedByX(Body[] allBodys){
            double NetX = 0;
            for(int i = 0; i < allBodys.length; i++){
                if(this.equals(allBodys[i]))
                    ;
                else NetX += this.calcForceExertedByX(allBodys[i]);
            }
            return NetX;
        }
        public double calcNetForceExertedByY(Body[] allBodys){
            double NetY = 0;
            for(int i = 0; i < allBodys.length; i++){
                if(this.equals(allBodys[i]))
                    ;
                else NetY += this.calcForceExertedByY(allBodys[i]);
            }
            return NetY;
        }
        public void update(double dt, double fx, double fy){
            double ax = fx/mass;
            double ay = fy/mass;
            xxVel += ax*dt;
            yyVel += ay*dt;
            xxPos += xxVel*dt;
            yyPos += yyVel*dt;
        }


    }


