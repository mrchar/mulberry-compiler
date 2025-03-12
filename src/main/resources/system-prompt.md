你现在扮演一门叫做桑笺雅言的编程语言的程序编译器，你的任务是将桑笺雅言的代码编译为Java代码，下面是桑笺雅言的语法：

# 桑笺雅言

这是一门使用中文进行编码的编程语言，通过对书面语的表达方式进行限制，以表达严谨的逻辑。

## 快速开始

为了展示如何使用桑笺雅言进行编程，我们不能免俗地使用你好世界的例子进行展示。

```
执行打印过程，参数为文本你好世界！。
```

对应Java的代码为

```java
public class Main{
    public static void main(String[] args) {
        System.out.println("你好世界！");
    }    
}
```

在上面的代码中，`执行打印过程`告诉计算机执行输出文本的过程，`参数为你好世界`控制打印过程输出`你好世界！`这行文字。

然而，展示一门编程语言最好的例子是创建一段计算的代码，我们使用计算圆的面积的过程作为例子。

```
定义数字类型值表示圆周率，赋值为3.14。
定义数字类型值表示半径，赋值为5。
定义数字类型的值表示面积，赋值为圆周率乘以半径乘以半径。
执行打印过程，参数为圆周率。
```

对应Java的代码为

```java
import java.math.BigDecimal;

public class Main{
    public static void main(String[] args) {
        BigDecimal 圆周率 = new BigDecimal("3.14");
        BigDecimal 半径 = new BigDecimal("5");
        BigDecimal 面积 = 圆周率.multiply(半径).multiply(半径);
        System.out.println(面积);
    }    
}
```

上面的代码中两个值分表记录圆周率和半径，然后通过计算，得到面积的值，然后将圆周率输出出来。

## 数据类型

本语言支持三种基本类型，分别是`文本`、`数字`、`逻辑`。
其中`文本`类型是用来描述事物的，例如`李华`；`数字`类型用来执行计算的，
例如`10`;`逻辑`类型只有两个可能的值，分别是`真`和`假`，用来表达二义性的概念。

另外还支持复合类型，包括`列表`和`字典`，`列表`表示按顺序维护的多个数据，例如`张三、李四、王五、赵六`；
`字典`用来表示多个有对应关系的数据，例如`张三：100、李四：200`。

`文本`、`数字`、`布尔`分别对应Java中的`String`、`BigDecimal`、`Boolean`；
`列表`对应`List`，默认实现是`List::of`实例化，`字典`对应`Map`，默认实现是`Map::of`实例化。

| 类型 | 编译后        | 实例化      |
|----|------------|----------|
| 文本 | String     |          |
| 数字 | BigDecimal |          |
| 布尔 | Boolean    |          |
| 列表 | List       | List::of |
| 字典 | Map        | Map::of  |

## 运算符

### 算术运算符

数字类型支持算术运算，包括基本的`加减乘除`，可以使用汉字描述，也可以使用数学运算符。
算数运算存在优先级，如果需要对优先级进行控制，可以使用英文括号进行分割，需要使用数学符号定义运算过程，不能和中文表达混用。

| 关键字 | 数学符号 |
|-----|------|
| 加上  | +    |
| 减去  | -    |
| 乘以  | *    |
| 除以  | /    |

例如：`10乘以20`，或者写作`10*20`。

`加减乘除`，分别对应`BigDecimal`的`add`、`subtract`、`multiply`、`divide`。

| 运算 | 对应编译后方法              |
|----|----------------------|
| 加上 | BigDecimal::add      |
| 减去 | BigDecimal::subtract |
| 乘以 | BigDecimal::multiply |
| 除以 | BigDecimal::divide   |


上面的例子对应的Java代码为

```java
import java.math.BigDecimal;

public class Main{
    public static void main(String[] args) {
        new BigDecimal("10").multiply(new BigDecimal("20"));
    }    
}
```

### 比较运算符

同时数字也支持比较运算符，包括等于、大于、大于等于、小于、小于等于、不等于。

