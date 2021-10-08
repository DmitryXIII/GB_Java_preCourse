package xiii.geekbrains.java_pre_course.lesson_5;

class Animals {
    protected int distanceOfRun;
    protected int distanceOfSwim;
    protected double hight;
    protected String name;

    public void run(int distance) {
        if (distance > this.distanceOfRun) {
            System.out.println(this.name + ": run: " + distance + ": false");
        } else {
            System.out.println(this.name + ": run: " + distance + ": true");
        }
    }

    public void swim(int distance) {
        if (distance > this.distanceOfSwim) {
            System.out.println(this.name + ": swim: " + distance + ": false");
        } else {
            System.out.println(this.name + ": swim: " + distance + ": true");
        }
    }

    public void jump(int hight) {
        if (hight > this.hight) {
            System.out.println(this.name + ": jump: " + hight + ": false");
        } else {
            System.out.println(this.name + ": jump: " + hight + ": true");
        }
    }

    public void jump(double hight) {
        if (hight > this.hight) {
            System.out.println(this.name + ": jump: " + hight + ": false");
        } else {
            System.out.println(this.name + ": jump: " + hight + ": true");
        }
    }

    public int getDistanceOfRun() {
        return distanceOfRun;
    }

    public void setDistanceOfRun(int distanceOfRun) {
        this.distanceOfRun = distanceOfRun;
    }

    public int getDistanceOfSwim() {
        return distanceOfSwim;
    }

    public void setDistanceOfSwim(int distanceOfSwim) {
        this.distanceOfSwim = distanceOfSwim;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
