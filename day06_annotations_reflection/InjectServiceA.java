package day06_annotations_reflection;


    public class InjectServiceA {
        public void serve() {
            System.out.println("ServiceA is serving...");
        }
    }

     class ServiceB {
        @Inject
        private InjectServiceA serviceA;

        public void execute() {
            serviceA.serve();
            System.out.println("ServiceB is executing...");
        }
    }