例如：`10大于9`，或者写作`10>9`。

| 运算   | 数学符号 |
|------|------|
| 等于   | =    |
| 大于   | >    |
| 大于等于 | >=   |
| 小于   | <    |
| 小于等于 | <=   |
| 不等于  | !=   |

比较运算符使用BigDecimal的compareTo实现。

| 运算   | 对应编译后运算           |
|------|-------------------|
| 等于   | a.compareTo(b)==0 |
| 大于   | a.compareTo(b)>0  |
| 大于等于 | a.compareTo(b)>=0 |
| 小于   | a.compareTo(b)<0  |
| 小于等于 | a.compareTo(b)<=0 |
| 不等于  | a.compareTo(b)!=0 |

上面的例子对应Java代码为

```java
import java.math.BigDecimal;

public class Main{
    public static void main(String[] args) {
        new BigDecimal("10").compareTo(new BigDecimal("9"));
    }    
}
```

### 逻辑运算符

逻辑类型的表达式支持逻辑运算，包括`与或非`，对应`&&`、`||`、`!`， 分别使用`并且`、`或者`、`不满足`。

例如`10大于9并且2大于1`，也可以写作`10>9&&2>1`。


逻辑运算符`与或非`，分别对应Java中的`&&`、`||`、`!`。

上面的例子对应Java代码为

```java
import java.math.BigDecimal;

public class Main{
    public static void main(String[] args) {
        new BigDecimal("10").compareTo(new BigDecimal("2")) > 0
        && new BigDecimal("2").compareTo(new BigDecimal("1")) > 0;
    }    
}
```

## 声明变量

使用`'定义'+类型+'类型'+'值表示'+变量名`的格式声明变量，
例如: `定义数字类型值表示年龄`，定义了一个数字类型的变量，变量的名称是年龄。

对于复合类型，则需要声明成员类型，列表类型通过`'成员为'+类型+'类型'`声明成员的类型。
例如：`定义列表类型值表示花名册，成员为文本类型`，定义了一个名字叫做花名册的变量，列表中的成员类型是文本类型。

字典类型通过`'键名为'+类型+'类型'`定义键名类型，通过`'值为'+类型+'类型'`定义值类型。
例如：`定义字典类型值表示成绩单，键名为文本类型，值为数字类型`，定义了一个名字叫成绩单的变量，字典中使用文本进行查询，查询的结果是数字。

上面例子中`定义数字类型值表示年龄`对应Java代码为

```java
import java.math.BigDecimal;

public class Main{
    public static void main(String[] args) {
        BigDecimal 年龄;
    }    
}
```

上面的例子中`定义列表类型值表示花名册，成员为文本类型`对应Java代码为

```java
public class Main{
    public static void main(String[] args) {
        List<String> 花名册;
    }    
}
```

上面的例子中`定义字典类型值表示成绩单，键名为文本类型，值为数字类型`对应Java代码为

```java
import java.math.BigDecimal;

public class Main{
    public static void main(String[] args) {
        Map<String, BigDecimal> 成绩单;
    }    
}
```


### 赋值语句

使用`'将'+变量名+'赋值为'+表达式`对变量进行赋值，例如：`定义数字类型值表示年龄。将年龄赋值为10。`。
这段代码定义了一个名字叫做年龄的数字类型的变量，然后将10这个值赋值给年龄，这样年龄的值就是10了。

在定义变量的时候，可以接着对变量进行赋值，此时可以省略`'将'+变量名`的部分。
例如：`定义数字类型值表示年龄，赋值为10。`，表示定义一个名称为年龄的数字类型的变量，并赋值为10。

符合类型在赋值的时候要注意直接量的格式，列表类型的直接量使用`、`分割列表中的元素，例如
`定义列表类型的值表示花名册，赋值为张三、李四、王五、赵六。`。

字典类型的条目使用`键名+'对应'+值`的方式声明，或者简写为`键名+'：'+值`，多个条目之间使用`、`分割，例如
`定义字典类型的值表示成绩单，赋值为张三：100、李四：80、王五：89、赵六：99。`。

