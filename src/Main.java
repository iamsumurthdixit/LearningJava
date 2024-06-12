import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
    }
}