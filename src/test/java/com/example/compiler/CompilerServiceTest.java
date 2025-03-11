package com.example.compiler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompilerServiceTest {
  @Autowired CompilerService compilerService;

  @Test
  void define_variables() {
    compilerService
        .compile(
            """
                定义数字类型值表示年龄，赋值为10。
                """)
        .toStream()
        .forEach(System.out::print);
  }

  @Test
  void arithmetic_calculation() {
    compilerService
        .compile(
            """
                        定义数字类型值表示速度，赋值为10。
                        定义数字类型值表示时间，赋值为2。
                        定义数字类型值表示距离，赋值为速度乘以时间。
                        """)
        .toStream()
        .forEach(System.out::print);
  }

  @Test
  void branch_structure() {
    compilerService
        .compile(
            """
                                定义数字类型值表示年龄，赋值为10。
                                如果年龄大于8，那么执行打印过程，参数为符合入学条件文本，否则执行打印过程，参数为不符合入学条件文本。
                                """)
        .toStream()
        .forEach(System.out::print);
  }

  @Test
  void function_calling() {
    compilerService
        .compile(
            """
                                        定义数字类型值表示长度，赋值为2。定义数字类型值表示宽度，赋值为4。

                                        定义过程用于求正方形的面积，定义数字类型参数表示长，定义数字类型参数表示宽，结果为数字类型。
                                        定义数字类型值表示面积，赋值为长乘以宽。
                                        结束过程，结果为面积。

                                        定义数字类型值表示面积，赋值为过程的结果，执行求正方形面积的过程，参数为长度和宽度。
                                        """)
        .toStream()
        .forEach(System.out::print);
  }
}
