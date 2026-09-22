import java.util.*;

public class FusionTreeIndex {

    private TreeMap<Double, List<Integer>> priceIndex;

    public FusionTreeIndex() {
        priceIndex = new TreeMap<>();
    }

    public void insert(double price, int productId) {

        if (!priceIndex.containsKey(price)) {
            priceIndex.put(price, new ArrayList<>());
        }

        priceIndex.get(price).add(productId);
    }


    public List<Integer> searchRange(double minPrice, double maxPrice) {

        List<Integer> result = new ArrayList<>();

        Map<Double, List<Integer>> range =
                priceIndex.subMap(minPrice, true, maxPrice, true);

        for (List<Integer> ids : range.values()) {
            result.addAll(ids);
        }

        return result;
    }
}