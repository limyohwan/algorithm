package polygon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼각형과세변 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if (x == 0 && y == 0 && z == 0) {
                break;
            }

            Triangle triangle = new Triangle(x, y, z);
            System.out.println(triangle.getTriangleName());
        }

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
            int max = Math.max(Math.max(x, y), z);

//            if (max == x) {
//                if ((y + z) <= x) {
//                    return "Invalid";
//                }
//            } else if (max == y) {
//                if ((z + x) <= y) {
//                    return "Invalid";
//                }
//            } else if (max == z){
//                if ((x + y) <= z) {
//                    return "Invalid";
//                }
//            }
            if ((x + y + z - max) <= max) {
                return "Invalid";
            }

            if (x == y && y == z && z == x) {
                return "Equilateral";
            }

            if (x != y && y != z && z != x) {
                return "Scalene";
            }

            return "Isosceles";
        }
    }
}
