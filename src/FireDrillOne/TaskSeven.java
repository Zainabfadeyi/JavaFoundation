
    public class TaskSeven {
        public static void main(String[] args) {

            for (int i = 1; i <= 10; i++) {

                if (i % 4 == 0) {

                    int value = i;
                    int sum = 0;

                    for (int j = 1; j <= 5; j++) {
                        sum += value;
                        value = value * i;
                    }

                    System.out.print( sum + " ");
                }
            }
        }
    }



