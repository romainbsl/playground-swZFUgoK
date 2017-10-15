import org.junit.Test
import java.io.File
import java.util.*

class ProductTest {
  @Test
  fun component() {
    val isDestructured = existsInFile(File("./src/destructuring.kt"), "name", "brand", "size", "price")

    if (isDestructured)
      msgDestructuring("🌟 Congratz ! You end up this course with honor ! 🌟")
    else
      msgDestructuring("🐞 You may forget to implement something ! :-(")
  }

  // check if a string exists in a text file
  fun existsInFile(file: File, vararg str: String): Boolean {
    val scanner = Scanner(file)
    try {
      while (scanner.hasNextLine()) {
        val line = scanner.nextLine()
        val result = str.asSequence()
            .map { line.contains(it) }
            .filter { !it }.toList()

        if (result.isEmpty()) return true
      }

      return false
    } finally {
      scanner.close()
    }
  }

  private fun msgDestructuring(str: String) = msg("Destructuring Declaration", str)
}