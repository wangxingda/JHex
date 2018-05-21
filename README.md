JHex工具类参考手册
------------
### Version：1.2.0
### Author：王兴达
### Data：2018年5月21日15:22:56
---------
简介
==========
    Java不是一个完全面向对象的编程语言，因为其有基本数据类型的存在，在Java中所有的数值类的基本数据类型都是
    有符号数，而在嵌入式系统常用的C语言编程的数据则分为有符号和无符号两种类型，通常用于数据通讯与数据交互的
    都是无符号类型，尤其是使用SerialPort或者LibUSB这种接口与PC进行数据传输时尤为明显。

    以SerialPort为例，通常嵌入式编程中使用8bit数据位为一帧的方式传送数据，通常为无符号数，比如一个float类
    型占4个字节，通常需要接受4帧才能恢复出一个float类型的数据，Java在这方面就显得有些力不从心了，虽然有Da
    taInputStream这种类或者某些包装类的方法可以解决这个问题，但通常要么就是花费比较大的资源要么要么就是功
    能不够全面并且现在很多JDK里的数据转化存在BUG，比如Integer.parseInt(num,radix)这种方法如果你粘贴进去
    负数的二进制进去，那么就会产生异常了。

    使用JHex工具类可以解决这些问题，比如你可以轻松的使用toFloat(byte[] arr)这种函数把4帧byte数据转化成一
    个float类型，你可以使用getBitValue(int number,int bitAt)函数获取数值在某一个二进制位上的值等等 ，或
    者使用toByteArray(int number)将一个整型数转化成4帧byte数组并后续通过串口发送出去。

#### JHex是一个开源的、专门用于处理二进制数据和基本数据类型转换的工具类，本工具类基于JDK1.8编写。
-------------

