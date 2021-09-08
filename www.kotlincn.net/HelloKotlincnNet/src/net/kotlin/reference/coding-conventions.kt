package net.kotlin.reference

/*
https://www.kotlincn.net/docs/reference/coding-conventions.html

编码规范
本页包含当前 Kotlin 语言的编码风格

应用风格指南
如需根据本风格指南配置 IntelliJ 格式化程序，请安装 Kotlin 插件 1.2.20 或更高版本，
转到 Settings | Editor | Code Style | Kotlin，点击右上角的 Set from… 链接，并从菜单中选择 Kotlin style guide。

如需验证代码已按风格指南格式化，请转到 Settings | Editor | Inspections
并启用 Kotlin | Style issues | File is not formatted according to project settings 探查项。
验证风格指南中描述的其他问题（如命名约定）的附加探查项默认已启用。

源代码组织
目录结构
在纯 Kotlin 项目中，推荐的目录结构遵循省略了公共根包的包结构。
例如，如果项目中的所有代码都位于 org.example.kotlin 包及其子包中，
那么 org.example.kotlin 包的文件应该直接放在源代码根目录下，
而 org.example.kotlin.network.socket 中的文件应该放在源代码根目录下的 network/socket 子目录中。

对于 JVM 平台：Kotlin 源文件应当与 Java 源文件位于同一源文件根目录下，
并遵循相同的目录结构（每个文件应存储在与其 package 语句对应的目录中。

源文件名称
如果 Kotlin 文件包含单个类（以及可能相关的顶层声明），那么文件名应该与该类的名称相同，并追加 .kt 扩展名。
如果文件包含多个类或只包含顶层声明， 那么选择一个描述该文件所包含内容的名称，并以此命名该文件。
使用首字母大写的驼峰风格（也称为 Pascal 风格）， 例如 ProcessDeclarations.kt。
文件的名称应该描述文件中代码的作用。因此，应避免在文件名中使用诸如“Util”之类的无意义词语。

源文件组织
鼓励多个声明（类、顶级函数或者属性）放在同一个 Kotlin 源文件中，
只要这些声明在语义上彼此紧密关联并且文件保持合理大小 （不超过几百行）。

特别是在为类定义与类的所有客户都相关的扩展函数时， 请将它们放在与类自身定义相同的地方。
而在定义仅对指定客户有意义的扩展函数时，请将它们放在紧挨该客户代码之后。
不要只是为了保存 “Foo 的所有扩展函数”而创建文件。

类布局
通常，一个类的内容按以下顺序排列：

属性声明与初始化块
次构造函数
方法声明
伴生对象
不要按字母顺序或者可见性对方法声明排序，也不要将常规方法与扩展方法分开。
而是要把相关的东西放在一起，这样从上到下阅读类的人就能够跟进所发生事情的逻辑。
选择一个顺序（高级别优先，或者相反）并坚持下去。

将嵌套类放在紧挨使用这些类的代码之后。如果打算在外部使用嵌套类，
而且类中并没有引用这些类，那么把它们放到末尾，在伴生对象之后。

接口实现布局
在实现一个接口时，实现成员的顺序应该与该接口的成员顺序相同（如果需要， 还要插入用于实现的额外的私有方法）

重载布局
在类中总是将重载放在一起。

命名规则
在 Kotlin 中，包名与类名的命名规则非常简单：

包的名称总是小写且不使用下划线（org.example.project）。 通常不鼓励使用多个词的名称，但是如果确实需要使用多个词，可以将它们连接在一起或使用驼峰风格（org.example.myProject）。

类与对象的名称以大写字母开头并使用驼峰风格：

open class DeclarationProcessor { ... }
object EmptyDeclarationProcessor : DeclarationProcessor() { ... }

函数名
函数、属性与局部变量的名称以小写字母开头、使用驼峰风格而不使用下划线：

fun processDeclarations() { …… }
var declarationCount = 1
例外：用于创建类实例的工厂函数可以与抽象返回类型具有相同的名称：

interface Foo { …… }
class FooImpl : Foo { …… }
fun Foo(): Foo { return FooImpl() }

测试方法的名称
当且仅当在测试中，可以使用反引号括起来的带空格的方法名。 （请注意，Android 运行时目前不支持这样的方法名。）测试代码中也允许方法名使用下划线。

class MyTestCase {
     @Test fun `ensure everything works`() { ... }
     @Test fun ensureEverythingWorks_onAndroid() { ... }
}
属性名
常量名称（标有 const 的属性，或者保存不可变数据的没有自定义 get 函数的顶层/对象 val 属性）
应该使用大写、下划线分隔的名称 (screaming snake case) names:
const val MAX_COUNT = 8
val USER_NAME_FIELD = "UserName"

保存带有行为的对象或者可变数据的顶层/对象属性的名称应该使用驼峰风格名称：
val mutableCollection: MutableSet<String> = HashSet()
保存单例对象引用的属性的名称可以使用与 object 声明相同的命名风格：
val PersonComparator: Comparator<Person> = ...
对于枚举常量，可以使用大写、下划线分隔的名称 (screaming snake case) （
enum class Color { RED, GREEN }）也可使用首字母大写的常规驼峰名称，具体取决于用途。

幕后属性的名称
如果一个类有两个概念上相同的属性，一个是公共 API 的一部分，另一个是实现细节，那么使用下划线作为私有属性名称的前缀：

class C {
    private val _elementList = mutableListOf<Element>()
    val elementList: List<Element>
         get() = _elementList
}

选择好名称
类的名称通常是用来解释类是什么的名词或者名词短语：List、 PersonReader。

方法的名称通常是动词或动词短语，说明该方法做什么：close、 readPersons。
修改对象或者返回一个新对象的名称也应遵循建议。
例如 sort 是对一个集合就地排序，而 sorted 是返回一个排序后的集合副本。

名称应该表明实体的目的是什么，所以最好避免在名称中使用无意义的单词 （Manager、 Wrapper 等）。
当使用首字母缩写作为名称的一部分时，如果缩写由两个字母组成，就将其大写（IOStream）；
而如果缩写更长一些，就只大写其首字母（XmlFormatter、 HttpInputStream）。

格式化
使用 4 个空格缩进。不要使用 tab。
对于花括号，将左花括号放在结构起始处的行尾，而将右花括号放在与左括结构横向对齐的单独一行。
if (elements != null) {
    for (element in elements) {
        // ……
    }
}
在 Kotlin 中，分号是可选的，因此换行很重要。语言设计采用 Java 风格的花括号格式，如果尝试使用不同的格式化风格，那么可能会遇到意外的行为。

横向空白
在二元操作符左右留空格（a + b）。例外：不要在“range to”操作符（0..i）左右留空格。
不要在一元运算符左右留空格（a++）
在控制流关键字（if、 when、 for 以及 while）与相应的左括号之间留空格。
不要在主构造函数声明、方法声明或者方法调用的左括号之前留空格。

class A(val x: Int)
fun foo(x: Int) { …… }
fun bar() {
    foo(1)
}

绝不在 (、 [ 之后或者 ]、 ) 之前留空格。
绝不在. 或者 ?. 左右留空格：foo.bar().filter { it > 2 }.joinToString(), foo?.bar()
在 // 之后留一个空格：// 这是一条注释
不要在用于指定类型参数的尖括号前后留空格：class Map<K, V> { …… }
不要在 :: 前后留空格：Foo::class、 String::length
不要在用于标记可空类型的 ? 前留空格：String?
作为一般规则，避免任何类型的水平对齐。将标识符重命名为不同长度的名称不应该影响声明或者任何用法的格式。

冒号
在以下场景中的 : 之前留一个空格：

当它用于分隔类型与超类型时；
当委托给一个超类的构造函数或者同一类的另一个构造函数时；
在 object 关键字之后。
而当分隔声明与其类型时，不要在 : 之前留空格。

在 : 之后总要留一个空格。
abstract class Foo<out T : Any> : IFoo {
    abstract fun foo(a: Int): T
}
class FooImpl : Foo() {
    constructor(x: String) : this(x) { …… }
    val x = object : IFoo { …… }
}

类头格式化
具有少数主构造函数参数的类可以写成一行：

class Person(id: Int, name: String)
具有较长类头的类应该格式化，以使每个主构造函数参数都在带有缩进的独立的行中。 另外，右括号应该位于一个新行上。如果使用了继承，那么超类的构造函数调用或者所实现接口的列表应该与右括号位于同一行：

class Person(
    id: Int,
    name: String,
    surname: String
) : Human(id, name) { …… }

对于多个接口，应该将超类构造函数调用放在首位，然后将每个接口应放在不同的行中：
class Person(
    id: Int,
    name: String,
    surname: String
) : Human(id, name),
    KotlinMaker { …… }

对于具有很长超类型列表的类，在冒号后面换行，并横向对齐所有超类型名：
class MyFavouriteVeryLongClassHolder :
    MyLongHolder<MyFavouriteVeryLongClass>(),
    SomeOtherInterface,
    AndAnotherOne {
    fun foo() { ... }
}

为了将类头与类体分隔清楚，当类头很长时，
可以在类头后放一空行 （如上例所示）或者将左花括号放在独立行上：
class MyFavouriteVeryLongClassHolder :
    MyLongHolder<MyFavouriteVeryLongClass>(),
    SomeOtherInterface,
    AndAnotherOne
{
    fun foo() { ... }
}

构造函数参数使用常规缩进（4 个空格）。
理由：这确保了在主构造函数中声明的属性与 在类体中声明的属性具有相同的缩进。

修饰符
如果一个声明有多个修饰符，请始终按照以下顺序安放：
public / protected / private / internal
expect / actual
final / open / abstract / sealed / const
external
override
lateinit
tailrec
vararg
suspend
inner
enum / annotation / fun // 在 `fun interface` 中是修饰符
companion
inline
infix
operator
data

将所有注解放在修饰符前：
@Named("Foo")
private val foo: Foo
除非你在编写库，否则请省略多余的修饰符（例如 public）。


注解格式化
注解通常放在单独的行上，在它们所依附的声明之前，并使用相同的缩进：
@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

无参数的注解可以放在同一行：
@JsonExclude @JvmField
var x: String

无参数的单个注解可以与相应的声明放在同一行：
@Test fun foo() { …… }

函数格式化
如果函数签名不适合单行，请使用以下语法：
fun longMethodName(
    argument: ArgumentType = defaultValue,
    argument2: AnotherArgumentType,
): ReturnType {
    // 函数体
}
函数参数使用常规缩进（4 个空格）。
理由：与构造函数参数一致

对于由单个表达式构成的函数体，优先使用表达式形式。
良好
fun foo(): Int {     // 不良
    return 1
}
fun foo() = 1        // 良好

表达式函数体格式化
如果函数的表达式函数体与函数声明不适合放在同一行，那么将 = 留在第一， 并将表达式函数体缩进 4 个空格。
fun f(x: String, y: String, z: String) =
    veryLongFunctionCallWithManyWords(andLongParametersToo(), x, y, z)


属性格式化
对于非常简单的只读属性，请考虑单行格式：
val isEmpty: Boolean get() = size == 0

对于更复杂的属性，总是将 get 与 set 关键字放在不同的行上：
val foo: String
    get() { ……}

对于具有初始化器的属性，如果初始化器很长，那么在等号后增加一个换行并将初始化器缩进四个空格：
private val defaultCharset: Charset? =
    EncodingRegistry.getInstance().getDefaultCharsetForPropertiesFiles(file)

格式化控制流语句
如果 if 或 when 语句的条件有多行，那么在语句体外边总是使用大括号。
将该条件的每个后续行相对于条件语句起始处缩进 4 个空格。 将该条件的右圆括号与左花括号放在单独一行：
if (!component.isSyncing &&
    !hasAnyKotlinRuntimeInScope(module)
) {
    return createKotlinNotConfiguredPanel(module)
}
理由：对齐整齐并且将条件与语句体分隔清楚

将 else、 catch、 finally 关键字以及 do/while 循环的 while 关键字与之前的花括号放在相同的行上：
if (condition) {
    // 主体
} else {
    // else 部分
}

try {
    // 主体
} finally {
    // 清理
}

在 when 语句中，如果一个分支不止一行，可以考虑用空行将其与相邻的分支块分开：
private fun parsePropertyValue(propName: String, token: Token) {
    when (token) {
        is Token.ValueToken ->
            callback.visitValue(propName, token.value)

        Token.LBRACE -> { // ……
        }
    }
}

将短分支放在与条件相同的行上，无需花括号。
when (foo) {
    true -> bar() // 良好
    false -> { baz() } // 不良
}

在较长参数列表的左括号后添加一个换行符。按 4 个空格缩进参数。 将密切相关的多个参数分在同一行。
drawSquare(
    x = 10, y = 10,
    width = 100, height = 100,
    fill = true
)
在分隔参数名与值的 = 左右留空格。

链式调用换行
当对链式调用换行时，将 . 字符或者 ?. 操作符放在下一行，并带有单倍缩进：
val anchor = owner
    ?.firstChild!!
    .siblings(forward = true)
    .dropWhile { it is PsiComment || it is PsiWhiteSpace }
调用链的第一个调用通常在换行之前，当然如果能让代码更有意义也可以忽略这点。

Lambda 表达式格式化
在 lambda 表达式中，应该在花括号左右以及分隔参数与代码体的箭头左右留空格。
如果一个调用接受单个 lambda 表达式，应该尽可能将其放在圆括号外边传入。
list.filter { it > 10 }

如果为 lambda 表达式分配一个标签，那么不要在该标签与左花括号之间留空格：
fun foo() {
    ints.forEach lit@{
        // ……
    }
}

在多行的 lambda 表达式中声明参数名时，将参数名放在第一行，后跟箭头与换行符：
appendCommaSeparated(properties) { prop ->
    val propertyValue = prop.get(obj)  // ……
}

如果参数列表太长而无法放在一行上，请将箭头放在单独一行：
foo {
   context: Context,
   environment: Env
   ->
   context.configureEnv(environment)
}




*/


