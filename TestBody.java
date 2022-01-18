public class TestBody {
    public static void main(String[] args) {
        Body samh = new Body(1, 0, 0, 0, 10, "samh");
        Body Aegir = new Body(3, 3, 0, 0, 5, "Aegir");
        Body Rocinante = new Body(5, -3, 0, 0, 50, "Rocinante");
        Body[] allBodys = {samh, Aegir, Rocinante};
        Body wgs = new Body(0, 0, 3, 5, 1, "wgs");
        System.out.println(samh.calcDistance(Aegir));
        System.out.println(samh.calcForceExertedBy(Rocinante));
        System.out.println(samh.calcForceExertedByX(Rocinante));
        System.out.println(samh.calcNetForceExertedByX(allBodys));
        wgs.update(1, -5, -2);
        System.out.println(wgs.xxPos);
        System.out.println(wgs.yyPos);
        System.out.println(wgs.xxVel);
        System.out.println(wgs.yyVel);
        System.out.println(NBody.readRadius("./data/planets.txt"));
        System.out.println(NBody.readBodies("./data/planets.txt"));
    }
}
