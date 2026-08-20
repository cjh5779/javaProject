package exam.finalaloex;

public class StorageMain {
    public static void main(String[] args) {
        BinarySearchTreeStorage<Product> storage = new BinarySearchTreeStorage<Product>();
        
        storage.add(new Product("melon", 5));
        storage.add(new Product("apple", 5));
        storage.add(new Product("banana", 5));
        storage.add(new Product("orange", 5));
        storage.add(new Product("kiwi", 5));
        storage.add(new Product("mango", 5));
        storage.add(new Product("tomato", 5));
        
        System.out.print("재고 확인 : ");
        storage.preorder();
        System.out.println();

        
        System.out.println("재고 반출 : banana 3 ");
        storage.updateStock(new Product("banana"), 3);
        System.out.print("재고 확인 : ");
        storage.preorder();
        System.out.println();
        
        System.out.println("재고 반출 : banana 3 ");
        System.out.println("재고 반출 결과 : " + storage.updateStock(new Product("banana"), 3));
        System.out.print("재고 확인 : ");
        storage.preorder();
        System.out.println();
        
        int resTemp = storage.updateStock(new Product("banana"), 3);
        
        if(resTemp == 0) {
            System.out.println("재고가 없는 품목이므로 재고 품목에서 삭제합니다");
            storage.remove(new Product("banana"));
        } else if(resTemp == -1) {
            System.out.println("반출수량만큼 재고가 없습니다");
            storage.preorder();
        } else if(resTemp == 1) {
            System.out.println("재고 반출 완료");
            storage.preorder();
        } else {
            System.out.println("반출하려는 품목이 창고에 없습니다");
            storage.preorder();
        }
    }
}