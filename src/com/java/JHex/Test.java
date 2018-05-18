package com.java.JHex;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) throws IOException {
		int number = 3;
		// float f = 1.23f;
		byte[] bytes = JHex.toByteArray(number);
		System.out.println(Arrays.toString(bytes));
		System.out.println(JHex.toBinaryString(9, 32));
		for (int i = 0; i < 32; i++)
			System.out.print(JHex.bitValueAt(9, 5));
		System.out.println();
		System.out.println(JHex.getBitsValue(9, 1, 4));
		String str = "255";
		System.out.println(JHex.transRadix(str, 6, 3));
		System.out.println(JHex.extractBits(3, 1, 5));
		System.out.println("-----------------------------------------");
		byte[] b = JHex.toByteArray(1);
		System.out.println(Arrays.toString(b));
		System.out.println(JHex.toFloat(b));
		byte[] b2 = { 63, -100, 40, -10, 63, -100, 40, -10 };
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(b));
		System.out.println(dis.readFloat());
		System.out.println("-----------------------------------------");
		System.out.println(JHex.toHexString(-1, 10));
		System.out.println(JHex.toInt(b));
		System.out.println(Arrays.toString(JHex.toByteArray(number)));
		System.out.println(JHex.toInt(b2, 0, 2));
		System.out.println(JHex.toInt("127", 10));
		int[] numbers = { 65536 << 15, 128, 3 };
		byte[] b3 = JHex.toByteArray(numbers, 0, 3);
		System.out.println(Arrays.toString(b3));
		System.out.println(Arrays.toString(JHex.toFloatArray(b2, 0, 4)));
		System.out.println(Arrays.toString(JHex.toIntArray(b2, 2, 0, 8)));
		System.out.println("------------------------------------------");
		System.out.println(Arrays.toString(JHex.toByteArray(1.22)));
		System.out.println((byte)0x85);
	}
}
