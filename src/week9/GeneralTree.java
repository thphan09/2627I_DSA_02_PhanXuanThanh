
class Node {
    int data;
    Node leftmostChild; // Con trưởng
    Node rightSibling;  // Em liền kề

    public Node(int data) {
        this.data = data;
        this.leftmostChild = null;
        this.rightSibling = null;
    }
}
public class GeneralTree {

    // Hàm tìm kiếm và trả về nút bố của nút có giá trị targetVal
    public static Node findParent(Node root, int targetVal) {
        if (root == null) {
            return null;
        }

        // Duyệt qua danh sách các con của nút hiện tại (bắt đầu từ con trưởng)
        Node child = root.leftmostChild;
        while (child != null) {
            // Nếu con trưởng hoặc anh em của nó chính là nút cần tìm thì 'root' là bố
            if (child.data == targetVal) {
                return root;
            }
            
            // Gọi đệ quy tìm sâu hơn trong cây con của người con này
            Node found = findParent(child, targetVal);
            if (found != null) {
                return found;
            }
            
            // Chuyển sang người em liền kề tiếp theo
            child = child.rightSibling;
        }

        return null; // Không tìm thấy
    }
}