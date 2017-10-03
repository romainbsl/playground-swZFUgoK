# Introduction

Kotlin is a brand new world, with quiet a lot of new feature. One of them is **conventions**. 
Kotlin documentation said that if you define an `operator` function `plus`, you can use `+`, _by convention_, to call
 that function. 
 
Conventions are not just for operators, you'll find them in Collections, Ranges, Destructive Declaration and invocation.

Let's see the details !!! 

## Operator overloading

Operator overloading provide a way to invoke functions to perform arithmetic operation, equality checks or comparison
 on our own objects, through symbols like `+`, `-`, `/`, `*`, `%`, `<`, `>`, `=`.  

### Arithmetic operators

```kotlin
data class Expr(val value: Double)
```

> `plus`

```kotlin
// Here how to provide `+` operator on our own object
operator fun Expr.plus(expr: Expr) = Expr(this.value + expr.value)
```

> `minus`

```kotlin
// Here how to provide `-` operator on our own object
operator fun Expr.minus(expr: Expr) = Expr(this.value - expr.value)
```

> `times`

```kotlin
// Here how to provide `*` operator on our own object
operator fun Expr.times(expr: Expr) = Expr(this.value * expr.value)
```

> `div`

```kotlin
// Here how to provide `/` operator on our own object
operator fun Expr.div(expr: Expr) = Expr(this.value / expr.value)
```

> `rem`

```kotlin
// Here how to provide `%` operator on our own object
operator fun Expr.rem(expr: Expr) = Expr(this.value % expr.value)
```

Note that those examples are simple, you may be able to implement more complex operator, depending on your own 
object's definition.

@[Try Me !]({"stubs": ["src/expr.kt"], "command": "ExpreTest#operator"})


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