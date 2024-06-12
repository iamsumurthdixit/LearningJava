import com.sun.source.tree.Tree;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
//        System.out.println("hello world");
//        int priceOfPen = Calculation.getPriceOfPen();
//        System.out.println("Price of pen is: " + priceOfPen);

//        Person.getProfession();
//        Doctor.getProfession();

//        Calculation calculation = new Calculation();
//        calculation.sum(34, 98, 2,4,5,6,38,0);
//        calculation.sum(87);
//        calculation.sum(34, 3,4,2,5,68,9);


//        SingleCalculation object = SingleCalculation.getInstance();

//        ManagerChild manager = new ManagerChild("sam", 34);

//        Audi smallAudi = new Audi(45, 500);
//        LuxuryCar sedanAudi = new Audi(98, 600);
//        Car suvAudi = new Audi(100, 900);

//        Object parentAudi = new Audi(34, 983);
//        System.out.println(parentAudi.getClass());  // class Audi

//        OuterClassMember outerOBj = new OuterClassMember();
//        OuterClassMember.InnerClass innerObj = outerOBj.new InnerClass();
//        innerObj.print(); // 40

//        OuterClassLocal outerLocal = new OuterClassLocal();
//        outerLocal.display(); // 264


//        AnonymousClass anonymousObj = new AnonymousClass() {
//            @Override
//            public void pressBrake() {
//                System.out.println("brake pressed");
//            }
//        };
//        anonymousObj.pressBrake();
//        System.out.println(anonymousObj.getClass()); // class Main$1 (this name is created by the compiler)

//        PrintGeneric<Integer> printObj1 = new PrintGeneric<Integer>();
//        printObj1.setValue(10);
//        if (printObj1.getValue() == 10) {
//            System.out.println("yes"); // yes
//        }

//        ColorNonGeneric colorObj = new ColorNonGeneric();
//        colorObj.setValue("blue");
//        System.out.println(colorObj.getValue()); // blue
//
//        ColorGeneric<String> colorGenObj = new ColorGeneric<>();
//        colorGenObj.setValue("red");
//        System.out.println(colorGenObj.getValue()); // red

//        Pair<String, Integer> pair = new Pair<>();
//        pair.put("red", 34);
//        pair.print(); // red=34

//        PrintAllGeneric printObj = new PrintAllGeneric();
//        printObj.setValue(new Doctor());
//        printObj.setValue(new Audi(24, 98));

//        for(EnumSample sample: EnumSample.values()) {
//            System.out.println(sample.ordinal()); // 0 1 2 3 4 5 6
//        }
//        EnumSample enumVar = EnumSample.valueOf("FRIDAY");
//        System.out.println(enumVar); // FRIDAY
//        System.out.println(enumVar.name());  // FRIDAY

//        EnumCustom sampleVar = EnumCustom.getEnumFromValue(102);
//        System.out.println(sampleVar + " " + sampleVar.getComment() + " " + sampleVar.ordinal()); // TUESDAY 2nd 1

//        EnumCustom enumCustomVar = EnumCustom.SUNDAY;
//        System.out.println(enumCustomVar.getComment() + " " + enumCustomVar.getClass()); // 7rd class EnumCustom
//
//        String valueOfSundayFromEnum = EnumCustom.SUNDAY.name();
//        System.out.println(valueOfSundayFromEnum + " : " + valueOfSundayFromEnum.getClass()); // SUNDAY : class java.lang.String

//        EnumSample dummySample = EnumSample.FRIDAY;
//        dummySample.dummyMethod(); // default dummy method
//        EnumSample mondaySample = EnumSample.MONDAY;
//        mondaySample.dummyMethod(); // monday dummy method

//        EnumAbstract monday = EnumAbstract.MONDAY;
//        monday.dummyMethod(); // monday
//        EnumAbstract tuesday = EnumAbstract.TUESDAY;
//        tuesday.dummyMethod(); // tuesday

//        EnumInterface monday = EnumInterface.MONDAY;
//        System.out.println(monday.toLowerCase()); // monday

//        DBConnectionEager DbConnectionObject = DBConnectionEager.getInstance();
//        DBConnectionEager newDbInstance = DBConnectionEager.getInstance();
//
//        for(int i = 0; i < 5; i++) {
//            if((i & 1) == 1) {
//                DbConnectionObject.connectDB();
//            } else {
//                DbConnectionObject.disConnectDB();
//            }
//            System.out.println(DbConnectionObject.isActive() + " , " + newDbInstance.isActive());
//        }

