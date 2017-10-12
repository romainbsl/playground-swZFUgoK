## Introduction
 
Kotlin documentation said that if you define an `operator` function `plus`, you can use `+`, _by convention_, to call
 that function. 
 
_Conventions_ are not just for operators, you'll find them in Collections, Ranges, Destructuring Declaration and Invocation.

Let's see the details !!! 

## Operator overloading

Kotlin allows us to overload some operators on any object we have created, or that we know of (through [extensions][]). 
The concept of [operator overloading][op_overloading] provides a way to invoke functions to perform arithmetic 
operation, equality checks or comparison on whatever object we want, through symbols like `+`, `-`, `/`, `*`, `%`,
 `<`, `>`. But, obviously, those overloading should be defined when it make sense to use them.
 
For the following parts, let's assume we have the `data class`:  

```kotlin
data class Point(val x: Double, val y: Double)
```

### Arithmetic operators

To overload the `+` operator we need to implement the function `plus`, with the keyword `operator`. This function 
takes one parameter of any kind, even it make sense in most cases to use the same type.

```kotlin
// Here how to provide `+` operator on our object Point
operator fun plus(p: Point) = Point(this.x + p.x, this.y + p.x)
// return type is inferred to Point
```

To go further we can apply all the following operator overloading on the object `Point`.

|expression|function called|
|------------|----------|
| p1 `+` p2 | p1.`plus`(p2) |
| p1 `-` p2 | p1.`minus`(p2) |
| p1 `*` p2 | p1.`times`(p2) |
| p1 `/` p2 | p1.`div`(p2) |
| p1 `%` p2 | p1.`rem`(p2) |
| p1`++` | p1.`inc`() |
| p1`--` | p1.`dec`() |

Here the implementation on our previous `data class`:

```kotlin runnable
data class Point(val x: Double, val y: Double) {
  operator fun plus(p: Point) = Point(x + p.x, y + p.y)
  operator fun minus(p: Point) = Point(x - p.x, y - p.y)
  operator fun times(p: Point) = Point(x * p.x, y * p.y)
  operator fun div(p: Point) = Point(x / p.x, y / p.y)
  operator fun inc() = Point(x + 1, y + 1)
  operator fun dec() = Point(x - 1, y - 1)
}

// { autofold
val running: (String, String, String) -> String = {first, op, second -> "Running $first $op $second = "}
fun main(args: Array<String>) {
  var one = Point(2.0, 3.0)
  var two = Point(3.0, 2.0)
  println(running(one.toString(), "+", two.toString()) + (one + two))
  println(running(one.toString(), "-", two.toString()) + (one - two))
  println(running(one.toString(), "*", two.toString()) + (one * two))
  println(running(one.toString(), "/", two.toString()) + (one * two))
  println(running(one.toString(), "++", "") + (++one))
  println(running(two.toString(), "--", "") + (--two))
}
// }
```

Note that those examples are quiet simple, you may be able to implement more complex operator, depending on your own 
object's definition.

#### Let's practice a little

Assuming the following `data class`:

```kootlin
data class Fraction(val numerator: Int, val denominator: Int)
```

@[Try to implement the `+` operator for `Fraction`.]({"stubs": ["src/fractionPlus.kt", "src/Fraction.kt"], "command": "FractionTest#plus"})

::: Show the answer

```kotlin
operator fun Fraction.plus(add: Fraction): Fraction =
  if (this.denominator == add.denominator) {
    Fraction(this.numerator + add.numerator, denominator)
  } else {
    Fraction(numerator * add.denominator + add.numerator * denominator,
        denominator * add.denominator)
  }
```

:::

@[Try to implement the `*` operator for `Fraction`.]({"stubs": ["src/fractionTimes.kt", "src/Fraction.kt"], "command": "FractionTest#times"})

::: Show the answer

```kotlin
operator fun Fraction.times(num: Int) = Fraction(numerator * num, denominator)
```

:::

### Equality and inequality

