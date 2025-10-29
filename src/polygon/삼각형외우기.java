package polygon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 삼각형외우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Triangle triangle = new Triangle(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
        System.out.println(triangle.getTriangleName());
    }

    static class Triangle {
        int x;
        int y;
        int z;

        public Triangle(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public String getTriangleName() {
            if (x == 60 && y == 60 && z == 60) {
                return "Equilateral";
            }

            if ((x + y + z) == 180) {
                if (x == y || y == z || z == x) {
                    return "Isosceles";
                } else {
                    return "Scalene";
                }
            }

            return "Error";
        }
    }
}
