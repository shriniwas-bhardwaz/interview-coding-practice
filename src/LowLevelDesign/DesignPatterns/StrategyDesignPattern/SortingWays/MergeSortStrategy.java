package LowLevelDesign.DesignPatterns.StrategyDesignPattern.SortingWays;

public class MergeSortStrategy implements SortingStrategy {

    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Merge Sort");
    }
}