//        String name = "random";
//        List<Object> petNames = new ArrayList<>();
//        petNames.add("sj");
//        petNames.add("pj");
//
//        ImmutableClass immutableObj = new ImmutableClass(name, petNames);
//        System.out.println(immutableObj.getName()); // random
//
//        List<Object> petNamesList = immutableObj.getPetNameList();
//        petNamesList.add("new word");
//        System.out.println(petNamesList); // [sj, pj, new word]
//        System.out.println(immutableObj.getPetNameList()); // [sj, pj]


//        Bird eagle = new Eagle();
//        eagle.canFly(); // Eagle can fly
//        Bird hen = new Hen();
//        System.out.println(hen.getFixedValue()); // I am fixed from Bird
//        System.out.println(hen.getMinimumFlyHeight()); // 200
//
//        MultipleInterface multipleInterfaceObject = new MultipleInterface();
//        multipleInterfaceObject.canFly(); // I can fly
//        System.out.println(multipleInterfaceObject.getMinimumFlyHeight()); // 200
//        System.out.println(multipleInterfaceObject.getFixedValue()); // Overridden Bird and Airborne default methods

//        BirdChildClass birdChild = new BirdChildClass();
//        System.out.println(birdChild.getFixedValue()); // BirdChild

//        AirborneChildClass obj = new AirborneChildClass();
//        System.out.println(obj.getFixedValue()); // I am airborne adding this from airborne child

//        boolean canBirdBreathe = Bird.canBreathe(); // accessing static method of an interface
//        System.out.println(canBirdBreathe); // true

//        PrivateInterfaceClass privateInterfaceObject = new PrivateInterfaceClass();
//        privateInterfaceObject.canFly();
//        System.out.println("------  calling interface default method");
//        PrivateInterface.publicStaticMethod();
//
//        FunctionalBird anonymousClassObj = new FunctionalBird() {
//            @Override
//            public void canFly(String val) {
//                System.out.println("can fly from anonymous class " + val);
//            }
//        };
//        anonymousClassObj.canFly("implemented"); // can fly from anonymous class implemented
//
//        FunctionalBird lambdaObject = (String val) -> {
//            System.out.println("lambdaObject " + val);
//        };
//        lambdaObject.canFly("implemented"); // lambdaObject implemented
//        Consumer<Integer> loggingObject = (Integer val) -> {
//            if (val > 10) {
//                System.out.println(val + " is greater than 10");
//            }
//        };
//        loggingObject.accept(134); // accept() is the only method present in Consumer
//
//        Supplier<String> isEvenNumber = () -> "This is an even number";
//        System.out.println(isEvenNumber.get());
//
//        Function<Integer, String> integerToString = (Integer val) -> {
//            String output = val.toString();
//            return output;
//        };
//        System.out.println(integerToString.apply(9834)); // 9834
//
//        Predicate<Integer> isOddNumber = val -> val % 2 == 0;
//        System.out.println(isOddNumber.test(9834)); // true

//        Class eagleClass = EagleReflection.class;
//
//        System.out.println(eagleClass.getName()); // EagleReflection
//        System.out.println(Modifier.toString(eagleClass.getModifiers())); // public
//
        // .getMethods() gives all the "public" methods of the current class and all it's parent classes
//        Method[] methods = eagleClass.getMethods();


//        for (Method method : methods) {
//            System.out.println(method.getName());
//            System.out.println(Modifier.toString(method.getModifiers()));
//            System.out.println(method.getReturnType());
//            System.out.println(method.getDeclaringClass());
//            System.out.println();
//        }

        // .getDeclaredMethods() gives all kinds of methods of the currently declared class only

//        Method[] declaredMethods = eagleClass.getDeclaredMethods(); // [fly(), eat()]
//        for (Method method : declaredMethods) {
//            System.out.println(method.getName());
//            System.out.println(method.getDeclaringClass());
//            System.out.println();
//        }


//        Class eagleClass = Class.forName("EagleReflection");
//        Object eagleClassObject = eagleClass.newInstance(); // OR EagleReflection eagleClassObject = ...
//
//        Method flyMethod = eagleClass.getMethod("fly", int.class, boolean.class, String.class);
//        flyMethod.invoke(eagleClassObject, 34, true, "hello"); // fly: 34 true hello
//
//        // similar methods for .getFields() and .getDeclaredFields() of return type Field[]
//
//        Field field = eagleClass.getDeclaredField("canSwim");
//        field.setAccessible(true);
//        field.set(eagleClassObject, true);
//        if (field.getBoolean(eagleClassObject)) {
//            System.out.println("private field canSwim set to true from Main()");
//        }

