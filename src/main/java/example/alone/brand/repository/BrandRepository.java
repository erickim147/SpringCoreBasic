package example.alone.brand.repository;

import example.alone.brand.Brand;

public interface BrandRepository {

    void save(Brand brand);

    Brand findByName(String brandName);

    void update(Brand brand);

    void delete(String brandName);

}
