# Introduction

Kotlin is a brand new world, with quiet a lot of new feature. One of them is **conventions**. 
Kotlin documentation said that if you define an `operator` function `plus`, you can use `+`, _by convention_, to call
 that function. 
 
Conventions are not just for operators, you'll find them in Collections, Ranges, Destructive Declaration and invocation.

Let's see the details !!! 

## Operator overloading

Kotlin allows us to overload some operator on any object we have created, or that we know of (through extensions). 
Operator overloading provide a way to invoke functions to perform arithmetic operation, equality checks or comparison
 on as many objects as we want, through symbols like `+`, `-`, `/`, `*`, `%`, `<`, `>`, `=`. But, obviously, those 
 overloading should be defined when it make sense to use them.
 
For the following parts, let's assume we have the `data class`:  

```kotlin
data class Point(val x: Double, val y: Double)
```

### Arithmetic operators

To overload the `+` operator we need the implement the function `plus`, with the keyword `operator`.
This function takes one parameter of the same type as the object that is applied, `Point`.

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

### Equality and inequality

As a Java developer I always felt confused about equality, sometimes you have to use `==` / `!=` (on primitives), 
sometimes you have to use `equals()`. (reminder, the usage of `==`/ `!=` on non-primitive checks the reference of the
 object not it's value).
 
Kotlin makes it more simple by reserving the symbols `==`and `!=` to check the values of objects (to check 
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

> Exception: As you may know, in Kotlin objects can be non-null. In that case, `x == null` will always be `false`, 
and `equals` will never be called. 

### Comparison

Comparison, `<`, `>`, `<=` and `>=`, are all based on one function, `compareTo()`. This function returns an `Int`, 
that define if the left-side of an expression is `greater`, `smaller` or `equals` to the right-side of the expression.

| Expression | function called |
| -----------|-------------- |
| left > right | left.compareTo(right) > 0 |
| left < right | left.compareTo(right) < 0 |
| left >= right | left.compareTo(right) >= 0 |
| left <= right | left.compareTo(right) <= 0 |

Here is an examples on how we could compare dates.

```kotlin runnable
data class Date(val year: Int, val month: Int, val day: Int) {
  operator fun compareTo(d: Date) = when {
    year != d.year -> year - d.year
    month != d.month -> month - d.month
    else -> day - d.day
  }
}
//{autofold
val compare: (String, String, String) -> String = {first, op, second -> "Compare $first $op $second = "}
fun main(args: Array<String>) {
  val d1 = Date(2017, 1, 1)
  val d2 = Date(2017, 12, 31)
  val d3 = Date(2017, 1, 1)
  val d4 = Date(2017, 6, 15)

  println(compare(d1.toString(), ">", d2.toString()) + (d1 > d2))
  println(compare(d1.toString(), "<", d2.toString()) + (d1 < d2))
  println(compare(d2.toString(), ">=", d4.toString()) + (d2 >= d4))
  println(compare(d2.toString(), "<=", d4.toString()) + (d2 <= d4))
  println(compare(d4.toString(), ">", d3.toString()) + (d4 > d3))
  println(compare(d4.toString(), "<", d3.toString()) + (d4 < d3))
  println(compare(d1.toString(), "<=", d3.toString()) + (d1 >= d3))
  println(compare(d1.toString(), "<=", d3.toString()) + (d1 <= d3))
}
//}
```

## Collections
## Ranges
## Destructive Declaration
## Invoke()

## Go further 

> Here is a reminder of what you can do with conventions

  | Expression | Invoke |
  | -----------|-------------- |
  | `a + b` | `a.plus(b)` |
  | `a - b` | `a.minus(b)` |
  | `a * b` | `a.times(b)` |
  | `a / b` | `a.div(b)` |
  | `a % b` | `a.rem(b)`, `a.mod(b)` (deprecated) |
  | `a..b ` | `a.rangeTo(b)` |


``` kotlin runnable
data class Invoice(val client: String, val price: Double) {
  operator fun plus(inv: Invoice) =
    if (this.client == inv.client)
      Invoice(this.client, this.price + inv.price)
    else
      Invoice("${this.client} & ${inv.client}", this.price + inv.price)
}
// { autofold
fun main(args: Array<String>) {
  println("""Invoice("Client 1", 195.0) + Invoice("Client 1", 19.0)""")
  println(Invoice("Client 1", 195.0) + Invoice("Client 1", 19.0))
  println("""Invoice("Client 1", 149.0) + Invoice("Client 2", 49.0)""")
  println(Invoice("Client 1", 149.0) + Invoice("Client 2", 49.0))
}
// }
```

[Full documentation](https://kotlinlang.org/docs/reference/operator-overloading.html)