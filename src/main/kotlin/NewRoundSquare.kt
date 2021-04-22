import pt.isel.canvas.*

fun drawRoundSquare (rs: RoundSquare, cv: Canvas){
    val f = ((rs.side/2)*rs.round).toInt()
    cv.erase()                              //We need to erase the canvas every time we use this function for the text not overwrite
    cv.drawRect(rs.center.x - (rs.side-2*f)/2, rs.center.y - rs.side/2,rs.side -2 * f,rs.side, GREEN )
    cv.drawRect(rs.center.x - rs.side/2, rs.center.y - (rs.side/2-f),rs.side,rs.side -2 * f, GREEN )
    cv.drawCircle(rs.center.x - (rs.side/2) + f, rs.center.y - (rs.side/2) + f, f, GREEN )
    cv.drawCircle(rs.center.x + (rs.side/2) - f, rs.center.y - (rs.side/2) + f, f, GREEN )
    cv.drawCircle(rs.center.x + (rs.side/2) - f, rs.center.y + (rs.side/2) - f, f, GREEN )
    cv.drawCircle(rs.center.x - (rs.side/2) + f, rs.center.y + (rs.side/2) - f, f, GREEN )
    cv.drawText(5, 395,
        "center= ( ${rs.center.x}, ${rs.center.y} )  side= ${rs.side}  round= ${(rs.round * 100).toInt()}%  color= 0x00${rs.color.toString(16).toUpperCase()}",
        BLACK, 16)
}


fun newSize(rs: RoundSquare, ke: Char): RoundSquare {

    return when (ke) {

        'S' -> if (rs.side <= RangeSide.last) RoundSquare(rs.center, rs.side + 1, rs.round, rs.color) else rs
        's' -> if (rs.side >= RangeSide.first) RoundSquare(rs.center, rs.side - 1, rs.round, rs.color) else rs
        'R' -> if (rs.round <= RangeRound.endInclusive) RoundSquare(rs.center, rs.side, rs.round + 0.01, rs.color) else rs
        'r' -> if (rs.round >= RangeRound.start) RoundSquare(rs.center, rs.side, rs.round - 0.01, rs.color) else rs
        else -> rs
    }
}



