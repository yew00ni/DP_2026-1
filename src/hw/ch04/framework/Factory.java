package hw.ch04.framework;

public abstract class Factory {
    // 템플릿 메소드(제품 생성할 때 생성)
    public final Product create(String owner) {
        // 예 : 실제로는 IDCard 객체가 생성되지만, 부모 타입으로 받을 수 있다.
        Product p = createProduct(owner); // 제품 생성(타입은 Product이지만, 생성되는 것은 자식인 IDCard)
        registerProduct(p); // 생성된 제품을 등록
        return p; // create를 호출하면 제품이 생성됨
    }

    // 구체적인 공장이 구현해야 하는 메소드
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
