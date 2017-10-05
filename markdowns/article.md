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
### Comparison

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