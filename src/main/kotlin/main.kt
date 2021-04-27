import pt.isel.canvas.*

/** Is the range of size and round values **/
val RANGE_SIDE = 11..399
val RANGE_ROUND = 1..99
const val SIDE = 200            // We use a const val because it's a value of a read-only property
const val ROUND = 50           // We use a const val because it's a value of a read-only property


data class Position (val x: Int, val y: Int)
data class RoundSquare (val center: Position, val side: Int, val round: Int, val color:Int)
//The type of the val round is Int, so we don´t need to convert it to Int throughout the code, and just divide by 100 in the val f


fun main() {
    onStart {
        /** Creation of the Canvas window and the first RoundSquare **/
        val cv = Canvas(600, 400)
        var rs = RoundSquare(Position(cv.width / 2, cv.height / 2), SIDE, ROUND, GREEN)
        drawRoundSquare(rs, cv)

        /** Modifications based on the allowed keys **/
        cv.onKeyPressed { key: KeyEvent ->
            rs = newSize(rs, key.char)
            drawRoundSquare(rs, cv)
        }
        /** The new position given by the user's mouse click  **/
        cv.onMouseDown{

            rs = RoundSquare( Position(it.x, it.y), rs.side, rs.round, rs.color)
            drawRoundSquare(rs, cv)
        }

    }
    onFinish {}
}
