package dev.ashish.productservice.repositories;

public interface CustomQueries {
    String FIND_ALL_BY_TITLE = "select * from product join product_orders " +
            "on product.id = product_orders.product_id where title = :ashish";
    String  FIND_PROD_BY_ID ="SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.category LEFT JOIN FETCH p.price where p.id=:id";
    String FIND_ALL_PRODUCT="SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.category LEFT JOIN FETCH p.price";
    String FIND_ALL_PRODUCT_BY_CATEGORY="SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.category LEFT JOIN FETCH p.price where p.category.name=:categoryName";
    String GET_ALL_PRODUCT_CATEGORY="Select distinct c.name from product p left join category c on p.category = c.id";
}