参考手册
-------
```Java
1.private static final chs

各进制的字符，最大到16进制，0-f；


2.public static int bitValueAt(int number, int bitAt)

获取整形数中某一位的二进制值是1还是0；

参数：

  number -需要获取的整型数值。
  
  bitAt-需要获取的二进制的位置索引，0代表最低位，31代表最高位
  
返回：


  返回该索引位置的二进制值0或1。
  

3.public static String extractBits(int number, int from, int to)

获取整形数中某些位的二进制值得字符串。

参数：

  number -需要处理的整型数值。
  
  from -需要抽取的整型数的起始位置索引，from包含在内；
  
  to-需要抽取的整型数的结束位置索引，to不包含在内；
  
返回：

  从起始位置到结束位置索引抽取的二进制字符串。


4.public static int getBitsValue(int number, int from, int to)

获取整形数中某些连续位的二进制数组成的新数的数值大小。

参数：

  number -需要处理的整型数值。
  
  from -需要抽取的整型数的起始位置索引，from包含在内；
  
  to-需要抽取的整型数的结束位置索引，to不包含在内；
  
返回：

  从起始位置到结束位置索引抽取的二进制数的值。
  
抛出：

  IllegalArgumentException-如果from或者to的值越界或者from大于等于to时。
  

5.public static String toBinaryString(int number)

将一个十进制的整型数转化成相应的二进制字符串；

参数：

  number-需要处理的整型数值。
  
返回：

  该整型数的二进制形式表示的字符串。
  


6.public static String toBinaryString(int number, int minBinaryStringLength)

将一个十进制的整型数转化成相应的二进制字符串，并制定该二进制字符串的最短长度，不足位数用0补齐。

参数：

  number-需要处理的整型数值。
  
  minBinaryStringLength -二进制字符串的最短长度，高位用0补齐；
  
返回：

  返回补齐之后的该整型数表示的二进制字符串。
  
抛出：

IllegalArgumentException-当参数minBinaryStringLength小于该整型数的二进制表示的最短字符串长度时。



7.public static byte[] toByteArray(double number)

将一个double类型的浮点数转化成8个字节表示的byte类型的数组。

参数：

number-需要处理的浮点数类型。

返回：

  表示该double类型的8个字节的byte数组，从高位到低位排列，索引0表示最高位，7表示最低位。


8.public static byte[] toByteArray(double[] numbers)

将一个double类型的浮点数数组转化成表示其对应值的byte类型的数组。长度为double类型数组长度*8。

参数：

  numbers-需要处理的浮点数类型数组。
  
返回：

  表示该double类型的8*浮点数数组的长度 个字节的byte数组，从高位到低位排列。 
  
抛出：

  IllegalArgumentException-当输入的浮点类型的数组numbers为空时。
  


9.public static byte[] toByteArray(double[] numbers, int from, int to)

将一个double类型的浮点数数组中指定位置的浮点数转化成表示其对应值的byte类型的数组。长度为指定位置的double类型数组长度*8。

参数：

  numbers-需要处理的浮点数类型数组。
  
  from -需要处理的浮点数的起始位置索引，from包含在内；
  
  to-需要处理的浮点数的结束位置索引，to不包含在内；
  
返回：

  指定位置的该double类型的浮点数数组的byte数组，从高位到低位排列。 
  
抛出：

  IllegalArgumentException-当输入的浮点类型的数组numbers为空时；from或者to越界时或者from大于等于to时。
  


10.public static byte[] toByteArray(float number)

将一个float类型的浮点数转化成4个字节表示的byte类型的数组。

参数：

  number-需要处理的浮点数类型。
  
返回：

  表示该float类型的4个字节的byte数组，从高位到低位排列，索引0表示最高位，3表示最低位。
  


11.public static byte[] toByteArray(float[] numbers)

将一个float类型的浮点数数组转化成表示其对应值的byte类型的数组。长度为float类型数组长度*4。

参数：

  numbers-需要处理的浮点数类型数组。
  
返回：

  表示该float类型的4*浮点数数组的长度 个字节的byte数组，从高位到低位排列。 
  
抛出：

  IllegalArgumentException-当输入的浮点类型的数组numbers为空时。
  


12.public static byte[] toByteArray(float[] numbers, int from, int to)

将一个float类型的浮点数数组中指定位置的浮点数转化成表示其对应值的byte类型的数组。长度为指定位置的float类型数组长度*4。

参数：

  numbers-需要处理的浮点数类型数组。
  
  from -需要处理的浮点数的起始位置索引，from包含在内；
  
  to-需要处理的浮点数的结束位置索引，to不包含在内；
  
返回：

  指定位置的该float类型的浮点数数组的byte数组，从高位到低位排列。 
  
抛出：

  IllegalArgumentException-当输入的浮点类型的数组numbers为空时；from或者to越界时或者from大于等于to时。
  


13.public static byte[] toByteArray(int number)

将一个float类型的浮点数转化成4个字节表示的byte类型的数组。

参数：

  number-需要处理的浮点数类型。
  
返回：

  表示该int类型的4个字节的byte数组，从高位到低位排列，索引0表示最高位，3表示最低位。
  


14.public static byte[] toByteArray(int[] numbers)

将一个int类型的整型数组转化成表示其对应值的byte类型的数组。长度为int类型数组长度*4。

参数：

  numbers-需要处理的整型类型数组。
  
返回：

  表示该int类型的 4*整型数数组的长度 个字节的byte数组，从高位到低位排列。 
  
抛出：

  IllegalArgumentException-当输入的整型类型的数组numbers为空时。
  


15.public static byte[] toByteArray(int[] numbers, int from, int to)

将一个int类型的整型数值数组中指定位置的整型数值转化成表示其对应值的byte类型的数组。长度为指定位置的int类型数组长度*4。

参数：

  numbers-需要处理的整型数值类型数组。
  
  from -需要处理的整型数值的起始位置索引，from包含在内；
  
  to-需要处理的整型数值的结束位置索引，to不包含在内；
  
返回：

  指定位置的该int类型的整型数值数组的byte数组，从高位到低位排列。 
  
抛出：

  IllegalArgumentException-当输入的整型类型的数组numbers为空时；from或者to越界时或者from大于等于to时。
  


16.public static float toFloat(byte[] arr)

将一个byte类型的数组转化成表示其对应值float类型的浮点数。数组长度必须为4。且byte数组为从高到低字节排序的，0位最高字节，3位最低字节。

参数：

  arr-需要处理的byte类型的数组。
  
返回：

  将该arr数组转化成的float类型的浮点数值。 
  
抛出：

  IllegalArgumentException-当输入的byte数组为空或者长度不等于4时抛出。
  


17.public static float toFloat(String number)

将一个字符串转化成一个浮点类型的数值。

参数：

  number-需要处理的字符串，表示一个浮点数。
  
返回：

  该字符串表示的浮点类型的值。 
  


18.public static float[] toFloatArray(byte[] arr)

将一个byte类型的数组转化成表示其对应值float类型的浮点数。数组长度必须为4的倍数。且byte数组为从高到低字节排序的。

参数：

  arr-需要处理的byte类型的数组。
  
返回：

  将该arr数组转化成的float类型的浮点数数组。 
  
抛出：

  IllegalArgumentException-当输入的byte数组为空或者长度不等于4的倍数时抛出。
  


19.public static float[] toFloatArray(byte[] arr, int from, int to)

将一个byte数组指定位置之间子数组转化成表示其对应值float类型的浮点数组。指定位置的数组长度必须为4的倍数。且byte数组为从高到低字节排序的。

参数：

  arr-需要处理的byte类型的数组。
  
  from -需要处理的byte数组的起始位置索引，from包含在内；
  
  to-需要处理的byte数组的结束位置索引，to不包含在内；
  
返回：

  将该arr指定位置的子数组转化成的float类型的浮点数数组。 
  
抛出：

  IllegalArgumentException-当输入的byte数组为空或者长度不等于4的倍数时抛出。
  


20.public static String toHexString(int number)

将一个整型数转换成十六进制表示的字符串。

参数：

  number-需要处理的整型数。
  
返回：

  该整型数用十六进制表示时的字符串。 
  


21.public static String toHexString(int number, int minHexStringLength)

将一个十进制的整型数转化成相应的十六制字符串，并制定该十六制字符串的最短长度，不足位数用0补齐。

参数：

  number-需要处理的整型数值。
  
  minBinaryStringLength -十六制字符串的最短长度，高位用0补齐；
  
返回：

  返回补齐之后的该整型数表示的十六制字符串。
  
抛出：

IllegalArgumentException-当参数minBinaryStringLength小于该整型数的十六制表示的最短字符串长度时。



22.public static int toInt(byte[] arr)

将一个byte类型的数组转化成表示其对应值int类型的整型数。数组长度必须小于4。且byte数组为从高到低字节排序的，0位最高字节，3位最低字节。

参数：

  arr-需要处理的byte类型的数组。
  
返回：

  将该arr数组转化成的int类型的整型数值。 
  
抛出：

  IllegalArgumentException-当输入的byte数组为空或者长度大于4时抛出。
  


23.public static int toInt (byte[] arr, int from, int to)

将一个byte数组指定位置之间子数组转化成表示其对应值int类型的整型数值。指定位置的数组长度必须小于4。且byte数组为从高到低字节排序的。

参数：

  arr-需要处理的byte类型的数组。
  
  from -需要处理的byte数组的起始位置索引，from包含在内；
  
  to-需要处理的byte数组的结束位置索引，to不包含在内；
  
返回：

  将该arr指定位置的子数组转化成的int类型的整型数值。 
  
抛出：

  IllegalArgumentException-当指定位置的byte子数组为空或者长度大于4，from或者to越界或者from大于等于to时抛出。
  


24.public static int toInt(String number)

将一个字符串转化成一个整型类型的数值。

参数：

  number-需要处理的字符串，表示一个整型数。
  
返回：

  该字符串表示的整型类型的值。 
  


25.public static int toInt(String number，int radix)

将一个指定进制的字符串转化成一个整型类型的数值。

参数：

  number-需要处理的字符串，表示一个整型数。
  
Radix-表示该输入的字符串表示的进制，大于等于2，小于等于16

返回：

  该字符串表示的十进制整型类型的值。
  


26.public static int[] toIntArray(byte[] arr, int byteNumPerInt)

将一个byte类型的数组转化成表示其对应值int类型的整型数。数组长度必须为byteNumPerInt的倍数。且byte数组为从高到低字节排序的。

参数：

  arr-需要处理的byte类型的数组。
  
byteNumPerInt-一个整型由几个byte字节表示，也就是说没几个字节表示一个整型数；

返回：

  将该arr数组转化成的int类型的整型数数组。 
  
抛出：

  IllegalArgumentException-当输入的byte数组为空或者长度不等于byteNumPerInt的倍数时抛出。
  


27.public static int[] toIntArray(byte[] arr, int byteNumPerInt, int from, int to)

将一个byte类型的数组指定位置的子数组转化成表示其对应值int类型的整型数。数组长度必须为byteNumPerInt的倍数。且byte数组为从高到低字节排序的。

参数：

  arr-需要处理的byte类型的数组。
  
  from -需要处理的byte数组的起始位置索引，from包含在内；
  
  to-需要处理的byte数组的结束位置索引，to不包含在内；
  
返回：

  将该arr指定位置的子数组转化成的int类型的整型数数组。 
  
抛出：

  IllegalArgumentException-当指定位置的byte子数组为空或者长度大于4，from或者to越界或者from大于等于to时抛出。
  


28.public static short toUnsigned(byte number)

将一个指定进制的byte类型的值转化成其无符号类型表示的数值。

参数：

  number-需要处理的byte数值。
  
返回：

  该byte表示的无符号类型数的值。类型为short。
  


29.public static long toUnsigned(int number)

将一个指定进制的int类型的值转化成其无符号类型表示的数值。

参数：

  number-需要处理的int数值。
  
返回：

  该byte表示的无符号类型数的值。类型为long。
  


30.public static int toUnsigned(short number)

将一个指定进制的short类型的值转化成其无符号类型表示的数值。

参数：

  number-需要处理的short数值。
  
返回：

  该short表示的无符号类型数的值。类型为int。
  


31.public static String transRadix(String number, int fromRadix, int toRadix)

将一个任意进制的字符串转换成指定进制的字符串，也就是任意进制字符串之间的互相转化。

参数：

  number-需要处理的任意进制表示的字符串。
  
  fromRadix-源字符串的进制
  
  toRadix-目标字符串的进制，即想要转化成几进制的字符串；
  
返回：

  将源字符串转化成目标进制之后的字符串表示。
  
```
欢迎大家Follow
--------------
先fork此项目，在分支修改后，pull request到主分支

提问请到issues里创建，欢迎contributor！

如果觉得好，给项目点颗星吧～

