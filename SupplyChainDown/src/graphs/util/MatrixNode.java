package graphs.util;

import java.util.List;
import java.util.Objects;

public class MatrixNode {
    public int x;
    public int y;
    public int value;

    public MatrixNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixNode that = (MatrixNode) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
