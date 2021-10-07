package xiii.geekbrains.java_pre_course.lesson_4;

class Dog extends Animals {
    public Dog(String name) {
        this.name = name;
        this.distanceOfRun = (int) (400 + Math.random() * 201);
        this.distanceOfSwim = 10;
        this.hight = 0.5;
    }
}
