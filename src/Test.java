public class Test {

    private String testId;
    private String testName;
    private int testCost;

    public Test(String testId, String testName, int testCost) {
        this.testId = testId;
        this.testName = testName;
        this.testCost = testCost;
    }

    public void showInfo()
    {
        System.out.println("test id is "  +this.testId);
        System.out.println("test name is " +this.testName);
        System.out.println("test cost is " +this.testCost);
    }
    public String getTestId() {
        return testId;
    }

}

