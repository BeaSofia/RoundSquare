import pt.isel.canvas.*

val RANGE_SIDE = 10..400
val RANGE_ROUND = 0.0..1.0
val side = 200
val round = 0.5





data class Position (val x: Int, val y: Int)
data class RoundSquare (val center: Position, val side: Int, val round: Double, val color:Int)

fun drawObject (rs: RoundSquare,cv: Canvas){
    val f = ((rs.side/2)*rs.round).toInt()
    cv.erase()
    cv.drawRect(rs.center.x - (rs.side-2*f)/2, rs.center.y - rs.side/2,rs.side -2 * f,rs.side, GREEN )
    cv.drawRect(rs.center.x - rs.side/2, rs.center.y - (rs.side/2-f),rs.side,rs.side -2 * f, GREEN )
    cv.drawCircle(rs.center.x - (rs.side/2) + f, rs.center.y - (rs.side/2) + f, f, GREEN )
    cv.drawCircle(rs.center.x + (rs.side/2) - f, rs.center.y - (rs.side/2) + f, f, GREEN )
    cv.drawCircle(rs.center.x + (rs.side/2) - f, rs.center.y + (rs.side/2) - f, f, GREEN )
    cv.drawCircle(rs.center.x - (rs.side/2) + f, rs.center.y + (rs.side/2) - f, f, GREEN )
    cv.drawText(5, 395,
        "center = ( ${rs.center.x}, ${rs.center.y} )  side = $side round = ${(round * 100).toInt()}% color = 0x${rs.color.toString(16)}",
        BLACK, 12)

}


fun newSize(rs: RoundSquare, ke: Char) : RoundSquare {

    val newRs: RoundSquare
    when(ke) {

         'S' -> newRs = if (rs.side < 400) RoundSquare(rs.center, rs.side + 1, rs.round, rs.color) else rs
         's' -> newRs = if (rs.side > 10) RoundSquare(rs.center, rs.side - 1, rs.round, rs.color) else rs
         'R' -> newRs = if (rs.round < 1.0) RoundSquare(rs.center, rs.side , rs.round + 0.01, rs.color) else rs
         'r' -> newRs = if (rs.round > 0.0) RoundSquare(rs.center, rs.side , rs.round - 0.01, rs.color) else rs
        else -> newRs = rs}
    return newRs
}


fun main() {
    onStart {

        val cv = Canvas(600, 400)
        var rs = RoundSquare(Position(cv.width / 2, cv.height / 2), side, round, GREEN)
        drawObject(rs, cv)

        cv.onKeyPressed { key: KeyEvent ->
            rs = newSize(rs, key.char)
            drawObject(rs, cv)
        }

        cv.onMouseDown{

            rs = RoundSquare( Position(it.x, it.y), rs.side, rs.round, rs.color)
            drawObject(rs, cv)
        }

    }
    onFinish {}
}