As a Java developer, I always felt confused about equality, sometimes you have to use `==` / `!=` (on primitives), 
sometimes you have to use `equals()`. (reminder, the usage of `==`/ `!=` on non-primitive checks the reference of the
 object not its value).
 
Kotlin makes it more simple by reserving the symbols `==`and `!=` to check the objects' values (to check 
references you may use `===`/ `!==`).

To overload the equality (and inequality) checks, you may override the well known `equals()` function.

```kotlin
override fun equals(other: Any?): Boolean {
  if (other == null || 
      other !is Point ||
      x != other.x || y != other.y) return false
    
  return true
}
```   

> **Exception**: As you may know, in Kotlin objects can be non-null. In that case, `x == null` will always be `false`, 
and `equals` will never be called. 

> **Tips**: As you may know, in Kotlin, data class already implements `eqauls()`, as other useful functions (`getters/setters`, `hashCode()`, `copy()` and `toString()`)

#### Let's practice a little

@[Try to implement the `==` operator for the following `data class`.]({"stubs": ["src/Product.kt"], "command": "ProductTest#equals"})

::: Show the answer

```kotlin
override fun equals(other: Any?): Boolean {
  if (this === other) return true
  if (other != null && this::class.java != other::class.java) return false

  other as Product
  return name == other.name && price == other.price
}
```

:::

> NB: As a good practice, when you override `equals()` function, you should override `hashCode()` too

### Comparison

Comparison, `<`, `>`, `<=` and `>=`, are all based on one function, `compareTo()`. This function returns an `Int`, 
that define if the left-side of an expression is `greater`, `smaller` or `equals` to the right-side of that 
same expression.

| Expression | function called |
| -----------|-------------- |
| left > right | left.compareTo(right) > 0 |
| left < right | left.compareTo(right) < 0 |
| left >= right | left.compareTo(right) >= 0 |
| left <= right | left.compareTo(right) <= 0 |

Here is an examples on how we could compare `Point`s:

```kotlin runnable
data class Point(val x: Double, val y: Double) {
  operator fun compareTo(other: Point): Int = when {
    y != other.y -> (y - other.y).toInt()
    else -> (x - other.x).toInt()
  }
}

// { autofold
val compare: (Point, String, Point) -> String = {first, op, second -> "Compare $first $op $second"}
fun main(args: Array<String>) {
  val p1 = Point(1.0,1.0)
  val p2 = Point(2.0,2.0)
  val p3 = Point(1.0,2.0)

  println(compare(p1, "<", p2) + " [=${p1 > p2}]")
  println(compare(p1, "<", p2) + " [=${p1 < p2}]")
  println(compare(p1, ">", p3) + " [=${p1 > p3}]")
  println(compare(p1, "<", p3) + " [=${p1 < p3}]")
  println(compare(p2, ">", p3) + " [=${p2 > p3}]")
  println(compare(p2, "<", p3) + " [=${p2 < p3}]")
}
// }
```

You just saw how to use an operator to implement comparison between two instances of your object. But, there is 
another way to implement such mechanism, you could implement the `Comparable` interface, and overrides its 
`compareTo` method, it would have the same result.

```kotlin
data class Point(val x: Double, val y: Double) : Comparable<Point> {
  override fun compareTo(other: Point): Int = when {
    y != other.y -> (y - other.y).toInt()
    else -> (x - other.x).toInt()
  }
}
```

#### Let's practice a little

@[Try to implement the compareTo() function]({"stubs": ["src/MyDate.kt"], "command": "MyDateTest#compareTo"})

::: Show the answer

```kotlin
override fun compareTo(other: MyDate) = when {
  year != other.year -> year - other.year
  month != other.month -> month - other.month
  else -> dayOfMonth - other.dayOfMonth
}
```

:::

## Collections

Kotlin's Collections bring two type of **conventions**, the interaction with a specific data by using `getter` and 
`setter` with indexes, and the ability to check if an object belongs to a given list through the keyword `in`.

> `get` / `set`

You can implement `get`and `set` operators and then use sqaure brackets to interact with your objects.