//        System.out.println(new CustomAnnotation().getClass().getAnnotation(MyCustomAnnotation.class)); // @MyCustomAnnotation()

//        System.out.println(new CustomAnnotationChild().getClass().getAnnotation(MyCustomAnnotation.class)); // @MyCustomAnnotation()


        //
//        Category[] categoryAnnotationArray = CategoryClass.class.getAnnotationsByType(Category.class);
//        for (Category annotation : categoryAnnotationArray) {
//            System.out.println(annotation); //        @Category(name="bird") @Category(name="livingThing") @Category(name="someAnotherValue")
//        }

        List<Integer> values = new ArrayList<>();
//        for (int i = 1; i <= 4; i++) {
//            values.add(i);
//        }
//        System.out.println(values);
//        Iterator<Integer> iterator = values.iterator();
//        while(iterator.hasNext()) {
//            int value = iterator.next();
//            System.out.println(value);
//            if(value == 3) {
//                iterator.remove();
//            }
//        }
//        System.out.println(values);
//
//        for(int value : values) {
//            System.out.println(value);
//        }
//        values.forEach((Integer value) -> System.out.println("value is = " + value));

//        values.add(2); values.add(3); values.add(4);
//        System.out.println(values.contains(2)); // true
//        values.remove(Integer.valueOf(4));
//        System.out.println(values.contains(4)); // false
//        values.add(5);
//        values.remove(2);
//        System.out.println(values); // [2, 3]
//        Stack<Integer> stackValues = new Stack<>();
//        stackValues.addAll(values);
//        System.out.println(values.containsAll(stackValues)); // true
//        values.removeAll(stackValues);
//        System.out.println(values.isEmpty()); // true
//        values.add(3); values.add(7); values.add(8); values.add(10);
//        values.removeIf((Integer val) -> val % 2 == 0);
//        System.out.println(values); // [3, 7]

//        List<CarComp> cars = new ArrayList<>();
//        cars.add(new CarComp("honda", "sedan"));
//        cars.add(new CarComp("audi", "sport"));
//        cars.add(new CarComp("bmw", "luxury"));
//
//        Collections.sort(cars, new CarNameComparator());
//        cars.forEach((CarComp car) -> System.out.println(car.name + " " + car.type)); // audi sport bmw luxury honda sedan

//        List<CarComparable> cars = new ArrayList<>();
//        cars.add(new CarComparable("honda", "sedan"));
//        cars.add(new CarComparable("audi", "sport"));
//        cars.add(new CarComparable("bmw", "luxury"));
//
//        Collections.sort(cars);
//        cars.forEach(car -> System.out.println(car.name + " " + car.type));


//        ArrayDeque<Integer> dequeAsQueue = new ArrayDeque<>();
//        dequeAsQueue.addLast(1); dequeAsQueue.addLast(2);
//        int queueElement = dequeAsQueue.removeFirst();
//        System.out.println(queueElement); // 1
//
//        ArrayDeque<Integer> dequeAStack = new ArrayDeque<>();
//        dequeAStack.addFirst(1); dequeAStack.addFirst(2);
//        int stackElement = dequeAStack.removeFirst();
//        System.out.println(stackElement); // 2

//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list1.add(0, 100); list1.add(1, 200); list1.add(2, 300);
//        list2.add(0, 400); list2.add(1, 500); list2.add(2, 600);
//        list1.addAll(2, list2);
//        list1.forEach(System.out::println);
//        list1.replaceAll(val -> -1 * val);
//        list1.forEach(System.out::println);
//        list1.sort(Comparator.comparingInt(a -> a));
//        list1.remove(2);
//        list1.forEach(System.out::println);
//
//        ListIterator<Integer> forwardIterator = list1.listIterator();
//        while(forwardIterator.hasNext()) {
//            int val = forwardIterator.next();
//            System.out.println("val= " + val + ", pI = " + forwardIterator.previousIndex());
//            if(val == -200) {
//                forwardIterator.add(24);
//            }
//        }
//        list1.forEach(System.out::println);
//
//        ListIterator<Integer> reverseIterator = list1.listIterator(list1.size());
//        while(reverseIterator.hasPrevious()) {
//            int val = reverseIterator.previous();
//            System.out.println("val= " + val + ", pI = " + reverseIterator.previousIndex() + ", nI = " + reverseIterator.nextIndex());
//        }
//
//        List<Integer> sublist = list1.subList(2, list1.size() - 2);
//        sublist.forEach(System.out::println); // [-300, -200]
//        sublist.add(1, 999);
//        System.out.println();
//        list1.forEach(System.out::println);