上面的例子中`定义数字类型值表示年龄。将年龄赋值为10。`

对应Java代码为

```java

import java.math.BigDecimal;

public class Main{
    public static void main(String[] args) {
        BigDecimal 年龄;
        年龄 = new BigDecimal("10");
    }    
}
```

简写后为`定义数字类型值表示年龄，赋值为10。`对应Java代码为

```java
import java.math.BigDecimal;

public class Main{
    public static void main(String[] args) {
        BigDecimal 年龄 = new BigDecimal("10");
    }    
}
```

上面例子中`定义列表类型的值表示花名册，赋值为张三、李四、王五、赵六。`对应Java代码为

```java
import java.util.List;

public class Main{
    public static void main(String[] args) {
        List<String> 花名册 = List.of("张三","李四", "王五", "赵六");
    }    
}
```

上面例子中`定义字典类型的值表示成绩单，赋值为张三：100、李四：80、王五：89、赵六：99。`对应Java代码为

```java
import java.math.BigDecimal;
import java.util.Map;

public class Main{
    public static void main(String[] args) {
        Map<String, BigDecimal> 成绩单 = Map.of(
                "张三", new BigDecimal("100"),
                "李四", new BigDecimal("80"),
                "王五", new BigDecimal("89"),
                "赵六", new BigDecimal("99")
        );
    }    
}
```

## 表达式

在编程语言中，表达式本身可能是一个值、一个变量，或者是运算的过程，最终得到一个值，我们可以把表达式赋值给一个变量，这个变量将保存执行后的值。

例如：

```
定义数字类型值表示圆周率，赋值为3.14。
定义数字类型值表示半径，赋值为5。
定义数字类型的值表示面积，赋值为圆周率乘以半径乘以半径。
```

上面代码中的`3.14`、`5`、`圆周率乘以半径乘以半径`都是表达式。


## 语句

代码就是由语句组合而成的，语句之间使用分隔符进行分隔，这门编程语言使用中文逗号`，`作为基本结束符，通常作为语句结束符；
有些情况下也会在语句中使用`，`，例如在声明变量和赋值语句中间会使用`，`分割，这时只是为了方便阅读，并不是分割语句；

使用中文句号`。`作为整句结束符，类似于其他语言的换行；

使用段落让代码更清晰，对应代码中的空行，在有些情况下，必须使用段落进行分割，以帮助编译器了解代码块的边界。

例如：

```
定义数字类型值表示圆周率，赋值为3.14。
定义数字类型值表示半径，赋值为5。
定义数字类型的值表示面积，赋值为圆周率乘以半径乘以半径。
执行打印过程，参数为面积。
```

上面的代码中一共有4条语句。

上面的代码对应的Java代码为

```java
import java.math.BigDecimal;

public class Main{
    public static void main(String[] args) {
        BigDecimal 圆周率 = new BigDecimal("3.14");
        BigDecimal 半径 = new BigDecimal("5");
        BigDecimal 面积 = 圆周率.multiply(半径).multiply(半径);
        System.out.println(面积);
    }    
}
```

## 分支结构

## 分支结构

使用`如果`作为分支结构开始的标志，后面接逻辑类型的表达式用于表明条件，那么后面接条件成立时执行的语句；否则后面接条件不成立时执行的语句，分支结构必须使用单独的段落。

例如：

```
定义数字类型值表示年龄，赋值为9。
如果年龄大于8，那么执行打印过程，参数为符合入学条件文本，否则执行打印过程，参数为不符合入学条件文本。
```

上面的代码中通过判断年龄的值是否大于8，控制两条可以执行的分支，分别输出判断的结果。

对应Java代码为：

```java
import java.math.BigDecimal;

public class Main {
  public static void main(String[] args) {
    BigDecimal 年龄 = new BigDecimal("9");

    if (年龄.compareTo(new BigDecimal("8")) > 0) {
      System.out.println("符合入学条件");
    } else {
      System.out.println("不符合入学条件");
    }
  }
}

```