| Expression | Function called |
| -------|-------------- |
| `a[i]`  | `a.get(i)` |
| `a[i, j]`  | `a.get(i, j)` |
| `a[i_1, ...,  i_n]`  | `a.get(i_1, ...,  i_n)` | 

> `in` / `!in` 

`in` is an operator that calls the function `contains()`, that you may implement to check if a value if part of your 
object. Obviously, `!in` will call `!contains()`. You'll be glad to know that `Collection` have already an 
implementation of the `contains`function, so you could already check if `1` is part of the `listOf(1, 2, 3)` (hint: 
this return `true` ^_^).

Here is an example implementing operators for collections

```kotlin runnable
data class OperatingSystem(val name: String, 
                           val products: MutableList<Product> = mutableListOf()) {
  operator fun get(id: Int) = products[id]
  operator fun set(id: Int, product: Product) {
    products.add(id, product)
  }

  operator fun contains(p: Product) = p in products
}

data class Product(val name: String)

val android = OperatingSystem("Android")

val googlePixel2 = Product("Google Pixel 2")
val samsungGalaxyS8 = Product("Samsung Galaxy S8")
val xiaomiMiMix2 = Product("Xiaomi Mi Mix 2")
val iPhoneX = Product("iPhone X")

//{ autofold
fun main(args: Array<String>) {
  // Use OperatingSystem.set operator
  android[0] = googlePixel2
  android[1] = samsungGalaxyS8
  android[2] = xiaomiMiMix2

  println("Here is Android list ${android.products}")
  println()

  // Use OperatingSystem.get operator
  println("Phone at index 0 in ${android.name} list is ${android[0]}")
  println()

  // Use OperatingSystem.in/!in operator
  println(contains(xiaomiMiMix2, android))
  println(contains(iPhoneX, android))
}

val contains: (Product, OperatingSystem) -> String = { p, r ->
  "Does ${p.name} is available in ${r.name}'s list ? [= ${p in r} }"
}
//}
```

## Ranges

Ranges are part of the nice features that make you love Kotlin. It's no magic, there is _(nearly)_ no complexity, but 
when you 
think about it, it just make sense. To build ranges you can use the operator `..`, translated to `rangeTo()`.

The Kotlin standard library provides some extra features around type that we know. So integrals have their own 
implementation of Ranges, like `IntRange` (as `LongRange` and `CharRange`), that allow you to write `1..10` that will 
build a collection of value from 1 to 10 included, by calling the following snippet `1.rangeTo(10)`.

```kotlin runnable
//{ autofold
fun main(args: Array<String>) {
//}
  (1..10).forEach(::print)
//{ autofold
}
//}
```

### Custom ranges

Let's get back to our `Point` class.

```kotlin
data class Point(val x: Double, val y: Double) : Comparable<Point> {
  override fun compareTo(other: Point): Int = when {
    y != other.y -> (y - other.y).toInt()
    else -> (x - other.x).toInt()
  }
}
```

Kotlin provides an extension `rangeTo()` on `Comparable<T>` interface, so we don't need to overload it for our `Point` 
class.

```kotlin runnable
//{ autofold
fun main(args: Array<String>) {
//}
val pointRange = Point(1.0, 1.0)..Point(5.0, 5.0)
val point = Point(2.5, 2.5)
println("Does $point is in $pointRange ? [= ${point in pointRange} ]")
// { autofold
}
data class Point(val x: Double, val y: Double) : Comparable<Point> {
  override fun compareTo(other: Point): Int = when {
    y != other.y -> (y - other.y).toInt()
    else -> (x - other.x).toInt()
  }
}

//}
```

### Iterating over ranges

To go further we may implement an operator to iterate over `Point` ranges, the `iterator()`:

```kotlin
operator fun ClosedRange<Point>.iterator() = object : Iterator<Point> {
  var currentPoint = start
  override fun hasNext() = currentPoint <= endInclusive
  override fun next() = currentPoint++
}
``` 

By doing that, we can now iterate over a `Point` collection:

