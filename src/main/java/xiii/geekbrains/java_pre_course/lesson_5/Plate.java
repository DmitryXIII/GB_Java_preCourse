package xiii.geekbrains.java_pre_course.lesson_5;

class Plate {
    private int maxVolume;
    private int foodInside = 0;

    public Plate(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public void putFoodInside(int foodInside) {
        if ((this.foodInside + foodInside) > this.maxVolume) {
            System.out.println(foodInside + " единиц еды в миску не влезет");
        } else {
            this.foodInside += foodInside;
            System.out.println("Добавили единиц еды: " + foodInside + ". Сейчас в миске " + this.foodInside + " единиц еды");
        }
    }

    public int getFoodInside() {
        if (foodInside < 1) {
            System.out.println("Миска пустая, необходимо ее наполнить");
            this.putFoodInside(this.maxVolume);
            System.out.println();
        }
        return this.foodInside;
    }

    public void setFoodInside(int foodInside) {
        this.foodInside = foodInside;
    }
}
