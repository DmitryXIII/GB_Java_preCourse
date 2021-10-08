package xiii.geekbrains.java_pre_course.lesson_5;

class Cat extends Animals {
    private boolean isWellFed = false; //по умолчанию кот рождается голодным
    private int foodToWellFed; // сколько единиц еды надо съесть, чтобы быть сытым

    public Cat(String name, int foodToWellFed) {
        this.name = name;
        this.distanceOfRun = 200;
        this.distanceOfSwim = 0;
        this.hight = 2;
        this.foodToWellFed = foodToWellFed;
    }

    public boolean getIsWellFed() {
        return this.isWellFed;
    }

    public void eatFromPlate(Plate plate) {
        if ((plate.getFoodInside() - this.foodToWellFed) < 0) {
            System.out.println(this.getName() + " хочет " + this.foodToWellFed + " единиц еды и не наестся из этой миски");
        } else {
            this.isWellFed = true;
            plate.setFoodInside(plate.getFoodInside() - this.foodToWellFed);
            System.out.println(this.getName() + " съел " + this.foodToWellFed + " единиц еды и наелся");
        }
    }

    public int getFoodToWellFed() {
        return foodToWellFed;
    }
}
