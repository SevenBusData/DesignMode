package DesignPhilosophy.InterfaceSegregationPrinciple;

/**
 * @ClassName: ProductQueryClient
 * @Description: TODO
 * @author: SevenBusData
 * @since: 2025/10/12
 */
public class ProductQueryClient implements ProductQueryService{
    @Override
    public Product getProductById(String productId) {
        // 只实现需要的查询逻辑，无冗余代码
        return new Product(productId, "手机");
    }
}
