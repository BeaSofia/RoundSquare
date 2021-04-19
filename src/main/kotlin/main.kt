import pt.isel.canvas.*
import java.awt.Color

val RANGE_SIDE = 10..400
val RANGE_ROUND = 0.0..1.0
val side = 200
val round = 0.5
val f = ((side/2) * round ).toInt()




data class Position (val x: Int, val y: Int)
data class RoundSquare (val center: Position, val side: Int, val round: Double, val color:Int)

fun drawObject (rs: RoundSquare,cv: Canvas): RoundSquare{

    cv.drawRect(cv.width/2 - (side-2 *f)/2, cv.height/2 - side/2,side -2 * f,side, GREEN )
    cv.drawRect(cv.width/2 - side/2, cv.height/2 - (side/2-f),side,side -2 * f, GREEN )
    cv.drawCircle(cv.width/2 - f, cv.height/2 - f, f, GREEN )
    cv.drawCircle(cv.width/2 + f, cv.height/2 - f, f, GREEN )
    cv.drawCircle(cv.width/2 - f, cv.height/2 + f, f, GREEN )
    cv.drawCircle(cv.width/2 + f, cv.height/2 + f, f, GREEN )
    //cv.drawCircle(cv.width/2, cv.height/2, 2*f, RED)
    return RoundSquare(rs.center, rs.side, rs.round, rs.color)
}

fun resise(rs: RoundSquare, cv: Canvas, ke: Char) : RoundSquare {
    val newRs: RoundSquare
    when(ke) {

        'S' -> newRs = if (rs.side < 400) RoundSquare(rs.center, rs.side + 1, rs.round, rs.color) else rs
        's' -> newRs = if (rs.side > 10) RoundSquare(rs.center, rs.side - 1, rs.round, rs.color) else rs
        'R' -> newRs = if (rs.side < 0.0) RoundSquare(rs.center, rs.side , rs.round + 1, rs.color) else rs
        'r' -> newRs = if (rs.side > 1.0) RoundSquare(rs.center, rs.side , rs.round- 1, rs.color) else rs
        else -> newRs = rs}
    return newRs
}

fun main(){
    onStart{

        val cv = Canvas(600,400)
        var rs = RoundSquare(Position(cv.width/2, cv.height/2), side, round, GREEN)
        drawObject(rs,cv)

        cv.onTimeProgress(20) {
            drawObject(rs,cv)
        }

        cv.onKeyPressed { ke:KeyEvent ->
            cv.erase()
            rs = resise(rs, cv,ke.char)
            drawObject(rs,cv)


        }



    }
}