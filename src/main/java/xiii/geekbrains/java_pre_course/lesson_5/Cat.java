package xiii.geekbrains.java_pre_course.lesson_5;

class Cat extends Animals {
    private boolean isWellFed = false; //сытый
    private int foodToWellFed; // сколько единиц еды надо съесть, чтобы быть сытым

    public Cat(String name, int foodToWellFed) {
        setName(name);
        setDistanceOfRun(200);
        setDistanceOfSwim(0);
        setHight(2);
        this.foodToWellFed = foodToWellFed;
    }

    public boolean getIsWellFed() {
        this.isWellFed = true;
        return isWellFed;
    }

    public void eatFromPlate(Plate plate) {
        if ((plate.getFoodInside() - this.foodToWellFed) < 0) {
            System.out.println(this.getName() + " хочет " + this.foodToWellFed + " единиц еды и не наестся из этой миски");
        } else {
            this.getIsWellFed();
            plate.setFoodInside(plate.getFoodInside() - this.foodToWellFed);
            System.out.println(this.getName() + " съел " + this.foodToWellFed + " единиц еды и наелся");
        }
    }

    public void setWellFed(boolean wellFed) {
        this.isWellFed = wellFed;
    }

    public int getFoodToWellFed() {
        return foodToWellFed;
    }

    public void setFoodToWellFed(int foodToWellFed) {
        this.foodToWellFed = foodToWellFed;
    }
}
