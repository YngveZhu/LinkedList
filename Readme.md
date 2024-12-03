#  LinkedList数组操作（java版）

> 采用链表实现的数组结构

### 引入

```xml
<dependency>
	<groupId>top.zyqer</groupId>
    	<artifactId>LinkedNodes</artifactId>
    <version>3.3.5</version>
</dependency>
```

### 使用方法

> LinkedList<T> 变量名 = new LinkedList<>(int val);
>
> T：数组存储的元素类型
>
> val(选填)：数组存储的第一个元素

```java
LinkedList<Integer> l = new LinkedList<>(); // 打印数组为[]
// 或者
LinkedList<Integer> l = new LinkedList<>(1); // 打印数组为 [1]
```

### 操作数

| 修饰符和类型 | 方法                     | 说明                   |
| ------------ | ------------------------ | ---------------------- |
| void         | alter(int index, T val)  | 数组指定位置修改元素   |
| void         | append(int index, T val) | 向数组指定位置添加元素 |
| void         | append(T val)            | 向数组尾部添加一个元素 |
| T            | element(int index)       | 获取数组指定位置的元素 |
| boolean      | isEmpty()                | 检查数组是否为空       |
| T            | remove()                 | 数组尾部删除元素       |
| T            | remove(int index)        | 数组指定位置删除元素   |
| String       | toString()               | 打印数组元素           |
| int          | length                   | 获取数组长度           |

### alter(int index, T val)

> 概述：数组指定位置修改元素
>
> index：需要被修改元素的索引值
>
> val：修改后的元素

```java
LinkedList<Integer> list = new LinkedList<>(1);
list.alter(0, 2);
System.out.println(list); // 输出：[2]
```

### append(int index, T val)

> 概述：向数组指定位置添加元素
>
> index：需要添加元素的索引值（填入数组的总长度将会在数组最后添加该元素）
>
> val：被添加的元素

```java
LinkedList<Integer> list = new LinkedList<>();
list.append(1).append(2);
System.out.println(list); // 输出：[1,2]
```

### append(T val)

> 概述：向数组尾部添加一个元素
>
> val：被添加的元素

```java
LinkedList<Integer> list = new LinkedList<>();
list.append(1);
System.out.println(list); // 输出：[1]
```

### element(int index)

> 概述：获取数组指定位置的元素
>
> index：被查询的元素索引值

```java
LinkedList<Integer> list = new LinkedList<>();
list.append(1).append(2).append(3).append(4).append(5);
System.out.println(list.element(2)); // 输出：3
```

### isEmpty()

> 概述：检查数组是否为空
>
> 若数组为空，则返回true，否则返回false

```java
LinkedList<Integer> list = new LinkedList<>();
list.append(1).append(2).append(3).append(4).append(5);
System.out.println(list.isEmpty()); // 输出：false
```

### remove()

> 概述：数组尾部删除元素
>
> 返回被删除的元素

```java
LinkedList<Integer> list = new LinkedList<>();
list.append(1).append(2).append(3).append(4).append(5);
System.out.println(list.remove()); // 输出：5
System.out.println(list); // 输出：[1,2,3,4]
```

### remove(int index)

> 概述：数组指定位置删除元素
>
> index：被删除元素的索引值
>
> 返回被删除的元素

```java
LinkedList<Integer> list = new LinkedList<>();
list.append(1).append(2).append(3).append(4).append(5);
System.out.println(list.remove(2)); // 输出：3
System.out.println(list); // 输出：[1,2,4,5]
```

### length

> 概述：获取数组长度
>
> 返回数组长度

```java
LinkedList<Integer> list = new LinkedList<>();
list.append(1).append(2).append(3).append(4).append(5);
System.out.println(list.length); // 输出：5
```

### toString()

> 概述：打印数组元素（重写）
>
> 返回数组元素

```java
LinkedList<Integer> list = new LinkedList<>();
list.append(1).append(2).append(3).append(4).append(5);
System.out.println(list); // 输出：[1,2,3,4,5]
```

