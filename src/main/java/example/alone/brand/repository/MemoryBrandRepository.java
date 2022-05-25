package example.alone.brand.repository;

import example.alone.brand.Brand;

import java.util.HashMap;
import java.util.Map;

public class MemoryBrandRepository implements BrandRepository{

    private static Map<Long, Brand> store = new HashMap<>();

    @Override
    public void save(Brand brand) {
        store.put(brand.getBrandId(), brand);
    }

    @Override
    public Brand findByName(String brandName) {
        return store.get(brandName);
    }

    @Override
    public void update(Brand brand) {
    }

    @Override
    public void delete(String brandName) {

    }
}
