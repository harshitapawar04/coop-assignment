//Company Asset Tracker (Map<String, Set<Asset>>)
//
//        Store assets per department with unique Asset objects.
//
//        Detect duplicate asset IDs globally.

package javaCollectionFramework.Assignment11;
import java.util.*;

class Asset {
    private String id;
    private String name;

    public Asset(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Equals and hashCode based on id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asset)) return false;
        Asset asset = (Asset) o;
        return Objects.equals(id, asset.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name;
    }
}

public class CompanyassetTracker {
    private final Map<String, Set<Asset>> departmentAssets = new HashMap<>();
    private final Set<String> globalAssetIds = new HashSet<>();
    private final Set<String> duplicateAssetIds = new HashSet<>();

  // Business logic
    public void addAsset(String department, Asset asset) {
        if (!globalAssetIds.add(asset.getId())) {
            duplicateAssetIds.add(asset.getId());
        }

        departmentAssets
                .computeIfAbsent(department, k -> new HashSet<>())
                .add(asset);
    }

    public void printAssetsByDepartment() {
        for (String dept : departmentAssets.keySet()) {
            System.out.println("Department: " + dept);
            for (Asset asset : departmentAssets.get(dept)) {
                System.out.println("  " + asset);
            }
        }
    }

    public void printDuplicateAssetIds() {
        if (duplicateAssetIds.isEmpty()) {
            System.out.println("No duplicate asset IDs found.");
        } else {
            System.out.println("Duplicate asset IDs detected:");
            for (String id : duplicateAssetIds) {
                System.out.println("  - " + id);
            }
        }
    }

    public static void main(String[] args) {
        CompanyassetTracker tracker = new CompanyassetTracker();

        tracker.addAsset("IT", new Asset("A100", "Laptop"));
        tracker.addAsset("HR", new Asset("A200", "Projector"));
        tracker.addAsset("IT", new Asset("A300", "Monitor"));
        tracker.addAsset("Finance", new Asset("A100", "Laptop Duplicate"));

        tracker.printAssetsByDepartment();
        tracker.printDuplicateAssetIds();
    }
}
