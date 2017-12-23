### android使用lambda表达式

关于lambda表达式使用一般如下：

> (argument) -> (doSomething)

其中argument表示参数，body表示函数体要做的事。常用的表达式如下：

```
(arg1, arg2...) -> { doSomething}
(type1 arg1, type2 arg2...) -> { doSomething}
```

具体使用如下所示：

```
(int a, int b) -> {  return a + b; }
() -> System.out.println("Hello World");
(String s) -> { System.out.println(s); }
() -> 42
a  -> a + 5
() -> { return 3.1415 };

```

Lambda 表达式的结构：

 - 一个 Lambda 表达式可以有零个或多个参数
 - 参数的类型既可以明确声明，也可以根据上下文来推断。例如：(int a)与(a)效果相同
  - 所有参数需包含在圆括号内，参数之间用逗号相隔。例如：(a, b) 或 (int a, int b) 或 (String a, int b, float c)
 - 空圆括号代表参数集为空。例如：() -> 42
 - 当只有一个参数，且其类型可推导时，圆括号（）可省略。例如：a -> return a*a
- Lambda 表达式的主体可包含零条或多条语句
 -  如果 Lambda 表达式的主体只有一条语句，花括号{}可省略。匿名函数的返回类型与该主体表达式一致
- 如果 Lambda 表达式的主体包含一条以上语句，则表达式必须包含在花括号{}中（形成代码块）。匿名函数的返回类型与代码块的返回类型一致，若没有返回则为空

lambda表达式函数接口：
```
Consumer<Integer>  c = (int x) -> { System.out.println(x) };

BiConsumer<Integer, String> b = (Integer x, String y) -> System.out.println(x + " : " + y);

Predicate<String> p = (String s) -> { s == null };
```




android常用例子如下：

1.监听事件
    1.匿名内部类只有一个参数

    ```
            button.setOnClickListener(view -> System.out.println("asd"));
    ```

    2.匿名内部类多个参数

    ```
            /*
            *普通写法
            */
            CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   System.out.println("asd")
                }
            });

            /*
            *使用lambda表达式写法
            */
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
               System.out.println("asd")
               System.out.println("asd"+isChecked)
            });
    ```

2.遍历for循环

```
        List<String> strings = new ArrayList<>();

        strings.add("asd");
        strings.add("asd");
        strings.add("asd");
        strings.add("asd");
        strings.add("asd");
        strings.add("asd");
        strings.add("asd");

        button2.setOnClickListener(n -> strings.forEach(n -> System.out.println(n)));

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);

```
