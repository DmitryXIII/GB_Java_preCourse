package xiii.geekbrains.java_pre_course.lesson_4;

class Animals {
    int distanceOfRun;
    int distanceOfSwim;
    double hight;
    String name;

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
}
