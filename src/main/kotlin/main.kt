import pt.isel.canvas.*

/** Is the range of size and round values **/
val RangeSide = 11..399
val RangeRound = 0.0..1.0
const val side = 200            // We use a const val because it's a value of a read-only property
const val round = 0.5           // We use a const val because it's a value of a read-only property


data class Position (val x: Int, val y: Int)
data class RoundSquare (val center: Position, val side: Int, val round: Double, val color:Int)


fun main() {
    onStart {
        /** Creation of the Canvas window and the first RoundSquare **/
        val cv = Canvas(600, 400)
        var rs = RoundSquare(Position(cv.width / 2, cv.height / 2), side, round, GREEN)
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

