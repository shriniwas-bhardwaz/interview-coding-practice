package LowLevelDesign.DesignPatterns.StrategyDesignPattern.SortingWays;

public class QuickSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Quick Sort");
    }
}
