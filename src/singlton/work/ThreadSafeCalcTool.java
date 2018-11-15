package singlton.work;

public class ThreadSafeCalcTool {
    private static int totalBMICalcullated=0;
    private static int numberOfCaculations=0;
    private ThreadSafeCalcTool inst;

    public ThreadSafeCalcTool getThreadSafeCalcTool(){
        synchronized (ThreadSafeCalcTool.class){
            if(inst == null){
                inst = new ThreadSafeCalcTool();
            }
        }
        return inst;
    }

    private ThreadSafeCalcTool(){};



    public static double calcBMI(double height, double weight, MeasurementSystem measurementSystem) {
        double bmi = weight / Math.pow(height,2);
        if (measurementSystem == MeasurementSystem.ENGLISH) {
            bmi *= 703;
        }
        totalBMICalcullated+=bmi;
        numberOfCaculations++;

        return bmi;
    }

    public static double averageBMI() {
        return totalBMICalcullated / numberOfCaculations;
    }

}