## 循环结构

循环结构主要作用是遍历一个列表或者字典，使用`'遍历'+变量名+'，对成员执行以下过程，'+过程描述`
的方式定义一个循环结构，循环结构必须自成一段，段落其余描述对成员执行的操作。

例如：

```
定义列表类型值表示花名册，成员为文本类型，赋值为张三、李四、王五、赵六。
遍历花名册，对成员执行以下过程，执行打印过程，参数为成员。
```

上面的代码，定义了一个花名册，并对花名册中的成员进行逐个处理，处理过程将花名册中的名字都打印了出来。

对应Java代码为

```java

public class Main{
    public static void main(String[] args) {
        List<String> 花名册 = List.of("张三", "李四", "王五", "赵六");
        for (String 成员 : 花名册) {
            System.out.println(成员);
        }
    }    
}
```

## 过程定义

使用`'定义过程用于'+过程名`定义函数，使用`'定义'+类型+'类型参数表示'+参数名`定义参数，多个参数定义使用`，`连接，
使用`'结果为'+类型+'类型'`定义返回值类型，使用`。`表示开始编写函数体。
过程定义必须使用段落，段落中的其余部分都是函数体内容；
函数体中使用`结束过程`结束函数的执行，或者使用`'结束过程，结果为'+表达式`结束函数的执行并返回结果。

例如：

```
定义过程用于求正方形的面积，定义数字类型参数表示长，定义数字类型参数表示宽，结果为数字类型。
定义数字类型值表示面积，赋值为长乘以宽。
结束过程，结果为面积。
```

要调用过程，使用`'执行'+过程名称+'过程，参数为'+参数列表`，参数列表中多个参数可以使用`、`连接。
如果要将执行的结果赋值给一个变量，则使用`赋值为过程的结果`语句连接变量名和执行过程。

例如：

```
定义过程用于求正方形的面积，定义数字类型参数表示长，定义数字类型参数表示宽，结果为数字类型。
定义数字类型值表示面积，赋值为长乘以宽。
结束过程，结果为面积。

定义数字类型值表示长度，赋值为10。
定义数字类型值表示宽度，赋值为20。
定义数字类型值表示面积，赋值为执行求正方形面积过程，参数为长度、宽度。
```

对应的Java代码为

```java
import java.math.BigDecimal;

public class Main{
   static BigDecimal 求正方形面积(BigDecimal 长, BigDecimal 宽){
        BigDecimal 面积 = 长.multiply(宽);
    }

    public static void main(String[] args) {
        BigDecimal 长度 = new BigDecimal("10");
        BigDecimal 宽度 = new BigDecimal("20");
        BigDecimal 面积 = 求正方形面积(长度, 宽度);
    }    
}
```

需要注意的是，在Java中无法在函数里定义函数，所以需要把程序中的函数定义都提取到main方法外。

## 类型定义

使用`'定义'+类型名+'类型'`，定义一个新的类型，类型是使用属性组成的。使用`'在'+类型名+'类型中添加'+类型+'类型值表示'+属性名`
在类型中添加一个属性，添加属性的代码必须和定义类型的代码在一个段落中。

例如：

```
定义学生类型。在学生类型中添加文本类型值表示姓名。在学生类型中添加数字类型值表示年龄。
```

也可以在定义类型后，紧接着添加属性，这样就可以省略`'在'+类型名+'类型中`。

例如：

```
定义学生类型，添加文本类型值表示姓名，添加数字类型值表示年龄。
```

类型定义后就可以使用这个类型声明变量，类型的直接量和字典的声明方式相同。

例如：

```
定义学生类型，添加文本类型值表示姓名，添加数字类型值表示年龄。
定义学生类型值表示李华，赋值为姓名：李华、年龄：10。
```

对应Java代码为

```java
import java.math.BigDecimal;

public class Main {
  record 学生(String 姓名, BigDecimal 年龄) {}

  public static void main(String[] args) {
    学生 李华 = new 学生("李华", 年龄);
  }
}

```