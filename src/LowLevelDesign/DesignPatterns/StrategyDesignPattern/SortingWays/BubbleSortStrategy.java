package LowLevelDesign.DesignPatterns.StrategyDesignPattern.SortingWays;

public class BubbleSortStrategy implements SortingStrategy{
    @Override
    public void sort(int[] array) {
        System.out.println(" Sorting using Bubble Sort");
    }
}
