import pt.isel.canvas.*


/** Function that draws the RoundSquare and the information about it on the canvas**/
fun drawRoundSquare (rs: RoundSquare, cv: Canvas){
    val f = ((rs.side/2)*rs.round)/100
    cv.erase() //We need to erase the canvas every time we use this function for the text not overwrite
    cv.drawRect(rs.center.x - (rs.side-2*f)/2, rs.center.y - rs.side/2,rs.side -2 * f,rs.side, rs.color )
    cv.drawRect(rs.center.x - rs.side/2, rs.center.y - (rs.side/2-f),rs.side,rs.side -2 * f, rs.color )
    cv.drawCircle(rs.center.x - (rs.side/2) + f, rs.center.y - (rs.side/2) + f, f, rs.color )
    cv.drawCircle(rs.center.x + (rs.side/2) - f, rs.center.y - (rs.side/2) + f, f, rs.color )
    cv.drawCircle(rs.center.x + (rs.side/2) - f, rs.center.y + (rs.side/2) - f, f, rs.color )
    cv.drawCircle(rs.center.x - (rs.side/2) + f, rs.center.y + (rs.side/2) - f, f, rs.color )
    cv.drawText(5, 395,
        "center= ( ${rs.center.x}, ${rs.center.y} )  side= ${rs.side}  round= ${(rs.round)}%  color= 0x00${rs.color.toString(16).toUpperCase()}",
        BLACK, 16)
}

/** Function that implements the modifications made based on the selected keys **/
fun newSize(rs: RoundSquare, ke: Char): RoundSquare {

    return when (ke) {

        'S' -> if (rs.side <= RANGE_SIDE.last) RoundSquare(rs.center, rs.side + 1, rs.round, rs.color) else rs
        's' -> if (rs.side >= RANGE_SIDE.first) RoundSquare(rs.center, rs.side - 1, rs.round, rs.color) else rs
        'R' -> if (rs.round <= RANGE_ROUND.last) RoundSquare(rs.center, rs.side, rs.round + 1, rs.color) else rs
        'r' -> if (rs.round >= RANGE_ROUND.first) RoundSquare(rs.center, rs.side, rs.round - 1, rs.color) else rs
        else -> rs
    }
}
