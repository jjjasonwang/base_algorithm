package hash;

public class BloomFilterTest {

    public static void main(String[] args) {
        //一个int 4字节， 一字节 8bit， 一个int 32个bit
        //32000 bit
        int[] arr = new int[1000];

        int index = 30000;

        //求出在哪个int位
        int intIndex = index / 32;

        //求出在int位中的哪个bit位
        int bitIndex = index % 32;

        System.out.println(intIndex);
        System.out.println(bitIndex);

        //整个数组中 锁定的bit位变1
        arr[intIndex] = (arr[intIndex] | (1 << bitIndex));

    }
}