```kotlin runnable
//{ autofold
fun main(args: Array<String>) {
//}
for (point in Point(1.0, 1.0)..Point(5.0, 5.0)) println(point)
//{ autofold
}
data class Point(val x: Double, val y: Double) : Comparable<Point> {
  override fun compareTo(other: Point): Int = when {
    y != other.y -> (y - other.y).toInt()
    else -> (x - other.x).toInt()
  }
  operator fun inc() = Point(x + 1, y + 1)
}
operator fun ClosedRange<Point>.iterator() = object : Iterator<Point> {
  var currentPoint = start
  override fun hasNext() = currentPoint <= endInclusive
  override fun next() = currentPoint++
}
//}
```

## Destructuring Declaration

Many times, you certainly had to decompose objects to play with:

```kotlin
val name = person.name
val age = person.age
val address = person.address
// and so on
``` 

With Kotlin, you are able to decompose your `data class`, `Map(s)`, and own object in a simple way.

### `data class`

`data class` get rid of a lot of boilerplate code (`getter/setter`, `equals`, `hashCode`, `toString`, `copy`...), but it 
also brings the ability to decompose our object according to the properties we have defined.
Kotlin create a `component` operator for each of those properties.

Let's take this data `class as` example

```kotlin
data class Person(val name: String, val age: Int, val address: String)
```

The compiler will automatically provide `componentN()` for `name` (component1), `age` (component2) and `address` 
(component3). Give you the power to destructure the `Person` object into variables. 

```kotlin
data class Person(val name: String, val age: Int, val address: String) {
  // behind the scene
  operator fun component1() = this.name
  operator fun component2() = this.age
  operator fun component3() =  this.address
}
```

> Usage

```kotlin runnable
data class Person(val name: String, val age: Int, val address: String)

// { autofold
fun main(args: Array<String>) {
// }
val (name, age, address) = buildPerson("Romain", "Belgium")

// { autofold
  println("name: $name")
  println("age: $age")
  println("address: $address")
}
fun buildPerson(name: String, address: String) = Person(name, 30, address)
// }
```

> tips: if you don't need some elements you can omit them by using an underscore `_`

```kotlin runnable
data class Person(val name: String, val age: Int, val address: String)

// { autofold
fun main(args: Array<String>) {
// }
val (name, _, address) = buildPerson("Romain", "Belgium")

// { autofold
  println("name: $name")
  println("address: $address")
}
fun buildPerson(name: String, address: String) = Person(name, 30, address)
// }
```

###  `Map(s)`

Map implements `iterator()`, `component1()` for key, and `component2()` for value. That help us to write nice 
more convenient iteration like:

```kotlin runnable
// { autofold
fun main(args: Array<String>) {
// }
val map = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four")
for((key, value) in map) println("Literal of $key is $value")
// { autofold
}
// }
```

## Summary

> Here is a reminder of what you can do `by convention`

  | Expression | Invoke |
  | -----------|-------------- |
  | `a + b` | `a.plus(b)` |
  | `a - b` | `a.minus(b)` |
  | `a * b` | `a.times(b)` |
  | `a / b` | `a.div(b)` |
  | `a % b` | `a.rem(b)`, `a.mod(b)` (deprecated) |
  | `a > b` | `a.compareTo(b)` |
  | `a++` | `a.inc()` |
  | `b--` | `b.dec()` |
  | `a == b` | `a.equals(b)` |
  | `a != b` | `!a.equals(b)` |
  | `a < b` | `a.compareTo(b)` |
  | `a >= b` | `a.compareTo(b)` |
  | `a <= b` | `a.compareTo(b)` |
  | `a[i]` | `a.get(i)` |
  | `a[i, j]` | `a.get(i, j)` |
  | `a[i] = b` | `a.set(i, b)` |
  | `a[i, j] = b` | `a.set(i, j, b)` |
  | `a in b` | `b.contains(a)` |
  | `a !in b` | `!b.contains(a)` |
  | `a..b` | `a.rangeTo(b)` |

Go further with the [full documentation](https://kotlinlang.org/docs/reference/) !

[extensions]: https://kotlinlang.org/docs/reference/extensions.html
[op_overloading]: https://kotlinlang.org/docs/reference/operator-overloading.html