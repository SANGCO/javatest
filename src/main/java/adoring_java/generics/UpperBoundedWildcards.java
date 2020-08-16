package adoring_java.generics;

public class UpperBoundedWildcards {

    /*
        statoc으로 말들어 놓으면 static main 함수에서
        new 해서 Box 생성할 수 있고
        static 때고 만들면 UpperBoundedWildcards 클래스에 일반 메서드에서
        new 해서 Box 생성할 수 있다.
     */
    static class Box<T> {

        private T ob;

        public T getOb() {
            return ob;
        }

        public void setOb(T ob) {
            this.ob = ob;
        }

        public void outBox(Box<? extends T> box) {

        }
    }

    static class Toy {

        private String name = "Toy";

    }

    static class Car extends Toy {

        private String name = "Toy";

    }

    static class Robot extends Toy {

        private String name = "Toy";

    }

    public static void outBox(Box<? extends Toy> box) {
        Car ob = (Car) box.getOb();
// required type이 ? extends Toy 라고 컴파일 오류 뜬다.
//        box.setOb(new Toy());
    }

    public static void main(String[] args) {

    }

}