//        LinkedList<Integer> linkedListDeque = new LinkedList<>();
//        linkedListDeque.addFirst(34);
//        linkedListDeque.addLast(53);
//        linkedListDeque.forEach(System.out::println); // [34, 53]
//        LinkedList<Integer> linkedListArrayList = new LinkedList<>();
//        linkedListArrayList.add(0, 34);
//        linkedListArrayList.add(1, 53);
//        linkedListArrayList.forEach(System.out::println); // [34, 53]

//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        while(!stack.isEmpty()) {
//            System.out.println(stack.pop()); // 2 1
//        }

//        Map<Integer, String> rollNumberVsNameMap = new HashMap<>();
//        rollNumberVsNameMap.put(null, "test");
//        rollNumberVsNameMap.put(0, null);
//        rollNumberVsNameMap.put(1, "A");
//        rollNumberVsNameMap.put(2, "B");
//
//        rollNumberVsNameMap.putIfAbsent(null, "test-update");
//        rollNumberVsNameMap.putIfAbsent(0, "fixed-0");
//        rollNumberVsNameMap.putIfAbsent(1, "C");
//        rollNumberVsNameMap.putIfAbsent(3, "D");
//
//        System.out.println(rollNumberVsNameMap); // {null=test, 0=fixed-0, 1=A, 2=B, 3=D}
//        for(Map.Entry<Integer, String> entry : rollNumberVsNameMap.entrySet()) {
//            System.out.println("key= " + entry.getKey() + " value= " + entry.getValue());
//        } // key= null value= test key= 0 value= fixed-0 key= 1 value= A key= 2 value= B key= 3 value= D
//
//        rollNumberVsNameMap.remove(null);
//        System.out.println(rollNumberVsNameMap); // {0=fixed-0, 1=A, 2=B, 3=D}
//        System.out.println(rollNumberVsNameMap.containsKey(3)); // true
//        System.out.println(rollNumberVsNameMap.containsValue("D")); // true
//
//        for (Integer key : rollNumberVsNameMap.keySet()) {
//            System.out.println("key= " + key + " value= " + rollNumberVsNameMap.get(key));
//        }
//        for (String value : rollNumberVsNameMap.values()) {
//            System.out.println("value= " + value);
//        }

//        Map<Integer, String> linkedMap = new LinkedHashMap<>();
//        linkedMap.put(1, "A"); linkedMap.put(2, "B"); linkedMap.put(3, "C");
//        linkedMap.forEach((k, v) -> System.out.println(k + ": " + v)); // 1: A 2: B 3: C // insertion order maintained

        // creating accessOrder linked hash map, used for caching
//        Map<Integer, String> frequentMap = new LinkedHashMap<>(16, 0.75f, true);
//        frequentMap.put(1, "A"); frequentMap.put(2, "B"); frequentMap.put(3, "C");
//        String val = frequentMap.get(2);
//        System.out.println(val);
//        frequentMap.forEach((k, v) -> System.out.println(k + ": " + v)); // 1: A 3: C 2: B
//
//        Map<Integer, String> threadSafeMap = Collections.synchronizedMap(new LinkedHashMap<>());
//        threadSafeMap.put(1, "A"); threadSafeMap.put(2, "B"); threadSafeMap.put(3, "C");
//        System.out.println(threadSafeMap); // {1=A, 2=B, 3=C}

//        Map<Integer, String> desMap = new TreeMap<>((a, b) -> b - a);
//        desMap.put(1, "A"); desMap.put(2, "B"); desMap.put(3, "C");
//        desMap.forEach((k, v) -> System.out.println(k + ": " + v)); // 3: C 2: B 1: A

        SortedMap<Integer, String> incMap = new TreeMap<>();
        incMap.put(5, "A"); incMap.put(8, "B"); incMap.put(2, "C");
        incMap.put(17, "D"); incMap.put(13, "F"); incMap.put(14, "E");
        System.out.println(incMap); // {2=C, 5=A, 8=B, 13=F, 14=E, 17=D}

        System.out.println(incMap.headMap(12)); // {2=C, 5=A, 8=B}
        System.out.println(incMap.tailMap(12)); // {13=F, 14=E, 17=D}
        incMap.headMap(12).put(2, "X"); // changes reflect vice-versa
        System.out.println(incMap); // {2=X, 5=A, 8=B, 13=F, 14=E, 17=D}

        System.out.println("smallest key = " + incMap.firstKey()); // 2
        System.out.println("largest key = " + incMap.lastKey()); // 17



















    }
}
















