import kotlin.random.Random

class Game {
    private val choice = arrayOf("Камень", "Ножницы", "Бумага", "Ящерица", "Спок")
    private val random = Random

    fun start() {
        println(" Камень x Ножницы x Бумага x Ящерица x Спок (OwO)")

        while (true) {
            print("\nВыбери: \n1-Камень \n2-Ножницы \n3-Бумага \n4-Ящерица " +
                    "\n5-Спок \n0-Выход\n \n(m;_ _)m -> ")

            val player = playerInput()

            if (player == 0) break

            val computer = random.nextInt(1, 6)

            println("\nИгрок: ${choice[player - 1]} | Компьютер: ${choice[computer - 1]}")

            val res = getResult(player, computer)
            println(res)
        }

        println("\nИгра завершена (x_x)(x_x)(x_x)")
        Thread.sleep(1000)
    }

    private fun playerInput(): Int {
        while (true) {
            val input = readlnOrNull()

            if (input.isNullOrBlank()) {
                print("\nПустой ввод! Введите число от 0 до 5: (o_O)!!!!!!!")
                continue
            }

            val num = input.toIntOrNull()
            if (num != null && num in 0..5) {
                return num
            }

            print("Ошибка ввода! Введите число от 0 до 5: (o_O) \n")
        }
    }

    private fun getResult(player: Int, computer: Int): String {
        if (player == computer)
            return "Ничья! (-_-)(-_-)(-_-)"

        if ((player == 1 && (computer == 2 || computer == 4)) ||
            (player == 2 && (computer == 3 || computer == 4)) ||
            (player == 3 && (computer == 1 || computer == 5)) ||
            (player == 4 && (computer == 3 || computer == 5)) ||
            (player == 5 && (computer == 1 || computer == 2)))
            return "Ты победил! ＼(*w*)／＼(*w*)／＼(*w*)／"

        return "Компьютер победил (T_T)(T_T)(T_T)"
    }
}
