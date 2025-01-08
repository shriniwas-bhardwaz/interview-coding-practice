package LowLevelDesign.DesignPatterns.StrategyDesignPattern.SortingWays;

public class SortingContext {

    private SortingStrategy sortingStrategy;

    public SortingContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(int[] arr) {
        sortingStrategy.sort(arr);
    }
}
