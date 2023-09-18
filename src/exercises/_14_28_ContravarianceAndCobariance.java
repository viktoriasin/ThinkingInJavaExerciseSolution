package exercises;

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}


class Consumer<T> {
    public void consume(T arg) {

    }
}

class Producer<T> {
    T arg;

    Producer(T arg) {
        this.arg = arg;
    }

    public T produce() {
        return arg;
    }
}


public class _14_28_ContravarianceAndCobariance {
    static void contravariantMethod(Consumer<? super Apple> arg, Apple n) {
        arg.consume(n);
    }

    static Apple covariantMethod(Producer<? extends Apple> arg) {
        return arg.produce();
    }

    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        Orange orange = new Orange();
        Apple apple = new Apple();
        Jonathan jonathan = new Jonathan();

        Consumer<Object> consumerObjects = new Consumer<Object>();
        Consumer<Fruit> consumerFruits = new Consumer<Fruit>();
        Consumer<Orange> consumerOranges = new Consumer<Orange>();
        Consumer<Apple> consumerApples = new Consumer<Apple>();
        Consumer<Jonathan> consumerJonathans = new Consumer<Jonathan>();

//        contravariantMethod(consumerFruits, fruit);
        contravariantMethod(consumerApples, apple);
        contravariantMethod(consumerFruits, apple);
        contravariantMethod(consumerFruits, jonathan);
        contravariantMethod(consumerObjects, jonathan);
//        contravariantMethod(consumerFruits, orange);


        Producer<Object> objectProducer = new Producer<>(new Object());
        Producer<Fruit> fruitProducer = new Producer<>(new Fruit());
        Producer<Orange> orangeProducer = new Producer<>(new Orange());
        Producer<Apple> appleProducer = new Producer<>(new Apple());
        Producer<Jonathan> jonathanProducer = new Producer<>(new Jonathan());



        Apple testApple;
//        testApple = covariantMethod(objectProducer);
//        testApple = covariantMethod(fruitProducer);
//        testApple = covariantMethod(orangeProducer);
        testApple = covariantMethod(appleProducer);
        testApple = covariantMethod(jonathanProducer);
    }
}
