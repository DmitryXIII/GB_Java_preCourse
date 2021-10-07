package xiii.geekbrains.java_pre_course.lesson_5;

/*
1. Класс кота из прошлого ДЗ расширить функционалом потребления пищи.
   У каждого кота есть аппетит, т.е. количество еды, которое он съедает за один раз;
2. Кот должен есть из миски. Создайте такую сущность, которая будет обладать объёмом и едой в ней,
   а также методами наполнения и получения информации о количестве еды;
3. Метод из первого пункта ДЗ должен взаимодействовать с миской, т.е.,
   конкретный кот ест из конкретной миски, уменьшая объём еды в ней;
4. Предусмотрите проверку, при которой в миске не может получиться отрицательного
   количества еды (например, в миске 10 единиц еды, а кот пытается съесть 15);
5. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
   Если коту удалось поесть (хватило еды), сытость = true;
   Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
   то есть не может быть наполовину сыт (это сделано для упрощения логики программы);
6. Создать массив котов и одну тарелку с едой, попросить всех котов покушать из этой тарелки
   и потом вывести информацию о сытости котов в консоль;
7. Когда еда в тарелке кончается, нужно оповещать об этом и наполнять её едой.
*/

public class Zadanie_5 {
    public static void main(String[] args) {

        Plate plate1 = new Plate(150);
        plate1.getFoodInside();

        Cat[] cats = new Cat[10];
        cats[0] = new Cat("Кот_0", 20);
        cats[1] = new Cat("Кот_1", 10);
        cats[2] = new Cat("Кот_2", 11);
        cats[3] = new Cat("Кот_3", 13);
        cats[4] = new Cat("Кот_4", 20);
        cats[5] = new Cat("Кот_5", 22);
        cats[6] = new Cat("Кот_6", 15);
        cats[7] = new Cat("Кот_7", 9);
        cats[8] = new Cat("Кот_8", 24);
        cats[9] = new Cat("Кот_9", 13);

        for (int i = 0; i < cats.length; i++) {
            while (true) {
                System.out.println(cats[i].name + " сытый: " + cats[i].wellFed);
                cats[i].eatFromPlate(plate1);
                System.out.println(cats[i].name + " сытый: " + cats[i].wellFed);
                System.out.println("В миске осталось: " + plate1.foodInside + " единиц еды");
                System.out.println();
                if (!cats[i].wellFed) {
                    plate1.putFoodInside(cats[i].foodToWellFed);
                    continue;
                }
                break;
            }
        }
    }
}


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

class Cat extends Animals {
    boolean wellFed = false; //сытый
    int foodToWellFed; // сколько единиц еды надо съесть, чтобы быть сытым

    public Cat(String name, int foodToWellFed) {
        this.name = name;
        this.foodToWellFed = foodToWellFed;
        this.distanceOfRun = 200;
        this.distanceOfSwim = 0;
        this.hight = 2;
    }

    public boolean isWellFed() {
        this.wellFed = true;
        return wellFed;
    }

    public void eatFromPlate(Plate plate) {
        if ((plate.foodInside - this.foodToWellFed) < 0) {
            System.out.println(this.name + " хочет " + this.foodToWellFed + " единиц еды и не наестся из этой миски");
        } else {
            this.isWellFed();
            plate.foodInside -= this.foodToWellFed;
            System.out.println(this.name + " съел " + this.foodToWellFed + " единиц еды и наелся");
        }
    }
}

class Dog extends Animals {
    public Dog(String name) {
        this.name = name;
        this.distanceOfRun = (int) (400 + Math.random() * 201);
        this.distanceOfSwim = 10;
        this.hight = 0.5;
    }
}

class Plate {
    int maxVolume;
    int foodInside = 0;

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
}
